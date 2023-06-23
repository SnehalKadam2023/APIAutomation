package com.api.pojoResponse;

import java.util.ArrayList;

import com.api.pojoRequests.UserDataTeacher;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
@JsonIgnoreProperties(ignoreUnknown = true)
public class DigiLockerPortalTeacherRegisterResponse {
	private boolean success;
	private String status;
	private String message;
	private String user;
	@JsonProperty("userData")
	UserDataTeacher userData;
	private String TokenTeacherRegister;
	
	
	public boolean getSuccess() {
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
	public UserDataTeacher getUserData() {
		return userData;
	}
	public void setUserData(UserDataTeacher userData) {
		this.userData = userData;
	}
	public String getTokenTeacherRegister() {
		return TokenTeacherRegister;
	}
	public void setTokenTeacherRegister(String tokenTeacherRegister) {
		TokenTeacherRegister = tokenTeacherRegister;
	}
	
	
	
	
	
}
