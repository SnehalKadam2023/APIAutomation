package com.api.pojoResponse;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
@JsonIgnoreProperties(ignoreUnknown = true)
public class Properties {
	@JsonProperty("grade")
	Grade grade;
	@JsonProperty("school_id")
	School_id school_id;
	@JsonProperty("schoolName")
	SchoolName schoolName;
	@JsonProperty("student_id")
	Student_id student_id;
	@JsonProperty("aadhar_token")
	Aadhar_token aadhar_token;
	@JsonProperty("enrolled_on")
	Enrolled_on enrolled_on;
	@JsonProperty("student_name")
	Student_name student_name;
	@JsonProperty("guardian_name")
	Guardian_name guardian_name;
	@JsonProperty("academic_year")
	Academic_year academic_year ;


	public Grade getGrade() {
		return grade;
	}
	public void setGrade(Grade grade) {
		this.grade = grade;
	}
	public School_id getSchool_id() {
		return school_id;
	}
	public void setSchool_id(School_id school_id) {
		this.school_id = school_id;
	}
	public SchoolName getSchoolName() {
		return schoolName;
	}
	public void setSchoolName(SchoolName schoolName) {
		this.schoolName = schoolName;
	}
	public Student_id getStudent_id() {
		return student_id;
	}
	public void setStudent_id(Student_id student_id) {
		this.student_id = student_id;
	}
	public Aadhar_token getAadhar_token() {
		return aadhar_token;
	}
	public void setAadhar_token(Aadhar_token aadhar_token) {
		this.aadhar_token = aadhar_token;
	}
	public Enrolled_on getEnrolled_on() {
		return enrolled_on;
	}
	public void setEnrolled_on(Enrolled_on enrolled_on) {
		this.enrolled_on = enrolled_on;
	}
	public Student_name getStudent_name() {
		return student_name;
	}
	public void setStudent_name(Student_name student_name) {
		this.student_name = student_name;
	}
	public Guardian_name getGuardian_name() {
		return guardian_name;
	}
	public void setGuardian_name(Guardian_name guardian_name) {
		this.guardian_name = guardian_name;
	}
	public Academic_year getAcademic_year() {
		return academic_year;
	}
	public void setAcademic_year(Academic_year academic_year) {
		this.academic_year = academic_year;
	}

}
