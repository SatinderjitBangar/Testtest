package com.CPM.qa.testCases;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.CPM.qa.baseClass.BaseClass;
import com.CPM.qa.pageObjects.LandingPage;
import com.CPM.qa.utilities.XLUtils;

/*Description
This test case is testing that a potential renter can search for property by viewing the images.                                           
1. User navigates to Cedallion System webpage
2. User filters with search criteria
3. User click the Get Started link
4. User clicks on the  forward play button at the right side of the search result window

Acceptance Criteria:

The following will happen for the test case to be considered successful: 
AC01: Cedallion System webpage should open and "Renting Made Simple" should be displayed
AC02: User is able to select search criteria
AC03: Search results page is displayed        
AC04: Next Property image is displayed including property details such as size, no of bedrooms, no of bathrooms, Amount/month and the location
 * 
 */

public class TC_CPM_002 extends BaseClass {

	@Test(priority=1,dataProvider="DataTC_CPM_002")
	public void tc_cpm_002(String expTitle,String expHead,String numBed,String numBath,String numGarage,String minRate,String maxRate) {
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		logger.info("TC_CPM_002 started");
				
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
		
		//Assertion AC02: Verify if search filters are selected
		if(landingpage.verifySrchFilter(numBed, numBath, numGarage, minRate, maxRate)) 
		{
			
			softassert.assertTrue(true);
			logger.info("Passed AC02:Search filter selected successfully");
		}
		else
		{
			softassert.assertTrue(false);
			logger.info("Failed AC02:Unable to set Search filter");
			
		}
		
				
		//Click on Get Started button
		landingpage.clkbtnGetStarted();
		logger.info("Clicked on Get Started button");
		
		//Assertion AC03: verify Search Result is displayed 
		
		if(landingpage.headSearchRes.isDisplayed() && landingpage.detailsSearchRes.isDisplayed() && landingpage.ratePerMonth.isDisplayed())
		{
			 softassert.assertTrue(true);
			 logger.info("Passed AC03:Search Result Page displayed ");
		 }
		else
		{
			softassert.assertTrue(false);
			logger.info("Failed AC03:Search Result Page NOT displayed properly");
		}
		
		//Click on Forward play button to display next search result
		landingpage.clkbtnFwdPlay();
		logger.info("Clicked on Forward play button to display next search result");
		
		//AC04:Verify Next Property image is displayed including property details
		
		if(landingpage.verifyNxtRes())
		{
			softassert.assertTrue(true);
			logger.info("Passed AC04:Next Search Result displayed along with details");
		}
		else
		{
			softassert.assertTrue(false);
			logger.info("Failed AC04:Next Search Result NOT displayed properly");
		}
			
			
		

		softassert.assertAll();
	}
	
	//Excel Data Provider Method  
			@DataProvider (name="DataTC_CPM_002")
			public Object[][] testData () throws IOException
			{		
				return XLUtils.getData(Excel_Path, "TC_CPM_002");				

			}

}
