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

public class DigilockerportalTest extends BaseTest {
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
	private ArrayList<UserData> strTeacherData;
	private ResultSchoolData strSchoolDetails;
	private String strMeriPehchanID;

	//Initialize
	private APIview objAPIview= new APIview(this);
	private commonMethodsView objcommonMethodsView= new commonMethodsView(this);

	@BeforeClass
	public void initializeEnvironment() {
		ConfigFileReader(); 
	}

	@Title("Verify that user is able to generate digiurl for Portal")
	@Description("Verify that user is able to generate digiurlfor portal")
	@Test(priority = 1)
	public void API_01_VerifyUserIsAbleToGenerateDigiUrlForPortal() {
		reqSpec = new RequestSpecBuilder().addHeader("Content-Type","application/json").build();
		Response response =	given().spec(reqSpec)
				.get(ApiResreqURL.valueOf("getDigilockerAuthorizePortal").returnResourcePath()).then().extract().response();
		
		objAPIview.getDigiurlResponse(response);
		String actResponseCode=getConfig().getProperty("StatusCodeOK");
		objcommonMethodsView.validateStatusCode(response, actResponseCode);
		strDigiLockerurl=objAPIview.getDigilockerUrl();
	}

	@Title("Verify that user is able to generate auth code")
	@Description("Verify that user is able to generate auth code")
	@Test(priority = 2)
	public void API_02_VerifyUserIsAbleToGenerateAuthCode() {
		this.initializeWebEnvironment(strDigiLockerurl); 
		strAuthCode=objAPIview.EnterDetailsOnDigilockerLoginPageUsingMobile(getConfig().getProperty("Mobile_Number"),getConfig().getProperty("Pin"));	
	}

	@Title("Verify user is able to generate token")
	@Description("Verify user is able to generate token")
	@Test(priority = 3)
	public void API_03_VerifyUserIsAbleToGenerateToken() {
		reqSpec = new RequestSpecBuilder().addHeader("Content-Type","application/json").build();
		objAPIview.setDigiLockerRequest(getConfig().getProperty("digiacc_portal"),strAuthCode);

		Response response = given().spec(reqSpec).body(objAPIview.getDigiLockerRequest()).when()
				.post(ApiResreqURL.valueOf("postDigilockerTokenEwallet").returnResourcePath()).then().extract().response();
		
		String actResponseCode=getConfig().getProperty("StatusCodeOK");
		objcommonMethodsView.validateStatusCode(response, actResponseCode);
		objAPIview.getDigiLockerTokenEwalletResponse(response);
		strTeacherData=objAPIview.getTeacherData();
		strMeriPehchanID=objAPIview.getMeripehchanID();
		boolean success=objAPIview.getSuccessMessage();
		objcommonMethodsView.validateSuccessmessage(success);
		strTokenTeacher = objAPIview.getToken();
		strAccessToken = objAPIview.getAccessToken();
		strDIDTeacher = objAPIview.getDID();
	}
//	@Title("Verify user is able to generate uuid for portal")
//	@Description("Verify user is able to generate uuid for portal")
//	@Test(priority = 4)
//	public void API_04_VerifyUserIsAbleToGenerateUuidPortal() {
//		reqSpec = new RequestSpecBuilder().addHeader("Content-Type","application/json").build();
//		objAPIview.setDigiLockerAdharRequest(getConfig().getProperty("digiacc_portal"),getConfig().getProperty("strAdharName"),
//				getConfig().getProperty("strAdhargender"),getConfig().getProperty("strAdharDob"),getConfig().getProperty("strdigilockerID"));
//
//		Response response = given().spec(reqSpec).body(objAPIview.getDigiLockerAdharRequest()).when()
//				.post(ApiResreqURL.valueOf("postDigilockerAadhaarPortal").returnResourcePath()).then().extract().response();
//		
//		String actResponseCode=getConfig().getProperty("StatusCodeOK");
//		objcommonMethodsView.validateStatusCode(response, actResponseCode);
//		objAPIview.getDigiLockerAdharEwalletResponse(response);
//		boolean success=objAPIview.getSuccessMessageAdhar();
//		objcommonMethodsView.validateSuccessmessage(success);
//		strUuid = objAPIview.getUuid();
//	}
	@Title("Get State List")
	@Description("Get State List")
	@Test(priority = 5)
	public void API_05_VerifyUserIsAbleToGetStateList() {
		reqSpec = new RequestSpecBuilder().addHeader("Content-Type","application/json").build();
		Response response =	given().spec(reqSpec)
				.get(ApiResreqURL.valueOf("getStateList").returnResourcePath()).then().extract().response();

		objAPIview.getListResponse(response);
		String actResponseCode=getConfig().getProperty("StatusCodeOK");
		boolean success=objAPIview.getStatus();
		objcommonMethodsView.validateSuccessmessage(success);
		strStateCode =objAPIview.getStateCode();
		objcommonMethodsView.validateStatusCode(response, actResponseCode);
	}

