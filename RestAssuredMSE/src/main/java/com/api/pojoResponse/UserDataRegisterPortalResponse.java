package com.api.pojoResponse;

import java.util.ArrayList;

import com.api.pojoResponse.ResultSchoolData;
import com.api.pojoResponse.UserData;
import com.api.pojoResponse.UserDataPortal;
import com.fasterxml.jackson.annotation.JsonProperty;

public class UserDataRegisterPortalResponse {
	@JsonProperty("teacher")
	UserDataTeacherRegisterPortalResponse teacher;
	public UserDataTeacherRegisterPortalResponse getTeacher() {
		return teacher;
	}
	public void setTeacher(UserDataTeacherRegisterPortalResponse teacher) {
		this.teacher = teacher;
	}
	public ResultSchoolData getSchool() {
		return school;
	}
	public void setSchool(ResultSchoolData school) {
		this.school = school;
	}
	@JsonProperty("school")
	ResultSchoolData school;
	
	

}
