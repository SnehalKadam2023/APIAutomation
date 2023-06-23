package com.api.script;

import static io.restassured.RestAssured.given;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.api.view.APIview;
import com.api.view.commonMethodsView;
import com.generic.ApiResreqURL;
import com.generic.BaseTest;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import ru.yandex.qatools.allure.annotations.Description;
import ru.yandex.qatools.allure.annotations.Title;

public class DigilockerEwalletNegativeTest extends BaseTest{
	//Global variables
	private RequestSpecification reqSpec = null;
	String strAuthCode;
	String strDigiLockerurl;
	String strToken;
	String strStateCode;
	String strDistrictCode;
	String strBlockCode;


	//Initialize
	private APIview objAPIview= new APIview(this);
	private commonMethodsView objcommonMethodsView= new commonMethodsView(this);
	private DigilockerEwalletTest objDigilockerEwalletTest= new DigilockerEwalletTest();
	
	@BeforeClass
	public void initializeEnvironment() {
		ConfigFileReader(); 
	}
	
	@Title("Verify user is able to generate token using wrong auth code")
	@Description("Verify user is able to generate token using wrong auth code")
	@Test(priority = 1)
	public void API_01_VerifyUserIsAbleToGenerateTokenUsingWrongAuthCode() {
		reqSpec = new RequestSpecBuilder().addHeader("Content-Type","application/json").build();
		objAPIview.setDigiLockerRequest(getConfig().getProperty("digiacc"),objDigilockerEwalletTest.strAuthCode);

		Response response = given().spec(reqSpec).body(objAPIview.getDigiLockerRequest()).when()
				.post(ApiResreqURL.valueOf("postDigilockerTokenEwallet").returnResourcePath()).then().extract().response();
		testLevelLog.get().info("GenerateToken Using Wrong auth code Response Data: "+response.asString());

		String actResponseCode=getConfig().getProperty("StatusCodeUnauthorized");	
		objcommonMethodsView.validateStatusCode(response, actResponseCode);
		boolean failed =objAPIview.getFailedMessage();
		objcommonMethodsView.validateFailedmessage(failed);	
	}

	@Title("Get State List")
	@Description("Get State List")
	@Test(priority = 2)
	public void API_02_VerifyUserIsAbleToGetStateList() {
		reqSpec = new RequestSpecBuilder().addHeader("Content-Type","application/json").build();
		Response response =	given().spec(reqSpec)
				.get(ApiResreqURL.valueOf("getStateList").returnResourcePath()).then().extract().response();
		testLevelLog.get().info("Get State List Response Data: "+response.asString());

		objAPIview.getListResponse(response);
		String actResponseCode=getConfig().getProperty("StatusCodeOK");
		boolean success=objAPIview.getStatus();
		objcommonMethodsView.validateSuccessmessage(success);
		strStateCode =objAPIview.getStateCode();
		objcommonMethodsView.validateStatusCode(response, actResponseCode);
	}

	@Title("Verify user is able to get District list")
	@Description("Verify user is able to get District list")
	@Test(priority = 3)
	public void API_03_VerifyUserIsAbleToGetDistrictList() {
		reqSpec = new RequestSpecBuilder().addHeader("Content-Type","application/json").build();
		objAPIview.setDigiLockerNegativeDistrictRequest(strStateCode);

		Response response = given().spec(reqSpec).body(objAPIview.getDigiLockerDistrictRequest()).when()
				.post(ApiResreqURL.valueOf("GetDistrictList").returnResourcePath()).then().extract().response();
		testLevelLog.get().info("Get District List  Response Data: "+response.asString());

		objAPIview.getListNegativeResponse(response);
		String actResponseCode=getConfig().getProperty("StatusCodeOK");
		boolean success=objAPIview.getFalseMessage();
		objcommonMethodsView.validateFailedmessage(success);
		objcommonMethodsView.validateStatusCode(response, actResponseCode);
	}
	
	@Title("Verify user is able to get Block list")
	@Description("Verify user is able to get Block list")
	@Test(priority = 4)
	public void API_04_VerifyUserIsAbleToGetBlockList() {
		reqSpec = new RequestSpecBuilder().addHeader("Content-Type","application/json").build();
		objAPIview.setDigiLockerNegativeBlockRequest(objDigilockerEwalletTest.strDistrictCode);

		Response response = given().spec(reqSpec).body(objAPIview.getdigilockerBlockListRequest()).when()
				.post(ApiResreqURL.valueOf("GetBlockList").returnResourcePath()).then().extract().response();
		testLevelLog.get().info("Get Block List  Response Data: "+response.asString());

		objAPIview.getListNegativeResponse(response);
		String actResponseCode=getConfig().getProperty("StatusCodeOK");
		boolean success=objAPIview.getFalseMessage();
		objcommonMethodsView.validateFailedmessage(success);
		objcommonMethodsView.validateStatusCode(response, actResponseCode);

	}
	@Title("Verify user is able to get school list")
	@Description("Verify user is able to get school list")
	@Test(priority = 5)
	public void API_05_VerifyUserIsAbleToGetSchoolList() {
		reqSpec = new RequestSpecBuilder().addHeader("Content-Type","application/json").build();
		objAPIview.setDigiLockerSchoolListRequest(getConfig().getProperty("strRegionType"),objDigilockerEwalletTest.strDistrictCode,getConfig().getProperty("strSortBy"));

		Response response = given().spec(reqSpec).body(objAPIview.getDigiLockerSchoolListRequest()).when()
				.post(ApiResreqURL.valueOf("getSchoolList").returnResourcePath()).then().extract().response();
		testLevelLog.get().info("Get School List Response Data: "+response.asString());

		objAPIview.getListNegativeResponse(response);
		String actResponseCode=getConfig().getProperty("StatusCodeOK");
		boolean success=objAPIview.getFalseMessage();
		objcommonMethodsView.validateFailedmessage(success);
		objcommonMethodsView.validateStatusCode(response, actResponseCode);
	}
	
	@Title("verify user is able to logout from digilocker")
	@Description("verify user is able to logout from digilocker")
	@Test(priority = 6)
	public void API_06_verifyUserIsAbleToLogoutFromDigilocker() {
		reqSpec = new RequestSpecBuilder().addHeader("Content-Type","application/json").build();
		objAPIview.setDigiLockerNegativeLogoutRequest(getConfig().getProperty("digiacc"),objDigilockerEwalletTest.strAccessToken);

		Response response = given().spec(reqSpec).body(objAPIview.getDigiLockerLogoutRequest()).when()
				.post(ApiResreqURL.valueOf("postDigilockerLogout").returnResourcePath()).then().extract().response();
		testLevelLog.get().info("Log out from Digilocker Response Data: "+response.asString());

		String actResponseCode=getConfig().getProperty("StatusCodeOK");
		objAPIview.getDigiLockerTokenEwalletResponse(response);
		boolean failed=objAPIview.getFailedMessage();
		objcommonMethodsView.validateFailedmessage(failed);
		objcommonMethodsView.validateStatusCode(response, actResponseCode);

	}
	
}
