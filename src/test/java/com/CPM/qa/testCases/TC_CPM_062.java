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
This test case is to verify whether user is able to successfully select type of account from drop downCase 1: User clicks on drop down arrow and selects checking account.

Case 2: User clicks on drop down arrow and selects savings account.

Acceptance Criteria:The following will happen for the test case to be considered successful:

Case 1 AC: When user selects checking, checking should be displayed

Case 2 AC: When Saving is selected, Savings should be displayed
 */
public class TC_CPM_062 extends BaseClass {

	@Test(priority=1,dataProvider="DataTC_CPM_062")
	public void tc_cpm_062(String location,String numBed,String numBath,String numGarage,String minRate,String maxRate,String firstName,String lastName,String prefName,String dobYYYY, String dobMon, String dobDD, String phone,String dlNum,String state, String expYYYY, String expMon, String expDD, String ssnNum,String empEmployer,String empAdd1,String empAdd2,String empCity,String empState,String empZip,String empPhone,String empSup,String empPos,String empReason,String wSyyyy,String wSmon,String wSdd,String wEyyyy,String wEmon,String wEdd,String empSal,String renAdd,String renRorO,String renReason,String renLord,String rSyyyy,String rSmon,String rSdd,String rEyyyy,String rEmon,String rEdd,String renAmount,String renPhone,String bCorS,String bExpAcc) throws InterruptedException   {
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		logger.info("TC_CPM_062 started");
				
		
		// Creating object for Banking Reference page
			RE_BankingRefPage bankRefPage = new RE_BankingRefPage(driver);
						
		// Assert whether the renter login is successful
			SoftAssert softassert = new SoftAssert();
											
		// Creating object for TC_CPM_052
			TC_CPM_052 TC_052 = new TC_CPM_052();
											
		TC_052.tc_cpm_052(  location,  numBed,  numBath,  numGarage,  minRate,  maxRate,  firstName,  lastName,  prefName,  dobYYYY,   dobMon,   dobDD,   phone,  dlNum,  state,   expYYYY,   expMon,   expDD,   ssnNum,  empEmployer,  empAdd1,  empAdd2,  empCity,  empState,  empZip,  empPhone,  empSup,  empPos,  empReason,  wSyyyy,  wSmon,  wSdd,  wEyyyy,  wEmon,  wEdd,  empSal,  renAdd,  renRorO,  renReason,  renLord,  rSyyyy,  rSmon,  rSdd,  rEyyyy,  rEmon,  rEdd,  renAmount,  renPhone);
										
							
		//Delete Existing Banking Reference if any
		bankRefPage.clkbtnDelBankRef1();
		logger.info("Deleted Banking Reference");
		//Click on Add new Banking Reference
		bankRefPage.clkbtnAddRef();
		logger.info("Clicked on Add new Banking Reference");
		//Set Checking or saving account on Banking Reference page 
		bankRefPage.setdrpBankCorSRef1(bCorS);
		logger.info("Checking or saving account Entered");
								
		//Assertion AC01:Verify if right Account is selected
						
				if (bankRefPage.drpBankCorSCurRef1.getText().equals(bExpAcc)) {
							softassert.assertTrue(true);
							logger.info("Passed AC01:User selected:" + bCorS + " Account selected:" + bankRefPage.drpBankCorSCurRef1.getText());
				} 
				else {
							softassert.assertTrue(false);
							logger.error("Failed AC01:User selected:" + bCorS + " Account selected:" +bankRefPage.drpBankCorSCurRef1.getText());
					}
				


		softassert.assertAll();
	}
	
	//Excel Data Provider Method  
			@DataProvider (name="DataTC_CPM_062")
			public Object[][] testData () throws IOException
			{		
				return XLUtils.getData(Excel_Path, "TC_CPM_062");				

			}

}
