# Быстрое обновление метаданных Trevo Vault

## TL;DR - Самый простой способ

```bash
# 1. Перейдите в корень проекта
cd /path/to/trevo-vault

# 2. Запустите автоматический скрипт
./trevo_assets/update_metadata.sh
```

Скрипт сделает всё автоматически:
- ✅ Загрузит новые метаданные с RPC
- ✅ Создаст backup старых метаданных  
- ✅ Обновит файлы в базе данных
- ✅ Сгенерирует новый QR код
- ✅ Покажет подробный отчет

## Если что-то пошло не так

### 1. Восстановление из backup
```bash
# Найдите папку backup (будет показана в выводе скрипта)
ls backup_metadata_*

# Восстановите файлы
cp backup_metadata_YYYYMMDD_HHMMSS/* rust/defaults/release_metadata/
```

### 2. Ручное обновление
Если автоматический скрипт не работает, используйте подробную инструкцию в `update_metadata.md`

### 3. Проверка результата
```bash
# Проверьте, что метаданные загружены
ls -la rust/defaults/release_metadata/

# Проверьте, что база данных создается без ошибок
cd rust/generate_message
cargo run make-cold-release
```

## Что изменилось в проекте

После успешного обновления в проекте изменятся:
- `rust/defaults/release_metadata/trevo-asset-hub[VERSION]` - новый файл метаданных
- `rust/defaults/src/lib.rs` - функция `release_metadata()` (если была неактивна)
- `trevo_assets/generate_qr.sh` - версия runtime для QR генератора
- `trevo_assets/load_metadata_trevo-asset-hubV[VERSION].png` - новый QR код

## Следующие шаги

1. **Тестирование**: Соберите и протестируйте приложение
2. **Коммит**: Добавьте изменения в git
3. **Документирование**: Обновите changelog с новой версией метаданных 