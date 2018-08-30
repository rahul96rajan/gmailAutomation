package com.google.gmailAutomation.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.google.gmailAutomation.base.TestBase;
import com.google.gmailAutomation.pages.LoginPageEmail;
import com.google.gmailAutomation.pages.LoginPagePassword;

public class LoginPagePasswordTest extends TestBase{
	
	LoginPageEmail loginPageMail;
	LoginPagePassword loginPagePwd;
	public LoginPagePasswordTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		initialization();
		loginPageMail = new LoginPageEmail();
		loginPagePwd = loginPageMail.enterUserNameAndNext();
	}
	
	@Test(priority = 0)
	public void testEnterPwdAndNext() {
		loginPagePwd.enterPwdAndNext();
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
