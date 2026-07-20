# Полная инструкция по настройке сборки Trevo Vault

## 🎯 Быстрый старт

Если у вас проблемы с Android сборкой:

1. **Запустите Android Studio правильно:**
   ```bash
   ./launch_android_studio.sh
   ```

2. **Обновите метаданные (если нужно):**
   ```bash
   ./trevo_assets/update_metadata.sh
   ```

## 📁 Созданные файлы для решения проблем

### Для Android сборки:
- `launch_android_studio.sh` - Скрипт для запуска Android Studio с правильными переменными окружения
- `android/local.properties` - Конфигурация путей для Android проекта
- `ANDROID_BUILD_TROUBLESHOOTING.md` - Подробное руководство по решению проблем сборки

### Для обновления метаданных:
- `trevo_assets/update_metadata.sh` - Автоматический скрипт обновления метаданных
- `trevo_assets/update_metadata.md` - Подробная техническая документация
- `trevo_assets/QUICK_START.md` - Краткая инструкция

## 🔧 Решение проблемы "no such file or directory"

### Причина проблемы
Android Studio, запущенный через Finder, не видит переменные окружения терминала, включая PATH к Rust инструментам.

### Решения (выберите любое)

#### ✅ Решение 1: Использовать скрипт (Рекомендуется)
```bash
./launch_android_studio.sh
```

#### ✅ Решение 2: Alias в shell
```bash
# Добавлено в ~/.zshrc:
alias android-studio='PATH="$PATH" CARGO_HOME="$HOME/.cargo" RUSTUP_HOME="$HOME/.rustup" "/Applications/Android Studio.app/Contents/MacOS/studio" &'

# Использование:
android-studio
```

#### ✅ Решение 3: Запуск из терминала
```bash
cd /Applications
PATH="$PATH" CARGO_HOME="$HOME/.cargo" RUSTUP_HOME="$HOME/.rustup" "./Android Studio.app/Contents/MacOS/studio" &
```

## 🚀 Проверка настройки

### 1. Проверьте инструменты
```bash
which cargo          # /Users/dmitry/.cargo/bin/cargo
which uniffi-bindgen # /Users/dmitry/.cargo/bin/uniffi-bindgen
which python3        # /opt/homebrew/bin/python3
```

### 2. Проверьте Gradle
```bash
./gradlew tasks | head -5
```

### 3. Попробуйте сборку
```bash
./gradlew assembleDebug
```

## 📋 Конфигурационные файлы

### android/local.properties
```properties
sdk.dir=/Users/YOUR_USERNAME/Library/Android/sdk
ndk.dir=/Users/YOUR_USERNAME/Library/Android/sdk/ndk/28.2.13676358
rust.pythonCommand=python3
rust.cargoCommand=/Users/dmitry/.cargo/bin/cargo
rust.uniffiBindgenCommand=/Users/dmitry/.cargo/bin/uniffi-bindgen
```

### ~/.zshrc (добавлен alias)
```bash
alias android-studio='PATH="$PATH" CARGO_HOME="$HOME/.cargo" RUSTUP_HOME="$HOME/.rustup" "/Applications/Android Studio.app/Contents/MacOS/studio" &'
```

## 🔄 Обновление метаданных

Для обновления метаданных сети до новой версии:

```bash
# Автоматическое обновление
./trevo_assets/update_metadata.sh

# Ручная генерация QR кода
cd trevo_assets
./generate_qr.sh
```

## 📚 Дополнительная документация

- `ANDROID_BUILD_TROUBLESHOOTING.md` - Детальное решение проблем Android сборки
- `trevo_assets/update_metadata.md` - Техническая документация по метаданным
- `trevo_assets/QUICK_START.md` - Быстрые инструкции по обновлению метаданных
- `README.md` - Обновлен с новыми инструкциями по решению проблем

## 🎉 Результат

После применения этих решений:
- ✅ Android Studio запускается с правильными переменными окружения
- ✅ Rust инструменты доступны для сборки
- ✅ Метаданные можно обновлять автоматически
- ✅ Проект собирается без ошибок "no such file or directory" 