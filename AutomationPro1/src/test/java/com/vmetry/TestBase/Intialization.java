package com.vmetry.TestBase;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;

import atu.testng.reports.ATUReports;


public class Intialization{
	
	
	public static WebDriver wd=null;
	
	
	
	public static void start() throws IOException{
		System.setProperty("atu.reporter.config",System.getProperty("user.dir")+"//lib//atu.properties");
		ATUReports.setWebDriver(wd);
		ATUReports.indexPageDescription="Functional Reports";
		
		File f=new File(System.getProperty("user.dir")+"\\src\\"
				+ "test\\resources\\config\\config.properties");
		FileInputStream fis=new FileInputStream(f);
		Properties pr=new Properties();
		pr.load(fis);
			
		
		if(pr.getProperty("browser").equalsIgnoreCase("firefox")){
			
			
		wd=new FirefoxDriver();
		}
		else if(pr.getProperty("browser").equals("IE")){
			
			System.setProperty("webdriver.ie.driver", "exefile");
		wd=new InternetExplorerDriver();
		}
		else if(pr.getProperty("browser").equals("chrome")){
			
			System.setProperty("webdriver.chrome.driver", "exefile");
			wd=new ChromeDriver();
		}
		
		wd.get(pr.getProperty("TestingUrl"));
		
		
		
	}
	
	
	
	
	
	
	
	
}