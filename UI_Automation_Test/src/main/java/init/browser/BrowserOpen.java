package init.browser;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import read.data.ReadDataFromPropertiesFile;

public class BrowserOpen 
{
	public static WebDriver driver;

	public static WebDriver browserOpen() throws IOException
	{
		driver = new ChromeDriver(); 
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Long.parseLong(ReadDataFromPropertiesFile.readDataFromPropertiesFile("implicitWait")), TimeUnit.SECONDS);
		driver.get(ReadDataFromPropertiesFile.readDataFromPropertiesFile("url"));	
		return driver;
	}

	
}
