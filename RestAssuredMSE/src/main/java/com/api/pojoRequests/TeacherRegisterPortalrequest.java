package com.api.pojoRequests;


import com.fasterxml.jackson.annotation.JsonProperty;

public class TeacherRegisterPortalrequest {

	private String digiacc;
	@JsonProperty("userdata")
	UserDataTeacher userdata;
	@JsonProperty("digimpid")
	private String digimpid;

	public String getDigiacc() {
		return digiacc;
	}
	public void setDigiacc(String digiacc) {
		this.digiacc = digiacc;
	}
	public UserDataTeacher getUserdata() {
		return userdata;
	}
	public void setUserdata(UserDataTeacher userdata) {
		this.userdata = userdata;
	}
	public String getDigimpid() {
		return digimpid;
	}
	public void setDigimpid(String digimpid) {
		this.digimpid = digimpid;
	}




}
