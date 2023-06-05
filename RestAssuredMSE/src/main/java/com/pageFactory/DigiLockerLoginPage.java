package com.pageFactory;

import org.openqa.selenium.By;
import com.generic.Pojo;
import com.generic.WrapperFunctions;

public class DigiLockerLoginPage {
	private Pojo objPojo ;
	private WrapperFunctions objWrapperFunctions;

	public DigiLockerLoginPage(Pojo pojo) {
		this.objPojo = pojo;
		objWrapperFunctions = new WrapperFunctions(objPojo);
		
	}

	By locMobileNumber= By.xpath("//input[@id='mobilenumber']");
	By locUserPin = By.xpath("//input[@id='passwordmobile']");
	By locCheckboxConsent = By.xpath("//input[@type='checkbox' and @id='terms2']");
	By locBtnLogin = By.xpath("//button[@id='submitbtn2']");
	By locOTP = By.xpath("//input[@id='otp']");
	By locAllow = By.xpath("//input[@id='authorizedbtn' and @value='Allow']");
	By locUseName= By.xpath("//input[@id='username']");
	By locUserPassword = By.xpath("//input[@id='password']");
	By locUsenameTab =By.xpath("//button[@id='userbtn']");
	By locCheckboxConsentUsername = By.xpath("//input[@type='checkbox' and @id='terms1']");
	By locBtnLoginUsername = By.xpath("//button[@id='submitbtn1']");

	public void setMobileNo(String mobileNo) {
		objPojo.getWebDriver().findElement(locMobileNumber).sendKeys(mobileNo);
		objWrapperFunctions.logReporter("Verify user enters mobile number ",mobileNo, true);
	}
	public void setUsername(String username) {
		objPojo.getWebDriver().findElement(locUseName).sendKeys(username);
		objWrapperFunctions.logReporter("Verify user enters mobile number ",username, true);
	}

	public void setUserPin(String userPin) {
		objPojo.getWebDriver().findElement(locUserPin).sendKeys(userPin);
		objWrapperFunctions.logReporter("Verify user enters pin",userPin, true);	
	}
	public void setUserPassword(String userPassword) {
		objPojo.getWebDriver().findElement(locUserPassword).sendKeys(userPassword);
		objWrapperFunctions.logReporter("Verify user enters pin",userPassword, true);	
	}

	public void selectCheckbox() {
		objPojo.getWebDriver().findElement(locCheckboxConsent).click();	
		objWrapperFunctions.logReporter("Verify user is able to select checkbox",null, true);
	}

	public void clickOnSignInbutton() {
		objPojo.getWebDriver().findElement(locBtnLogin).click();
		objPojo.getObjWrapperFunctions().waitFor(10);
		objWrapperFunctions.logReporter("Verify user is able to click on signin button",null, true);
	}

	public void clickOnAllowButton() {
		objPojo.getWebDriver().findElement(locAllow).click();	
		objWrapperFunctions.logReporter("Verify user is able to click on Allow button",null, true);
	}

	public String getAuthCode() {
		String url =objPojo.getWebDriver().getCurrentUrl();
		String[] result = url.split("\\?");
		String[] result1= result[1].split("\\&");
		String[] strAuthCode= result1[0].split("\\=");
		objWrapperFunctions.logReporter("Verify user gets auth code ",strAuthCode[1], true);
		return strAuthCode[1];
	}
	public void clickOnUseNameTab() {
		objPojo.getObjWrapperFunctions().waitFor(3);
		objPojo.getWebDriver().findElement(locUsenameTab).click();	
		objWrapperFunctions.logReporter("Verify user is able to click on Usename tab",null, true);
		
	}
	public void selectCheckboxUsername() {
		objPojo.getWebDriver().findElement(locCheckboxConsentUsername).click();	
		objWrapperFunctions.logReporter("Verify user is able to select checkbox",null, true);
	}

	public void clickOnSignInbuttonUsername() {
		objPojo.getWebDriver().findElement(locBtnLoginUsername).click();
		objPojo.getObjWrapperFunctions().waitFor(10);
		objWrapperFunctions.logReporter("Verify user is able to click on signin button",null, true);
	}
}