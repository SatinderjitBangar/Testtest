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
 *
 *This test case is to verify whether first name in the Personal info page can be left blank or whether it accepts special characters/numbers 

Login with valid credentials

Case 1: Leave the first name field blank > Click on next tab Last Name

Case 2: Enter more than 20 characters in the first name field

Case 3: Enter special characters in the first name field

Case 4: Enter numbers in the first name field

Case 5: Enter combination of special characters, numbers and alphabets

Acceptance Criteria:

The following will happen for the test case to be considered successful:

Case 1 :AC.User should get error message"The First Name field is required”

Case 2: AC: User should get error message “The First Name field may not be greater than 20 characters”

Case 3. AC: User should get error message “The First Name field format is invalid”

Case 4. AC: User should get error message “The First Name field format is invalid”

Case 5. AC: User should get error message “The First Name field format is invalid”


 */
public class TC_CPM_014 extends BaseClass {

	@Test(priority=1,dataProvider="DataTC_CPM_014")
	public void tc_cpm_014(String location,String numBed,String numBath,String numGarage,String minRate,String maxRate,String firstName,String errMsg)   {
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		logger.info("TC_CPM_014 started");
				
				
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

				
		
		//Setting First Name on personal info page
		personalInfopage.settxtFirstName(firstName);
		logger.info("First Name Entered");
		//Click on next text box ie Last Name
		personalInfopage.clkTxtLastName();
		logger.info("Clicked on next text box ie Last Name");
		
			
		
		//Assertion AC01:Verify if Error Message is displayed 
					
		if (personalInfopage.txtErrFirstName.isDisplayed() && personalInfopage.txtErrFirstName.getText().equals(errMsg) ) {
			softassert.assertTrue(true);
			logger.info("Passed AC01:Invalid First Name:" + firstName + " Error Displayed:" + errMsg);
		} 
		else {
			softassert.assertTrue(false);
			logger.error("Failed AC01:Error NOT displayed or mismatch for Invalid First Name:" + firstName);
		}

		softassert.assertAll();
	}
	
	//Excel Data Provider Method  
			@DataProvider (name="DataTC_CPM_014")
			public Object[][] testData () throws IOException
			{		
				return XLUtils.getData(Excel_Path, "TC_CPM_014");				

			}

}
