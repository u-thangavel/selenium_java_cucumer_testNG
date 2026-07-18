
---

# Selenium Java Cucumber TestNG Framework

This is a robust, scalable test automation framework built with Java, Selenium, Cucumber (BDD), and TestNG. It supports parallel execution and follows the Page Object Model (POM) pattern.

## 🚀 Features

* **BDD Approach:** Cucumber for readable test scenarios.
* **Test Orchestration:** TestNG for running test suites and managing execution flow.
* **Parallel Execution:** Configured to run tests in parallel to save time.
* **Robust Reporting:** Integrated with Allure/Cucumber HTML reports.
* **Architecture:** Page Object Model (POM) for clean, maintainable code.

## 🛠 Prerequisites

Ensure you have the following installed on your machine:

* **Java JDK 21+**
* **Maven**
* **IntelliJ IDEA** (or your preferred IDE)

## ⚙️ How to Run

1. **Clone the repository:**
```bash
git clone https://github.com/u-thangavel/selenium_java_cucumer_testNG.git

```


2. **Install Dependencies:**
   Run the following command in the project root:
```bash
mvn clean install

```


3. **Run Tests:**
   You can execute tests via the `testng.xml` file:
```bash
mvn test

```


## 📂 Project Structure

* `src/test/java/com/feature`: Contains Gherkin feature files.
* `src/test/java/com/Test`: Contains Step Definition files.
* `src/test/java/com/runner`: Contains the TestRunner class.
* `src/main/java/com/utils`: Contains base classes and utility methods (e.g., driver initialization).
* `src/test/java/com/Pages`: Contains Locators pagewise.


## 💡 Notes

* This framework uses `ThreadLocal` for driver management to ensure thread safety during parallel execution.
* Ensure your `chromedriver` or appropriate browser driver is managed correctly (this framework is configured for Selenium 4).

---
