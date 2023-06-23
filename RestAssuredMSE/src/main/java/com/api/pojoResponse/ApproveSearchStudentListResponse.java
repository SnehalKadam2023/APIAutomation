package com.api.pojoResponse;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ApproveSearchStudentListResponse {
	private boolean success;
	private String status;
	private String message;
	@JsonProperty("result")
	ArrayList<ResultStudentData> result;
	

	public boolean getSuccess() {
		return success;
	}

	public ArrayList<ResultStudentData> getResult() {
		return result;
	}

	public void setResult(ArrayList<ResultStudentData> result) {
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
