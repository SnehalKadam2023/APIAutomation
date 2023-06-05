package com.generic;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import java.io.File;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.testng.IReporter;
import org.testng.IResultMap;
import org.testng.ISuite;
import org.testng.ISuiteResult;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.xml.XmlSuite;

public class HtmlCustomReporter implements IReporter {
	private ExtentReports objExtentReports;
	private ExtentTest objExtentTest;

	public void generateReport(List<XmlSuite> xmlSuites, List<ISuite> suites, String outputDirectory) {
		outputDirectory = System.getProperty("user.dir");
		this.objExtentReports = new ExtentReports(
				outputDirectory + "/target/custom-reports/" + File.separator + "HTML-DashboardReport.html", true);
		this.objExtentReports.loadConfig(
				new File(System.getProperty("user.dir") + "/src/main/resources/externalResources/extent-config.xml"));
		Iterator var5 = suites.iterator();

		while (var5.hasNext()) {
			ISuite suite = (ISuite) var5.next();
			Map<String, ISuiteResult> result = suite.getResults();
			Iterator var8 = result.values().iterator();

			while (var8.hasNext()) {
				ISuiteResult r = (ISuiteResult) var8.next();
				ITestContext context = r.getTestContext();
				this.buildTestNodes(context.getPassedTests(), LogStatus.PASS);
				this.buildTestNodes(context.getFailedTests(), LogStatus.FAIL);
				this.buildTestNodes(context.getSkippedTests(), LogStatus.SKIP);
			}
		}

		this.objExtentReports.flush();
		this.objExtentReports.close();
	}

	private void buildTestNodes(IResultMap tests, LogStatus status) {
		if (tests.size() > 0) {
			Iterator var4 = tests.getAllResults().iterator();

			while (var4.hasNext()) {
				ITestResult result = (ITestResult) var4.next();
				this.objExtentTest = this.objExtentReports.startTest(result.getMethod().getMethodName());
				this.objExtentTest.log(LogStatus.INFO, "" + result.getMethod().getMethodName() + " Started..");
				System.out.println("TC_ID Method Name :: " + result.getMethod().getMethodName());
				String[] var8;
				int var7 = (var8 = result.getMethod().getGroups()).length;

				String message;
				for (int var6 = 0; var6 < var7; ++var6) {
					message = var8[var6];
					this.objExtentTest.assignCategory(new String[]{message});
				}

				message = "Test " + status.toString().toLowerCase() + "ed";
				if (result.getThrowable() != null) {
					message = result.getThrowable().getMessage();
				}

				this.objExtentTest.log(status, message);
				this.objExtentReports.endTest(this.objExtentTest);
				this.objExtentTest.log(LogStatus.INFO, "Test Ended");
			}
		}

	}

	private Date getTime(long millis) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTimeInMillis(millis);
		return calendar.getTime();
	}
}