package com.api.script;

import static io.restassured.RestAssured.given;

import java.io.File;
import java.util.Base64;
import java.util.List; 

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.api.pojoResponse.ResultRenderSchema;
import com.api.pojoResponse.ResultSearchStudent;
import com.api.view.APIview;
import com.api.view.commonMethodsView;
import com.generic.ApiResreqURL;
import com.generic.BaseTest;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import ru.yandex.qatools.allure.annotations.Description;
import ru.yandex.qatools.allure.annotations.Title;

public class DigilockerBFFCredentialsTest extends BaseTest{

	//Global variables
	private RequestSpecification reqSpec = null;
	String strCredentialsID;
	String strCredentialSchemaID;
	Response responseSearchStudent;
	Response responseRenderSchema;
	Response responseSchemaTemplate;
	ResultSearchStudent strCredentials;
	ResultRenderSchema strResultRenderSchema;
	String strSchemaTemplate;

	//Initialize
	private APIview objAPIview= new APIview(this);
	private commonMethodsView objcommonMethodsView= new commonMethodsView(this);
	private DigilockerEwalletTest objDigilockerEwalletTest= new DigilockerEwalletTest();
	private DigilockerportalTest objDigilockerportalTest= new DigilockerportalTest();

	@BeforeClass
	public void initializeEnvironment() {
		ConfigFileReader(); 
	}

	@Title("Verify user is able to search student")
	@Description("Verify user is able to search student")
	@Test(priority = 1)
	public void API_01_VerifyUserIsAbleToSearchStudent() {
		reqSpec = new RequestSpecBuilder().addHeader("Content-Type","application/json").addHeader("Authorization", "Bearer " +objDigilockerEwalletTest.strTokenStudent).build();
		objAPIview.setBFFCredentialSearchStudent(objDigilockerEwalletTest.strDIDStudent);
		responseSearchStudent =	given().spec(reqSpec).body(objAPIview.getBFFCredentialSearchStudent()).when()
				.post(ApiResreqURL.valueOf("postSearchStudent").returnResourcePath()).then().extract().response();

		objAPIview.getSearchStudentResponse(responseSearchStudent);
		strCredentialsID=objAPIview.getCredentialID();
		strCredentials =objAPIview.getResultCredentials();
		String actResponseCode=getConfig().getProperty("StatusCodeOK");
		objcommonMethodsView.validateStatusCode(responseSearchStudent, actResponseCode);
		boolean success =objAPIview.getSuccessMessageSearchStudent();
		objcommonMethodsView.validateSuccessmessage(success);
	}

	@Title("Get Schema ID bt credentials ID")
	@Description("Get schema ID by credentials ID")
	@Test(priority = 2)
	public void API_02_GetSchemaIDByCredentialsID() {
		reqSpec = new RequestSpecBuilder().addHeader("Content-Type","application/json").addPathParam("credentialID", strCredentialsID).build();
		Response response =	given().spec(reqSpec)
				.get(ApiResreqURL.valueOf("getSchemaIDByCredentialsID").returnResourcePath()).then().extract().response();

		objAPIview.getSchemaIDResponse(response);
		String actResponseCode=getConfig().getProperty("StatusCodeOK");
		boolean success=objAPIview.getSuccessMessageSchemaID();
		objcommonMethodsView.validateSuccessmessage(success);
		strCredentialSchemaID=objAPIview.getCredentialSchemaID();
		objcommonMethodsView.validateStatusCode(response, actResponseCode);
	}

