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
This test case is to verify that State/Province field should not be left blank or accept invalid charactersSteps to reproduce:

Login with valid credentials

Validate following details in the State/Province field :
Case 1: Leave the State/Province field blank
Case 2: Enter more than 20 characters in the State/Province field
Case 3: Enter special characters in the State/Province field
Case 4: Enter numbers in the State/Province field
Case 5: Enter combination of special characters, numbers and alphabets

Acceptance Criteria:

The following will happen for the test case to be considered successful:


AC01:Case 1: User should get error message "The State / Province field is required"
	 Case 2: User should get error message “The State / Province field may not be greater than 20 characters”
	 Case 3: User should get error message "The State / Province field format is invalid”
	 Case 4: User should get error message “The State / Province field format is invalid”
	 Case 5: User should get error message “The State / Province field format is invalid”
 */
public class TC_CPM_096 extends BaseClass {

	@Test(priority=1,dataProvider="DataTC_CPM_096")
	public void tc_cpm_096(String location,String numBed,String numBath,String numGarage,String minRate,String maxRate,String state,String errMsg)   {
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		logger.info("TC_CPM_096 started");
				
				
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

				
		
		//Setting State on personal info page
		personalInfopage.settxtState(state);
		logger.info("State Entered");
		//Click on next text box ie Expiry Date
		personalInfopage.clkdateExp();
		logger.info("Clicked on next text box ie Expiry Date");
		
			
		
		//Assertion AC01:Verify if Error Message is displayed 
					
		if (personalInfopage.txtErrState.isDisplayed() && personalInfopage.txtErrState.getText().equals(errMsg) ) {
			softassert.assertTrue(true);
			logger.info("Passed AC01:Invalid State:" + state + " Error Displayed:" + errMsg);
		} 
		else {
			softassert.assertTrue(false);
			logger.error("Failed AC01:Error NOT displayed or mismatch for Invalid State" + state);
		}

		softassert.assertAll();
	}
	
	//Excel Data Provider Method  
			@DataProvider (name="DataTC_CPM_096")
			public Object[][] testData () throws IOException
			{		
				return XLUtils.getData(Excel_Path, "TC_CPM_096");				

			}

}
