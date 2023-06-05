package com.api.pojoRequests;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class digilockerRegisterEwalletRequest {
	
	private String digiacc;
	@JsonProperty("userdata")
	Userdata userdata;
	private String digimpid;


	// Getter Methods 

	public String getDigiacc() {
		return digiacc;
	}

	public Userdata getUserdata() {
		return userdata;
	}

	public String getDigimpid() {
		return digimpid;
	}

	// Setter Methods 

	public void setDigiacc(String digiacc) {
		this.digiacc = digiacc;
	}

	public void setUserdata(Userdata userdata) {
		this.userdata = userdata;
	}

	public void setDigimpid(String digimpid) {
		this.digimpid = digimpid;
	}

}
