package UI_Automation_Test.test.automation.ui;

import java.io.IOException;
import java.util.LinkedHashSet;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import init.browser.BrowserOpen;
import read.data.ReadDataFromPropertiesFile;
import ui.pages.Complete;
import ui.pages.Registration;

public class VerifyStateDropDownContainsDuplicateValues {
	
	// @author: Kaavya
	// @desc: This testcase is used to find out, whether State dropdown contains duplicate states

	WebDriver driver;
	@Test
	public void verifyRegisterUser() throws IOException, InterruptedException
	{
		driver = BrowserOpen.browserOpen();
		Registration register = new Registration();
		register.enterEmailAndPassword(ReadDataFromPropertiesFile.readDataFromPropertiesFile("InValidEmailAddress"),
				ReadDataFromPropertiesFile.readDataFromPropertiesFile("Password"));
		register.clickNext();
		String username= "kaavya@orikan.com";
        String password= "Kaavya@123";
        String fname= "Kaavya";
        String lname="sameera";
		driver.findElement(By.xpath("//*[@id='firstName']")).sendKeys(fname);
		driver.findElement(By.xpath("//*[@id='lastName']")).sendKeys(lname);
		driver.findElement(By.id("addressLine1")).sendKeys("James nagar");
		driver.findElement(By.id("addressLine2")).sendKeys("14C");
		driver.findElement(By.id("postcode")).sendKeys("502032");
		driver.findElement(By.id("city")).sendKeys("Hyderabad");
		WebElement state= driver.findElement(By.id("state"));
		Select dropdown = new Select(state);
		List<WebElement> states = dropdown.getOptions();
		int statesCountFromDropdown = states.size();
		LinkedHashSet<String> nonDuplicateStates = new LinkedHashSet<String>();
		for(WebElement eachState: states)
		{
			nonDuplicateStates.add(eachState.getText());
		}
		int nonDuplicateStatesCount = nonDuplicateStates.size();
		if(statesCountFromDropdown!=nonDuplicateStatesCount)
			System.out.println("Duplicate states are present in the state dropdown list");
		else
			System.out.println("No Duplicate states are present in the state dropdown list");
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
}
