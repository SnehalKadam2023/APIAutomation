package com.api.view;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import com.api.pojoRequests.BffCredentialRenderRequest;
import com.api.pojoRequests.BffSearchStudentRequest;
import com.api.pojoRequests.DigiLockerLogoutRequest;
import com.api.pojoRequests.DigiLockerRequest;
import com.api.pojoRequests.DigiLockerSchoolListRequest;
import com.api.pojoRequests.Requestbody;
import com.api.pojoRequests.Student;
import com.api.pojoRequests.Studentdetail;
import com.api.pojoRequests.Subject;
import com.api.pojoRequests.TeacherRegisterPortalrequest;
import com.api.pojoRequests.UserDataTeacher;
import com.api.pojoRequests.Userdata;
import com.api.pojoRequests.countFields;
import com.api.pojoRequests.digilockerAdharRequest;
import com.api.pojoRequests.digilockerBlockListRequest;
import com.api.pojoRequests.digilockerDistrictListRequest;
import com.api.pojoRequests.digilockerRegisterEwalletRequest;
import com.api.pojoRequests.getTokenRequest;
import com.api.pojoRequests.portalVerifyUdiseRequest;
import com.api.pojoResponse.BffCredentialsSearchStudentsresponse;
import com.api.pojoResponse.BffGetRenderSchemaResponse;
import com.api.pojoResponse.BffGetSchemaIDResponse;
import com.api.pojoResponse.BffGetSchemaTemplateResponse;
import com.api.pojoResponse.Detail;
import com.api.pojoResponse.DigiLockerTokenEwalletResponse;
import com.api.pojoResponse.DigilockerAdharEwalletResponse;
import com.api.pojoResponse.DigilockerGetDashboardResponse;
import com.api.pojoResponse.DigilockerGetStudentDataResponse;
import com.api.pojoResponse.DigilockerSchoolListResponse;
import com.api.pojoResponse.DigilockerStateListResponse;
import com.api.pojoResponse.ResultRenderSchema;
import com.api.pojoResponse.ResultSchoolData;
import com.api.pojoResponse.ResultSearchStudent;
import com.api.pojoResponse.SchoolDetailsResponse;
import com.api.pojoResponse.URLpage;
import com.api.pojoResponse.UdiseVerifyResponse;
import com.api.pojoResponse.UserData;
import com.api.pojoResponse.digilockerRegisterResponse;
import com.api.pojoResponse.negativeResponse;
import com.generic.Pojo;
import com.generic.WrapperFunctions;
import com.itextpdf.text.Document;  
import com.itextpdf.text.DocumentException;  
import com.itextpdf.text.Paragraph;  
import com.itextpdf.text.pdf.PdfWriter;
import com.api.pojoResponse.getTokenResponse;
import com.pageFactory.DigiLockerLoginPage;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Base64;  

import io.restassured.response.Response;

