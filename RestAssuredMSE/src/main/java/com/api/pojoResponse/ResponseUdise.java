package com.api.pojoResponse;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ResponseUdise {
	 private boolean status;
	 @JsonProperty("data")
	 DataUdise data;
	 private String errorDetails;
	 private String message;


	 // Getter Methods 

	 public boolean getStatus() {
	  return status;
	 }

	 public DataUdise getData() {
	  return data;
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

	 public void setData(DataUdise data) {
	  this.data = data;
	 }

	 public void setErrorDetails(String errorDetails) {
	  this.errorDetails = errorDetails;
	 }

	 public void setMessage(String message) {
	  this.message = message;
	 }
	}


