package com.vmetry.PageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class HomePagePO {

	 	@FindBy(how=How.XPATH, using="html/body/section[1]/div[1]/div/div/div/ul/li[5]/div/a/span[2]")
	 	public WebElement logoutdd;
	 	
	 	@FindBy(how=How.XPATH, using=".//*[@id='header-top']/div/div/div/ul/li[5]/div/ul/li[7]/a")
	 	public WebElement logoutbutton;
	 	
	 	public void clicklogoutbtn() throws InterruptedException{
	 		logoutdd.click();
	 		Thread.sleep(3000);
	 		logoutbutton.click();
	 		Thread.sleep(3000);
	 		
	 	}
	 	
	 	
	 	
	 	@FindBy(how=How.XPATH, using=".//*[@id='main_active_class']/li[2]/a")
	 	public WebElement bloglink;
	 	
	 	public void clickbloglink(){
	 		bloglink.click();
	 	}
	 	
		@FindBy(how=How.XPATH, using="html/body/section[1]/div[1]/div/div/div/ul/li[5]/div/a/span[1]")
		public WebElement dipslayName;
		
		public String getdispName(){
			
			String s=dipslayName.getText();
			return s;
			
			
		}
	 	
	 	
	 	
}