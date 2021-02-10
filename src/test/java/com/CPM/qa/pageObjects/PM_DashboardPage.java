package com.CPM.qa.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PM_DashboardPage {
	
	public WebDriver ldriver;
	
	//Constructor
	public PM_DashboardPage(WebDriver rdriver)
	{
		ldriver = rdriver;
		PageFactory.initElements(rdriver,this);
	}
	
	//Capture the Dashboard Element
		@FindBy(xpath = "//h2[normalize-space()='Dashboard']")
		@CacheLookup
		public WebElement txtdash;
		

		// Capture the Application Management Element
		@FindBy(xpath = "//span[contains(text(),'Applicant Management')]")
		@CacheLookup
		public WebElement appManage;

		// ==================Action methods===========================//

		// Click on Application Management Link
		public void clickAppManage() {
			WebDriverWait wait = new WebDriverWait(ldriver, 25);
			wait.until(ExpectedConditions.visibilityOf(appManage));
			appManage.click();
		}
}
