package UI_Automation_Test.test.automation.ui;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import init.browser.BrowserOpen;
import read.data.ReadDataFromPropertiesFile;
import ui.pages.Registration;

public class EmailIdvalidation {
	
	// @author: Kaavya
	// @desc: This test case is used to find out the entered email is valid or not.

	WebDriver driver;
	@Test
	public void validateEmailAddress() throws IOException
	{
		driver = BrowserOpen.browserOpen();
		Registration register = new Registration();
		register.enterEmailAndPassword(ReadDataFromPropertiesFile.readDataFromPropertiesFile("InValidEmailAddress"),
				ReadDataFromPropertiesFile.readDataFromPropertiesFile("Password"));
		register.validatevalidEmailId();
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
}
