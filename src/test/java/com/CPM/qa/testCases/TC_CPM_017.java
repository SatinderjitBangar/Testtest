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

This test case is to verify whether Date of Birth field can be left empty on Personal Info Page

1.User leaves the Date of Birth field empty and fill all other fields.

2. User clicks on Next.

Acceptance Criteria:

The following will happen for the test case to be considered successful:
AC01. User gets an error message" Missing Date(s)"

 */
public class TC_CPM_017 extends BaseClass {

	@Test(priority=1,dataProvider="DataTC_CPM_017")
	public void tc_cpm_017(String location,String numBed,String numBath,String numGarage,String minRate,String maxRate,String user,String pass,String firstName,String lastName,String prefName,String phone,String dlNum,String state, String expYYYY, String expMon, String expDD, String ssnNum,String errMsg)   {
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		logger.info("TC_CPM_017 started");
				
				
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
		loginpg.settxtEmail(user);
		//Set Password
		loginpg.settxtpassword(pass);
		//Click on login
		loginpg.clkbtnLogin();
		logger.info("Clicked on Login");
		
		// Creating object for PersonalInfoPage
		RE_PersonalInfoPage personalInfopage = new RE_PersonalInfoPage(driver);

				
		
				//Setting First Name on personal info page
				personalInfopage.settxtFirstName(firstName);
				logger.info("First Name Entered");
				//Setting Last Name on personal info page
				personalInfopage.settxtLastName(lastName);
				logger.info("Last Name Entered");
				//Setting Preferred Name on personal info page
				personalInfopage.settxtPrefName(prefName);
				logger.info("Preferred Name Entered");
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
				//Click on Single applicant radio button
				personalInfopage.clkbtnSingleApp();
				logger.info("Clicked on Single Applicant Button");	
				//Click on Next button
				personalInfopage.clkbtnNxt();
				logger.info("Clicked on Next Button");
					
		
			
		
		//Assertion AC01:Verify if Error Message is displayed 
					
		if (personalInfopage.txtErrDate.isDisplayed() && personalInfopage.txtErrDate.getText().equals(errMsg) ) {
			softassert.assertTrue(true);
			logger.info("Passed AC01:Blank DOB field Error Displayed:" + errMsg);
		} 
		else {
			softassert.assertTrue(false);
			logger.error("Failed AC01:Error NOT displayed or mismatch for Blank DOB");
		}

		softassert.assertAll();
	}
	
	//Excel Data Provider Method  
			@DataProvider (name="DataTC_CPM_017")
			public Object[][] testData () throws IOException
			{		
				return XLUtils.getData(Excel_Path, "TC_CPM_017");				

			}

}
