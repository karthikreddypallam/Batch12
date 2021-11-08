package utils;

public interface IConstants {
	String input_path = System.getProperty("user.dir")+"/src/test/resources/input.properties";
	String env_path = System.getProperty("user.dir")+"/src/test/resources/env.properties";
	String chromeDriverPath = System.getProperty("user.dir")+"/src/main/resources/drivers/chromedriver";
	String firefoxDriverPath = System.getProperty("user.dir")+"/src/main/resources/drivers/geckodriver";
	String failedScreenshots = System.getProperty("user.dir")+"/target/failedscreenshot.png";
	String edgeDriverPath = System.getProperty("user.dir")+"/src/main/resources/drivers/geckodriver";

}
