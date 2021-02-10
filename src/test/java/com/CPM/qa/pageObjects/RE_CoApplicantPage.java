package com.CPM.qa.pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RE_CoApplicantPage {

public WebDriver ldriver;
	
	//Constructor
	public RE_CoApplicantPage(WebDriver rdriver)
	{
		ldriver = rdriver;
		PageFactory.initElements(rdriver,this);
	}
	
	//Capture the link Co-Applicant in tab
	@FindBy(xpath="//a[contains(@class,'v-tab')][2]")
	@CacheLookup
	public WebElement lnkCoApp;
	
	//Capture the First name text box in co-applicant info form
	@FindBy(xpath="//div[@class='wrapper df']/div[1]//span[1]//input")
	@CacheLookup
	public WebElement txtFirstName;
			
	//Capture the Last name text box in co-applicant info form
	@FindBy(xpath="//div[@class='wrapper df']/div[1]//span[2]//input")
	@CacheLookup
	public WebElement txtLastName;
			
	//Capture the Preferred name text box in co-applicant info form
	@FindBy(xpath="//div[@class='wrapper df']/div[1]//span[3]//input")
	@CacheLookup
	public WebElement txtPrefName;
	
	//Capture the Date of Birth Date picker in co-applicant info form
	@FindBy(xpath="//div[@class='wrapper df']/div[1]//span[4]//input")
	@CacheLookup
	public WebElement dateDOB;
	
	//Capture the Date of Birth year button in date picker
	@FindBy(xpath="//div[@class='v-menu__content theme--light menuable__content__active']/div/div[1]/div/div[1]")
	@CacheLookup
	public WebElement btnDOByyyy;
	
	
	//Capture the Phone text box in co-applicant info form
	@FindBy(xpath="//div[@class='wrapper df']/div[1]//span[5]//input")
	@CacheLookup
	public WebElement txtPhone;
	
	//Capture the Driver License/others text box in co-applicant info form
	@FindBy(xpath="//div[@class='wrapper df']/div[2]//span[1]//input")
	@CacheLookup
	public WebElement txtDl;
	
	//Capture the State/Province text box in co-applicant info form
	@FindBy(xpath="//div[@class='wrapper df']/div[2]//span[2]//input")
	@CacheLookup
	public WebElement txtState;
	
	//Capture the Expiry Date datepicker
	@FindBy(xpath="//div[@class='wrapper df']/div[2]//span[3]//input")
	@CacheLookup
	public WebElement dateExp;
	
			
	//Capture the Social Security text box in co-applicant info form
	@FindBy(xpath="//div[@class='wrapper df']/div[2]//span[4]//input")
	@CacheLookup
	public WebElement txtSSN;
	
	//Capture the Next button in co-applicant info form
	@FindBy(xpath="//span[normalize-space()='NEXT']")
	@CacheLookup
	public WebElement btnNxt;
	
	//Capture Error message if First Name filed is wrongly entered or blank
	@FindBy(xpath="//p[contains(text(),'The First Name field')]")
	@CacheLookup
	public WebElement txtErrFirstName;
	
	//Capture Error message if Last Name filed is wrongly entered or blank
	@FindBy(xpath="//p[contains(text(),'The Last Name field')]")
	@CacheLookup
	public WebElement txtErrLastName;
	
	//Capture Error message if Preferred Name filed is wrongly entered or blank
	@FindBy(xpath="//p[contains(text(),'The Preferred Name field')]")
	@CacheLookup
	public WebElement txtErrPrefName;
	
	//Capture Error message if Phone filed is wrongly entered or blank
	@FindBy(xpath="//p[contains(text(),'The Phone field')]")
	@CacheLookup
	public WebElement txtErrPhone;
	
	//Capture Error message if Driving License filed is wrongly entered or blank
	@FindBy(xpath="//p[contains(text(),\"The Driver's License field\")]")
	@CacheLookup
	public WebElement txtErrDl;
	
	//Capture Error message if Social Security Number filed is wrongly entered or blank
	@FindBy(xpath="//p[contains(text(),'The Social Security field')]")
	@CacheLookup
	public WebElement txtErrSnn;
	
	//Capture Error message if State filed is wrongly entered or blank
	@FindBy(xpath="//p[contains(text(),'The State / Province field')]")
	@CacheLookup
	public WebElement txtErrState;
	
	//Capture Error message if DOB filed is blank
	@FindBy(xpath="//div[@class='v-dialog v-dialog--active v-dialog--persistent']/div/div[1]")
	@CacheLookup
	public WebElement txtErrDate;



// =======================ACTION METHOD=============================//


//Set the First Name text box
	public void settxtFirstName(String firstName)  {
		
		
		WebDriverWait wait = new WebDriverWait(ldriver, 5);
		 ExpectedCondition<Boolean> expectation = new
		            ExpectedCondition<Boolean>() {
		                public Boolean apply(WebDriver driver) {
		                    return driver.findElement(By.xpath("//div[@class='wrapper df']/div[1]//span[1]//input")).getAttribute("value").length() !=0;
		                }
	};
	
	try {
        wait.until(expectation);
        txtFirstName.click();
		txtFirstName.sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.DELETE));
    } catch (Exception e) {
    	txtFirstName.click();
		
    }
						
		txtFirstName.sendKeys(firstName);
	}
	
				
	//Set the Last Name text box
	public void settxtLastName(String lastName) {
		WebDriverWait wait = new WebDriverWait(ldriver, 5);
		 ExpectedCondition<Boolean> expectation = new
		            ExpectedCondition<Boolean>() {
		                public Boolean apply(WebDriver driver) {
		                    return driver.findElement(By.xpath("//div[@class='wrapper df']/div[1]//span[2]//input")).getAttribute("value").length() !=0;
		                }
	};
	
	try {
        wait.until(expectation);
        txtLastName.click();
        txtLastName.sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.DELETE));
    } catch (Exception e) {
    	txtLastName.click();
		
    }
						
	txtLastName.sendKeys(lastName);
	}
	
	//Set the Preferred Name text box
	public void settxtPrefName(String prefName) {
		WebDriverWait wait = new WebDriverWait(ldriver, 5);
		 ExpectedCondition<Boolean> expectation = new
		            ExpectedCondition<Boolean>() {
		                public Boolean apply(WebDriver driver) {
		                    return driver.findElement(By.xpath("//div[@class='wrapper df']/div[1]//span[3]//input")).getAttribute("value").length() !=0;
		                }
	};
	
	try {
        wait.until(expectation);
        txtPrefName.click();
        txtPrefName.sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.DELETE));
    } catch (Exception e) {
    	txtPrefName.click();
		
    }
						
	txtPrefName.sendKeys(prefName);
	}
	
	//Set the Date of Birth datepicker
	public void setDOB(String yyyy,String mon,String day)  {
		
		
		WebDriverWait wait = new WebDriverWait(ldriver, 35);
		
		dateDOB.click();
		wait.until(ExpectedConditions.visibilityOf(btnDOByyyy));
		btnDOByyyy.click();
		
		
		List<WebElement> lstDOByyyy = ldriver.findElements(By.xpath("//ul[@class='v-date-picker-years']/li"));
		wait.until(ExpectedConditions.visibilityOfAllElements(lstDOByyyy));
		for(WebElement y: lstDOByyyy)
		{
			if(y.getText().equalsIgnoreCase(yyyy))
			{
				y.click();
				break;
			}
		}
		
		
		
		
		List<WebElement> lstDOBmm = ldriver.findElements(By.xpath("//div[@class='v-date-picker-table v-date-picker-table--month theme--light']//table//td"));
		wait.until(ExpectedConditions.visibilityOfAllElements(lstDOBmm));
		
		for(WebElement m: lstDOBmm)
		{
			if(m.getText().equalsIgnoreCase(mon))
			{
				wait.until(ExpectedConditions.visibilityOf(m));
				m.click();
				break;
			}
		}
		
		List<WebElement> lstDOBdd = ldriver.findElements(By.xpath("//div[@class='v-date-picker-table v-date-picker-table--date theme--light']//table//td"));
		wait.until(ExpectedConditions.visibilityOfAllElements(lstDOBdd));
		for(WebElement d: lstDOBdd)
		{
			if(d.getText().equalsIgnoreCase(day))
			{
				d.click();
				break;
			}
		}
		
		
	}
	
	//Set the Phone text box
	public void settxtPhone(String phone) {
		JavascriptExecutor js = (JavascriptExecutor) ldriver;
		js.executeScript("window.scrollBy(0,100)");
		WebDriverWait wait = new WebDriverWait(ldriver, 5);
		 ExpectedCondition<Boolean> expectation = new
		            ExpectedCondition<Boolean>() {
		                public Boolean apply(WebDriver driver) {
		                    return driver.findElement(By.xpath("//div[@class='wrapper df']/div[1]//span[5]//input")).getAttribute("value").length() !=0;
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
	
	//Set the Driving License/others text box
	public void settxtDl(String dlNum) {
		WebDriverWait wait = new WebDriverWait(ldriver, 5);
		 ExpectedCondition<Boolean> expectation = new
		            ExpectedCondition<Boolean>() {
		                public Boolean apply(WebDriver driver) {
		                    return driver.findElement(By.xpath("//div[@class='wrapper df']/div[2]//span[1]//input")).getAttribute("value").length() !=0;
		                }
	};
	
	try {
        wait.until(expectation);
        txtDl.click();
        txtDl.sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.DELETE));
    } catch (Exception e) {
    	txtDl.click();
		
    }
						
	txtDl.sendKeys(dlNum);
	}
	
	//Set the State/Province text box
	public void settxtState(String state) {
		WebDriverWait wait = new WebDriverWait(ldriver, 5);
		 ExpectedCondition<Boolean> expectation = new
		            ExpectedCondition<Boolean>() {
		                public Boolean apply(WebDriver driver) {
		                    return driver.findElement(By.xpath("//div[@class='wrapper df']/div[2]//span[2]//input")).getAttribute("value").length() !=0;
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
	
	//Set the Expire date date picker
			
	public void setExpDate(String yyyy,String mon,String day)   {
		
		
		WebDriverWait wait = new WebDriverWait(ldriver, 25);
		
		dateExp.click();
		
		WebElement btnExpyyyy =ldriver.findElement(By.xpath("//div[@class='v-menu__content theme--light menuable__content__active']/div/div[1]/div/div[1]"));
		
		btnExpyyyy.click();
		
		List<WebElement> lstExpyyyy = ldriver.findElements(By.xpath("//ul[@class='v-date-picker-years']/li"));
		wait.until(ExpectedConditions.visibilityOfAllElements(lstExpyyyy));
		for(WebElement y: lstExpyyyy)
		{
			if(y.getText().equalsIgnoreCase(yyyy))
			{
				y.click();
				break;
			}
		}
		
		
		
		
		List<WebElement> lstExpmm = ldriver.findElements(By.xpath("//div[@class='v-date-picker-table v-date-picker-table--month theme--light']//table//td"));
		wait.until(ExpectedConditions.visibilityOfAllElements(lstExpmm));
		
		for(WebElement m: lstExpmm)
		{
			if(m.getText().equalsIgnoreCase(mon))
			{
				wait.until(ExpectedConditions.visibilityOf(m));
				m.click();
				break;
			}
		}
		
		List<WebElement> lstExpdd = ldriver.findElements(By.xpath("//div[@class='v-date-picker-table v-date-picker-table--date theme--light']//table//td"));
		
		for(WebElement d: lstExpdd)
		{
			if(d.getText().equalsIgnoreCase(day))
			{
				d.click();
				break;
			}
		}
		
		
	}			
				
			
	
	//Set the Social Security Number text box
	public void settxtSSN(String ssnNum) {
		WebDriverWait wait = new WebDriverWait(ldriver, 5);
		 ExpectedCondition<Boolean> expectation = new
		            ExpectedCondition<Boolean>() {
		                public Boolean apply(WebDriver driver) {
		                    return driver.findElement(By.xpath("//div[@class='wrapper df']/div[2]//span[4]//input")).getAttribute("value").length() !=0;
		                }
	};
	
	try {
        wait.until(expectation);
        txtSSN.click();
        txtSSN.sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.DELETE));
    } catch (Exception e) {
    	txtSSN.click();
		
    }
						
	txtSSN.sendKeys(ssnNum);
	}
	
	//Click on Next button
	public void clkbtnNxt() {
		WebDriverWait wait = new WebDriverWait(ldriver, 25);
		wait.until(ExpectedConditions.visibilityOf(btnNxt));
		wait.until(ExpectedConditions.elementToBeClickable(btnNxt));
		btnNxt.click();
		}
	
	//Click on LastName text box
	public void clkTxtLastName() {
		WebDriverWait wait = new WebDriverWait(ldriver, 25);
		wait.until(ExpectedConditions.visibilityOf(txtLastName));
		wait.until(ExpectedConditions.elementToBeClickable(txtLastName));
		txtLastName.click();
		}
	
	//Click on Preferred Name text box
	public void clkTxtPrefName() {
		WebDriverWait wait = new WebDriverWait(ldriver, 25);
		wait.until(ExpectedConditions.visibilityOf(txtPrefName));
		wait.until(ExpectedConditions.elementToBeClickable(txtPrefName));
		txtPrefName.click();
		}
	
	//Click on Date of Birth datepicker
	public void clkdateDOB() {
		WebDriverWait wait = new WebDriverWait(ldriver, 25);
		wait.until(ExpectedConditions.visibilityOf(dateDOB));
		wait.until(ExpectedConditions.elementToBeClickable(dateDOB));
		dateDOB.click();
		}
	
	//Click on Driving License textbox
	public void clktxtDl() {
		WebDriverWait wait = new WebDriverWait(ldriver, 25);
		wait.until(ExpectedConditions.visibilityOf(txtDl));
		wait.until(ExpectedConditions.elementToBeClickable(txtDl));
		txtDl.click();
		}
	
	//Click on State textbox
	public void clktxtState() {
		WebDriverWait wait = new WebDriverWait(ldriver, 25);
		wait.until(ExpectedConditions.visibilityOf(txtState));
		wait.until(ExpectedConditions.elementToBeClickable(txtState));
		txtState.click();
		}
	
	//Click on First Name textbox
	public void clktxtFirstName() {
		WebDriverWait wait = new WebDriverWait(ldriver, 25);
		wait.until(ExpectedConditions.visibilityOf(txtFirstName));
		wait.until(ExpectedConditions.elementToBeClickable(txtFirstName));
		txtFirstName.click();
		}
	
	//Click on Expiry Date datepicker
	public void clkdateExp() {
		WebDriverWait wait = new WebDriverWait(ldriver, 25);
		wait.until(ExpectedConditions.visibilityOf(dateExp));
		wait.until(ExpectedConditions.elementToBeClickable(dateExp));
		dateExp.click();
		}
	
	//Verify Co-Applicant tab is displayed and selected
	public Boolean dispCoApp() {
		WebDriverWait wait = new WebDriverWait(ldriver, 25);
		 ExpectedCondition<Boolean> expectation = new
		            ExpectedCondition<Boolean>() {
		                public Boolean apply(WebDriver driver) {
		                    return driver.findElement(By.xpath("//a[contains(@class,'v-tab')][2]")).getAttribute("aria-selected").equals("true");
		                }
		 	};
		wait.until(expectation);
		return true;
		}

}
