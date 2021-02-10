package com.CPM.qa.testCases;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.CPM.qa.baseClass.BaseClass;
import com.CPM.qa.pageObjects.LandingPage;
import com.CPM.qa.pageObjects.LoginPage;
import com.CPM.qa.pageObjects.RE_CoApplicantPage;
import com.CPM.qa.pageObjects.RE_EmploymentHistoryPage;
import com.CPM.qa.pageObjects.RE_HomePage;
import com.CPM.qa.pageObjects.RE_PersonalInfoPage;
import com.CPM.qa.pageObjects.RE_RentalHistoryPage;
import com.CPM.qa.pageObjects.SignUpPage;
import com.CPM.qa.utilities.XLUtils;
/*
This test case is to verify that Applicant is able to fill in the valid employment history details

User enters valid name of Employer and clicks Enter

1.Enter Valid Address

2.User enters valid City Name in the city field

3.User enters valid state name

4.User enters valid Zip code

5.Enter valid phone number

6.Enter valid Supervisor first name

7.Enter valid Supervisor last name

8.Enter valid Position

9.Enter tenure of service

10.Enter Reason of leaving

11.Enter valid Start date

12.Enter valid End date

13.Enter Annual Salary

14.Click Next tab

Acceptance Criteria:

The following will happen for the test case to be considered successful:
AC01:Employment History Tab should be displayed and enabled
AC02: User should be able to move to the Rental History page
 */
public class TC_CPM_029 extends BaseClass {

	@Test(priority=1,dataProvider="DataTC_CPM_029")
	public void tc_cpm_029(String location,String numBed,String numBath,String numGarage,String minRate,String maxRate,String firstName,String lastName,String prefName,String dobYYYY, String dobMon, String dobDD, String phone,String dlNum,String state, String expYYYY, String expMon, String expDD, String ssnNum,String empEmployer,String empAdd1,String empAdd2,String empCity,String empState,String empZip,String empPhone,String empSup,String empPos,String empReason,String wSyyyy,String wSmon,String wSdd,String wEyyyy,String wEmon,String wEdd,String empSal) throws InterruptedException   {
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		logger.info("TC_CPM_029 started");
				
				
		// Assert whether the renter login is successful
		SoftAssert softassert = new SoftAssert();
													
		// Creating object for TC_CPM_013
		TC_CPM_013 TC_013 = new TC_CPM_013();
													
		TC_013.tc_cpm_013(  location,  numBed,  numBath,  numGarage,  minRate,  maxRate,  firstName,  lastName,  prefName,  dobYYYY,   dobMon,   dobDD,   phone,  dlNum,  state,   expYYYY,   expMon,   expDD,   ssnNum);
									
				
		// Creating object for Employment history page
		RE_EmploymentHistoryPage empHisPage = new RE_EmploymentHistoryPage(driver);
		
		//Fill all Main Applicant fields on Employment history page
		logger.info("Fill all Main Applicant fields on Employment history page");
		
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
		empHisPage.clkbtnNxt();
		logger.info("Clicked on Next Button");
		
		// Creating object for Rental history page
		RE_RentalHistoryPage rentHisPage = new RE_RentalHistoryPage(driver);
		
							
		//Assertion AC02:Verify if Rental history Heading is displayed 
							
		if (rentHisPage.txtRentalHis.isDisplayed()) {
				softassert.assertTrue(true);
				logger.info("Passed AC02: Rental History Page is open and heading is displayed");
		} 
		else {
				softassert.assertTrue(false);
				logger.error("Failed AC02:Rental History Page is NOT open or heading is NOT displayed");
			}


		softassert.assertAll();
	}
	
	//Excel Data Provider Method  
			@DataProvider (name="DataTC_CPM_029")
			public Object[][] testData () throws IOException
			{		
				return XLUtils.getData(Excel_Path, "TC_CPM_029");				

			}

}
