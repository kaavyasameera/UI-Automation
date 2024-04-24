package UI_Automation_Test.test.automation.ui;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import init.browser.BrowserOpen;
import read.data.ReadDataFromPropertiesFile;
import ui.pages.Complete;
import ui.pages.Registration;

public class VerifyNextButtonEnabled {
	// @author: Kaavya
	// @desc: This testcase is used to find out, whether ‘Next’ button is enabled without filling mandatory info.

		WebDriver driver;
		@Test
		public void verifyNextButtonEnabled() throws IOException, InterruptedException
		{
			driver = BrowserOpen.browserOpen();
			Registration register = new Registration();
			if(register.verifyEnabled())
				System.out.println("Next button is enabled without filling mandatory details - Issue");
			else
				System.out.println("Next button is disabled without filling mandatory details");
		}
		
		@AfterMethod
		public void tearDown()
		{
			driver.quit();
		}
}
