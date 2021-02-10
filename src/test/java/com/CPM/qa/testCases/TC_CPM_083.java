package com.CPM.qa.testCases;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.CPM.qa.baseClass.BaseClass;
import com.CPM.qa.pageObjects.LandingPage;
import com.CPM.qa.pageObjects.LoginPage;
import com.CPM.qa.pageObjects.PM_DashboardPage;
import com.CPM.qa.pageObjects.PM_OnlineApplicationListingPage;
import com.CPM.qa.utilities.XLUtils;

/*This is testing the Logout link on Online Application Listing page  for user logs out the current user.
a) Go to  https://orion.cedallion.com and select login link
b) Enter Login credentials as userid  john.doe+142@mailinator.com and  p/w Password12345$ to sign in as
a Property Manager.
c)Click Login button.
d)Click on Applicant Management.
e)Click on Logout link

Acceptance Criteria:
The test case will be succesful when the following happens:
AC01- User is successfully logged out.*/

public class TC_CPM_083 extends BaseClass {
	@Test(priority = 1, dataProvider = "DataTC_CPM_083")
	public void tC_CPM_083(String managerEmail, String managerPassword, String landingPageUrl)
			throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		logger.info("TC_CPM_083 started");

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

		// Create an object of online Application Management page
		PM_OnlineApplicationListingPage onlineAppListing = new PM_OnlineApplicationListingPage(driver);
		onlineAppListing.clickLogOut();
		logger.info("Clicked on LogOut button");

		// AC01: User is successfully logged out

		if (driver.getCurrentUrl().equals(landingPageUrl)) {
			softassert.assertTrue(true);
			logger.info("Passed AC01: User is successfully logged out  ");
		} else {
			softassert.assertTrue(false);
			logger.error("Failed AC01: User is successfully logged out ");
		}

		softassert.assertAll();

	}

	// Excel Data Provider Method
	@DataProvider(name = "DataTC_CPM_083")
	public Object[][] testData() throws IOException {
		return XLUtils.getData(Excel_Path, "TC_CPM_083");

	}

}

