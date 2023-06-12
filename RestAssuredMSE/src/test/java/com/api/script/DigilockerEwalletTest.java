package com.api.script;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;

import java.util.ArrayList;

import com.api.pojoResponse.Detail;
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

public class DigilockerEwalletTest extends BaseTest{
	//Global variables
	private RequestSpecification reqSpec = null;
	public static String strAuthCode;
	public static String strDigiLockerLearnerUrl;
	public static String strTokenStudent;
	public static String strAccessToken;
	public static String strDIDStudent;
	public static String strUuid;
	public static String strStateCode;
	public static String strDistrictCode;
	public static String strBlockCode;
	public static String strUdiseCode;
	public static String strStudentName;
	public static String strMeriPehchanID;
	public static String strMobileNo;
	public static String strDOB;
	public static String strStateName;
	public static String strDistrictname;
	public static String strBolckName;
	public static String strUdiseCodeRegister;
	public static String strSchoolName;
	public static String strGender;
	public static String strStudentOsid;
	public static String StrDate;

	//Initialize
	private APIview objAPIview= new APIview(this);
	private commonMethodsView objcommonMethodsView= new commonMethodsView(this);
	
	
	
	@BeforeClass
	public void initializeEnvironment() {
		ConfigFileReader(); 
	}

	@Title("Verify that user is able to generate digiurl")
	@Description("Verify that user is able to generate digiurl ")
	@Test(priority = 1)
	public void API_01_VerifyUserIsAbleToGenerateDigiUrl() {
		reqSpec = new RequestSpecBuilder().addHeader("Content-Type","application/json").build();
		Response response =	given().spec(reqSpec)
				.get(ApiResreqURL.valueOf("getDigilockerAuthorizeEwallet").returnResourcePath()).then().extract().response();

		objAPIview.getDigiurlResponse(response);
		String actResponseCode=getConfig().getProperty("StatusCodeOK");
		objcommonMethodsView.validateStatusCode(response, actResponseCode);
		strDigiLockerLearnerUrl=objAPIview.getDigilockerUrl();
	}

	@Title("Verify that user is able to generate auth code")
	@Description("Verify that user is able to generate auth code")
	@Test(priority = 2)
	public void API_02_VerifyUserIsAbleToGenerateAuthCode() {
		this.initializeWebEnvironment(strDigiLockerLearnerUrl); 
		strAuthCode=objAPIview.EnterDetailsOnDigilockerLoginPageUsingMobile(getConfig().getProperty("Mobile_Number"),getConfig().getProperty("Pin"));	
	}

	@Title("Verify user is able to generate token")
	@Description("Verify user is able to generate token")
	@Test(priority = 3)
	public void API_03_VerifyUserIsAbleToGenerateToken() {
		reqSpec = new RequestSpecBuilder().addHeader("Content-Type","application/json").build();
		objAPIview.setDigiLockerRequest(getConfig().getProperty("digiacc"),strAuthCode);

		Response response = given().spec(reqSpec).body(objAPIview.getDigiLockerRequest()).when()
				.post(ApiResreqURL.valueOf("postDigilockerTokenEwallet").returnResourcePath()).then().extract().response();

		String actResponseCode=getConfig().getProperty("StatusCodeOK");
		objcommonMethodsView.validateStatusCode(response, actResponseCode);
		objAPIview.getDigiLockerTokenEwalletResponse(response);
		boolean success=objAPIview.getSuccessMessage();
		objcommonMethodsView.validateSuccessmessage(success);
		strStudentName=objAPIview.getStudentName();
		strMeriPehchanID = objAPIview.getMeripehchanID();
		strMobileNo =objAPIview.getmobileNo();
		strDOB = objAPIview.getDOB();
		strGender = objAPIview.getGender();
		strAccessToken = objAPIview.getAccessToken();
	}

	@Title("Verify user is able to generate uuid")
	@Description("Verify user is able to generate uuid")
	@Test(priority = 4)
	public void API_04_VerifyUserIsAbleToUenerateUuid() {
		reqSpec = new RequestSpecBuilder().addHeader("Content-Type","application/json").build();
		objAPIview.setDigiLockerAdharRequest(getConfig().getProperty("digiacc"),getConfig().getProperty("strAdharName"),
				getConfig().getProperty("strAdhargender"),getConfig().getProperty("strAdharDob"),getConfig().getProperty("strdigilockerID"));

		Response response = given().spec(reqSpec).body(objAPIview.getDigiLockerAdharRequest()).when()
				.post(ApiResreqURL.valueOf("postDigilockerAadhaarEwallet").returnResourcePath()).then().extract().response();

		String actResponseCode=getConfig().getProperty("StatusCodeOK");
		objcommonMethodsView.validateStatusCode(response, actResponseCode);
		objAPIview.getDigiLockerAdharEwalletResponse(response);
		objAPIview.getSuccessMessageAdhar();
		strUuid = objAPIview.getUuid();
	}

	@Title("Get State List")
	@Description("Get State List")
	@Test(priority = 5)
	public void API_05_VerifyUserIsAbleToGetStateList() {
		reqSpec = new RequestSpecBuilder().addHeader("Content-Type","application/json").build();
		Response response =	given().spec(reqSpec)
				.get(ApiResreqURL.valueOf("getStateList").returnResourcePath()).then().extract().response();

		objAPIview.getListResponse(response);
		String actResponseCode=getConfig().getProperty("StatusCodeOK");
		objAPIview.getStatus();
		strStateCode =objAPIview.getStateCode();
		strStateName = objAPIview.getStateName();
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
		objAPIview.getStatus();
		strDistrictCode =objAPIview.getDistrictCode();
		strDistrictname =objAPIview.getDistrictName();
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
		objAPIview.getStatus();
		strBlockCode =objAPIview.getBlockCode();
		strBolckName = objAPIview.getBlockName();

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
		strUdiseCodeRegister=objAPIview.getUdiseCode();
		strSchoolName = objAPIview.getSchoolName();
		objcommonMethodsView.validateStatusCode(response, actResponseCode);
		objAPIview.getStatusSchoolList();
		
	}

