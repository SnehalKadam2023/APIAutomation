package com.api.script;

import org.testng.annotations.AfterClass;
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

public class DigilockerEwalletTest extends BaseTest {
	// Global variables
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
	public static String Strosid;
	public static String strSBRCToken;
	public static String strAdharId;

	// Initialize
	private APIview objAPIview = new APIview(this);
	private commonMethodsView objcommonMethodsView = new commonMethodsView(this);
	private SBRCTest objSBRCTest = new SBRCTest();

	@BeforeClass
	public void initializeEnvironment() {
		ConfigFileReader();
	}

//	@AfterClass
//	public void tearDown() {
//		this.tearDownWebEnvironment();
//	}

	@Title("Verify that user is able to generate digiurl")
	@Description("Verify that user is able to generate digiurl ")
	@Test(priority = 1)
	public void API_01_VerifyUserIsAbleToGenerateDigiUrl() {
		reqSpec = new RequestSpecBuilder().addHeader("Content-Type", "application/json").build();
		Response response = given().spec(reqSpec)
				.get(ApiResreqURL.valueOf("getDigilockerAuthorizeEwallet").returnResourcePath()).then().extract()
				.response();
		testLevelLog.get().info("Generate digiurl Response Data: " + response.asString());

		objAPIview.getDigiurlResponse(response);
		String actResponseCode = getConfig().getProperty("StatusCodeOK");
		objcommonMethodsView.validateStatusCode(response, actResponseCode);
		strDigiLockerLearnerUrl = objAPIview.getDigilockerUrl();
	}

	@Title("Verify that user is able to generate auth code")
	@Description("Verify that user is able to generate auth code")
	@Test(priority = 2)
	public void API_02_VerifyUserIsAbleToGenerateAuthCode() throws InterruptedException {
		this.initializeWebEnvironment(strDigiLockerLearnerUrl);
		strAuthCode = objAPIview.EnterDetailsOnDigilockerLoginPageUsingMobile(getConfig().getProperty("Mobile_Number"),
				getConfig().getProperty("Pin"));
	}

	@Title("Verify user is able to generate token")
	@Description("Verify user is able to generate token")
	@Test(priority = 3)
	public void API_03_VerifyUserIsAbleToGenerateToken() throws InterruptedException {
		reqSpec = new RequestSpecBuilder().addHeader("Content-Type", "application/json").build();
		objAPIview.setDigiLockerRequest(getConfig().getProperty("digiacc"), strAuthCode);

		Response response = given().spec(reqSpec).body(objAPIview.getDigiLockerRequest()).when()
				.post(ApiResreqURL.valueOf("postDigilockerTokenEwallet").returnResourcePath()).then().extract()
				.response();
		testLevelLog.get().info("Generate Token Response Data: " + response.asString());

//		String actResponseCode = getConfig().getProperty("StatusCodeOK");
//		objcommonMethodsView.validateStatusCode(response, actResponseCode);
		objAPIview.getDigiLockerTokenEwalletResponse(response);
		boolean success = objAPIview.getSuccessMessage();

		if (success == false) {
			for (int i = 0; i <= 10; i++) {
				this.initializeWebEnvironment(strDigiLockerLearnerUrl);
				String strAuthCode1 = objAPIview.EnterDetailsOnDigilockerLoginPageUsingMobile(
						getConfig().getProperty("Mobile_Number"), getConfig().getProperty("Pin"));

				reqSpec = new RequestSpecBuilder().addHeader("Content-Type", "application/json").build();
				objAPIview.setDigiLockerRequest(getConfig().getProperty("digiacc"), strAuthCode1);

				Response response1 = given().spec(reqSpec).body(objAPIview.getDigiLockerRequest()).when()
						.post(ApiResreqURL.valueOf("postDigilockerTokenEwallet").returnResourcePath()).then().extract()
						.response();
				testLevelLog.get().info("Generate Token Response Data: " + response1.asString());

				String actResponseCode1 = getConfig().getProperty("StatusCodeOK");
				objcommonMethodsView.validateStatusCode(response1, actResponseCode1);
				objAPIview.getDigiLockerTokenEwalletResponse(response1);
				success = objAPIview.getSuccessMessage();
			}
		} else {
			objcommonMethodsView.validateSuccessmessage(success);
			strStudentName = objAPIview.getStudentName();
			strMeriPehchanID = objAPIview.getMeripehchanID();
			strMobileNo = objAPIview.getmobileNo();
			strDOB = objAPIview.getDOB();
			strGender = objAPIview.getGender();
			strAccessToken = objAPIview.getAccessToken();
		}
	}

