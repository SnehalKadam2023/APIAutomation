package com.api.pojoResponse;

public class getTokenResponse {
	private boolean success;
	private String token;

	public boolean getSuccess() {
		return success;
	}

	public String getToken() {
		return token;
	}

	// Setter Methods 

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public void setToken(String token) {
		this.token = token;
	}

}
