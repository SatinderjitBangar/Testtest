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
import com.CPM.qa.pageObjects.RE_PersonalInfoPage;
import com.CPM.qa.utilities.XLUtils;

/*This test case is to verify that Address field cannot be left blank

User leaves address field blank and clicks enter

Acceptance Criteria:
The following will happen for the test case to be considered successful:
AC01.User should get an error message"This field cannot be left empty"

Assumption Made:
Error displayed is "The Address Line 1 field is required" and not "This field cannot be left empty"

*/


public class TC_CPM_031 extends BaseClass{

	@Test(priority=1,dataProvider="DataTC_CPM_031")
	//@Test(priority=1)
	public void tc_cpm_031(String employerName,String employerAddress,String employerAddress2) throws InterruptedException{
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		logger.info("TC_CPM_031 started");
		
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
		
		//Leaving the address line 1 textfield empty
		employementHistorypage.settxtAdd1(employerAddress);
		logger.info("Left Address line 1 textfield empty");
		
		//Entering the valid data in address line textfield and take address line 1 text box out of focus 
		employementHistorypage.settxtAdd2(employerAddress2);
		
		//Assertion AC01.User should get an error message"The Address Line 1 field is required"
		if (employementHistorypage.addressLine1ErrorIsDisplayed()) {
			softassert.assertTrue(true);
			logger.info("Passed AC01:error message is displayed when the address line 1 is left empty - 'The Address Line 1 field is required'");
		}
		else {
			softassert.assertTrue(false);
			logger.info("Failed AC01: error message is not displayed when the address line 1 field is left empty");
		}
		
		softassert.assertAll();

	}
	//Excel Data Provider Method  
	@DataProvider (name="DataTC_CPM_031")
	public Object[][] testData () throws IOException
	{		
		return XLUtils.getData(Excel_Path, "TC_CPM_031");				

	}
}
