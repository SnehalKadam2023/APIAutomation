package com.api.pojoResponse;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class digilockerRegisterResponse {

	private String id;
	private String ver;
	private float ets;
	Params params;
	private String responseCode;
	ResultRegisterEwallet result;


	// Getter Methods 

	public Params getParams() {
		return params;
	}

	public void setParams(Params params) {
		this.params = params;
	}

	public ResultRegisterEwallet getResult() {
		return result;
	}

	public void setResult(ResultRegisterEwallet result) {
		this.result = result;
	}

	public String getId() {
		return id;
	}

	public String getVer() {
		return ver;
	}

	public float getEts() {
		return ets;
	}

	public String getResponseCode() {
		return responseCode;
	}
	// Setter Methods 

	public void setId(String id) {
		this.id = id;
	}

	public void setVer(String ver) {
		this.ver = ver;
	}

	public void setEts(float ets) {
		this.ets = ets;
	}

	public void setResponseCode(String responseCode) {
		this.responseCode = responseCode;
	}
}
