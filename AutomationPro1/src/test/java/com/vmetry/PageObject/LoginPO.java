package com.vmetry.PageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginPO {
	@FindBy(how=How.XPATH,using=".//*[@id='email']")//@FindBy is like Static memory
	public WebElement EmailInput;
	public void enterEmailTextbox(String uname)
	{
		
		EmailInput.sendKeys(uname);
	}
	
	@FindBy(how=How.XPATH, using=".//*[@id='password']")
	public WebElement PasswordInput;
	public void enterPwordTextbox(String pword)
	{
		
		PasswordInput.sendKeys(pword);
	}

	
	@FindBy(how=How.XPATH, using=".//*[@id='login-submit']")
	public WebElement LoginButton;
	public void clickLoginButton()
	{
		LoginButton.click();
	}
	
	@FindBy(how=How.LINK_TEXT, using="Forgot Password")
	public WebElement forgotlink;
	public void clickforgotpasslink()
	{ 	
		forgotlink.click();
	}
	
	
	@FindBy(how=How.LINK_TEXT, using="Login")
	public WebElement loginlink;
	public void clickloginlink()
	{ 	
		loginlink.click();
	}   


	

}
