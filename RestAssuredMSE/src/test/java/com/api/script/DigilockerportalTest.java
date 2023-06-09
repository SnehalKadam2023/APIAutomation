package com.api.script;

import static io.restassured.RestAssured.given;

import java.util.ArrayList;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.api.pojoResponse.ResultSchoolData;
import com.api.pojoResponse.UserData;
import com.api.pojoResponse.UserDataPortal;
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
	private String strMeriPehchanID;
	public static String strTeacherName;
	private String strMobileNo;
	private String strDOB;
	private String strGender;
	public static String strUdiseCodeRegister;
	private String strSchoolName;
	private static String strDIDSchool;
	private String strOSIDSchool;

	// Initialize
	private APIview objAPIview = new APIview(this);
	private commonMethodsView objcommonMethodsView = new commonMethodsView(this);
	private DigilockerEwalletTest objDigilockerEwalletTest = new DigilockerEwalletTest();

	@BeforeClass
	public void initializeEnvironment() {
		ConfigFileReader();
	}

	@AfterClass
	public void tearDown() {
		this.tearDownWebEnvironment();
	}

	@Title("Verify that user is able to generate digiurl for Portal")
	@Description("Verify that user is able to generate digiurlfor portal")
	@Test(priority = 1)
	public void API_01_VerifyUserIsAbleToGenerateDigiUrlForPortal() {
		reqSpec = new RequestSpecBuilder().addHeader("Content-Type", "application/json").build();
		Response response = given().spec(reqSpec)
				.get(ApiResreqURL.valueOf("getDigilockerAuthorizePortal").returnResourcePath()).then().extract()
				.response();
		testLevelLog.get().info("Generate DigiUrl for portal Response Data: " + response.asString());
		objAPIview.getDigiurlResponse(response);
		String actResponseCode = getConfig().getProperty("StatusCodeOK");
		objcommonMethodsView.validateStatusCode(response, actResponseCode);
		strDigiLockerurl = objAPIview.getDigilockerUrl();
	}

	@Title("Verify that user is able to generate auth code")
	@Description("Verify that user is able to generate auth code")
	@Test(priority = 2)
	public void API_02_VerifyUserIsAbleToGenerateAuthCode() throws InterruptedException {
		this.initializeWebEnvironment(strDigiLockerurl);
		strAuthCode = objAPIview.EnterDetailsOnDigilockerLoginPageUsingMobile(getConfig().getProperty("Mobile_Number"),
				getConfig().getProperty("Pin"));
		testLevelLog.get().info("Generated Auth Code: " + strAuthCode);

	}

	@Title("Verify user is able to generate token")
	@Description("Verify user is able to generate token")
	@Test(priority = 3)
	public void API_03_VerifyUserIsAbleToGenerateToken() {
		reqSpec = new RequestSpecBuilder().addHeader("Content-Type", "application/json").build();
		objAPIview.setDigiLockerRequest(getConfig().getProperty("digiacc_portal"), strAuthCode);

		Response response = given().spec(reqSpec).body(objAPIview.getDigiLockerRequest()).when()
				.post(ApiResreqURL.valueOf("postDigilockerTokenEwallet").returnResourcePath()).then().extract()
				.response();
		testLevelLog.get().info("Generate Token Response Data: " + response.asString());

		String actResponseCode = getConfig().getProperty("StatusCodeOK");
		objcommonMethodsView.validateStatusCode(response, actResponseCode);
		objAPIview.getDigiLockerTokenPortalResponse(response);
		boolean success = objAPIview.getSuccessMessagePortal();
		objcommonMethodsView.validateSuccessmessage(success);
		strTeacherName = objAPIview.getTeacherName();
		strMeriPehchanID = objAPIview.getMeripehchanIDPortal();
		strMobileNo = objAPIview.getmobileNoPortal();
		strDOB = objAPIview.getDOBPortal();
		strGender = objAPIview.getGenderPortal();
		strAccessToken = objAPIview.getAccessTokenTeacher();
		testLevelLog.get().info("Generated Token " + strAccessToken);

	}

	@Title("Verify user is able to generate uuid for portal")
	@Description("Verify user is able to generate uuid for portal")
	@Test(priority = 4)
	public void API_04_VerifyUserIsAbleToGenerateUuidPortal() {
		reqSpec = new RequestSpecBuilder().addHeader("Content-Type", "application/json").build();
		objAPIview.setDigiLockerAdharRequest(getConfig().getProperty("digiacc_portal"),
				getConfig().getProperty("strAdharId"), getConfig().getProperty("strAdharName"),
				getConfig().getProperty("strAdhargender"), getConfig().getProperty("strAdharDob"),
				getConfig().getProperty("strdigilockerID"));

		Response response = given().spec(reqSpec).body(objAPIview.getDigiLockerAdharRequest()).when()
				.post(ApiResreqURL.valueOf("postDigilockerAadhaarPortal").returnResourcePath()).then().extract()
				.response();
		testLevelLog.get().info("Generate Uuid Portal Response Data: " + response.asString());

		String actResponseCode = getConfig().getProperty("StatusCodeOK");
		objcommonMethodsView.validateStatusCode(response, actResponseCode);
		objAPIview.getDigiLockerAdharEwalletResponse(response);
		boolean success = objAPIview.getSuccessMessageAdhar();
		objcommonMethodsView.validateSuccessmessage(success);
		strUuid = objAPIview.getUuid();
	}

	@Title("Verify user is able to verify udise details")
	@Description("Verify user is able to verify udise details")
	@Test(priority = 9)
	public void API_09_VerifyUserIsAbleToVerifyUdiseDetails() {
		reqSpec = new RequestSpecBuilder().addHeader("Content-Type", "application/json").build();
		objAPIview.setUdiseVerifyRequest(getConfig().getProperty("Password"),
				objDigilockerEwalletTest.strUdiseCodeRegister);

		Response response = given().spec(reqSpec).body(objAPIview.getUdiseVerifyRequest()).when()
				.post(ApiResreqURL.valueOf("getUdiseVerify").returnResourcePath()).then().extract().response();
		testLevelLog.get().info("udise Details: " + response.asString());

		String actResponseCode = getConfig().getProperty("StatusCodeOK");
		objAPIview.getUdiseVerifyResponse(response);
		objcommonMethodsView.validateStatusCode(response, actResponseCode);
		boolean success = objAPIview.getSuccessStatusUdiseVerify();
		objcommonMethodsView.validateSuccessmessage(success);
	}

	@Title("Verify user is able to register Teacher")
	@Description("Verify user is able to register Teacher")
	@Test(priority = 10)
	public void API_10_VerifyUserIsAbleToRegisterTeacher() {
		reqSpec = new RequestSpecBuilder().addHeader("Content-Type", "application/json").build();
		objAPIview.setDigiLockerRegisterTeacherRequest(getConfig().getProperty("digiacc_portal"),
				getConfig().getProperty("student_ID"), getConfig().getProperty("DID"), strMobileNo, strUuid,
				strTeacherName, strDOB, getConfig().getProperty("schoolType"), strMeriPehchanID, strUuid, strGender,
				objDigilockerEwalletTest.strUdiseCodeRegister, objDigilockerEwalletTest.strSchoolName,
				objDigilockerEwalletTest.strStateCode, objDigilockerEwalletTest.strStateName,
				objDigilockerEwalletTest.strDistrictCode, objDigilockerEwalletTest.strDistrictname,
				objDigilockerEwalletTest.strBlockCode, objDigilockerEwalletTest.strBolckName);
		testLevelLog.get().info("Teacher Register Request state code Data: " + objDigilockerEwalletTest.strStateCode);
		testLevelLog.get().info("Teacher Register Request state name Data: " + objDigilockerEwalletTest.strStateName);
		testLevelLog.get()
				.info("Teacher Register Request district name Data: " + objDigilockerEwalletTest.strDistrictCode);
		testLevelLog.get()
				.info("Teacher Register Request district name Data: " + objDigilockerEwalletTest.strDistrictname);
		testLevelLog.get().info("Teacher Register Request block  name Data: " + objDigilockerEwalletTest.strBlockCode);
		testLevelLog.get().info("Teacher Register Request block name Data: " + objDigilockerEwalletTest.strBolckName);
		testLevelLog.get().info("Teacher Register Request school Data: " + objDigilockerEwalletTest.strSchoolName);
		int count = 0;
		boolean success = false;
		Response response = null;
		String actResponseCode;
		do {
			response = given().spec(reqSpec).body(objAPIview.getDigiLockerRegisterTeacherRequest()).when()
					.post(ApiResreqURL.valueOf("postRegisterTeacher").returnResourcePath()).then().extract().response();
			testLevelLog.get().info("Teacher Register Portal Response Data: " + response.asString());

			actResponseCode = getConfig().getProperty("StatusCodeOK");
			objAPIview.getDigiLockerPortalTeacherRegisterResponse(response);
			success = objAPIview.getSuccessMessageRegisterPortal();
			count++;
			if (success == true && count == 6) {
				break;
			}
		} while (success == false && count <= 6);
		objcommonMethodsView.validateStatusCode(response, actResponseCode);
		objcommonMethodsView.validateSuccessmessage(success);
		strTokenTeacher = objAPIview.getTokenRegisterTeacher();
		testLevelLog.get().info("Teacher Register Portal Response Token: " + strTokenTeacher);
		strDIDTeacher = objAPIview.getDIDRegisterTeacher();
		testLevelLog.get().info("Teacher Register Portal Response Teacher DID: " + strDIDTeacher);
		strDIDSchool = objAPIview.getDIDRegisterSchool();
		testLevelLog.get().info("Teacher Register Portal Response Teacher DID: " + strDIDSchool);
	}

	@Title("Get School Details")
	@Description("Get School Details")
	@Test(priority = 11)
	public void API_11_VerifyUserIsAbleToGetSchoolDetails() {
		reqSpec = new RequestSpecBuilder().addHeader("Content-Type", "application/json")
				.addHeader("Authorization", "Bearer " + strTokenTeacher)
				.addPathParam("udiseCode", objDigilockerEwalletTest.strUdiseCodeRegister).build();
		testLevelLog.get().info("Get udise code :" + objDigilockerEwalletTest.strUdiseCodeRegister);
		Response response = given().spec(reqSpec).get(ApiResreqURL.valueOf("getSchoolDetails").returnResourcePath())
				.then().extract().response();
		testLevelLog.get().info("School Details Response Data: " + response.asString());

		objAPIview.getSchoolDetailsResponse(response);
		strOSIDSchool = objAPIview.getOsidSchool();
		String actResponseCode = getConfig().getProperty("StatusCodeOK");
		boolean success = objAPIview.getSuccessSchoolDetails();
		objcommonMethodsView.validateSuccessmessage(success);
		objcommonMethodsView.validateStatusCode(response, actResponseCode);
	}

	@Title("verify user is able to logout from digilocker")
	@Description("verify user is able to logout from digilocker")
	@Test(priority = 12)
	public void API_12_verifyUserIsAbleToLogoutFromDigilocker() {
		reqSpec = new RequestSpecBuilder().addHeader("Content-Type", "application/json").build();
		objAPIview.setDigiLockerLogoutRequest(getConfig().getProperty("digiacc_portal"), strAccessToken);

		Response response = given().spec(reqSpec).body(objAPIview.getDigiLockerLogoutRequest()).when()
				.post(ApiResreqURL.valueOf("postDigilockerLogout").returnResourcePath()).then().extract().response();
		testLevelLog.get().info("Logout from digilocker Response Data: " + response.asString());

		String actResponseCode = getConfig().getProperty("StatusCodeOK");
		objAPIview.getDigiLockerTokenEwalletResponse(response);
		objcommonMethodsView.validateStatusCode(response, actResponseCode);
		boolean success = objAPIview.getSuccessMessage();
		objcommonMethodsView.validateSuccessmessage(success);

	}

	@Title("Get Teacher Data")
	@Description("Get Teacher Data")
	@Test(priority = 13)
	public void API_13_VerifyUserIsAbleToGetTeacherData() {
		reqSpec = new RequestSpecBuilder().addHeader("Content-Type", "application/json")
				.addHeader("Authorization", "Bearer " + strTokenTeacher).build();
		Response response = given().spec(reqSpec).get(ApiResreqURL.valueOf("getTeacherData").returnResourcePath())
				.then().extract().response();
		testLevelLog.get().info("Teacher Response Data: " + response.asString());

		objAPIview.getStudentDataResponse(response);
		String actResponseCode = getConfig().getProperty("StatusCodeOK");
		boolean success = objAPIview.getSuccessMessageStudentData();
		objcommonMethodsView.validateSuccessmessage(success);
		objcommonMethodsView.validateStatusCode(response, actResponseCode);
	}

	@Title("Verify that user is able to generate auth code and token using username for Portal")
	@Description("Verify that user is able to generate auth code and token using username for portal")
	@Test(priority = 14)
	public void API_14_VerifyThatUserIsAbleToGenerateAuthCodeAndTokenForUsername() {
		this.initializeWebEnvironment(strDigiLockerurl);
		strAuthCode = objAPIview.EnterDetailsOnDigilockerLoginPageUsingUsername(getConfig().getProperty("Username"),
				getConfig().getProperty("Pin"));
		reqSpec = new RequestSpecBuilder().addHeader("Content-Type", "application/json").build();
		objAPIview.setDigiLockerRequest(getConfig().getProperty("digiacc_portal"), strAuthCode);

		Response response = given().spec(reqSpec).body(objAPIview.getDigiLockerRequest()).when()
				.post(ApiResreqURL.valueOf("postDigilockerTokenPortal").returnResourcePath()).then().extract()
				.response();
		testLevelLog.get().info("Generat AuthCode And Token For Username Response Data: " + response.asString());

		String actResponseCode = getConfig().getProperty("StatusCodeOK");
		objcommonMethodsView.validateStatusCode(response, actResponseCode);
		objAPIview.getDigiLockerTokenEwalletResponse(response);
	}

	@Title("Verify user is able to get dashboard count")
	@Description("Verify user is able to get dashboard count")
	@Test(priority = 15)
	public void API_15_VerifyUserIsAbleToGetDashboardCount() {
		reqSpec = new RequestSpecBuilder().addHeader("Content-Type", "application/json")
				.addHeader("Authorization", "Bearer " + strTokenTeacher).build();
		objAPIview.setCountFieldsRequest();

		Response response = given().spec(reqSpec).body(objAPIview.getCountFieldsRequest()).when()
				.post(ApiResreqURL.valueOf("getDashboardCount").returnResourcePath()).then().extract().response();
		testLevelLog.get().info("Get Dashboard Count Response Data: " + response.asString());

		String actResponseCode = getConfig().getProperty("StatusCodeOK");
		objcommonMethodsView.validateStatusCode(response, actResponseCode);
		objAPIview.getDigiLockerDashboardCountResponse(response);
		boolean success = objAPIview.getSuccessMessageDashboardCount();
		objcommonMethodsView.validateSuccessmessage(success);
	}

	// @author : tejal
	@Title("Verify user is able to find List of students for Approval")
	@Description("Verify user is able to find list of students for Approval")
	@Test(priority = 16)
	public void API_16_VerifyUserIsAbleToFindStudentListForApproval() {
		reqSpec = new RequestSpecBuilder().addHeader("Content-Type", "application/json")
				.addHeader("Authorization", "Bearer " + strTokenTeacher).build();
		objAPIview.setSTudentDetailRequest(getConfig().getProperty("status"));

		Response response = given().spec(reqSpec).body(objAPIview.getClaimStatusRequest()).when()
				.post(ApiResreqURL.valueOf("postStudentApprovelistRequest").returnResourcePath()).then().extract()
				.response();

		testLevelLog.get().info("Response Data for approval List : " + response.asString());

		objAPIview.getDigiLockerApprovalResponse(response);
		String actResponseCode = getConfig().getProperty("StatusCodeOK");
		objcommonMethodsView.validateStatusCode(response, actResponseCode);
	}

	// @author : tejal
	@Title("Verify user is able find student for Approval")
	@Description("Verify user is able student for Approval")
	@Test(priority = 17)
	public void API_17_VerifyUserIsAbleToFindStudentForApproval() {
		reqSpec = new RequestSpecBuilder().addHeader("Content-Type", "application/json")
				.addHeader("Authorization", "Bearer " + strTokenTeacher).build();
		objAPIview.setDigiLockerStudentApproveRequest(strDIDTeacher, objDigilockerEwalletTest.StrDate,
				objDigilockerEwalletTest.strMobileNo, getConfig().getProperty("guardianName"),
				objDigilockerEwalletTest.strSchoolName, getConfig().getProperty("class"),
				getConfig().getProperty("academicYear"), strOSIDSchool, objDigilockerEwalletTest.strUdiseCodeRegister,
				getConfig().getProperty("student_ID"), objDigilockerEwalletTest.strStudentName,
				objDigilockerEwalletTest.strDOB, objDigilockerEwalletTest.strUuid,
				getConfig().getProperty("referenceID"), objDigilockerEwalletTest.strStudentOsid,
				objDigilockerEwalletTest.Strosid);

		testLevelLog.get().info(" osid from ewallet test class:" + objDigilockerEwalletTest.Strosid);
		Response response = given().spec(reqSpec).body(objAPIview.getDigiLockerStudentApproveRequest()).when()
				.post(ApiResreqURL.valueOf("postStudentApproveRequest").returnResourcePath()).then().extract()
				.response();

		testLevelLog.get().info("Response Data: " + response.asString());

		objAPIview.getDigiLockerApprovalResponse(response);
		String actResponseCode = getConfig().getProperty("StatusCodeOK");
		objcommonMethodsView.validateStatusCode(response, actResponseCode);

//		objAPIview.getSuccessMessageApproval();
//		strDIDStudent = objAPIview.getDIDStudent();
	}

	

}
