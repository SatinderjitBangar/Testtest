package com.CPM.qa.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SignUpPage {
	
	public WebDriver ldriver;
	
	//Constructor
	public SignUpPage(WebDriver rdriver)
	{
		ldriver = rdriver;
		PageFactory.initElements(rdriver,this);
	}
	
	// Capture the SignUp  heading 
	@FindBy(xpath = "//h2[normalize-space()='Sign Up']")
	@CacheLookup
	public WebElement headSignUp;
	
	// Capture the FullName text box 
	@FindBy(xpath = "//input[@placeholder='Full Name']")
	@CacheLookup
	public WebElement txtFullName;
	
	// Capture the e-mail text box 
	@FindBy(xpath = "//input[@placeholder='Email Address']")
	@CacheLookup
	public WebElement txtemail;
	
	// Capture the New Password text box 
	@FindBy(xpath = "//input[@placeholder='New Password']")
	@CacheLookup
	public WebElement txtNewPass;
	
	// Capture the Confirm Password text box 
	@FindBy(xpath = "//input[@placeholder='Confirm Password']")
	@CacheLookup
	public WebElement txtConPass;
	
	// Capture the Register button
	@FindBy(xpath = "//button[@class='button s_1']")
	@CacheLookup
	public WebElement btnRegister;
	
	// Capture the Success! Check your e-mail message
	@FindBy(xpath = "//div[@class='register-success df jcc aic']")
	@CacheLookup
	public WebElement regSuccess;
	
	// Capture the Sign in link
	@FindBy(xpath = "//a[normalize-space()='Sign in']")
	@CacheLookup
	public WebElement lnkSignin;
	
	
	
	
	//Click on Register button
	public void clkbtnRegister() {
		WebDriverWait wait = new WebDriverWait(ldriver, 25);
		wait.until(ExpectedConditions.visibilityOf(btnRegister));
		wait.until(ExpectedConditions.elementToBeClickable(btnRegister));
		btnRegister.click();
	}
	
	//Set Full Name text box
	public void settxtFullName(String fullName) {
		WebDriverWait wait = new WebDriverWait(ldriver, 25);
		wait.until(ExpectedConditions.visibilityOf(txtFullName));
		wait.until(ExpectedConditions.elementToBeClickable(txtFullName));
		txtFullName.clear();
		txtFullName.sendKeys(fullName);
	}
	
	//Set e-mail text box
	public void settxtemail(String email) {
		WebDriverWait wait = new WebDriverWait(ldriver, 25);
		wait.until(ExpectedConditions.visibilityOf(txtemail));
		wait.until(ExpectedConditions.elementToBeClickable(txtemail));
		txtemail.clear();
		txtemail.sendKeys(email);
		}
	
	//Set New Password text box
	public void settxtNewPass(String newPass) {
		WebDriverWait wait = new WebDriverWait(ldriver, 25);
		wait.until(ExpectedConditions.visibilityOf(txtNewPass));
		wait.until(ExpectedConditions.elementToBeClickable(txtNewPass));
		txtNewPass.clear();
		txtNewPass.sendKeys(newPass);
		}
	
	//Set Confirm Password text box
	public void settxtConPass(String conPass) {
		WebDriverWait wait = new WebDriverWait(ldriver, 25);
		wait.until(ExpectedConditions.visibilityOf(txtConPass));
		wait.until(ExpectedConditions.elementToBeClickable(txtConPass));
		txtConPass.clear();
		txtConPass.sendKeys(conPass);
		}
	
	//Click on Register button
	public void clklnkSignin() {
		WebDriverWait wait = new WebDriverWait(ldriver, 25);
		wait.until(ExpectedConditions.visibilityOf(lnkSignin));
		wait.until(ExpectedConditions.elementToBeClickable(lnkSignin));
		lnkSignin.click();
		}
}
