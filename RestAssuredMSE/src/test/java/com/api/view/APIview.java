package com.api.view;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import com.api.pojoRequests.ApprovalCredentialSubjectReq;
import com.api.pojoRequests.BffCredentialRenderRequest;
import com.api.pojoRequests.BffSearchStudentRequest;
import com.api.pojoRequests.Claim_status;
import com.api.pojoRequests.CredentialSubject;
import com.api.pojoRequests.DeleteStudentRequest;
import com.api.pojoRequests.DigiLockerLogoutRequest;
import com.api.pojoRequests.DigiLockerRequest;
import com.api.pojoRequests.DigiLockerSchoolListRequest;
import com.api.pojoRequests.Requestbody;
import com.api.pojoRequests.SearchStudentRequest;
import com.api.pojoRequests.Student;
import com.api.pojoRequests.Studentdetail;
import com.api.pojoRequests.Subject;
import com.api.pojoRequests.TeacherRegisterPortalrequest;
import com.api.pojoRequests.UserDataTeacher;
import com.api.pojoRequests.UserdataRegister;
import com.api.pojoRequests.VcData;
import com.api.pojoRequests.Filter;
import com.api.pojoRequests.Student_name;
import com.api.pojoRequests.countFields;
import com.api.pojoRequests.digilockerAdharRequest;
import com.api.pojoRequests.digilockerBlockListRequest;
import com.api.pojoRequests.digilockerDistrictListRequest;
import com.api.pojoRequests.digilockerRegisterEwalletRequest;
import com.api.pojoRequests.filters;
import com.api.pojoRequests.SBRCTokenRequest;
import com.api.pojoRequests.getTokenRequest;
import com.api.pojoRequests.portalVerifyUdiseRequest;
import com.api.pojoRequests.searchStudentForApprovalRequest;
import com.api.pojoRequests.searchStudentListApprovalRequest;
import com.api.pojoResponse.ApproveStudentResponse;
import com.api.pojoResponse.BffCredentialsSearchStudentsresponse;
import com.api.pojoResponse.BffGetRenderSchemaResponse;
import com.api.pojoResponse.BffGetSchemaIDResponse;
import com.api.pojoResponse.BffGetSchemaTemplateResponse;
import com.api.pojoResponse.Detail;
import com.api.pojoResponse.DigiLockerPortalTeacherRegisterResponse;
import com.api.pojoResponse.DigiLockerTokenEwalletResponse;
import com.api.pojoResponse.DigiLockerTokenPortalResponse;
import com.api.pojoResponse.DigilockerAdharEwalletResponse;
import com.api.pojoResponse.DigilockerGetDashboardResponse;
import com.api.pojoResponse.DigilockerGetStudentDataResponse;
import com.api.pojoResponse.DigilockerSchoolListResponse;
import com.api.pojoResponse.DigilockerStateListResponse;
import com.api.pojoResponse.GetTokenEwalletDIDResponse;
import com.api.pojoResponse.ResultRenderSchema;
import com.api.pojoResponse.ResultSchoolData;
import com.api.pojoResponse.ResultSearchStudent;
import com.api.pojoResponse.SBRCDeleteStudentResponse;
import com.api.pojoResponse.SBRCSearchStudentResponse;
import com.api.pojoResponse.SBRCSearchTeacherResponse;
import com.api.pojoResponse.SBRCTokenResposne;
import com.api.pojoResponse.SchoolDetailsResponse;
import com.api.pojoResponse.URLpage;
import com.api.pojoResponse.UdiseVerifyResponse;
import com.api.pojoResponse.UserData;
import com.api.pojoResponse.UserDataPortal;
import com.api.pojoResponse.digilockerRegisterResponse;
import com.api.pojoResponse.negativeResponse;

import com.generic.BaseTest;
import com.generic.Pojo;
import com.generic.WrapperFunctions;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import com.mongodb.client.model.Filters;
import com.api.pojoResponse.getTokenResponse;
import com.pageFactory.DigiLockerLoginPage;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Base64;
import io.restassured.response.Response;
import ru.yandex.qatools.allure.annotations.Step;

public class APIview {

	int iDistrict;

	private Pojo objPojo;
	private URLpage objURLpage;
	private DigiLockerLoginPage objDigiLockerLoginPage;
	private DigiLockerRequest objDigiLockerRequest;
	private digilockerAdharRequest objdigilockerAdharRequest;
	private DigiLockerTokenEwalletResponse objDigiLockerTokenEwalletResponse;
	private WrapperFunctions objWrapperFunctions;
	private DigilockerAdharEwalletResponse objDigilockerAdharEwalletResponse;
	private DigilockerStateListResponse objDigilockerStateListResponse;
	private digilockerDistrictListRequest objdigilockerDistrictListRequest;
	private digilockerBlockListRequest objdigilockerBlockListRequest;
	private DigiLockerSchoolListRequest objDigiLockerSchoolListRequest;
	private DigilockerSchoolListResponse objDigilockerSchoolListResponse;
	private DigiLockerLogoutRequest objDigiLockerLogoutRequest;
	private DigilockerGetStudentDataResponse objDigilockerGetStudentDataResponse;
	private countFields objcountFields;
	private DigilockerGetDashboardResponse objDigilockerGetDashboardResponse;
	private BffSearchStudentRequest objBffSearchStudentRequest;
	private BffCredentialsSearchStudentsresponse objBffCredentialsSearchStudentsresponse;
	private portalVerifyUdiseRequest objportalVerifyUdiseRequest;
	private UdiseVerifyResponse objUdiseVerifyResponse;
	private SchoolDetailsResponse objSchoolDetailsResponse;
	private BffGetSchemaIDResponse objBffGetSchemaIDResponse;
	private BffGetSchemaTemplateResponse objBffGetSchemaTemplateResponse;
	private BffGetRenderSchemaResponse objBffGetRenderSchemaResponse;
	private BffCredentialRenderRequest objBffCredentialRenderRequest;
	private negativeResponse objnegativeResponse;
	private digilockerRegisterEwalletRequest objdigilockerRegisterEwalletRequest;
	private digilockerRegisterResponse objdigilockerRegisterResponse;
	private TeacherRegisterPortalrequest objTeacherRegisterPortalrequest;
	private getTokenRequest objgetTokenRequest;
	private getTokenResponse objgetTokenResponse;
	private SearchStudentRequest objSearchStudentRequest;
	private SBRCSearchStudentResponse objSBRCSearchStudentResponse;
	private DeleteStudentRequest objDeleteStudentRequest;
	private DigiLockerTokenPortalResponse objDigiLockerTokenPortalResponse;
	private SBRCDeleteStudentResponse objSBRCDeleteStudentResponse;
	private BaseTest objBaseTest;
	private GetTokenEwalletDIDResponse objGetTokenEwalletDIDResponse;
	private searchStudentForApprovalRequest objsearchStudentForApprovalRequest;
	private SBRCSearchTeacherResponse objSBRCSearchTeacherResponse;
	private searchStudentListApprovalRequest objsearchStudentListApprovalRequest;
	private ApprovalCredentialSubjectReq objApprovalCredentialSubjectReq;
	private ApproveStudentResponse objApproveStudentResponse;
	private SBRCTokenRequest objSBRCTokenRequest;
	private SBRCTokenResposne objSBRCTokenResposne;
	private Claim_status objClaim_status;
	private DigiLockerPortalTeacherRegisterResponse objDigiLockerPortalTeacherRegisterResponse;

