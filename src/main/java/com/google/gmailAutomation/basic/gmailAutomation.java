package com.google.gmailAutomation.basic;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class gmailAutomation {
	public static WebDriverWait wait;

	public static void main(String[] args) {
		WebDriver driver = new FirefoxDriver();
		wait = new WebDriverWait(driver, 5);
		driver.get("https://mail.google.com/mail");

		// Email Entry
		driver.findElement(By.id("identifierId")).sendKeys("sample96rajan@gmail.com");
		driver.findElement(By.id("identifierNext")).click();

		// Password Entry
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//content[contains(text(),'Welcome')]")));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("identifierNext")));
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys("Sample987*#");
		driver.findElement(By.id("passwordNext")).click();
		
		//Compose
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Compose')]")));
		driver.findElement(By.xpath("//div[contains(text(),'Compose')]")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//textarea[@aria-label='To']")));
		driver.findElement(By.xpath("//textarea[@aria-label='To']")).sendKeys("rahul.rajan10101996@gmail.com");
		driver.findElement(By.xpath("//input[@name='subjectbox']")).sendKeys("Test Subject");
		driver.findElement(By.xpath("//div[@aria-label='Message Body']")).sendKeys("Test BODY");
		driver.findElement(By.xpath("//div[contains(text(),'Send')]")).click();
		
		
	}

}
