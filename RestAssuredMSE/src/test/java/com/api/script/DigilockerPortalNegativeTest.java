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

public class DigilockerPortalNegativeTest extends BaseTest{
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
	private DigilockerportalTest objDigilockerportalTest= new DigilockerportalTest();
	
	@BeforeClass
	public void initializeEnvironment() {
		ConfigFileReader(); 
	}
	
	@Title("Verify user is able to generate token using wrong auth code")
	@Description("Verify user is able to generate token using wrong auth code")
	@Test(priority = 1)
	public void API_01_VerifyUserIsAbleToGenerateTokenUsingWrongAuthCode() {
		reqSpec = new RequestSpecBuilder().addHeader("Content-Type","application/json").build();
		objAPIview.setDigiLockerRequest(getConfig().getProperty("digiacc"),objDigilockerportalTest.strAuthCode);

		Response response = given().spec(reqSpec).body(objAPIview.getDigiLockerRequest()).when()
				.post(ApiResreqURL.valueOf("postDigilockerTokenPortal").returnResourcePath()).then().extract().response();

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
		objAPIview.setDigiLockerNegativeBlockRequest(objDigilockerportalTest.strDistrictCode);

		Response response = given().spec(reqSpec).body(objAPIview.getdigilockerBlockListRequest()).when()
				.post(ApiResreqURL.valueOf("GetBlockList").returnResourcePath()).then().extract().response();

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
		objAPIview.setDigiLockerSchoolListRequest(getConfig().getProperty("strRegionType"),objDigilockerportalTest.strDistrictCode,getConfig().getProperty("strSortBy"));

		Response response = given().spec(reqSpec).body(objAPIview.getDigiLockerSchoolListRequest()).when()
				.post(ApiResreqURL.valueOf("getSchoolList").returnResourcePath()).then().extract().response();

		objAPIview.getListNegativeResponse(response);
		String actResponseCode=getConfig().getProperty("StatusCodeOK");
		boolean success=objAPIview.getFalseMessage();
		objcommonMethodsView.validateFailedmessage(success);
		objcommonMethodsView.validateStatusCode(response, actResponseCode);
	}
	
	@Title("Verify user is able to verify udise details")
	@Description("Verify user is able to verify udise details")
	@Test(priority = 6)
	public void API_06_VerifyUserIsAbleToVerifyUdiseDetails() {
		reqSpec = new RequestSpecBuilder().addHeader("Content-Type","application/json").build();
		objAPIview.setUdiseVerifyNegativeRequest(getConfig().getProperty("Password"),objDigilockerportalTest.strUdiseCode);

		Response response = given().spec(reqSpec).body(objAPIview.getUdiseVerifyRequest()).when()
				.post(ApiResreqURL.valueOf("getUdiseVerify").returnResourcePath()).then().extract().response();

		objAPIview.getListNegativeResponse(response);
		String actResponseCode=getConfig().getProperty("StatusCodeOK");
		boolean success=objAPIview.getFalseMessage();
		objcommonMethodsView.validateFailedmessage(success);
		objcommonMethodsView.validateStatusCode(response, actResponseCode);
	}
	@Title("verify user is able to logout from digilocker")
	@Description("verify user is able to logout from digilocker")
	@Test(priority = 7)
	public void API_07_verifyUserIsAbleToLogoutFromDigilocker() {
		reqSpec = new RequestSpecBuilder().addHeader("Content-Type","application/json").build();
		objAPIview.setDigiLockerNegativeLogoutRequest(getConfig().getProperty("digiacc_portal"),objDigilockerportalTest.strAccessToken);

		Response response = given().spec(reqSpec).body(objAPIview.getDigiLockerLogoutRequest()).when()
				.post(ApiResreqURL.valueOf("postDigilockerLogout").returnResourcePath()).then().extract().response();

		String actResponseCode=getConfig().getProperty("StatusCodeOK");
		objAPIview.getDigiLockerTokenEwalletResponse(response);
		boolean failed=objAPIview.getFailedMessage();
		objcommonMethodsView.validateFailedmessage(failed);
		objcommonMethodsView.validateStatusCode(response, actResponseCode);
	}
}
