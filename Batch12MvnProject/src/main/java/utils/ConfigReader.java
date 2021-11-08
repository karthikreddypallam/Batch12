package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
	
	Properties prop = null;
//	Properties input = null;

	public void readConfig() {
		String filePath = IConstants.env_path;
		File file = new File(filePath);
		FileInputStream fis = null;
		
		prop = new Properties();
		try {
			fis = new FileInputStream(file);
			prop.load(fis);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}

	public String getBrowser() {
		return prop.getProperty("browser");
	}
	
	public String getURL() {
		return prop.getProperty("url");
	}
	
	public String getValidEmail() {
		return prop.getProperty("valid_email");
	}
	
	public String getInvalidEmail() {
		return prop.getProperty("invalid_email");
	}
	
	public String getPwd() {
		return prop.getProperty("valid_pwd");
	}
	
	

}