	@Title("Verify user is able to get District list")
	@Description("Verify user is able to get District list")
	@Test(priority = 6)
	public void API_06_VerifyUserIsAbleToGetDistrictList() {
		reqSpec = new RequestSpecBuilder().addHeader("Content-Type","application/json").build();
		objAPIview.setDigiLockerDistrictRequest(strStateCode);

		Response response = given().spec(reqSpec).body(objAPIview.getDigiLockerDistrictRequest()).when()
				.post(ApiResreqURL.valueOf("GetDistrictList").returnResourcePath()).then().extract().response();

		String actResponseCode=getConfig().getProperty("StatusCodeOK");
		objAPIview.getListResponse(response);
		objcommonMethodsView.validateStatusCode(response, actResponseCode);
		boolean success =objAPIview.getStatus();
		objcommonMethodsView.validateSuccessmessage(success);
		strDistrictCode =objAPIview.getDistrictCode();

	}
	@Title("Verify user is able to get Block list")
	@Description("Verify user is able to get Block list")
	@Test(priority = 7)
	public void API_07_VerifyUserIsAbleToGetBlockList() {
		reqSpec = new RequestSpecBuilder().addHeader("Content-Type","application/json").build();
		objAPIview.setDigiLockerBlockRequest(strDistrictCode);

		Response response = given().spec(reqSpec).body(objAPIview.getdigilockerBlockListRequest()).when()
				.post(ApiResreqURL.valueOf("GetBlockList").returnResourcePath()).then().extract().response();

		String actResponseCode=getConfig().getProperty("StatusCodeOK");
		objAPIview.getListResponse(response);
		objcommonMethodsView.validateStatusCode(response, actResponseCode);
		boolean success=objAPIview.getStatus();
		objcommonMethodsView.validateSuccessmessage(success);
		strBlockCode =objAPIview.getBlockCode();

	}
	@Title("Verify user is able to get school list")
	@Description("Verify user is able to get school list")
	@Test(priority = 8)
	public void API_08_VerifyUserIsAbleToGetSchoolList() {
		reqSpec = new RequestSpecBuilder().addHeader("Content-Type","application/json").build();
		objAPIview.setDigiLockerSchoolListRequest(getConfig().getProperty("strRegionType"),strDistrictCode,getConfig().getProperty("strSortBy"));

		Response response = given().spec(reqSpec).body(objAPIview.getDigiLockerSchoolListRequest()).when()
				.post(ApiResreqURL.valueOf("getSchoolList").returnResourcePath()).then().extract().response();

		String actResponseCode=getConfig().getProperty("StatusCodeOK");
		objAPIview.getSchoolListResponse(response);
		strUdiseCode= objAPIview.getUdiseCode();
		objcommonMethodsView.validateStatusCode(response, actResponseCode);
		boolean success =objAPIview.getStatusSchoolList();
		objcommonMethodsView.validateSuccessmessage(success);
	
	}
	
	@Title("Verify user is able to verify udise details")
	@Description("Verify user is able to verify udise details")
	@Test(priority = 9)
	public void API_09_VerifyUserIsAbleToVerifyUdiseDetails() {
		reqSpec = new RequestSpecBuilder().addHeader("Content-Type","application/json").build();
		objAPIview.setUdiseVerifyRequest(getConfig().getProperty("Password"),strUdiseCode);

		Response response = given().spec(reqSpec).body(objAPIview.getUdiseVerifyRequest()).when()
				.post(ApiResreqURL.valueOf("getUdiseVerify").returnResourcePath()).then().extract().response();

		String actResponseCode=getConfig().getProperty("StatusCodeOK");
		objAPIview.getUdiseVerifyResponse(response);
		objcommonMethodsView.validateStatusCode(response, actResponseCode);
		boolean success=objAPIview.getSuccessStatusUdiseVerify();
		objcommonMethodsView.validateSuccessmessage(success);
	}
	
	@Title("Get School Details")
	@Description("Get School Details")
	@Test(priority = 10)
	public void API_10_VerifyUserIsAbleToGetSchoolDetails() {
		reqSpec = new RequestSpecBuilder().addHeader("Content-Type","application/json")
				.addHeader("Authorization", "Bearer " +strTokenTeacher).addPathParam("udiseCode",strUdiseCode).build();
		
		Response response =	given().spec(reqSpec)
				.get(ApiResreqURL.valueOf("getSchoolDetails").returnResourcePath()).then().extract().response();

		objAPIview.getSchoolDetailsResponse(response);
		strSchoolDetails =objAPIview.getSchoolDetails();
		String actResponseCode=getConfig().getProperty("StatusCodeOK");
		boolean success =objAPIview.getSuccessSchoolDetails();
		objcommonMethodsView.validateSuccessmessage(success);
		objcommonMethodsView.validateStatusCode(response, actResponseCode);
	}
	

