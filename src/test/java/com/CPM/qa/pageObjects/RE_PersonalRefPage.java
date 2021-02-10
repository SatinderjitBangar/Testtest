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

public class RE_PersonalRefPage {

public WebDriver ldriver;
	
	//Constructor
	public RE_PersonalRefPage(WebDriver rdriver)
	{
		ldriver = rdriver;
		PageFactory.initElements(rdriver,this);
	}
	
		// Capture  Name text box for  Reference 1
		@FindBy(xpath = "//div[@class='df'][1]/div[1]/span[1]//input")
		public WebElement txtNameRef1;
		
		// Capture  Address text box for  Reference 1
		@FindBy(xpath = "//div[@class='df'][1]/div[1]/span[2]//input")
		public WebElement txtAddRef1;
		
		// Capture  City text box for  Reference 1
		@FindBy(xpath = "//div[@class='df'][1]/div[1]/span[3]//input")
		public WebElement txtCityRef1;
		
		// Capture  Zip code text box for  Reference 1
		@FindBy(xpath = "//div[@class='df'][1]/div[1]/span[4]//input")
		public WebElement txtZipRef1;
			
		// Capture  State text box for  Reference 1
		@FindBy(xpath = "//div[@class='df'][1]/div[1]/span[5]//input")
		public WebElement txtStateRef1;
		
		// Capture Phone text box for Reference 1
		@FindBy(xpath = "//div[@class='df'][1]/div[2]/span[1]//input")
		public WebElement txtPhoneRef1;
		
		// Capture Relationship text box for Reference 1
		@FindBy(xpath = "//div[@class='df'][1]/div[2]/span[2]//input")
		public WebElement txtRelRef1;
		
		//Capture the Next button 
		@FindBy(xpath="//span[normalize-space()='NEXT']")
		@CacheLookup
		public WebElement btnNxt;
		
		//Capture the Add Personal Reference Button
		@FindBy(xpath="//span[contains(@class,'add-reference button')]")
		@CacheLookup
		public WebElement btnAddRef;
		
		// Capture Delete button for Reference 1
		@FindBy(xpath = "//div[@class='df']/div[1]/h3/span[2]")
		public WebElement btnDelRef1;
		
	//========================ACTION METHODS========================//
	
		//Set the  Name text box for  Reference 1
		