	@Title("Verify user is able to generate uuid")
	@Description("Verify user is able to generate uuid")
	@Test(priority = 4)
	public void API_04_VerifyUserIsAbleToUenerateUuid() {
		reqSpec = new RequestSpecBuilder().addHeader("Content-Type", "application/json").build();
		objAPIview.setDigiLockerAdharRequest(getConfig().getProperty("digiacc"),
				getConfig().getProperty("strAdharName"), getConfig().getProperty("strAdhargender"),
				getConfig().getProperty("strAdharDob"), getConfig().getProperty("strdigilockerID"),
				getConfig().getProperty("strAdharId"));

		Response response = given().spec(reqSpec).body(objAPIview.getDigiLockerAdharRequest()).when()
				.post(ApiResreqURL.valueOf("postDigilockerAadhaarEwallet").returnResourcePath()).then().extract()
				.response();
		testLevelLog.get().info("Generate Uuid Response Data: " + response.asString());

		String actResponseCode = getConfig().getProperty("StatusCodeOK");
		objcommonMethodsView.validateStatusCode(response, actResponseCode);
		objAPIview.getDigiLockerAdharEwalletResponse(response);
		objAPIview.getSuccessMessageAdhar();
		strUuid = objAPIview.getUuid();
		strAdharId = objAPIview.getAdharId();
	}

	@Title("Get State List")
	@Description("Get State List")
	@Test(priority = 5)
	public void API_05_VerifyUserIsAbleToGetStateList() {
		reqSpec = new RequestSpecBuilder().addHeader("Content-Type", "application/json").build();
		Response response = given().spec(reqSpec).get(ApiResreqURL.valueOf("getStateList").returnResourcePath()).then()
				.extract().response();
		testLevelLog.get().info("Get State List Response Data: " + response.asString());

		objAPIview.getListResponse(response);
		String actResponseCode = getConfig().getProperty("StatusCodeOK");
		objAPIview.getStatus();
		strStateCode = objAPIview.getStateCode();
		testLevelLog.get().info("Get Student State code :" + strStateCode);
		strStateName = objAPIview.getStateName();
		testLevelLog.get().info("Get Student State Name :" + strSchoolName);
		objcommonMethodsView.validateStatusCode(response, actResponseCode);
	}

	@Title("Verify user is able to get District list")
	@Description("Verify user is able to get District list")
	@Test(priority = 6)
	public void API_06_VerifyUserIsAbleToGetDistrictList() {
		reqSpec = new RequestSpecBuilder().addHeader("Content-Type", "application/json").build();
		objAPIview.setDigiLockerDistrictRequest(strStateCode);

		Response response = given().spec(reqSpec).body(objAPIview.getDigiLockerDistrictRequest()).when()
				.post(ApiResreqURL.valueOf("GetDistrictList").returnResourcePath()).then().extract().response();
		testLevelLog.get().info("Get district List Response Data: " + response.asString());

		String actResponseCode = getConfig().getProperty("StatusCodeOK");
		objAPIview.getListResponse(response);
		objcommonMethodsView.validateStatusCode(response, actResponseCode);
		objAPIview.getStatus();
		strDistrictCode = objAPIview.getDistrictCode(getConfig().getProperty("strDistrict"));
		testLevelLog.get().info("Get Student district code" + strDistrictCode);
		strDistrictname = objAPIview.getDistrictName();
		testLevelLog.get().info("Get Student district name" + strDistrictname);
	}

	@Title("Verify user is able to get Block list")
	@Description("Verify user is able to get Block list")
	@Test(priority = 7)
	public void API_07_VerifyUserIsAbleToGetBlockList() {
		reqSpec = new RequestSpecBuilder().addHeader("Content-Type", "application/json").build();
		objAPIview.setDigiLockerBlockRequest(strDistrictCode);

		Response response = given().spec(reqSpec).body(objAPIview.getdigilockerBlockListRequest()).when()
				.post(ApiResreqURL.valueOf("GetBlockList").returnResourcePath()).then().extract().response();
		testLevelLog.get().info("Get Block List Response Data: " + response.asString());

		String actResponseCode = getConfig().getProperty("StatusCodeOK");
		objAPIview.getListResponse(response);
		objcommonMethodsView.validateStatusCode(response, actResponseCode);
		objAPIview.getStatus();
		strBlockCode = objAPIview.getBlockCode();
		testLevelLog.get().info("Get Block code" + strBlockCode);
		strBolckName = objAPIview.getBlockName();
		testLevelLog.get().info("Get Block code" + strBolckName);

	}

