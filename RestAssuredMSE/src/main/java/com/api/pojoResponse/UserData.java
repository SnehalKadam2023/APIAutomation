package com.api.pojoResponse;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class UserData {

	private String student_id;
	public String DID;
	private String reference_id;
	private String aadhar_token;
	private String student_name;
	private String dob;
	private String school_type;
	private String meripehchan_id;
	private String username;
	private String aadhaar_status;
	private String aadhaar_enc;
	private String osCreatedAt;
	private String osUpdatedAt;
	private String osCreatedBy;
	private String osUpdatedBy;
	private String osid;
	private String type;


	// Getter Methods 

	public String getStudent_id() {
		return student_id;
	}

	public String getDID() {
		return DID;
	}

	public String getReference_id() {
		return reference_id;
	}

	public String getAadhar_token() {
		return aadhar_token;
	}

	public String getStudent_name() {
		return student_name;
	}

	public String getDob() {
		return dob;
	}

	public String getSchool_type() {
		return school_type;
	}

	public String getMeripehchan_id() {
		return meripehchan_id;
	}

	public String getUsername() {
		return username;
	}

	public String getAadhaar_status() {
		return aadhaar_status;
	}

	public String getAadhaar_enc() {
		return aadhaar_enc;
	}

	public String getOsCreatedAt() {
		return osCreatedAt;
	}

	public String getOsUpdatedAt() {
		return osUpdatedAt;
	}

	public String getOsCreatedBy() {
		return osCreatedBy;
	}

	public String getOsUpdatedBy() {
		return osUpdatedBy;
	}

	public String getOsid() {
		return osid;
	}

	// Setter Methods 

	public void setStudent_id(String student_id) {
		this.student_id = student_id;
	}

	public void setDID(String DID) {
		this.DID = DID;
	}

	public void setReference_id(String reference_id) {
		this.reference_id = reference_id;
	}

	public void setAadhar_token(String aadhar_token) {
		this.aadhar_token = aadhar_token;
	}

	public void setStudent_name(String student_name) {
		this.student_name = student_name;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public void setSchool_type(String school_type) {
		this.school_type = school_type;
	}

	public void setMeripehchan_id(String meripehchan_id) {
		this.meripehchan_id = meripehchan_id;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setAadhaar_status(String aadhaar_status) {
		this.aadhaar_status = aadhaar_status;
	}

	public void setAadhaar_enc(String aadhaar_enc) {
		this.aadhaar_enc = aadhaar_enc;
	}

	public void setOsCreatedAt(String osCreatedAt) {
		this.osCreatedAt = osCreatedAt;
	}

	public void setOsUpdatedAt(String osUpdatedAt) {
		this.osUpdatedAt = osUpdatedAt;
	}

	public void setOsCreatedBy(String osCreatedBy) {
		this.osCreatedBy = osCreatedBy;
	}

	public void setOsUpdatedBy(String osUpdatedBy) {
		this.osUpdatedBy = osUpdatedBy;
	}

	public void setOsid(String osid) {
		this.osid = osid;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

}

