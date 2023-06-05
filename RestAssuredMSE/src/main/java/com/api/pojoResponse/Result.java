package com.api.pojoResponse;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Result {
	private String meripehchanid;
	private String name;
	private String mobile;
	private String dob;
	private String username;

	private String uuid;

	private float students_registered;
	private float claims_pending;
	private float claims_approved;
	private float claims_rejected;
	private float credentials_issued;


	// Getter Methods 

	public float getStudents_registered() {
		return students_registered;
	}

	public float getClaims_pending() {
		return claims_pending;
	}

	public float getClaims_approved() {
		return claims_approved;
	}

	public float getClaims_rejected() {
		return claims_rejected;
	}

	public float getCredentials_issued() {
		return credentials_issued;
	}

	// Setter Methods 

	public void setStudents_registered(float students_registered) {
		this.students_registered = students_registered;
	}

	public void setClaims_pending(float claims_pending) {
		this.claims_pending = claims_pending;
	}

	public void setClaims_approved(float claims_approved) {
		this.claims_approved = claims_approved;
	}

	public void setClaims_rejected(float claims_rejected) {
		this.claims_rejected = claims_rejected;
	}

	public void setCredentials_issued(float credentials_issued) {
		this.credentials_issued = credentials_issued;
	}

	// Getter Methods 

	public String getUuid() {
		return uuid;
	}

	// Setter Methods 

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}


	// Getter Methods 

	public String getMeripehchanid() {
		return meripehchanid;
	}

	public String getName() {
		return name;
	}

	public String getMobile() {
		return mobile;
	}

	public String getDob() {
		return dob;
	}

	public String getUsername() {
		return username;
	}

	// Setter Methods 

	public void setMeripehchanid(String meripehchanid) {
		this.meripehchanid = meripehchanid;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public void setUsername(String username) {
		this.username = username;
	}
}
