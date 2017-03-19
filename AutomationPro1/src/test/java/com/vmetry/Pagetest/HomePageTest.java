package com.vmetry.Pagetest;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.vmetry.PageObject.HomePagePO;
import com.vmetry.PageObject.LoginPO;
import com.vmetry.TestBase.Intialization;

public class HomePageTest extends Intialization {


	public static HomePagePO hp=null;
	public static LoginPO lp=null;
	
	@BeforeClass
	public void bfrcls(){
		
		
		lp = PageFactory.initElements(wd, LoginPO.class);
		hp = PageFactory.initElements(wd, HomePagePO.class);
		
	}
	
	@Test(enabled=false)
	public void Bloglink(){
		
		hp.clickbloglink();
	}
	
	@AfterClass
	public void aftclass(){
		wd.close();
		
	}
}
