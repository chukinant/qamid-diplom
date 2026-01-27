## Процедура подготовки и запуска автотестов.
Предусловие: В Android Studio в списке устройств есть эмулятор с API 29 (например, Google Pixel 3a – Android 10).

Шаги:
1. Запустить Android Studio.
2. Скачать репозиторий с автотестами запустив в терминале команду `git clone --branch main git@github.com:chukinant/qamid-diplom.git` (в  общем случае: `git clone --single-branch --branch main {url репозитория} {название папки (опционально)}`).
3. Если репозиторий уже был скачен ранее, то перейти в папку проекта и убедиться что в файлах отражены последние изменения, запустив команду `git pull`.
4. Запустить эмулятор из предусловия.
5. Отключить анимацию на устройстве:
`adb shell settings put global window_animation_scale 0`
`adb shell settings put global transition_animation_scale 0`
`adb shell settings put global animator_duration_scale 0`
6. Для запуска всех тестов в терминале запустить кастомную команду `./gradlew runTestsNoUninstall`. 
 Для запуска всех тестов из конкретного класса нужно запускать с флагом, например `./gradlew app:runTestsNoUninstall "-Pandroid.testInstrumentationRunnerArguments.class=ru.iteco.fmhandroid.ui.tests.LoginActivityTests"`
7. Для получения отчета Allure запустить Device Explorer, в дереве найти папку /data/data/ru.iteco.fmhandroid/files/allure-results, затем правой кнопкой мыши нажать на папку files, выбрать "Save As", далее сохранить в ./app/build/
После этого перейти в ./app/build и выполнить `allure serve` для генерации отчета и его просмотра.