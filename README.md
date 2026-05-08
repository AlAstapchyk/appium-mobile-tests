# Mobile Appium Automation Framework

A robust, enterprise-grade mobile automation framework built to test Android applications using Appium and Java. This project demonstrates Senior QA Engineering practices, focusing on performance, reliability, and clear test reporting.

🌍 **[View Live Allure Test Report on Vercel](https://allure-maven-plugin.vercel.app)**

## 🚀 Key Features

- **Appium-Native Architecture**: Built exclusively for Mobile Testing using the Appium Java Client (v8.6.0).
- **Mastered Wait Strategies**: Zero implicit waits. 100% reliant on explicit `WebDriverWait` to eliminate flaky test runs and optimize execution speed.
- **Advanced Gestures**: Implements native Android `UiScrollable` integrations for complex dynamic scrolling, bypassing brittle coordinates.
- **Data-Driven Testing (DDT)**: Uses JUnit 5 `@ParameterizedTest` to dynamically run scenarios against multiple datasets.
- **Page Object Model (POM) via Fluent Interface**: Highly maintainable architecture utilizing method chaining, making test scenarios read like plain English and eliminating boilerplate code.
- **Automated Failure Screenshots**: Custom JUnit 5 `TestWatcher` automatically captures and attaches screenshots to reports upon test failure.
- **Action Logging**: SLF4J integrated into the Base Page for deep, step-by-step trace logging of all interactions.
- **Allure Reporting**: Generates beautiful, comprehensive HTML test execution reports.

## 🛠️ Technology Stack

- **Java 17**
- **Appium** (Java Client 8.6.0)
- **Selenium WebDriver** (Core API & Wait Strategies)
- **JUnit 5**
- **Maven**
- **Allure Reporting**
- **SLF4J / Logback**
- **GitHub Actions** (CI/CD Mobile Emulator pipeline)

## 🧪 Test Coverage
The suite covers critical end-to-end (E2E) flows for a mobile eCommerce application:
1. Dynamic Product Discovery (Scrolling & Selecting)
2. Cart Management (Adding & Removing)
3. Data-Driven Scenarios
4. Complete Checkout Flow (Authentication -> Shipping -> Payment)

## 🏃‍♂️ How to Run

1. Ensure **Appium Server** is installed and running (`appium`).
2. Ensure an Android Emulator or physical device is connected (`adb devices`).
3. Execute the custom PowerShell wrapper:
```powershell
./run-test.ps1
```
*(This automatically boots the server, runs the tests, and kills the server afterwards).*

To view the execution report:
```bash
mvn allure:serve
```
