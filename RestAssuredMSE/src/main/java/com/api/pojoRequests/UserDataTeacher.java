package com.api.pojoRequests;

import java.util.ArrayList;

import com.api.pojoResponse.ResultSchoolData;
import com.api.pojoResponse.UserData;
import com.api.pojoResponse.UserDataPortal;
import com.fasterxml.jackson.annotation.JsonProperty;

public class UserDataTeacher {
	@JsonProperty("teacher")
	UserDataPortal teacher;
	@JsonProperty("school")
	ResultSchoolData school;
	
	public UserDataPortal getTeacher() {
		return teacher;
	}
	public void setTeacher(UserDataPortal strTeacherData) {
		this.teacher = strTeacherData;
	}
	public ResultSchoolData getSchool() {
		return school;
	}
	public void setSchool(ResultSchoolData school) {
		this.school = school;
	}
	
	

}
