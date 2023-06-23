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
import com.generic.WrapperFunctions;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import ru.yandex.qatools.allure.annotations.Description;
import ru.yandex.qatools.allure.annotations.Title;

public class SBRCTest extends BaseTest {
	private RequestSpecification reqSpec = null;
	private String strDeleteToken;
	private String strOsid;
	private Response strresponse;
	private WrapperFunctions objWrapperFunctions;
	public static String strSBRCToken;
	// Initialize object
	private APIview objAPIview = new APIview(this);
	private commonMethodsView objcommonMethodsView = new commonMethodsView(this);

	@BeforeClass
	public void initializeEnvironment() {
		ConfigFileReader();
	}

//	@Title("Get Token")
//	@Description("Get Token")
//	@Test(priority = 1)
//	public void API_01_GetToken() {
//		reqSpec = new RequestSpecBuilder().addHeader("Content-Type", "application/json").build();
//		objAPIview.setGetSBRCTokenRequest(getConfig().getProperty("digiacc"),
//				getConfig().getProperty("strAdharIdToken"), getConfig().getProperty("strAdharNameToken"),
//				getConfig().getProperty("strAdharDobToken"), getConfig().getProperty("strAdhargenderToken"),
//				getConfig().getProperty("strdigilockerIDToken"));
//
//		Response responseToken = given().spec(reqSpec).body(objAPIview.getSBRCTokenRequest()).when()
//				.post(ApiResreqURL.valueOf("getToken").returnResourcePath()).then().extract().response();
//
//		testLevelLog.get().info("Get SBRC Token Response Data : " + responseToken.asString());
//		String actResponseCode = getConfig().getProperty("StatusCodeOK");
//		objcommonMethodsView.validateStatusCode(responseToken, actResponseCode);
//		System.out.println("Respone code:" + responseToken + ":" + actResponseCode);
//		objAPIview.getSBRCTokenResponse(responseToken);
//		strSBRCToken = objAPIview.getSBRCToken();
//	}

//	@Title("Get Token")
//    @Description("Get Token")
//    @Test(priority = 1)
//    public void API_01_GetToken() {
//        reqSpec = new RequestSpecBuilder().addHeader("Content-Type", "application/json").build();
//        objAPIview.setGetTokenRequest(getConfig().getProperty("password_GetToken"));
//        
//        Response response = given().spec(reqSpec).body(objAPIview.GetTokenRequest()).when()
//                .post(ApiResreqURL.valueOf("getToken").returnResourcePath()).then().extract().response();
//        
//        testLevelLog.get().info("Get Token Response Data : " + response.asString());
//        String actResponseCode = getConfig().getProperty("StatusCodeOK");
//        objcommonMethodsView.validateStatusCode(response, actResponseCode);
//        objAPIview.getTokenResponse(response);
//        strSBRCToken = objAPIview.getDeleteToken();
//    }
//	
//	
//	@Title("SBRC Search Student")
//	@Description("SBRC Search Student")
//	@Test(priority = 2)
//	public void API_02_SBRCSearchStudent() {
//		reqSpec = new RequestSpecBuilder().addHeader("Content-Type", "application/json")
//				.addHeader("Authorization", "Bearer " + strSBRCToken).build();
//
//		objAPIview.setSearchStudentRequest(getConfig().getProperty("schema_Student"),
//				getConfig().getProperty("studentName"));
//
//		strresponse = given().spec(reqSpec).body(objAPIview.getSearchStudentRequest()).when()
//				.post(ApiResreqURL.valueOf("postSBRCSearchStudent").returnResourcePath()).then().extract().response();
//
//		testLevelLog.get().info("Search Student Response Data : " + strresponse.asString());
//		testLevelLog.get().info("Verify status code :: " + strresponse.statusCode());
//		if (strresponse.statusCode() == 404) {
//			testLevelLog.get().info("Student is already deleted :: ");
//		} else {
//			objAPIview.getSBRCSearchStudentResponse(strresponse);
//			strOsid = objAPIview.getStudentOsid();
//			String actResponseCode = getConfig().getProperty("StatusCodeOK");
//			objcommonMethodsView.validateStatusCode(strresponse, actResponseCode);
//		}
//
//	}
//
//	@Title("SBRC Delete Student")
//	@Description("SBRC Delete Student")
//	@Test(priority = 3)
//	public void API_03_SBRCDeleteStudent() {
//		if (strresponse.statusCode() == 404) {
//			testLevelLog.get().info("Student is already deleted...!!!! ");
//		} else {
//			reqSpec = new RequestSpecBuilder().addHeader("Content-Type", "application/json")
//					.addHeader("Authorization", "Bearer " + strSBRCToken).build();
//			objAPIview.setDeleteStudentRequest(getConfig().getProperty("schema_Student"), strOsid);
//			int count = 0;
//			boolean success = false;
//			strresponse = null;
//			String actResponseCode;
//			do {
//				strresponse = given().spec(reqSpec).body(objAPIview.getDeleteStudentRequest()).when()
//						.post(ApiResreqURL.valueOf("postSBRCDeleteStudent").returnResourcePath()).then().extract()
//						.response();
//				testLevelLog.get().info("Delete Student Response Data : " + strresponse.asString());
//				objAPIview.getSBRCDeleteStudentResponse(strresponse);
//				success = objAPIview.getSuccessMessageDelete();
//				count++;
//				if (success == true && count == 6) {
//					break;
//				}
//			} while (success == false && count <= 6);
//			actResponseCode = getConfig().getProperty("StatusCodeOK");
//			objcommonMethodsView.validateStatusCode(strresponse, actResponseCode);
//
//		}
//
//	}
//
//	@Title("SBRC Search teacher")
//	@Description("SBRC search teacher")
//	@Test(priority = 4)
//	public void API_04_SBRCSearchTeacher() {
//
//		reqSpec = new RequestSpecBuilder().addHeader("Content-Type", "application/json")
//				.addHeader("Authorization", "Bearer " + strSBRCToken).build();
//
//		objAPIview.setSearchStudentRequest(getConfig().getProperty("schema_Teacher"),
//				getConfig().getProperty("studentName"));
//
//		strresponse = given().spec(reqSpec).body(objAPIview.getSearchStudentRequest()).when()
//				.post(ApiResreqURL.valueOf("postSBRCSearchStudent").returnResourcePath()).then().extract().response();
//
//		testLevelLog.get().info("Search Teacher Response Data : " + strresponse.asString());
//		testLevelLog.get().info("Verify status code :: " + strresponse.statusCode());
//		if (strresponse.statusCode() == 404) {
//			testLevelLog.get().info("Teacher is already deleted :: ");
//		} else {
//			objAPIview.getSBRCSearchStudentResponse(strresponse);
//			strOsid = objAPIview.getStudentOsid();
//			String actResponseCode = getConfig().getProperty("StatusCodeOK");
//			objcommonMethodsView.validateStatusCode(strresponse, actResponseCode);
//		}
//	}
//
//	@Title("SBRC Delete Teacher")
//	@Description("SBRC Delete Teacher")
//	@Test(priority = 3)
//	public void API_05_SBRCDeleteTeacher() {
//		if (strresponse.statusCode() == 404) {
//			testLevelLog.get().info("Teacher is already deleted...!!!! ");
//		} else {
//			reqSpec = new RequestSpecBuilder().addHeader("Content-Type", "application/json")
//					.addHeader("Authorization", "Bearer " + strSBRCToken).build();
//			objAPIview.setDeleteStudentRequest(getConfig().getProperty("schema_Teacher"), strOsid);
//			int count = 0;
//			boolean success = false;
//			strresponse = null;
//			String actResponseCode;
//			do {
//				strresponse = given().spec(reqSpec).body(objAPIview.getDeleteStudentRequest()).when()
//						.post(ApiResreqURL.valueOf("postSBRCDeleteStudent").returnResourcePath()).then().extract()
//						.response();
//				testLevelLog.get().info("Delete Teacher Response Data : " + strresponse.asString());
//				objAPIview.getSBRCDeleteStudentResponse(strresponse);
//				success = objAPIview.getSuccessMessageDelete();
//				count++;
//				if (success == true && count == 6) {
//					break;
//				}
//			} while (success == false && count <= 6);
//			actResponseCode = getConfig().getProperty("StatusCodeOK");
//			objcommonMethodsView.validateStatusCode(strresponse, actResponseCode);
//
//		}
//
//	}
}
