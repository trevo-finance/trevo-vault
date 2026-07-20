# Android Build Troubleshooting для Trevo Vault

## Проблема: "no such file or directory" error при вызове cargo/rustc/uniffi-bindgen

### 🎯 Быстрое решение

```bash
# Запустите Android Studio через предоставленный скрипт:
./launch_android_studio.sh
```

### 🔍 Диагностика проблемы

Проблема возникает когда Android Studio не может найти Rust инструменты в PATH. Это часто происходит при запуске Android Studio через Finder вместо терминала.

**Проверьте, что инструменты установлены:**
```bash
which cargo          # Должно показать: /Users/YOUR_USERNAME/.cargo/bin/cargo
which uniffi-bindgen # Должно показать: /Users/YOUR_USERNAME/.cargo/bin/uniffi-bindgen
echo $PATH | grep cargo  # Должно показать путь к .cargo/bin
```

### 💡 Решения (в порядке предпочтения)

#### Решение 1: Скрипт запуска (Рекомендуется)
```bash
# Используйте предоставленный скрипт из корня проекта:
./launch_android_studio.sh
```

#### Решение 2: Запуск из терминала
```bash
cd /Applications
PATH="$PATH" CARGO_HOME="$HOME/.cargo" RUSTUP_HOME="$HOME/.rustup" \
  "./Android Studio.app/Contents/MacOS/studio" &
```

#### Решение 3: Создание alias
```bash
# Добавьте в ~/.zshrc (для zsh) или ~/.bash_profile (для bash):
alias android-studio='PATH="$PATH" CARGO_HOME="$HOME/.cargo" RUSTUP_HOME="$HOME/.rustup" "/Applications/Android Studio.app/Contents/MacOS/studio" &'

# Перезагрузите shell:
source ~/.zshrc  # или source ~/.bash_profile

# Теперь можно запускать:
android-studio
```

#### Решение 4: Настройка local.properties
Создайте/обновите файл `android/local.properties`:
```properties
sdk.dir=/Users/YOUR_USERNAME/Library/Android/sdk
ndk.dir=/Users/YOUR_USERNAME/Library/Android/sdk/ndk/28.2.13676358
rust.pythonCommand=python3
rust.cargoCommand=/Users/YOUR_USERNAME/.cargo/bin/cargo
rust.uniffiBindgenCommand=/Users/YOUR_USERNAME/.cargo/bin/uniffi-bindgen
```

### 🔧 Дополнительные проблемы

#### NDK не найден
```bash
# Проверьте установку NDK:
ls ~/Library/Android/sdk/ndk/

# Если пусто, установите через Android Studio:
# SDK Manager -> SDK Tools -> NDK (Side by side) -> версия 28.2.13676358
```

#### Python не найден
```bash
# Проверьте python3:
which python3

# Если не найден, установите через Homebrew:
brew install python3
```

#### Rust targets отсутствуют
```bash
# Установите необходимые targets для Android:
rustup target add aarch64-linux-android armv7-linux-androideabi x86_64-linux-android
```

### 🚀 Проверка успешной настройки

После применения решения:

1. **Откройте Android Studio через скрипт или alias**
2. **Откройте проект из корневой папки**
3. **Дождитесь индексации**
4. **Попробуйте собрать проект (Ctrl+R или Build -> Make Project)**

Если всё настроено правильно, вы увидите в логах сборки:
```
> Task :app:cargoBuild
Building Rust library...
```

### 📞 Если ничего не помогает

1. **Перезапустите Android Studio полностью**
2. **Очистите кэш: File -> Invalidate Caches and Restart**
3. **Проверьте версии:**
   ```bash
   rustc --version    # Должно быть >= 1.70
   cargo --version
   uniffi-bindgen --version  # Должно быть 0.22.0
   ```
4. **Пересоздайте local.properties с актуальными путями**

### 🎯 Финальная проверка

```bash
# Из корня проекта выполните:
./gradlew assembleDebug

# Если команда выполняется без ошибок - всё настроено правильно!
```

**Примечание:** gradlew находится в корневой папке проекта, не в папке android. 