	@Title("Verify user is able to get school list")
	@Description("Verify user is able to get school list")
	@Test(priority = 8)
	public void API_08_VerifyUserIsAbleToGetSchoolList() {
		reqSpec = new RequestSpecBuilder().addHeader("Content-Type", "application/json").build();
		objAPIview.setDigiLockerSchoolListRequest(getConfig().getProperty("strRegionType"), strDistrictCode,
				getConfig().getProperty("strSortBy"));

		Response response = given().spec(reqSpec).body(objAPIview.getDigiLockerSchoolListRequest()).when()
				.post(ApiResreqURL.valueOf("getSchoolList").returnResourcePath()).then().extract().response();
		testLevelLog.get().info("Get School List Response Data: " + response.asString());

		String actResponseCode = getConfig().getProperty("StatusCodeOK");
		objAPIview.getSchoolListResponse(response);
		strUdiseCodeRegister = objAPIview.getUdiseCode();
		strSchoolName = objAPIview.getSchoolName();
		testLevelLog.get().info("Get Student School Name :" + strSchoolName);
		objcommonMethodsView.validateStatusCode(response, actResponseCode);
		objAPIview.getStatusSchoolList();

	}

	@Title("Verify user is able to register student")
	@Description("Verify user is able to register student")
	@Test(priority = 9)
	public void API_09_VerifyUserIsAbleToRegisterStudent() {
		reqSpec = new RequestSpecBuilder().addHeader("Content-Type", "application/json").build();
		objAPIview.setDigiLockerRegisterStudentRequest(getConfig().getProperty("digiacc"),
				getConfig().getProperty("student_ID"), getConfig().getProperty("DID"),
				getConfig().getProperty("referenceID"), strUuid, strStudentName, strDOB,
				getConfig().getProperty("schoolType"), strMeriPehchanID, strUuid, strGender, strUdiseCodeRegister,
				strSchoolName, strStateCode, strStateName, strDistrictCode, strDistrictname, strBlockCode, strBolckName,
				strMobileNo);
		int count = 0;
		boolean success = false;
		Response response = null;
		String actResponseCode;
		do {
			response = given().spec(reqSpec).body(objAPIview.getDigiLockerRegisterStudentRequest()).when()
					.post(ApiResreqURL.valueOf("postRegisterEwallet").returnResourcePath()).then().extract().response();
			testLevelLog.get().info("Register Student Response Data: " + response.asString());

			actResponseCode = getConfig().getProperty("StatusCodeOK");
//	     	objAPIview.getDigiLockerTokenEwalletResponse(response);
			objAPIview.getDigiLockerRegisterStudentResponse(response);

			success = objAPIview.getSuccessMessage();
			count++;
			if (success == true && count == 6) {
				break;
			}
		} while (success == false && count <= 6);

		Strosid = objAPIview.getOsid();
		testLevelLog.get().info("osid : " + Strosid);
//		strTokenStudent = objAPIview.getToken();
		objcommonMethodsView.validateStatusCode(response, actResponseCode);
	}

	
	@Title("Verify that user is able to generate auth code and token using username")
	@Description("Verify that user is able to generate auth code and token using ser name")
	@Test(priority = 10)
	public void API_10_VerifyThatUserIsAbleToGenerateAuthCodeAndTokenForUsername() {
		this.initializeWebEnvironment(strDigiLockerLearnerUrl);
		strAuthCode = objAPIview.EnterDetailsOnDigilockerLoginPageUsingUsername(getConfig().getProperty("Username"),
				getConfig().getProperty("Pin"));
		reqSpec = new RequestSpecBuilder().addHeader("Content-Type", "application/json").build();
		objAPIview.setDigiLockerRequest(getConfig().getProperty("digiacc"), strAuthCode);

		Response response = given().spec(reqSpec).body(objAPIview.getDigiLockerRequest()).when()
				.post(ApiResreqURL.valueOf("postDigilockerTokenEwallet").returnResourcePath()).then().extract()
				.response();
		testLevelLog.get().info("Generate auth code and token for username Response Data: " + response.asString());

		String actResponseCode = getConfig().getProperty("StatusCodeOK");
		objcommonMethodsView.validateStatusCode(response, actResponseCode);
		objAPIview.getDigiLockerTokenEwalletDIDResponse(response);
		strAccessToken = objAPIview.getAccessTokenFromUsernameLogin();
	}

