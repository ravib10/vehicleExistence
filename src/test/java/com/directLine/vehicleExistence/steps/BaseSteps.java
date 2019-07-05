package com.directLine.vehicleExistence.steps;

import com.directLine.vehicleExistence.ExtentListeners.ExtentTestManager;
import com.directLine.vehicleExistence.utilities.DriverFactory;
import com.directLine.vehicleExistence.utilities.DriverManager;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class BaseSteps {

	private WebDriver driver;


	private Properties Config = new Properties();
	private FileInputStream fis;
	public Logger log = Logger.getLogger(BaseSteps.class);

	public Properties getConfig() {
		return Config;
	}
	public void setUpFramework() {

		configureLogging();
		DriverFactory.setConfigPropertyFilePath(
				System.getProperty("user.dir") + "//src//test//resources//properties//Config.properties");

		try {
			fis = new FileInputStream(DriverFactory.getConfigPropertyFilePath());
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			Config.load(fis);
			log.info("Config properties file loaded");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		;

	}

//	public void logInfo(String message) {
//
//		ExtentTestManager.testReport.get().info(message);
//	}

	public void configureLogging() {
		String log4jConfigFile = System.getProperty("user.dir") + File.separator + "src/test/resources/properties" + File.separator
				+ "log4j.properties";
		PropertyConfigurator.configure(log4jConfigFile);
	}


	public void openBrowser(String browser) {
		
		if (browser.equals("chrome")) {
			System.out.println("Launching : " + browser);
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (browser.equals("firefox")) {
			System.out.println("Launching : " + browser);
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
					}

		DriverManager.setWebDriver(driver);
		log.info("Driver Initialized !!!");
		DriverManager.getDriver().manage().window().maximize();
		DriverManager.getDriver().manage().timeouts().implicitlyWait(Long.parseLong(Config.getProperty("implicit.wait")), TimeUnit.SECONDS);
	}

	public void quit() {

		DriverManager.getDriver().quit();
		log.info("Test Execution Completed !!!");
	}

}
