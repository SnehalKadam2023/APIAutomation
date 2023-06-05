package com.api.pojoRequests;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Userdata {
	@JsonProperty("student")
	Student student;
	@JsonProperty("studentdetail")
	Studentdetail studentdetail;
	
	
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	public Studentdetail getStudentdetail() {
		return studentdetail;
	}
	public void setStudentdetail(Studentdetail studentdetail) {
		this.studentdetail = studentdetail;
	}


}
