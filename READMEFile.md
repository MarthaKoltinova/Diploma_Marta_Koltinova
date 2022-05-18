Internship Project
=====================
Requirements
-----------------------------------
* Java version 11
* Maven
* Selenium + TestNG
* Realization - PageObject pattern
* Using Allure
* Building the project through mvn + testng.xml(there are 4 xml files for execution tests)

Running tests
-----------------------------------
* Clone the project 
```
git clone url
```
* Checkout to the main branch
* Run tests with maven:
  ```
  mvn clean test
  ```
Allure reports
-----------------------------------
* use this command to generate a report
  ```
 allure generate target/allure-results -c -o target/result
  ```
* use this command to open a report
  ```
 allure serve target/allure-results
  ```
