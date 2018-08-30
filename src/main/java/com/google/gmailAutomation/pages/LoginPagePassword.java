package com.google.gmailAutomation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.google.gmailAutomation.base.TestBase;

public class LoginPagePassword extends TestBase {

	// Page Factory - Object Repository
	@FindBy(xpath = "//input[@type='password']")
	WebElement pwdTextBox;

	@FindBy(id = "passwordNext")
	WebElement nextBtnPwd;

	public LoginPagePassword() {
		PageFactory.initElements(driver, this);
	}

	public MyGoogleAccountPage enterPwdAndNext() {
		pwdTextBox.sendKeys(prop.getProperty("mail_id"));
		nextBtnPwd.click();
		return new MyGoogleAccountPage();
	}

}
