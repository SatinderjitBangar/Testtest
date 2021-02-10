package com.CPM.qa.testCases;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.CPM.qa.baseClass.BaseClass;
import com.CPM.qa.pageObjects.LandingPage;
import com.CPM.qa.pageObjects.LoginPage;
import com.CPM.qa.pageObjects.RE_BankingRefPage;
import com.CPM.qa.pageObjects.RE_CoApplicantPage;
import com.CPM.qa.pageObjects.RE_EmploymentHistoryPage;
import com.CPM.qa.pageObjects.RE_HomePage;
import com.CPM.qa.pageObjects.RE_PersonalInfoPage;
import com.CPM.qa.pageObjects.RE_PersonalRefPage;
import com.CPM.qa.pageObjects.RE_PetsPage;
import com.CPM.qa.pageObjects.RE_RentalHistoryPage;
import com.CPM.qa.pageObjects.SignUpPage;
import com.CPM.qa.utilities.XLUtils;
/*
 This test case is to verify that Boats field can take alphanumeric
1. User enters valid Boat Info and clicks Submit

Acceptance Criteria:
The following will happen for the test case to be considered successful:
AC01. User should be able to move to the next page

 */
public class TC_CPM_079 extends BaseClass {

	@Test(priority=1,dataProvider="DataTC_CPM_079")
	public void tc_cpm_079(String location,String numBed,String numBath,String numGarage,String minRate,String maxRate,String firstName,String lastName,String prefName,String dobYYYY, String dobMon, String dobDD, String phone,String dlNum,String state, String expYYYY, String expMon, String expDD, String ssnNum,String empEmployer,String empAdd1,String empAdd2,String empCity,String empState,String empZip,String empPhone,String empSup,String empPos,String empReason,String wSyyyy,String wSmon,String wSdd,String wEyyyy,String wEmon,String wEdd,String empSal,String renAdd,String renRorO,String renReason,String renLord,String rSyyyy,String rSmon,String rSdd,String rEyyyy,String rEmon,String rEdd,String renAmount,String renPhone,String bName,String bAdd,String bCity,String bState,String bZip,String bPhone,String bCorS,String bAcc,String bBal,String pName,String pAdd,String pCity,String pZip,String pState,String pPhone,String pRel,String petBoots) throws InterruptedException   {
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		logger.info("TC_CPM_079 started");
				
		// Assert whether the renter login is successful
		SoftAssert softassert = new SoftAssert();
		
		// Creating object for TC_CPM_066
		TC_CPM_066 TC_066 = new TC_CPM_066();
		
		TC_066.tc_cpm_066(  location,  numBed,  numBath,  numGarage,  minRate,  maxRate,  firstName,  lastName,  prefName,  dobYYYY,   dobMon,   dobDD,   phone,  dlNum,  state,   expYYYY,   expMon,   expDD,   ssnNum,  empEmployer,  empAdd1,  empAdd2,  empCity,  empState,  empZip,  empPhone,  empSup,  empPos,  empReason,  wSyyyy,  wSmon,  wSdd,  wEyyyy,  wEmon,  wEdd,  empSal,  renAdd,  renRorO,  renReason,  renLord,  rSyyyy,  rSmon,  rSdd,  rEyyyy,  rEmon,  rEdd,  renAmount,  renPhone,  bName,  bAdd,  bCity,  bState,  bZip,  bPhone,  bCorS,  bAcc,  bBal,  pName,  pAdd,  pCity,  pZip,  pState,  pPhone,  pRel);
		
		// Creating object for Personal Reference page
		RE_PetsPage PetsPage = new RE_PetsPage(driver);
		
		
		//Set Boots Text area
		PetsPage.settxtBoots(petBoots);
		logger.info("Entered Boots");
		
		//Click on Submit
		PetsPage.clkbtnSubmit();
		logger.info("Clicked on Submit");
				
		
		
		
		//AC01: Verify if Application is Submitted  
			
		if (PetsPage.dispheadAppSubmit()) {
					softassert.assertTrue(true);
					logger.info("Passed AC01:Application is submitted successfully");
		} 
		else {
					softassert.assertTrue(false);
					logger.error("Failed AC01:Application is NOT submitted successfully");
			}


		softassert.assertAll();
	}
	
	//Excel Data Provider Method  
			@DataProvider (name="DataTC_CPM_079")
			public Object[][] testData () throws IOException
			{		
				return XLUtils.getData(Excel_Path, "TC_CPM_079");				

			}

}
