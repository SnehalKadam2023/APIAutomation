package com.api.pojoResponse;


import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CredentialsSearchAllResponse {
	private boolean success;
	private String status;
	private String message;
	@JsonProperty("result")
   ArrayList <ResultCredentialsSearchAll> result;


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


	public ArrayList<ResultCredentialsSearchAll> getResult() {
		return result;
	}


	public void setResult(ArrayList<ResultCredentialsSearchAll> result) {
		this.result = result;
	}






}
