package com.api.pojoResponse;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class URLpage {
	private String digiauthurl;

	public String getDigiauthurl() {
		return digiauthurl;
	}

	public void setDigiauthurl(String digiauthurl) {
		this.digiauthurl = digiauthurl;
	}
}
