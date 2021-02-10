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

public class RE_EmploymentHistoryPage {

public WebDriver ldriver;
	
	//Constructor
	public RE_EmploymentHistoryPage(WebDriver rdriver)
	{
		ldriver = rdriver;
		PageFactory.initElements(rdriver,this);
	}
	
	//Capture the text Employment History
	@FindBy(xpath = "//h3[@class=\"application-box df w_1\"]")
	WebElement txtEmphist;
	
	//Capture the Heading Employment History
	@FindBy(xpath="//h2[normalize-space()='Employment History']")
	@CacheLookup
	public WebElement headEmpHis;
	
	//Capture the Employer textbox for Employment History 1
	@FindBy(xpath="//div[@class=' df'][1]/div/h3//following-sibling::div[1]/div/div/span[1]//input")
	@CacheLookup
	public WebElement txtEmployer;
	
	//Capture the Address Line 1 text box for Employment History 1
	@FindBy(xpath="//div[@class=' df'][1]/div/h3//following-sibling::div[1]/div/div/span[2]//input")
	@CacheLookup
	public WebElement txtAdd1;
	
	//Capture the Address Line 2 text box for Employment History 1
	@FindBy(xpath="//div[@class=' df'][1]/div/h3//following-sibling::div[1]/div/div/span[3]//input")
	@CacheLookup
	public WebElement txtAdd2;
	
	//Capture the Address city text box for Employment History 1
	@FindBy(xpath="//div[@class=' df'][1]/div/h3//following-sibling::div[1]/div/div/span[4]//input")
	@CacheLookup
	public WebElement txtCity;
	
	//Capture the Address State text box for Employment History 1
	@FindBy(xpath="//div[@class=' df'][1]/div/h3//following-sibling::div[1]/div/div/div/span[1]//input")
	@CacheLookup
	public WebElement txtState;
	
	//Capture the Zip Code text box for Employment History 1
	@FindBy(xpath="//div[@class=' df'][1]/div/h3//following-sibling::div[1]/div/div/div/span[2]//input")
	@CacheLookup
	public WebElement txtZip;
	
	//Capture the Phone text box for Employment History 1
	@FindBy(xpath="//div[@class=' df'][1]/div/h3//following-sibling::div[1]/div/div/span[5]//input")
	@CacheLookup
	public WebElement txtPhone;
	
	//Capture the Supervisor text box for Employment History 1
	@FindBy(xpath="//div[@class=' df'][1]/div/h3//following-sibling::div[1]/div/div/span[6]//input")
	@CacheLookup
	public WebElement txtSup;
		
	//Capture the Position text box for Employment History 1
	@FindBy(xpath="//div[@class=' df'][1]/div/h3//following-sibling::div[1]/div/div/span[7]//input")
	@CacheLookup
	public WebElement txtPos;
	
	//Capture the Reason for leaving text box for Employment History 1
	@FindBy(xpath="//div[@class=' df'][1]/div/h3//following-sibling::div[1]/div/div/span[8]//input")
	@CacheLookup
	public WebElement txtReason;
	
	//Capture the Work start datepicker for Employment History 1
	@FindBy(xpath="//div[@class=' df'][1]/div/h3//following-sibling::div[1]/div/div/div[2]//input")
	@CacheLookup
	public WebElement dateWorkStart;
	
	//Capture the year button in Work Start date picker for Employment History 1
	@FindBy(xpath="//div[@class='v-menu__content theme--light menuable__content__active']/div/div[1]/div/div[1]")
	@CacheLookup
	public WebElement btnWorkStartyy;
	
	//Capture the Work end datepicker for Employment History 1
	@FindBy(xpath="//div[@class=' df'][1]/div/h3//following-sibling::div[1]/div/div/div[3]//input")
	@CacheLookup
	public WebElement dateWorkEnd;
	
	//Capture the year button in Work End date picker for Employment History 1
	@FindBy(xpath="//div[@class='v-menu__content theme--light menuable__content__active']/div/div[1]/div/div[1]")
	@CacheLookup
	public WebElement btnWorkEndyy;
	
