
package com.generic;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.json.simple.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.Reporter;

import com.api.pojoResponse.URLpage;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.response.Response;

import org.openqa.selenium.JavascriptExecutor;

/**
 * @ScriptName : WrapperFunctions
 * @Description : Core wrapper function required for framework
 * @Author : Automation Tester
 */
public class WrapperFunctions {
	private Pojo objPojo;
	final Logger logger = Logger.getLogger(WrapperFunctions.class);

	public WrapperFunctions(Pojo pojo) {
		this.objPojo = pojo;
	}

	/**
	 * @Description : This is wrapper method wait for element presence located
	 * @param : locator - By identification of element
	 */
	public void waitForElementPresence(By locator) throws NotFoundException {
		objPojo.getWebDriverWait().until(ExpectedConditions.presenceOfElementLocated(locator));
	}

	/**
	 * @Description : This is wrapper method wait for element presence located
	 * @param : locator - By identification of element
	 */
	public void waitForPresenceOfNestedElementLocated(WebElement webElement, By sub_locator) throws NotFoundException {
		objPojo.getWebDriverWait().until(ExpectedConditions.presenceOfNestedElementLocatedBy(webElement, sub_locator));
	}

	/**
	 * @Description : This is wrapper method wait for element presence located
	 * @param : locator - By identification of element
	 */
	public void waitForPresenceOfNestedElementsLocated(By locator, By sub_locator) throws NotFoundException {
		objPojo.getWebDriverWait().until(ExpectedConditions.presenceOfNestedElementsLocatedBy(locator, sub_locator));
	}

	/**
	 * @Description : This is wrapper method wait for element to be clickable
	 * @param : locator - By identification of element
	 */
	public void waitForElementToBeClickable(By locator) throws NotFoundException {
		objPojo.getWebDriverWait().until(ExpectedConditions.elementToBeClickable(locator));
	}

	/**
	 * @Description : This is wrapper method wait for visibility of element located
	 * @param : locator - By identification of element
	 */
	public void waitForElementVisibilityLocated(By locator) throws NotFoundException {
		objPojo.getWebDriverWait().until(ExpectedConditions.visibilityOfElementLocated(locator));
	}

	public void waitForElementVisibility(WebElement webElement) throws NotFoundException {
		objPojo.getWebDriverWait().until(ExpectedConditions.visibilityOf(webElement));
	}

	/**
	 * @Description : This is wrapper method wait for visibility of element located
	 * @param : locator - By identification of element
	 */
	public void waitForElementInVisibilityLocated(By locator) throws NotFoundException {
		objPojo.getWebDriverWait().until(ExpectedConditions.invisibilityOfElementLocated(locator));
	}

	/**
	 * @Method : waitFor
	 * @Description : Waits for the specified amount of [timeInMilliseconds].
	 * @param : timeUnitSeconds - wait time seconds
	 */
	public boolean waitFor(int timeUnitSeconds) {
		try {
			Thread.sleep(TimeUnit.MILLISECONDS.convert(timeUnitSeconds, TimeUnit.SECONDS));
			return true;
		} catch (Exception exception) {
			exception.printStackTrace();
			return false;
		}
	}

	/**
	 * @Method : waitFor
	 * @Description : Waits for the specified amount of [timeInMilliseconds].
	 * @param : timeUnitSeconds - wait time seconds
	 */
	public boolean waitFor(String timeUnitSeconds) {
		try {
			Thread.sleep(TimeUnit.MILLISECONDS.convert(Integer.parseInt(timeUnitSeconds), TimeUnit.SECONDS));
			return true;
		} catch (Exception exception) {
			exception.printStackTrace();
			return false;
		}
	}

	/**
	 * @Description : This is wrapper method to check the web element is displayed
	 *              on the page
	 * @param : locator - By identification of element
	 * @return : - true if element present
	 */
	public boolean checkElementDisplayed(By locator) {
		try {
			this.waitForElementVisibilityLocated(locator);
			return objPojo.getWebDriver().findElement(locator).isDisplayed();
		} catch (NotFoundException exception) {
			System.out.println("I got timeout " + exception.getMessage());
			exception.printStackTrace();
			return false;
		} catch (Exception exception) {
			return false;
		}
	}

	/**
	 * @Description : This is wrapper method to check the web element is displayed
	 *              on the page
	 * @param : locator - By identification of element
	 * @return : - true if element present
	 */
	public boolean checkElementPresence(By locator) {
		try {
			this.waitForElementPresence(locator);
			return true;
		} catch (Exception exception) {
			return false;
		}
	}

	/**
	 * @Description : This is wrapper method to check the web element is displayed
	 *              on the page
	 * @param : locator - By identification of element
	 * @return : - true if element present
	 */
	public boolean isElementDisplayed(By locator) {
		try {
			objPojo.getWebDriverWait().until(ExpectedConditions.visibilityOfElementLocated(locator));
			return true;
		} catch (Exception exception) {
			return false;
		}
	}

