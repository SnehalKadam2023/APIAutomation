package com.generic;

public enum ApiResreqURL {

	getDigilockerAuthorizeEwallet("https://ulp.uniteframework.io/ulp-bff/v1/sso/digilocker/authorize/ewallet"),
	postDigilockerTokenEwallet("https://ulp.uniteframework.io/ulp-bff/v1/sso/digilocker/token"),
	postDigilockerAadhaarEwallet("https://ulp.uniteframework.io/ulp-bff/v1/sso/digilocker/aadhaar"),
	getStateList("https://ulp.uniteframework.io/ulp-bff/v1/school/stateList"),
	GetDistrictList("https://ulp.uniteframework.io/ulp-bff/v1/school/districtList"),
	GetBlockList("https://ulp.uniteframework.io/ulp-bff/v1/school/blockList"),
	getSchoolList("https://ulp.uniteframework.io/ulp-bff/v1/school/schoolList"),
	postDigilockerRegisterEwallet("https://ulp.uniteframework.io/ulp-bff/v1/sso/digilocker/token"),
	postDigilockerLogout("https://ulp.uniteframework.io/ulp-bff/v1/sso/digilocker/logout"),
	getStudentData("https://ulp.uniteframework.io/ulp-bff/v1/sso/user/ewallet"),
	getDigilockerAuthorizePortal("https://ulp.uniteframework.io/ulp-bff/v1/sso/digilocker/authorize/portal"),
	postDigilockerTokenPortal("https://ulp.uniteframework.io/ulp-bff/v1/sso/digilocker/token"),
	postDigilockerAadhaarPortal("https://ulp.uniteframework.io/ulp-bff/v1/sso/digilocker/aadhaar"),
	getTeacherData("https://ulp.uniteframework.io/ulp-bff/v1/sso/user/portal"),
	getDashboardCount("https://ulp.uniteframework.io/ulp-bff/v1/portal/count"),
	getUdiseVerify("https://ulp.uniteframework.io/ulp-bff/v1/school/verify"),
	getSchoolDetails("https://ulp.uniteframework.io/ulp-bff/v1/sso/school/{udiseCode}"),

	postSearchStudent("https://ulp.uniteframework.io/ulp-bff/v1/sso/student/credentials/search/student"),
	getSchemaIDByCredentialsID(
			"https://ulp.uniteframework.io/ulp-bff/v1/sso/student/credentials/schema/{credentialID}"),
	getRenderSchema(
			"https://ulp.uniteframework.io/ulp-bff/v1/sso/student/credentials/schema/json/{credentialSchemaID}"),
	getRenderSchemaTemplate(
			"https://ulp.uniteframework.io/ulp-bff/v1/sso/student/credentials/rendertemplateschema/{credentialSchemaID}"),
	postRenderCredentials("https://ulp.uniteframework.io/ulp-bff/v1/sso/student/credentials/render"),

	// postRegisterEwallet("https://ulp.uniteframework.io/ulp-bff/v1/sso/digilocker/register"),
	postRegisterEwallet("https://ulp.uniteframework.io/registry/api/v1/StudentDetail/invite"),
	postRegisterTeacher("https://ulp.uniteframework.io/ulp-bff/v1/sso/digilocker/register"),
	getToken("https://ulp.uniteframework.io/ulp-bff/v1/sbrc/token"),
//	getToken("https://ulp.uniteframework.io/ulp-bff/v1/sso/digilocker/aadhaar"),

	postSBRCSearchStudent("https://ulp.uniteframework.io/ulp-bff/v1/sbrc/search"),
	postSBRCDeleteStudent("https://ulp.uniteframework.io/ulp-bff/v1/sbrc/delete"),
	postSearchTeacher("https://ulp.uniteframework.io/ulp-bff/v1/sso/student/credentials/search/teacher"),
	postStudentApproveRequest("https://ulp.uniteframework.io/ulp-bff/v1/credentials/approveStudentV2"),
	postStudentApprovelistRequest("https://ulp.uniteframework.io/ulp-bff/v1/sso/studentDetailV2");

	private String strReturn;

	ApiResreqURL(String returnPath) {
		this.strReturn = returnPath;
	}

	public String returnResourcePath() {
		return strReturn;
	}

}
