package com.CPM.qa.pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RE_RentalHistoryPage {

public WebDriver ldriver;
	
	//Constructor
	public RE_RentalHistoryPage(WebDriver rdriver)
	{
		ldriver = rdriver;
		PageFactory.initElements(rdriver,this);
	}
	
	// Capture Rental History webelement
		@FindBy(xpath = "//h2[contains(text(),'Rental History')]")
		public WebElement txtRentalHis;
		
	// Capture Address textbox for Rental History 1
		@FindBy(xpath = "//div[@class='wrapper df'][1]/div[1]/span[1]/div//input")
		public WebElement txtAddHis1;
		
	// Capture Rent or Own drop down for Rental History 1
		@FindBy(xpath = "//div[@class='wrapper df'][1]//div[@class='v-select__selections']")
		public WebElement drpRorOHis1;
		
	// Capture RENT option of Rent or Own drop down for Rental History 1
		@FindBy(xpath = "//div[@class='v-menu__content theme--light menuable__content__active'][1]/div/div[1]/div/div")
		public WebElement drpRentHis1;
		
	// Capture OWN option of Rent or Own drop down for Rental History 1
		@FindBy(xpath = "//div[@class='v-menu__content theme--light menuable__content__active'][1]/div/div[2]/div/div")
		public WebElement drpOWNHis1;
		
	// Capture Reason for Leaving textarea for Rental History 1
		@FindBy(xpath = "//div[@class='wrapper df'][1]//textarea")
		public WebElement txtReasonHis1;
		
	// Capture LandLord textbox for Rental History 1
		@FindBy(xpath = "//div[@class='wrapper df'][1]/div[1]/span[3]/div//input")
		public WebElement txtLordHis1;
		
	// Capture Rent Start datepicker for Rental History 1
		@FindBy(xpath = "//div[@class='wrapper df'][1]/div[2]/div[1]/div//input")
		public WebElement dateStartHis1;
		
	//Capture the year button in Rent Start date picker
		@FindBy(xpath="//div[@class='v-menu__content theme--light menuable__content__active']/div/div[1]/div/div[1]")
		@CacheLookup
		public WebElement btnRentStartyy;
		
	// Capture Rent End datepicker for Rental History 1
		@FindBy(xpath = "//div[@class='wrapper df'][1]/div[2]/div[2]/div//input")
		public WebElement dateEndHis1;
		
	//Capture the year button in Rent End date picker
		@FindBy(xpath="//div[@class='v-menu__content theme--light menuable__content__active']/div/div[1]/div/div[1]")
		@CacheLookup
		public WebElement btnRentEndyy;
		
	// Capture Amount Paid Monthly textbox for Rental History 1
		@FindBy(xpath = "//div[@class='wrapper df'][1]/div[2]/span[1]/div//input")
		public WebElement txtAmtHis1;
		
	// Capture Phone textbox for Rental History 1
		@FindBy(xpath = "//div[@class='wrapper df'][1]/div[2]/span[2]/div//input")
		public WebElement txtPhoneHis1;
		
	//Capture the Next button in Employment History Page
		@FindBy(xpath="//span[normalize-space()='NEXT']")
		@CacheLookup
		public WebElement btnNxt;
		
	//Capture the Delete Rental History 1 Button 
		@FindBy(xpath="//div[@class='wrapper df'][1]/div/h3/span[2]")
		@CacheLookup
		public WebElement btnDelHis1;
		
	//Capture the Add Employment History Button on Employment History Page
		@FindBy(xpath="//span[contains(@class,'add-reference button')]")
		@CacheLookup
		public WebElement btnAddHis;
		
		
		
		//========================ACTION METHODS========================//
		
		//Set the Address text box for Rental History 1
				public void settxtAddHis1(String add)  {
					
					
					WebDriverWait wait = new WebDriverWait(ldriver, 1);
					 ExpectedCondition<Boolean> expectation = new
					            ExpectedCondition<Boolean>() {
					                public Boolean apply(WebDriver driver) {
					                    return driver.findElement(By.xpath("//div[@class='wrapper df'][1]/div[1]/span[1]/div//input")).getAttribute("value").length() !=0;
					                }
				};
				
				try {
			        wait.until(expectation);
			        txtAddHis1.click();
			        txtAddHis1.sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.DELETE));
			    } catch (Exception e) {
			    	txtAddHis1.click();
					
			    }
									
				txtAddHis1.sendKeys(add);
				}
				
		//Set the Reason for Leaving text box for Rental History 1
				public void settxtReasonHis1(String reason)  {
					
					
					WebDriverWait wait = new WebDriverWait(ldriver, 1);
					 ExpectedCondition<Boolean> expectation = new
					            ExpectedCondition<Boolean>() {
					                public Boolean apply(WebDriver driver) {
					                    return driver.findElement(By.xpath("//div[@class='wrapper df'][1]//textarea")).getAttribute("value").length() !=0;
					                }
				};
				
				try {
			        wait.until(expectation);
			        txtReasonHis1.click();
			        txtReasonHis1.sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.DELETE));
			    } catch (Exception e) {
			    	txtReasonHis1.click();
					
			    }
									
				txtReasonHis1.sendKeys(reason);
				}
				
		//Set the Land Lord text box for Rental History 1
				public void settxtLordHis1(String lord)  {
					
					
					WebDriverWait wait = new WebDriverWait(ldriver, 1);
					 ExpectedCondition<Boolean> expectation = new
					            ExpectedCondition<Boolean>() {
					                public Boolean apply(WebDriver driver) {
					                    return driver.findElement(By.xpath("//div[@class='wrapper df'][1]/div[1]/span[3]/div//input")).getAttribute("value").length() !=0;
					                }
				};
				
				try {
			        wait.until(expectation);
			        txtLordHis1.click();
			        txtLordHis1.sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.DELETE));
			    } catch (Exception e) {
			    	txtLordHis1.click();
					
			    }
									
				txtLordHis1.sendKeys(lord);
				}
				
		//Set the Amount paid monthly text box for Rental History 1
				public void settxtAmtHis1(String amount)  {
					
					
					WebDriverWait wait = new WebDriverWait(ldriver, 1);
					 ExpectedCondition<Boolean> expectation = new
					            ExpectedCondition<Boolean>() {
					                public Boolean apply(WebDriver driver) {
					                    return driver.findElement(By.xpath("//div[@class='wrapper df'][1]/div[2]/span[1]/div//input")).getAttribute("value").length() !=0;
					                }
				};
				
				try {
			        wait.until(expectation);
			        txtAmtHis1.click();
			        txtAmtHis1.sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.DELETE));
			    } catch (Exception e) {
			    	txtAmtHis1.click();
					
			    }
									
				txtAmtHis1.sendKeys(amount);
				}
				
		//Set the Phone text box for Rental History 1
				public void settxtPhoneHis1(String phone)  {
					
					
					WebDriverWait wait = new WebDriverWait(ldriver, 1);
					 ExpectedCondition<Boolean> expectation = new
					            ExpectedCondition<Boolean>() {
					                public Boolean apply(WebDriver driver) {
					                    return driver.findElement(By.xpath("//div[@class='wrapper df'][1]/div[2]/span[2]/div//input")).getAttribute("value").length() !=0;
					                }
				};
				
				try {
			        wait.until(expectation);
			        txtPhoneHis1.click();
			        txtPhoneHis1.sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.DELETE));
			    } catch (Exception e) {
			    	txtPhoneHis1.click();
					
			    }
									
				txtPhoneHis1.sendKeys(phone);
				}
				
		//Set the Rent or Owner drop down menu for Rental History 1
				public void setdrpRorOHis1(String rOrO)  {
					
					WebDriverWait wait = new WebDriverWait(ldriver, 25);
					wait.until(ExpectedConditions.visibilityOf(drpRorOHis1));
					wait.until(ExpectedConditions.elementToBeClickable(drpRorOHis1));
					drpRorOHis1.click();
					
					if(rOrO.equalsIgnoreCase("RENT"))
					{
						wait.until(ExpectedConditions.visibilityOf(drpRentHis1));
						wait.until(ExpectedConditions.elementToBeClickable(drpRentHis1));
						drpRentHis1.click();
					}
					else if(rOrO.equalsIgnoreCase("OWN"))
					{
						
						wait.until(ExpectedConditions.visibilityOf(drpOWNHis1));
						wait.until(ExpectedConditions.elementToBeClickable(drpOWNHis1));
						drpOWNHis1.click();
					}
					    			   
				}
				
		//Verify Rental History tab is displayed and selected
				public Boolean dispRentHis() {
					WebDriverWait wait = new WebDriverWait(ldriver, 25);
					 ExpectedCondition<Boolean> expectation = new
					            ExpectedCondition<Boolean>() {
					                public Boolean apply(WebDriver driver) {
					                    return driver.findElement(By.xpath("//a[contains(@class,'v-tab')][4]")).getAttribute("aria-selected").equals("true");
					                }
					 	};
					wait.until(expectation);
					return true;
					}
				
		//Set the Rent Start datepicker
				public void setdateRentStart(String yyyy,String mon,String day) throws InterruptedException  {
					
					
					WebDriverWait wait = new WebDriverWait(ldriver, 35);
					wait.until(ExpectedConditions.elementToBeClickable(dateStartHis1));
					dateStartHis1.click();
					wait.until(ExpectedConditions.visibilityOf(btnRentStartyy));
					btnRentStartyy.click();
					
					
					List<WebElement> lstyyyy = ldriver.findElements(By.xpath("//ul[@class='v-date-picker-years']/li"));
					wait.until(ExpectedConditions.visibilityOfAllElements(lstyyyy));
					for(WebElement y: lstyyyy)
					{
						if(y.getText().equalsIgnoreCase(yyyy))
						{
							wait.until(ExpectedConditions.elementToBeClickable(y));
							y.click();
							break;
						}
					}
					
					
					
					
					List<WebElement> lstmm = ldriver.findElements(By.xpath("//div[@class='v-date-picker-table v-date-picker-table--month theme--light']//table//td"));
					wait.until(ExpectedConditions.visibilityOfAllElements(lstmm));
					
					for(WebElement m: lstmm)
					{
						if(m.getText().equalsIgnoreCase(mon))
						{
							m.click();
							break;
						}
					}
					
					List<WebElement> lstdd = ldriver.findElements(By.xpath("//div[@class='v-date-picker-table v-date-picker-table--date theme--light']//table//td"));
					wait.until(ExpectedConditions.visibilityOfAllElements(lstdd));
					for(WebElement d: lstdd)
					{
						if(d.getText().equalsIgnoreCase(day))
						{
							d.click();
							break;
						}
					}
					
					
				}
				
				//Set the Rent End datepicker
					public void setdateRentEnd(String yyyy,String mon,String day)  {
						
						
						WebDriverWait wait = new WebDriverWait(ldriver, 35);
						
						dateEndHis1.click();
						wait.until(ExpectedConditions.visibilityOf(btnRentEndyy));
						btnRentEndyy.click();
						
						
						List<WebElement> lstyyyy = ldriver.findElements(By.xpath("//ul[@class='v-date-picker-years']/li"));
						wait.until(ExpectedConditions.visibilityOfAllElements(lstyyyy));
						for(WebElement y: lstyyyy)
						{
							
							if(y.getText().equalsIgnoreCase(yyyy))
							{
								
								y.click();
								break;
							}
						}
						
						
						
						
						List<WebElement> lstmm = ldriver.findElements(By.xpath("//div[@class='v-date-picker-table v-date-picker-table--month theme--light']//table//td"));
						wait.until(ExpectedConditions.visibilityOfAllElements(lstmm));
						
						for(WebElement m: lstmm)
						{
							if(m.getText().equalsIgnoreCase(mon))
							{
								m.click();
								break;
							}
						}
						
						List<WebElement> lstdd = ldriver.findElements(By.xpath("//div[@class='v-date-picker-table v-date-picker-table--date theme--light']//table//td"));
						//wait.until(ExpectedConditions.visibilityOfAllElements(lstdd));
						for(WebElement d: lstdd)
						{
							if(d.getText().equalsIgnoreCase(day))
							{
								d.click();
								break;
							}
						}
						
						
					}
					
			//Click on Next button
					public void clkbtnNxt() {
						WebDriverWait wait = new WebDriverWait(ldriver, 25);
						wait.until(ExpectedConditions.visibilityOf(btnNxt));
						wait.until(ExpectedConditions.elementToBeClickable(btnNxt));
						btnNxt.click();
						}
					
			//Click on Delete Rental History 1 button
					public void clkbtnDelHis1() throws InterruptedException {
						WebDriverWait wait = new WebDriverWait(ldriver, 4);
						ExpectedCondition<Boolean> expectation = new
					            ExpectedCondition<Boolean>() {
					                public Boolean apply(WebDriver driver) {
					                	return driver.findElement(By.xpath("//div[@class='wrapper df'][1]/div[1]/span[1]/div//input")).getAttribute("value").length() !=0;
					                }
					 	};
						try{
							wait.until(expectation);
							btnDelHis1.click();
						}
						catch(Exception e){
							btnDelHis1.click();
						}
						
						}
					
			//Click on Add Employment History  button
					public void clkbtnAddHis() {
						WebDriverWait wait = new WebDriverWait(ldriver, 25);
						wait.until(ExpectedConditions.visibilityOf(btnAddHis));
						wait.until(ExpectedConditions.elementToBeClickable(btnAddHis));
						btnAddHis.click();
								}
		
}
