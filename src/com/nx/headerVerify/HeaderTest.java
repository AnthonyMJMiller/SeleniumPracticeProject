package com.nx.headerVerify;

import org.testng.annotations.Test;

import com.nx.baseTestFunctions.LoginFunction;
import com.nx.privateTestInfo.ConfigFileReader;

import org.testng.annotations.BeforeMethod;

import static org.testng.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;

public class HeaderTest {

	WebDriver browser;
	ChromeOptions options;
	LoginFunction login = new LoginFunction();
	ConfigFileReader config;

	@BeforeMethod
	public void setup() {
		
		config = new ConfigFileReader();

		System.setProperty("webdriver.chrome.driver", config.getDriverPath());

		browser = new ChromeDriver();

		options = new ChromeOptions();

		options.addArguments("--incognito");
		options.addArguments("enable-automation");
		options.addArguments("--headless");
		options.addArguments("--no-sandbox");
		options.addArguments("--disable-gpu");
		options.addArguments("--disable-extensions");
		options.addArguments("--dns-prefetch-disable");
		options.setPageLoadStrategy(PageLoadStrategy.NORMAL);

		browser.get(config.getUrl());

		browser.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}

	@AfterMethod
	public void finishTest() {

		browser.quit();
	}
	
	@Test
	public void checkHomeHeader() {

		login.loginFunction(browser, config.getUsername(), config.getPassword());

		WebElement homeButton = browser.findElement(By.xpath("//a[@aria-label='Home']"));

		assertTrue(homeButton.isDisplayed());
	}

	@Test
	public void checkEventsHeader() {

		login.loginFunction(browser, config.getUsername(), config.getPassword());

		WebElement eventsButton = browser.findElement(By.xpath("//a[@aria-label='Events']"));

		assertTrue(eventsButton.isDisplayed());
	}

	@Test
	public void checkTimesheetHeader() {

		login.loginFunction(browser, config.getUsername(), config.getPassword());

		WebElement timesheetButton = browser.findElement(By.xpath("//a[@aria-label='View Timesheet']"));

		assertTrue(timesheetButton.isDisplayed());
	}

	@Test
	public void checkClientsHeader() {

		login.loginFunction(browser, config.getUsername(), config.getPassword());

		WebElement clientsButton = browser.findElement(By.xpath("//a[@aria-label='View Client Workflow']"));

		assertTrue(clientsButton.isDisplayed());
	}

	@Test
	public void checkProfileHeader() {

		login.loginFunction(browser, config.getUsername(), config.getPassword());

		WebElement profileButton = browser.findElement(By.xpath("//a[@aria-label='View Profile']"));

		assertTrue(profileButton.isDisplayed());
	}

	@Test
	public void checkEmployeeSearchHeader() {

		login.loginFunction(browser, config.getUsername(), config.getPassword());

		WebElement searchButton = browser.findElement(By.xpath("//a[@aria-label='View Directory']"));

		assertTrue(searchButton.isDisplayed());
	}

	@Test
	public void checkLogoutHeader() {

		login.loginFunction(browser, config.getUsername(), config.getPassword());

		WebElement logoutButton = browser.findElement(By.xpath("//button[@aria-label='Logout']"));

		assertTrue(logoutButton.isDisplayed());
	}

}
