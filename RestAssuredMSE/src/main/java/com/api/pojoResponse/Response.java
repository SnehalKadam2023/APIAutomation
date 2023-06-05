package com.api.pojoResponse;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Response {

	private boolean status;
	ArrayList < Data > data = new ArrayList < Data > ();
	private String errorDetails;
	private String message;

	// Getter Methods 

	public boolean getStatus() {
		return status;
	}

	public String getErrorDetails() {
		return errorDetails;
	}

	public String getMessage() {
		return message;
	}

	// Setter Methods 

	public void setStatus(boolean status) {
		this.status = status;
	}

	public void setErrorDetails(String errorDetails) {
		this.errorDetails = errorDetails;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public ArrayList<Data> getData() {
		return data;
	}

	public void setData(ArrayList<Data> data) {
		this.data = data;
	}

}
