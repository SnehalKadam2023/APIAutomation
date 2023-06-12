package com.api.pojoResponse;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SchoolDetailsResponse {
	private boolean success;
	private String status;
	private String message;
	@JsonProperty("result")
	ResultSchoolDetails result;
	
	// Getter Methods 

	public boolean getSuccess() {
		return success;
	}

	public String getStatus() {
		return status;
	}

	public String getMessage() {
		return message;
	}

	public ResultSchoolDetails getResult() {
		return result;
	}

	// Setter Methods 

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public void setResult(ResultSchoolDetails result) {
		this.result = result;
	}
}