	public APIview(Pojo pojo) {
		this.objPojo = pojo;
		objURLpage = new URLpage();
		objDigiLockerRequest = new DigiLockerRequest();
		objDigiLockerTokenEwalletResponse = new DigiLockerTokenEwalletResponse();
		objDigiLockerLoginPage = new DigiLockerLoginPage(objPojo);
		objWrapperFunctions = new WrapperFunctions(objPojo);
		objdigilockerAdharRequest = new digilockerAdharRequest();
		objDigilockerAdharEwalletResponse = new DigilockerAdharEwalletResponse();
		objDigilockerStateListResponse = new DigilockerStateListResponse();
		objdigilockerDistrictListRequest = new digilockerDistrictListRequest();
		objdigilockerBlockListRequest = new digilockerBlockListRequest();
		objDigiLockerSchoolListRequest = new DigiLockerSchoolListRequest();
		objDigilockerSchoolListResponse = new DigilockerSchoolListResponse();
		objDigiLockerLogoutRequest = new DigiLockerLogoutRequest();
		objDigilockerGetStudentDataResponse = new DigilockerGetStudentDataResponse();
		objcountFields = new countFields();
		objDigilockerGetDashboardResponse = new DigilockerGetDashboardResponse();
		objBffSearchStudentRequest = new BffSearchStudentRequest();
		objBffCredentialsSearchStudentsresponse = new BffCredentialsSearchStudentsresponse();
		objportalVerifyUdiseRequest = new portalVerifyUdiseRequest();
		objUdiseVerifyResponse = new UdiseVerifyResponse();
		objSchoolDetailsResponse = new SchoolDetailsResponse();
		objBffGetSchemaIDResponse = new BffGetSchemaIDResponse();
		objBffGetSchemaTemplateResponse = new BffGetSchemaTemplateResponse();
		objBffGetRenderSchemaResponse = new BffGetRenderSchemaResponse();
		objBffCredentialRenderRequest = new BffCredentialRenderRequest();
		objnegativeResponse = new negativeResponse();
		objdigilockerRegisterEwalletRequest = new digilockerRegisterEwalletRequest();
		objdigilockerRegisterResponse = new digilockerRegisterResponse();
		objTeacherRegisterPortalrequest = new TeacherRegisterPortalrequest();
		objgetTokenRequest = new getTokenRequest();
		objgetTokenResponse = new getTokenResponse();
		objSearchStudentRequest = new SearchStudentRequest();
		objSBRCSearchStudentResponse = new SBRCSearchStudentResponse();
		objDeleteStudentRequest = new DeleteStudentRequest();
		objDigiLockerTokenPortalResponse = new DigiLockerTokenPortalResponse();
		objSBRCDeleteStudentResponse = new SBRCDeleteStudentResponse();
		objGetTokenEwalletDIDResponse = new GetTokenEwalletDIDResponse();
		objsearchStudentForApprovalRequest = new searchStudentForApprovalRequest();
		objBaseTest = new BaseTest();
		objSBRCSearchTeacherResponse = new SBRCSearchTeacherResponse();
		objsearchStudentListApprovalRequest = new searchStudentListApprovalRequest();
		objApprovalCredentialSubjectReq = new ApprovalCredentialSubjectReq();
		objApproveStudentResponse = new ApproveStudentResponse();
		objSBRCTokenRequest = new SBRCTokenRequest();
		objSBRCTokenResposne = new SBRCTokenResposne();
		objClaim_status = new Claim_status();
		objDigiLockerPortalTeacherRegisterResponse = new DigiLockerPortalTeacherRegisterResponse();
	}

