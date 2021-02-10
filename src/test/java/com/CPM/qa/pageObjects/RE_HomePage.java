package com.CPM.qa.pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RE_HomePage {
	
	public WebDriver ldriver;
	
	//Constructor
		public RE_HomePage(WebDriver rdriver)
		{
			ldriver = rdriver;
			PageFactory.initElements(rdriver,this);
		}

		
	//Capture the Home Element
		@FindBy(xpath = "//h2[contains(text(),'Home')]")
		@CacheLookup
		public WebElement txtHome;
		
		//Capture the heading in the logged in page
		@FindBy(xpath="//h2[contains(text(),'Personal Info')]")
		@CacheLookup
		public WebElement txtPersonalInfo;
		
		
		
		
				
				
		//=============ACTION METHODS=================//
		public String gettxtHome()
		{
			WebDriverWait wait = new WebDriverWait(ldriver, 20);
			wait.until(ExpectedConditions.visibilityOf(txtHome));
			return txtHome.getText();
		}
		
		public String gettxtPersonalInfo()
		{
			WebDriverWait wait = new WebDriverWait(ldriver, 20);
			wait.until(ExpectedConditions.visibilityOf(txtPersonalInfo));
			return txtPersonalInfo.getText();
		}
		
		
}

