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
 * his test case is to verify whether applicant is able to move to next page after entering valid details
 * 

1. User navigates to Cedallion System webpage                                 
2. User search for property                                  
3. User clicks Get started link            
4. User selects property     
5. User click on apply now link
6. Click on sign in
7. Enter e-mail
8. Enter password
9. Click on Login

Enter information in Personal info form: 

a. Enter valid first name only alphabets

b. Enter valid last name only alphabets

c. Enter valid preferred name

d. User selects a valid date of birth

e. Enter valid phone number

f. User enters valid driving license number

g. Enter valid State/Province

h. Enter valid Expiry date (Future date)

i. Enter valid Social Security/Social insurance

10. Click Next

Acceptance Criteria:

The following will happen for the test case to be considered successful:
AC01: Personal Info tab should be displayed and enabled.
AC02: User should be able to navigate to next page successfully.
 */
public class TC_CPM_013 extends BaseClass {

	@Test(priority=1,dataProvider="DataTC_CPM_013")
	public void tc_cpm_013(String location,String numBed,String numBath,String numGarage,String minRate,String maxRate,String firstName,String lastName,String prefName,String dobYYYY, String dobMon, String dobDD, String phone,String dlNum,String state, String expYYYY, String expMon, String expDD, String ssnNum) throws InterruptedException   {
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		logger.info("TC_CPM_013 started");
				
				
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

				
		//Assertion AC01: Verify Personal Info tab should be displayed and enabled
		
		if (personalInfopage.lnkPersonalInfo.isDisplayed() && personalInfopage.lnkPersonalInfo.isEnabled()) {
			softassert.assertTrue(true);
			logger.info("Passed AC01:Personal Info tab should is displayed and enabled");
		} 
		else {
			softassert.assertTrue(false);
			logger.info("Failed AC01:Personal Info tab should is NOT displayed or enabled");
		}
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
		//Click on Single applicant radio button
		personalInfopage.clkbtnSingleApp();
		logger.info("Clicked on Single Applicant Button");	
		//Click on Next button
		personalInfopage.clkbtnNxt();
		logger.info("Clicked on Next Button");
			
		
		// Creating object for Employment History page
		RE_EmploymentHistoryPage empHispage = new RE_EmploymentHistoryPage(driver);
		
		//Assertion AC02:Verify if user is able to navigate to next page
					
		if (empHispage.headEmpHis.isDisplayed()) {
			softassert.assertTrue(true);
			logger.info("Passed AC02:User successfully navigated to next page Employment History");
		} 
		else {
			softassert.assertTrue(false);
			logger.error("Failed AC02:User cannot navigated to next page Employment History");
		}

		softassert.assertAll();
	}
	
	//Excel Data Provider Method  
			@DataProvider (name="DataTC_CPM_013")
			public Object[][] testData () throws IOException
			{		
				return XLUtils.getData(Excel_Path, "TC_CPM_013");				

			}

}
