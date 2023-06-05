package com.api.pojoResponse;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class negativeResponse {

	private boolean status;
	@JsonProperty("response")
	ResponseNegative response;


	// Getter Methods 

	public ResponseNegative getResponse() {
		return response;
	}


	public void setResponse(ResponseNegative response) {
		this.response = response;
	}


	public boolean getStatus() {
		return status;
	}

	
	// Setter Methods 

	public void setStatus(boolean status) {
		this.status = status;
	}

}
