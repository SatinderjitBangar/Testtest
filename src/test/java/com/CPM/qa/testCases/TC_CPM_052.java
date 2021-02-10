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
This test case is to verify that user is able to navigate to Banking Reference tab after filling valid details
1. User enters valid address in the Present address field
2. Enter valid reason for leaving previous property
3. Enter valid landlord/Mortgage company name
4. Select valid rent start date
5. Select valid rent end date
6. Enter valid amount paid monthly
7. Enter valid phone
8. Click Next

Acceptance Criteria:The following will happen for the test case to be considered successful:

AC01:User should be able to move to the next tab - Employment History

AC02:User should be able to move to the next tab - Rental History

AC03.User should be able to move to the next tab - Banking Reference
 */
public class TC_CPM_052 extends BaseClass {

	@Test(priority=1,dataProvider="DataTC_CPM_052")
	public void tc_cpm_052(String location,String numBed,String numBath,String numGarage,String minRate,String maxRate,String firstName,String lastName,String prefName,String dobYYYY, String dobMon, String dobDD, String phone,String dlNum,String state, String expYYYY, String expMon, String expDD, String ssnNum,String empEmployer,String empAdd1,String empAdd2,String empCity,String empState,String empZip,String empPhone,String empSup,String empPos,String empReason,String wSyyyy,String wSmon,String wSdd,String wEyyyy,String wEmon,String wEdd,String empSal,String renAdd,String renRorO,String renReason,String renLord,String rSyyyy,String rSmon,String rSdd,String rEyyyy,String rEmon,String rEdd,String renAmount,String renPhone) throws InterruptedException   {
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		logger.info("TC_CPM_052 started");
		
		
		// Creating object for Rental history page
		RE_RentalHistoryPage rentHisPage = new RE_RentalHistoryPage(driver);
								
		// Assert whether the renter login is successful
		SoftAssert softassert = new SoftAssert();
											
		// Creating object for TC_CPM_029
		TC_CPM_029 TC_029 = new TC_CPM_029();
											
		TC_029.tc_cpm_029(  location,  numBed,  numBath,  numGarage,  minRate,  maxRate,  firstName,  lastName,  prefName,  dobYYYY,   dobMon,   dobDD,   phone,  dlNum,  state,   expYYYY,   expMon,   expDD,   ssnNum,  empEmployer,  empAdd1,  empAdd2,  empCity,  empState,  empZip,  empPhone,  empSup,  empPos,  empReason,  wSyyyy,  wSmon,  wSdd,  wEyyyy,  wEmon,  wEdd,  empSal);
									
		
		//Fill all fields on Rental history page for History 1
				logger.info("Fill all fields on Rental history page for History 1");
				
				//Delete Existing Rental History if any
				rentHisPage.clkbtnDelHis1();
				logger.info("Deleted Existing Rental History");
				//Click on Add new Rental History
				rentHisPage.clkbtnAddHis();
				logger.info("Clicked on Add new Rental History");
				//Set Address on Rental History page 
				rentHisPage.settxtAddHis1(renAdd);
				logger.info("Address Entered");
				//Set Rent or Own on Rental History page
				rentHisPage.setdrpRorOHis1(renRorO);
				logger.info("Rent or Own Entered");
				//Set Reason for leaving on Rental History page
				rentHisPage.settxtReasonHis1(renReason);
				logger.info("Reason for leaving  Entered");
				//Set Land Lord on Rental History page
				rentHisPage.settxtLordHis1(renLord);
				logger.info("Land Lord Entered");
				//Set Rent Start date on Rental History page
				rentHisPage.setdateRentStart(rSyyyy, rSmon, rSdd);
				logger.info("Rent Start date Entered");
				//Set Rent End date on Rental History page
				rentHisPage.setdateRentEnd(rEyyyy, rEmon, rEdd);
				logger.info("Rent End date Entered");
				//Set Amount paid monthly on Rental History page
				rentHisPage.settxtAmtHis1(renAmount);
				logger.info("Amount paid monthly Entered");
				//Set Phone on Rental History page
				rentHisPage.settxtPhoneHis1(renPhone);
				logger.info("Phone Number Entered");
				//Click on Next
				rentHisPage.clkbtnNxt();
				logger.info("Clicked on Next Button");
				
		// Creating object for Banking Reference page
			RE_BankingRefPage bankRefPage = new RE_BankingRefPage(driver);
				
		//Assertion AC03:Verify if Banking Reference tab is enabled and selected
				
		if (bankRefPage.dispBankRef()) {
					softassert.assertTrue(true);
					logger.info("Passed AC03:Banking Reference tab is enabled and selected");
		} 
		else {
					softassert.assertTrue(false);
					logger.error("Failed AC03:Banking Reference tab is NOT enabled and selected");
			}
				


		softassert.assertAll();
	}
	
	//Excel Data Provider Method  
			@DataProvider (name="DataTC_CPM_052")
			public Object[][] testData () throws IOException
			{		
				return XLUtils.getData(Excel_Path, "TC_CPM_052");				

			}

}
