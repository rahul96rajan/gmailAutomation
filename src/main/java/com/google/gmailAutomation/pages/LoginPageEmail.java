package com.google.gmailAutomation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.google.gmailAutomation.base.TestBase;

public class LoginPageEmail extends TestBase {

	// Page Factory - Object Repository
	@FindBy(xpath = "//input[@type='email']")
	WebElement emailTextBox;

	@FindBy(id = "identifierNext")
	WebElement nextBtnEmail;

	public LoginPageEmail() {
		PageFactory.initElements(driver, this);
	}

	public LoginPagePassword enterUserNameAndNext() {
		emailTextBox.sendKeys(prop.getProperty("mail_id"));
		nextBtnEmail.click();
		return new LoginPagePassword();	
	}

}
