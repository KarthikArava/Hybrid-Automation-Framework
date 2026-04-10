# 🚀 Hybrid Automation Framework

---

## 📌 Overview

This project is a **Hybrid Test Automation Framework** built using modern automation tools and best practices.  
It supports both **UI (Web) Automation** and **API Automation** in a single framework.

The framework is designed to be:

- Scalable  
- Maintainable  
- Reusable  
- Parallel execution ready  

---

## ✨ Key Features

✔ UI Automation using Selenium WebDriver  
✔ API Automation using RestAssured  
✔ Hybrid module (UI + API) tests  
✔ BDD framework using Cucumber  
✔ Test execution using TestNG  
✔ Parallel execution  
✔ Page Object Model (POM) design  
✔ Centralized configuration management  
✔ Multi Browser compatibility  
✔ Logging using Log4j  
✔ Allure Reporting integration  
✔ JSON schema validation for APIs  
✔ Screenshot capture on failure  
✔ Modular framework architecture  

---

## 🏗️ Project Structure

```text
Hybrid_Automation_Framework/
│
├── api-test/src/test/
│   ├── client/
│   ├── requestBuilders/
│   ├── validator/
│   ├── tests/
│   └── resources/
│   └── pom.xml
│
├── ui-test/src/test/
│   ├── hooks/
│   ├── pages/
│   ├── runner/
│   ├── stepDefinitions/
│   └── resources/features/
│   └── pom.xml
│
├── hybrid-test/src/test/
│   ├── hooks/
│   ├── pages/
│   ├── runner/
│   ├── stepDefinitions/
│   ├── client/
│   ├── requestBuilder/
│   ├── validator/
│   └── resources/features/
│   └── pom.xml
│
├── common/src/main/
│   ├── config/
│   ├── driver/
│   ├── utils/
│   └── resources/
│   └── pom.xml
│
├── reports/
├── pom.xml
```

---

## ⚙️ Prerequisites

Make sure the following tools are installed on your system.

---

### ✅ 1. Java

Check if installed:

```bash
java -version
```

If not installed:
- Download JDK 17+
- Set environment variable:

```bash
JAVA_HOME=C:\Program Files\Java\jdk-17
```

---

### ✅ 2. Maven

Check:

```bash
mvn -version
```

If not installed:
- Download Maven
- Add to PATH:

```bash
MAVEN_HOME=C:\maven
PATH=%MAVEN_HOME%\bin
```

---

### ✅ 3. Allure

Check:

```bash
allure --version
```

If not installed (Windows):

```bash
scoop install allure
```

OR download manually and add `/bin` to PATH.

---

## 📥 Clone the Repository

```bash
git clone https://github.com/KarthikArava/Hybrid-Automation-Framework.git
cd hybrid-automation-framework
```

---

## ▶️ Run Commands

---

### 🔹 Run All Tests

```bash
mvn clean test
```

---

### 🔹 Run modules in Parallel

```bash
mvn clean test -T 3
```

---

### 🔹 Run Only UI Tests

```bash
mvn clean test -pl ui-test
```

---

### 🔹 Run Only API Tests

```bash
mvn clean test -pl api-test
```

---

### 🔹 Run Only Hybrid Tests

```bash
mvn clean test -pl hybrid-test
```

---

## 📊 Allure Reporting

---

### 🔹 After running, Generate & Open Report (Single Command)

```bash
allure serve reports/allure-results
```

---

## Results & Reports

<img width="1867" height="318" alt="Screenshot 2026-04-10 164455" src="https://github.com/user-attachments/assets/744858ae-6b2a-4dda-9270-bbc6ac9b9647" />

<img width="1920" height="1200" alt="Screenshot 2026-04-10 164027" src="https://github.com/user-attachments/assets/5b8d830c-8d5c-4531-8ec3-23a6931e3753" />
<img width="1920" height="1200" alt="Screenshot 2026-04-10 164112" src="https://github.com/user-attachments/assets/cd2b325a-97be-48ce-a027-87904cfe7aa8" />
<img width="1920" height="1200" alt="Screenshot 2026-04-10 164135" src="https://github.com/user-attachments/assets/5f674593-b5e2-447b-aab5-e143a77c6478" />
<img width="1920" height="1200" alt="Screenshot 2026-04-10 164237" src="https://github.com/user-attachments/assets/03053670-62a7-463c-bacf-53ec14dc7515" />

---

## 📂 Execution Reports

Overall reports are generated in:

```text
reports/
├── allure-results/
```
UI reports are generated in:

```text
ui-test/
├── reports/
|   ├── cucumber-report.html
|   ├── cucumber-report.json
```

---

## 📸 Logging & Screenshots

- Logs stored in:

```text
logs/automation.log
```

- Screenshots captured automatically on failure and attached to reports

---

## 🧠 Framework Highlights

- Hybrid automation (UI + API)
- Parallel execution support
- Modular architecture
- Reusable utilities
- Clean reporting with Allure

---

## 🚀 Tech Stack

- Java  
- Selenium  
- RestAssured  
- TestNG  
- Cucumber  
- Maven  
- Allure  
- Log4j  

---

## 📌 Notes

- Ensure internet connection tests  
- You can change browser type in common/resources/config.properties  
- Ensure firefox browser setup for best results
- Always run `mvn clean test` before generating reports  

---

## ⭐ Project Goal

```text
To build a robust, scalable, and maintainable hybrid automation framework
supporting both UI and API testing with parallel execution and advanced reporting.
```

---
