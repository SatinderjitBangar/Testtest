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

/*This is testing when selecting the Employment History tab it displays the correct information
a) Go to https://orion.cedallion.com/ and select login link
b) Enter Login credentials as userid john.doe+142@mailinator.com and p/w Password12345$ to sign in as
a Property Manager.
c)Click Login button.
d)Click on Applicant Management.
e)Select propert group as the default one.
f)Click on pencil under Edit column for client (Johnny Doe) in the application listing.
g)Click on Employment History

Acceptance Criteria:
The test case will be succesful when the following happens:
AC01- Employment History information is displayed showing Company, Position, End Date, Salary*/

public class TC_CPM_084 extends BaseClass {
	@Test(priority = 1, dataProvider = "DataTC_CPM_084")
	public void tC_CPM_084(String managerEmail, String managerPassword, String landingPageUrl, String companny,
			String positionn, String endDatee, String salaray) throws InterruptedException {
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

		// Click on Employment History button
		manageApp.clickEmpHistory();
		logger.info("Clicked on Employment History");

		Thread.sleep(1000);

		// AC01- Employment History information is displayed showing Company, Position,
		// End Date, Salary

		// check Visibility of Company
		if (manageApp.company.getText().equals(companny)) {
			softassert.assertTrue(true);
			logger.info("Passed AC01: Visibility of Company Sucessful");
		} else {
			softassert.assertTrue(false);
			logger.error("Failed AC01: Visibility of Company Sucessful");
		}

		// check Visibility of Position
		if (manageApp.position.getText().equals(positionn)) {
			softassert.assertTrue(true);
			logger.info("Passed AC01: Visibility of Position Sucessful");
		} else {
			softassert.assertTrue(false);
			logger.error("Failed AC01: Visibility of Position Sucessful");
		}

		// check Visibility of End Date
		if (manageApp.endDate.getText().equals(endDatee)) {
			softassert.assertTrue(true);
			logger.info("Passed AC01: Visibility of End Date Sucessful");
		} else {
			softassert.assertTrue(false);
			logger.error("Failed AC01: Visibility of End Date Sucessful");
		}

		// check Visibility of Salary
		if (manageApp.salary.getText().equals(salaray)) {
			softassert.assertTrue(true);
			logger.info("Passed AC01: Visibility of Salary Sucessful");
		} else {
			softassert.assertTrue(false);
			logger.error("Failed AC01: Visibility of Salary Sucessful");
		}

		softassert.assertAll();

	}

	// Excel Data Provider Method
	@DataProvider(name = "DataTC_CPM_084")
	public Object[][] testData() throws IOException {
		return XLUtils.getData(Excel_Path, "TC_CPM_084");
	}
}

