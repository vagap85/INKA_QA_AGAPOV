# INKA_QA_AGAPOV

# User Management UI Tests

Автотесты для формы управления пользователями.

## Требования

- Java 11 или выше
- Maven 3.6 или выше
- Chrome/Firefox браузер

## Переменные окружения

- "BASE_URL" - URL тестового окружения (по умолчанию: https://mes.inka.team)
- "BROWSER" - браузер для тестов (chrome/firefox, по умолчанию: chrome)
- "REMOTE" - URL remote WebDriver (для Selenium Grid)
- "USERNAME" - логин пользователя (по умолчанию: admin)
- "PASSWORD" - пароль пользователя (по умолчанию: admin)

## Структура проекта
- src/test/java/com/company/tests/ - тестовые классы
- src/test/java/com/company/pages/ - Page Objects
- src/test/resources/config/- конфигурационные файлы
- test-results/ - результаты тестов и скриншоты

## Запуск тестов

### Локальный запуск
bash <br>
mvn clean test

### Запуск с параметрами
bash <br>
mvn clean test -Dbrowser=firefox -DbaseUrl=https://mes.inka.team

### Запуск определенных тестов
bash <br>
mvn clean test -Dtest=UserCreationTest

### Генерация отчётов
bash <br>
mvn surefire-report:report

### Запуск в Docker
bash <br>
docker-compose up --build


