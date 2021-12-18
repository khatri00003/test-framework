package com.banking.testCases;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.banking.utilities.ReadConfig;


public class BaseClass {
	ReadConfig RC=new ReadConfig();
	public String baseURL=RC.getApplicationURL();
	public String username=RC.getUsername();
	public String password=RC.getPassword();
	public static WebDriver driver;
	public static Logger logger;
	
	@BeforeClass
	public void Setup() {
		System.setProperty("webdriver.chrome.driver", RC.getChromePath());
		driver = new ChromeDriver();
		logger=Logger.getLogger("ebanking");
		PropertyConfigurator.configure("Log4j.properties");
	}
	
	@AfterClass
	public void teardown() {
		driver.quit();
	}
	
	
}
