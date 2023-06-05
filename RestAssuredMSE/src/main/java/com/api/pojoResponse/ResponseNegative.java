package com.api.pojoResponse;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ResponseNegative {
	private boolean status;
	private String data;
	@JsonProperty("errorDetails")
	ErrorDetails errorDetails;
	private String message;


	// Getter Methods 

	public boolean getStatus() {
		return status;
	}

	public String getData() {
		return data;
	}
	
	public String getMessage() {
		return message;
	}

	// Setter Methods 

	public void setStatus(boolean status) {
		this.status = status;
	}

	public ErrorDetails getErrorDetails() {
		return errorDetails;
	}

	public void setErrorDetails(ErrorDetails errorDetails) {
		this.errorDetails = errorDetails;
	}

	public void setData(String data) {
		this.data = data;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
