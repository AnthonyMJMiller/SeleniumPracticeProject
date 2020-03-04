package com.nx.externalLinksVerify;

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

public class ExternalLinkCheckTest {
	
	WebDriver browser;
	ChromeOptions options;
	LoginFunction login = new LoginFunction();
	ConfigFileReader config = new ConfigFileReader();
	
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
	public void verifyOffice365Link() {
		
		login.loginFunction(browser, config.getUsername(), config.getPassword());
		
		WebElement officeLink = browser.findElement(By.xpath("//img[@ng-src='img/office365.png']//ancestor::div[@ng-click='homeControllerVC.clickToExternal(link.externalLink)']"));
		
		assertTrue(officeLink.isDisplayed());
		
	}
	
	@Test
	public void verifySharepointLink() {
		
		login.loginFunction(browser, config.getUsername(), config.getPassword());
		
		WebElement shareLink = browser.findElement(By.xpath("//img[@ng-src='img/sharepoint-logo.jpg']//ancestor::div[@ng-click='homeControllerVC.clickToExternal(link.externalLink)']"));
		
		assertTrue(shareLink.isDisplayed());
	}
	
	@Test
	public void verifyNexWikiLink() {
		
		login.loginFunction(browser, config.getUsername(), config.getPassword());
		
		WebElement nexWikiLink = browser.findElement(By.xpath("//img[@ng-src='img/nexient-logo.png']//ancestor::div[@ng-click='homeControllerVC.clickToExternal(link.externalLink)']"));
		
		assertTrue(nexWikiLink.isDisplayed());
	}
	
	@Test
	public void verifyADPLink() {
		
		login.loginFunction(browser, config.getUsername(), config.getPassword());
		
		WebElement adpLink = browser.findElement(By.xpath("//img[@ng-src='img/adp-logo.png']//ancestor::div[@ng-click='homeControllerVC.clickToExternal(link.externalLink)']"));
		
		assertTrue(adpLink.isDisplayed());
	}
	
	@Test
	public void verifyBambooHrLink() {
		
		login.loginFunction(browser, config.getUsername(), config.getPassword());
		
		WebElement bamHrLink = browser.findElement(By.xpath("//img[@ng-src='img/bamboo-logo.jpg']//ancestor::div[@ng-click='homeControllerVC.clickToExternal(link.externalLink)']"));
		
		assertTrue(bamHrLink.isDisplayed());
	}
	
	@Test
	public void verifyGitLabLink() {
		
		login.loginFunction(browser, config.getUsername(), config.getPassword());
		
		WebElement gitLabLink = browser.findElement(By.xpath("//img[@ng-src='img/gitlab-logo.png']//ancestor::div[@ng-click='homeControllerVC.clickToExternal(link.externalLink)']"));
		
		assertTrue(gitLabLink.isDisplayed());
	}
	
	@Test
	public void verifyJenkinsLink() {
		
		login.loginFunction(browser, config.getUsername(), config.getPassword());
		
		WebElement jenkinsLink = browser.findElement(By.xpath("//img[@ng-src='img/jenkins.jpg']//ancestor::div[@ng-click='homeControllerVC.clickToExternal(link.externalLink)']"));
		
		assertTrue(jenkinsLink.isDisplayed());
	}
	
	@Test
	public void verifySonarQubeLink() {
		
		login.loginFunction(browser, config.getUsername(), config.getPassword());
		
		WebElement sonQubeLink = browser.findElement(By.xpath("//img[@ng-src='img/sonarqube-logo.png']//ancestor::div[@ng-click='homeControllerVC.clickToExternal(link.externalLink)']"));
		
		assertTrue(sonQubeLink.isDisplayed());
	}

}
