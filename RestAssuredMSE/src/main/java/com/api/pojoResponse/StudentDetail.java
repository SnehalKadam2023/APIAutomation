package com.api.pojoResponse;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class StudentDetail {
	private String osid;

	// Getter Methods 

	public String getOsid() {
		return osid;
	}

	// Setter Methods 

	public void setOsid(String osid) {
		this.osid = osid;
	}
}