public class APIview {

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
		
	}

	/**
	 *Author: Snehal kadam
	 *API_01_VerifyUserIsAbleToGenerateDigiUrl
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

	public void getDigiurlResponse(Response response)
	{
		ObjectMapper objMapper= new ObjectMapper();
		try {
			objURLpage=objMapper.readValue(response.asString(), URLpage.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		objWrapperFunctions.logReporter("get response:", response.asPrettyString(), true);
	}

	public String getDigilockerUrl()
	{
		String strDigilockerURL= objURLpage.getDigiauthurl();
		objWrapperFunctions.logReporter("Get Digilocker URL", strDigilockerURL, true);
		return strDigilockerURL;

	}

	/**
	 *Author: Snehal kadam
	 *API_02_VerifyUserIsAbleToGenerateAuthCode
	 */

	public String EnterDetailsOnDigilockerLoginPageUsingMobile(String strMobileNo, String strPin) {
		objDigiLockerLoginPage.setMobileNo(strMobileNo);
		objDigiLockerLoginPage.setUserPin(strPin);
		objDigiLockerLoginPage.selectCheckbox();
		objDigiLockerLoginPage.clickOnSignInbutton();
		objDigiLockerLoginPage.clickOnAllowButton();
		String strAuthCode = objDigiLockerLoginPage.getAuthCode();
		return strAuthCode;	
	}
	/**
	 *Author: Snehal kadam
	 *API_03_VerifyUserIsAbleToGenerateToken
	 */

	public void setDigiLockerRequest(String strDigiacc,String strAuthCode) {
		objDigiLockerRequest.setDigiacc(strDigiacc);
		objDigiLockerRequest.setAuth_code(strAuthCode);
		String str = this.createAPIFromPojo(objDigiLockerRequest);
		objWrapperFunctions.logReporter("Set Request:", str, true);
	}

	public DigiLockerRequest getDigiLockerRequest(){
		return objDigiLockerRequest;

	}

	public void getDigiLockerTokenEwalletResponse(Response response) {
		ObjectMapper objMapper= new ObjectMapper();
		try {
			objDigiLockerTokenEwalletResponse=objMapper.readValue(response.asString(), DigiLockerTokenEwalletResponse.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		objWrapperFunctions.logReporter("get response:", response.asPrettyString(), true);
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
	public ArrayList<UserData> getTeacherData() {
		ArrayList<UserData> strTeacherData = objDigiLockerTokenEwalletResponse.getUserData();
		return strTeacherData;
	}
	public boolean getSuccessMessage() {
		boolean strSuccess = objDigiLockerTokenEwalletResponse.getSuccess();
		objWrapperFunctions.logReporter("Get Success ", strSuccess);
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
		String strDID=objDigiLockerTokenEwalletResponse.getUserData().get(0).getDID();
		objWrapperFunctions.logReporter("Get DID ", strDID, true);
		return strDID;
	}
	/**
	 *Author: Snehal kadam
	 *API_03_VerifyUserIsAbleToGenerateToken
	 */

	public void setDigiLockerAdharRequest(String strDigiacc,String strAdharName,String strAdhargender,String strAdharDob,String strdigilockerID) {
		String strAdharID= "123456"+objWrapperFunctions.getRandomStringWithNumbers(6);
		objdigilockerAdharRequest.setDigiacc(strDigiacc);
		objdigilockerAdharRequest.setAadhaar_id(strAdharID);	
		objdigilockerAdharRequest.setAadhaar_name(strAdharName);
		objdigilockerAdharRequest.setAadhaar_gender(strAdhargender);
		objdigilockerAdharRequest.setAadhaar_dob(strAdharDob);
		objdigilockerAdharRequest.setDigilocker_id(strdigilockerID);

		String str = this.createAPIFromPojo(objdigilockerAdharRequest);
		objWrapperFunctions.logReporter("Set Request:", str, true);
	}

	public digilockerAdharRequest getDigiLockerAdharRequest(){
		return objdigilockerAdharRequest;
	}

	public void getDigiLockerAdharEwalletResponse(Response response) {
		ObjectMapper objMapper= new ObjectMapper();
		try {
			objDigilockerAdharEwalletResponse=objMapper.readValue(response.asString(), DigilockerAdharEwalletResponse.class);
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
	 *Author: Snehal kadam
	 *API_07_VerifyUserIsAbleToGenerateAuthCode(using Username)
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
	 *Author: Snehal kadam
	 *API_05_VerifyUserIsAbleToGetStateList
	 */

	public void getListResponse(Response response) {
		ObjectMapper objMapper= new ObjectMapper();
		try {
			objDigilockerStateListResponse=objMapper.readValue(response.asString(), DigilockerStateListResponse.class);
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


	/**
	 *Author: Snehal kadam
	 *API_06_VerifyUserIsAbleToGetDistrictList
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

	public String getDistrictCode() {
		String strDistrictCode = objDigilockerStateListResponse.getResponse().getData().get(2).getDistrictCode();
		objWrapperFunctions.logReporter("Get District Code ", strDistrictCode, true);
		return strDistrictCode;

	}

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
		String strDistrictCode = objDigilockerStateListResponse.getResponse().getData().get(0).getBlockCode();
		objWrapperFunctions.logReporter("Get Block Code ", strDistrictCode, true);
		return strDistrictCode;

	}	// TODO Auto-generated method stub

	public void setDigiLockerSchoolListRequest(String strRegionType, String strDistrictCode , String strSortBy) {
		objDigiLockerSchoolListRequest.setRegionType(strRegionType);
		objDigiLockerSchoolListRequest.setRegionCd(strDistrictCode);
		objDigiLockerSchoolListRequest.setSortBy(strSortBy);
		String str = this.createAPIFromPojo(objDigiLockerSchoolListRequest);
		objWrapperFunctions.logReporter("Set Request:", str, true);	
	}
	public void setDigiLockerNegativeSchoolListRequest(String strRegionType, String strDistrictCode , String strSortBy) {
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
		ObjectMapper objMapper= new ObjectMapper();
		try {
			objDigilockerSchoolListResponse=objMapper.readValue(response.asString(), DigilockerSchoolListResponse.class);
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
		String strUdiseCode = objDigilockerSchoolListResponse.getResponse().getDataSchool().getPagingContent().get(0).getUdiseCode();
		objWrapperFunctions.logReporter("Get Udise Code ", strUdiseCode, true);
		return strUdiseCode;
	}

	public void setDigiLockerLogoutRequest(String strDigiacc,String strAccessToken) {
		objDigiLockerLogoutRequest.setDigiacc(strDigiacc);
		objDigiLockerLogoutRequest.setAccess_token(strAccessToken);
		String str = this.createAPIFromPojo(objDigiLockerLogoutRequest);
		objWrapperFunctions.logReporter("Set Request:", str, true);
	}
	public void setDigiLockerNegativeLogoutRequest(String strDigiacc,String strAccessToken) {
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
		ObjectMapper objMapper= new ObjectMapper();
		try {
			objDigilockerGetStudentDataResponse=objMapper.readValue(response.asString(), DigilockerGetStudentDataResponse.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		objWrapperFunctions.logReporter("get response:", response.asPrettyString(), true);
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
		ObjectMapper objMapper= new ObjectMapper();
		try {
			objDigilockerGetDashboardResponse=objMapper.readValue(response.asString(), DigilockerGetDashboardResponse.class);
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

	public void setBFFCredentialSearchStudent(String strDID) {
		Subject objSubject =new Subject();
		objSubject.setId(strDID);
		objBffSearchStudentRequest.setSubject(objSubject);
		String str = this.createAPIFromPojo(objBffSearchStudentRequest);
		objWrapperFunctions.logReporter("Set Request BFF Search:", str, true);	
	}

	public BffSearchStudentRequest getBFFCredentialSearchStudent() {
		return objBffSearchStudentRequest;
	}

	public void getSearchStudentResponse(Response response) {
		ObjectMapper objMapper= new ObjectMapper();
		try {
			objBffCredentialsSearchStudentsresponse=objMapper.readValue(response.asString(), BffCredentialsSearchStudentsresponse.class);
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
		//		ArrayList<ResultSearchStudent> strCredentialsID = new ArrayList<ResultSearchStudent>();
		//		strCredentialsID.add(ResultSearchStudent);

		//		//System.out.println("Get Response::::::::::::"+ strCredentialsID.get(0));
		//		for(int i = 0; i < 1; i++) {
		//            System.out.println(strCredentialsID.get(i).getId());
		//            System.out.println(strCredentialsID.get(i).getIssuanceDate());
		//            System.out.println(strCredentialsID.get(i).getExpirationDate());
		//            System.out.println(strCredentialsID.get(i).getType());
		//            System.out.println(strCredentialsID.get(i).getCredentialSubject().getId());
		//            System.out.println(strCredentialsID.get(i).getCredentialSubject().getAadhar_token());
		//        }
		return ResultSearchStudent;
	}

	public void setResultCredentials(List<ResultSearchStudent> strCredentialsID) {
		objBffCredentialsSearchStudentsresponse.setResult(strCredentialsID);
		System.out.println("SetResponse::::::::::::"+strCredentialsID);
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
		strUdiseCode= strUdiseCode + objWrapperFunctions.getRandomStringWithNumbers(1);
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
		ObjectMapper objMapper= new ObjectMapper();
		try {
			objUdiseVerifyResponse=objMapper.readValue(response.asString(),UdiseVerifyResponse.class);
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
		ObjectMapper objMapper= new ObjectMapper();
		try {
			objSchoolDetailsResponse=objMapper.readValue(response.asString(),SchoolDetailsResponse.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		objWrapperFunctions.logReporter("get response:", response.asPrettyString(), true);	
	}

	public ResultSchoolData getSchoolDetails() {
		ResultSchoolData strSchoolDetails = objSchoolDetailsResponse.getResult();
		return strSchoolDetails;
	}

	public boolean getSuccessSchoolDetails() {
		boolean strSuccess = objSchoolDetailsResponse.getSuccess();
		objWrapperFunctions.logReporter("Get Success message ", strSuccess);
		return strSuccess;
	}

	public void getSchemaIDResponse(Response response) {
		ObjectMapper objMapper= new ObjectMapper();
		try {
			objBffGetSchemaIDResponse=objMapper.readValue(response.asString(),BffGetSchemaIDResponse.class);
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
		ObjectMapper objMapper= new ObjectMapper();
		try {
			objBffGetSchemaTemplateResponse=objMapper.readValue(response.asString(),BffGetSchemaTemplateResponse.class);
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
		ObjectMapper objMapper= new ObjectMapper();
		try {
			objBffGetRenderSchemaResponse=objMapper.readValue(response.asString(),BffGetRenderSchemaResponse.class);
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
		//		Document doc = new Document();  
		File outputImageFile = new File("C:\\Users\\SNEHAL\\Desktop\\tekdi workspace\\RestAssuredMSE\\src\\test\\resources\\download\\ID.pdf");
		try ( FileOutputStream fos = new FileOutputStream(outputImageFile); ) {
			// To be short I use a corrupted PDF string, so make sure to use a valid one if you want to preview the PDF file
			//String b64 = "JVBERi0xLjUKJYCBgoMKMSAwIG9iago8PC9GaWx0ZXIvRmxhdGVEZWNvZGUvRmlyc3QgMTQxL04gMjAvTGVuZ3==";
			byte[] decoder = Base64.getDecoder().decode(response);

			fos.write(decoder);
			System.out.println("PDF File Saved");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void getListNegativeResponse(Response response) {
		ObjectMapper objMapper= new ObjectMapper();
		try {
			objnegativeResponse=objMapper.readValue(response.asString(),negativeResponse.class);
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

	public ArrayList<UserData> getStudentUserData() {
		ArrayList<UserData> strUserData = objDigiLockerTokenEwalletResponse.getUserData();
		return strUserData;
	}
	public Detail getStudentDetail() {
		Detail strStudentDetail = objDigiLockerTokenEwalletResponse.getDetail();
		return strStudentDetail;
	}

	public void setDigiLockerRegisterStudentRequest(String strDigiacc, ArrayList<UserData> strUserData,
			Detail strStudentDetail, String strMeriPehchanID) {

		objdigilockerRegisterEwalletRequest.setDigiacc(strDigiacc);
		Userdata userData=new Userdata();
		userData.setStudent(strUserData);
		objdigilockerRegisterEwalletRequest.setUserdata(userData);
		userData.setStudentdetail(strStudentDetail);
		objdigilockerRegisterEwalletRequest.setUserdata(userData);
		objdigilockerRegisterEwalletRequest.setDigimpid(strMeriPehchanID);
		String str = this.createAPIFromPojo(objdigilockerRegisterEwalletRequest);
		objWrapperFunctions.logReporter("Set Request:", str, true);

	}
	public digilockerRegisterEwalletRequest getDigiLockerRegisterStudentRequest() {
		return objdigilockerRegisterEwalletRequest;	
	}

	public void getRegisterEwalletResponse(Response response) {
		ObjectMapper objMapper= new ObjectMapper();
		try {
			objdigilockerRegisterResponse=objMapper.readValue(response.asString(),digilockerRegisterResponse.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		objWrapperFunctions.logReporter("get response:", response.asPrettyString(), true);

	}

	public void setDigiLockerRegisterTeacherRequest(String strDigiacc, ArrayList<UserData> strTeacherData,
			ResultSchoolData strSchoolDetails,String strMeriPehchanID) {
		objTeacherRegisterPortalrequest.setDigiacc(strDigiacc);
		UserDataTeacher userData=new UserDataTeacher();
		userData.setTeacher(strTeacherData);
		objTeacherRegisterPortalrequest.setUserdata(userData);
		userData.setSchool(strSchoolDetails);
		objTeacherRegisterPortalrequest.setUserdata(userData);
		objTeacherRegisterPortalrequest.setDigimpid(strMeriPehchanID);
		String str = this.createAPIFromPojo(objTeacherRegisterPortalrequest);
		objWrapperFunctions.logReporter("Set Request:", str, true);

	}

	public TeacherRegisterPortalrequest getDigiLockerRegisterTeacherRequest() {
		return objTeacherRegisterPortalrequest;
	}

	public void getRegisterTeacherResponse(Response response) {
		ObjectMapper objMapper= new ObjectMapper();
		try {
			//need to create response class for register teacher(previous API is getting failed)
			objdigilockerRegisterResponse=objMapper.readValue(response.asString(),digilockerRegisterResponse.class);
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
		ObjectMapper objMapper= new ObjectMapper();
		try {
			objgetTokenResponse=objMapper.readValue(response.asString(),getTokenResponse.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		objWrapperFunctions.logReporter("get response:", response.asPrettyString(), true);
		
	}
}


