package com.api.pojoRequests;

import java.util.ArrayList;

import com.api.pojoResponse.ResultSchoolData;
import com.api.pojoResponse.UserData;
import com.fasterxml.jackson.annotation.JsonProperty;

public class UserDataTeacher {
	@JsonProperty("teacher")
	ArrayList<UserData> teacher;
	@JsonProperty("school")
	ResultSchoolData school;
	
	public ArrayList<UserData> getTeacher() {
		return teacher;
	}
	public void setTeacher(ArrayList<UserData> teacher) {
		this.teacher = teacher;
	}
	public ResultSchoolData getSchool() {
		return school;
	}
	public void setSchool(ResultSchoolData school) {
		this.school = school;
	}
	
	

}
