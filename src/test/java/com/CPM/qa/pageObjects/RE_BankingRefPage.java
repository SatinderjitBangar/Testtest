package com.CPM.qa.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RE_BankingRefPage {

public WebDriver ldriver;
	
	//Constructor
	public RE_BankingRefPage(WebDriver rdriver)
	{
		ldriver = rdriver;
		PageFactory.initElements(rdriver,this);
	}
	
	
	// Capture Bank Name text box for Banking Reference 1
	@FindBy(xpath = "//div[@class='wrapper df'][1]/div[1]/span[1]//input")
	public WebElement txtBankNameRef1;
	
	// Capture Bank Address text box for Banking Reference 1
	@FindBy(xpath = "//div[@class='wrapper df'][1]/div[1]/span[2]//input")
	public WebElement txtBankAddRef1;
	
	// Capture Bank City text box for Banking Reference 1
	@FindBy(xpath = "//div[@class='wrapper df'][1]/div[1]/span[3]//input")
	public WebElement txtBankCityRef1;
	
	// Capture Bank Zip code text box for Banking Reference 1
	@FindBy(xpath = "//div[@class='wrapper df'][1]/div[1]/span[5]//input")
	public WebElement txtBankZipRef1;
		
	// Capture Bank State text box for Banking Reference 1
	@FindBy(xpath = "//div[@class='wrapper df'][1]/div[1]/span[4]//input")
	public WebElement txtBankStateRef1;
	
	// Capture Bank Phone text box for Banking Reference 1
	@FindBy(xpath = "//div[@class='wrapper df'][1]/div[1]/span[6]//input")
	public WebElement txtBankPhoneRef1;
	
	// Capture Bank Account Number text box for Banking Reference 1
	@FindBy(xpath = "//div[@class='wrapper df'][1]/div[2]/span[2]//input")
	public WebElement txtBankAccRef1;
		
	// Capture Bank Account Balance text box for Banking Reference 1
	@FindBy(xpath = "//div[@class='wrapper df'][1]/div[2]/span[3]//input")
	public WebElement txtBankBalRef1;
	
	// Capture Checking or saving account menu for Banking Reference 1
	@FindBy(xpath = "//div[@class='wrapper df'][1]/div[2]/span[1]/div/div")
	public WebElement drpBankCorSRef1;
	
	// Capture Checking  account option for Banking Reference 1
	@FindBy(xpath = "//div[@class='v-menu__content theme--light menuable__content__active']/div/div[1]/div/div")
	public WebElement drpBankChkRef1;
	
	// Capture Savings account option for Banking Reference 1
	@FindBy(xpath = "//div[@class='v-menu__content theme--light menuable__content__active']/div/div[2]/div/div")
	public WebElement drpBankSavRef1;
	
	// Capture Currently selected Checking or saving account menu for Banking Reference 1
	@FindBy(xpath = "//div[@class='wrapper df'][1]/div[2]/span[1]/div/div/div/div[1]/div[1]/div[1]/div")
	public WebElement drpBankCorSCurRef1;
	
	// Capture Delete button for Banking Reference 1
	@FindBy(xpath = "//div[@class='wrapper df'][1]/div[1]/h3//span[2]")
	public WebElement btnDelBankRef1;
	
	//Capture the Next button 
	@FindBy(xpath="//span[normalize-space()='NEXT']")
	@CacheLookup
	public WebElement btnNxt;
	
	//Capture the Add Banking Reference Button
	@FindBy(xpath="//span[contains(@class,'add-reference button')]")
	@CacheLookup
	public WebElement btnAddRef;

	
	
	//========================ACTION METHODS========================//
	
	//Verify Banking Reference tab is displayed and selected
	public Boolean dispBankRef() {
		WebDriverWait wait = new WebDriverWait(ldriver, 25);
		 ExpectedCondition<Boolean> expectation = new
		            ExpectedCondition<Boolean>() {
		                public Boolean apply(WebDriver driver) {
		                    return driver.findElement(By.xpath("//a[contains(@class,'v-tab')][5]")).getAttribute("aria-selected").equals("true");
		                }
		 	};
		wait.until(expectation);
		return true;
		}
	
	//Set the Bank Name text box for Banking Reference 1
	
	public void settxtBankNameRef1(String bName)  {
		
		
		WebDriverWait wait = new WebDriverWait(ldriver, 1);
		 ExpectedCondition<Boolean> expectation = new
		            ExpectedCondition<Boolean>() {
		                public Boolean apply(WebDriver driver) {
		                    return driver.findElement(By.xpath("//div[@class='wrapper df'][1]/div[1]/span[1]//input")).getAttribute("value").length() !=0;
		                }
	};
	
	try {
        wait.until(expectation);
        txtBankNameRef1.click();
        txtBankNameRef1.sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.DELETE));
    } catch (Exception e) {
    	txtBankNameRef1.click();
		
    }
						
	txtBankNameRef1.sendKeys(bName);
	}
	
	//Set the Bank Address text box for Banking Reference 1
	
		public void settxtBankAddRef1(String bAdd)  {
			
			
			WebDriverWait wait = new WebDriverWait(ldriver, 1);
			 ExpectedCondition<Boolean> expectation = new
			            ExpectedCondition<Boolean>() {
			                public Boolean apply(WebDriver driver) {
			                    return driver.findElement(By.xpath("//div[@class='wrapper df'][1]/div[1]/span[2]//input")).getAttribute("value").length() !=0;
			                }
		};
		
		try {
	        wait.until(expectation);
	        txtBankAddRef1.click();
	        txtBankAddRef1.sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.DELETE));
	    } catch (Exception e) {
	    	txtBankAddRef1.click();
			
	    }
							
		txtBankAddRef1.sendKeys(bAdd);
		}
		
		//Set the Bank City text box for Banking Reference 1
		
			public void settxtBankCityRef1(String bCity)  {
				
				
				WebDriverWait wait = new WebDriverWait(ldriver, 1);
				 ExpectedCondition<Boolean> expectation = new
				            ExpectedCondition<Boolean>() {
				                public Boolean apply(WebDriver driver) {
				                    return driver.findElement(By.xpath("//div[@class='wrapper df'][1]/div[1]/span[3]//input")).getAttribute("value").length() !=0;
				                }
			};
			
			try {
		        wait.until(expectation);
		        txtBankCityRef1.click();
		        txtBankCityRef1.sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.DELETE));
		    } catch (Exception e) {
		    	txtBankCityRef1.click();
				
		    }
								
			txtBankCityRef1.sendKeys(bCity);
			}
			
			//Set the Bank State text box for Banking Reference 1
			
			public void settxtBankStateRef1(String bState)  {
				
				
				WebDriverWait wait = new WebDriverWait(ldriver, 1);
				 ExpectedCondition<Boolean> expectation = new
				            ExpectedCondition<Boolean>() {
				                public Boolean apply(WebDriver driver) {
				                    return driver.findElement(By.xpath("//div[@class='wrapper df'][1]/div[1]/span[4]//input")).getAttribute("value").length() !=0;
				                }
			};
			
			try {
		        wait.until(expectation);
		        txtBankStateRef1.click();
		        txtBankStateRef1.sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.DELETE));
		    } catch (Exception e) {
		    	txtBankStateRef1.click();
				
		    }
								
			txtBankStateRef1.sendKeys(bState);
			}
			
			//Set the Bank Zip text box for Banking Reference 1
			
			public void settxtBankZipRef1(String bZip)  {
				
				
				WebDriverWait wait = new WebDriverWait(ldriver, 1);
				 ExpectedCondition<Boolean> expectation = new
				            ExpectedCondition<Boolean>() {
				                public Boolean apply(WebDriver driver) {
				                    return driver.findElement(By.xpath("//div[@class='wrapper df'][1]/div[1]/span[5]//input")).getAttribute("value").length() !=0;
				                }
			};
			
			try {
		        wait.until(expectation);
		        txtBankZipRef1.click();
		        txtBankZipRef1.sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.DELETE));
		    } catch (Exception e) {
		    	txtBankZipRef1.click();
		    }
				txtBankZipRef1.sendKeys(bZip);
		    }
			
			//Set the Bank Phone text box for Banking Reference 1
			
			public void settxtBankPhoneRef1(String bPhone)  {
				
				
				WebDriverWait wait = new WebDriverWait(ldriver, 1);
				 ExpectedCondition<Boolean> expectation = new
				            ExpectedCondition<Boolean>() {
				                public Boolean apply(WebDriver driver) {
				                    return driver.findElement(By.xpath("//div[@class='wrapper df'][1]/div[1]/span[6]//input")).getAttribute("value").length() !=0;
				                }
			};
			
			try {
		        wait.until(expectation);
		        txtBankPhoneRef1.click();
		        txtBankPhoneRef1.sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.DELETE));
		    } catch (Exception e) {
		    	txtBankPhoneRef1.click();
				
		    }
								
			txtBankPhoneRef1.sendKeys(bPhone);
			}
			
			//Set the Bank Acc text box for Banking Reference 1
			
			public void settxtBankAccRef1(String bAcc)  {
				
				
				WebDriverWait wait = new WebDriverWait(ldriver, 1);
				 ExpectedCondition<Boolean> expectation = new
				            ExpectedCondition<Boolean>() {
				                public Boolean apply(WebDriver driver) {
				                    return driver.findElement(By.xpath("//div[@class='wrapper df'][1]/div[2]/span[2]//input")).getAttribute("value").length() !=0;
				                }
			};
			
			try {
		        wait.until(expectation);
		        txtBankAccRef1.click();
		        txtBankAccRef1.sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.DELETE));
		    } catch (Exception e) {
		    	txtBankAccRef1.click();
				
		    }
								
			txtBankAccRef1.sendKeys(bAcc);
			}
			
			//Set the Bank Bal text box for Banking Reference 1
			
			public void settxtBankBalRef1(String bBal)  {
				
				
				WebDriverWait wait = new WebDriverWait(ldriver, 1);
				 ExpectedCondition<Boolean> expectation = new
				            ExpectedCondition<Boolean>() {
				                public Boolean apply(WebDriver driver) {
				                    return driver.findElement(By.xpath("//div[@class='wrapper df'][1]/div[2]/span[3]//input")).getAttribute("value").length() !=0;
				                }
			};
			
			try {
		        wait.until(expectation);
		        txtBankBalRef1.click();
		        txtBankBalRef1.sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.DELETE));
		    } catch (Exception e) {
		    	txtBankBalRef1.click();
				
		    }
								
			txtBankBalRef1.sendKeys(bBal);
			}
			
			//Set the Checking or Saving drop down menu for Banking reference 1
			public void setdrpBankCorSRef1(String bCorS)  {
				
				WebDriverWait wait = new WebDriverWait(ldriver, 25);
				wait.until(ExpectedConditions.visibilityOf(drpBankCorSRef1));
				wait.until(ExpectedConditions.elementToBeClickable(drpBankCorSRef1));
				drpBankCorSRef1.click();
				
				if(bCorS.equalsIgnoreCase("checking account"))
				{
					wait.until(ExpectedConditions.visibilityOf(drpBankChkRef1));
					wait.until(ExpectedConditions.elementToBeClickable(drpBankChkRef1));
					drpBankChkRef1.click();
				}
				else if(bCorS.equalsIgnoreCase("savings account"))
				{
					
					wait.until(ExpectedConditions.visibilityOf(drpBankSavRef1));
					wait.until(ExpectedConditions.elementToBeClickable(drpBankSavRef1));
					drpBankSavRef1.click();
				}
				    			   
			}
			
			
			//Click on Next button
			public void clkbtnNxt() {
				WebDriverWait wait = new WebDriverWait(ldriver, 25);
				wait.until(ExpectedConditions.visibilityOf(btnNxt));
				wait.until(ExpectedConditions.elementToBeClickable(btnNxt));
				btnNxt.click();
				}
			
	//Click on Delete Banking reference 1 button
			public void clkbtnDelBankRef1() throws InterruptedException {
				WebDriverWait wait = new WebDriverWait(ldriver, 4);
				ExpectedCondition<Boolean> expectation = new
			            ExpectedCondition<Boolean>() {
			                public Boolean apply(WebDriver driver) {
			                	return driver.findElement(By.xpath("//div[@class='wrapper df'][1]/div[1]/span[1]//input")).getAttribute("value").length() !=0;
			                }
			 	};
				try{
					wait.until(expectation);
					btnDelBankRef1.click();
				}
				catch(Exception e){
					btnDelBankRef1.click();
				}
				
				}
			
	//Click on Add Banking Reference  button
			public void clkbtnAddRef() {
				WebDriverWait wait = new WebDriverWait(ldriver, 25);
				wait.until(ExpectedConditions.visibilityOf(btnAddRef));
				wait.until(ExpectedConditions.elementToBeClickable(btnAddRef));
				btnAddRef.click();
						}
			
			
}