	@Title("Verify user is able to register student")
	@Description("Verify user is able to register student")
	@Test(priority = 9)
	public void API_09_VerifyUserIsAbleToRegisterStudent() {
		reqSpec = new RequestSpecBuilder().addHeader("Content-Type","application/json").build();
		objAPIview.setDigiLockerRegisterStudentRequest(getConfig().getProperty("digiacc"),getConfig().getProperty("student_ID"),
				getConfig().getProperty("DID"),getConfig().getProperty("referenceID"),strUuid,
				strStudentName,strDOB,getConfig().getProperty("schoolType"),strMeriPehchanID,strUuid,
				strGender,strUdiseCodeRegister,strSchoolName,strStateCode,strStateName,strDistrictCode,
				strDistrictname,strBlockCode,strBolckName,strMobileNo);
		int count =0;
		boolean success=false;
		Response response = null;
		String actResponseCode;
		do
		{	
		 response = given().spec(reqSpec).body(objAPIview.getDigiLockerRegisterStudentRequest()).when()
				.post(ApiResreqURL.valueOf("postRegisterEwallet").returnResourcePath()).then().extract().response();
		
		 actResponseCode=getConfig().getProperty("StatusCodeOK");
		objAPIview.getDigiLockerTokenEwalletResponse(response);
		
		success=objAPIview.getSuccessMessage();
		count++;	
		if (success==true && count==6) {
			break;	
		}
	} while(success==false && count<=6);
		strTokenStudent = objAPIview.getToken();
		objcommonMethodsView.validateStatusCode(response, actResponseCode);
	}

	@Title("Get Student Data")
	@Description("Get Student Data")
	@Test(priority = 10)
	public void API_10_VerifyUserIsAbleToGetStudentData() {
		reqSpec = new RequestSpecBuilder().addHeader("Content-Type","application/json").addHeader("Authorization", "Bearer " +strTokenStudent).build();
		Response response =	given().spec(reqSpec)
				.get(ApiResreqURL.valueOf("getStudentData").returnResourcePath()).then().extract().response();

		objAPIview.getStudentDataResponse(response);
		String actResponseCode=getConfig().getProperty("StatusCodeOK");
		objAPIview.getSuccessMessageStudentData();
		objcommonMethodsView.validateStatusCode(response, actResponseCode);
	}

	@Title("Verify that user is able to generate auth code and token using username")
	@Description("Verify that user is able to generate auth code and token using ser name")
	@Test(priority = 11)
	public void API_11_VerifyThatUserIsAbleToGenerateAuthCodeAndTokenForUsername() {
		this.initializeWebEnvironment(strDigiLockerLearnerUrl); 
		strAuthCode=objAPIview.EnterDetailsOnDigilockerLoginPageUsingUsername(getConfig().getProperty("Username"),getConfig().getProperty("Pin"));
		reqSpec = new RequestSpecBuilder().addHeader("Content-Type","application/json").build();
		objAPIview.setDigiLockerRequest(getConfig().getProperty("digiacc"),strAuthCode);

		Response response = given().spec(reqSpec).body(objAPIview.getDigiLockerRequest()).when()
				.post(ApiResreqURL.valueOf("postDigilockerTokenEwallet").returnResourcePath()).then().extract().response();

		String actResponseCode=getConfig().getProperty("StatusCodeOK");
		objcommonMethodsView.validateStatusCode(response, actResponseCode);
		objAPIview.getDigiLockerTokenEwalletDIDResponse(response);
	}	
	@Title("verify user is able to logout from digilocker")
	@Description("verify user is able to logout from digilocker")
	@Test(priority = 12)
	public void API_12_verifyUserIsAbleToLogoutFromDigilocker() {
		reqSpec = new RequestSpecBuilder().addHeader("Content-Type","application/json").build();
		objAPIview.setDigiLockerLogoutRequest(getConfig().getProperty("digiacc"),strAccessToken);

		Response response = given().spec(reqSpec).body(objAPIview.getDigiLockerLogoutRequest()).when()
				.post(ApiResreqURL.valueOf("postDigilockerLogout").returnResourcePath()).then().extract().response();

		String actResponseCode=getConfig().getProperty("StatusCodeOK");
		objAPIview.getDigiLockerTokenEwalletResponse(response);
		objcommonMethodsView.validateStatusCode(response, actResponseCode);
		objAPIview.getSuccessMessage();
	}
	
	@Title("SBRC Search Student")
	@Description("SBRC Search Student")
	@Test(priority = 13)
	public void API_13_SBRCSearchStudent() {
		reqSpec = new RequestSpecBuilder().addHeader("Content-Type","application/json").addHeader("Authorization", "Bearer " +strTokenStudent).build();
		objAPIview.setSearchStudentRequest(getConfig().getProperty("schema_Student"),strStudentName);

		Response response = given().spec(reqSpec).body(objAPIview.getSearchStudentRequest()).when()
				.post(ApiResreqURL.valueOf("postSBRCSearchStudent").returnResourcePath()).then().extract().response();

		objAPIview.getSBRCSearchStudentResponse(response);
		strStudentOsid =objAPIview.getStudentOsid();
		StrDate= objAPIview.getissuanceDate();
		String actResponseCode=getConfig().getProperty("StatusCodeOK");
		objcommonMethodsView.validateStatusCode(response, actResponseCode);	
	}

}
