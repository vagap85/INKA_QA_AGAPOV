# INKA_QA_AGAPOV
  
  # Автотесты и план тестирования для формы управления пользователями

# Содержание проекта
- Структура проекта
- Автотесты для формы управления пользователями
- План автоматизации

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

## 1. Структура проекта
- src/test/java/com/company/tests/ - тестовые классы
- src/test/java/com/company/pages/ - Page Objects
- src/test/resources/config/- конфигурационные файлы
- test-results/ - результаты тестов и скриншоты

user-management-ui-tests/
├── src/
│   ├── main/
│   │   └── java/
│   │       └── com/
│   │           └── company/
│   │               └── utils/
│   │                   ├── ConfigReader.java
│   │                   ├── TestDataGenerator.java
│   │                   └── Waits.java
│   └── test/
│       ├── java/
│       │   └── com/
│       │       └── company/
│       │           ├── pages/
│       │           │   ├── BasePage.java
│       │           │   ├── LoginPage.java
│   │   │   ├── UserTablePage.java
│   │   │   └── components/
│   │   │       ├── AddUserModal.java
│   │   │       ├── EditUserModal.java
│   │   │       └── SaveChangesModal.java
│       │           ├── tests/
│       │           │   ├── base/
│   │   │   │   └── BaseTest.java
│       │           │   ├── functional/
│   │   │   │   ├── UserCreationTest.java
│   │   │   │   ├── UserEditTest.java
│   │   │   │   └── UserTableTest.java
│       │           │   └── validation/
│   │   │   │   └── UserValidationTest.java
│       │           └── data/
│   │   │   └── TestData.java
│       └── resources/
│           ├── config/
│   │   │   └── config.properties
│           ├── test-data/
│   │   │   └── users.json
│           └── log4j2.xml
├── test-results/
│   ├── reports/
│   ├── screenshots/
│   └── logs/
├── pom.xml
├── README.md
└── docker-compose.yml

## Запуск тестов

# Локальный запуск
bash <br>
mvn clean test

# Запуск с параметрами
bash <br>
mvn clean test -Dbrowser=firefox -DbaseUrl=https://mes.inka.team

# Запуск определенных тестов
bash <br>
mvn clean test -Dtest=UserCreationTest

# Генерация отчётов
bash <br>
mvn surefire-report:report

# Запуск в Docker
bash <br>
docker-compose up --build


## План автоматизации

# Приоритеты автоматизации

Первый этап (High Priority):
1. Критическая функциональность - добавление пользователя с валидными данными
2. Валидация полей - негативные сценарии для обязательных полей и формата email
3. Базовые операции - редактирование пользователя через двойной клик
4. Фильтрация и сортировка - базовые сценарии работы с таблицей

Второй этап (Medium Priority):
1. Сохраняемость настроек - порядок колонок, фильтры, сортировка
2. Комплексные сценарии - цепочки действий (добавление → редактирование → фильтрация)
3. Граничные значения - минимальная/максимальная длина полей
4. Ошибки сервера - обработка сетевых ошибок, таймаутов

Третий этап (Low Priority):
1. UI/UX тестирование - визуальное оформление, responsive design
2. Производительность - время отклика при большом количестве данных
3. Кросс-браузерное тестирование - совместимость с разными браузерами

# Метрики и отчеты

Собираемые метрики:
- Стабильность тестов - процент успешных прогонов
- Время выполнения - длительность тестовых прогонов
- Coverage - покрытие функциональности тестами
- Flaky tests - количество нестабильных тестов

Инструменты отчетности:
- Allure Report - детальные отчеты с шагами и скриншотами
- JUnit 5 Reports - базовая статистика выполнения
- Custom Dashboard - мониторинг стабильности тестов
- Slack Integration - уведомления о результатах прогонов

Интеграция в CI/CD:
- Автоматический запуск тестов при pull request
- Gate для блокировки мержа при падении критических тестов
- Ночные регрессионные прогоны
- Периодический анализ flaky tests и их стабилизация
