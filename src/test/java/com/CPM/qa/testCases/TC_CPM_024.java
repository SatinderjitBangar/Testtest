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
This test case is to verify that Preferred name field in Co-applicant Page should not be left blank or accept invalid characters

Steps to reproduce:

Login with valid credentials

Select Co-applicant radio button

Fill in the valid details for Applicant 1

Click on Next

Enter following details in the Co-applicant tab (applicant-2):

Case 1: Enter more than 50 characters in the preferred name field

Case 2: Enter special characters in the preferred name field

Case 3: Enter numbers in the preferred name field

Case 4: Enter combination of special characters, numbers and alphabets

Acceptance Criteria:

The following will happen for the test case to be considered successful:

AC01: Co-applicant tab is displayed and enabled.

AC02:

Case1: User should get error message “The Preferred Name field may only contain alphabetic characters”

Case2: User should get error message “The Preferred Name field may only contain alphabetic characters”

Case3: User should get error message “The Preferred Name field may only contain alphabetic characters”

Case4: User should get error message “The Preferred Name field may only contain alphabetic characters”
 */
public class TC_CPM_024 extends BaseClass {

	@Test(priority=1,dataProvider="DataTC_CPM_024")
	public void tc_cpm_024(String location,String numBed,String numBath,String numGarage,String minRate,String maxRate,String firstName,String lastName,String prefName,String dobYYYY, String dobMon, String dobDD, String phone,String dlNum,String state, String expYYYY, String expMon, String expDD, String ssnNum,String coprefName,String errMsg) throws InterruptedException   {
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		logger.info("TC_CPM_024 started");
				
				
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
			
		//Setting Preferred Name on Co-Applicant info page
		coAppInfoPage.settxtPrefName(coprefName);
		logger.info("Co-Applicant Preferred Name Entered");
		
		//Click on next text box ie Preferred Name
		coAppInfoPage.clkdateDOB();
		logger.info("Clicked on next text box ie Date of Birth");
				
					
		//Assertion AC02:Verify if Error Message is displayed 
							
		if (coAppInfoPage.txtErrPrefName.isDisplayed() && coAppInfoPage.txtErrPrefName.getText().equals(errMsg) ) {
				softassert.assertTrue(true);
				logger.info("Passed AC02:Invalid Preferred Name:" + coprefName + " Error Displayed:" + errMsg);
		} 
		else {
				softassert.assertTrue(false);
				logger.error("Failed AC02:Error NOT displayed or mismatch for Invalid Preferred Name:" + coprefName);
			}


		softassert.assertAll();
	}
	
	//Excel Data Provider Method  
			@DataProvider (name="DataTC_CPM_024")
			public Object[][] testData () throws IOException
			{		
				return XLUtils.getData(Excel_Path, "TC_CPM_024");				

			}

}
