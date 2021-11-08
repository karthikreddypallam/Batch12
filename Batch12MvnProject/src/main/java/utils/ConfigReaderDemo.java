package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReaderDemo {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		String filePath = "/Users/karthikreddy/eclipseWorkspace/eclipse-workspace/Batch12MvnProject/src/test/resources/env.properties";
		File file = new File(filePath);
		FileInputStream fis = new FileInputStream(file);
		
		Properties prop = new Properties();
		prop.load(fis);
		
		System.out.println(prop.getProperty("platform"));
		System.out.println(prop.getProperty("browser"));
		System.out.println(prop.getProperty("version"));
		System.out.println(prop.getProperty("url"));

		
		

	}

}
