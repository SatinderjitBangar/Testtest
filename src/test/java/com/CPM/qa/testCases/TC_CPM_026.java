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
This test case is to verify that Phone field in Co-applicant Page should not be left blank or accept invalid characters

Steps to reproduce:

Login with valid credentials

Select Co-applicant radio button

Fill in the valid details for Applicant 1

Click on Next

Enter following details in the phone field of Co-applicant tab (applicant-2):

Case 1: Leave the phone field blankCase 2: Enter phone number less than 10 digit e.g. 9876789Case 3: Enter phone number more than 10 digit e.g. 987654321234Case 4: Enter phone number with special characters e.g. 987#$&%(12Case 5: Enter phone number with alphabets e.g. ADGB6799GH

Acceptance Criteria:

The following will happen for the test case to be considered successful:

AC01: Co-applicant tab is displayed and enabled.

AC02:Case 1: AC: User should get error message "The Phone field is required”

Case 2: AC: User should get error message "The Phone field must be 10 long”

Case 3: AC: User should get error message "The Phone field must be 10 long”

Case 4: AC: User should get error message "The Phone field format is invalid”

Case 5: AC: User should get error message "The Phone field format is invalid”
 */
public class TC_CPM_026 extends BaseClass {

	@Test(priority=1,dataProvider="DataTC_CPM_026")
	public void tc_cpm_026(String location,String numBed,String numBath,String numGarage,String minRate,String maxRate,String firstName,String lastName,String prefName,String dobYYYY, String dobMon, String dobDD, String phone,String dlNum,String state, String expYYYY, String expMon, String expDD, String ssnNum,String cophone,String errMsg) throws InterruptedException   {
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		logger.info("TC_CPM_026 started");
				
				
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
			
		//Setting Phone number on Co-Applicant info page
		coAppInfoPage.settxtPhone(cophone);
		logger.info("Co-Applicant Phone Number Entered");
		
		//Click on next text box ie Driving license
		coAppInfoPage.clktxtDl();
		logger.info("Clicked on next text box ie Driving license");
				
					
		//Assertion AC02:Verify if Error Message is displayed 
							
		if (coAppInfoPage.txtErrPhone.isDisplayed() && coAppInfoPage.txtErrPhone.getText().equals(errMsg) ) {
				softassert.assertTrue(true);
				logger.info("Passed AC02:Invalid Phone number:" + cophone + " Error Displayed:" + errMsg);
		} 
		else {
				softassert.assertTrue(false);
				logger.error("Failed AC02:Error NOT displayed or mismatch for Invalid Phone number:" + cophone);
			}


		softassert.assertAll();
	}
	
	//Excel Data Provider Method  
			@DataProvider (name="DataTC_CPM_026")
			public Object[][] testData () throws IOException
			{		
				return XLUtils.getData(Excel_Path, "TC_CPM_026");				

			}

}
