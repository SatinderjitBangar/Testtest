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
import com.CPM.qa.pageObjects.RE_RentalHistoryPage;
import com.CPM.qa.pageObjects.SignUpPage;
import com.CPM.qa.utilities.XLUtils;
/*
This test case is to verify the functionality of Add Employment History button.
 1. Renter enter valid details in all fields of Employment History page
 2. Renter clicks on Add Employment History
 3.Renter enters all valid details in employment History 2 form.
 4. Renter clicks on next button

Acceptance Criteria:The following will happen for the test case to be considered successful:
AC01. Employment History page is open
AC02. Employment History 2 should get added to the page 
AC03. Renter should successfully navigate to next tab.
 */
public class TC_CPM_051 extends BaseClass {

	@Test(priority=1,dataProvider="DataTC_CPM_051")
	public void tc_cpm_051(String location,String numBed,String numBath,String numGarage,String minRate,String maxRate,String firstName,String lastName,String prefName,String dobYYYY, String dobMon, String dobDD, String phone,String dlNum,String state, String expYYYY, String expMon, String expDD, String ssnNum,String empEmployer,String empAdd1,String empAdd2,String empCity,String empState,String empZip,String empPhone,String empSup,String empPos,String empReason,String wSyyyy,String wSmon,String wSdd,String wEyyyy,String wEmon,String wEdd,String empSal,String empEmployerHis2,String empAdd1His2,String empAdd2His2,String empCityHis2,String empStateHis2,String empZipHis2,String empPhoneHis2,String empSupHis2,String empPosHis2,String empReasonHis2,String wSyyyyHis2,String wSmonHis2,String wSddHis2,String wEyyyyHis2,String wEmonHis2,String wEddHis2,String empSalHis2) throws InterruptedException   {
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		logger.info("TC_CPM_051 started");
				
								
		// Assert whether the renter login is successful
		SoftAssert softassert = new SoftAssert();
											
		// Creating object for TC_CPM_013
		TC_CPM_013 TC_013 = new TC_CPM_013();
											
		TC_013.tc_cpm_013(  location,  numBed,  numBath,  numGarage,  minRate,  maxRate,  firstName,  lastName,  prefName,  dobYYYY,   dobMon,   dobDD,   phone,  dlNum,  state,   expYYYY,   expMon,   expDD,   ssnNum);
							
		
		// Creating object for Employment history page
		RE_EmploymentHistoryPage empHisPage = new RE_EmploymentHistoryPage(driver);

				
		//Fill all Main Applicant fields on Employment history 1
		logger.info("Fill all Main Applicant fields on Employment history 1");
		
		//Delete Existing Employment History if any
		empHisPage.clkbtnDelHis();
		logger.info("Deleted Existing Employment History");
		//Click on Add new Employment History
		empHisPage.clkbtnAddHis();
		logger.info("Clicked on Add new Employment History");
		//Set Employer on Employment History page
		empHisPage.settxtEmployer(empEmployer);
		logger.info("Employer Entered");
		//Set Address Line 1 on Employment History page
		empHisPage.settxtAdd1(empAdd1);
		logger.info("Address Line 1 Entered");
		//Set Address Line 2 on Employment History page
		empHisPage.settxtAdd2(empAdd2);
		logger.info("Address Line 2 Entered");
		//Set City on Employment History page
		empHisPage.settxtCity(empCity);
		logger.info("City Entered");
		//Set State on Employment History page
		empHisPage.settxtState(empState);
		logger.info("State Entered");
		//Set Zip code on Employment History page
		empHisPage.settxtZip(empZip);
		logger.info("Zip code Entered");
		//Set Phone on Employment History page
		empHisPage.settxtPhone(empPhone);
		logger.info("Phone Entered");
		//Set Supervisor on Employment History page
		empHisPage.settxtSup(empSup);
		logger.info("Supervisor Entered");
		//Set Position on Employment History page
		empHisPage.settxtPos(empPos);
		logger.info("Position Entered");
		//Set Reason for Leaving on Employment History page
		empHisPage.settxtReason(empReason);
		logger.info("Reason for Leaving Entered");
		//Set Work Start Date Employment History page
		empHisPage.setWorkStart(wSyyyy, wSmon, wSdd);;
		logger.info("Work Start Date Entered");
		//Set Work End Date Employment History page
		empHisPage.setWorkEnd(wEyyyy, wEmon, wEdd);;
		logger.info("Work End Date Entered");
		//Set Combined annual salary on Employment History page
		empHisPage.settxtSal(empSal);
		logger.info("Combined annual salary Entered");
		//Click on Add new Employment History
		empHisPage.clkbtnAddHis();
		logger.info("Clicked on Add new Employment History");
		
		
		//Fill all Main Applicant fields on Employment history 2
		logger.info("Fill all Main Applicant fields on Employment history 2");
				
		
		logger.info("Clicked on Add new Employment History");
		//Set Employer on Employment History page
		empHisPage.settxtEmployerHis2(empEmployerHis2);
		logger.info("Employer Entered");
		//Set Address Line 1 on Employment History page
		empHisPage.settxtAdd1His2(empAdd1His2);
		logger.info("Address Line 1 Entered");
		//Set Address Line 2 on Employment History page
		empHisPage.settxtAdd2His2(empAdd2His2);
		logger.info("Address Line 2 Entered");
		//Set City on Employment History page
		empHisPage.settxtCityHis2(empCityHis2);
		logger.info("City Entered");
		//Set State on Employment History page
		empHisPage.settxtStateHis2(empStateHis2);
		logger.info("State Entered");
		//Set Zip code on Employment History page
		empHisPage.settxtZipHis2(empZipHis2);
		logger.info("Zip code Entered");
		//Set Phone on Employment History page
		empHisPage.settxtPhoneHis2(empPhoneHis2);
		logger.info("Phone Entered");
		//Set Supervisor on Employment History page
		empHisPage.settxtSupHis2(empSupHis2);
		logger.info("Supervisor Entered");
		//Set Position on Employment History page
		empHisPage.settxtPosHis2(empPosHis2);
		logger.info("Position Entered");
		//Set Reason for Leaving on Employment History page
		empHisPage.settxtReasonHis2(empReasonHis2);
		logger.info("Reason for Leaving Entered");
		//Set Work Start Date Employment History page
		empHisPage.setWorkStartHis2(wSyyyyHis2, wSmonHis2, wSddHis2);;
		logger.info("Work Start Date Entered");
		//Set Work End Date Employment History page
		empHisPage.setWorkEndHis2(wEyyyyHis2, wEmonHis2, wEddHis2);;
		logger.info("Work End Date Entered");
		//Set Combined annual salary on Employment History page
		empHisPage.settxtSalHis2(empSalHis2);
		logger.info("Combined annual salary Entered");
		
		
		
		//Assertion AC02:Verify if Employment History 2 is added
		
		if (empHisPage.headEmployerHis2.isDisplayed()) {
				softassert.assertTrue(true);
				logger.info("Passed AC02: Employment History 2 is added");
		} 
		else {
				softassert.assertTrue(false);
				logger.error("Failed AC02: Employment History 2 is NOT added");
		}
		
		empHisPage.clkbtnNxt();
		logger.info("Clicked on Next Button");
		
		// Creating object for Rental history page
		RE_RentalHistoryPage rentHisPage = new RE_RentalHistoryPage(driver);
		
							
		//Assertion AC03:Verify if Rental history Heading is displayed 
							
		if (rentHisPage.txtRentalHis.isDisplayed()) {
				softassert.assertTrue(true);
				logger.info("Passed AC03: Rental History Page is open and heading is displayed");
		} 
		else {
				softassert.assertTrue(false);
				logger.error("Failed AC03:Rental History Page is NOT open or heading is NOT displayed");
			}


		softassert.assertAll();
	}
	
	//Excel Data Provider Method  
			@DataProvider (name="DataTC_CPM_051")
			public Object[][] testData () throws IOException
			{		
				return XLUtils.getData(Excel_Path, "TC_CPM_051");				

			}

}
