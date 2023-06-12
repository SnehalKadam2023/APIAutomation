package com.api.pojoResponse;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class DigilockerGetStudentDataResponse {
	private boolean success;
	private String status;
	private String message;
	@JsonProperty("result")
	ResultStudentData result;
	@JsonProperty("detail")
	Detail detail;


	// Getter Methods 

	public ResultStudentData getResult() {
		return result;
	}

	public void setResult(ResultStudentData result) {
		this.result = result;
	}

	public Detail getDetail() {
		return detail;
	}

	public void setDetail(Detail detail) {
		this.detail = detail;
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
