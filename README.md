
## User Authentication API Testing with REST Assured & Selenium(Aquality,TestNG,POM)

## Project Overview

This project tests the User Authentication API using REST Assured for API testing and Selenium with Aquality, TestNG, and POM for UI verification.
### Feature: User Authentication
The automation suite verifies user authentication by:
1. Sending a POST request with valid credentials.
2. Validating that the response status code is 200.
3. Extracting the authentication token from the response
4. Sending a GET request with the token to retrieve user info.
5. Verifying that the correct user details are returned.
### Tech Stack
- Java (Test Automation)
- REST Assured (API Testing)
- Selenium WebDriver (UI Automation)
- Aquality Selenium Framework (Enhanced Selenium Features)
- TestNG (Test Execution & Assertions)
- Cucumber (BDD)
- Maven (Dependency Management)

### How to Set Up the Project

1. **Prerequisites**:
Ensure you have the following installed:
   - Java 17+
   - Maven
   - IDE (IntelliJ, Eclipse, VS Code)
   - Postman (Optional for API verification)
   - WebDriver (Chrome, Firefox, or Edge)

2. **Install dependencies**
- mvn clean install
3. **Run Test**
- You can run TestRunner class in src/test/java/runners
