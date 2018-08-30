package com.google.gmailAutomation.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.google.gmailAutomation.base.TestBase;
import com.google.gmailAutomation.pages.LoginPageEmail;
import com.google.gmailAutomation.pages.LoginPagePassword;

public class LoginPageEmailTest extends TestBase {
	
	LoginPageEmail loginPageMail;
	
	public LoginPageEmailTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		initialization();
		loginPageMail = new LoginPageEmail();	
	}
	
	@Test
	public void testEnterUserNameAndNext() {
		loginPageMail.enterUserNameAndNext();
		waitObj.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Forgot password')]")));
		Assert.assertTrue(driver.findElement(By.xpath("//span[contains(text(),'Forgot password')]")).isDisplayed(),
				"Forgot Password link is not displayed");
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
}
