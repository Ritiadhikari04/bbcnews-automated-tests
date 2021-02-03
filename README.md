# bbcnews-automated-tests
BBC News Website Automated Tests using Java, Cucumber, TestNg and Selenium following BDD approach

## Setup Project
`clone` and `import` as a `maven` project in eclipse, You can find `bbc_news_tests.feature` having all the `test scenarios` under test resource folder.

## Run
TestRunnerClass is available at `com/riti/bbcnews/test/BBCNewsAutomatedTestsRunner.java`
Before you run, set program arguments required for testing.
`-Ddriver=`{i.e chrome or firefox}
`-Ddriverpath=`{i.e broswer driver path}
`-Dusername=your BBC News Account Username`
`-Dpassword=BBC Account Password`
`-Dregion=(i.e England, Scotland etc)` {for news by region test scenario, default is England}
`-Dpostcode=(i.e postcode for local news)` {default is CB1}

## Running in headless mode
By default all tests runs on browser, if you wish to run tests in headless mode pass programs arguement `-Dheadless=true`

## Test Scenarios
Project covers below test scenarios:
1. Search News Topic On the Main Page.
2. Navigation to SignIn Page and User SignIn/SignOut.
3. Search Local News By PostCode.
4. Selecting News Based on the `region` passed as the parameter to the program.

## Parallel Execution
Project is using `TestNg` to run `test scenarios` parallely

## Test Report
Test report named `bbc-news-automated-tests-report.html` is generated in project root folder upon running the test cases. This report can be accessed to view the passed or failed steps.
