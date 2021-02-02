package com.riti.bbcnews.factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class WebDriverFactory {

	public static WebDriver createWebDriver() {

		String webdriver = System.getProperty("browser");
		String driverPath = System.getProperty("driverpath");
		boolean headless = Boolean.parseBoolean(System.getProperty("headless"));
		switch (webdriver) {
		case "firefox":
			System.setProperty("webdriver.firefox.driver", driverPath);
			FirefoxOptions firefoxOptions = new FirefoxOptions();
			if (headless)
				firefoxOptions.addArguments("headless");
			return new FirefoxDriver(firefoxOptions);
		case "chrome":
			System.setProperty("webdriver.chrome.driver", driverPath);
			ChromeOptions chromeOptions = new ChromeOptions();
			if (headless)
				chromeOptions.addArguments("headless");
			return new ChromeDriver(chromeOptions);
		default:
			throw new RuntimeException("Unsupported webdriver: " + webdriver);
		}
	}
}
