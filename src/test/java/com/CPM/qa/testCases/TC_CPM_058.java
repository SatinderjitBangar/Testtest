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
import com.CPM.qa.pageObjects.RE_RentalHistoryPage;
import com.CPM.qa.pageObjects.SignUpPage;
import com.CPM.qa.utilities.XLUtils;
/*
This test case is to verify whether user is able to navigate to next page after filling in valid details on Banking Reference Page
1. Enter valid name
2. Enter valid address
3. Enter valid city name
4. Enter valid State/Province
5. Select checking/savings account
6. Enter valid account number
7. Enters valid checking balance
8. Enter valid phone number
9. Click Next

Acceptance Criteria:The following will happen for the test case to be considered successful:

AC01:User should be able to move to the next tab - Employment History

AC02:User should be able to move to the next tab - Rental History

AC03.User should be able to move to the next tab - Banking Reference

AC04.User should be able to successfully navigate to next page-Personal Reference
 */
public class TC_CPM_058 extends BaseClass {

	@Test(priority=1,dataProvider="DataTC_CPM_058")
	public void tc_cpm_058(String location,String numBed,String numBath,String numGarage,String minRate,String maxRate,String firstName,String lastName,String prefName,String dobYYYY, String dobMon, String dobDD, String phone,String dlNum,String state, String expYYYY, String expMon, String expDD, String ssnNum,String empEmployer,String empAdd1,String empAdd2,String empCity,String empState,String empZip,String empPhone,String empSup,String empPos,String empReason,String wSyyyy,String wSmon,String wSdd,String wEyyyy,String wEmon,String wEdd,String empSal,String renAdd,String renRorO,String renReason,String renLord,String rSyyyy,String rSmon,String rSdd,String rEyyyy,String rEmon,String rEdd,String renAmount,String renPhone,String bName,String bAdd,String bCity,String bState,String bZip,String bPhone,String bCorS,String bAcc,String bBal) throws InterruptedException   {
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		logger.info("TC_CPM_058 started");
				
				
		
		// Creating object for Banking Reference page
			RE_BankingRefPage bankRefPage = new RE_BankingRefPage(driver);
				
		// Assert whether the renter login is successful
			SoftAssert softassert = new SoftAssert();
									
		// Creating object for TC_CPM_052
		TC_CPM_052 TC_052 = new TC_CPM_052();
									
		TC_052.tc_cpm_052(  location,  numBed,  numBath,  numGarage,  minRate,  maxRate,  firstName,  lastName,  prefName,  dobYYYY,   dobMon,   dobDD,   phone,  dlNum,  state,   expYYYY,   expMon,   expDD,   ssnNum,  empEmployer,  empAdd1,  empAdd2,  empCity,  empState,  empZip,  empPhone,  empSup,  empPos,  empReason,  wSyyyy,  wSmon,  wSdd,  wEyyyy,  wEmon,  wEdd,  empSal,  renAdd,  renRorO,  renReason,  renLord,  rSyyyy,  rSmon,  rSdd,  rEyyyy,  rEmon,  rEdd,  renAmount,  renPhone);
													
		
		//Fill all fields on Banking Reference page for Reference 1
		logger.info("Fill all fields on Banking Reference page for Reference 1");
		
		//Delete Existing Banking Reference if any
		bankRefPage.clkbtnDelBankRef1();
		logger.info("Deleted Banking Reference");
		//Click on Add new Banking Reference
		bankRefPage.clkbtnAddRef();
		logger.info("Clicked on Add new Banking Reference");
		//Set Bank Name on Banking Reference page 
		bankRefPage.settxtBankNameRef1(bName);
		logger.info("Bank Name Entered");
		//Set Bank Address on Banking Reference page 
		bankRefPage.settxtBankAddRef1(bAdd);
		logger.info("Bank Address Entered");
		//Set Bank City on Banking Reference page 
		bankRefPage.settxtBankCityRef1(bCity);
		logger.info("Bank City Entered");
		//Set Bank State on Banking Reference page 
		bankRefPage.settxtBankStateRef1(bState);
		logger.info("Bank State Entered");
		//Set Bank Zip Code on Banking Reference page 
		bankRefPage.settxtBankZipRef1(bZip);
		logger.info("Bank Zip Code Entered");
		//Set Bank Phone Code on Banking Reference page 
		bankRefPage.settxtBankPhoneRef1(bPhone);
		logger.info("Bank Phone Code Entered");
		//Set Checking or saving account on Banking Reference page 
		bankRefPage.setdrpBankCorSRef1(bCorS);
		logger.info("Checking or saving account Entered");
		//Set Account number on Banking Reference page 
		bankRefPage.settxtBankAccRef1(bAcc);
		logger.info("Account Number Entered");
		//Set Account Balance on Banking Reference page 
		bankRefPage.settxtBankBalRef1(bBal);
		logger.info("Account Balance Entered");
		//Click on Next button on Banking Reference page 
		bankRefPage.clkbtnNxt();
		logger.info("Clicked Next Button");
		
		// Creating object for Personal Reference page
					RE_PersonalRefPage PersRefPage = new RE_PersonalRefPage(driver);
						
		//Assertion AC04:Verify if Personal Reference tab is enabled and selected
						
				if (PersRefPage.dispPersRef()) {
							softassert.assertTrue(true);
							logger.info("Passed AC04:Personal Reference tab is enabled and selected");
				} 
				else {
							softassert.assertTrue(false);
							logger.error("Failed AC04:Personal Reference tab is NOT enabled and selected");
					}
				


		softassert.assertAll();
	}
	
	//Excel Data Provider Method  
			@DataProvider (name="DataTC_CPM_058")
			public Object[][] testData () throws IOException
			{		
				return XLUtils.getData(Excel_Path, "TC_CPM_058");				

			}

}
