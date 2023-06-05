package com.api.pojoRequests;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Subject {
	@JsonProperty("id")
	private String id;

	// Getter Methods 

	public String getId() {
		return id;
	}

	// Setter Methods 

	public void setId(String id) {
		this.id = id;
	}


}
