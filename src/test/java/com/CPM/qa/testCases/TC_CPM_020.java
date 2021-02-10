package com.CPM.qa.testCases;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.CPM.qa.baseClass.BaseClass;
import com.CPM.qa.pageObjects.LandingPage;
import com.CPM.qa.pageObjects.LoginPage;
import com.CPM.qa.pageObjects.RE_EmploymentHistoryPage;
import com.CPM.qa.pageObjects.RE_HomePage;
import com.CPM.qa.pageObjects.RE_PersonalInfoPage;
import com.CPM.qa.pageObjects.SignUpPage;
import com.CPM.qa.utilities.XLUtils;
/*
This test case is to verify that SSN/SIN field should not be left blank or accept invalid characters

Login with valid credentials

Case 1: Leave the SSN/SIN field blank

Case 2: Enter less than 9 numbers in the SSN/SIN field

Case 3: Enter more than 15 numbers in the SSN/SIN field

Case 4: Enter special characters in the SSN/SIN field

Case 5: Enter alphabets in the SSN/SIN field

Case 6: Enter combination of special characters, numbers and alphabets

Acceptance Criteria:

The following will happen for the test case to be considered successful:

Case1 : AC: User should get error message "The Social Security field is required"

Case2: AC: User should get error message “The Social Security field must be 9 long”

Case 3: AC: User should get error message "The Social Security field may not be greater than 15 characters”

Case 4: AC: User should get error message “The Social Security field format is invalid”

Case 5: AC: User should get error message “The Social Security field format is invalid”

Case 6: AC: User should get error message “The Social Security field format is invalid”
 */
public class TC_CPM_020 extends BaseClass {

	@Test(priority=1,dataProvider="DataTC_CPM_020")
	public void tc_cpm_020(String location,String numBed,String numBath,String numGarage,String minRate,String maxRate,String snnNum,String errMsg)   {
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		logger.info("TC_CPM_020 started");
				
				
		// Creating object for LandingPage
		LandingPage landingpage = new LandingPage(driver);
		
		// Assert whether the renter login is successful
		SoftAssert softassert = new SoftAssert();
								
		//Set Location
		landingpage.settxtSearchLoc(location);
		logger.info("Setting Search location");
		
		//Set search filters		
		landingpage.setSrchFilters(numBed, numBath, numGarage, minRate, maxRate);
		logger.info("Setting Search Filters");
							
		//Click on Get Started button
		landingpage.clkbtnGetStarted();
		logger.info("Clicked on Get Started button");
					
		//Click on Apply Button
		landingpage.clkbtnApply();
		logger.info("Clicked on Apply button");
		
		//Create an object of SignUp page
		SignUpPage signuppage = new SignUpPage(driver);
		
		//Click on Sign in Link
		signuppage.clklnkSignin();
		logger.info("Clicked on Signin");
		
		//Create an object for Login page
		LoginPage loginpg = new LoginPage(driver);
		
		//Set Username
		loginpg.settxtEmail(username1);
		//Set Password
		loginpg.settxtpassword(password1);
		//Click on login
		loginpg.clkbtnLogin();
		logger.info("Clicked on Login");
		
		// Creating object for PersonalInfoPage
		RE_PersonalInfoPage personalInfopage = new RE_PersonalInfoPage(driver);

				
		
		//Setting Social Security Number on personal info page
		personalInfopage.settxtSSN(snnNum);
		logger.info("Social Security Number Entered");
		//Click on next text box ie First Name
		personalInfopage.clktxtFirstName();
		logger.info("Clicked on next text box ie First Name");
		
			
		
		//Assertion AC01:Verify if Error Message is displayed 
					
		if (personalInfopage.txtErrSnn.isDisplayed() && personalInfopage.txtErrSnn.getText().equals(errMsg) ) {
			softassert.assertTrue(true);
			logger.info("Passed AC01:Invalid Social Security Number:" + snnNum + " Error Displayed:" + errMsg);
		} 
		else {
			softassert.assertTrue(false);
			logger.error("Failed AC01:Error NOT displayed or mismatch for Invalid Social Security Number:" + snnNum);
		}

		softassert.assertAll();
	}
	
	//Excel Data Provider Method  
			@DataProvider (name="DataTC_CPM_020")
			public Object[][] testData () throws IOException
			{		
				return XLUtils.getData(Excel_Path, "TC_CPM_020");				

			}

}