	@Title("verify user is able to logout from digilocker")
	@Description("verify user is able to logout from digilocker")
	@Test(priority = 9)
	public void API_09_verifyUserIsAbleToLogoutFromDigilocker() {
		reqSpec = new RequestSpecBuilder().addHeader("Content-Type","application/json").build();
		objAPIview.setDigiLockerLogoutRequest(getConfig().getProperty("digiacc_portal"),strAccessToken);

		Response response = given().spec(reqSpec).body(objAPIview.getDigiLockerLogoutRequest()).when()
				.post(ApiResreqURL.valueOf("postDigilockerLogout").returnResourcePath()).then().extract().response();

		String actResponseCode=getConfig().getProperty("StatusCodeOK");
		objAPIview.getDigiLockerTokenEwalletResponse(response);
		objcommonMethodsView.validateStatusCode(response, actResponseCode);
		boolean success=objAPIview.getSuccessMessage();
		objcommonMethodsView.validateSuccessmessage(success);

	}
	@Title("Get Teacher Data")
	@Description("Get Teacher Data")
	@Test(priority = 10)
	public void API_10_VerifyUserIsAbleToGetStudentData() {
		reqSpec = new RequestSpecBuilder().addHeader("Content-Type","application/json").addHeader("Authorization", "Bearer " +strTokenTeacher).build();
		Response response =	given().spec(reqSpec)
				.get(ApiResreqURL.valueOf("getTeacherData").returnResourcePath()).then().extract().response();

		objAPIview.getStudentDataResponse(response);
		String actResponseCode=getConfig().getProperty("StatusCodeOK");
		boolean success= objAPIview.getSuccessMessageStudentData();
		objcommonMethodsView.validateSuccessmessage(success);
		objcommonMethodsView.validateStatusCode(response, actResponseCode);
	}
	@Title("Verify that user is able to generate auth code and token using username for Portal")
	@Description("Verify that user is able to generate auth code and token using username for portal")
	@Test(priority = 11)
	public void API_11_VerifyThatUserIsAbleToGenerateAuthCodeAndTokenForUsername() {
		this.initializeWebEnvironment(strDigiLockerurl); 
		strAuthCode=objAPIview.EnterDetailsOnDigilockerLoginPageUsingUsername(getConfig().getProperty("Username"),getConfig().getProperty("Pin"));
		reqSpec = new RequestSpecBuilder().addHeader("Content-Type","application/json").build();
		objAPIview.setDigiLockerRequest(getConfig().getProperty("digiacc_portal"),strAuthCode);

		Response response = given().spec(reqSpec).body(objAPIview.getDigiLockerRequest()).when()
				.post(ApiResreqURL.valueOf("postDigilockerTokenPortal").returnResourcePath()).then().extract().response();

		String actResponseCode=getConfig().getProperty("StatusCodeOK");
		objcommonMethodsView.validateStatusCode(response, actResponseCode);
		objAPIview.getDigiLockerTokenEwalletResponse(response);
	}
	
	@Title("Verify user is able to get dashboard count")
	@Description("Verify user is able to get dashboard count")
	@Test(priority = 12)
	public void API_12_VerifyUserIsAbleToGetDashboardCount() {
		reqSpec = new RequestSpecBuilder().addHeader("Content-Type","application/json").addHeader("Authorization", "Bearer " +strTokenTeacher).build();
		objAPIview.setCountFieldsRequest();

		Response response = given().spec(reqSpec).body(objAPIview.getCountFieldsRequest()).when()
				.post(ApiResreqURL.valueOf("getDashboardCount").returnResourcePath()).then().extract().response();

		String actResponseCode=getConfig().getProperty("StatusCodeOK");
		objcommonMethodsView.validateStatusCode(response, actResponseCode);
		objAPIview.getDigiLockerDashboardCountResponse(response);
		boolean success= objAPIview.getSuccessMessageDashboardCount();
		objcommonMethodsView.validateSuccessmessage(success);
	}
	
	@Title("Verify user is able to register Teacher")
	@Description("Verify user is able to register Teacher")
	@Test(priority = 13)
	public void API_13_VerifyUserIsAbleToRegisterTeacher() {
		reqSpec = new RequestSpecBuilder().addHeader("Content-Type","application/json").build();
		objAPIview.setDigiLockerRegisterTeacherRequest(getConfig().getProperty("digiacc_portal"),strTeacherData,strSchoolDetails,strMeriPehchanID);

		Response response = given().spec(reqSpec).body(objAPIview.getDigiLockerRegisterTeacherRequest()).when()
				.post(ApiResreqURL.valueOf("postRegisterTeacher").returnResourcePath()).then().extract().response();
		String actResponseCode=getConfig().getProperty("StatusCodeOK");
		objAPIview.getRegisterTeacherResponse(response);
		objcommonMethodsView.validateStatusCode(response, actResponseCode);
	}
}
