package com.api.pojoResponse;
import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
@JsonIgnoreProperties(ignoreUnknown = true)

public class DigiLockerTokenEwalletResponse {
	private boolean success;
	private String status;
	private String message;
	Result ResultObject;
	Digi DigiObject;
	private String user;
	UserData userData;
	@JsonProperty("detail")
	Detail DetailObject;
	private String token;
	private String needaadhaar;


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

	public Result getResult() {
		return ResultObject;
	}

	public Digi getDigi() {
		return DigiObject;
	}

	public String getUser() {
		return user;
	}

	public Detail getDetail() {
		return DetailObject;
	}

	public String getToken() {
		return token;
	}
	
	public UserData getUserData() {
		return userData;
	}

	public void setUserData(UserData userData) {
		this.userData = userData;
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

	public void setResult(Result resultObject) {
		this.ResultObject = resultObject;
	}

	public void setDigi(Digi digiObject) {
		this.DigiObject = digiObject;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public void setDetail(Detail detailObject) {
		this.DetailObject = detailObject;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getNeedaadhaar() {
		return needaadhaar;
	}

	public void setNeedaadhaar(String needaadhaar) {
		this.needaadhaar = needaadhaar;
	}
}
