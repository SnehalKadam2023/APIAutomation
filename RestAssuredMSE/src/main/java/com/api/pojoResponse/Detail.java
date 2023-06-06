package com.api.pojoResponse;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Detail {
	private String student_detail_id;
	private String student_id;
	private String gaurdian_name;
//	private String school_udise;
//	private String school_name;
	private String grade;
	private String acdemic_year;
	private String start_date;
	private String end_date;
	private String claim_status;
	private String osCreatedAt;
	private String osUpdatedAt;
	private String osCreatedBy;
	private String osUpdatedBy;
	private String osid;
	@JsonProperty("@type")
	private String type;


	// Getter Methods 

	public String getStudent_detail_id() {
		return student_detail_id;
	}

	public String getStudent_id() {
		return student_id;
	}

	public String getGaurdian_name() {
		return gaurdian_name;
	}

//	public String getSchool_udise() {
//		return school_udise;
//	}
//
//	public String getSchool_name() {
//		return school_name;
//	}

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

	public String getType() {
		return type;
	}
	// Setter Methods 
	public void setType(String type) {
		this.type = type;
	}

	public void setStudent_detail_id(String student_detail_id) {
		this.student_detail_id = student_detail_id;
	}

	public void setStudent_id(String student_id) {
		this.student_id = student_id;
	}

	public void setGaurdian_name(String gaurdian_name) {
		this.gaurdian_name = gaurdian_name;
	}

//	public void setSchool_udise(String school_udise) {
//		this.school_udise = school_udise;
//	}
//
//	public void setSchool_name(String school_name) {
//		this.school_name = school_name;
//	}

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
