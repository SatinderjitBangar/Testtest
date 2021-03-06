package com.CPM.qa.testCases;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.CPM.qa.baseClass.BaseClass;
import com.CPM.qa.pageObjects.LandingPage;
import com.CPM.qa.pageObjects.LoginPage;
import com.CPM.qa.pageObjects.RE_EmploymentHistoryPage;
import com.CPM.qa.pageObjects.RE_PersonalInfoPage;
import com.CPM.qa.utilities.XLUtils;

/*
This test case is to verify whether Phone field can be left blank.
1. User leaves the phone field empty and moves to the next tab.

Acceptance Criteria:
The following will happen for the test case to be considered successful:
AC01.User should get error message "Please enter your Phone Number"

Assumption made:
Error displayed is "The Phone field is required" and not "Please enter your Phone Number"

*/


public class TC_CPM_036 extends BaseClass{

	@Test(priority=1,dataProvider = "DataTC_CPM_036")
	public void tc_cpm_036(String phone,String supervisor) throws InterruptedException{
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		logger.info("TC_CPM_036 started");
		
		//Soft Assert object declared and defined
		SoftAssert softassert = new SoftAssert();
													
		// Creating object for LandingPage
		LandingPage landingpage = new LandingPage(driver);	
		landingpage.clkbtnLogin();
		logger.info("Clicked on Login here button");
		
		// Creating object for LoginPage
		LoginPage loginpg = new LoginPage(driver);
		
		//Set Valid Username
		loginpg.settxtEmail(username3);
		//Set Valid Password
		loginpg.settxtpassword(password3);
		//Click on login
		loginpg.clkbtnLogin();
		logger.info("Entered Valid credentials and Clicked on Login");
		
		// Creating object for PersonalInfoPage
		RE_PersonalInfoPage personalInfopage = new RE_PersonalInfoPage(driver);
		//All the info will be pre-populated
		personalInfopage.clkbtnNxt();
		logger.info("Clicked on Next Button");
		
		// Creating object for PersonalInfoPage
		RE_EmploymentHistoryPage employementHistorypage = new RE_EmploymentHistoryPage(driver);
		//Selecting phone field and leaving it empty
		employementHistorypage.settxtPhone(phone);
		logger.info("Left Phone textfield empty");
		//Pressing tab to get State/Province textfield out of focus
		employementHistorypage.moveOutOfFocus(employementHistorypage.txtPhone);
		
		//Assertion AC01.User should get error message "The Phone field is required"
		if (employementHistorypage.phoneErrorIsDisplayed()) {
			softassert.assertTrue(true);
			logger.info("Passed AC01:error message is displayed when the Phone field is left empty - 'The Phone field is required'");
		}
		else {
			softassert.assertTrue(false);
			logger.error("Failed AC01: error message is not displayed when the Phone field is left empty");
		}
		
		softassert.assertAll();

	}
	//Excel Data Provider Method  
	@DataProvider (name="DataTC_CPM_036")
	public Object[][] testData () throws IOException
	{		
		return XLUtils.getData(Excel_Path,"TC_CPM_036");				

	}
}
