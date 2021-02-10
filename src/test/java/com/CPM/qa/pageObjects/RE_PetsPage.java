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
import org.openqa.selenium.support.ui.WebDriverWait;

public class RE_PetsPage {

public WebDriver ldriver;
	
	//Constructor
	public RE_PetsPage(WebDriver rdriver)
	{
		ldriver = rdriver;
		PageFactory.initElements(rdriver,this);
	}
	
	//Capture Water filled furniture text area
	@FindBy(xpath = "//div[@class='wrapper df']/div[1]/span[1]//textarea")
	WebElement txtWaterFur;
	
	//Capture Any Delinquincies? text area 
	@FindBy(xpath="//div[@class='wrapper df']/div[1]/span[2]//textarea")
	@CacheLookup
	public WebElement txtDelin;
	
	//Capture Boots text area 
	@FindBy(xpath="//div[@class='wrapper df']/div[2]/span[1]//textarea")
	@CacheLookup
	public WebElement txtBoots;
	
	//Capture Describe prior evictions text area 
	@FindBy(xpath="//div[@class='wrapper df']/div[2]/span[2]//textarea")
	@CacheLookup
	public WebElement txtPriorEvc;
	
	//Capture Vehicle Make text box 
	@FindBy(xpath="//div[@class='wrapper df']/div[1]/div[1]/div/span[1]//input")
	@CacheLookup
	public WebElement txtVehMake;
	
	//Capture Vehicle Color text box 
	@FindBy(xpath="//div[@class='wrapper df']/div[1]/div[1]/div/span[2]//input")
	@CacheLookup
	public WebElement txtVehCol;
	
	//Capture Vehicle Year text box 
	@FindBy(xpath="//div[@class='wrapper df']/div[1]/div[1]/div/span[3]//input")
	@CacheLookup
	public WebElement txtVehYear;
	
	//Capture Vehicle Plate number text box 
	@FindBy(xpath="//div[@class='wrapper df']/div[1]/div[1]/div/span[4]//input")
	@CacheLookup
	public WebElement txtVehPlate;
	
	//Capture Del Vehicle btn
	@FindBy(xpath="//div[@class='wrapper df']/div[1]/div/div/h3/span[2]")
	@CacheLookup
	public List<WebElement> btnVehDel;
	
	//Capture Add Vehicle btn
	@FindBy(xpath="//div[@class='wrapper df']/div[1]/span[3]")
	@CacheLookup
	public WebElement btnVehAdd;
	
	//Capture Add Pet btn
	@FindBy(xpath="//div[@class='wrapper df']/div[2]/span[3]")
	@CacheLookup
	public WebElement btnPetAdd;
	
	//Capture Del Pet btn
	@FindBy(xpath="//div[@class='wrapper df']/div[2]/div/div/h3/span[2]")
	@CacheLookup
	public List<WebElement> btnPetDel;
	
	//Capture Pet Type text box 
	@FindBy(xpath="//div[@class='wrapper df']/div[2]/div[1]/div/span[1]//input")
	@CacheLookup
	public WebElement txtPetType;
	
	//Capture Pet Description text box 
	@FindBy(xpath="//div[@class='wrapper df']/div[2]/div[1]/div/span[2]//input")
	@CacheLookup
	public WebElement txtPetDes;
	
	//Capture submit button
	@FindBy(xpath="//button[@type='submit']")
	@CacheLookup
	public WebElement btnSubmit;
	
	//Capture Application submitted heading
	@FindBy(xpath="//div[@class='submitted df jcc aic']/h3")
	@CacheLookup
	public WebElement headAppSubmit;
	
	//========================ACTION METHODS========================//
	
