package ui.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import init.browser.BrowserOpen;

public class Complete extends BrowserOpen{
	
	@FindBy(xpath="//*[contains(text(),'successfully registered')]")
	WebElement txt_success;
	
	public Complete() 
	{
		PageFactory.initElements(driver, this);
	}
	
	public void validateUserRegistrationSuccess() throws IOException, InterruptedException
	{
	try {
		if(txt_success.isDisplayed())
			System.out.println("Issue identified -- Without filling mandatory details and able to register user");
	} catch (Exception e) {
		Thread.sleep(2000);
		if(txt_success.isDisplayed())
			System.out.println("Issue identified -- Without filling mandatory details and able to register user");
	} 
	Thread.sleep(3000);
	}
	
}
