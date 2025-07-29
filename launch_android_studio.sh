#!/bin/bash

# Скрипт для запуска Android Studio с правильными переменными окружения
# Решает проблему "no such file or directory" при вызове cargo/rustc/uniffi-bindgen

echo "🚀 Запускаем Android Studio с правильными переменными окружения..."

# Проверяем, что необходимые инструменты доступны
if ! command -v cargo &> /dev/null; then
    echo "❌ Ошибка: cargo не найден в PATH"
    echo "Убедитесь, что Rust установлен и ~/.cargo/bin добавлен в PATH"
    exit 1
fi

if ! command -v uniffi-bindgen &> /dev/null; then
    echo "❌ Ошибка: uniffi-bindgen не найден"
    echo "Установите его командой: cargo install uniffi_bindgen --version 0.22.0"
    exit 1
fi

echo "✅ cargo найден: $(which cargo)"
echo "✅ uniffi-bindgen найден: $(which uniffi-bindgen)"

# Показываем текущий PATH
echo "📁 Текущий PATH содержит:"
echo "$PATH" | tr ':' '\n' | grep -E "(cargo|rust)" | head -5

# Экспортируем переменные окружения для Android Studio
export PATH="$PATH"
export CARGO_HOME="$HOME/.cargo"
export RUSTUP_HOME="$HOME/.rustup"

# Запускаем Android Studio с текущими переменными окружения
echo "🔧 Запускаем Android Studio..."
"/Applications/Android Studio.app/Contents/MacOS/studio" "$@" &

echo "✅ Android Studio запущен!"
echo "💡 Теперь Android Studio должен видеть cargo и uniffi-bindgen" 