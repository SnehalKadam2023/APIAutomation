package com.api.pojoResponse;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Academic_year {
	@JsonProperty("type")
	private String type;
	@JsonProperty("description")
	private String description;

	// Getter Methods 

	public String getType() {
		return type;
	}

	public String getDescription() {
		return description;
	}

	// Setter Methods 

	public void setType(String type) {
		this.type = type;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
