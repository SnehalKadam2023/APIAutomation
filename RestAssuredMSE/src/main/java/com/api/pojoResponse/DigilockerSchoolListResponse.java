package com.api.pojoResponse;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class DigilockerSchoolListResponse {


	private boolean status;
	ResponseSchoolList response;


	// Getter Methods 

	public boolean getStatus() {
		return status;
	}

	// Setter Methods 

	public void setStatus(boolean status) {
		this.status = status;
	}

	public ResponseSchoolList getResponse() {
		return response;
	}

	public void setResponse(ResponseSchoolList response) {
		this.response = response;
	}
}

