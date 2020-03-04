package com.nx.loginVerify;

import org.testng.annotations.Test;

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

public class LoginTest {

	WebDriver browser;
	ChromeOptions options;
	ConfigFileReader config;
	
	@BeforeMethod
	public void setup() {
		
		config = new ConfigFileReader();
		
		System.setProperty("webdriver.chrome.driver", config.getDriverPath());

		browser = new ChromeDriver();

		browser.get(config.getUrl());
		
		options = new ChromeOptions();

		options.addArguments("--incognito");
		options.addArguments("enable-automation");
		options.addArguments("--headless");
		options.addArguments("--no-sandbox");
		options.addArguments("--disable-gpu");
		options.addArguments("--disable-extensions");
		options.addArguments("--dns-prefetch-disable");
		options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
		
		browser.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

	}

	@AfterMethod
	public void finishTest() {

		browser.quit();
	}

	@Test
	public void checkingLoginButton() {

		WebElement loginButton = browser.findElement(By.xpath("//button[@aria-label='Login' and @ng-click='OpenLoginModal()']"));

		assertTrue(loginButton.isDisplayed());
		
		WebElement loginLink = browser.findElement(By.xpath("//a[text()='login']"));
		
		assertTrue(loginLink.isDisplayed());

	}

	@Test
	public void checkingLoginScreen() {

		WebElement loginButton = browser.findElement(By.xpath("//button[@aria-label='Login' and @ng-click='OpenLoginModal()']"));

		loginButton.click();

		WebElement username = browser.findElement(By.xpath("//input[@name='username']"));

		assertTrue(username.isDisplayed());

		WebElement password = browser.findElement(By.xpath("//input[@name='password']"));

		assertTrue(password.isDisplayed());
		
		WebElement enterButton = browser.findElement(By.xpath("//button[@type='submit' and @ng-click='loginModal.ok()']"));
		
		assertTrue(enterButton.isDisplayed());
		
		WebElement checkbox = browser.findElement(By.xpath("//md-checkbox[@name='rememberMe']"));
		
		assertTrue(checkbox.isDisplayed());
		
		WebElement cancelButton = browser.findElement(By.xpath("//button[@ng-click='loginModal.cancel()']"));
		
		assertTrue(cancelButton.isDisplayed());
	}

}
