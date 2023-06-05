package com.api.pojoRequests;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class digilockerAdharRequest {
	private String digiacc;
	private String aadhaar_id;
	private String aadhaar_name;
	private String aadhaar_gender;
	private String aadhaar_dob;
	private String digilocker_id;


	// Getter Methods 

	public String getDigiacc() {
		return digiacc;
	}

	public String getAadhaar_id() {
		return aadhaar_id;
	}

	public String getAadhaar_name() {
		return aadhaar_name;
	}

	public String getAadhaar_gender() {
		return aadhaar_gender;
	}

	public String getAadhaar_dob() {
		return aadhaar_dob;
	}

	public String getDigilocker_id() {
		return digilocker_id;
	}

	// Setter Methods 

	public void setDigiacc(String digiacc) {
		this.digiacc = digiacc;
	}

	public void setAadhaar_id(String aadhaar_id) {
		this.aadhaar_id = aadhaar_id;
	}

	public void setAadhaar_name(String aadhaar_name) {
		this.aadhaar_name = aadhaar_name;
	}

	public void setAadhaar_gender(String aadhaar_gender) {
		this.aadhaar_gender = aadhaar_gender;
	}

	public void setAadhaar_dob(String aadhaar_dob) {
		this.aadhaar_dob = aadhaar_dob;
	}

	public void setDigilocker_id(String digilocker_id) {
		this.digilocker_id = digilocker_id;
	}

}
