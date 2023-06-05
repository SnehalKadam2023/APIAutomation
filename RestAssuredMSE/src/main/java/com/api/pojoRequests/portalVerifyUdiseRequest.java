package com.api.pojoRequests;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class portalVerifyUdiseRequest {
	
	private String password;
	@JsonProperty("requestbody")
	Requestbody requestbody;

	// Getter Methods 

	public String getPassword() {
		return password;
	}

	public Requestbody getRequestbody() {
		return requestbody;
	}

	// Setter Methods 

	public void setPassword(String password) {
		this.password = password;
	}

	public void setRequestbody(Requestbody requestbody) {
		this.requestbody = requestbody;
	}
}
