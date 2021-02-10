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
This test case is to verify whether Driving License field can be left blank

Case 1: Leave the DL field blank
Case 2: Enter digits less than 8
Case 3: Enter digits More than 25 
Case 4: Enter DL with special characters e.g.AB#$^%%89

Acceptance Criteria:

The following will happen for the test case to be considered successful:

Case1: AC: User should get error message "Please enter your driving license number"

Case2: AC: User should get error message "The Driver's License / Others field must be at least 8 characters”

Case3: AC: User should get error message "The Driver's License / Others field may not be greater than 25 characters”

Case4: AC: User should get error message "The Driver's License / Others field format is invalid”
 */
public class TC_CPM_019 extends BaseClass {

	@Test(priority=1,dataProvider="DataTC_CPM_019")
	public void tc_cpm_019(String location,String numBed,String numBath,String numGarage,String minRate,String maxRate,String dlNum,String errMsg)   {
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		logger.info("TC_CPM_019 started");
				
				
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

				
		
		//Setting Driving License on personal info page
		personalInfopage.settxtDl(dlNum);
		logger.info("Driving License Entered");
		//Click on next text box ie State
		personalInfopage.clktxtState();
		logger.info("Clicked on next text box ie State");
		
			
		
		//Assertion AC01:Verify if Error Message is displayed 
					
		if (personalInfopage.txtErrDl.isDisplayed() && personalInfopage.txtErrDl.getText().equals(errMsg) ) {
			softassert.assertTrue(true);
			logger.info("Passed AC01:Invalid Driving License number:" + dlNum + " Error Displayed:" + errMsg);
		} 
		else {
			softassert.assertTrue(false);
			logger.error("Failed AC01:Error NOT displayed or mismatch for Invalid Driving License number:" + dlNum);
		}

		softassert.assertAll();
	}
	
	//Excel Data Provider Method  
			@DataProvider (name="DataTC_CPM_019")
			public Object[][] testData () throws IOException
			{		
				return XLUtils.getData(Excel_Path, "TC_CPM_019");				

			}

}
