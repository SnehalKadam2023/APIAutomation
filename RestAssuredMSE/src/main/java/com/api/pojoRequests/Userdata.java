package com.api.pojoRequests;

import java.util.ArrayList;

import com.api.pojoResponse.Detail;
import com.api.pojoResponse.UserData;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Userdata {
	@JsonProperty("student")
	ArrayList<UserData> student;
	@JsonProperty("studentdetail")
	Detail studentdetail;
	
	
	public ArrayList<UserData> getStudent() {
		return student;
	}
	public void setStudent(ArrayList<UserData> student) {
		this.student = student;
	}
	public Detail getStudentdetail() {
		return studentdetail;
	}
	public void setStudentdetail(Detail strStudentDetail) {
		this.studentdetail = strStudentDetail;
	}


}
