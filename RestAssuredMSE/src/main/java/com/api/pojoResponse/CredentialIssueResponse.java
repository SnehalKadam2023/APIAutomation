package com.api.pojoResponse;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CredentialIssueResponse {
	private boolean success;
	private String status;
	private boolean iserror;
	private String message;
	private int error_count;
	private int success_count;
	@JsonProperty("result")
	ResultCredentialissueResponse result;

	public ResultCredentialissueResponse getResult() {
		return result;
	}

	public void setResult(ResultCredentialissueResponse result) {
		this.result = result;
	}

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

	public boolean isIserror() {
		return iserror;
	}

	public void setIserror(boolean iserror) {
		this.iserror = iserror;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public int getError_count() {
		return error_count;
	}

	public void setError_count(int error_count) {
		this.error_count = error_count;
	}

	public int getSuccess_count() {
		return success_count;
	}

	public void setSuccess_count(int success_count) {
		this.success_count = success_count;
	}

	// Getter Methods

}
