package com.api.pojoResponse;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class DigilockerStateListResponse {

	private boolean status;
	Response ResponseObject;


	// Getter Methods 

	public boolean getStatus() {
		return status;
	}

	public Response getResponse() {
		return ResponseObject;
	}

	// Setter Methods 

	public void setStatus(boolean status) {
		this.status = status;
	}

	public void setResponse(Response responseObject) {
		this.ResponseObject = responseObject;
	}
}
