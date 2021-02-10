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
 This test case is testing that a Property Manager can login in to the Application 
 1. Property Manager navigates to Cedallion System webpage
 2. Property Manager Clicks Login Button on the tope left corner
 3. Property Manager enters email "john.doe+143@mailinator.com"
 4. Property Manager enters password  
  5. Property Manager clicks on the login link

Acceptance Criteria:
The following will happen for the test case to be considered successful:
AC01: Cedallion System webpage should open
AC02: "Renting Made Simple" page should be dispalyed 
AC03: Login page opens
AC04: Property Manager profile/home page should open
 */

public class TC_CPM_009 extends BaseClass {

	@Test(priority=1,dataProvider="DataTC_CPM_009")
	public void tc_cpm_009(String expTitle,String expHead,String userID,String password) {
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		logger.info("TC_CPM_009 started");
		
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

		
		// Creating object for Property Manager Dash board
		PM_DashboardPage homepage = new PM_DashboardPage(driver);

		//Assertion AC04: verify login is successful and Property Manager profile/home page open
		if (homepage.txtdash.isDisplayed()) {
			softassert.assertTrue(true);
			logger.info("Passed AC04:Login as Property Manager successful!!");
		}
		else {
			softassert.assertTrue(false);
			logger.info("Failed AC04:Login as Property Manager NOT successful!!");
		}
		
		softassert.assertAll();

	}
	
	//Excel Data Provider Method  
			@DataProvider (name="DataTC_CPM_009")
			public Object[][] testData () throws IOException
			{		
				return XLUtils.getData(Excel_Path, "TC_CPM_009");				

			}

}
