package com.CPM.qa.testCases;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.CPM.qa.baseClass.BaseClass;
import com.CPM.qa.pageObjects.LandingPage;
import com.CPM.qa.pageObjects.LoginPage;
import com.CPM.qa.pageObjects.RE_CoApplicantPage;
import com.CPM.qa.pageObjects.RE_EmploymentHistoryPage;
import com.CPM.qa.pageObjects.RE_HomePage;
import com.CPM.qa.pageObjects.RE_PersonalInfoPage;
import com.CPM.qa.pageObjects.SignUpPage;
import com.CPM.qa.utilities.XLUtils;
/*
This test case is to verify that SSN/SIN field should not be left blank or accept invalid characters

Steps to reproduce:

Login with valid credentials

Select Co-applicant radio button

Fill in the valid details for Applicant 1

Click on Next

Validate following details in the SIN/SSN of Co-applicant tab (applicant-2):

Case 1: Leave the SSN/SIN field blank

Case 2: Enter less than 9 numbers in the SSN/SIN field

Case 3: Enter more than 15 numbers in the SSN/SIN field

Case 4: Enter special characters in the SSN/SIN field

Case 5: Enter alphabets in the SSN/SIN field

Case 6: Enter combination of special characters, numbers and alphabets

Acceptance Criteria:

The following will happen for the test case to be considered successful:

AC01: Co-applicant tab is displayed and enabled.

AC02:

Case1: User should get error message "The Social Security field is required"

Case2: User should get error message “The Social Security field must be 9 long”

Case 3: User should get error message "The Social Security field may not be greater than 15 characters”

Case 4:  User should get error message “The Social Security field format is invalid”

Case 5:  User should get error message “The Social Security field format is invalid”

Case 6:  User should get error message “The Social Security field format is invalid”
 */
public class TC_CPM_028 extends BaseClass {

	@Test(priority=1,dataProvider="DataTC_CPM_028")
	public void tc_cpm_028(String location,String numBed,String numBath,String numGarage,String minRate,String maxRate,String firstName,String lastName,String prefName,String dobYYYY, String dobMon, String dobDD, String phone,String dlNum,String state, String expYYYY, String expMon, String expDD, String ssnNum,String coSsnNum,String errMsg) throws InterruptedException   {
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		logger.info("TC_CPM_028 started");
				
				
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

				
		//Fill all fields on Personal info page
		
		//Setting First Name on personal info page
		personalInfopage.settxtFirstName(firstName);
		logger.info("First Name Entered");
		//Setting Last Name on personal info page
		personalInfopage.settxtLastName(lastName);
		logger.info("Last Name Entered");
		//Setting Preferred Name on personal info page
		personalInfopage.settxtPrefName(prefName);
		logger.info("Preferred Name Entered");
		//Setting Date of Birth on personal info page
		personalInfopage.setDOB(dobYYYY, dobMon, dobDD);
		logger.info("Date of Birth Entered");
		//Setting Phone on personal info page
		personalInfopage.settxtPhone(phone);
		logger.info("Phone number Entered");
		//Setting Driving License on personal info page
		personalInfopage.settxtDl(dlNum);
		logger.info("Driving License/Others Entered");
		//Setting State on personal info page
		personalInfopage.settxtState(state);
		logger.info("State Entered");
		//Setting Expiry Date on personal info page
		personalInfopage.setExpDate(expYYYY, expMon, expDD);
		logger.info("Expiry Date Entered");
		//Setting Social Security Number on personal info page
		personalInfopage.settxtSSN(ssnNum);
		logger.info("Social Security Number Entered");
		//Click on Co-Applicant radio button
		personalInfopage.clkbtnCoApp();
		logger.info("Clicked on Co-Applicant Radio Button");
		//Click on Next button
		personalInfopage.clkbtnNxt();
		logger.info("Clicked on Next Button");
		
		// Creating object for Co-Applicant info page
		RE_CoApplicantPage coAppInfoPage = new RE_CoApplicantPage(driver);

		//AC01:Verify Co-Applicant tab is displayed and enabled
		
		if (coAppInfoPage.dispCoApp()) {
						
			softassert.assertTrue(true);
			logger.info("Passed AC01: Co-Applicant Info tab is displayed and enabled");
			
		} 
		else {
				
			softassert.assertTrue(false);
			logger.error("Failed AC01: Co-Applicant Info tab is NOT displayed or enabled");
			
			
		}
			
		//Setting Driving License number on Co-Applicant info page
		coAppInfoPage.settxtSSN(coSsnNum);
		logger.info("Co-Applicant Social Security Number Entered");
		
		//Click on next text box ie State
		coAppInfoPage.clktxtFirstName();
		logger.info("Clicked on next text box ie First Name");
				
					
		//Assertion AC02:Verify if Error Message is displayed 
							
		if (coAppInfoPage.txtErrSnn.isDisplayed() && coAppInfoPage.txtErrSnn.getText().equals(errMsg) ) {
				softassert.assertTrue(true);
				logger.info("Passed AC02:Invalid Social Security number:" + coSsnNum + " Error Displayed:" + errMsg);
		} 
		else {
				softassert.assertTrue(false);
				logger.error("Failed AC02:Error NOT displayed or mismatch for Invalid Social Security number:" + coSsnNum);
			}


		softassert.assertAll();
	}
	
	//Excel Data Provider Method  
			@DataProvider (name="DataTC_CPM_028")
			public Object[][] testData () throws IOException
			{		
				return XLUtils.getData(Excel_Path, "TC_CPM_028");				

			}

}
