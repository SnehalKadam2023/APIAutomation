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
	public static String strAuthCode;
	String strDigiLockerurl;
	public static String strTokenTeacher;
	public static String strAccessToken;
	public static String strDIDTeacher;
	String strUuid;
	String strStateCode;
	public static String strDistrictCode;
	String strBlockCode;
	public static String strUdiseCode;

	//Initialize
	private APIview objAPIview= new APIview(this);
	private commonMethodsView objcommonMethodsView= new commonMethodsView(this);
	private ArrayList<UserData> strTeacherData;
	private ResultSchoolData strSchoolDetails;
	private String strMeriPehchanID;

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
	}

}
