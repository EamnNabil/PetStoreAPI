# Pet Store API Testing

## Overview
This project validates CRUD operations for user management, pet information, and order processing using Rest Assured.

## Setup
1. Install Java 11 or later.
2. Install Maven for dependency management.
3. Clone the repository: `git clone <repo-url>`.
4. Run `mvn clean install` to download dependencies.

## Execution
Run tests using TestNG:
```
mvn test
```

## Reports
Test results are generated in the `target/surefire-reports` directory. Use Allure for detailed reports:
```
allure serve target/allure-results
