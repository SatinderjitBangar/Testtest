package com.CPM.qa.baseClass;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.*;
import com.CPM.qa.utilities.ReadConfig;
import com.CPM.qa.utilities.Reporting;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

public class BaseClass {
	// Creating object for ReadConfig Class
	ReadConfig readconfig = new ReadConfig();
	// Integrating data from ReadConfig
	public String baseURL = readconfig.getApplicationURL();
	public String username1 = readconfig.getUsername1();
	public String password1 = readconfig.getPassword1();
	public String username2 = readconfig.getUsername2();
	public String password2 = readconfig.getPassword2();
	public String username3 = readconfig.getUsername3();
	public String password3 = readconfig.getPassword3();
	public String os = readconfig.getOs();
	public static WebDriver driver;
	public static Logger logger;
	public static EventFiringWebDriver e_driver;
	public static Reporting eventListener;
	public String Excel_Path = System.getProperty("user.dir") + "/src/test/java/com/CPM/qa/testData//CPMTestData.xlsx";
	public String screenpath;
	
	@Parameters("browser")
	@BeforeMethod
		public void setup(String browser) {
		// Initialization // Logger initiated within the setup method
		logger = Logger.getLogger("CPM");// Project Name
		PropertyConfigurator.configure("log4j.properties"); // Added Logger
		logger.setLevel(Level.DEBUG); // To get the debug log
		logger.debug("Debug logging has started ");

		if (browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", readconfig.getChromePath());
			if (os.equalsIgnoreCase("linux")) {
				ChromeOptions options = new ChromeOptions();
				options.addArguments("--no-sandbox", "--headless", "--disable-gpu", "--window-size=1920,1200","--ignore-certificate-errors");
				driver = new ChromeDriver(options);
			} else {
				driver = new ChromeDriver();
			}
			driver.get(baseURL);
			logger.info("Opening URL in Chrome Browser!");

		}

		else if (browser.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", readconfig.getFFPath());
			if (os.equalsIgnoreCase("linux")) {
				FirefoxBinary firefoxBinary = new FirefoxBinary();
			        firefoxBinary.addCommandLineOptions("--headless");
				FirefoxOptions firefoxOptions = new FirefoxOptions();
				firefoxOptions.setBinary(firefoxBinary);
				driver = new FirefoxDriver(firefoxOptions);
			} else {
				driver = new FirefoxDriver();
			}
			driver.get(baseURL);
			logger.info("Opening URL in Firefox Browser!");
		}

		else if (browser.equalsIgnoreCase("edge")) {
			System.setProperty("webdriver.edge.driver", readconfig.getEdgePath());
			driver = new EdgeDriver();
			driver.get(baseURL);
			logger.info("Opening URL in Microsoft Edge!");
		}

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		e_driver = new EventFiringWebDriver(driver);
		// Now create object of EventListerHandler to register it with
		// EventFiringWebDriver
		eventListener = new Reporting();
		e_driver.register(eventListener);
		driver = e_driver;

	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

	// Method to take screenshot
	public String screenshot(String testMethodName) {
		//TakesScreenshot ts = (TakesScreenshot) driver;
		Screenshot s=new AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000)).takeScreenshot(driver);
		//File source = ts.getScreenshotAs(OutputType.FILE);
		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());// time stamp
		String destination;
		if (os.equalsIgnoreCase("linux")) {
			destination = System.getProperty("user.dir")+"/Screenshots/" + testMethodName + "-" + timeStamp
							+ ".png";
		} else {
			destination = System.getProperty("user.dir")+"\\Screenshots\\" + testMethodName + "-" + timeStamp
								+ ".png";
		}
	
		
		//String destination = System.getProperty("user.dir")+"\\Screenshots\\" + testMethodName + "-" + timeStamp
			//			+ ".png";
		
		try {
			File outputFile = new File(destination);
			File parentDir = outputFile.getParentFile();
			 if(parentDir !=null && ! parentDir.exists() ){
			    if(!parentDir.mkdirs()){
			        throw new IOException("error creating directories");
			    }
			 }
			ImageIO.write(s.getImage(),"PNG", outputFile);
			//FileUtils.copyFile(source, new File(destination));
		} catch (IOException e) {
			e.printStackTrace();
		}

		screenpath = "../Screenshots/"+ testMethodName + "-" + timeStamp	+ ".png";
		return screenpath;
	}

}

