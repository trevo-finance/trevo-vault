# 🛠️ Сборка и запуск Trevo Vault на iOS Simulator

Последнее обновление: 2026-02-13
Репозиторий: `/Users/dmitry/dev/trevo-vault`
Ветка: `trevo`

## Цель

Запустить приложение Trevo Vault в iOS Simulator, чтобы убедиться, что оно собирается и работает.

---

## 1. Текущее состояние окружения

Проверено автоматически на момент создания документа:

| Компонент | Статус | Значение |
|-----------|--------|----------|
| Xcode | ✅ Установлен | 26.2 (Build 17C52) |
| Rust toolchain | ✅ Установлен | stable-aarch64-apple-darwin |
| `uniffi-bindgen` | ✅ Установлен | 0.22.0 (требуемая версия) |
| `aarch64-apple-ios-sim` target | ✅ Установлен | — |
| `x86_64-apple-ios` target | ✅ Установлен | — |
| opencv (Homebrew) | ✅ Установлен | — |
| `libsigner.a` (prebuilt) | ✅ Есть | 106MB, fat binary (x86_64 + arm64) |
| База данных (cold release) | ✅ Есть | `ios/PolkadotVault/Database/Database/` |
| Сгенерированные FFI-биндинги | ✅ Есть | `ios/PolkadotVault/Generated/signer.swift` (283KB) |
| Доступные симуляторы | ✅ Есть | iPhone 15 Pro, iPhone 15, iPhone SE и др. |

### Вывод

Все предварительные зависимости уже установлены. Rust-библиотека (`libsigner.a`) **уже собрана** и закоммичена в репозиторий. FFI-биндинги (`signer.swift`, `signerFFI.h`) тоже есть. Пересобирать Rust НЕ нужно, если только не менялся код в `rust/`.

---

## 2. Архитектура сборки

```
rust/signer/  ──(cargo build)──►  libsigner.a  (статическая библиотека)
                                        │
                                        ▼
                      ios/PolkadotVault/libsigner.a
                      ios/PolkadotVault/Generated/signer.swift      (Swift биндинги)
                      ios/PolkadotVault/Generated/signerFFI.h       (C header)
                      ios/PolkadotVault/Generated/signerFFI.modulemap
                                        │
                                        ▼
                      Xcode (PolkadotVault.xcodeproj)
                      ├── Scheme: PolkadotVault-Dev  ← для симулятора (рекомендуется)
                      ├── Scheme: PolkadotVault      ← production
                      └── Scheme: PolkadotVault-QA   ← QA / TestFlight
```

**Важно:** Для симулятора используем **`PolkadotVault-Dev`** — этот scheme не требует air-gap (не нужно выключать WiFi).

---

## 3. Быстрый старт (через Xcode)

Самый простой способ — напрямую через Xcode:

```bash
# 1. Открыть проект в Xcode
open /Users/dmitry/dev/trevo-vault/ios/PolkadotVault.xcodeproj
```

Затем в Xcode:
1. Выбрать scheme: **`PolkadotVault-Dev`** (верхняя панель, рядом с кнопкой Run)
2. Выбрать симулятор: **iPhone 15 Pro**
3. Нажать **▶ Run** (Cmd+R)

### Что ожидать при первом запуске:
- Xcode может скачать Swift packages (SPM зависимости) — несколько минут
- Сборка Rust НЕ запускается автоматически (библиотека уже есть)
- Компиляция Swift кода ~2-5 минут при первой сборке

---

## 4. Альтернатива: сборка из командной строки

```bash
cd /Users/dmitry/dev/trevo-vault/ios

# Сборка для симулятора
xcodebuild \
  -project PolkadotVault.xcodeproj \
  -scheme PolkadotVault-Dev \
  -configuration Debug \
  -destination 'platform=iOS Simulator,name=iPhone 15 Pro' \
  -skipPackagePluginValidation \
  -skipMacroValidation \
  build

# Или через fastlane-trevo (если установлены ruby gems)
bundle exec fastlane --fastlane_path fastlane-trevo build_simulator device:'iPhone 15 Pro'
```

---

## 5. Если нужно пересобрать Rust-библиотеку

Пересборка нужна **только** если менялся код в `rust/`. Сейчас `libsigner.a` уже есть и актуален.

```bash
cd /Users/dmitry/dev/trevo-vault/ios

# Сборка для симулятора (aarch64-apple-ios-sim + x86_64-apple-ios)
./scripts/build_libsigner.sh simulator

# Результат: ios/PolkadotVault/libsigner.a (fat binary)
```

