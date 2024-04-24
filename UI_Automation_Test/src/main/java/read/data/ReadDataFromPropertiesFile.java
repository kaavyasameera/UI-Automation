package read.data;

import java.io.File;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadDataFromPropertiesFile 
{
	public static String readDataFromPropertiesFile(String key) throws IOException
	{
		FileInputStream path = new FileInputStream("./DataFiles/commonData.properties");
		Properties prop = new Properties();
		prop.load(path);
		return prop.getProperty(key);
	}
}
