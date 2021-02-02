package com.riti.bbcnews.test;


import org.testng.annotations.DataProvider;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = { "classpath:bbc_news_tests.feature" }, plugin = { "pretty",
		"html:bbc-news-automated-tests-report.html" })
public class BBCNewsAutomatedTestsRunner extends AbstractTestNGCucumberTests {

	@Override
	@DataProvider(parallel = true)
	public Object[][] scenarios() {
		return super.scenarios();
	}
}
