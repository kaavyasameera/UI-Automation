package UI_Automation_Test.test.automation.ui;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import init.browser.BrowserOpen;
import read.data.ReadDataFromPropertiesFile;
import ui.pages.Registration;

public class VerifyingExistingUser {
	
	// @author: Kaavya
	// @desc: This test case is used to find out display of existing user validation message, when trying to register with existing user
	WebDriver driver;
	@Test
	public void verifyExistingUser() throws IOException, InterruptedException
	{
		driver = BrowserOpen.browserOpen();
		Registration register = new Registration();
		register.enterEmailAndPassword(ReadDataFromPropertiesFile.readDataFromPropertiesFile("validEmailAddress"),
				ReadDataFromPropertiesFile.readDataFromPropertiesFile("Password"));
		register.clickNext();
		register.validateExistinguser();
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
}
