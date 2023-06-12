package com.api.pojoRequests;

import com.api.pojoResponse.Detail;
import com.api.pojoResponse.UserData;
import com.fasterxml.jackson.annotation.JsonProperty;

public class UserdataRegister {
	@JsonProperty("student")
	Student student;
	@JsonProperty("studentdetail")
	Studentdetail studentdetail;
	
	
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student studentObj) {
		this.student = studentObj;
	}
	public Studentdetail getStudentdetail() {
		return studentdetail;
	}
	public void setStudentdetail(Studentdetail strStudentDetail) {
		this.studentdetail = strStudentDetail;
	}


}
