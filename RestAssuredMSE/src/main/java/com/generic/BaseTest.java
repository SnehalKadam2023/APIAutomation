package com.generic;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Collections;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import java.lang.reflect.Method;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * @ScriptName : BaseTest
 * @Description : This class will load all test data, load all objects,
 *              initialize web driver,Contains generic
 *              functionalities like open browser, login/logout
 * @Author : Automation Tester
 */
public class BaseTest extends Pojo {

	private WebDriver webDriver;
	private ChromeOptions options = new ChromeOptions();
	private WrapperFunctions objWrapperFunctions;
	private static Properties properties;
	//Extent Report
	public static ExtentReports extent;
	public static ThreadLocal<ExtentTest> classLevelLog = new ThreadLocal<ExtentTest>();
	public static ThreadLocal<ExtentTest> testLevelLog = new ThreadLocal<ExtentTest>();



	public WebDriver initializeWebEnvironment(String Url) {
		options.addArguments("--disable-extensions");
		options.addArguments("--no-sandbox");
		options.addArguments("--disable-notifications");
		options.addArguments("--disable-dev-shm-usage");
		options.addArguments("--disable-infobars");
		options.setExperimentalOption("useAutomationExtension", false);
		options.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));
		options.addArguments("--start-maximized");
		try {
			WebDriverManager.chromedriver().setup();
			setWebDriver(new ChromeDriver(options));
			getWebDriver().get(Url);
			getWebDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			getWebDriver().manage().window().maximize();

			objWrapperFunctions = new WrapperFunctions(this);
			this.setObjWrapperFunctions(objWrapperFunctions);

			return webDriver;

		} catch (Exception exception) {
			exception.printStackTrace();
			return null;
		}
	}
	public void tearDownWebEnvironment() {
		try {
			webDriver.quit();
		} catch (Exception exception) {
			exception.printStackTrace();
		}
	}
	
	public static void ConfigFileReader(){
	    BufferedReader reader;
	    try {
	        reader = new BufferedReader(new FileReader("./src/test/resources/config.properties"));
	        properties = new Properties(); 
	        properties.load(reader);
	        setConfig(properties);
	        reader.close();
	        
	    } catch (Exception e) {
	        e.printStackTrace();
	    }        
	}

	@BeforeSuite
	public void setUp() {
		extent=ExtentReportManager.GetExtent("./target/AutomationReport.html");
	}

	@BeforeTest
	public void beforeTest() {

	}

	@BeforeClass
	public void beforeClass() {
		ExtentTest classLevelTest = extent.createTest(getClass().getSimpleName());
		classLevelLog.set(classLevelTest);
		ConfigFileReader(); 
	}

	@BeforeMethod
	public void beforeMethod(Method method) {
		ExtentTest test = classLevelLog.get().createNode(method.getName());
		testLevelLog.set(test);
	}

	@AfterMethod
	public void afterMethod(ITestResult testCaseResult) {
		if(testCaseResult.isSuccess())
		{
		  testLevelLog.get().pass("This test case got passed");	
		}
		else
		{
			testLevelLog.get().fail("This test case got failed");
		}
		extent.flush();
	}

	@AfterClass
	public void afterClass() {

	}

	@AfterTest
	public void afterTest() {

	}
	@AfterSuite
	public void tearDown() {

	}



}