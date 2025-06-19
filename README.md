# Java Selenium Test Automation Framework

This is a modular and scalable Test Automation Framework built using **Java**, **Selenium WebDriver**, **TestNG**, and follows the **Page Object Model (POM)** design pattern. It supports cross-browser testing and integrates **Log4j** for logging and **ExtentReports** for test reporting.

---

## ✅ Key Features

- Java + Selenium WebDriver for UI test automation
- Page Object Model (POM) for maintainable and reusable code
- TestNG for test execution, grouping, and parallel testing
- Cross-browser testing support (Chrome, Firefox, Edge, etc.)
- Log4j logging integration for debugging and traceability
- ExtentReports for detailed HTML reporting
- Maven-based project structure for dependency management

---

## 🧱 Project Structure

![image](https://github.com/user-attachments/assets/593b5fd9-3913-4d52-aa05-b4edb0b9062d)


---

## ⚙️ Tools & Technologies

- **Java 8+**
- **Selenium WebDriver**
- **TestNG**
- **Log4j**
- **ExtentReports**
- **Maven**
- **POM Design Pattern**
- **Eclipse IDE**

---

## 🧪 Getting Started

### 1. Clone the Repository

```bash
git clone https://github.com/girishkumar-repo/PlanSourceAutomation.git
cd PlanSourceAutomation




### 2. Configure Project
Configuration is updated in config.properties

### 3. Install Eclipse
🖥️ Step-by-Step Installation
1. Download Eclipse Installer
Visit the official Eclipse download page:
https://www.eclipse.org/downloads/

Click on "Download x86_64" for your operating system.

2. Run the Installer
Launch the downloaded installer file.

3. Choose Eclipse IDE for Java Developers
Select “Eclipse IDE for Java Developers” (or another variant as needed).

4. Select Installation Folder
Choose or confirm the installation path.

Click "Install".

5. Accept License Agreement
Accept the license terms and proceed.

6. Wait for Installation to Complete
Let the installer download and install the necessary components.

7. Launch Eclipse
After installation, click “Launch”.

Choose the cloned workspace directory.

3. Build and Run Tests
run test using testng.xml

4. View Reports
After test execution:

✅ Test Report: Open reports/ExtentReport.html

📜 Logs: View logs in the logs/ directory

🔄 Cross-Browser Testing
You can run tests on multiple browsers by updating the browser value in config.properties. Supported browsers:

Chrome

Firefox

Edge

📊 Reporting with ExtentReports
This framework uses ExtentReports for test reporting, including:

Pass/fail/skipped test statuses

Step-wise test logs

Report output path: reports/TestReport-{time-stamp}.html

📝 Logging with Log4j
Log4j is used to create runtime logs. You can configure logging level and format in the log4j.properties file. Log files are saved in the PlanSourceAssignment/logs.
