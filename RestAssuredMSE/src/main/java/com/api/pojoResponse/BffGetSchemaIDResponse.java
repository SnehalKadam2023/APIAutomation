package com.api.pojoResponse;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class BffGetSchemaIDResponse {
	private boolean success;
	private String status;
	private String message;
	@JsonProperty("result")
	ResultBFFSchema result;


	// Getter Methods 

	public ResultBFFSchema getResult() {
		return result;
	}

	public void setResult(ResultBFFSchema result) {
		this.result = result;
	}

	public boolean getSuccess() {
		return success;
	}

	public String getStatus() {
		return status;
	}

	public String getMessage() {
		return message;
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
}



