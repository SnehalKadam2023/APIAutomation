package com.api.pojoResponse;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ResultBFFSchema {
	private String credential_schema;


	// Getter Methods 

	public String getCredential_schema() {
		return credential_schema;
	}

	// Setter Methods 

	public void setCredential_schema(String credential_schema) {
		this.credential_schema = credential_schema;
	}

}