	/**
	 * @Description : This is wrapper method to check the web element is displayed
	 *              on the page
	 * @param : locator - By identification of element
	 * @return : - true if element present
	 */
	public boolean checkElementVisibile(By locator) {
		try {
			this.waitForElementVisibilityLocated(locator);
			return objPojo.getWebDriver().findElement(locator).isDisplayed();
		} catch (Exception exception) {
			return false;
		}
	}

	/**
	 * @Description : This is wrapper method to check the web element is displayed
	 *              on the page
	 * @param : locator - By identification of element
	 * @return : - true if element present
	 */
	public boolean checkElementInVisibile(By locator) {
		try {
			this.waitForElementInVisibilityLocated(locator);
			return !objPojo.getWebDriver().findElement(locator).isDisplayed();
		} catch (Exception exception) {
			return false;
		}
	}

	/**
	 * @Method : click
	 * @Description : This is wrapper method to click on web element
	 * @param : locator - By identification of element
	 * @return : - true if click successful
	 * @author : Automation Tester
	 */
	public boolean click(By locator) {
		try {
			waitForElementPresence(locator);
			waitForElementToBeClickable(locator);
			objPojo.getWebDriver().manage().timeouts().setScriptTimeout(objPojo.getScriptTimeoutWait(),
					TimeUnit.SECONDS);
			JavascriptExecutor js = (JavascriptExecutor) objPojo.getWebDriver();
			js.executeScript("return arguments[0].click()", locator);
			return true;
		} catch (Exception exception) {
			try {
				waitForElementPresence(locator);
				waitForElementToBeClickable(locator);
				return true;
			} catch (Exception exceptionJavascript) {
				return false;
			}
		}
	}

	/**
	 * @Method :
	 * @Description : This is wrapper method to set text for input element
	 * @param : element - WebElement identification of element
	 * @param : fieldValue - field value as string
	 * @return : - true if text entered successfully
	 * @author : Automation Tester
	 */
	public boolean setText(WebElement element, String fieldValue) {
		try {
			waitForElementVisibility(element);
			element.clear();
			element.sendKeys(fieldValue);
			return true;
		} catch (Exception exception) {
			exception.printStackTrace();
			return false;
		}
	}

	public String createAPIFromPojo(Object objPojoApi) {
		ObjectMapper objectMapper = new ObjectMapper();
		String addPlaceJson = "";
		try {
			addPlaceJson = objectMapper.writeValueAsString(objPojoApi);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return addPlaceJson;
	}
	
	public void logReporter(String step, String value, boolean resultLog) {
		String strLog = step + " : "+ value + " " ;
		if (resultLog==true) {
			Reporter.log("Step Description--> " + strLog);// generate report
			logger.info("Step Description--> " + strLog);
			Assert.assertTrue(resultLog);
		} else {
			Reporter.log("Step Description--> " + strLog);
			logger.error("Step Description--> " + strLog);
			Assert.assertTrue(resultLog);
		}
	}
	
	public void logReporter(String step,int value, boolean resultLog) {
		String strLog = step + " : "+ value + " " ;
		if (resultLog==true) {
			Reporter.log("Step Description--> " + strLog);// generate report
			logger.info("Step Description--> " + strLog);
			Assert.assertTrue(resultLog);
		} else {
			Reporter.log("Step Description--> " + strLog);
			logger.error("Step Description--> " + strLog);
			Assert.assertTrue(resultLog);
		}
	}
	
	public String getRandomStringWithNumbers(int lenght) 
	{
		String allowedChars = "1234567890";
		String randomstring = "";
		for (int i=0; i < lenght; i++) 
		{
			int rnum = (int) Math.floor(Math.random() * allowedChars.length() );
			randomstring += allowedChars.substring(rnum,rnum+1);
		}
		return randomstring;
	}

	public void logReporter(String step, boolean strSuccess) {
		String strLog = step + " : "+ strSuccess + " " ;
		if (strSuccess==true) {
			Reporter.log("Step Description--> " + strLog);// generate report
			logger.info("Step Description--> " + strLog);
			Assert.assertTrue(strSuccess);
		} else {
			Reporter.log("Step Description--> " + strLog);
			logger.error("Step Description--> " + strLog);
			Assert.assertTrue(strSuccess);
		}
		
	}
	public void logReporterFalseScenario(String step, boolean strFailed) {
		String strLog = step + " : "+ strFailed + " " ;
		if (strFailed==false) {
			Reporter.log("Step Description--> " + strLog);// generate report
			logger.info("Step Description--> " + strLog);
			Assert.assertFalse(strFailed);
		} else {
			Reporter.log("Step Description--> " + strLog);
			logger.error("Step Description--> " + strLog);
			Assert.assertFalse(strFailed);
		}
		
	}
}