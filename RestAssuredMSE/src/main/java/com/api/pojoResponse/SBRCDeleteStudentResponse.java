package com.api.pojoResponse;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SBRCDeleteStudentResponse {
	private boolean success;
	private String status;
	private String message;
	@JsonProperty("result")
	digilockerRegisterResponse result;
	
	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public digilockerRegisterResponse getResult() {
		return result;
	}
	public void setResult(digilockerRegisterResponse result) {
		this.result = result;
	}
}
