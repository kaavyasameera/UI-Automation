package UI_Automation_Test.test.automation.ui;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import init.browser.BrowserOpen;
import read.data.ReadDataFromPropertiesFile;
import ui.pages.Complete;
import ui.pages.Registration;

public class UserRegistrationWithoutFillingMandatoryDetails {
	
	// @author: Kaavya
	// @desc: This testcase is used to find out, when user clicks on ‘Next’ button continuously on ‘Registration’ page, without filling mandatory information, page is redirecting to Next Pages (Contact/Payment/T&C/ Complete). Getting user account added successful message also.

	WebDriver driver;
	@Test
	public void verifyRegisterUser() throws IOException, InterruptedException
	{
		driver = BrowserOpen.browserOpen();
		Registration register = new Registration();
		register.enterEmailAndPassword(ReadDataFromPropertiesFile.readDataFromPropertiesFile("InValidEmailAddress"),
				ReadDataFromPropertiesFile.readDataFromPropertiesFile("Password"));
		for(int i=1; i<5; i++)
		register.clickNext();
		Complete cmp = new Complete();
		cmp.validateUserRegistrationSuccess();
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
}
