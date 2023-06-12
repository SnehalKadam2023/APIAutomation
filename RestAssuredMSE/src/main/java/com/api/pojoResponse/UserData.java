package com.api.pojoResponse;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class UserData {

	private String student_id;
	@JsonProperty("DID")
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
	 
	 
	public String getStudent_id() {
		return student_id;
	}
	public void setStudent_id(String student_id) {
		this.student_id = student_id;
	}
	public String getDID() {
		return DID;
	}
	public void setDID(String DID) {
		this.DID = DID;
	}
	public String getReference_id() {
		return reference_id;
	}
	public void setReference_id(String reference_id) {
		this.reference_id = reference_id;
	}
	public String getAadhar_token() {
		return aadhar_token;
	}
	public void setAadhar_token(String aadhar_token) {
		this.aadhar_token = aadhar_token;
	}
	public String getStudent_name() {
		return student_name;
	}
	public void setStudent_name(String student_name) {
		this.student_name = student_name;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public String getSchool_type() {
		return school_type;
	}
	public void setSchool_type(String school_type) {
		this.school_type = school_type;
	}
	public String getMeripehchan_id() {
		return meripehchan_id;
	}
	public void setMeripehchan_id(String meripehchan_id) {
		this.meripehchan_id = meripehchan_id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getSchool_udise() {
		return school_udise;
	}
	public void setSchool_udise(String school_udise) {
		this.school_udise = school_udise;
	}
	public String getSchool_name() {
		return school_name;
	}
	public void setSchool_name(String school_name) {
		this.school_name = school_name;
	}
	public String getStateCode() {
		return stateCode;
	}
	public void setStateCode(String stateCode) {
		this.stateCode = stateCode;
	}
	public String getStateName() {
		return stateName;
	}
	public void setStateName(String stateName) {
		this.stateName = stateName;
	}
	public String getDistrictCode() {
		return districtCode;
	}
	public void setDistrictCode(String districtCode) {
		this.districtCode = districtCode;
	}
	public String getDistrictName() {
		return districtName;
	}
	public void setDistrictName(String districtName) {
		this.districtName = districtName;
	}
	public String getBlockCode() {
		return blockCode;
	}
	public void setBlockCode(String blockCode) {
		this.blockCode = blockCode;
	}
	public String getBlockName() {
		return blockName;
	}
	public void setBlockName(String blockName) {
		this.blockName = blockName;
	}
	public String getAadhaar_status() {
		return aadhaar_status;
	}
	public void setAadhaar_status(String aadhaar_status) {
		this.aadhaar_status = aadhaar_status;
	}
	public String getAadhaar_enc() {
		return aadhaar_enc;
	}
	public void setAadhaar_enc(String aadhaar_enc) {
		this.aadhaar_enc = aadhaar_enc;
	}
	public String getOsCreatedAt() {
		return osCreatedAt;
	}
	public void setOsCreatedAt(String osCreatedAt) {
		this.osCreatedAt = osCreatedAt;
	}
	public String getOsUpdatedAt() {
		return osUpdatedAt;
	}
	public void setOsUpdatedAt(String osUpdatedAt) {
		this.osUpdatedAt = osUpdatedAt;
	}
	public String getOsCreatedBy() {
		return osCreatedBy;
	}
	public void setOsCreatedBy(String osCreatedBy) {
		this.osCreatedBy = osCreatedBy;
	}
	public String getOsUpdatedBy() {
		return osUpdatedBy;
	}
	public void setOsUpdatedBy(String osUpdatedBy) {
		this.osUpdatedBy = osUpdatedBy;
	}
	public String getOsid() {
		return osid;
	}
	public void setOsid(String osid) {
		this.osid = osid;
	}
}

