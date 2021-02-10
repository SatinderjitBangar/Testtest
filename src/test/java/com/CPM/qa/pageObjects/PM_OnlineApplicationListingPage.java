package com.CPM.qa.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PM_OnlineApplicationListingPage {

	public WebDriver ldriver;

	// Constructor
	public PM_OnlineApplicationListingPage(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	// capture Our LogOut button
	@FindBy(xpath = "//a[contains(text(),'Logout')]")
	@CacheLookup
	public WebElement logOut;

	// capture Our pensil button
	@FindBy(xpath = "//td[@class='text-start']/button")
	@CacheLookup
	public WebElement editApp;

	// ==================Action methods===========================//

	// Click on LogOut button
	public void clickLogOut() {
		WebDriverWait wait = new WebDriverWait(ldriver, 25);
		wait.until(ExpectedConditions.visibilityOf(logOut));
		logOut.click();
	}

	// Click on pensil icon to edit application button
	public void clickAppEdit() {
		WebDriverWait wait = new WebDriverWait(ldriver, 25);
		wait.until(ExpectedConditions.visibilityOf(editApp));
		wait.until(ExpectedConditions.elementToBeClickable(editApp));
		editApp.click();

	}

}