**Время сборки:** ~10-20 минут (полная пересборка Rust workspace).

---

## 6. Если нужно пересоздать базу данных

```bash
cd /Users/dmitry/dev/trevo-vault/ios

# Генерация cold release database
./scripts/generate_database.sh

# Результат: ios/PolkadotVault/Database/Database/
```

---

## 7. Возможные проблемы и решения

### 7.1. `No such module 'signerFFI'`
**Причина:** Xcode не находит C header для FFI.
**Решение:** Проверить, что `ios/PolkadotVault/Generated/signerFFI.h` и `signerFFI.modulemap` существуют. Если нет — пересобрать Rust и regenerate bindings:
```bash
uniffi-bindgen generate rust/signer/src/signer.udl --language swift --out-dir ios/PolkadotVault/Generated/
```

### 7.2. `ld: library 'signer' not found`
**Причина:** `libsigner.a` отсутствует или собран для неправильной архитектуры.
**Проверка:**
```bash
lipo -info ios/PolkadotVault/libsigner.a
# Должно быть: x86_64 arm64
```
**Решение:** `./scripts/build_libsigner.sh simulator`

### 7.3. SPM packages не загружаются
**Решение:** В Xcode: File → Packages → Reset Package Caches, затем File → Packages → Resolve Package Versions.

### 7.4. `Signing for "PolkadotVault" requires a development team`
**Причина:** Xcode требует подпись даже для симулятора.
**Решение:** В Xcode: Target → Signing & Capabilities → Team → выбрать свою команду или поставить "None" для симулятора.
Альтернатива из CLI — добавить `CODE_SIGNING_ALLOWED=NO`:
```bash
xcodebuild ... -xcargs "CODE_SIGNING_ALLOWED=NO"
```

### 7.5. App требует отключить WiFi (Airplane Mode)
**Причина:** Используется scheme `PolkadotVault` (production), который проверяет air-gap.
**Решение:** Переключиться на **`PolkadotVault-Dev`** — в нём air-gap проверка отключена в debug-сборках.

---

## 8. Ограничения симулятора

| Функция | На симуляторе | На устройстве |
|---------|---------------|---------------|
| Запуск приложения | ✅ | ✅ |
| UI / Навигация | ✅ | ✅ |
| Камера (QR-сканер) | ❌ Не работает | ✅ |
| Air-gap mode | ⚠️ Эмулируется через Dev scheme | ✅ Реальный |
| Keychain (seed storage) | ⚠️ Ограниченно | ✅ |

---

## 9. Структура файлов, относящихся к сборке

```
ios/
├── PolkadotVault.xcodeproj/           ← Xcode проект
│   └── xcshareddata/xcschemes/
│       ├── PolkadotVault.xcscheme     ← Production
│       ├── PolkadotVault-Dev.xcscheme ← Development (для симулятора!)
│       └── PolkadotVault-QA.xcscheme  ← QA / TestFlight
├── PolkadotVault/
│   ├── Configuration/
│   │   ├── Debug.xcconfig             ← PRODUCT_NAME = Trevo Vault Dev
│   │   ├── Production.xcconfig        ← PRODUCT_NAME = Trevo Vault
│   │   └── QA.xcconfig                ← PRODUCT_NAME = Trevo Vault QA
│   ├── Generated/
│   │   ├── signer.swift               ← FFI биндинги (автогенерация)
│   │   ├── signerFFI.h                ← C header
│   │   └── signerFFI.modulemap        ← Module map
│   ├── Database/Database/             ← Cold release DB
│   ├── libsigner.a                    ← Rust static library (106MB)
│   └── ...                            ← Swift source code
├── Packages/                          ← Локальные SPM пакеты
│   ├── Blockies/
│   ├── Jdenticon/
│   └── PolkadotIdenticon/
├── scripts/
│   ├── build_libsigner.sh             ← Сборка Rust → libsigner.a
│   └── generate_database.sh           ← Генерация cold DB
├── swiftgen/                          ← SwiftGen для кодогенерации
├── fastlane/                          ← Оригинальный fastlane (Novasama)
└── fastlane-trevo/                    ← Наш fastlane конфиг
    ├── Appfile
    └── Fastfile
```

---

## 10. Следующие шаги после успешной сборки

1. ✅ Убедиться, что приложение запускается на симуляторе
2. ✅ Проверить основную навигацию и UI
3. Проверить создание ключей / seed phrase
4. Проверить, что Trevo network отображается
5. (Опционально) Собрать для физического устройства для тестирования камеры
