package com.api.pojoResponse;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ResultCredentialissueResponse {
	private boolean success;;
	private String error;
	@JsonProperty("studentDetails")
	StudentDetailCredentialIssueReponse studentDetails;

	// Getter Methods
	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public StudentDetailCredentialIssueReponse getStudentDetails() {
		return studentDetails;
	}

	public void setStudentDetails(StudentDetailCredentialIssueReponse studentDetails) {
		this.studentDetails = studentDetails;
	}

}
