package com.api.pojoResponse;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class GetCredentialsVerifyResponse {
	private boolean success;
	private String status;
	private String message;
	@JsonProperty("result")
	List < ResultCredentials > result;


	// Getter Methods 


	public boolean getSuccess() {
		return success;
	}

	public List<ResultCredentials> getResult() {
		return result;
	}

	public void setResult(List<ResultCredentials> result) {
		this.result = result;
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
