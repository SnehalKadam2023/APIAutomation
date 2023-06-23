package com.api.pojoResponse;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SBRCTokenResposne {

	private boolean success;
	private String status;
	private String message;
	private String user;
	@JsonProperty("userData")
	ArrayList<SBRCTokenUserDataResponse> userData;
	SBRCTokenDetailResposne detail;
	private String token;

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public ArrayList<SBRCTokenUserDataResponse> getUserData() {
		return userData;
	}

	public void setUserData(ArrayList<SBRCTokenUserDataResponse> userData) {
		this.userData = userData;
	}

	public SBRCTokenDetailResposne getDetail() {
		return detail;
	}

	public void setDetail(SBRCTokenDetailResposne detail) {
		this.detail = detail;
	}

	public String getToken() {

		return token;
	}
	public void setToken(String token) {

		this.token = token;

	}

}
