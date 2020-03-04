package com.nx.eventVerify;

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

public class EventCheckTest {

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

		browser.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

	}

	@AfterMethod
	public void finishTest() {

		browser.quit();
	}
	
	@Test
	public void checkingNoEventsListed() {

		login.loginFunction(browser, config.getUsername(), config.getPassword());

		WebElement noEvents = browser.findElement(By.xpath(
				"//p[text()='No events scheduled in the next month']"));

		assertTrue(noEvents.isDisplayed());

	}

}
