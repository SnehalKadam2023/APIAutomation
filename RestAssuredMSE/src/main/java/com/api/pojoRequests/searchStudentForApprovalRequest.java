package com.api.pojoRequests;


public class searchStudentForApprovalRequest {
	private String issuer;
	VcData vcData;
	CredentialSubject credentialSubject;
	
	
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
	public CredentialSubject getCredentialSubject() {
		return credentialSubject;
	}
	public void setCredentialSubject(CredentialSubject credentialSubject) {
		this.credentialSubject = credentialSubject;
	}





}