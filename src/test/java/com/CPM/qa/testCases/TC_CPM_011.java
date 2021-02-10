package com.CPM.qa.testCases;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.CPM.qa.baseClass.BaseClass;
import com.CPM.qa.pageObjects.LandingPage;
import com.CPM.qa.pageObjects.LoginPage;
import com.CPM.qa.pageObjects.PM_DashboardPage;
import com.CPM.qa.pageObjects.RE_HomePage;
import com.CPM.qa.pageObjects.SignUpPage;
import com.CPM.qa.utilities.XLUtils;
/*Test Description
This test case is testing that a renter can login in to the Application
1. User navigates to Cedallion System webpage  
2. User Clicks Login Button on the top left corner 
3. User clicks forget password link

Acceptance Criteria:
The following will happen for the test case to be considered successful:
AC01: Cedallion System webpage should open        
AC02: "Renting Made Simple" page should be displayed  
AC03: Login page should open  
AC04: Recover your password page should open
 */

public class TC_CPM_011 extends BaseClass {

	@Test(priority=1,dataProvider="DataTC_CPM_011")
	public void tc_cpm_011(String expTitle,String expHead) {
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		logger.info("TC_CPM_011 started");
		
		//Variable to store actual page title		
		String actTitle;
						
		//Capture the page title
		actTitle = driver.getTitle();
		
		// Creating object for LandingPage
		LandingPage landingpage = new LandingPage(driver);
		
		// Assert whether the renter login is successful
		SoftAssert softassert = new SoftAssert();
				
		//Assertion AC01: Verify page title 
				
		if(actTitle.equals(expTitle))
		{
					
			softassert.assertTrue(true);
			logger.info("Passed AC01:Cedallion System webpage opened successfully");
		}
			else
		{
			softassert.assertTrue(false);
			logger.info("Failed AC01:Cedallion System webpage NOT opened successfully");
		}
		
		//Assertion AC02: Verify if heading  is displayed
		 if(landingpage.verifyHead(expHead))
		 {
			softassert.assertTrue(true);
			logger.info("Passed AC02:" + expHead + " is Displayed"); 
		 }
		 else
		 {
			 softassert.assertTrue(false);
			 logger.info("Passed AC02:" + expHead + " is NOT Displayed"); 
		 }
		
		//Click on Login here button
		landingpage.clkbtnLogin();
		logger.info("Clicked on Login here button");
		
		// Creating object for LoginPage
		LoginPage loginpg = new LoginPage(driver);

		//Assertion AC03: Verify if Login Page is opened
		if(loginpg.headLogin.isDisplayed())
		 {
			softassert.assertTrue(true);
			logger.info("Passed AC03:Login page opened successfully"); 
		 }
		 else
		 {
			 softassert.assertTrue(false);
			 logger.info("Passed AC03:Login page NOT opened successfully"); 
		 }
		 		 
		
		
		//Click on Forgot Password button
		loginpg.clkbtnForgot();
		logger.info("Clicked on Forogt you password");

		
		//Assertion AC04: verify Recover your password page is displayed
		if (loginpg.headRecover.isDisplayed()) {
			softassert.assertTrue(true);
			logger.info("Passed AC04:Recover your passsword page opened succesfully ");
		}
		else {
			softassert.assertTrue(false);
			logger.info("Failed AC04:Recover your passsword page NOT opened succesfully ");
		}
		
		softassert.assertAll();

	}
	
	//Excel Data Provider Method  
			@DataProvider (name="DataTC_CPM_011")
			public Object[][] testData () throws IOException
			{		
				return XLUtils.getData(Excel_Path, "TC_CPM_011");				

			}

}