	/**
	 * Author: Snehal kadam API_01_VerifyUserIsAbleToGenerateDigiUrl
	 */
	public String createAPIFromPojo(Object objPojoApi) {
		ObjectMapper objectMapper = new ObjectMapper();
		String addPlaceJson = "";
		try {
			addPlaceJson = objectMapper.writeValueAsString(objPojoApi);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return addPlaceJson;
	}

	public void getDigiurlResponse(Response response) {
		ObjectMapper objMapper = new ObjectMapper();
		try {
			objURLpage = objMapper.readValue(response.asString(), URLpage.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		objWrapperFunctions.logReporter("get response:", response.asPrettyString(), true);
	}

	public String getDigilockerUrl() {
		String strDigilockerURL = objURLpage.getDigiauthurl();
		objWrapperFunctions.logReporter("Get Digilocker URL", strDigilockerURL, true);
		return strDigilockerURL;

	}

	/**
	 * Author: Snehal kadam API_02_VerifyUserIsAbleToGenerateAuthCode
	 * 
	 * @throws InterruptedException
	 */

	public String EnterDetailsOnDigilockerLoginPageUsingMobile(String strMobileNo, String strPin)
			throws InterruptedException {
		objDigiLockerLoginPage.setMobileNo(strMobileNo);
		objDigiLockerLoginPage.setUserPin(strPin);
		objDigiLockerLoginPage.selectCheckbox();
		objDigiLockerLoginPage.clickOnSignInbutton();
		Thread.sleep(5);
		objDigiLockerLoginPage.clickOnAllowButton();

		String strAuthCode = objDigiLockerLoginPage.getAuthCode();
		return strAuthCode;
	}

	/**
	 * Author: Snehal kadam API_03_VerifyUserIsAbleToGenerateToken
	 */

	public void setDigiLockerRequest(String strDigiacc, String strAuthCode) {
		objDigiLockerRequest.setDigiacc(strDigiacc);
		objDigiLockerRequest.setAuth_code(strAuthCode);
		String str = this.createAPIFromPojo(objDigiLockerRequest);
		objWrapperFunctions.logReporter("Set Request:", str, true);
	}

	public DigiLockerRequest getDigiLockerRequest() {
		return objDigiLockerRequest;

	}

	public void getDigiLockerTokenEwalletResponse(Response response) {
		ObjectMapper objMapper = new ObjectMapper();
		try {
			objDigiLockerTokenEwalletResponse = objMapper.readValue(response.asString(),
					DigiLockerTokenEwalletResponse.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		objWrapperFunctions.logReporter("get response:", response.asPrettyString(), true);
	}

	public void getOsid(Response response) {
		ObjectMapper objMapper = new ObjectMapper();
		try {
			objDigiLockerTokenEwalletResponse = objMapper.readValue(response.asString(),
					DigiLockerTokenEwalletResponse.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		objWrapperFunctions.logReporter("get response:", response.asPrettyString(), true);
	}
//	public String getOsidSchool() {
//		String strosid = objDigiLockerTokenEwalletResponse.getDetail().getOsid();
//		objWrapperFunctions.logReporter("get school osid",strosid , true);
//		return strosid;
//	}

	public void getDigiLockerTokenEwalletDIDResponse(Response response) {
		ObjectMapper objMapper = new ObjectMapper();
		try {
			objGetTokenEwalletDIDResponse = objMapper.readValue(response.asString(), GetTokenEwalletDIDResponse.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		objWrapperFunctions.logReporter("get response:", response.asPrettyString(), true);
	}

	public String getStudentName() {
		String strStudentName = objDigiLockerTokenEwalletResponse.getResult().getName();
		objWrapperFunctions.logReporter("Get StudentName ", strStudentName, true);
		return strStudentName;
	}

	public String getmobileNo() {
		String strmobileNo = objDigiLockerTokenEwalletResponse.getResult().getMobile();
		objWrapperFunctions.logReporter("Get StudentName ", strmobileNo, true);
		return strmobileNo;
	}

	public String getDOB() {
		String strDOB = objDigiLockerTokenEwalletResponse.getResult().getDob();
		objWrapperFunctions.logReporter("Get StudentName ", strDOB, true);
		return strDOB;
	}

	public String getGender() {
		String strGender = objDigiLockerTokenEwalletResponse.getResult().getGender();
		objWrapperFunctions.logReporter("Get StudentName ", strGender, true);
		return strGender;
	}

	public String getToken() {
		String strToken = objDigiLockerTokenEwalletResponse.getToken();
		objWrapperFunctions.logReporter("Get Token ", strToken, true);
		return strToken;
	}

	public String getMeripehchanID() {
		String strMeriPehchanID = objDigiLockerTokenEwalletResponse.getResult().getMeripehchanid();
		return strMeriPehchanID;
	}

	public boolean getSuccessMessage() {
		boolean strSuccess = objDigiLockerTokenEwalletResponse.getSuccess();
		// objWrapperFunctions.logReporter("Get Success ", strSuccess);
		return strSuccess;
	}

	public boolean getFailedMessage() {
		boolean strSuccess = objDigiLockerTokenEwalletResponse.getSuccess();
		objWrapperFunctions.logReporterFalseScenario("Get Success ", strSuccess);
		return strSuccess;
	}

	public String getAccessToken() {
		String strAccesstoken = objDigiLockerTokenEwalletResponse.getDigi().getAccess_token();
		objWrapperFunctions.logReporter("Get Access Token ", strAccesstoken, true);
		return strAccesstoken;
	}

	public String getDID() {
		String strDID = objGetTokenEwalletDIDResponse.getUserData().get(0).getDID();
		objWrapperFunctions.logReporter("Get DID ", strDID, true);
		return strDID;
	}

	public boolean getSuccessMessageDID() {
		boolean strSuccess = objGetTokenEwalletDIDResponse.getSuccess();
		objWrapperFunctions.logReporter("Get Success ", strSuccess);
		return strSuccess;
	}

	// Teacher
	public void getDigiLockerTokenPortalResponse(Response response) {
		ObjectMapper objMapper = new ObjectMapper();
		try {
			objDigiLockerTokenPortalResponse = objMapper.readValue(response.asString(),
					DigiLockerTokenPortalResponse.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		objWrapperFunctions.logReporter("get response:", response.asPrettyString(), true);
	}

	public String getmobileNoPortal() {
		String strmobileNo = objDigiLockerTokenPortalResponse.getResult().getMobile();
		objWrapperFunctions.logReporter("Get StudentName ", strmobileNo, true);
		return strmobileNo;
	}

	public String getDOBPortal() {
		String strDOB = objDigiLockerTokenPortalResponse.getResult().getDob();
		objWrapperFunctions.logReporter("Get StudentName ", strDOB, true);
		return strDOB;
	}

	public String getGenderPortal() {
		String strGender = objDigiLockerTokenPortalResponse.getResult().getGender();
		objWrapperFunctions.logReporter("Get StudentName ", strGender, true);
		return strGender;
	}

	public String getTeacherName() {
		String strName = objDigiLockerTokenPortalResponse.getResult().getName();
		objWrapperFunctions.logReporter("Get Teacher Name ", strName, true);
		return strName;
	}

	public String getudise() {
		String strudise = objDigiLockerTokenPortalResponse.getUserData().getTeacher().getSchoolUdise();
		objWrapperFunctions.logReporter("Get udise ", strudise, true);
		return strudise;
	}

	public String getMeripehchanIDPortal() {
		String strMeriPehchanID = objDigiLockerTokenPortalResponse.getResult().getMeripehchanid();
		return strMeriPehchanID;
	}

	public String getTokenTeacher() {
		String strToken = objDigiLockerTokenPortalResponse.getToken();
		objWrapperFunctions.logReporter("Get Token ", strToken, true);
		return strToken;
	}

	public String getDIDTeacher() {
		String strDID = objDigiLockerTokenPortalResponse.getUserData().getTeacher().getDid();
		objWrapperFunctions.logReporter("Get DID teacher", strDID, true);
		return strDID;
	}

	public String getDIDSchool() {
		String strDID = objDigiLockerTokenPortalResponse.getUserData().getSchool().getDid();
		objWrapperFunctions.logReporter("Get DID school", strDID, true);
		return strDID;
	}

	public String getAccessTokenTeacher() {
		String strAccesstoken = objDigiLockerTokenPortalResponse.getDigi().getAccess_token();
		objWrapperFunctions.logReporter("Get Access Token ", strAccesstoken, true);
		return strAccesstoken;
	}

	public boolean getSuccessMessagePortal() {
		boolean strSuccess = objDigiLockerTokenPortalResponse.getSuccess();
		// objWrapperFunctions.logReporter("Get Success ", strSuccess);
		return strSuccess;
	}

	/**
	 * Author: Snehal kadam API_03_VerifyUserIsAbleToGenerateToken
	 * 
	 * @param strAdharID
	 */

	public void setDigiLockerAdharRequest(String strDigiacc, String strAdharName, String strAdhargender,
			String strAdharDob, String strdigilockerID, String strAdharID) {
//		String strAdharID= "123456"+objWrapperFunctions.getRandomStringWithNumbers(6);
		objdigilockerAdharRequest.setDigiacc(strDigiacc);
		objdigilockerAdharRequest.setAadhaar_id(strAdharID);
		objdigilockerAdharRequest.setAadhaar_name(strAdharName);
		objdigilockerAdharRequest.setAadhaar_gender(strAdhargender);
		objdigilockerAdharRequest.setAadhaar_dob(strAdharDob);
		objdigilockerAdharRequest.setDigilocker_id(strdigilockerID);

		String str = this.createAPIFromPojo(objdigilockerAdharRequest);
		objWrapperFunctions.logReporter("Set Request:", str, true);
		System.out.println(str);
	}

	public digilockerAdharRequest getDigiLockerAdharRequest() {
		return objdigilockerAdharRequest;
	}

	public void getDigiLockerAdharEwalletResponse(Response response) {
		ObjectMapper objMapper = new ObjectMapper();
		try {
			objDigilockerAdharEwalletResponse = objMapper.readValue(response.asString(),
					DigilockerAdharEwalletResponse.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		objWrapperFunctions.logReporter("get response:", response.asPrettyString(), true);
	}

	public boolean getSuccessMessageAdhar() {
		boolean strSuccess = objDigilockerAdharEwalletResponse.getSuccess();
		objWrapperFunctions.logReporter("Get Success ", strSuccess);
		return strSuccess;
	}

	public boolean getFailureMessageAdhar() {
		boolean strSuccess = objDigilockerAdharEwalletResponse.getSuccess();
		objWrapperFunctions.logReporterFalseScenario("Get Failure", strSuccess);
		return strSuccess;
	}

	public String getUuid() {
		String strUuid = objDigilockerAdharEwalletResponse.getResult().getUuid();
		objWrapperFunctions.logReporter("Get Uuid ", strUuid, true);
		return strUuid;
	}

	/**
	 * Author: Snehal kadam API_07_VerifyUserIsAbleToGenerateAuthCode(using
	 * Username)
	 */

	public String EnterDetailsOnDigilockerLoginPageUsingUsername(String strusername, String strPin) {
		objDigiLockerLoginPage.clickOnUseNameTab();
		objDigiLockerLoginPage.setUsername(strusername);
		objDigiLockerLoginPage.setUserPassword(strPin);
		objDigiLockerLoginPage.selectCheckboxUsername();
		objDigiLockerLoginPage.clickOnSignInbuttonUsername();
		objDigiLockerLoginPage.clickOnAllowButton();
		String strAuthCode = objDigiLockerLoginPage.getAuthCode();
		return strAuthCode;
	}

	/**
	 * Author: Snehal kadam API_05_VerifyUserIsAbleToGetStateList
	 */

	public void getListResponse(Response response) {
		ObjectMapper objMapper = new ObjectMapper();
		try {
			objDigilockerStateListResponse = objMapper.readValue(response.asString(),
					DigilockerStateListResponse.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		objWrapperFunctions.logReporter("get response:", response.asPrettyString(), true);

	}

	public boolean getStatus() {
		boolean strStatus = objDigilockerStateListResponse.getStatus();
		objWrapperFunctions.logReporter("Get Status ", strStatus);
		return strStatus;
	}

	public String getStateCode() {
		String strStateCode = objDigilockerStateListResponse.getResponse().getData().get(21).getStateCode();
		objWrapperFunctions.logReporter("Get State Code ", strStateCode, true);
		return strStateCode;

	}

	public String getStateName() {
		String strStateCode = objDigilockerStateListResponse.getResponse().getData().get(21).getStateName();
		objWrapperFunctions.logReporter("Get State Code ", strStateCode, true);
		return strStateCode;

	}

	/**
	 * Author: Snehal kadam API_06_VerifyUserIsAbleToGetDistrictList
	 */

	public void setDigiLockerDistrictRequest(String strStateCode) {
		objdigilockerDistrictListRequest.setStateCode(strStateCode);
		String str = this.createAPIFromPojo(objdigilockerDistrictListRequest);
		objWrapperFunctions.logReporter("Set Request:", str, true);
	}

	public void setDigiLockerNegativeDistrictRequest(String strStateCode) {
		strStateCode = strStateCode + objWrapperFunctions.getRandomStringWithNumbers(1);
		objdigilockerDistrictListRequest.setStateCode(strStateCode);
		String str = this.createAPIFromPojo(objdigilockerDistrictListRequest);
		objWrapperFunctions.logReporter("Set Request:", str, true);
	}

	public digilockerDistrictListRequest getDigiLockerDistrictRequest() {
		return objdigilockerDistrictListRequest;
	}

//	public String getDistrictCode() {
//		String str=objWrapperFunctions.getRandomStringWithNumbers(1);
//		iDistrict=Integer.parseInt(str);  
//		String strDistrictCode = objDigilockerStateListResponse.getResponse().getData().get(iDistrict).getDistrictCode();
//		objWrapperFunctions.logReporter("Get District Code ", strDistrictCode, true);
//		return strDistrictCode;
//	}
//	public String getDistrictName() {
//		String strDistrictCode = objDigilockerStateListResponse.getResponse().getData().get(iDistrict).getDistrictName();
//		objWrapperFunctions.logReporter("Get District Code ", strDistrictCode, true);
//		return strDistrictCode;
//
//	}

	public void setDigiLockerBlockRequest(String strDistrictCode) {
		objdigilockerBlockListRequest.setDistrictCode(strDistrictCode);
		String str = this.createAPIFromPojo(objdigilockerBlockListRequest);
		objWrapperFunctions.logReporter("Set Request:", str, true);
	}

	public void setDigiLockerNegativeBlockRequest(String strDistrictCode) {
		strDistrictCode = objWrapperFunctions.getRandomStringWithNumbers(3);
		objdigilockerBlockListRequest.setDistrictCode(strDistrictCode);
		String str = this.createAPIFromPojo(objdigilockerBlockListRequest);
		objWrapperFunctions.logReporter("Set Request:", str, true);
	}

	public digilockerBlockListRequest getdigilockerBlockListRequest() {
		return objdigilockerBlockListRequest;
	}

	public String getBlockCode() {
		String strDistrictCode = objDigilockerStateListResponse.getResponse().getData().get(iDistrict).getBlockCode();
		objWrapperFunctions.logReporter("Get Block Code ", strDistrictCode, true);
		return strDistrictCode;

	}

	public String getBlockName() {
		String strDistrictCode = objDigilockerStateListResponse.getResponse().getData().get(iDistrict).getBlockName();
		objWrapperFunctions.logReporter("Get Block Code ", strDistrictCode, true);
		return strDistrictCode;

	}

	public void setDigiLockerSchoolListRequest(String strRegionType, String strDistrictCode, String strSortBy) {
		objDigiLockerSchoolListRequest.setRegionType(strRegionType);
		objDigiLockerSchoolListRequest.setRegionCd(strDistrictCode);
		objDigiLockerSchoolListRequest.setSortBy(strSortBy);
		String str = this.createAPIFromPojo(objDigiLockerSchoolListRequest);
		objWrapperFunctions.logReporter("Set Request:", str, true);
	}

	public void setDigiLockerNegativeSchoolListRequest(String strRegionType, String strDistrictCode, String strSortBy) {
		strDistrictCode = strDistrictCode + objWrapperFunctions.getRandomStringWithNumbers(1);
		objDigiLockerSchoolListRequest.setRegionType(strRegionType);
		objDigiLockerSchoolListRequest.setRegionCd(strDistrictCode);
		objDigiLockerSchoolListRequest.setSortBy(strSortBy);
		String str = this.createAPIFromPojo(objDigiLockerSchoolListRequest);
		objWrapperFunctions.logReporter("Set Request:", str, true);
	}

	public DigiLockerSchoolListRequest getDigiLockerSchoolListRequest() {
		return objDigiLockerSchoolListRequest;
	}

	public void getSchoolListResponse(Response response) {
		ObjectMapper objMapper = new ObjectMapper();
		try {
			objDigilockerSchoolListResponse = objMapper.readValue(response.asString(),
					DigilockerSchoolListResponse.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		objWrapperFunctions.logReporter("get response:", response.asPrettyString(), true);
	}

	public boolean getStatusSchoolList() {
		boolean strStatus = objDigilockerSchoolListResponse.getStatus();
		objWrapperFunctions.logReporter("Get Status ", strStatus);
		return strStatus;
	}

	public String getUdiseCode() {
		String strUdiseCode = objDigilockerSchoolListResponse.getResponse().getDataSchool().getPagingContent()
				.get(iDistrict).getUdiseCode();
		objWrapperFunctions.logReporter("Get Udise Code ", strUdiseCode, true);
		return strUdiseCode;
	}

	public String getSchoolName() {
		String strUdiseCode = objDigilockerSchoolListResponse.getResponse().getDataSchool().getPagingContent()
				.get(iDistrict).getSchoolName();
		objWrapperFunctions.logReporter("Get Udise Code ", strUdiseCode, true);
		return strUdiseCode;
	}

	public void setDigiLockerLogoutRequest(String strDigiacc, String strAccessToken) {
		objDigiLockerLogoutRequest.setDigiacc(strDigiacc);
		objDigiLockerLogoutRequest.setAccess_token(strAccessToken);
		String str = this.createAPIFromPojo(objDigiLockerLogoutRequest);
		objWrapperFunctions.logReporter("Set Request:", str, true);
	}

	public void setDigiLockerNegativeLogoutRequest(String strDigiacc, String strAccessToken) {
		strDigiacc = strDigiacc + objWrapperFunctions.getRandomStringWithNumbers(1);
		objDigiLockerLogoutRequest.setDigiacc(strDigiacc);
		objDigiLockerLogoutRequest.setAccess_token(strAccessToken);
		String str = this.createAPIFromPojo(objDigiLockerLogoutRequest);
		objWrapperFunctions.logReporter("Set Request:", str, true);
	}

	public DigiLockerLogoutRequest getDigiLockerLogoutRequest() {

		return objDigiLockerLogoutRequest;
	}

	public void getStudentDataResponse(Response response) {
		ObjectMapper objMapper = new ObjectMapper();
		try {
			objDigilockerGetStudentDataResponse = objMapper.readValue(response.asString(),
					DigilockerGetStudentDataResponse.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		objWrapperFunctions.logReporter("get response:", response.asPrettyString(), true);
	}

	public String getStudentOsid() {
		String strosid = objSBRCSearchStudentResponse.getResult().get(0).getOsid();
		objWrapperFunctions.logReporter("Get OSID ", strosid, true);
		return strosid;
	}

	public boolean getSuccessMessageStudentData() {
		boolean strSuccess = objDigilockerGetStudentDataResponse.getSuccess();
		objWrapperFunctions.logReporter("Get Success message ", strSuccess);
		return strSuccess;
	}

	public void setCountFieldsRequest() {
		ArrayList<String> countFields = new ArrayList<String>();
		countFields.add("claims_approved");
		countFields.add("claims_pending");
		countFields.add("claims_rejected");
		countFields.add("credentials_issued");
		countFields.add("students_registered");

		objcountFields.setCountFields(countFields);
		String str = this.createAPIFromPojo(objcountFields);
		objWrapperFunctions.logReporter("Set Request:", str, true);
	}

	public countFields getCountFieldsRequest() {
		return objcountFields;
	}

	public void getDigiLockerDashboardCountResponse(Response response) {
		ObjectMapper objMapper = new ObjectMapper();
		try {
			objDigilockerGetDashboardResponse = objMapper.readValue(response.asString(),
					DigilockerGetDashboardResponse.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		objWrapperFunctions.logReporter("get response:", response.asPrettyString(), true);
	}

	public boolean getSuccessMessageDashboardCount() {
		boolean strSuccess = objDigilockerGetDashboardResponse.getSuccess();
		objWrapperFunctions.logReporter("Get Success message ", strSuccess);
		return strSuccess;
	}

	/* Updated  by : tejal 
	 * Use for teacher and student both 
	 */
	public void setBFFCredentialSearchStudentAndTeacher(String strDID) {
		Subject objSubject = new Subject();
		objSubject.setId(strDID);
		objBffSearchStudentRequest.setSubject(objSubject);
		String str = this.createAPIFromPojo(objBffSearchStudentRequest);
		objWrapperFunctions.logReporter("Set Request BFF Search:", str, true);
	}

	/* 
	 * Use for teacher and student both 
	 */
	public BffSearchStudentRequest getBFFCredentialSearchStudent() {
		return objBffSearchStudentRequest;
	}

	public void getSearchStudentResponse(Response response) {
		ObjectMapper objMapper = new ObjectMapper();
		try {
			objBffCredentialsSearchStudentsresponse = objMapper.readValue(response.asString(),
					BffCredentialsSearchStudentsresponse.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		objWrapperFunctions.logReporter("get response:", response.asPrettyString(), true);
	}

	public String getCredentialID() {
		String strCredentialsID = objBffCredentialsSearchStudentsresponse.getResult().get(0).getId();
		objWrapperFunctions.logReporter("Get Credentials ID ", strCredentialsID, true);
		return strCredentialsID;
	}

	public ResultSearchStudent getResultCredentials() {
		ResultSearchStudent ResultSearchStudent = objBffCredentialsSearchStudentsresponse.getResult().get(0);
		// ArrayList<ResultSearchStudent> strCredentialsID = new
		// ArrayList<ResultSearchStudent>();
		// strCredentialsID.add(ResultSearchStudent);

		// //System.out.println("Get Response::::::::::::"+ strCredentialsID.get(0));
		// for(int i = 0; i < 1; i++) {
		// System.out.println(strCredentialsID.get(i).getId());
		// System.out.println(strCredentialsID.get(i).getIssuanceDate());
		// System.out.println(strCredentialsID.get(i).getExpirationDate());
		// System.out.println(strCredentialsID.get(i).getType());
		// System.out.println(strCredentialsID.get(i).getCredentialSubject().getId());
		// System.out.println(strCredentialsID.get(i).getCredentialSubject().getAadhar_token());
		// }
		return ResultSearchStudent;
	}

	public void setResultCredentials(List<ResultSearchStudent> strCredentialsID) {
		objBffCredentialsSearchStudentsresponse.setResult(strCredentialsID);
		System.out.println("SetResponse::::::::::::" + strCredentialsID);
	}

	public boolean getSuccessMessageSearchStudent() {
		boolean strSuccess = objBffCredentialsSearchStudentsresponse.getSuccess();
		objWrapperFunctions.logReporter("Get Success message ", strSuccess);
		return strSuccess;
	}

	public void setUdiseVerifyRequest(String password, String strUdiseCode) {
		objportalVerifyUdiseRequest.setPassword(password);
		objportalVerifyUdiseRequest.setRequestbody(new Requestbody());
		objportalVerifyUdiseRequest.getRequestbody().setUdiseCode(strUdiseCode);
		String str = this.createAPIFromPojo(objportalVerifyUdiseRequest);
		objWrapperFunctions.logReporter("Set Request:", str, true);
	}

	public void setUdiseVerifyNegativeRequest(String password, String strUdiseCode) {
		strUdiseCode = strUdiseCode + objWrapperFunctions.getRandomStringWithNumbers(1);
		objportalVerifyUdiseRequest.setPassword(password);
		objportalVerifyUdiseRequest.setRequestbody(new Requestbody());
		objportalVerifyUdiseRequest.getRequestbody().setUdiseCode(strUdiseCode);
		String str = this.createAPIFromPojo(objportalVerifyUdiseRequest);
		objWrapperFunctions.logReporter("Set Request:", str, true);
	}

	public portalVerifyUdiseRequest getUdiseVerifyRequest() {
		return objportalVerifyUdiseRequest;
	}

	public void getUdiseVerifyResponse(Response response) {
		ObjectMapper objMapper = new ObjectMapper();
		try {
			objUdiseVerifyResponse = objMapper.readValue(response.asString(), UdiseVerifyResponse.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		objWrapperFunctions.logReporter("get response:", response.asPrettyString(), true);
	}

	public boolean getSuccessStatusUdiseVerify() {
		boolean strSuccess = objUdiseVerifyResponse.getStatus();
		objWrapperFunctions.logReporter("Get Success message ", strSuccess);
		return strSuccess;

	}

	public void getSchoolDetailsResponse(Response response) {
		ObjectMapper objMapper = new ObjectMapper();
		try {
			objSchoolDetailsResponse = objMapper.readValue(response.asString(), SchoolDetailsResponse.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		objWrapperFunctions.logReporter("get response:", response.asPrettyString(), true);
	}

	public String getOsidSchool() {
		String strosid = objSchoolDetailsResponse.getResult().getOsid();
		objWrapperFunctions.logReporter("get school OSID:", strosid, true);
		return strosid;
	}

	public boolean getSuccessSchoolDetails() {
		boolean strSuccess = objSchoolDetailsResponse.getSuccess();
		objWrapperFunctions.logReporter("Get Success message ", strSuccess);
		return strSuccess;
	}

	public void getSchemaIDResponse(Response response) {
		ObjectMapper objMapper = new ObjectMapper();
		try {
			objBffGetSchemaIDResponse = objMapper.readValue(response.asString(), BffGetSchemaIDResponse.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		objWrapperFunctions.logReporter("get response:", response.asPrettyString(), true);

	}

	public boolean getSuccessMessageSchemaID() {
		boolean strSuccess = objBffGetSchemaIDResponse.getSuccess();
		objWrapperFunctions.logReporter("Get Success message ", strSuccess);
		return strSuccess;
	}

	public String getCredentialSchemaID() {
		String strSchemaID = objBffGetSchemaIDResponse.getResult().getCredential_schema();
		objWrapperFunctions.logReporter("Get Schema ID ", strSchemaID, true);
		return strSchemaID;
	}

	public void getSchemaTemplateResponse(Response response) {
		ObjectMapper objMapper = new ObjectMapper();
		try {
			objBffGetSchemaTemplateResponse = objMapper.readValue(response.asString(),
					BffGetSchemaTemplateResponse.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		objWrapperFunctions.logReporter("get response:", response.asPrettyString(), true);

	}

	public String getSchemaTemplate() {
		String strTemplate = objBffGetSchemaTemplateResponse.getResult().get(0).getTemplate();
		objWrapperFunctions.logReporter("Get Template ", strTemplate, true);
		return strTemplate;

	}

	public boolean getSuccessMessageSchemaTemplate() {
		boolean strSuccess = objBffGetSchemaTemplateResponse.getSuccess();
		objWrapperFunctions.logReporter("Get Success message ", strSuccess);
		return strSuccess;

	}

	public void getRenderSchemaResponse(Response response) {
		ObjectMapper objMapper = new ObjectMapper();
		try {
			objBffGetRenderSchemaResponse = objMapper.readValue(response.asString(), BffGetRenderSchemaResponse.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		objWrapperFunctions.logReporter("get response:", response.asPrettyString(), true);
	}

	public boolean getSuccessMessageRenderSchema() {
		boolean strSuccess = objBffGetRenderSchemaResponse.getSuccess();
		objWrapperFunctions.logReporter("Get Success message ", strSuccess);
		return strSuccess;

	}

	public ResultRenderSchema getRenderSchema() {
		ResultRenderSchema strSuccess = objBffGetRenderSchemaResponse.getResult();
		return strSuccess;
	}

	public void setBFFCredentialRenderRequest(ResultSearchStudent strCredentials,
			ResultRenderSchema strResultRenderSchema, String strSchemaTemplate) {

		objBffCredentialRenderRequest.setCredential(strCredentials);
		objBffCredentialRenderRequest.setSchema(strResultRenderSchema);
		objBffCredentialRenderRequest.setTemplate(strSchemaTemplate);
		objBffCredentialRenderRequest.setOutput("HTML");
		String str = this.createAPIFromPojo(objBffCredentialRenderRequest);
		objWrapperFunctions.logReporter("Set Request:", str, true);
	}

	public BffCredentialRenderRequest getBFFCredentialRenderRequest() {
		return objBffCredentialRenderRequest;
	}

	public void pdfFileDownload(String response) throws IOException, Exception {
		// Document doc = new Document();
		File outputImageFile = new File(
				"C:\\Users\\SNEHAL\\Desktop\\tekdi workspace\\RestAssuredMSE\\src\\test\\resources\\download\\ID.pdf");
		try (FileOutputStream fos = new FileOutputStream(outputImageFile);) {
			// To be short I use a corrupted PDF string, so make sure to use a valid one if
			// you want to preview the PDF file
			// String b64 =
			// "JVBERi0xLjUKJYCBgoMKMSAwIG9iago8PC9GaWx0ZXIvRmxhdGVEZWNvZGUvRmlyc3QgMTQxL04gMjAvTGVuZ3==";
			byte[] decoder = Base64.getDecoder().decode(response);

			fos.write(decoder);
			System.out.println("PDF File Saved");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void getListNegativeResponse(Response response) {
		ObjectMapper objMapper = new ObjectMapper();
		try {
			objnegativeResponse = objMapper.readValue(response.asString(), negativeResponse.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		objWrapperFunctions.logReporter("get response:", response.asPrettyString(), true);
	}

	public boolean getFalseMessage() {
		boolean strSuccess = objnegativeResponse.getStatus();
		objWrapperFunctions.logReporterFalseScenario("Get Success message ", strSuccess);
		return strSuccess;

	}

	public Detail getStudentDetail() {
		Detail strStudentDetail = objDigiLockerTokenEwalletResponse.getDetail();
		return strStudentDetail;
	}

	// public void setDigiLockerRegisterStudentRequest(String strDigiacc,
	// ArrayList<UserData> strUserData,
	// Detail strStudentDetail, String strMeriPehchanID) {
	//
	// objdigilockerRegisterEwalletRequest.setDigiacc(strDigiacc);
	// UserdataRegister userData=new UserdataRegister();
	// userData.setStudent(strUserData);
	// objdigilockerRegisterEwalletRequest.setUserdata(userData);
	// userData.setStudentdetail(strStudentDetail);
	// objdigilockerRegisterEwalletRequest.setUserdata(userData);
	// objdigilockerRegisterEwalletRequest.setDigimpid(strMeriPehchanID);
	// String str = this.createAPIFromPojo(objdigilockerRegisterEwalletRequest);
	// objWrapperFunctions.logReporter("Set Request register student:", str, true);
	//
	// }

	public void getRegisterEwalletResponse(Response response) {
		ObjectMapper objMapper = new ObjectMapper();
		try {
			objdigilockerRegisterResponse = objMapper.readValue(response.asString(), digilockerRegisterResponse.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		objWrapperFunctions.logReporter("get response:", response.asPrettyString(), true);

	}

	public void setDigiLockerRegisterTeacherRequest(String digiacc, String StudentID, String DID, String strMobileNo,
			String Adhartoken, String strTeacherName, String strDOB, String SchoolType, String strMeriPehchanID,
			String username, String strGender, String strUdiseCodeRegister, String strSchoolName, String strStateCode,
			String strStateName, String strDistrictCode, String strDistrictname, String strBlockCode,
			String strBolckName) {
		objTeacherRegisterPortalrequest.setDigiacc(digiacc);
		UserDataTeacher userDataTeacher = new UserDataTeacher();
		UserDataPortal teacherObj = new UserDataPortal();
		teacherObj.setName(strTeacherName);
		teacherObj.setJoiningdate("2023-06-08");
		teacherObj.setAadharId(Adhartoken);
		teacherObj.setSchoolUdise(strUdiseCodeRegister);
		teacherObj.setMeripehchanLoginId(strMeriPehchanID);
		teacherObj.setUsername(Adhartoken);
		teacherObj.setConsent("yes");
		teacherObj.setConsentDate("2023-06-09");
		teacherObj.setDid("");
		teacherObj.setSchool_name(strSchoolName);
		teacherObj.setStateCode(strStateCode);
		teacherObj.setStateName(strStateName);
		teacherObj.setDistrictCode(strDistrictCode);
		teacherObj.setDistrictName(strDistrictname);
		teacherObj.setBlockCode(strBlockCode);
		teacherObj.setBlockName(strBolckName);
		teacherObj.setMobile(strMobileNo);

		userDataTeacher.setTeacher(teacherObj);
		objTeacherRegisterPortalrequest.setUserdata(userDataTeacher);

		ResultSchoolData SchoolDetailsObj = new ResultSchoolData();
		SchoolDetailsObj.setSchoolName(strSchoolName);
		SchoolDetailsObj.setClientSecret("-");
		SchoolDetailsObj.setClientId("-");
		SchoolDetailsObj.setSchoolCategory(1);
		SchoolDetailsObj.setUdiseCode(strUdiseCodeRegister);
		SchoolDetailsObj.setSchoolManagementCenter(0);
		SchoolDetailsObj.setSchoolManagementState(0);
		SchoolDetailsObj.setSchoolType(3);
		SchoolDetailsObj.setClassFrom(2);
		SchoolDetailsObj.setClassTo(10);
		SchoolDetailsObj.setStateCode(9);
		SchoolDetailsObj.setStateName(strStateCode);
		SchoolDetailsObj.setStateName(strStateName);
		SchoolDetailsObj.setDistrictName(strDistrictname);
		SchoolDetailsObj.setBlockName(strBolckName);
		SchoolDetailsObj.setLocationType(1);
		SchoolDetailsObj.setHeadOfSchoolMobile("-");
		SchoolDetailsObj.setRespondentMobile("-");
		SchoolDetailsObj.setAlternateMobile("-");
		SchoolDetailsObj.setSchoolEmail("-");
		SchoolDetailsObj.setDid("");

		userDataTeacher.setSchool(SchoolDetailsObj);

		objTeacherRegisterPortalrequest.setUserdata(userDataTeacher);
		objTeacherRegisterPortalrequest.setDigimpid(strMeriPehchanID);
		String str = this.createAPIFromPojo(objTeacherRegisterPortalrequest);
		objWrapperFunctions.logReporter("Set Request register teacher:", str, true);

		// objTeacherRegisterPortalrequest.setDigiacc(strDigiacc);
		// UserDataTeacher userData=new UserDataTeacher();
		// userData.setTeacher(strTeacherData);
		// objTeacherRegisterPortalrequest.setUserdata(userData);
		// userData.setSchool(strSchoolDetails);
		// objTeacherRegisterPortalrequest.setUserdata(userData);
		// objTeacherRegisterPortalrequest.setDigimpid(strMeriPehchanID);
		// String str = this.createAPIFromPojo(objTeacherRegisterPortalrequest);
		// objWrapperFunctions.logReporter("Set Request register teacher:", str, true);

	}

	public TeacherRegisterPortalrequest getDigiLockerRegisterTeacherRequest() {
		return objTeacherRegisterPortalrequest;
	}

	public void getRegisterTeacherResponse(Response response) {
		ObjectMapper objMapper = new ObjectMapper();
		try {
			objdigilockerRegisterResponse = objMapper.readValue(response.asString(), digilockerRegisterResponse.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		objWrapperFunctions.logReporter("get response:", response.asPrettyString(), true);
	}

	public void setGetTokenRequest(String strPassword) {
		objgetTokenRequest.setPassword(strPassword);
		String str = this.createAPIFromPojo(objgetTokenRequest);
		objWrapperFunctions.logReporter("Set Request:", str, true);
	}

	public getTokenRequest GetTokenRequest() {
		return objgetTokenRequest;
	}

	public void getTokenResponse(Response response) {
		ObjectMapper objMapper = new ObjectMapper();
		try {
			objgetTokenResponse = objMapper.readValue(response.asString(), getTokenResponse.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		objWrapperFunctions.logReporter("get response:", response.asPrettyString(), true);

	}

	public String getDeleteToken() {
		String strToken = objgetTokenResponse.getToken();
		objWrapperFunctions.logReporter("Get delete token: ", strToken, true);
		return strToken;
	}

	public void setSearchStudentRequest(String strSchema, String strStudentName) {
		objSearchStudentRequest.setSchema(strSchema);

		Filter filterobj = new Filter();
		objSearchStudentRequest.setFilter(filterobj);
		Student_name studentNameobj = new Student_name();
		filterobj.setStudent_name(studentNameobj);
		studentNameobj.setContains(strStudentName);
		String str = this.createAPIFromPojo(objSearchStudentRequest);

		objWrapperFunctions.logReporter("Set Request:", str, true);
	}

	public SearchStudentRequest getSearchStudentRequest() {
		return objSearchStudentRequest;
	}

	public void getSBRCSearchStudentResponse(Response response) {
		ObjectMapper objMapper = new ObjectMapper();
		try {
			objSBRCSearchStudentResponse = objMapper.readValue(response.asString(), SBRCSearchStudentResponse.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		objWrapperFunctions.logReporter("get response:", response.asPrettyString(), true);
	}

	public String getissuanceDate() {
		String strissuancedate = objSBRCSearchStudentResponse.getResult().get(0).getOsCreatedAt();
		objWrapperFunctions.logReporter("Get issuance Date: ", strissuancedate, true);
		return strissuancedate;
	}

	public void setDeleteStudentRequest(String strSchema, String strOsid) {
		objDeleteStudentRequest.setSchema(strSchema);
		objDeleteStudentRequest.setOsid(strOsid);
		String str = this.createAPIFromPojo(objDeleteStudentRequest);
		objWrapperFunctions.logReporter("Set Request:", str, true);
	}

	public DeleteStudentRequest getDeleteStudentRequest() {
		return objDeleteStudentRequest;
	}

	public void getSBRCDeleteStudentResponse(Response response) {
		ObjectMapper objMapper = new ObjectMapper();
		try {
			objSBRCDeleteStudentResponse = objMapper.readValue(response.asString(), SBRCDeleteStudentResponse.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		objWrapperFunctions.logReporter("get response:", response.asPrettyString(), true);

	}

	public boolean getSuccessMessageDelete() {
		boolean strSuccess = objSBRCDeleteStudentResponse.isSuccess();
		// objWrapperFunctions.logReporterFalseScenario("Get Success message ",
		// strSuccess);
		return strSuccess;

	}

	public void setDigiLockerRegisterStudentRequest(String digiacc, String StudentID, String DID, String ReferanceID,
			String Adhartoken, String strStudentName, String strDOB, String SchoolType, String strMeriPehchanID,
			String username, String strGender, String strUdiseCodeRegister, String strSchoolName, String strStateCode,
			String strStateName, String strDistrictCode, String strDistrictname, String strBlockCode,
			String strBolckName, String strMobileNo) {
		objBaseTest.ConfigFileReader();
		objdigilockerRegisterEwalletRequest.setDigiacc(digiacc);
		UserdataRegister userData = new UserdataRegister();
		Student studentObj = new Student();
		studentObj.setStudent_id(StudentID);
		studentObj.setDID("");
		studentObj.setReference_id(ReferanceID);
		studentObj.setAadhar_token(Adhartoken);
		studentObj.setStudent_name(strStudentName);
		studentObj.setDob(strDOB);
		studentObj.setSchool_type(SchoolType);
		studentObj.setMeripehchan_id(strMeriPehchanID);
		studentObj.setUsername(username);
		studentObj.setGender(strGender);
		studentObj.setSchool_udise(strUdiseCodeRegister);
		studentObj.setSchool_name(strSchoolName);
		studentObj.setStateCode(strStateCode);
		studentObj.setStateName(strStateName);
		studentObj.setDistrictCode(strDistrictCode);
		studentObj.setDistrictName(strDistrictname);
		studentObj.setBlockCode(strBlockCode);
		studentObj.setBlockName(strBolckName);
		userData.setStudent(studentObj);
		objdigilockerRegisterEwalletRequest.setUserdata(userData);

		Studentdetail studentDetailObj = new Studentdetail();
		studentDetailObj.setStudent_detail_id("");
		studentDetailObj.setStudent_id(objBaseTest.getConfig().getProperty("student_ID"));

		studentDetailObj.setMobile(strMobileNo);
		studentDetailObj.setGaurdian_name(objBaseTest.getConfig().getProperty("guardianName"));
		studentDetailObj.setGrade(objBaseTest.getConfig().getProperty("class"));
		studentDetailObj.setAcdemic_year(objBaseTest.getConfig().getProperty("academicYear"));
		studentDetailObj.setStart_date("");
		studentDetailObj.setEnd_date("");
		studentDetailObj.setClaim_status(objBaseTest.getConfig().getProperty("status"));
		studentDetailObj.setEnrollon(objBaseTest.getConfig().getProperty("enrolledOn"));
		userData.setStudentdetail(studentDetailObj);

		objdigilockerRegisterEwalletRequest.setUserdata(userData);
		objdigilockerRegisterEwalletRequest.setDigimpid(strMeriPehchanID);
		String str = this.createAPIFromPojo(objdigilockerRegisterEwalletRequest);
		objWrapperFunctions.logReporter("Set Request register student", str, true);
	}

	public digilockerRegisterEwalletRequest getDigiLockerRegisterStudentRequest() {
		return objdigilockerRegisterEwalletRequest;
	}

	// public void setDigiLockerStudentApproveRequest(String strPending) {
	//
	// objsearchStudentForApprovalRequest.setIssuer(strPending);
	//// filters filtersobj = new filters();
	//// objsearchStudentForApprovalRequest.setFilters(filtersobj);
	//// Claim_status claim_statusobj = new Claim_status();
	//// filtersobj.setClaim_status(claim_statusobj);
	//// claim_statusobj.setEq(strPending);
	// String str = this.createAPIFromPojo(objsearchStudentForApprovalRequest);
	// objWrapperFunctions.logReporter("Set Request search student for Approval",
	// str, true);
	// }

	public searchStudentForApprovalRequest getDigiLockerStudentApproveRequest() {
		return objsearchStudentForApprovalRequest;
	}

	public void getSBRCSearchTeacherResponse(Response response) {
		ObjectMapper objMapper = new ObjectMapper();
		try {
			objSBRCSearchTeacherResponse = objMapper.readValue(response.asString(), SBRCSearchTeacherResponse.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		objWrapperFunctions.logReporter("get response:", response.asPrettyString(), true);

	}

	public String getTeacherOsid() {
		String strTeacherOsid = objSBRCSearchTeacherResponse.getOsid();
		objWrapperFunctions.logReporter("Get teacher Osid:", strTeacherOsid, true);
		return strTeacherOsid;
	}

//	public void setDigiLockerStudentApproveRequest(String strDIDTeacher, String strDate, String strMobileNo,
//			String strguardianName, String strSchoolName, String strClass, String strAcademicYear, String strTeacherOsid,
//			String strUdiseCodeRegister, String strStudentID, String strStudentName, String strDOB, String strUuid,
//			String strReferanceID, String strStudentOsid) {
//		objsearchStudentForApprovalRequest.setIssuer(strDIDTeacher);
//		VcData vcdataobj = new VcData();
//		vcdataobj.setIssuanceDate(strDate);
//		vcdataobj.setExpirationDate(strDate);
//
//		objsearchStudentForApprovalRequest.setVcData(vcdataobj);
//
//		CredentialSubject credentialsubobj = new CredentialSubject();
//		credentialsubobj.setMobile(strMobileNo);
//		credentialsubobj.setGuardian_name(strguardianName);
//		credentialsubobj.setSchool_name(strSchoolName);
//		credentialsubobj.setGrade(strClass);
//		credentialsubobj.setAcademic_year(strAcademicYear);
//		credentialsubobj.setOsid("");
//		credentialsubobj.setSchool_id(strUdiseCodeRegister);
//		credentialsubobj.setStudent_id(strStudentID);
//		credentialsubobj.setStudent_name(strStudentName);
//		credentialsubobj.setDob(strDOB);
//		credentialsubobj.setAadhar_token(strUuid);
//		credentialsubobj.setReference_id(strReferanceID);
//		credentialsubobj.setStudent_osid(strStudentOsid);
//
//		objsearchStudentForApprovalRequest.setCredentialSubject(credentialsubobj);
//		String str = this.createAPIFromPojo(objsearchStudentForApprovalRequest);
//		objWrapperFunctions.logReporter("Set Request search student for Approval", str, true);
//	}

	public void getDigiLockerApprovalResponse(Response response) {
		ObjectMapper objMapper = new ObjectMapper();
		try {
			objApproveStudentResponse = objMapper.readValue(response.asString(), ApproveStudentResponse.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		objWrapperFunctions.logReporter("get student approve response:", response.asPrettyString(), true);
	}

	// Author : tejal moture
	// date : 13 June 2023
	public void setDigiLockerStudentApproveRequest(String strDIDTeacher, String strDate, String strMobileNo,
			String strguardianName, String strSchoolName, String strClass, String strAcademicYear,
			String strTeacherOsid, String strUdiseCodeRegister, String strStudentID, String strStudentName,
			String strDOB, String strUuid, String strReferanceID, String strStudentOsid, String osid) {
		objsearchStudentListApprovalRequest.setIssuer(strDIDTeacher);
		VcData vcdataobj = new VcData();
		vcdataobj.setIssuanceDate(strDate);
		vcdataobj.setExpirationDate(strDate);

		objsearchStudentListApprovalRequest.setVcData(vcdataobj);
		ApprovalCredentialSubjectReq credentialsubobj = new ApprovalCredentialSubjectReq();
		credentialsubobj.setMobile(strMobileNo);
		credentialsubobj.setGuardian_name(strguardianName);
		credentialsubobj.setSchool_name(strSchoolName);
		credentialsubobj.setGrade(strClass);
		credentialsubobj.setAcademic_year(strAcademicYear);
		credentialsubobj.setOsid(osid);
		credentialsubobj.setSchool_id(strUdiseCodeRegister);
		credentialsubobj.setStudent_id(strStudentID);
		credentialsubobj.setStudent_name(strStudentName);
		credentialsubobj.setDob(strDOB);
		credentialsubobj.setAadhar_token(strUuid);
		credentialsubobj.setReference_id(strReferanceID);
		credentialsubobj.setStudent_osid(strStudentOsid);
		objsearchStudentListApprovalRequest.setCredentialSubject(credentialsubobj);
		String str = this.createAPIFromPojo(objsearchStudentListApprovalRequest);
		objWrapperFunctions.logReporter("Set Request search student for Approval", str, true);
	}

//	tejal 
	public void getDigiLockerRegisterStudentResponse(Response response) {
		ObjectMapper objMapper = new ObjectMapper();
		try {
			objdigilockerRegisterResponse = objMapper.readValue(response.asString(), digilockerRegisterResponse.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		objWrapperFunctions.logReporter("get Digilocker Register Response:", response.asPrettyString(), true);
	}

	public String getOsid() {
		String strOsid = objdigilockerRegisterResponse.getResult().getStudentDetail().getOsid();
		objWrapperFunctions.logReporter("get Digilocker Register Response osid:", strOsid, true);
		// objWrapperFunctions.logReporter("Get Success ", strSuccess);
		return strOsid;
	}

	public void setGetSBRCTokenRequest(String Digiacc, String Aadhaar_id, String Aadhaar_name, String Aadhaar_dob,
			String Aadhaar_gender, String Digilocker_id) {

//		SBRCTokenRequest objSBRCTokenRequest =new SBRCTokenRequest();
		objSBRCTokenRequest.setDigiacc(Digiacc);
		objSBRCTokenRequest.setAadhaar_id(Aadhaar_id);
		objSBRCTokenRequest.setAadhaar_name(Aadhaar_name);
		objSBRCTokenRequest.setAadhaar_dob(Aadhaar_dob);
		objSBRCTokenRequest.setAadhaar_gender(Aadhaar_gender);
		objSBRCTokenRequest.setDigilocker_id(Digilocker_id);
		String str = this.createAPIFromPojo(objSBRCTokenRequest);
		objWrapperFunctions.logReporter("Set Request:", str, true);
	}

	public String getAdharId() {
		String AdharId = objdigilockerAdharRequest.getAadhaar_id();
		objWrapperFunctions.logReporter("Get AdharId ", AdharId, true);
		return AdharId;
	}

	public SBRCTokenRequest getSBRCTokenRequest() {
		return objSBRCTokenRequest;
	}

	public void getSBRCTokenResponse(Response response) {
		ObjectMapper objMapper = new ObjectMapper();
		try {
			objSBRCTokenResposne = objMapper.readValue(response.asString(), SBRCTokenResposne.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		objWrapperFunctions.logReporter("get response:", response.asPrettyString(), true);
	}

	public String getSBRCToken() {
		String strToken = objSBRCTokenResposne.getToken();
		objWrapperFunctions.logReporter("Get SBRC  token: ", strToken, true);
		return strToken;
	}

	// temp
	// method for to get access token from user name
	public String getAccessTokenFromUsernameLogin() {
		String strAccesstoken = objGetTokenEwalletDIDResponse.getDigi().getAccess_token();
		objWrapperFunctions.logReporter("Get Access Token from user name login ", strAccesstoken, true);
		return strAccesstoken;
	}

	public String getDistrictCode(String strDistrict) {
//		String str=objWrapperFunctions.getRandomStringWithNumbers(1);
		iDistrict = Integer.parseInt(strDistrict);
		String strDistrictCode = objDigilockerStateListResponse.getResponse().getData().get(iDistrict)
				.getDistrictCode();
		objWrapperFunctions.logReporter("Get District Code ", strDistrictCode, true);
		return strDistrictCode;
	}

	public String getDistrictName() {
		String strDistrictCode = objDigilockerStateListResponse.getResponse().getData().get(iDistrict)
				.getDistrictName();
		objWrapperFunctions.logReporter("Get District Name ", strDistrictCode, true);
		return strDistrictCode;

	}

	public String getStuOsid() {
		String strOsid = objDigilockerGetStudentDataResponse.getResult().getOsid();
		objWrapperFunctions.logReporter("get Digilocker Register Response osid:", strOsid, true);
		// objWrapperFunctions.logReporter("Get Success ", strSuccess);
		return strOsid;
	}

	public void setSTudentDetailRequest(String ClaimStatus) {
		objClaim_status.setEq(ClaimStatus);
		String str = this.createAPIFromPojo(objClaim_status);
		objWrapperFunctions.logReporter("Set Request:", str, true);
	}

	public Claim_status getClaimStatusRequest() {
		return objClaim_status;
	}

	/*
	 * @author : tejal Moture description : Teacher register Portal
	 */
	public void getDigiLockerPortalTeacherRegisterResponse(Response response) {
		ObjectMapper objMapper = new ObjectMapper();
		try {
			objDigiLockerPortalTeacherRegisterResponse = objMapper.readValue(response.asString(),
					DigiLockerPortalTeacherRegisterResponse.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		objWrapperFunctions.logReporter("get response:", response.asPrettyString(), true);
	}

	/*
	 * @author : tejal Moture description : Teacher register Portal
	 */
	public boolean getSuccessMessageRegisterPortal() {
		boolean strSuccess = objDigiLockerPortalTeacherRegisterResponse.getSuccess();
		objWrapperFunctions.logReporter("Get Success ", strSuccess);
		return strSuccess;
	}

	public String getTokenRegisterTeacher() {
		String strToken = objDigiLockerPortalTeacherRegisterResponse.getTokenTeacherRegister();
		objWrapperFunctions.logReporter("Get Token ", strToken, true);
		return strToken;
	}

	public String getDIDRegisterTeacher() {
		String strDID = objDigiLockerPortalTeacherRegisterResponse.getUserData().getTeacher().getDid();
		objWrapperFunctions.logReporter("Get DID teacher", strDID, true);
		return strDID;
	}

	public String getDIDRegisterSchool() {
		String strDID = objDigiLockerPortalTeacherRegisterResponse.getUserData().getSchool().getDid();
		objWrapperFunctions.logReporter("Get DID school", strDID, true);
		return strDID;
	}
}
