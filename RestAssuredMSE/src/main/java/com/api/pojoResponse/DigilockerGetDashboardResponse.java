package com.api.pojoResponse;

public class DigilockerGetDashboardResponse {
	private boolean success;
	private String status;
	private String message;
	Result ResultObject;
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
}
