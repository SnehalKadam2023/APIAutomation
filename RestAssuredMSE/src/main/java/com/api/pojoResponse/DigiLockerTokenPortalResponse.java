package com.api.pojoResponse;

import java.util.ArrayList;

import com.api.pojoRequests.UserDataTeacher;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
@JsonIgnoreProperties(ignoreUnknown = true)
public class DigiLockerTokenPortalResponse {
	private boolean success;
	private String status;
	private String message;
	@JsonProperty("result")
	Result result;
	@JsonProperty("digi")
	Digi digi;
	private String user;
	@JsonProperty("userData")
	UserDataTeacher userData;
	@JsonProperty("detail")
	Detail detail;
	private String needaadhaar;
	
	
	public String getNeedaadhaar() {
		return needaadhaar;
	}

	public void setNeedaadhaar(String needaadhaar) {
		this.needaadhaar = needaadhaar;
	}

	public Result getResult() {
		return result;
	}

	public void setResult(Result result) {
		this.result = result;
	}

	public Digi getDigi() {
		return digi;
	}

	public void setDigi(Digi digi) {
		this.digi = digi;
	}

	public Detail getDetail() {
		return detail;
	}

	public void setDetail(Detail detail) {
		this.detail = detail;
	}



	public UserDataTeacher getUserData() {
		return userData;
	}

	public void setUserData(UserDataTeacher userData) {
		this.userData = userData;
	}



	private String token;


	// Getter Methods 

	public boolean getSuccess() {
		return success;
	}

	public String getStatus() {
		return status;
	}

	public String getMessage() {
		return message;
	}


	public String getUser() {
		return user;
	}

	public String getToken() {
		return token;
	}
	

	// Setter Methods 

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public void setMessage(String message) {
		this.message = message;
	}


	public void setUser(String user) {
		this.user = user;
	}

	public void setToken(String token) {
		this.token = token;
	}

}
