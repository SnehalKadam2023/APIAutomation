package com.api.pojoResponse;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ApprovalCredentialSubject {

	@JsonProperty("id")
	private String id;

	@JsonProperty("dob")
	private String dob;

	@JsonProperty("grade")
	private String grade;

	@JsonProperty("mobile")
	private String mobile;

	@JsonProperty("school_id")
	private String school_id;

	@JsonProperty("student_id")
	private String student_id;

	@JsonProperty("enrolled_on")
	private String enrolled_on;

	@JsonProperty("school_name")
	private String school_name;

	@JsonProperty("aadhar_token")
	private String aadhar_token;

	@JsonProperty("reference_id")
	private String reference_id;

	@JsonProperty("student_name")
	private String student_name;

	@JsonProperty("academic_year")
	private String academic_year;

	@JsonProperty("guardian_name")
	private String guardian_name;

	// Getter Methods

	public String getId() {
		return id;
	}

	public String getDob() {
		return dob;
	}

	public String getGrade() {
		return grade;
	}

	public String getMobile() {
		return mobile;
	}

	public String getSchool_id() {
		return school_id;
	}

	public String getStudent_id() {
		return student_id;
	}

	public String getSchool_name() {
		return school_name;
	}

	public String getAadhar_token() {
		return aadhar_token;
	}

	public String getReference_id() {
		return reference_id;
	}

	public String getStudent_name() {
		return student_name;
	}

	public String getAcademic_year() {
		return academic_year;
	}

	public String getGuardian_name() {
		return guardian_name;
	}

	public String getEnrolled_on() {
		return enrolled_on;
	}

	// Setter Methods

	public void setId(String id) {
		this.id = id;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public void setSchool_id(String school_id) {
		this.school_id = school_id;
	}

	public void setStudent_id(String student_id) {
		this.student_id = student_id;
	}

	public void setSchool_name(String school_name) {
		this.school_name = school_name;
	}

	public void setAadhar_token(String aadhar_token) {
		this.aadhar_token = aadhar_token;
	}

	public void setReference_id(String reference_id) {
		this.reference_id = reference_id;
	}

	public void setStudent_name(String student_name) {
		this.student_name = student_name;
	}

	public void setAcademic_year(String academic_year) {
		this.academic_year = academic_year;
	}

	public void setGuardian_name(String guardian_name) {
		this.guardian_name = guardian_name;
	}

	public void setEnrolled_on(String enrolled_on) {
		this.enrolled_on = enrolled_on;
	}
}