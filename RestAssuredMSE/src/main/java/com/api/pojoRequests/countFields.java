package com.api.pojoRequests;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class countFields {
	@JsonProperty("countFields")
	ArrayList<String> countFields = new ArrayList<String>();

	public ArrayList<String> getCountFields() {
		return countFields;
	}

	public void setCountFields(ArrayList<String> countFields) {
		this.countFields = countFields;
	}

	

}
