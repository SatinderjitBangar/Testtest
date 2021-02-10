package com.CPM.qa.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LandingPage {

	public WebDriver ldriver;
	
	// Constructor
	public LandingPage(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	// Capture the Login Here button
	@FindBy(xpath = "//p[contains(text(),'Login here')]")
	@CacheLookup
	WebElement btnLoginhere;
	
	// Capture the Get Started button
	@FindBy(xpath = "//*[@id=\"app\"]/div/div/div/div[2]/button")
	@CacheLookup
	WebElement btnGetStarted;
	
	// Capture Forward Play Button 
	@FindBy(xpath = "//button[contains(text(),'▶')]")
	@CacheLookup
	WebElement btnFwdPlay;
	
	// Capture Back Play Button 
	@FindBy(xpath = "//button[contains(text(),'◀')]")
	@CacheLookup
	WebElement btnBckPlay;
	
	// Capture Apply Button 
	@FindBy(xpath = "//div[@class='VueCarousel-inner']//div[1]//a[1]//span[1]")
	@CacheLookup
	WebElement btnApply;
	
	// Capture Back To Search Button 
	@FindBy(xpath = "//p[@class='back-to-search']")
	@CacheLookup
	WebElement btnBckToSrch;
		
	
	// Capture the 'Where would you like to search? location text box
	@FindBy(xpath = "//div[@class='box df fdc jcc aic padded-box search-box posrel']//input")
	@CacheLookup
	public WebElement txtSearchLoc;
	
	// Capture the heading 
	@FindBy(xpath = "//div[@class='box df fdc jcc aic padded-box search-box posrel']//h2")
	public WebElement headRenting;
	
	// Capture the Search Result heading 
	@FindBy(xpath = "//h2[normalize-space()='Search Results']")
	@CacheLookup
	public WebElement headSearchRes;
	
	// Capture the Details "bedroom-bathroom-garage"  first slide from search result  
	@FindBy(xpath = "//div[@class='VueCarousel-inner']//div[1]//span[2]")
	@CacheLookup
	public WebElement detailsSearchRes;
	
	// Capture the rate per month first slide from search result  
	@FindBy(xpath = "//div[@class='VueCarousel-inner']//div[1]//span[5]")
	@CacheLookup
	public WebElement ratePerMonth;
	
	// Capture Number of Bedrooms search result filter  
	@FindBy(xpath = "//*[@id=\"app\"]/div/div/div/div[1]/div/select[1]")
	@CacheLookup
	public WebElement numBed;
	
	// Capture Number of Bathroom search result filter  
	@FindBy(xpath = "//*[@id=\"app\"]/div/div/div/div[1]/div/select[2]")
	@CacheLookup
	public WebElement numBath;
	
	// Capture Number of Garage search result filter  
	@FindBy(xpath = "//*[@id=\"app\"]/div/div/div/div[1]/div/select[3]")
	@CacheLookup
	public WebElement numGarage;
	
	// Capture Minimum search result filter  
	@FindBy(xpath = "//*[@id=\"app\"]/div/div/div/div[1]/div/select[4]")
	@CacheLookup
	public WebElement MinRate;
	
	// Capture Maximum Rate search result filter  
	@FindBy(xpath = "//*[@id=\"app\"]/div/div/div/div[1]/div/select[5]")
	@CacheLookup
	public WebElement MaxRate;
	
	//Capture next active slide
	@FindBy(xpath = "//*[@id=\"app\"]/div/div/div/div/div[1]/div/div[@class=\"VueCarousel-slide search-result df fdc VueCarousel-slide-active VueCarousel-slide-center\"]")
	@CacheLookup
	public WebElement activeSld;
	
	// Capture the Details "bedroom-bathroom-garage" Active slide from search result  
	@FindBy(xpath = "//div[@class='VueCarousel-slide search-result df fdc VueCarousel-slide-active VueCarousel-slide-center']//span[2]")
	@CacheLookup
	public WebElement bbgActiveSld;
		
	// Capture the rate per month Active slide from search result  
	@FindBy(xpath = "//div[@class='VueCarousel-slide search-result df fdc VueCarousel-slide-active VueCarousel-slide-center']//span[@class='unit_price']")
	@CacheLookup
	public WebElement rateActiveSld;
	
	// Capture the Property Image of Active slide from search result  
	@FindBy(xpath = "//div[@class='VueCarousel-slide search-result df fdc VueCarousel-slide-active VueCarousel-slide-center']//img")
	@CacheLookup
	public WebElement imgActiveSld;
	
	// Capture the address of Active slide from search result  
	@FindBy(xpath = "//div[@class='VueCarousel-slide search-result df fdc VueCarousel-slide-active VueCarousel-slide-center']//span[3]")
	@CacheLookup
	public WebElement addActiveSld;
		
	// Capture the city of Active slide from search result  
	@FindBy(xpath = "//div[@class='VueCarousel-slide search-result df fdc VueCarousel-slide-active VueCarousel-slide-center']//span[4]")
	@CacheLookup
	public WebElement cityActiveSld;
	
	// Capture the Unit name and size of Active slide from search result  
	@FindBy(xpath = "//div[@class='VueCarousel-slide search-result df fdc VueCarousel-slide-active VueCarousel-slide-center']//span[@class='unit_name']")
	@CacheLookup
	public WebElement nameActiveSld;
		
	
		
	
	// ====================ACTION METHODS==========================//
	
	//Click on Login button
	public void clkbtnLogin() {
		WebDriverWait wait = new WebDriverWait(ldriver, 25);
		wait.until(ExpectedConditions.visibilityOf(btnLoginhere));
		wait.until(ExpectedConditions.elementToBeClickable(btnLoginhere));
		btnLoginhere.click();
	}
	
	//Click on Get Started button
	public void clkbtnGetStarted() {
		WebDriverWait wait = new WebDriverWait(ldriver, 25);
		wait.until(ExpectedConditions.visibilityOf(btnGetStarted));
		wait.until(ExpectedConditions.elementToBeClickable(btnGetStarted));
		btnGetStarted.click();
	}
	
	//Click on Apply button
	public void clkbtnApply() {
		WebDriverWait wait = new WebDriverWait(ldriver, 25);
		wait.until(ExpectedConditions.visibilityOf(btnApply));
		wait.until(ExpectedConditions.elementToBeClickable(btnApply));
		btnApply.click();
		}
	
	//Click on Back To search button
	public void clkbtnBckToSrch() {
		WebDriverWait wait = new WebDriverWait(ldriver, 25);
		wait.until(ExpectedConditions.visibilityOf(btnBckToSrch));
		wait.until(ExpectedConditions.elementToBeClickable(btnBckToSrch));
		btnBckToSrch.click();
		}
	
	//Click on Forward Play button on search results 
	public void clkbtnFwdPlay() {
		
		WebDriverWait wait = new WebDriverWait(ldriver, 25);
		wait.until(ExpectedConditions.visibilityOf(btnFwdPlay));
		wait.until(ExpectedConditions.elementToBeClickable(btnFwdPlay));
		btnFwdPlay.click();
		}
	
	//Click on Back Play button on search results 
	public void clkbtnBckPlay() {
			
		WebDriverWait wait = new WebDriverWait(ldriver, 25);
		wait.until(ExpectedConditions.visibilityOf(btnBckPlay));
		wait.until(ExpectedConditions.elementToBeClickable(btnBckPlay));
		btnBckPlay.click();
		}

	
	//Set the 'Where would you like to search? location text box
	public void settxtSearchLoc(String location) {
		WebDriverWait wait = new WebDriverWait(ldriver, 25);
		wait.until(ExpectedConditions.visibilityOf(txtSearchLoc));
		wait.until(ExpectedConditions.elementToBeClickable(txtSearchLoc));
		txtSearchLoc.clear();
		txtSearchLoc.sendKeys(location);
	}

	//Set search filters No. of Bedrooms/Bathrooms/Garage/Minimum Rate/Maximum Rate
	public void setSrchFilters(String bed,String bath,String garage,String minRate,String maxRate) {
		WebDriverWait wait = new WebDriverWait(ldriver, 25);
		wait.until(ExpectedConditions.visibilityOf(numBed));
		wait.until(ExpectedConditions.elementToBeClickable(numBed));
		//Set Number of bedrooms
		Select drpBed = new Select(numBed);
		drpBed.selectByVisibleText(bed);
						
		wait.until(ExpectedConditions.visibilityOf(numBath));
		wait.until(ExpectedConditions.elementToBeClickable(numBath));
		//Set Number of bathrooms
		Select drpBath = new Select(numBath);
		drpBath.selectByVisibleText(bath);
			
		wait.until(ExpectedConditions.visibilityOf(numGarage));
		wait.until(ExpectedConditions.elementToBeClickable(numGarage));
		//Set Number of Garages
		Select drpGarage = new Select(numGarage);
		drpGarage.selectByVisibleText(garage);
			
		wait.until(ExpectedConditions.visibilityOf(MinRate));
		wait.until(ExpectedConditions.elementToBeClickable(MinRate));
		//Set Minimum rate
		Select drpMinRate = new Select(MinRate);
		drpMinRate.selectByVisibleText(minRate);
			
		wait.until(ExpectedConditions.visibilityOf(MaxRate));
		wait.until(ExpectedConditions.elementToBeClickable(MaxRate));
		//Set Minimum rate
		Select drpMaxRate = new Select(MaxRate);
		drpMaxRate.selectByVisibleText(maxRate);
		
		}
	
	//Verify the search filter options
	public boolean verifySrchFilter(String bed,String bath,String garage,String minRate,String maxRate) {
		
		WebDriverWait wait = new WebDriverWait(ldriver, 25);
		wait.until(ExpectedConditions.visibilityOf(numBed));
		wait.until(ExpectedConditions.elementToBeClickable(numBed));
		//Get text of currently selected Number of bedrooms
		Select drpBed = new Select(numBed);
		String selBed = drpBed.getFirstSelectedOption().getText();
		
		wait.until(ExpectedConditions.visibilityOf(numBath));
		wait.until(ExpectedConditions.elementToBeClickable(numBath));
		//Get text of currently selected Number of bathrooms
		Select drpBath = new Select(numBath);
		String selBath = drpBath.getFirstSelectedOption().getText();
		
		wait.until(ExpectedConditions.visibilityOf(numGarage));
		wait.until(ExpectedConditions.elementToBeClickable(numGarage));
		//Get text of currently selected Number of Garages
		Select drpGarage = new Select(numGarage);
		String selGarage = drpGarage.getFirstSelectedOption().getText();
		
		wait.until(ExpectedConditions.visibilityOf(MinRate));
		wait.until(ExpectedConditions.elementToBeClickable(MinRate));
		//Get text of currently selected Minimum rate
		Select drpMinRate = new Select(MinRate);
		String selMinRate = drpMinRate.getFirstSelectedOption().getText();
		
		wait.until(ExpectedConditions.visibilityOf(MaxRate));
		wait.until(ExpectedConditions.elementToBeClickable(MaxRate));
		//Get text of currently selected Maximum rate
		Select drpMaxRate = new Select(MaxRate);
		String selMaxRate = drpMaxRate.getFirstSelectedOption().getText();
		
		if(selBed.equals(bed) && selBath.equals(bath) && selGarage.equals(garage) && selMinRate.equals(minRate) && selMaxRate.equals(maxRate)){
			
			return true;
			
		}
		else
		{
			return false;
		}
		
	}
	
	//Verify next search result is displayed with image and details
	public boolean verifyNxtRes() {
			
		WebDriverWait wait = new WebDriverWait(ldriver, 25);
		wait.until(ExpectedConditions.visibilityOf(activeSld));
		wait.until(ExpectedConditions.visibilityOf(imgActiveSld));
		wait.until(ExpectedConditions.visibilityOf(addActiveSld));
		wait.until(ExpectedConditions.visibilityOf(cityActiveSld));
		wait.until(ExpectedConditions.visibilityOf(nameActiveSld));
		wait.until(ExpectedConditions.visibilityOf(bbgActiveSld));
		wait.until(ExpectedConditions.visibilityOf(rateActiveSld));
		
		//Verify if Next Slide, Property Image, No. Bedroom/Bathroom/Garage,size,location is displayed
		if(nameActiveSld.isDisplayed() && cityActiveSld.isDisplayed() && addActiveSld.isDisplayed() && imgActiveSld.isDisplayed() && activeSld.isDisplayed() && bbgActiveSld.isDisplayed() && rateActiveSld.isDisplayed())
		{
			return true;
		}
		else
		{
			return false;
		}
					
			
		}
	
	//Verify if the heading on page matches with expected heading
		public Boolean verifyHead(String expHead) {
			WebDriverWait wait = new WebDriverWait(ldriver, 25);
			wait.until(ExpectedConditions.visibilityOf(headRenting));
			if(headRenting.isDisplayed() && headRenting.getText().equals(expHead))
			{
				return true;
			}
			else
			{
				return false;
			}
		}

}
