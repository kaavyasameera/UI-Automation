package ui.pages;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentTest;

import dev.failsafe.internal.util.Assert;
import init.browser.BrowserOpen;
import read.data.ReadDataFromPropertiesFile;

public class Registration extends BrowserOpen {
	@FindBy(id="emailAddress") WebElement txt_emailId;
	
	@FindBy(xpath="//*[text()='Next']")
	WebElement btn_next;
	
	@FindBy(xpath="//*[contains(text(),'Email address is already registered')]")
	WebElement msg_existingEmail;
	
	@FindBy(id="password") WebElement txt_pwd;
	
	@FindBy(id="confirmPassword") WebElement txt_CnfPwd;

	public Registration() 
	{
		PageFactory.initElements(driver, this);
	}
	
	public void enterEmailAndPassword(String email, String pwd) throws IOException
	{
	txt_emailId.sendKeys(email);
	txt_pwd.sendKeys(pwd);
	txt_CnfPwd.sendKeys(pwd);
	}
	
	public void clickNext() throws IOException
	{
	btn_next.click();
	}
	
	public boolean verifyEnabled() throws IOException
	{
	return btn_next.isEnabled();
	}
	
	
	public void validatevalidEmailId() throws IOException
	{
		if(ReadDataFromPropertiesFile.readDataFromPropertiesFile("InValidEmailAddress").contains("."))
			System.out.println("valid email address entered");
		else
			System.out.println("Entered email id is invalid, Please check the format");	
	}
	
	public void validateExistinguser() throws InterruptedException
	{
		WebElement msg_emailExisted=null;
		try {
			msg_emailExisted = driver.findElement(By.xpath("//*[contains(text(),'Email address is already registered')]"));
		} catch (Exception e) {
			Thread.sleep(3000);
			msg_emailExisted = driver.findElement(By.xpath("//*[contains(text(),'Email address is already registered')]"));
		}
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    wait.until(ExpectedConditions.visibilityOf(msg_emailExisted));
		boolean emailExisted = msg_emailExisted.isDisplayed();
		org.testng.Assert.assertEquals(emailExisted, true);
		System.out.println("TestCase passed, getting email existed error message as expected.");
	}
	
}
