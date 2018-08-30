package com.google.gmailAutomation.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.google.gmailAutomation.base.TestBase;
import com.google.gmailAutomation.pages.InboxPage;
import com.google.gmailAutomation.pages.LoginPageEmail;
import com.google.gmailAutomation.pages.LoginPagePassword;

public class InboxPageTest extends TestBase  {
	LoginPageEmail loginPageMail;
	LoginPagePassword loginPagePwd;
	InboxPage inboxPage;
	public InboxPageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		initialization();
		loginPageMail = new LoginPageEmail();
		loginPagePwd = loginPageMail.enterUserNameAndNext();
		inboxPage = loginPagePwd.enterPwdAndNext();
	}
	
	@Test(priority = 0)
	public void testComposeAndSendMail() {
		inboxPage.composeAndSendMail(prop.getProperty("to_id"),prop.getProperty("subject"),prop.getProperty("body"));
		Assert.assertTrue(inboxPage.isSentMessageLabelPresent(), "Sent Message Label/Pop-Up is not generated.");
	}
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}

}