		//Verify Pets tab is displayed and selected
		public Boolean dispPets() {
			WebDriverWait wait = new WebDriverWait(ldriver, 25);
			 ExpectedCondition<Boolean> expectation = new
			            ExpectedCondition<Boolean>() {
			                public Boolean apply(WebDriver driver) {
			                    return driver.findElement(By.xpath("//a[contains(@class,'v-tab')][7]")).getAttribute("aria-selected").equals("true");
			                }
			 	};
			wait.until(expectation);
			return true;
			}
		
		//Verify Application submitted heading is displayed 
		public Boolean dispheadAppSubmit() {
			WebDriverWait wait = new WebDriverWait(ldriver, 25);
			wait.until(ExpectedConditions.visibilityOf(headAppSubmit));
			if(headAppSubmit.isDisplayed()) {
					return true;
			}
			else
			{
				return false;
			}
					}
		
		//Set the Water filled furniture text area
				public void settxtWaterFur(String petWaterFur)  {
					
					
					WebDriverWait wait = new WebDriverWait(ldriver, 5);
					 ExpectedCondition<Boolean> expectation = new
					            ExpectedCondition<Boolean>() {
					                public Boolean apply(WebDriver driver) {
					                    return driver.findElement(By.xpath("//div[@class='wrapper df']/div[1]/span[1]//textarea")).getAttribute("value").length() !=0;
					                }
				};
				
				try {
			        wait.until(expectation);
			        txtWaterFur.click();
			        txtWaterFur.sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.DELETE));
			    } catch (Exception e) {
			    	txtWaterFur.click();
					
			    }
									
				txtWaterFur.sendKeys(petWaterFur);
				}
				
				//Set the Any Delinquincies text area
				public void settxtDelin(String petDlin)  {
					
					
					WebDriverWait wait = new WebDriverWait(ldriver, 5);
					 ExpectedCondition<Boolean> expectation = new
					            ExpectedCondition<Boolean>() {
					                public Boolean apply(WebDriver driver) {
					                    return driver.findElement(By.xpath("//div[@class='wrapper df']/div[1]/span[2]//textarea")).getAttribute("value").length() !=0;
					                }
				};
				
				try {
			        wait.until(expectation);
			        txtDelin.click();
			        txtDelin.sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.DELETE));
			    } catch (Exception e) {
			    	txtDelin.click();
					
			    }
									
				txtDelin.sendKeys(petDlin);
				}
				
				//Set the Boots text area
				public void settxtBoots(String petBoots)  {
					
					
					WebDriverWait wait = new WebDriverWait(ldriver, 5);
					 ExpectedCondition<Boolean> expectation = new
					            ExpectedCondition<Boolean>() {
					                public Boolean apply(WebDriver driver) {
					                    return driver.findElement(By.xpath("//div[@class='wrapper df']/div[2]/span[1]//textarea")).getAttribute("value").length() !=0;
					                }
				};
				
				try {
			        wait.until(expectation);
			        txtBoots.click();
			        txtBoots.sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.DELETE));
			    } catch (Exception e) {
			    	txtBoots.click();
					
			    }
									
				txtBoots.sendKeys(petBoots);
				}
				
				//Set the Prior Evictions text area
				public void settxtPriorEvc(String petPriorEvc)  {
					
					
					WebDriverWait wait = new WebDriverWait(ldriver, 5);
					 ExpectedCondition<Boolean> expectation = new
					            ExpectedCondition<Boolean>() {
					                public Boolean apply(WebDriver driver) {
					                    return driver.findElement(By.xpath("//div[@class='wrapper df']/div[2]/span[2]//textarea")).getAttribute("value").length() !=0;
					                }
				};
				
				try {
			        wait.until(expectation);
			        txtPriorEvc.click();
			        txtPriorEvc.sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.DELETE));
			    } catch (Exception e) {
			    	txtPriorEvc.click();
					
			    }
									
				txtPriorEvc.sendKeys(petPriorEvc);
				}
				
				//Set the Vehicle make text area
				public void settxtVehMake(String petVehMake)  {
					
					
					WebDriverWait wait = new WebDriverWait(ldriver, 1);
					 ExpectedCondition<Boolean> expectation = new
					            ExpectedCondition<Boolean>() {
					                public Boolean apply(WebDriver driver) {
					                    return driver.findElement(By.xpath("//div[@class='wrapper df']/div[1]/div[1]/div/span[1]//input")).getAttribute("value").length() !=0;
					                }
				};
				
				try {
			        wait.until(expectation);
			        txtVehMake.click();
			        txtVehMake.sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.DELETE));
			    } catch (Exception e) {
			    	txtVehMake.click();
					
			    }
									
				txtVehMake.sendKeys(petVehMake);
				}
				
				//Set the Vehicle Year text area
				public void settxtVehYear(String petVehYear)  {
					
					
					WebDriverWait wait = new WebDriverWait(ldriver, 1);
					 ExpectedCondition<Boolean> expectation = new
					            ExpectedCondition<Boolean>() {
					                public Boolean apply(WebDriver driver) {
					                    return driver.findElement(By.xpath("//div[@class='wrapper df']/div[1]/div[1]/div/span[2]//input")).getAttribute("value").length() !=0;
					                }
				};
				
				try {
			        wait.until(expectation);
			        txtVehYear.click();
			        txtVehYear.sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.DELETE));
			    } catch (Exception e) {
			    	txtVehYear.click();
					
			    }
									
				txtVehYear.sendKeys(petVehYear);
				}
				
				//Set the Vehicle Color text area
				public void settxtVehCol(String petVehCol)  {
					
					
					WebDriverWait wait = new WebDriverWait(ldriver, 1);
					 ExpectedCondition<Boolean> expectation = new
					            ExpectedCondition<Boolean>() {
					                public Boolean apply(WebDriver driver) {
					                    return driver.findElement(By.xpath("//div[@class='wrapper df']/div[1]/div[1]/div/span[3]//input")).getAttribute("value").length() !=0;
					                }
				};
				
				try {
			        wait.until(expectation);
			        txtVehCol.click();
			        txtVehCol.sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.DELETE));
			    } catch (Exception e) {
			    	txtVehCol.click();
					
			    }
									
				txtVehCol.sendKeys(petVehCol);
				}
				
				//Set the Vehicle Plate text area
				public void settxtVehPlate(String petVehPlate)  {
					
					
					WebDriverWait wait = new WebDriverWait(ldriver, 1);
					 ExpectedCondition<Boolean> expectation = new
					            ExpectedCondition<Boolean>() {
					                public Boolean apply(WebDriver driver) {
					                    return driver.findElement(By.xpath("//div[@class='wrapper df']/div[1]/div[1]/div/span[4]//input")).getAttribute("value").length() !=0;
					                }
				};
				
				try {
			        wait.until(expectation);
			        txtVehPlate.click();
			        txtVehPlate.sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.DELETE));
			    } catch (Exception e) {
			    	txtVehPlate.click();
					
			    }
									
				txtVehPlate.sendKeys(petVehPlate);
				}
				
				//Click on all Vehicles delete buttons
				public void clkbtnVehDel() throws InterruptedException {
					WebDriverWait wait = new WebDriverWait(ldriver, 5);
					ExpectedCondition<Boolean> expectation = new
				            ExpectedCondition<Boolean>() {
				                public Boolean apply(WebDriver driver) {
				                	return driver.findElement(By.xpath("//div[@class='wrapper df']/div[1]/div[1]/div/span[1]//input")).getAttribute("value").length() !=0;
				                }
				 	};
					try{
						wait.until(expectation);
					
				 			
					int size = btnVehDel.size();
					
					for (int i=1;i<=size;i++)
					{
						
						ldriver.findElement(By.xpath("//div[@class='wrapper df']/div[1]/div[1]/div/h3/span[2]")).click();
					
					}
					}
					catch(Exception e) {
						int size = btnVehDel.size();
						
						for (int i=1;i<=size;i++)
						{
							
							ldriver.findElement(By.xpath("//div[@class='wrapper df']/div[1]/div[1]/div/h3/span[2]")).click();
						
						}
					}
					
			}
				
				//Set the Pet Type text area
				public void settxtPetType(String petType)  {
					
					
					WebDriverWait wait = new WebDriverWait(ldriver, 1);
					 ExpectedCondition<Boolean> expectation = new
					            ExpectedCondition<Boolean>() {
					                public Boolean apply(WebDriver driver) {
					                    return driver.findElement(By.xpath("//div[@class='wrapper df']/div[2]/div[1]/div/span[1]//input")).getAttribute("value").length() !=0;
					                }
				};
				
				try {
			        wait.until(expectation);
			        txtPetType.click();
			        txtPetType.sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.DELETE));
			    } catch (Exception e) {
			    	txtPetType.click();
					
			    }
									
				txtPetType.sendKeys(petType);
				}
				
				//Set the Pet Description text area
				public void settxtPetDes(String petDes)  {
					
					
					WebDriverWait wait = new WebDriverWait(ldriver, 1);
					 ExpectedCondition<Boolean> expectation = new
					            ExpectedCondition<Boolean>() {
					                public Boolean apply(WebDriver driver) {
					                    return driver.findElement(By.xpath("//div[@class='wrapper df']/div[2]/div[1]/div/span[2]//input")).getAttribute("value").length() !=0;
					                }
				};
				
				try {
			        wait.until(expectation);
			        txtPetDes.click();
			        txtPetDes.sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.DELETE));
			    } catch (Exception e) {
			    	txtPetDes.click();
					
			    }
									
				txtPetDes.sendKeys(petDes);
				}
				
				
				//Click on all Pet delete buttons
				public void clkbtnPetDel() throws InterruptedException {
					WebDriverWait wait = new WebDriverWait(ldriver, 5);
					ExpectedCondition<Boolean> expectation = new
				            ExpectedCondition<Boolean>() {
				                public Boolean apply(WebDriver driver) {
				                	return driver.findElement(By.xpath("//div[@class='wrapper df']/div[2]/div[1]/div/span[1]//input")).getAttribute("value").length() !=0;
				                }
				 	};
					try{
						wait.until(expectation);
					
				 			
					int size = btnPetDel.size();
					
					for (int i=1;i<=size;i++)
					{
						
						ldriver.findElement(By.xpath("//div[@class='wrapper df']/div[2]/div[1]/div/h3/span[2]")).click();
					
					}
					}
					catch(Exception e) {
						int size = btnPetDel.size();
						
						for (int i=1;i<=size;i++)
						{
							
							ldriver.findElement(By.xpath("//div[@class='wrapper df']/div[2]/div[1]/div/h3/span[2]")).click();
						
						}
					}
					
			}
				
				//Click on submit button
				public void clkbtnSubmit() {
					WebDriverWait wait = new WebDriverWait(ldriver, 25);
					wait.until(ExpectedConditions.visibilityOf(btnSubmit));
					wait.until(ExpectedConditions.elementToBeClickable(btnSubmit));
					btnSubmit.click();
					}
				
				//Click on Add new Vehicle
				public void clkbtnVehAdd() {
					WebDriverWait wait = new WebDriverWait(ldriver, 25);
					wait.until(ExpectedConditions.visibilityOf(btnVehAdd));
					wait.until(ExpectedConditions.elementToBeClickable(btnVehAdd));
					btnVehAdd.click();
					}
				
				//Click on Add new Pet
				public void clkbtnPetAdd() {
					WebDriverWait wait = new WebDriverWait(ldriver, 25);
					wait.until(ExpectedConditions.visibilityOf(btnPetAdd));
					wait.until(ExpectedConditions.elementToBeClickable(btnPetAdd));
					btnPetAdd.click();
					}
}
