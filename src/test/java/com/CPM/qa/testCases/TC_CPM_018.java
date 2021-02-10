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
This test case is to verify whether Phone field can accept blank or invalid characters.

Login with valid credentials

Case 1: Leave the phone field blankCase 2: Enter phone number less than 10 digit e.g. 9876789Case 3: Enter phone number more than 10 digit e.g. 987654321234Case 4: Enter phone number with special characters e.g. 987#$&%(12Case 5: Enter phone number with alphabets e.g. ADGB6799GH

Acceptance Criteria:

The following will happen for the test case to be considered successful:Case 1: AC: User should get error message "The Phone field is required”

Case 2: AC: User should get error message "The Phone field must be 10 long”

Case 1: AC: User should get error message "The Phone field must be 10 long”

Case 1: AC: User should get error message "The Phone field format is invalid”

Case 1: AC: User should get error message "The Phone field format is invalid”
 */
public class TC_CPM_018 extends BaseClass {

	@Test(priority=1,dataProvider="DataTC_CPM_018")
	public void tc_cpm_018(String location,String numBed,String numBath,String numGarage,String minRate,String maxRate,String phone,String errMsg)   {
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		logger.info("TC_CPM_018 started");
				
				
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

				
		
		//Setting Phone on personal info page
		personalInfopage.settxtPhone(phone);
		logger.info("Phone Entered");
		//Click on next text box ie Driving License
		personalInfopage.clktxtDl();
		logger.info("Clicked on next text box ie Driving License");
		
			
		
		//Assertion AC01:Verify if Error Message is displayed 
					
		if (personalInfopage.txtErrPhone.isDisplayed() && personalInfopage.txtErrPhone.getText().equals(errMsg) ) {
			softassert.assertTrue(true);
			logger.info("Passed AC01:Invalid Phone number:" + phone + " Error Displayed:" + errMsg);
		} 
		else {
			softassert.assertTrue(false);
			logger.error("Failed AC01:Error NOT displayed or mismatch for Invalid Phone number:" + phone);
		}

		softassert.assertAll();
	}
	
	//Excel Data Provider Method  
			@DataProvider (name="DataTC_CPM_018")
			public Object[][] testData () throws IOException
			{		
				return XLUtils.getData(Excel_Path, "TC_CPM_018");				

			}

}
