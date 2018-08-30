package com.google.gmailAutomation.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.gmailAutomation.util.TestUtil;


public class TestBase {
	
	public static WebDriver driver;
	public static Properties prop;
	public static WebDriverWait waitObj;
	
	public TestBase() {		
		try {
			prop = new Properties();
			FileInputStream in = new FileInputStream(System.getProperty("user.dir")
					+ "/src/main/java/com/google/gmailAutomation/config/config.properties");
			prop.load(in);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void initialization() {
		String browserName = prop.getProperty("browser");
		if(browserName.equals("chrome")) {
			driver = new ChromeDriver();
		}else if(browserName.equals("FF")) {
			driver = new FirefoxDriver();
		}
		
		driver.manage().deleteAllCookies();
		driver.get(prop.getProperty("URL"));
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIME, TimeUnit.SECONDS);
		waitObj = new WebDriverWait(driver, 15);
	}

}
