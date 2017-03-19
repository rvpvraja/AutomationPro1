package com.vmetry.Pagetest;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.vmetry.PageObject.HomePagePO;
import com.vmetry.PageObject.LoginPO;
import com.vmetry.TestBase.Intialization;
import com.vmetry.testutill.TestutilityClass;

import atu.testng.reports.listeners.*;


@Listeners({ConfigurationListener.class,MethodListener.class,ATUReportsListener.class})
public class LoginPageTest extends Intialization{
	
	public static LoginPO lp=null;
	public static HomePagePO hp=null;
	@BeforeClass
	public void BfrClass() throws IOException
	{
		start();
		wd.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		lp = PageFactory.initElements(wd, LoginPO.class);
		hp = PageFactory.initElements(wd, HomePagePO.class);
		
		
	}
	@Test(dataProvider="xxx")
	public void login(String tcid,String username, String password, String type) throws InterruptedException, IOException
	{
	
		lp.clickloginlink();
		lp.enterEmailTextbox(username);
		lp.enterPwordTextbox(password);
		lp.clickLoginButton();
		
		TestutilityClass.takesnapshot(tcid);
		
		
		if(type.equals("valid")){
			//Hard Assert
			//Assert.assertEquals(hp.getdispName(), "Hi Ra ja !");
			//softassert
			SoftAssert sf=new SoftAssert();
			sf.assertEquals(hp.getdispName(), "Hi Ra ja !");
			Thread.sleep(5000);
			hp.clicklogoutbtn();
			Thread.sleep(4000);
			sf.assertAll();
		}
		
		
			
	}

	
	@AfterClass
	public void AftrClass()
	{
//		wd.close();
		
		System.out.println("login after class finished");
	}
	@DataProvider(name="xxx")
	public static Object[][] table() throws IOException
	{
		
		
		if(TestutilityClass.isrunmode("Login")==true){
			Object[][] obj=TestutilityClass.getExcelData("Login");
			return obj;
		//wd.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS)
	}
		return null;
		}
	

}
