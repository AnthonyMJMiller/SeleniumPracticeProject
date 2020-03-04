package com.nx.baseTestFunctions;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class LoginFunction {
	
	public void loginFunction(WebDriver browser, String user, String pass) {
		
		WebElement loginButton = browser.findElement(By.xpath("//button[@aria-label='Login' and @ng-click='OpenLoginModal()']"));

		loginButton.click();

		WebElement username = browser.findElement(By.id("input_0"));

		username.sendKeys(user);

		WebElement password = browser.findElement(By.id("input_1"));

		password.sendKeys(pass);

		WebDriverWait hold = new WebDriverWait(browser, 30);

		hold.until(ExpectedConditions
				.elementToBeClickable(By.xpath("//button[@type='submit' and @ng-click='loginModal.ok()']")));

		WebElement enterButton = browser
				.findElement(By.xpath("//button[@type='submit' and @ng-click='loginModal.ok()']"));
		enterButton.click();
	}

}