		public void settxtNameRef1(String pName)  {
			
			
			WebDriverWait wait = new WebDriverWait(ldriver, 1);
			 ExpectedCondition<Boolean> expectation = new
			            ExpectedCondition<Boolean>() {
			                public Boolean apply(WebDriver driver) {
			                    return driver.findElement(By.xpath("//div[@class='df'][1]/div[1]/span[1]//input")).getAttribute("value").length() !=0;
			                }
		};
		
		try {
	        wait.until(expectation);
	        txtNameRef1.click();
	        txtNameRef1.sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.DELETE));
	    } catch (Exception e) {
	    	txtNameRef1.click();
			
	    }
							
		txtNameRef1.sendKeys(pName);
		}
		
		//Set the Address text box for Reference 1
		
			public void settxtAddRef1(String pAdd)  {
				
				
				WebDriverWait wait = new WebDriverWait(ldriver, 1);
				 ExpectedCondition<Boolean> expectation = new
				            ExpectedCondition<Boolean>() {
				                public Boolean apply(WebDriver driver) {
				                    return driver.findElement(By.xpath("//div[@class='df'][1]/div[1]/span[2]//input")).getAttribute("value").length() !=0;
				                }
			};
			
			try {
		        wait.until(expectation);
		        txtAddRef1.click();
		        txtAddRef1.sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.DELETE));
		    } catch (Exception e) {
		    	txtAddRef1.click();
				
		    }
								
			txtAddRef1.sendKeys(pAdd);
			}
			
			//Set the City text box for Reference 1
			
				public void settxtCityRef1(String pCity)  {
					
					
					WebDriverWait wait = new WebDriverWait(ldriver, 1);
					 ExpectedCondition<Boolean> expectation = new
					            ExpectedCondition<Boolean>() {
					                public Boolean apply(WebDriver driver) {
					                    return driver.findElement(By.xpath("//div[@class='df'][1]/div[1]/span[3]//input")).getAttribute("value").length() !=0;
					                }
				};
				
				try {
			        wait.until(expectation);
			        txtCityRef1.click();
			        txtCityRef1.sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.DELETE));
			    } catch (Exception e) {
			    	txtCityRef1.click();
					
			    }
									
				txtCityRef1.sendKeys(pCity);
				}
				
				//Set the  State text box for  Reference 1
				
				public void settxtStateRef1(String pState)  {
					
					
					WebDriverWait wait = new WebDriverWait(ldriver, 1);
					 ExpectedCondition<Boolean> expectation = new
					            ExpectedCondition<Boolean>() {
					                public Boolean apply(WebDriver driver) {
					                    return driver.findElement(By.xpath("//div[@class='df'][1]/div[1]/span[5]//input")).getAttribute("value").length() !=0;
					                }
				};
				
				try {
			        wait.until(expectation);
			        txtStateRef1.click();
			        txtStateRef1.sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.DELETE));
			    } catch (Exception e) {
			    	txtStateRef1.click();
					
			    }
									
				txtStateRef1.sendKeys(pState);
				}
				
				//Set the Zip text box for  Reference 1
				
				public void settxtZipRef1(String pZip)  {
					
					
					WebDriverWait wait = new WebDriverWait(ldriver, 1);
					 ExpectedCondition<Boolean> expectation = new
					            ExpectedCondition<Boolean>() {
					                public Boolean apply(WebDriver driver) {
					                    return driver.findElement(By.xpath("//div[@class='df'][1]/div[1]/span[4]//input")).getAttribute("value").length() !=0;
					                }
				};
				
				try {
			        wait.until(expectation);
			        txtZipRef1.click();
			        txtZipRef1.sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.DELETE));
			    } catch (Exception e) {
			    	txtZipRef1.click();
			    }
					txtZipRef1.sendKeys(pZip);
			    }
				
				//Set the  Phone text box for Reference 1
				
				public void settxtPhoneRef1(String pPhone)  {
					
					
					WebDriverWait wait = new WebDriverWait(ldriver, 1);
					 ExpectedCondition<Boolean> expectation = new
					            ExpectedCondition<Boolean>() {
					                public Boolean apply(WebDriver driver) {
					                    return driver.findElement(By.xpath("//div[@class='df'][1]/div[2]/span[1]//input")).getAttribute("value").length() !=0;
					                }
				};
				
				try {
			        wait.until(expectation);
			        txtPhoneRef1.click();
			        txtPhoneRef1.sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.DELETE));
			    } catch (Exception e) {
			    	txtPhoneRef1.click();
					
			    }
									
				txtPhoneRef1.sendKeys(pPhone);
				}
				
				//Set the Relationship text box for Reference 1
				
				public void settxtRelRef1(String pRel)  {
					
					
					WebDriverWait wait = new WebDriverWait(ldriver, 1);
					 ExpectedCondition<Boolean> expectation = new
					            ExpectedCondition<Boolean>() {
					                public Boolean apply(WebDriver driver) {
					                    return driver.findElement(By.xpath("//div[@class='df'][1]/div[2]/span[2]//input")).getAttribute("value").length() !=0;
					                }
				};
				
				try {
			        wait.until(expectation);
			        txtRelRef1.click();
			        txtRelRef1.sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.DELETE));
			    } catch (Exception e) {
			    	txtRelRef1.click();
					
			    }
									
				txtRelRef1.sendKeys(pRel);
				}
				
	//Verify Personal Reference tab is displayed and selected
		public Boolean dispPersRef() {
			WebDriverWait wait = new WebDriverWait(ldriver, 25);
			 ExpectedCondition<Boolean> expectation = new
			            ExpectedCondition<Boolean>() {
			                public Boolean apply(WebDriver driver) {
			                    return driver.findElement(By.xpath("//a[contains(@class,'v-tab')][6]")).getAttribute("aria-selected").equals("true");
			                }
			 	};
			wait.until(expectation);
			return true;
			}
		
		//Click on Add Personal Reference  button
		public void clkbtnAddRef() {
			WebDriverWait wait = new WebDriverWait(ldriver, 25);
			wait.until(ExpectedConditions.visibilityOf(btnAddRef));
			wait.until(ExpectedConditions.elementToBeClickable(btnAddRef));
			btnAddRef.click();
					}
		
		//Click on Delete reference 1 button
		public void clkbtnDelRef1() throws InterruptedException {
			WebDriverWait wait = new WebDriverWait(ldriver, 4);
			ExpectedCondition<Boolean> expectation = new
		            ExpectedCondition<Boolean>() {
		                public Boolean apply(WebDriver driver) {
		                	return driver.findElement(By.xpath("//div[@class='df'][1]/div[1]/span[1]//input")).getAttribute("value").length() !=0;
		                }
		 	};
			try{
				wait.until(expectation);
				btnDelRef1.click();
			}
			catch(Exception e){
				btnDelRef1.click();
			}
			
			}
		
		//Click on Next button
		public void clkbtnNxt() {
			WebDriverWait wait = new WebDriverWait(ldriver, 25);
			wait.until(ExpectedConditions.visibilityOf(btnNxt));
			wait.until(ExpectedConditions.elementToBeClickable(btnNxt));
			btnNxt.click();
			}
}