	//Capture the Combined annual salary for Employment History 1
	@FindBy(xpath="//div[@class=' df'][1]/div/h3//following-sibling::div[1]/div/div/span[9]//input")
	@CacheLookup
	public WebElement txtSal;
	
	//Capture the heading Employer History 2
	@FindBy(xpath="//div[@class=' df'][2]/div/h3")
	@CacheLookup
	public WebElement headEmployerHis2;
	
	//Capture the Employer textbox for Employment History 2
	@FindBy(xpath="//div[@class=' df'][2]/div/h3//following-sibling::div[1]/div/div/span[1]//input")
	@CacheLookup
	public WebElement txtEmployerHis2;
		
	//Capture the Address Line 1 text box for Employment History 2
	@FindBy(xpath="//div[@class=' df'][2]/div/h3//following-sibling::div[1]/div/div/span[2]//input")
	@CacheLookup
	public WebElement txtAdd1His2;
			
	//Capture the Address Line 2 text box for Employment History 2
	@FindBy(xpath="//div[@class=' df'][2]/div/h3//following-sibling::div[1]/div/div/span[3]//input")
	@CacheLookup
	public WebElement txtAdd2His2;
			
	//Capture the Address city text box for Employment History 2
	@FindBy(xpath="//div[@class=' df'][2]/div/h3//following-sibling::div[1]/div/div/span[4]//input")
	@CacheLookup
	public WebElement txtCityHis2;
			
	//Capture the Address State text box for Employment History 2
	@FindBy(xpath="//div[@class=' df'][2]/div/h3//following-sibling::div[1]/div/div/div/span[1]//input")
	@CacheLookup
	public WebElement txtStateHis2;
			
	//Capture the Zip Code text box for Employment History 2
	@FindBy(xpath="//div[@class=' df'][2]/div/h3//following-sibling::div[1]/div/div/div/span[2]//input")
	@CacheLookup
	public WebElement txtZipHis2;
	
	//Capture the Phone text box for Employment History 2
	@FindBy(xpath="//div[@class=' df'][2]/div/h3//following-sibling::div[1]/div/div/span[5]//input")
	@CacheLookup
	public WebElement txtPhoneHis2;
			
	//Capture the Supervisor text box for Employment History 2
	@FindBy(xpath="//div[@class=' df'][2]/div/h3//following-sibling::div[1]/div/div/span[6]//input")
	@CacheLookup
	public WebElement txtSupHis2;
				
	//Capture the Position text box for Employment History 2
	@FindBy(xpath="//div[@class=' df'][2]/div/h3//following-sibling::div[1]/div/div/span[7]//input")
	@CacheLookup
	public WebElement txtPosHis2;
			
	//Capture the Reason for leaving text box for Employment History 2
	@FindBy(xpath="//div[@class=' df'][2]/div/h3//following-sibling::div[1]/div/div/span[8]//input")
	@CacheLookup
	public WebElement txtReasonHis2;
			
	//Capture the Work start datepicker for Employment History 2
	@FindBy(xpath="//div[@class=' df'][2]/div/h3//following-sibling::div[1]/div/div/div[2]//input")
	@CacheLookup
	public WebElement dateWorkStartHis2;
		
	//Capture the year button in Work Start date picker for Employment History 2
	@FindBy(xpath="//div[@class='v-menu__content theme--light menuable__content__active']/div/div[1]/div/div[1]")
	@CacheLookup
	public WebElement btnWorkStartyyHis2;
	
	//Capture the Work end datepicker for Employment History 2
	@FindBy(xpath="//div[@class=' df'][2]/div/h3//following-sibling::div[1]/div/div/div[3]//input")
	@CacheLookup
	public WebElement dateWorkEndHis2;
			
	//Capture the year Work end button in date picker for Employment History 2
	@FindBy(xpath="//div[@class='v-menu__content theme--light menuable__content__active']/div/div[1]/div/div[1]")
	@CacheLookup
	public WebElement btnWorkEndyyHis2;
			
	//Capture the Combined annual salary for Employment History 2
	@FindBy(xpath="//div[@class=' df'][2]/div/h3//following-sibling::div[1]/div/div/span[9]//input")
	@CacheLookup
	public WebElement txtSalHis2;
	
