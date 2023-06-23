package com.api.pojoRequests;


public class searchStudentListApprovalRequest {
	private String issuer;
	VcData vcData;
	ApprovalCredentialSubjectReq credentialSubject;
	
	
	public String getIssuer() {
		return issuer;
	}
	public void setIssuer(String issuer) {
		this.issuer = issuer;
	}
	public VcData getVcData() {
		return vcData;
	}
	public void setVcData(VcData vcData) {
		this.vcData = vcData;
	}
	public ApprovalCredentialSubjectReq getCredentialSubject() {
		return credentialSubject;
	}
	public void setCredentialSubject(ApprovalCredentialSubjectReq credentialSubject) {
		this.credentialSubject = credentialSubject;
	}
	




}