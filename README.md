# bbcnews-automated-tests
BBC News Website Automated Tests using Java, Cucumber, TestNg and Selenium following BDD approach

## Setup Project
`clone` and `import` as a `maven` project in eclipse, You can find `bbc_news_tests.feature` having all the `test scenarios` under test resource folder.

## Run
under test folder at path  `com/riti/bbcnews/test/BBCNewsAutomatedTestsRunner.java` is the TestRunnerClass
Before you run you need to set some program arguments
`-Ddriver=chrome`
`-Ddriverpath=chromedriverpath`
`-Dusername=your BBC News Account Username`
`-Dpassword=BBC Account Password`
`-Dregion=(i.e England, Scotland etc)` {for opening news by region test scenario}

## Test Scenarios Covered
Currently this project covers below test cases
- Search News Topic On the Main Page
- Navigation to SignIn Page, User SignIn/SignOut
- Selecting News Based on the `region` passed as the parameter to the program

## Parallel Execution
Project is using `TestNg` to run `test scenarios` parallely