	//Capture the Next button in Employment History Page
	@FindBy(xpath="//span[normalize-space()='NEXT']")
	@CacheLookup
	public WebElement btnNxt;
	
	//Capture the all Delete Employment History Button on Employment History 
	@FindBy(xpath="//div[@class=' df']/div/h3//descendant::span[2]")
	public List <WebElement> btnDelHis;
		
	//Capture the Add Employment History Button on Employment History Page
	@FindBy(xpath="//span[contains(@class,'add-reference button')]")
	@CacheLookup
	public WebElement btnAddHis;
	
	
	
	
	
	//========================ACTION METHODS========================//
	public String gettxtEmphist()
	{
		return txtEmphist.getText();
	}
	
	//Set the Employer text box
		public void settxtEmployer(String employer)  {
			
			
			WebDriverWait wait = new WebDriverWait(ldriver, 1);
			 ExpectedCondition<Boolean> expectation = new
			            ExpectedCondition<Boolean>() {
			                public Boolean apply(WebDriver driver) {
			                    return driver.findElement(By.xpath("//h3[contains(text(),'Main Applicant')]//following::input[1]")).getAttribute("value").length() !=0;
			                }
		};
		
		try {
	        wait.until(expectation);
	        txtEmployer.click();
	        txtEmployer.sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.DELETE));
	    } catch (Exception e) {
	    	txtEmployer.click();
			
	    }
							
		txtEmployer.sendKeys(employer);
		}
		
	//Set the Address Line 2 text box
			public void settxtAdd2(String add2)  {
					
					
					WebDriverWait wait = new WebDriverWait(ldriver, 1);
					 ExpectedCondition<Boolean> expectation = new
					            ExpectedCondition<Boolean>() {
					                public Boolean apply(WebDriver driver) {
					                    return driver.findElement(By.xpath("//h3[contains(text(),'Main Applicant')]//following::input[3]")).getAttribute("value").length() !=0;
					                }
				};
				
				try {
			        wait.until(expectation);
			        txtAdd2.click();
			        txtAdd2.sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.DELETE));
			    } catch (Exception e) {
			    	txtAdd2.click();
					
			    }
									
				txtAdd2.sendKeys(add2);
				}
			
			//Set the City text box
			public void settxtCity(String city)  {
					
					
					WebDriverWait wait = new WebDriverWait(ldriver, 1);
					 ExpectedCondition<Boolean> expectation = new
					            ExpectedCondition<Boolean>() {
					                public Boolean apply(WebDriver driver) {
					                    return driver.findElement(By.xpath("//h3[contains(text(),'Main Applicant')]//following::input[4]")).getAttribute("value").length() !=0;
					                }
				};
				
				try {
			        wait.until(expectation);
			        txtCity.click();
			        txtCity.sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.DELETE));
			    } catch (Exception e) {
			    	txtCity.click();
					
			    }
									
				txtCity.sendKeys(city);
				}
			
			//Set the Address Line 1 text box
			public void settxtAdd1(String add1)  {
					
					
					WebDriverWait wait = new WebDriverWait(ldriver, 1);
					 ExpectedCondition<Boolean> expectation = new
					            ExpectedCondition<Boolean>() {
					                public Boolean apply(WebDriver driver) {
					                    return driver.findElement(By.xpath("//h3[contains(text(),'Main Applicant')]//following::input[2]")).getAttribute("value").length() !=0;
					                }
				};
				
				try {
			        wait.until(expectation);
			        txtAdd1.click();
			        txtAdd1.sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.DELETE));
			    } catch (Exception e) {
			    	txtAdd1.click();
					
			    }
									
				txtAdd1.sendKeys(add1);
				}
			
			
			//Set the State text box
			public void settxtState(String state)  {
					
					
					WebDriverWait wait = new WebDriverWait(ldriver, 1);
					 ExpectedCondition<Boolean> expectation = new
					            ExpectedCondition<Boolean>() {
					                public Boolean apply(WebDriver driver) {
					                    return driver.findElement(By.xpath("//h3[contains(text(),'Main Applicant')]//following::input[5]")).getAttribute("value").length() !=0;
					                }
				};
				
				try {
			        wait.until(expectation);
			        txtState.click();
			        txtState.sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.DELETE));
			    } catch (Exception e) {
			    	txtState.click();
					
			    }
									
				txtState.sendKeys(state);
				}
			
			//Set the Zip Code text box
			public void settxtZip(String zip)  {
					
					
					WebDriverWait wait = new WebDriverWait(ldriver, 1);
					 ExpectedCondition<Boolean> expectation = new
					            ExpectedCondition<Boolean>() {
					                public Boolean apply(WebDriver driver) {
					                    return driver.findElement(By.xpath("//h3[contains(text(),'Main Applicant')]//following::input[6]")).getAttribute("value").length() !=0;
					                }
				};
				
				try {
			        wait.until(expectation);
			        txtZip.click();
			        txtZip.sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.DELETE));
			    } catch (Exception e) {
			    	txtZip.click();
					
			    }
									
				txtZip.sendKeys(zip);
				}
			
			//Set the Phone text box
			public void settxtPhone(String phone)  {
					
					
					WebDriverWait wait = new WebDriverWait(ldriver, 1);
					 ExpectedCondition<Boolean> expectation = new
					            ExpectedCondition<Boolean>() {
					                public Boolean apply(WebDriver driver) {
					                    return driver.findElement(By.xpath("//h3[contains(text(),'Main Applicant')]//following::input[7]")).getAttribute("value").length() !=0;
					                }
				};
				
				try {
			        wait.until(expectation);
			        txtPhone.click();
			        txtPhone.sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.DELETE));
			    } catch (Exception e) {
			    	txtPhone.click();
					
			    }
									
				txtPhone.sendKeys(phone);
				}
			
			//Set the Position text box
			public void settxtPos(String position)  {
					
					
					WebDriverWait wait = new WebDriverWait(ldriver, 1);
					 ExpectedCondition<Boolean> expectation = new
					            ExpectedCondition<Boolean>() {
					                public Boolean apply(WebDriver driver) {
					                    return driver.findElement(By.xpath("//h3[contains(text(),'Main Applicant')]//following::input[9]")).getAttribute("value").length() !=0;
					                }
				};
				
				try {
			        wait.until(expectation);
			        txtPos.click();
			        txtPos.sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.DELETE));
			    } catch (Exception e) {
			    	txtPos.click();
					
			    }
									
				txtPos.sendKeys(position);
				}
			
			//Set the Supervisor text box
			public void settxtSup(String sup)  {
					
					
					WebDriverWait wait = new WebDriverWait(ldriver, 1);
					 ExpectedCondition<Boolean> expectation = new
					            ExpectedCondition<Boolean>() {
					                public Boolean apply(WebDriver driver) {
					                    return driver.findElement(By.xpath("//h3[contains(text(),'Main Applicant')]//following::input[8]")).getAttribute("value").length() !=0;
					                }
				};
				
				try {
			        wait.until(expectation);
			        txtSup.click();
			        txtSup.sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.DELETE));
			    } catch (Exception e) {
			    	txtSup.click();
					
			    }
									
				txtSup.sendKeys(sup);
				}
			
			//Set the Reason for leaving text box
			public void settxtReason(String reason)  {
					
					
					WebDriverWait wait = new WebDriverWait(ldriver, 1);
					 ExpectedCondition<Boolean> expectation = new
					            ExpectedCondition<Boolean>() {
					                public Boolean apply(WebDriver driver) {
					                    return driver.findElement(By.xpath("//h3[contains(text(),'Main Applicant')]//following::input[10]")).getAttribute("value").length() !=0;
					                }
				};
				
				try {
			        wait.until(expectation);
			        txtReason.click();
			        txtReason.sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.DELETE));
			    } catch (Exception e) {
			    	txtReason.click();
					
			    }
									
				txtReason.sendKeys(reason);
				}
			
			//Set the Annual Salary text box
			public void settxtSal(String salary)  {
					
					
					WebDriverWait wait = new WebDriverWait(ldriver, 1);
					 ExpectedCondition<Boolean> expectation = new
					            ExpectedCondition<Boolean>() {
					                public Boolean apply(WebDriver driver) {
					                    return driver.findElement(By.xpath("//h3[contains(text(),'Main Applicant')]//following::input[13]")).getAttribute("value").length() !=0;
					                }
				};
				
				try {
			        wait.until(expectation);
			        txtSal.click();
			        txtSal.sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.DELETE));
			    } catch (Exception e) {
			    	txtSal.click();
					
			    }
									
				txtSal.sendKeys(salary);
				}
			
			
	//Set the Work Start datepicker
	public void setWorkStart(String yyyy,String mon,String day)  {
		
		
		WebDriverWait wait = new WebDriverWait(ldriver, 35);
		wait.until(ExpectedConditions.elementToBeClickable(dateWorkStart));
		dateWorkStart.click();
		wait.until(ExpectedConditions.visibilityOf(btnWorkStartyy));
		btnWorkStartyy.click();
		
		
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
	
	//Set the Work End datepicker
		public void setWorkEnd(String yyyy,String mon,String day)  {
			
			
			WebDriverWait wait = new WebDriverWait(ldriver, 35);
			
			dateWorkEnd.click();
			wait.until(ExpectedConditions.visibilityOf(btnWorkEndyy));
			btnWorkEndyy.click();
			
			
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
		
		//Click on all Delete Employment History buttons
				public void clkbtnDelHis() throws InterruptedException {
					WebDriverWait wait = new WebDriverWait(ldriver, 4);
					ExpectedCondition<Boolean> expectation = new
				            ExpectedCondition<Boolean>() {
				                public Boolean apply(WebDriver driver) {
				                	return driver.findElement(By.xpath("//div[@class=' df'][1]/div/h3//following-sibling::div[1]/div/div/span[1]//input")).getAttribute("value").length() !=0;
				                }
				 	};
					try{
						wait.until(expectation);
					
				 			
					int size = btnDelHis.size();
					
					for (int i=1;i<=size;i++)
					{
						
						ldriver.findElement(By.xpath("//div[@class=' df'][1]/div/h3//descendant::span[2]")).click();
					
					}
					}
					catch(Exception e) {
						int size = btnDelHis.size();
						
						for (int i=1;i<=size;i++)
						{
							
							ldriver.findElement(By.xpath("//div[@class=' df'][1]/div/h3//descendant::span[2]")).click();
						
						}
					}
					
			}
		
		//Click on Add Employment History  button
		public void clkbtnAddHis() {
			WebDriverWait wait = new WebDriverWait(ldriver, 25);
			wait.until(ExpectedConditions.visibilityOf(btnAddHis));
			wait.until(ExpectedConditions.elementToBeClickable(btnAddHis));
			btnAddHis.click();
					}
		
		
		
		//Verify Employment History tab is displayed and selected
		public Boolean dispEmpHis() {
			WebDriverWait wait = new WebDriverWait(ldriver, 25);
			 ExpectedCondition<Boolean> expectation = new
			            ExpectedCondition<Boolean>() {
			                public Boolean apply(WebDriver driver) {
			                    return driver.findElement(By.xpath("//a[contains(@class,'v-tab')][3]")).getAttribute("aria-selected").equals("true");
			                }
			 	};
			wait.until(expectation);
			return true;
			}
		
		//Set the Employer text box for Employer History 2
		public void settxtEmployerHis2(String employer)  {
			
			
			WebDriverWait wait = new WebDriverWait(ldriver, 1);
			 ExpectedCondition<Boolean> expectation = new
			            ExpectedCondition<Boolean>() {
			                public Boolean apply(WebDriver driver) {
			                    return driver.findElement(By.xpath("//h3[contains(text(),'Main Applicant')]//following::input[1]")).getAttribute("value").length() !=0;
			                }
		};
		
		try {
	        wait.until(expectation);
	        txtEmployerHis2.click();
	        txtEmployerHis2.sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.DELETE));
	    } catch (Exception e) {
	    	txtEmployerHis2.click();
			
	    }
							
		txtEmployerHis2.sendKeys(employer);
		}
		
	//Set the Address Line 2 text box for Employer History 2
			public void settxtAdd2His2(String add2)  {
					
					
					WebDriverWait wait = new WebDriverWait(ldriver, 1);
					 ExpectedCondition<Boolean> expectation = new
					            ExpectedCondition<Boolean>() {
					                public Boolean apply(WebDriver driver) {
					                    return driver.findElement(By.xpath("//h3[contains(text(),'Main Applicant')]//following::input[3]")).getAttribute("value").length() !=0;
					                }
				};
				
				try {
			        wait.until(expectation);
			        txtAdd2His2.click();
			        txtAdd2His2.sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.DELETE));
			    } catch (Exception e) {
			    	txtAdd2His2.click();
					
			    }
									
				txtAdd2His2.sendKeys(add2);
				}
			
			//Set the City text box for Employer History 2
			public void settxtCityHis2(String city)  {
					
					
					WebDriverWait wait = new WebDriverWait(ldriver, 1);
					 ExpectedCondition<Boolean> expectation = new
					            ExpectedCondition<Boolean>() {
					                public Boolean apply(WebDriver driver) {
					                    return driver.findElement(By.xpath("//h3[contains(text(),'Main Applicant')]//following::input[4]")).getAttribute("value").length() !=0;
					                }
				};
				
				try {
			        wait.until(expectation);
			        txtCityHis2.click();
			        txtCityHis2.sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.DELETE));
			    } catch (Exception e) {
			    	txtCityHis2.click();
					
			    }
									
				txtCityHis2.sendKeys(city);
				}
			
			//Set the Address Line 1 text box for Employer History 2
			public void settxtAdd1His2(String add1)  {
					
					
					WebDriverWait wait = new WebDriverWait(ldriver, 1);
					 ExpectedCondition<Boolean> expectation = new
					            ExpectedCondition<Boolean>() {
					                public Boolean apply(WebDriver driver) {
					                    return driver.findElement(By.xpath("//h3[contains(text(),'Main Applicant')]//following::input[2]")).getAttribute("value").length() !=0;
					                }
				};
				
				try {
			        wait.until(expectation);
			        txtAdd1His2.click();
			        txtAdd1His2.sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.DELETE));
			    } catch (Exception e) {
			    	txtAdd1His2.click();
					
			    }
									
				txtAdd1His2.sendKeys(add1);
				}
			
			//Set the State text box for Employer History 2
			public void settxtStateHis2(String state)  {
					
					
					WebDriverWait wait = new WebDriverWait(ldriver, 1);
					 ExpectedCondition<Boolean> expectation = new
					            ExpectedCondition<Boolean>() {
					                public Boolean apply(WebDriver driver) {
					                    return driver.findElement(By.xpath("//h3[contains(text(),'Main Applicant')]//following::input[5]")).getAttribute("value").length() !=0;
					                }
				};
				
				try {
			        wait.until(expectation);
			        txtStateHis2.click();
			        txtStateHis2.sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.DELETE));
			    } catch (Exception e) {
			    	txtStateHis2.click();
					
			    }
									
				txtStateHis2.sendKeys(state);
				}
			
			//Set the Zip Code text box for Employer History 2
			public void settxtZipHis2(String zip)  {
					
					
					WebDriverWait wait = new WebDriverWait(ldriver, 1);
					 ExpectedCondition<Boolean> expectation = new
					            ExpectedCondition<Boolean>() {
					                public Boolean apply(WebDriver driver) {
					                    return driver.findElement(By.xpath("//h3[contains(text(),'Main Applicant')]//following::input[6]")).getAttribute("value").length() !=0;
					                }
				};
				
				try {
			        wait.until(expectation);
			        txtZipHis2.click();
			        txtZipHis2.sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.DELETE));
			    } catch (Exception e) {
			    	txtZipHis2.click();
					
			    }
									
				txtZipHis2.sendKeys(zip);
				}
			
			//Set the Phone text box for Employer History 2
			public void settxtPhoneHis2(String phone)  {
					
					
					WebDriverWait wait = new WebDriverWait(ldriver, 1);
					 ExpectedCondition<Boolean> expectation = new
					            ExpectedCondition<Boolean>() {
					                public Boolean apply(WebDriver driver) {
					                    return driver.findElement(By.xpath("//h3[contains(text(),'Main Applicant')]//following::input[7]")).getAttribute("value").length() !=0;
					                }
				};
				
				try {
			        wait.until(expectation);
			        txtPhoneHis2.click();
			        txtPhoneHis2.sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.DELETE));
			    } catch (Exception e) {
			    	txtPhoneHis2.click();
					
			    }
									
				txtPhoneHis2.sendKeys(phone);
				}
			
			//Set the Position text box for Employer History 2
			public void settxtPosHis2(String position)  {
					
					
					WebDriverWait wait = new WebDriverWait(ldriver, 1);
					 ExpectedCondition<Boolean> expectation = new
					            ExpectedCondition<Boolean>() {
					                public Boolean apply(WebDriver driver) {
					                    return driver.findElement(By.xpath("//h3[contains(text(),'Main Applicant')]//following::input[9]")).getAttribute("value").length() !=0;
					                }
				};
				
				try {
			        wait.until(expectation);
			        txtPosHis2.click();
			        txtPosHis2.sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.DELETE));
			    } catch (Exception e) {
			    	txtPosHis2.click();
					
			    }
									
				txtPosHis2.sendKeys(position);
				}
			
			//Set the Supervisor text box for Employer History 2
			public void settxtSupHis2(String sup)  {
					
					
					WebDriverWait wait = new WebDriverWait(ldriver, 1);
					 ExpectedCondition<Boolean> expectation = new
					            ExpectedCondition<Boolean>() {
					                public Boolean apply(WebDriver driver) {
					                    return driver.findElement(By.xpath("//h3[contains(text(),'Main Applicant')]//following::input[8]")).getAttribute("value").length() !=0;
					                }
				};
				
				try {
			        wait.until(expectation);
			        txtSupHis2.click();
			        txtSupHis2.sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.DELETE));
			    } catch (Exception e) {
			    	txtSupHis2.click();
					
			    }
									
				txtSupHis2.sendKeys(sup);
				}
			
			//Set the Reason for leaving text box for Employer History 2
			public void settxtReasonHis2(String reason)  {
					
					
					WebDriverWait wait = new WebDriverWait(ldriver, 1);
					 ExpectedCondition<Boolean> expectation = new
					            ExpectedCondition<Boolean>() {
					                public Boolean apply(WebDriver driver) {
					                    return driver.findElement(By.xpath("//h3[contains(text(),'Main Applicant')]//following::input[10]")).getAttribute("value").length() !=0;
					                }
				};
				
				try {
			        wait.until(expectation);
			        txtReasonHis2.click();
			        txtReasonHis2.sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.DELETE));
			    } catch (Exception e) {
			    	txtReasonHis2.click();
					
			    }
									
				txtReasonHis2.sendKeys(reason);
				}
			
			//Set the Annual Salary text box for Employer History 2
			public void settxtSalHis2(String salary)  {
					
					
					WebDriverWait wait = new WebDriverWait(ldriver, 1);
					 ExpectedCondition<Boolean> expectation = new
					            ExpectedCondition<Boolean>() {
					                public Boolean apply(WebDriver driver) {
					                    return driver.findElement(By.xpath("//h3[contains(text(),'Main Applicant')]//following::input[13]")).getAttribute("value").length() !=0;
					                }
				};
				
				try {
			        wait.until(expectation);
			        txtSalHis2.click();
			        txtSalHis2.sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.DELETE));
			    } catch (Exception e) {
			    	txtSalHis2.click();
					
			    }
									
				txtSalHis2.sendKeys(salary);
				}
			
			
	//Set the Work Start datepicker for Employer History 2
	public void setWorkStartHis2(String yyyy,String mon,String day)  {
		
		
		WebDriverWait wait = new WebDriverWait(ldriver, 35);
		wait.until(ExpectedConditions.elementToBeClickable(dateWorkStartHis2));
		dateWorkStartHis2.click();
		wait.until(ExpectedConditions.visibilityOf(btnWorkStartyyHis2));
		btnWorkStartyyHis2.click();
		
		
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
		
		for(WebElement d: lstdd)
		{
			if(d.getText().equalsIgnoreCase(day))
			{
				d.click();
				break;
			}
		}
		
		
	}
	
	//Set the Work End datepicker for Employer History 2
		public void setWorkEndHis2(String yyyy,String mon,String day)  {
			
			
			WebDriverWait wait = new WebDriverWait(ldriver, 35);
			
			dateWorkEndHis2.click();
			wait.until(ExpectedConditions.visibilityOf(btnWorkEndyyHis2));
			btnWorkEndyyHis2.click();
			
			
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
			for(WebElement d: lstdd)
			{
				if(d.getText().equalsIgnoreCase(day))
				{
					d.click();
					break;
				}
			}
			
			
		}
		
		//Check if the Address line 1 error message is displayed 				
		public boolean addressLine1ErrorIsDisplayed() {
			
			WebDriverWait wait = new WebDriverWait(ldriver, 5);
			try {
				wait.until(ExpectedConditions.visibilityOf(ldriver.findElement(By.xpath("//*[text()='The Address Line 1 field is required']"))));	
			}
			catch(Exception e)
			{
				return false;
			}
			return true;	
		}
		
		//Check if the error message is displayed if City is left black				
		public boolean cityErrorIsDisplayed() {
		
			WebDriverWait wait = new WebDriverWait(ldriver, 5);
			try {
				wait.until(ExpectedConditions.visibilityOf(ldriver.findElement(By.xpath("//*[text()='The City field is required']"))));	
			}
			catch(Exception e)
				{
					return false;
				}
			return true;	
				}
		
		//Check if the error message is displayed if State/Province Code is left black
		public boolean stateErrorIsDisplayed() {
			WebDriverWait wait = new WebDriverWait(ldriver, 5);
			try {
				wait.until(ExpectedConditions.visibilityOf(ldriver.findElement(By.xpath("//*[text()='The State/Province field is required']"))));	
			}
			catch(Exception e)
				{
					return false;
				}
			return true;
		}
		
		//Check if the error message is displayed if ZIP/Postal Code is left blank		
		public boolean zipErrorIsDisplayed() {
			WebDriverWait wait = new WebDriverWait(ldriver, 5);
			try {
				wait.until(ExpectedConditions.visibilityOf(ldriver.findElement(By.xpath("//*[text()='The Zip/Postal Code field is required']"))));	
			}
			catch(Exception e)
				{
					return false;
				}
			return true;
		}
		//Check if the error message is displayed if Phone is left blank	
		public boolean phoneErrorIsDisplayed() {
			WebDriverWait wait = new WebDriverWait(ldriver, 5);
			try {
				wait.until(ExpectedConditions.visibilityOf(ldriver.findElement(By.xpath("//*[text()='The Phone field is required']"))));	
			}
			catch(Exception e)
				{
					return false;
				}
			return true;
		}
		//Check if the error message is displayed if Supervisor is left blank
		public boolean supervisorErrorIsDisplayed() {
			// 
			WebDriverWait wait = new WebDriverWait(ldriver, 5);
			try {
				wait.until(ExpectedConditions.visibilityOf(ldriver.findElement(By.xpath("//*[text()='The Supervisor field is required']"))));	
			}
			catch(Exception e)
				{
					return false;
				}
			return true;
		}
		//Check if the error message is displayed if Position is left blank
		public boolean positionErrorIsDisplayed() {
			// 
			WebDriverWait wait = new WebDriverWait(ldriver, 5);
			try {
				wait.until(ExpectedConditions.visibilityOf(ldriver.findElement(By.xpath("//*[text()='The Position field is required']"))));	
			}
			catch(Exception e)
				{
					return false;
				}
			return true;
		}
		//This method will check if the provided error is displayed on the page
		public boolean missingErrorIsDisplayed(String expectedError) {
			WebDriverWait wait = new WebDriverWait(ldriver, 5);
			try {
				wait.until(ExpectedConditions.visibilityOf(ldriver.findElement(By.xpath("//*[text()='"+expectedError+"']"))));	
			}
			catch(Exception e)
				{
					return false;
				}
			return true;
		}



		//This method will move the Webelement passed as an argument out of focus by sending TAB key to that element
				public void moveOutOfFocus(WebElement txtState2) {
					txtState2.sendKeys(Keys.TAB);
				}

			

			
			
			



}
