package com.api.pojoRequests;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class DigiLockerLogoutRequest {

	private String access_token;
	private String digiacc;

	public String getAccess_token() {
		return access_token;
	}

	public void setAccess_token(String access_token) {
		this.access_token = access_token;
	}

	// Getter Methods 

	public String getDigiacc() {
		return digiacc;
	}
	public void setDigiacc(String digiacc) {
		this.digiacc = digiacc;
	}

}
