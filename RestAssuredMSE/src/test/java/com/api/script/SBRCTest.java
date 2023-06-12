package com.api.script;

import static io.restassured.RestAssured.given;

import java.util.ArrayList;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.api.pojoResponse.ResultSchoolData;
import com.api.pojoResponse.UserData;
import com.api.view.APIview;
import com.api.view.commonMethodsView;
import com.generic.ApiResreqURL;
import com.generic.BaseTest;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import ru.yandex.qatools.allure.annotations.Description;
import ru.yandex.qatools.allure.annotations.Title;

public class SBRCTest extends BaseTest {
	private RequestSpecification reqSpec = null;
	private String strDeleteToken;
	private String strOsid;

	//Initialize object 
	private APIview objAPIview= new APIview(this);
	private commonMethodsView objcommonMethodsView= new commonMethodsView(this);



	@BeforeClass
	public void initializeEnvironment() {
		ConfigFileReader(); 
	}

	@Title("Get Token")
	@Description("Get Token")
	@Test(priority = 1)
	public void API_01_GetToken() {
		reqSpec = new RequestSpecBuilder().addHeader("Content-Type","application/json").build();
		objAPIview.setGetTokenRequest(getConfig().getProperty("password_GetToken"));

		Response response = given().spec(reqSpec).body(objAPIview.GetTokenRequest()).when()
				.post(ApiResreqURL.valueOf("getToken").returnResourcePath()).then().extract().response();

		String actResponseCode=getConfig().getProperty("StatusCodeOK");
		objcommonMethodsView.validateStatusCode(response, actResponseCode);
		objAPIview.getTokenResponse(response);
		strDeleteToken =objAPIview.getDeleteToken();
	}

	@Title("SBRC Search Student")
	@Description("SBRC Search Student")
	@Test(priority = 2)
	public void API_02_SBRCSearchStudent() {
		reqSpec = new RequestSpecBuilder().addHeader("Content-Type","application/json").addHeader("Authorization", "Bearer " +strDeleteToken).build();
		objAPIview.setSearchStudentRequest(getConfig().getProperty("schema_Student"),DigilockerEwalletTest.strStudentName);

		Response response = given().spec(reqSpec).body(objAPIview.getSearchStudentRequest()).when()
				.post(ApiResreqURL.valueOf("postSBRCSearchStudent").returnResourcePath()).then().extract().response();

		objAPIview.getSBRCSearchStudentResponse(response);
		strOsid =objAPIview.getStudentOsid();
		String actResponseCode=getConfig().getProperty("StatusCodeOK");
		objcommonMethodsView.validateStatusCode(response, actResponseCode);	
	}
	
	@Title("SBRC Delete Student")
	@Description("SBRC Delete Student")
	@Test(priority = 3)
	public void API_03_SBRCDeleteStudent() {
		reqSpec = new RequestSpecBuilder().addHeader("Content-Type","application/json").addHeader("Authorization", "Bearer " +strDeleteToken).build();
		objAPIview.setDeleteStudentRequest(getConfig().getProperty("schema_Student"),strOsid);
		
		int count =0;
		boolean success=false;
		Response response = null;
		String actResponseCode;
		do
		{
			response = given().spec(reqSpec).body(objAPIview.getDeleteStudentRequest()).when()
					.post(ApiResreqURL.valueOf("postSBRCDeleteStudent").returnResourcePath()).then().extract().response();

			objAPIview.getSBRCDeleteStudentResponse(response);
			success=objAPIview.getSuccessMessageDelete();
			count++;	
			if (success==true && count==6) {
				break;	
			}
		} while(success==false && count<=6);
		actResponseCode=getConfig().getProperty("StatusCodeOK");
		objcommonMethodsView.validateStatusCode(response, actResponseCode);
	}
	
	@Title("SBRC Search teacher")
	@Description("SBRC search teacher")
	@Test(priority = 4)
	public void API_04_SBRCSearchTeacher() {
		reqSpec = new RequestSpecBuilder().addHeader("Content-Type","application/json").addHeader("Authorization", "Bearer " +strDeleteToken).build();
		objAPIview.setSearchStudentRequest(getConfig().getProperty("schema_Teacher"),DigilockerportalTest.strTeacherName);

		Response response = given().spec(reqSpec).body(objAPIview.getSearchStudentRequest()).when()
				.post(ApiResreqURL.valueOf("postSBRCSearchStudent").returnResourcePath()).then().extract().response();

		objAPIview.getSBRCSearchTeacherResponse(response);
		strOsid =objAPIview.getTeacherOsid();
		String actResponseCode=getConfig().getProperty("StatusCodeOK");
		objcommonMethodsView.validateStatusCode(response, actResponseCode);	
	}
}
