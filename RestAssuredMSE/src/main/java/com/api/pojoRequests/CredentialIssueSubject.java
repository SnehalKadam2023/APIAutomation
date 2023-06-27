package com.api.pojoRequests;

public class CredentialIssueSubject {
	private String guardian_name;
	private String student_id;
	private String student_name;
	private String dob;
	private String aadhar_token;
	private String reference_id;
	private String enrolled_on;

	public String getGuardian_name() {
		return guardian_name;
	}

	public void setGuardian_name(String guardian_name) {
		this.guardian_name = guardian_name;
	}

	public String getStudent_id() {
		return student_id;
	}

	public void setStudent_id(String student_id) {
		this.student_id = student_id;
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

	public String getAadhar_token() {
		return aadhar_token;
	}

	public void setAadhar_token(String aadhar_token) {
		this.aadhar_token = aadhar_token;
	}

	public String getReference_id() {
		return reference_id;
	}

	public void setReference_id(String reference_id) {
		this.reference_id = reference_id;
	}

	public String getEnrolled_on() {
		return enrolled_on;
	}

	public void setEnrolled_on(String enrolled_on) {
		this.enrolled_on = enrolled_on;
	}

}
