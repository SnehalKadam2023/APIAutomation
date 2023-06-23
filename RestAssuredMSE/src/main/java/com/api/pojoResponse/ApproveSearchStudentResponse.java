package com.api.pojoResponse;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ApproveSearchStudentResponse {

	private String student_id;
	private String DID;
	private String reference_id;
	private String aadhar_token;
	private String student_name;
	private String dob;
	private String school_type;
	private String meripehchan_id;
	private String username;
	private String gender;
	private String school_udise;
	private String school_name;
	private String stateCode;
	private String stateName;
	private String districtCode;
	private String districtName;
	private String blockCode;
	private String blockName;
	private String aadhaar_status;
	private String aadhaar_enc;
	private String osCreatedAt;
	private String osUpdatedAt;
	private String osCreatedBy;
	private String osUpdatedBy;
	private String osid;


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

	public String getGender() {
		return gender;
	}

	public String getSchool_udise() {
		return school_udise;
	}

	public String getSchool_name() {
		return school_name;
	}

	public String getStateCode() {
		return stateCode;
	}

	public String getStateName() {
		return stateName;
	}

	public String getDistrictCode() {
		return districtCode;
	}

	public String getDistrictName() {
		return districtName;
	}

	public String getBlockCode() {
		return blockCode;
	}

	public String getBlockName() {
		return blockName;
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

	public void setGender(String gender) {
		this.gender = gender;
	}

	public void setSchool_udise(String school_udise) {
		this.school_udise = school_udise;
	}

	public void setSchool_name(String school_name) {
		this.school_name = school_name;
	}

	public void setStateCode(String stateCode) {
		this.stateCode = stateCode;
	}

	public void setStateName(String stateName) {
		this.stateName = stateName;
	}

	public void setDistrictCode(String districtCode) {
		this.districtCode = districtCode;
	}

	public void setDistrictName(String districtName) {
		this.districtName = districtName;
	}

	public void setBlockCode(String blockCode) {
		this.blockCode = blockCode;
	}

	public void setBlockName(String blockName) {
		this.blockName = blockName;
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

}
