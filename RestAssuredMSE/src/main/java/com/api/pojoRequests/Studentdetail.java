package com.api.pojoRequests;

public class Studentdetail {
	private String student_detail_id;
	private String student_id;
	private String mobile;
	private String gaurdian_name;
	private String grade;
	private String acdemic_year;
	private String start_date;
	private String end_date;
	private String claim_status;
	private String enrollon;


	// Getter Methods 

	public String getStudent_detail_id() {
		return student_detail_id;
	}

	public String getStudent_id() {
		return student_id;
	}

	public String getMobile() {
		return mobile;
	}

	public String getGaurdian_name() {
		return gaurdian_name;
	}

	public String getGrade() {
		return grade;
	}

	public String getAcdemic_year() {
		return acdemic_year;
	}

	public String getStart_date() {
		return start_date;
	}

	public String getEnd_date() {
		return end_date;
	}

	public String getClaim_status() {
		return claim_status;
	}

	public String getEnrollon() {
		return enrollon;
	}

	// Setter Methods 

	public void setStudent_detail_id(String student_detail_id) {
		this.student_detail_id = student_detail_id;
	}

	public void setStudent_id(String student_id) {
		this.student_id = student_id;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public void setGaurdian_name(String gaurdian_name) {
		this.gaurdian_name = gaurdian_name;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public void setAcdemic_year(String acdemic_year) {
		this.acdemic_year = acdemic_year;
	}

	public void setStart_date(String start_date) {
		this.start_date = start_date;
	}

	public void setEnd_date(String end_date) {
		this.end_date = end_date;
	}

	public void setClaim_status(String claim_status) {
		this.claim_status = claim_status;
	}

	public void setEnrollon(String enrollon) {
		this.enrollon = enrollon;
	}
}
