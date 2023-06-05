package com.api.pojoResponse;
import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
@JsonIgnoreProperties(ignoreUnknown = true)

public class DigiLockerTokenEwalletResponse {
	private boolean success;
	private String status;
	private String message;
	Result ResultObject;
	Digi DigiObject;
	private String user;
	ArrayList<UserData> userData = new ArrayList<UserData>();
	Detail DetailObject;
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
	
	public ArrayList<UserData> getUserData() {
		return userData;
	}

	public void setUserData(ArrayList<UserData> userData) {
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
}
