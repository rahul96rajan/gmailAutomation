package com.google.gmailAutomation.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.google.gmailAutomation.base.TestBase;
import com.google.gmailAutomation.pages.LoginPageEmail;
import com.google.gmailAutomation.pages.LoginPagePassword;

public class LoginPageEmailTest extends TestBase {
	
	LoginPageEmail loginPageMail;
	
	public LoginPageEmailTest() {
		super();
	}

	@BeforeClass
	public void setUp() {
		initialization();
		loginPageMail = new LoginPageEmail();	
	}
	
	@Test(priority = 0)
	public LoginPagePassword testEnterUserNameAndNext() {
		loginPageMail.enterUserNameAndNext();
		waitObj.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Forgot password')]")));
		Assert.assertTrue(driver.findElement(By.xpath("//span[contains(text(),'Forgot password')]")).isDisplayed(),
				"Forgot Password link is not displayed");
		return new LoginPagePassword();
	}
	
	@AfterClass
	public void tearDown() {
//		driver.close();
	}
	
}
