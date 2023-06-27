package com.api.pojoResponse;

import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ResultCredentials {
	
	private String status;
	List <ChecksResponse> checks;
	
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public List<ChecksResponse> getChecks() {
		return checks;
	}
	public void setChecks(List<ChecksResponse> checks) {
		this.checks = checks;
	}
	
	
	
}
