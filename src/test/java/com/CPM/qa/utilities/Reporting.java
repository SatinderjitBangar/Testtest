package com.CPM.qa.utilities;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverEventListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.CPM.qa.baseClass.BaseClass;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.CPM.qa.utilities.ReadConfig;

public class Reporting extends BaseClass implements WebDriverEventListener, ITestListener {

	public ExtentHtmlReporter htmlReporter;
	public ExtentReports extent;
	public ExtentTest test;

        ReadConfig readconfig = new ReadConfig();
        public String os = readconfig.getOs();

		public void beforeNavigateTo(String url, WebDriver driver) {
		System.out.println("Before navigating to: '" + url + "'");
	}

	public void afterNavigateTo(String url, WebDriver driver) {
		System.out.println("Navigated to:'" + url + "'");
	}

	public void beforeChangeValueOf(WebElement element, WebDriver driver) {
		System.out.println("Value of the:" + element.toString() + " before any changes made");
	}

	public void afterChangeValueOf(WebElement element, WebDriver driver) {
		System.out.println("Element value changed to: " + element.toString());
	}

	public void beforeClickOn(WebElement element, WebDriver driver) {
		System.out.println("Trying to click on: " + element.toString());
	}

	public void afterClickOn(WebElement element, WebDriver driver) {
		System.out.println("Clicked on: " + element.toString());
	}

	public void beforeNavigateBack(WebDriver driver) {
		System.out.println("Navigating back to previous page");
	}

	public void afterNavigateBack(WebDriver driver) {
		System.out.println("Navigated back to previous page");
	}

	public void beforeNavigateForward(WebDriver driver) {
		System.out.println("Navigating forward to next page");
	}

	public void afterNavigateForward(WebDriver driver) {
		System.out.println("Navigated forward to next page");
	}

	public void onException(Throwable error, WebDriver driver) {
		System.out.println("Exception occured: " + error);

	}

	
	 @Override
	    public void onTestFailure(ITestResult result) {
	    	System.out.println("Failed Test");
			String feature = result.getMethod().getRealClass().getName()+ ":" + result.getMethod().getMethodName();
			feature = feature.substring(feature.lastIndexOf(".") + 1);	
			test=extent.createTest(feature); // create new entry in the report
			test.log(Status.FAIL, "Test Case FAILED IS " + feature);
			test.log(Status.FAIL, "TEST CASE FAILED IS " + result.getThrowable());
	    	//Get screenshot
	    	String screenshotPath= screenshot(result.getMethod().getMethodName());
			//Attach screenshot to extent report
			try {
				test.addScreenCaptureFromPath(screenshotPath);// adding screen shot	
			} catch (IOException e) {
					e.printStackTrace();
			}
	    }
	 @Override
	    public void onTestSuccess(ITestResult result) {
	    	
	    	System.out.println("Passed Test");
			String feature = result.getMethod().getRealClass().getName()+ ":" + result.getMethod().getMethodName();
			feature = feature.substring(feature.lastIndexOf(".") + 1);	
			test=extent.createTest(feature); // create new entry in the report
			test.log(Status.PASS, "Test Case PASSED IS " + feature);
			
	    }
	 
		public void onStart(ITestContext testContext)
		{
			String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());// time stamp
			String repName = "CPM_ExtentReport-" + timeStamp + ".html"; // Report name and time stamp in html format

			// specify location of the report
                        if (os.equalsIgnoreCase("linux")) {
				htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") + "/ExtentReport/" + repName);
                        } else {
				htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") + "\\ExtentReport\\" + repName);
                        }
			htmlReporter.config().setDocumentTitle("CPM Automation Report"); // Title of Report
			htmlReporter.config().setReportName("CPM Functional Testing"); // Name of the Report
			htmlReporter.config().setTheme(Theme.DARK); // Dark mode
			// htmlReporter.config().setTheme(Theme.STANDARD); //Standard mode

			extent = new ExtentReports();
			extent.attachReporter(htmlReporter);
			// System Information passed in the Report
			extent.setSystemInfo("Project: ", "CPM Automation Regression Test");
			extent.setSystemInfo("Host name: ", "localhost");
			extent.setSystemInfo("Environment: ", "QA");
			extent.setSystemInfo("OS: ", "Windows10");
			extent.setSystemInfo("Browser name: ", "Chrome, Firefox, Edge");
			extent.setSystemInfo("Language: ", "Java");
			extent.setSystemInfo("Framework: ", "TestNG");
			extent.setSystemInfo("Project Type: ", "Maven");
			extent.setSystemInfo("Created By: ", "Busyqa");
			extent.setSystemInfo("Client: ", "Cedallion Property Management");
		}
		public void onTestSkipped (ITestResult result)
		{   System.out.println("Skipped Test");
			String feature = result.getMethod().getRealClass().getName()+ ":" + result.getMethod().getMethodName();
			feature = feature.substring(feature.lastIndexOf(".") + 1);	
			test=extent.createTest(feature); // create new entry in the report
			//test=extent.createTest(result.getName()); // create new entry in the report
			test.log(Status.SKIP, "Test Case SKIIPED  IS " + feature);
			//Get screenshot
	    	String screenshotPath=screenshot(result.getMethod().getMethodName());
			//Attach screenshot to extent report
			try {
				test.addScreenCaptureFromPath(screenshotPath);// adding screen shot	
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void onFinish(ITestContext testContext) {

		extent.flush();

	}

	public void beforeFindBy(By by, WebElement element, WebDriver driver) {
		System.out.println("Trying to find Element By : " + by.toString());
	}

	public void afterFindBy(By by, WebElement element, WebDriver driver) {
		System.out.println("Found Element By : " + by.toString());
	}

	/*
	 * non overridden methods of WebListener class
	 */
	public void beforeScript(String script, WebDriver driver) {
	}

	public void afterScript(String script, WebDriver driver) {
	}

	public void beforeAlertAccept(WebDriver driver) {
		// TODO Auto-generated method stub

	}

	public void afterAlertAccept(WebDriver driver) {
		// TODO Auto-generated method stub

	}

	public void afterAlertDismiss(WebDriver driver) {
		// TODO Auto-generated method stub

	}

	public void beforeAlertDismiss(WebDriver driver) {
		// TODO Auto-generated method stub

	}

	public void beforeNavigateRefresh(WebDriver driver) {
		// TODO Auto-generated method stub

	}

	public void afterNavigateRefresh(WebDriver driver) {
		// TODO Auto-generated method stub

	}

	public void beforeChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {
		// TODO Auto-generated method stub

	}

	public void afterChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {
		// TODO Auto-generated method stub

	}

	public <X> void afterGetScreenshotAs(OutputType<X> arg0, X arg1) {
		// TODO Auto-generated method stub

	}

	public void afterGetText(WebElement arg0, WebDriver arg1, String arg2) {
		// TODO Auto-generated method stub

	}

	public void afterSwitchToWindow(String arg0, WebDriver arg1) {
		// TODO Auto-generated method stub

	}

	public <X> void beforeGetScreenshotAs(OutputType<X> arg0) {
		// TODO Auto-generated method stub

	}

	public void beforeGetText(WebElement arg0, WebDriver arg1) {
		// TODO Auto-generated method stub

	}

	public void beforeSwitchToWindow(String arg0, WebDriver arg1) {
		// TODO Auto-generated method stub

	}

}
