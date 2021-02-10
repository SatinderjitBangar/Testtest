package com.CPM.qa.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PM_ManageApplicantPage {

	public WebDriver ldriver;

	// Constructor
	public PM_ManageApplicantPage(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	// capture Applicant Management button
	@FindBy(xpath = "//h2[contains(text(),'Applicant Management')]")
	@CacheLookup
	public WebElement appManagement;

	// capture Employment History button
	@FindBy(xpath = "//h3[contains(text(),'Employment History')]")
	@CacheLookup
	public WebElement empHistory;

	// capture Employment History Company
	@FindBy(xpath = "//span[contains(text(),'Company')]")
	@CacheLookup
	public WebElement company;

	// capture Employment History Position
	@FindBy(xpath = "//span[contains(text(),'Position')]")
	@CacheLookup
	public WebElement position;

	// capture Employment History End Date
	@FindBy(xpath = "//span[contains(text(),'End Date')]")
	@CacheLookup
	public WebElement endDate;

	// capture Employment History Salary
	@FindBy(xpath = "//span[contains(text(),'Salary')]")
	@CacheLookup
	public WebElement salary;

	// capture Banking Reference
	@FindBy(xpath = "//h3[contains(text(),'Banking Reference')]")
	@CacheLookup
	public WebElement bankRef;

	// capture Bank Name
	@FindBy(xpath = "//span[contains(text(),'Bank Name')]")
	@CacheLookup
	public WebElement bankName;

	// capture Checking Account
	@FindBy(xpath = "//span[contains(text(),'Checking Account #')]")
	@CacheLookup
	public WebElement checkAccount;

	// capture Savings Account
	@FindBy(xpath = "//span[contains(text(),'Savings Account #')]")
	@CacheLookup
	public WebElement savingAccount;

	// capture phone
	@FindBy(xpath = "//span[contains(text(),'Bank Name')]//following-sibling::span[contains(text(),'Phone')]")
	@CacheLookup
	public WebElement phone;

	// ==================Action methods===========================//

	// Click on Employment History
	public void clickEmpHistory() {
		WebDriverWait wait = new WebDriverWait(ldriver, 25);
		wait.until(ExpectedConditions.visibilityOf(empHistory));
		empHistory.click();
	}

	// Click on Banking Reference
	public void clickBankRef() {
		WebDriverWait wait = new WebDriverWait(ldriver, 25);
		wait.until(ExpectedConditions.visibilityOf(bankRef));
		bankRef.click();
	}

}
