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
`-Dregion=(i.e England, Scotland etc)` {for opening news by region test scenario, default is England}
`-Dpostcode=(i.e postcode for local news)` {default is CB1}

## Test Cases
Project covers below test cases:
1. Search News Topic On the Main Page.
2. Navigation to SignIn Page and User SignIn/SignOut.
3. Search Local News By PostCode.
4. Selecting News Based on the `region` passed as the parameter to the program.

## Parallel Execution
Project is using `TestNg` to run `test scenarios` parallely

## Test Report
Test report named "bbc-news-automated-tests-report.html" is generated in the output folder upon running the test cases. This report can be accessed to view the pass or fail steps and to analyze failures if any.
