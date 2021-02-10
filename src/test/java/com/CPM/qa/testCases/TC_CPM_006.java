package com.CPM.qa.testCases;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.CPM.qa.baseClass.BaseClass;
import com.CPM.qa.pageObjects.LandingPage;
import com.CPM.qa.pageObjects.SignUpPage;
import com.CPM.qa.utilities.XLUtils;
/*Test Description
This test case is testing that a potential renter/Guest can sign up to the system by entering valid details

This test case is testing that a potential renter/Guest can sign up to the system to apply to rent property. 
1. User navigates to Cedallion System webpage                                 
2. User search for property                                  
3. User clicks Get started link            
4. User selects property     
5. User click on apply now link 
6. User enters fullname  "Cedrenter" 
7. User enter email address   " Cedrenter1@mailinator.com"    
8. User enters same Password and Repeat password text   "Password12345$"    
9. Users clicks on Register link

Acceptance Criteria:

The following will happen for the test case to be considered successful:        
AC01: Cedallion System webpage should open and "Renting Made Simple" should be displayed 
AC02: Filtered search results should be returned             
AC03: Sign up page should be displayed          
AC04: "Success! Check your email" message should be displayed
 * 
 */

public class TC_CPM_006 extends BaseClass {

	@Test(priority=1,dataProvider="DataTC_CPM_006")
	public void tc_cpm_006(String expTitle,String expHead,String numBed,String numBath,String numGarage,String minRate,String maxRate,String fullName,String email,String newPass,String conPass) {
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		logger.info("TC_CPM_006 started");
				
		//Variable to store actual page title		
		String actTitle;
				
		//Capture the page title
		actTitle = driver.getTitle();
		
		// Creating object for LandingPage
		LandingPage landingpage = new LandingPage(driver);
		
		// Assert whether the renter login is successful
		SoftAssert softassert = new SoftAssert();
		
		//Assertion AC01: Verify page title and if heading is displayed
		
		if(actTitle.equals(expTitle) && landingpage.verifyHead(expHead))
				{
									
			softassert.assertTrue(true);
			logger.info("Passed AC01:Cedallion System webpage opened successfully and " + expHead +  " is displayed");
		}
		else
		{
			softassert.assertTrue(false);
			logger.info("Failed AC01:Cedallion System webpage NOT opened successfully OR " + expHead +  " is NOT displayed");
		}
				
		//Set search filters		
		landingpage.setSrchFilters(numBed, numBath, numGarage, minRate, maxRate);
		logger.info("Setting Search Filters");
							
		//Click on Get Started button
		landingpage.clkbtnGetStarted();
		logger.info("Clicked on Get Started button");
		
		//Assertion AC02: verify Search Result is displayed 
		
		if(landingpage.headSearchRes.isDisplayed() && landingpage.detailsSearchRes.isDisplayed() && landingpage.ratePerMonth.isDisplayed())
		{
			 softassert.assertTrue(true);
			 logger.info("Passed AC02:Search Result Page displayed ");
		 }
		else
		{
			softassert.assertTrue(false);
			logger.info("Failed AC02:Search Result Page NOT displayed properly");
		}
		
		//Click on Apply Button
		landingpage.clkbtnApply();
		logger.info("Clicked on Apply button");
		
		//Create an object of SignUp page
		SignUpPage signuppage = new SignUpPage(driver);
		
		//AC03:Verify if SignUp page has opened
		
		if(signuppage.headSignUp.isDisplayed())
		{
			 softassert.assertTrue(true);
			 logger.info("Passed AC03:SignUp page is open");
		 }
		else
		{
			softassert.assertTrue(false);
			logger.info("Failed AC03:SignUp page is NOT open");
		}
		
		//Set Full Name field
		signuppage.settxtFullName(fullName);
		logger.info("Setting Full Name field ");
		//Set e-mail field
		signuppage.settxtemail(email);
		logger.info("Setting email field ");
		//Set New Password field
		signuppage.settxtNewPass(newPass);
		logger.info("Setting New Password field ");
		//Set Confirm Password field
		signuppage.settxtConPass(conPass);
		logger.info("Setting Confirm Password field ");
		//Click on Register button
		signuppage.clkbtnRegister();
		logger.info("Clicked on Register button");
		
		//AC03:Verify if Registration is successful
		
		if(signuppage.regSuccess.isDisplayed())
		{
			softassert.assertTrue(true);
			 logger.info("Passed AC04:\"Success! Check your email\" message is displayed");
		}
		else
		{
			softassert.assertTrue(false);
			logger.info("Failed AC04:\"Success! Check your email\" message is NOT displayed");
		}
						
		

		softassert.assertAll();
	}
	
	//Excel Data Provider Method  
			@DataProvider (name="DataTC_CPM_006")
			public Object[][] testData () throws IOException
			{		
				return XLUtils.getData(Excel_Path, "TC_CPM_006");				

			}

}
