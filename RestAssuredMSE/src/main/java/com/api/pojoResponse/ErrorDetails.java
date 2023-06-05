package com.api.pojoResponse;

public class ErrorDetails {
	private String responseCode;
	private String type;
	private String message;


	// Getter Methods 

	public String getResponseCode() {
		return responseCode;
	}

	public String getType() {
		return type;
	}

	public String getMessage() {
		return message;
	}

	// Setter Methods 

	public void setResponseCode(String responseCode) {
		this.responseCode = responseCode;
	}

	public void setType(String type) {
		this.type = type;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
