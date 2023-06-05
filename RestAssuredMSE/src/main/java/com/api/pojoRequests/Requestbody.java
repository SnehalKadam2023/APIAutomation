package com.api.pojoRequests;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Requestbody {
	@JsonProperty("udiseCode")
	private String udiseCode;


	// Getter Methods 

	public String getUdiseCode() {
		return udiseCode;
	}

	// Setter Methods 

	public void setUdiseCode(String udiseCode) {
		this.udiseCode = udiseCode;
	}
}

