package com.api.pojoResponse;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ResponseSchoolList {

	private boolean status;
	private String errorDetails;
	private String message;
	
	@JsonProperty("data")
	DataSchool data;

	public DataSchool getDataSchool() {
		return data;
	}

	public void setDataSchool(DataSchool dataSchool) {
		this.data = dataSchool;
	}


	// Getter Methods 

	public boolean getStatus() {
		return status;
	}

	public String getErrorDetails() {
		return errorDetails;
	}

	public String getMessage() {
		return message;
	}

	// Setter Methods 

	public void setStatus(boolean status) {
		this.status = status;
	}

	public void setErrorDetails(String errorDetails) {
		this.errorDetails = errorDetails;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
