package com.generic;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Pojo {
	private WebDriverWait webDriverWait;
	private WebDriverWait DriverWait;
	private WrapperFunctions objWrapperFunctions;
	private WebDriver webDriver;
	private int scriptTimeoutWait = 0;
	private static Properties config;

	public WebDriver getWebDriver() {
		return webDriver;
	}

	public void setWebDriver(WebDriver webDriver) {
		this.webDriver = webDriver;
	}
	public void setWebDriverWait(WebDriverWait webDriverWait) {
		this.webDriverWait = webDriverWait;
	}

	public WebDriverWait getWebDriverWait() {
		return this.webDriverWait;
	}

	public void setAppiumDriverWait(WebDriverWait DriverWait) {
		this.DriverWait = DriverWait;
	}

	public WebDriverWait getAppiumDriverWait() {
		return this.DriverWait;
	}
	public WrapperFunctions getObjWrapperFunctions() {
		return this.objWrapperFunctions;
	}

	public void setObjWrapperFunctions(WrapperFunctions objWrapperFunctions) {
		this.objWrapperFunctions = objWrapperFunctions;
	}
	
	public int getScriptTimeoutWait() {
		return this.scriptTimeoutWait;
	}

	public void setScriptTimeoutWait(int scriptTimeoutWait) {
		this.scriptTimeoutWait = scriptTimeoutWait;
	}
	
	 public static Properties getConfig() {
	        return config;
	    }
	    public static void setConfig(Properties config) {
	        Pojo.config = config;
	    }
}