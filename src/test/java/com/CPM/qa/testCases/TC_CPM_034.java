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

/*This test case is to verify that State/Province field cannot be left blank
1. User leaves State field blank and click enter

Acceptance Criteria:
The following will happen for the test case to be considered successful:
AC01.User should get an error message "This field cannot be left empty"

Assumption made:
Error displayed is "The State/Province field is required" and not "This field cannot be left empty"

*/


public class TC_CPM_034 extends BaseClass{

	@Test(priority=1,dataProvider="DataTC_CPM_034")
	public void tc_cpm_034(String employerName,String employerAddress,String employerState,String employerCity) throws InterruptedException{
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		logger.info("TC_CPM_034 started");
		
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
		//Entering valid employer name
		employementHistorypage.settxtEmployer(employerName);
		logger.info("Entered Valid employer name and moving to the next text field");
		//Entering Valid Address line 1 
		employementHistorypage.settxtAdd1(employerAddress);
		logger.info("Entered Valid info in Address line 1 textfield");
		//Entering Valid City name
		employementHistorypage.settxtCity(employerCity);
		logger.info("Entered Valid City name");
		//leaving state field empty
		employementHistorypage.settxtState(employerState);
		logger.info("Left State/Province textfield empty");
		//Pressing tab to get State/Province textfield out of focus
		employementHistorypage.moveOutOfFocus(employementHistorypage.txtState);
		
		//Assertion AC01.User should get an error message"The State/Province field is required"
		if (employementHistorypage.stateErrorIsDisplayed()) {
			softassert.assertTrue(true);
			logger.info("Passed AC01:error message is displayed when the State/Province textfield is left empty - 'The State/Province field is required'");
		}
		else {
			softassert.assertTrue(false);
			logger.info("Failed AC01: error message is not displayed when the State/Province field is left empty");
		}
		
		softassert.assertAll();

	}
	//Excel Data Provider Method  
	@DataProvider (name="DataTC_CPM_034")
	public Object[][] testData () throws IOException
	{		
		return XLUtils.getData(Excel_Path,"TC_CPM_034");				

	}
}
