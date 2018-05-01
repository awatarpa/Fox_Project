package com.webdriver.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import io.github.bonigarcia.wdm.FirefoxDriverManager;

public class TestBase {

	public static WebDriver driver;
	
	public static Properties prop;
	
	
	public WebDriver initializeDriver() throws IOException
	{
	    prop=new Properties();
		FileInputStream fis=new FileInputStream("C:\\Users\\awatarparajuli\\eclipse-workspace\\Fox-QA-Assignment\\Resources\\Configuration\\Config.properties");
		prop.load(fis);
		
		String browserName=prop.getProperty("browser");
		
		if (browserName.equals("chrome"))
				{/*System.setProperty("webdriver.chrome.driver", "F:\\Chromedriver\\chromedriver.exe");
				driver=new ChromeDriver();
				driver.manage().window().maximize();*/
				//execute in chromedriver
				}
				
		else if(browserName.equals("IE"))
		{
		//execute in Internet explorer
		}
		else if(browserName.equals("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", "F:\\geckodriver.exe");
			driver=new FirefoxDriver();
			driver.manage().window().maximize();
			//execute in firefox
	    }
		
		driver.get(prop.getProperty("url"));
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		return driver;
	
	}
	
}
