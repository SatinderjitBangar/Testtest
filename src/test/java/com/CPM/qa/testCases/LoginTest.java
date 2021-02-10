package com.CPM.qa.testCases;

import java.util.concurrent.TimeUnit;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.CPM.qa.baseClass.BaseClass;
import com.CPM.qa.pageObjects.LandingPage;
import com.CPM.qa.pageObjects.LoginPage;
import com.CPM.qa.pageObjects.RE_HomePage;
import com.CPM.qa.pageObjects.RE_PersonalInfoPage;
//This testcase is to check whether login is successful
public class LoginTest extends BaseClass {

	@Test
	public void logintest() {
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		logger.info("Login Test started");
		// Creating object for LandingPage
		LandingPage landingpage = new LandingPage(driver);
		landingpage.clkbtnLogin();
		logger.info("Clicked on Login here button");

		// Creating object for LoginPage
		LoginPage loginpg = new LoginPage(driver);
		loginpg.settxtEmail(username1);
		loginpg.settxtpassword(password1);
		loginpg.clkbtnLogin();
		logger.info("Clicked on Login");

		// Assert whether the renter login is successful
		SoftAssert softassert = new SoftAssert();

		// Creating object for PersonalInfoPage
		RE_HomePage homepage = new RE_HomePage(driver);

		//Assertion
		if (homepage.txtPersonalInfo.isDisplayed()) {
			softassert.assertTrue(true);
			logger.info("Login successful!!");
		} else {
			softassert.assertTrue(false);
			logger.info("Login NOT successful!!");
		}
		softassert.assertAll();
	}

}
