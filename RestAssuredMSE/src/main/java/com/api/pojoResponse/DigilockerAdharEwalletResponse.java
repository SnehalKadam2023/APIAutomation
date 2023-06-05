package com.api.pojoResponse;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class DigilockerAdharEwalletResponse {
	private boolean success;
	private String status;
	private String message;
	Result ResultObject;
	private String user;


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

	public Result getResult() {
		return ResultObject;
	}

	public String getUser() {
		return user;
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

	public void setResult(Result resultObject) {
		this.ResultObject = resultObject;
	}

	public void setUser(String user) {
		this.user = user;
	}

}
