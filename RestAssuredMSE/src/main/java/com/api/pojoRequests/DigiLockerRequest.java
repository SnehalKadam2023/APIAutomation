package com.api.pojoRequests;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class DigiLockerRequest {

	private String digiacc;
	private String auth_code;
	
	// Getter Methods 

	public String getDigiacc() {
		return digiacc;
	}

	public String getAuth_code() {
		return auth_code;
	}

	// Setter Methods 

	public void setDigiacc(String digiacc) {
		this.digiacc = digiacc;
	}

	public void setAuth_code(String auth_code) {
		this.auth_code = auth_code;
	}
}
