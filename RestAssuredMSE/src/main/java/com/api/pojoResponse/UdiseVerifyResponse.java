package com.api.pojoResponse;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
@JsonIgnoreProperties(ignoreUnknown = true)
public class UdiseVerifyResponse {
	
	private boolean status;
	@JsonProperty("response")
	ResponseUdise response;


	// Getter Methods 

	public boolean getStatus() {
		return status;
	}

	public ResponseUdise getResponse() {
		return response;
	}

	// Setter Methods 

	public void setStatus(boolean status) {
		this.status = status;
	}

	public void setResponse(ResponseUdise response) {
		this.response = response;
	}

}
