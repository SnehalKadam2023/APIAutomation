package com.api.view;

import org.apache.log4j.Logger;

import com.generic.Pojo;
import com.generic.WrapperFunctions;

import io.restassured.response.Response;

public class commonMethodsView {

	private Pojo objPojo;
	private WrapperFunctions objWrapperFunctions;

	public commonMethodsView(Pojo pojo) {
		this.objPojo = pojo;
		objWrapperFunctions = new WrapperFunctions(objPojo);
	}

	public void validateStatusCode(Response response, String StatusCode) {
		int actStatusCode = Integer.parseInt(StatusCode); 
		if(response.statusCode() == actStatusCode)
			objWrapperFunctions.logReporter("Status Code: ",actStatusCode, true);
		else
			objWrapperFunctions.logReporter("Status Code: ",actStatusCode, false);
	}
	
	public void validateSuccessmessage(boolean successMessage) {	 
		if(successMessage == true)
			objWrapperFunctions.logReporter("Succeeded", successMessage);
		else
			objWrapperFunctions.logReporter("Failed",successMessage);

	}

	public void validateFailedmessage(boolean Failed) {
		if(Failed == false)
			objWrapperFunctions.logReporterFalseScenario("Succeeded", Failed);
		else
			objWrapperFunctions.logReporterFalseScenario("Failed",Failed);

		
	}
	
	
}