	@Title("Get render schema")
	@Description("Get render schema")
	@Test(priority = 3)
	public void API_03_GetRenderSchema() {
		reqSpec = new RequestSpecBuilder().addHeader("Content-Type","application/json").addPathParam("credentialSchemaID", strCredentialSchemaID).build();
		responseRenderSchema =	given().spec(reqSpec)
				.get(ApiResreqURL.valueOf("getRenderSchema").returnResourcePath()).then().extract().response();

		objAPIview.getRenderSchemaResponse(responseRenderSchema);
		String actResponseCode=getConfig().getProperty("StatusCodeOK");
		strResultRenderSchema=objAPIview.getRenderSchema();
		boolean success=objAPIview.getSuccessMessageRenderSchema();
		objcommonMethodsView.validateSuccessmessage(success);
		objcommonMethodsView.validateStatusCode(responseRenderSchema, actResponseCode);
	}

	@Title("Get render schema template")
	@Description("Get render schema template")
	@Test(priority = 4)
	public void API_04_GetRenderSchemaTemplate() {
		reqSpec = new RequestSpecBuilder().addHeader("Content-Type","application/json").addPathParam("credentialSchemaID", strCredentialSchemaID).build();
		responseSchemaTemplate = given().spec(reqSpec)
				.get(ApiResreqURL.valueOf("getRenderSchemaTemplate").returnResourcePath()).then().extract().response();

		objAPIview.getSchemaTemplateResponse(responseSchemaTemplate);
		strSchemaTemplate = objAPIview.getSchemaTemplate();
		String actResponseCode=getConfig().getProperty("StatusCodeOK");
		boolean success= objAPIview.getSuccessMessageSchemaTemplate();
		objcommonMethodsView.validateSuccessmessage(success);
		objcommonMethodsView.validateStatusCode(responseSchemaTemplate, actResponseCode);
	}

	@Title("Credential render")
	@Description("Credentail render")
	@Test(priority = 5)
	public void API_05_CredentialRender() throws Exception {
		reqSpec = new RequestSpecBuilder().addHeader("Content-Type","application/json")
				.addHeader("Accept", "application/pdf").addHeader("DNT", "1").addHeader("sec-ch-ua", "\"Google Chrome\";v=\"113\", \"Chromium\";v=\"113\", \"Not-A.Brand\";v=\"24\"")
				.addHeader("sec-ch-ua-mobile", "?0").addHeader("User-Agent", "Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/113.0.0.0 Safari/537.36")
				.addHeader("Referer", "https://ulp-registration-portal.netlify.app/").addHeader("sec-ch-ua-platform", "Linux")
				.addHeader("Authorization", "Bearer " +objDigilockerEwalletTest.strTokenStudent).build();
		objAPIview.setBFFCredentialRenderRequest(strCredentials,strResultRenderSchema,strSchemaTemplate);
		Response response = given().spec(reqSpec).body(objAPIview.getBFFCredentialRenderRequest()).when()
				.post(ApiResreqURL.valueOf("postRenderCredentials").returnResourcePath()).then().extract().response();

		String actResponseCode=getConfig().getProperty("StatusCreated");
		objcommonMethodsView.validateStatusCode(response, actResponseCode);		
	}

	@Title("Verify user is able to search teacher")
	@Description("Verify user is able to search teacher")
	@Test(priority = 6)
	public void API_06_VerifyUserIsAbleToSearchTeacher() {
		reqSpec = new RequestSpecBuilder().addHeader("Content-Type","application/json").addHeader("Authorization", "Bearer " +objDigilockerportalTest.strTokenTeacher).build();
		objAPIview.setBFFCredentialSearchStudent(objDigilockerportalTest.strDIDTeacher);
		Response response =	given().spec(reqSpec).body(objAPIview.getBFFCredentialSearchStudent()).when()
				.post(ApiResreqURL.valueOf("postSearchTeacher").returnResourcePath()).then().extract().response();

		objAPIview.getSearchStudentResponse(response);
		String actResponseCode=getConfig().getProperty("StatusCodeOK");
		objcommonMethodsView.validateStatusCode(response, actResponseCode);
		boolean success =objAPIview.getSuccessMessageSearchStudent();
		objcommonMethodsView.validateSuccessmessage(success);
	}


}
