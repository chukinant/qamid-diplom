## Процедура подготовки и запуска автотестов.
Предусловие: В Android Studio в списке устройств есть эмулятор с API 29 (например, Google Pixel 3a – Android 10).

Шаги:
1. Запустить Android Studio.
2. Скачать репозиторий с автотестами запустив в терминале команду `git clone --single-branch --branch main {url репозитория} {название папки (опционально)}`.
3. Если репозиторий уже был скачен, то перейти в папку проекта и убедиться что в файлах отражены последние изменения, запустив команду `git pull`.
6. Сгенерировать .apk-файл (Build -> Generate App Bundles or APKs -> Generate APKs)
7. Запустить эмулятор из предусловия.
8. Установить на эмуляторе сгенерированный .apk файл.
7. Отключить анимацию на устройстве:
`adb shell settings put global window_animation_scale 0
adb shell settings put global transition_animation_scale 0
adb shell settings put global animator_duration_scale 0`
7. Открыть другое окно терминала, запустить команду `./gradlew clean test --stacktrace --info`
7. Для получения отчета Allure запустить `./gradlew allureReport`, далее открыть сгенерированный index.html из папки .\build\reports\allure-report\allureReport\
