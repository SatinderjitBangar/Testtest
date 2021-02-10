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
 This test case is testing that a user should not be able to login in to the Application with invalid credentials: 
 1. User navigates to Cedallion System webpage   
 2. User clicks on Login Button on the top left corner
 Scenarios:  
 3a. Enter valid username and wrong password (sysadmin)  
 3b. Enter invalid username and valid password (sysadmin)  
 3c. Enter invalid username and invalid password (sysadmin)  
 3d. Enter valid email id and wrong password  
 3e. Enter invalid email id and valid password  
 3f. Enter invalid email id and invalid password  
 3g. Leave username/email field - blank and enter valid password  
 3h. Enter valid username and leave password - blank (sysadmin)  
 3i. Enter valid email and leave password - blank  
 3j. Leave username/email field - blank and password - blank4. Click on Login button

Acceptance Criteria:
The following will happen for the test case to be considered successful:
AC01: Cedallion System webpage should open 
AC02: "Renting Made Simple" page is displayed 
AC03: Login page opens 
AC04: "Error logging in " message should be displayed
 */

public class TC_CPM_010 extends BaseClass {

	@Test(priority=1,dataProvider="DataTC_CPM_010")
	public void tc_cpm_010(String expTitle,String expHead,String userID,String password) {
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		logger.info("TC_CPM_010 started");
		
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
		 		 
		
		//Setting user ID
		loginpg.settxtEmail(userID);
		logger.info("Entered User ID");
		//Setting password
		loginpg.settxtpassword(password);
		logger.info("Entered Password");
		//Click on Login button
		loginpg.clkbtnLogin();
		logger.info("Clicked on Login");

		
		//Assertion AC04: verify Error login is displayed
		if (loginpg.headErrorLogin.isDisplayed()) {
			softassert.assertTrue(true);
			logger.info("Passed AC04:Login Failed with invalid credentials:" + "E-mail/UserName:" + userID + " Password:" + password );
		}
		else {
			softassert.assertTrue(false);
			logger.info("Failed AC04:Login Passed with invalid credentials:" + "E-mail/UserName:" + userID + " Password:" + password );
		}
		
		softassert.assertAll();

	}
	
	//Excel Data Provider Method  
			@DataProvider (name="DataTC_CPM_010")
			public Object[][] testData () throws IOException
			{		
				return XLUtils.getData(Excel_Path, "TC_CPM_010");				

			}

}
