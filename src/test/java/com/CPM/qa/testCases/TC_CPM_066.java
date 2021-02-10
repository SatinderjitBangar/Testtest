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
This test case is to verify whether applicant is able to navigate to next tab - Pets
1. Enter valid first name 
2. Enter valid address
3. Enter valid city 
4. Enter valid State
5. Enter valid phone
6. Enter Zip code
7. Click Next

Acceptance Criteria:The following will happen for the test case to be considered successful:

AC01:User should be able to move to the next tab - Employment History

AC02:User should be able to move to the next tab - Rental History

AC03.User should be able to move to the next tab - Banking Reference

AC04.User should be able to move to the next tab-Personal Reference

AC05.User should be able to navigate to next tab - Pets
 */
public class TC_CPM_066 extends BaseClass {

	@Test(priority=1,dataProvider="DataTC_CPM_066")
	public void tc_cpm_066(String location,String numBed,String numBath,String numGarage,String minRate,String maxRate,String firstName,String lastName,String prefName,String dobYYYY, String dobMon, String dobDD, String phone,String dlNum,String state, String expYYYY, String expMon, String expDD, String ssnNum,String empEmployer,String empAdd1,String empAdd2,String empCity,String empState,String empZip,String empPhone,String empSup,String empPos,String empReason,String wSyyyy,String wSmon,String wSdd,String wEyyyy,String wEmon,String wEdd,String empSal,String renAdd,String renRorO,String renReason,String renLord,String rSyyyy,String rSmon,String rSdd,String rEyyyy,String rEmon,String rEdd,String renAmount,String renPhone,String bName,String bAdd,String bCity,String bState,String bZip,String bPhone,String bCorS,String bAcc,String bBal,String pName,String pAdd,String pCity,String pZip,String pState,String pPhone,String pRel) throws InterruptedException   {
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		logger.info("TC_CPM_066 started");
				
				
		// Assert whether the renter login is successful
			SoftAssert softassert = new SoftAssert();
						
		// Creating object for TC_CPM_058
			TC_CPM_058 TC_058 = new TC_CPM_058();
						
			TC_058.tc_cpm_058(  location,  numBed,  numBath,  numGarage,  minRate,  maxRate,  firstName,  lastName,  prefName,  dobYYYY,   dobMon,   dobDD,   phone,  dlNum,  state,   expYYYY,   expMon,   expDD,   ssnNum,  empEmployer,  empAdd1,  empAdd2,  empCity,  empState,  empZip,  empPhone,  empSup,  empPos,  empReason,  wSyyyy,  wSmon,  wSdd,  wEyyyy,  wEmon,  wEdd,  empSal,  renAdd,  renRorO,  renReason,  renLord,  rSyyyy,  rSmon,  rSdd,  rEyyyy,  rEmon,  rEdd,  renAmount,  renPhone,  bName,  bAdd,  bCity,  bState,  bZip,  bPhone,  bCorS,  bAcc,  bBal);
						
		// Creating object for Personal Reference page
					RE_PersonalRefPage PersRefPage = new RE_PersonalRefPage(driver);
						
		
				
		//Fill all fields on Personal Reference page for Reference 1
		logger.info("Fill all fields on Personal Reference page for Reference 1");
				
		//Delete Existing Personal Reference if any
		PersRefPage.clkbtnDelRef1();
		logger.info("Deleted Personal Reference");
		//Click on Add new Personal Reference
		PersRefPage.clkbtnAddRef();
		logger.info("Clicked on Add new Personal Reference");
		//Set  Name on Personal Reference page 
		PersRefPage.settxtNameRef1(pName);
		logger.info("Name Entered");
		//Set  Address on Personal Reference page 
		PersRefPage.settxtAddRef1(pAdd);
		logger.info(" Address Entered");
		//Set  City on Personal Reference page 
		PersRefPage.settxtCityRef1(pCity);
		logger.info(" City Entered");
		//Set  Zip Code on Personal Reference page 
		PersRefPage.settxtZipRef1(pZip);
		logger.info(" Zip Code Entered");
		//Set  State on Personal Reference page 
		PersRefPage.settxtStateRef1(pState);
		logger.info(" State Entered");
		//Set Phone on Personal Reference page 
		PersRefPage.settxtPhoneRef1(pPhone);
		logger.info("Phone Entered");
		//Set Relationship on Personal Reference page 
		PersRefPage.settxtRelRef1(pRel);
		logger.info("Relationship Entered");
		//Click on Next button on Personal Reference page 
		PersRefPage.clkbtnNxt();
		logger.info("Clicked Next Button");
		
		// Creating object for Personal Reference page
		RE_PetsPage PetsPage = new RE_PetsPage(driver);
			
		//Assertion AC05:Verify if Personal Reference tab is enabled and selected
			
		if (PetsPage.dispPets()) {
					softassert.assertTrue(true);
					logger.info("Passed AC05:Pets tab is enabled and selected");
		} 
		else {
					softassert.assertTrue(false);
					logger.error("Failed AC05:Pets tab is NOT enabled and selected");
			}


		softassert.assertAll();
	}
	
	//Excel Data Provider Method  
			@DataProvider (name="DataTC_CPM_066")
			public Object[][] testData () throws IOException
			{		
				return XLUtils.getData(Excel_Path, "TC_CPM_066");				

			}

}
