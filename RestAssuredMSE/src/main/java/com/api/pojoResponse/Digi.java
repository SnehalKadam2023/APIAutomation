package com.api.pojoResponse;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Digi {
	private String access_token;
	private float expires_in;
	private String token_type;
	private String scope;
	private String id_token;


	// Getter Methods 

	public String getAccess_token() {
		return access_token;
	}

	public float getExpires_in() {
		return expires_in;
	}

	public String getToken_type() {
		return token_type;
	}

	public String getScope() {
		return scope;
	}

	public String getId_token() {
		return id_token;
	}

	// Setter Methods 

	public void setAccess_token(String access_token) {
		this.access_token = access_token;
	}

	public void setExpires_in(float expires_in) {
		this.expires_in = expires_in;
	}

	public void setToken_type(String token_type) {
		this.token_type = token_type;
	}

	public void setScope(String scope) {
		this.scope = scope;
	}

	public void setId_token(String id_token) {
		this.id_token = id_token;
	}
}

