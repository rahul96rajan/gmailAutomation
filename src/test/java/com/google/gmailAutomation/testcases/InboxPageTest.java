package com.google.gmailAutomation.testcases;

import org.testng.annotations.BeforeMethod;

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
		inboxPage;
	}

}
