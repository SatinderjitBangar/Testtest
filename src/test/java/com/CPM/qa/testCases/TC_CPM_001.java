package com.CPM.qa.testCases;

import java.io.IOException;

import java.util.concurrent.TimeUnit;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.CPM.qa.baseClass.BaseClass;
import com.CPM.qa.pageObjects.LandingPage;
import com.CPM.qa.utilities.XLUtils;

/*Test Description
This test case is testing that a potential renter can search for property. 
1. User navigates to Cedallion System webpage
2. User enters valid area or city "Mississauga" on the Location Textbox 
3. User click Get Started link
 */

/*Acceptance criteria:

The following will happen for the test case to be considered successful:
 AC01: Cedallion System webpage should open and "Renting Made Simple" is displayed 
 AC02: Mississauga is visible 
 AC03: Search Results Window opens with detailed search criteria such No of bedrooms/bathroom/Rate per month
 * 
 */

public class TC_CPM_001 extends BaseClass {

	@Test(priority=1,dataProvider="DataTC_CPM_001")
	public void tc_cpm_001(String expTitle,String expHead, String location) {
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		logger.info("TC_CPM_001 started");
				
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
		
		
		
		//Set Where would you like to search? text box
		landingpage.settxtSearchLoc(location);
		logger.info("Text entered in Where would you like to search? box");	
		
		//Assertion AC02: Search box is visible after entering text
		if(landingpage.txtSearchLoc.isDisplayed())
		{
			softassert.assertTrue(true);
			logger.info("Passed AC02:Search box is visible after entering text");
		}
		else
		{
			softassert.assertTrue(false);
			logger.info("Failed AC02:Search box is NOT visible after entering text");
		}
		
		//Click on Get Started button
		landingpage.clkbtnGetStarted();
		logger.info("Clicked on Get Started button");	
			
		//Assertion AC03: verify Search Result is displayed along with No of bedrooms/bathroom/Rate per month
				
		if(landingpage.headSearchRes.isDisplayed() && landingpage.detailsSearchRes.isDisplayed() && landingpage.ratePerMonth.isDisplayed())
		 {
			 softassert.assertTrue(true);
			 logger.info("Passed AC03:Search Result displayed along with details");
		 }
		else
		{
			softassert.assertTrue(false);
			logger.info("Failed AC03:Search Result NOT displayed properly");
		}

		softassert.assertAll();
	}
	
	//Excel Data Provider Method  
			@DataProvider (name="DataTC_CPM_001")
				public Object[][] testData () throws IOException
				{		
					return XLUtils.getData(Excel_Path, "TC_CPM_001");				

				}

}
