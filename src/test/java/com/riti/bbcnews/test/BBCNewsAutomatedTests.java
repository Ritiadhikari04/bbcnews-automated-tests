package com.riti.bbcnews.test;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.riti.bbcnews.factory.WebDriverFactory;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class BBCNewsAutomatedTests {

	private WebDriver driver = null;
	private WebDriverWait wait;
	private String username = "";
	private String password = "";
	private String postcode = "CB1";
	private String region = "England";

	@Before
	public void Setup() {
		driver = WebDriverFactory.createWebDriver();
		wait = new WebDriverWait(driver, 50);
		username = System.getProperty("username");
		password = System.getProperty("password");
		if (System.getProperty("region") != null && !"".equals(System.getProperty("region")))
			region = System.getProperty("region");
		if (System.getProperty("postcode") != null && !"".equals(System.getProperty("postcode")))
			postcode = System.getProperty("postcode");
		System.out.println("[username=" + username + ", password=" + password + ", postcode=" + postcode + ", region="
				+ region + "]");
	}

	public WebDriver getWebDriver() {
		return driver;
	}

	public WebDriverWait getWebDriverWait() {
		return wait;
	}

	@Given("^Browser has BBC News website opened$")
	public void openBrowser() {
		driver.navigate().to("https://www.bbc.co.uk/news");
	}

	@When("^Search Exists$")
	public void search_exists() {
		WebElement input = getWebDriver().findElement(By.id("orb-search-q"));
		WebElement searchButton = getWebDriver().findElement(By.id("orb-search-button"));

		Assert.assertEquals(input.isDisplayed(), true);
		Assert.assertEquals(searchButton.isDisplayed(), true);
		System.out.println("Search Exists");
	}

	@Then("^We are able to search$")
	public void search_works() {
		WebElement input = getWebDriver().findElement(By.id("orb-search-q"));
		// type
		input.sendKeys("health");

		WebElement input2 = getWebDriverWait().until(
				ExpectedConditions.elementToBeClickable(getWebDriver().findElement(By.id("se-searchbox-input-field"))));

		Assert.assertEquals(input2.isDisplayed(), true);

		WebElement searchButton = getWebDriver().findElement(By.className("se-searchbox__submit"));
		// submit search
		searchButton.click();
		getWebDriverWait().until(ExpectedConditions.presenceOfElementLocated(By.id("main-content")));

		System.out.println("Search works fine");
	}

	@When("^Has SignIn Option$")
	public void hasSignInOption() {
		WebElement signInButton = getWebDriverWait()
				.until(ExpectedConditions.presenceOfElementLocated(By.id("idcta-link")));
		Assert.assertEquals(signInButton.isDisplayed(), true);
		signInButton.click();
	}

	@Then("^Perform SignIn$")
	public void performSignIn() {

		WebElement emailInput = getWebDriverWait()
				.until(ExpectedConditions.presenceOfElementLocated(By.id("user-identifier-input")));
		Assert.assertEquals(emailInput.isDisplayed(), true);
		emailInput.sendKeys(username);

		WebElement passwordInput = getWebDriver().findElement(By.id("password-input"));
		passwordInput.sendKeys(password);

		WebElement signInButton = getWebDriverWait()
				.until(ExpectedConditions.presenceOfElementLocated(By.id("submit-button")));

		Assert.assertEquals(signInButton.isDisplayed(), true);
		signInButton.click();
	}

	@And("^SignedIn$")
	public void signedIn() {
		WebElement element = getWebDriverWait()
				.until(ExpectedConditions.presenceOfElementLocated(By.id("idcta-username")));
		Assert.assertEquals(element.isDisplayed(), true);
		System.out.println("Succesfully Logged In");
		element.click();
	}

	@When("^I click SignOut")
	public void signout() {
		WebElement signout = getWebDriverWait()
				.until(ExpectedConditions.presenceOfElementLocated(By.partialLinkText("Sign out")));
		Assert.assertEquals(signout.isDisplayed(), true);
		signout.click();
	}

	@Then("^I should SignOut")
	public void signedout() {
		WebElement signInButton = getWebDriverWait()
				.until(ExpectedConditions.presenceOfElementLocated(By.id("idcta-link")));
		Assert.assertEquals(signInButton.isDisplayed(), true);
		System.out.println("Succesfully Logged Out");
	}

	@When("^Open news of selected Region")
	public void openRegionNews() {
		System.out.println("Looking for all the news in " + region);
		WebElement regionNews = getWebDriverWait()
				.until(ExpectedConditions.presenceOfElementLocated(By.partialLinkText(region)));
		Assert.assertEquals(regionNews.isDisplayed(), true);
		System.out.println("Region News Option Available");
		regionNews.click();
	}

	@Then("^all news are of selected region")
	public void selectedRegionNews() {

		List<WebElement> regionNewsList = getWebDriverWait()
				.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.partialLinkText(region)));

		Assert.assertEquals(regionNewsList.isEmpty(), false);
		System.out.println("Found News for selected Region (" + region + ")");
	}

	@When("Open Local News")
	public void gotToLocalNews() {
		WebElement localNews = getWebDriverWait()
				.until(ExpectedConditions.presenceOfElementLocated(By.partialLinkText("Local News")));
		Assert.assertEquals(localNews.isDisplayed(), true);
		localNews.click();
	}

	@Then("Search By Entering PostCode")
	public void searchLocalNewsByPostCode() {
		getWebDriverWait().until(ExpectedConditions.invisibilityOfElementLocated(By.id("ls-c-search__input-label")));
		WebElement inputElement = getWebDriver().findElement(By.id("ls-c-search__input-label"));
		Actions action = new Actions(getWebDriver());
		action.moveToElement(inputElement);

		JavascriptExecutor javascript = (JavascriptExecutor) getWebDriver();
		javascript.executeScript("let input = document.getElementById('ls-c-search__input-label');\n input.value='"
				+ postcode
				+ "';\n let searchButton = document.getElementsByClassName('ls-c-search__submit')[0];\n searchButton.click();");
		System.out.println("Search Started");
	}

	@Then("Set Radius and See Search Results")
	public void setLocalNewsByPostCodeRadius() {
		WebElement fiveMileRadiusLink = getWebDriverWait()
				.until(ExpectedConditions.visibilityOfElementLocated(By.partialLinkText("5")));
		Assert.assertEquals(fiveMileRadiusLink.isDisplayed(), true);
		fiveMileRadiusLink.click();
		System.out.println("5 Mile Radius is selected, Local News is Visible");
	}

	@After
	public void tearDown() {
		getWebDriver().close();
	}

}
