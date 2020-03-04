package com.nx.holidayVerify;

import org.testng.annotations.Test;

import com.nx.baseTestFunctions.LoginFunction;
import com.nx.privateTestInfo.ConfigFileReader;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;

import static org.testng.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class HolidayCheckTest {

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
	public void verifyMemorialDay() {

		login.loginFunction(browser, config.getUsername(), config.getPassword());

		WebElement memDayText = browser.findElement(By.xpath("//b[text()='Memorial Day']"));

		assertTrue(memDayText.isDisplayed());

		WebElement memDate = browser.findElement(By.xpath("//h4[text()='2020-05-25']"));

		assertTrue(memDate.isDisplayed());

	}

	@Test
	public void verifyIndependenceDay() {

		login.loginFunction(browser, config.getUsername(), config.getPassword());

		WebElement indDate = browser.findElement(By.xpath("//h4[text()='2020-07-03']"));

		assertTrue(indDate.isDisplayed());

		WebElement indDayText = browser.findElement(By.xpath("//b[text()='Independence Day']"));

		assertTrue(indDayText.isDisplayed());

	}

	@Test
	public void verifyLaborDay() {

		login.loginFunction(browser, config.getUsername(), config.getPassword());

		WebElement labDay = browser.findElement(By.xpath("//h4[text()='2020-09-07']"));

		assertTrue(labDay.isDisplayed());

		WebElement labDayText = browser.findElement(By.xpath("//b[text()='Labor Day']"));

		assertTrue(labDayText.isDisplayed());

	}

	@Test
	public void verifyThanksgivingDay() {

		login.loginFunction(browser, config.getUsername(), config.getPassword());

		WebElement thankDay = browser.findElement(By.xpath("//h4[text()='2020-11-26']"));

		assertTrue(thankDay.isDisplayed());

		WebElement thankDayText = browser.findElement(By.xpath("//b[text()='Thanksgiving Day']"));

		assertTrue(thankDayText.isDisplayed());

	}

	@Test
	public void verifyChristmasDay() {

		login.loginFunction(browser, config.getUsername(), config.getPassword());

		WebElement xmasDay = browser.findElement(By.xpath("//h4[text()='2020-12-25']"));

		assertTrue(xmasDay.isDisplayed());

		WebElement xmasDayText = browser.findElement(By.xpath("//b[text()='Christmas Day']"));

		assertTrue(xmasDayText.isDisplayed());

	}

}
