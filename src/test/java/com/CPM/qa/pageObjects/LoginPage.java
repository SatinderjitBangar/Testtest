package com.CPM.qa.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	public WebDriver ldriver;
	
	//Constructor
	public LoginPage(WebDriver rdriver)
	{
		ldriver = rdriver;
		PageFactory.initElements(rdriver,this);
	}
	
	//Capture email/user id textbox
	@FindBy(xpath = "//input[@type='email']")
	WebElement txtEmail;
	
	//Capture password textbox
		@FindBy(xpath = "//input[@type='password']")
		WebElement txtpassword;
		
		//Capture Login button
		@FindBy(xpath = "//button[contains(text(),'Login')]")
		WebElement btnLogin;
		
	//Capture Login Heading
	@FindBy(xpath = "//h2[normalize-space()='Login']")
	public WebElement headLogin;
	
	//Capture Error logging in 
	@FindBy(xpath = "//p[@class='auth-error-message s_1']")
	public WebElement headErrorLogin;
	
	//Capture Forgot your Password button
	@FindBy(xpath = "//a[normalize-space()='Forgot Password?']")
	WebElement btnForgot;
	
	//Capture Recover your password Heading
	@FindBy(xpath = "//h2[normalize-space()='Recover Your Password']")
	public WebElement headRecover;
		
	
		
		
		//==========================ACTION METHODS===========================//
		
		//Send username/email to textbox
		public void settxtEmail(String email)
		{
			txtEmail.sendKeys(email);
		}
	
		
		//Send password to password textbox
		public void settxtpassword(String pwd)
		{
			txtpassword.sendKeys(pwd);
		}
		
		//Click on login button
		public void clkbtnLogin()
		{
			btnLogin.click();
		}
		
		//Click on Forgot your Password button
		public void clkbtnForgot()
		{
			btnForgot.click();
		}
}
