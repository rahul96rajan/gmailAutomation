package com.google.gmailAutomation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.google.gmailAutomation.base.TestBase;

public class InboxPage extends TestBase {

	// Page Factory - Object Repository
	@FindBy(xpath = "//div[contains(text(),'Compose')]")
	WebElement composeBtn;

	@FindBy(xpath = "//textarea[@aria-label='To']")
	WebElement toTextField;

	@FindBy(xpath = "//input[@name='subjectbox']")
	WebElement subjectField;

	@FindBy(xpath = "//div[@aria-label='Message Body']")
	WebElement messageBody;
	
	@FindBy(xpath = "//div[contains(text(),'Send')]")
	WebElement sendBtn;
	
	@FindBy(xpath = "//span[contains(text(),'Message')]")
	WebElement sentMessageLabel;

	public InboxPage() {
		PageFactory.initElements(driver, this);
	}
	
	public void composeAndSendMail(String to_id, String subject, String body) {
		waitObj.until(ExpectedConditions.visibilityOf(composeBtn));
		composeBtn.click();
		waitObj.until(ExpectedConditions.visibilityOf(toTextField));
		toTextField.sendKeys(to_id);
		subjectField.sendKeys(subject);
		messageBody.sendKeys(body);
		sendBtn.click();
	}
	
	public boolean isSentMessageLabelPresent() {
		return sentMessageLabel.isDisplayed();
	}

}
