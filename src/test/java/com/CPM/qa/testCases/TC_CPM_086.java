package com.CPM.qa.testCases;


import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.CPM.qa.baseClass.BaseClass;
import com.CPM.qa.pageObjects.LandingPage;
import com.CPM.qa.pageObjects.LoginPage;
import com.CPM.qa.pageObjects.PM_DashboardPage;
import com.CPM.qa.pageObjects.PM_ManageApplicantPage;
import com.CPM.qa.pageObjects.PM_OnlineApplicationListingPage;
import com.CPM.qa.utilities.XLUtils;

/*This is testing when selecting the Banking Reference tab it displays the correct information
a) Go to https://orion.cedallion.com/ and select login link
b) Enter Login credentials as userid john.doe+142@mailinator.com and p/w Password12345$ to sign in as
a Property Manager.
c)Click Login button.
d)Click on Applicant Management.
e)Select propert group as the default one.
f)Click on pencil under Edit column for client (Johnny Doe) in the application listing.
g)Click on Banking Reference

Acceptance Criteria:
The test case will be succesful when the following happens:
AC01- Banking reference information is displayed and static*/
public class TC_CPM_086 extends BaseClass {
	@Test(priority = 1, dataProvider = "DataTC_CPM_086")
	public void tC_CPM_084(String managerEmail, String managerPassword,String landingPageUrl, String bankName, String checkAccount,
			String savingAccount, String phone) throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		logger.info("TC_CPM_086 started");

		// Create an object of Assert
		SoftAssert softassert = new SoftAssert();

		// Create an object of Landing page
		LandingPage landingPage = new LandingPage(driver);
		// Click on login here
		landingPage.clkbtnLogin();
		logger.info("Clicked on login link");

		// Create an object of Login page
		LoginPage loginPage = new LoginPage(driver);
		// enter Login Credentials
		loginPage.settxtEmail(managerEmail);
		logger.info("Email entered");
		loginPage.settxtpassword(managerPassword);
		logger.info("Password entered");

		// Click on login button
		loginPage.clkbtnLogin();
		logger.info("Clicked on login button");

		// Create an object of Dashboard page
		PM_DashboardPage dashbord = new PM_DashboardPage(driver);
		
		// Click on Application Management button
		dashbord.clickAppManage();
		logger.info("Clicked on Application Management button");

		// Create an object of OnlineApplicationListing page
		PM_OnlineApplicationListingPage onlineAppListing = new PM_OnlineApplicationListingPage(driver);

		// Scroll down in the page
		JavascriptExecutor jss = (JavascriptExecutor) driver;
		jss.executeScript("window.scrollBy(0,500)");
		logger.info("Scroll down page");

		// Click on pencil icon to edit application
		Thread.sleep(5000);
		onlineAppListing.clickAppEdit();
		logger.info("Clicked on pencil icon");

		// Scroll down in the page
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,1000)");
		logger.info("Scroll down page");

		// Create an object of Application Management page
		PM_ManageApplicantPage manageApp = new PM_ManageApplicantPage(driver);

		// Click on Banking Refrence button
		manageApp.clickBankRef();
		logger.info("Clicked on Banking Refrence");

		Thread.sleep(1000);

		//AC01- Banking reference information is displayed and static*/

		// check Visibility of bankName
		if (manageApp.bankName.getText().equals(bankName)) {
			softassert.assertTrue(true);
			logger.info("Passed AC01: Visibility of bankName");
		} else {
			softassert.assertTrue(false);
			logger.error("Failed AC01: Visibility of bankName");
		}

		// check Visibility of checking Account
		if (manageApp.checkAccount.getText().equals(checkAccount)) {
			softassert.assertTrue(true);
			logger.info("Passed AC01: Visibility of checking Account");
		} else {
			softassert.assertTrue(false);
			logger.error("Failed AC01: Visibility of checking Account");
		}

		// check Visibility of saving Account
		if (manageApp.savingAccount.getText().equals(savingAccount)) {
			softassert.assertTrue(true);
			logger.info("Passed AC01: Visibility of saving Account");
		} else {
			softassert.assertTrue(false);
			logger.error("Failed AC01: Visibility of saving Account");
		}

		// check Visibility of phone
		if (manageApp.phone.getText().equals(phone)) {
			softassert.assertTrue(true);
			logger.info("Passed AC01: Visibility of phone Sucessful");
		} else {
			softassert.assertTrue(false);
			logger.error("Failed AC01: Visibility of phone Sucessful");
		}

		softassert.assertAll();

	}

	// Excel Data Provider Method
	@DataProvider(name = "DataTC_CPM_086")
	public Object[][] testData() throws IOException {
		return XLUtils.getData(Excel_Path, "TC_CPM_086");
	}
}