	@Title("verify user is able to logout from digilocker")
	@Description("verify user is able to logout from digilocker")
	@Test(priority = 11)
	public void API_11_verifyUserIsAbleToLogoutFromDigilocker() {
		reqSpec = new RequestSpecBuilder().addHeader("Content-Type", "application/json").build();
		objAPIview.setDigiLockerLogoutRequest(getConfig().getProperty("digiacc"), strAccessToken);

		Response response = given().spec(reqSpec).body(objAPIview.getDigiLockerLogoutRequest()).when()
				.post(ApiResreqURL.valueOf("postDigilockerLogout").returnResourcePath()).then().extract().response();
		testLevelLog.get().info("Logout from Digilocker Response Data: " + response.asString());

		String actResponseCode = getConfig().getProperty("StatusCodeOK");
		objAPIview.getDigiLockerTokenEwalletResponse(response);
		objcommonMethodsView.validateStatusCode(response, actResponseCode);
		objAPIview.getSuccessMessage();
	}

	@Title("Get Student Data")
	@Description("Get Student Data")
	@Test(priority = 12)
	public void API_12_VerifyUserIsAbleToGetStudentData() {
		reqSpec = new RequestSpecBuilder().addHeader("Content-Type", "application/json")
				.addHeader("Authorization", "Bearer " + strSBRCToken).build();
		Response response = given().spec(reqSpec).get(ApiResreqURL.valueOf("getStudentData").returnResourcePath())
				.then().extract().response();
		testLevelLog.get().info("Get Student Response Data: " + response.asString());

		objAPIview.getStudentDataResponse(response);
		String actResponseCode = getConfig().getProperty("StatusCodeOK");
		objAPIview.getSuccessMessageStudentData();
		Strosid = objAPIview.getStuOsid();
		testLevelLog.get().info("osid : " + Strosid);
		objcommonMethodsView.validateStatusCode(response, actResponseCode);
	}

//	@Title("SBRC Search Student")
//	@Description("SBRC Search Student")
//	@Test(priority = 13)
//	public void API_13_SBRCSearchStudent() {
//		reqSpec = new RequestSpecBuilder().addHeader("Content-Type", "application/json")
//				.addHeader("Authorization", "Bearer " + strSBRCToken).build();
//		objAPIview.setSearchStudentRequest(getConfig().getProperty("schema_Student"), strStudentName);
//
//		Response response = given().spec(reqSpec).body(objAPIview.getSearchStudentRequest()).when()
//				.post(ApiResreqURL.valueOf("postSBRCSearchStudent").returnResourcePath()).then().extract().response();
//		testLevelLog.get().info("SBRC Search Student Response Data: " + response.asString());
//
//		objAPIview.getSBRCSearchStudentResponse(response);
//		strStudentOsid = objAPIview.getStudentOsid();
//		StrDate = objAPIview.getissuanceDate();
//		String actResponseCode = getConfig().getProperty("StatusCodeOK");
//		objcommonMethodsView.validateStatusCode(response, actResponseCode);
//	}
	
	// @author : tejal
		@Title("Get Token")
		@Description("Get Token")
		@Test(priority = 10)
		public void API_01_GetToken() {
			reqSpec = new RequestSpecBuilder().addHeader("Content-Type", "application/json").build();
			objAPIview.setGetTokenRequest(getConfig().getProperty("password_GetToken"));

			Response response = given().spec(reqSpec).body(objAPIview.GetTokenRequest()).when()
					.post(ApiResreqURL.valueOf("getToken").returnResourcePath()).then().extract().response();

			testLevelLog.get().info("Get Token Response Data : " + response.asString());
			String actResponseCode = getConfig().getProperty("StatusCodeOK");
			objcommonMethodsView.validateStatusCode(response, actResponseCode);
			objAPIview.getTokenResponse(response);
			strSBRCToken = objAPIview.getDeleteToken();
		}
}
