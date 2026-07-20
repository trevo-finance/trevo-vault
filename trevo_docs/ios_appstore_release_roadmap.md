# 🚀 Дорожная карта релиза Trevo Vault в App Store

Этот документ описывает полный процесс подготовки и публикации iOS-приложения Trevo Vault.

Последнее обновление: 2026-02-16

---

## Фаза 0: Подготовительная ревизия проекта

### 0.1. ⚠️ Обновить App Icons
*Согласно `docs/ios_trevo_mapping.md`, иконки Trevo ещё не добавлены.*

- Подготовить иконки Trevo Vault во **всех требуемых размерах** (от 20×20 до 1024×1024).
- Заменить старые иконки в `ios/PolkadotVault/Resources/Assets.xcassets/AppIcon.appiconset/`.
- Проверить, что Launch Screen также содержит правильный логотип.

### 0.2. ✅ Сверить Bundle Identifier — ВЫПОЛНЕНО
- Bundle ID: `finance.trevo.vault` — зарегистрирован (App ID: `Y6TFBP5MRW`).

### 0.3. ✅ Fastlane Trevo — ВЫПОЛНЕНО
Создан отдельный `ios/fastlane-trevo/` (не затрагивает оригинальный `ios/fastlane/`).
Запуск: `./run_trevo_fastlane.sh <lane>`.

Credentials:
- username: `dmitry.zakharov@trevo.finance`
- team_name: `TRAIT TECH PTE LTD`
- cert: `4F7242RY23` (Dmitrii Zakharov, development)

### 0.4. Версия и номер сборки
- Установить `MARKETING_VERSION` (например, `1.0.0`) и `CURRENT_PROJECT_VERSION` (например, `1`) в Xcode (Target -> General).

---

## Фаза 1: ✅ Apple Developer Portal — ВЫПОЛНЕНО

### 1.1. ✅ Регистрация — активная подписка Apple Developer Program

### 1.2. ✅ App ID и сертификаты — ВЫПОЛНЕНО
- App ID `finance.trevo.vault` зарегистрирован через `./run_trevo_fastlane.sh register_app`
- Development сертификат `4F7242RY23` установлен через `./run_trevo_fastlane.sh certificates`
- Provisioning profile `TrevoVault_Debug` создан через `./run_trevo_fastlane.sh provisioning_profiles`

---

## Фаза 2: ✅ Сборка и запуск — ВЫПОЛНЕНО

### 2.1. ✅ Simulator — работает
- Scheme: `PolkadotVault-Dev`, сборка без ошибок

### 2.2. ✅ Physical device — работает (2026-02-16)
- Запуск через Xcode, automatic signing, Team: TRAIT TECH PTE LTD

---

## Фаза 3: ✅ App Store Connect — частично ВЫПОЛНЕНО

### 3.1. ✅ Запись приложения создана
- App ID в ASC: `6759246669`
- Name: **Trevo Vault**
- Bundle ID: `finance.trevo.vault`
- SKU: `trevo-vault-ios`

### 3.2. Метаданные и скриншоты — TODO
- [ ] Описание, ключевые слова, URL поддержки
- [ ] **Privacy Policy URL** (обязательно)
- [ ] **Скриншоты** для 6.7" (iPhone 15 Pro Max) и 6.5" (iPhone 11 Pro Max)
- [ ] **App Icon** (1024×1024, PNG, без прозрачности) — ⚠️ иконки ещё не обновлены

---

## Фаза 4: Сборка и загрузка в TestFlight — TODO

Нужно добавить:
- [ ] Distribution (AppStore) сертификат
- [ ] AppStore provisioning profile
- [ ] `testflight` lane в fastlane-trevo (с apple_id: `6759246669`)

```bash
# Когда будет готово:
./run_trevo_fastlane.sh distribute_testflight
```

---

## Фаза 5: Тестирование через TestFlight — TODO

- Добавить внутренних тестеров (доступно сразу).
- (Опционально) Добавить внешних тестеров (требует Beta App Review).

---

## Фаза 6: App Review — TODO

1. **App Privacy:** Заполнить анкету по сбору данных (вероятно, "Data Not Collected").
2. **Age Rating:** Пройти анкету (обычно 4+ или 12+).
3. **Review Notes:** Подробно объяснить reviewer-у, как работает air-gapped приложение.
4. **Submit for Review:** Ожидать 24-48 часов.

---

## Фаза 7: Публикация — TODO

- После статуса "Pending Developer Release" или "Ready for Sale", приложение станет доступно в App Store.

---

## 📋 Сводный чеклист

```
[x] Bundle ID зарегистрирован в Developer Portal
[x] Fastlane настроен (ios/fastlane-trevo/)
[x] Development сертификат установлен
[x] Development provisioning profile создан
[x] Запись приложения создана в App Store Connect (ID: 6759246669)
[x] Приложение собирается и запускается на симуляторе
[x] Приложение собирается и запускается на физическом устройстве
[x] App Icons добавлены в проект
[x] Distribution сертификат + AppStore profile (созданы 2026-02-16)
[x] Билд 1.0.0 (1) создан (готов к ручной загрузке)
[ ] Скриншоты и метаданные подготовлены
[ ] Privacy Policy URL доступен
[ ] Билд загружен в TestFlight (ручная загрузка)
[ ] Приложение отправлено на App Review

## ⚠️ Важные нюансы заполнения App Store

### 1. Export Compliance (Шифрование)
В `Info.plist` установлен ключ:
```xml
<key>ITSAppUsesNonExemptEncryption</key>
<false/>
```
Это означает, что мы декларируем использование шифрования только в рамках исключений (Exemptions).
- Для крипто-кошельков: подпись транзакций (Digital Signature) и хранение ключей (Storage Encryption) обычно **не требуют** классификации как экспортное шифрование.
- При загрузке билда вопрос про шифрование должен быть пропущен автоматически.

### 2. App Privacy (Конфиденциальность)
В разделе **App Privacy** в App Store Connect:
- Укажите **"Data Not Collected"** (Данные не собираются).
- Так как приложение Air-gapped и не имеет доступа к сети, оно физически не может отправлять данные аналитики или трекинга.

### 3. Review Notes (Заметки для ревьювера)
Критически важно для одобрения! Напишите примерно следующее:
> "This is a fully air-gapped cold wallet application for the Trevo ecosystem. It is designed to run on an offline device without internet connection. It communicates with hot wallets solely via QR codes.
> To test the app:
> 1. Launch the app.
> 2. Create a new wallet (no internet required).
> 3. Use the generated QR codes to sign transactions from a watch-only wallet (if available) or simply explore the key generation features.
> No login or account is required."
```

---

## 🔧 Скрипты и инструменты

```bash
cd /Users/dmitry/dev/trevo-vault/ios

# Зарегистрировать App ID (одноразово, уже выполнено)
./run_trevo_fastlane.sh register_app

# Сертификаты (одноразово, уже выполнено)
./run_trevo_fastlane.sh certificates

# Provisioning profiles (одноразово, уже выполнено)
./run_trevo_fastlane.sh provisioning_profiles

# Сборка для симулятора
./run_trevo_fastlane.sh build_simulator device:'iPhone 15 Pro'

# Все шаги сразу (одноразово)
./run_trevo_fastlane.sh setup
```
