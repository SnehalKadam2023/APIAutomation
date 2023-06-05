package com.api.pojoResponse;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class DigilockerGetStudentDataResponse {
	private boolean success;
	private String status;
	private String message;
	ResultStudentData ResultObject;
	Detail DetailObject;


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

	public ResultStudentData getResult() {
		return ResultObject;
	}

	public Detail getDetail() {
		return DetailObject;
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

	public void setResult(ResultStudentData resultObject) {
		this.ResultObject = resultObject;
	}

	public void setDetail(Detail detailObject) {
		this.DetailObject = detailObject;
	}
}
