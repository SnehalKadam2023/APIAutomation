package com.api.pojoRequests;


public class CredentialIssueRequest {
	private String clientId;
	private String clientSecret;
	IssuerDetail issuerDetail;
	VcData vcData;
	CredentialIssueSubjectCommon credentialSubjectCommon;
	CredentialIssueSubject credentialSubject;
	
	
	public String getClientId() {
		return clientId;
	}
	public void setClientId(String clientId) {
		this.clientId = clientId;
	}
	public String getClientSecret() {
		return clientSecret;
	}
	public void setClientSecret(String clientSecret) {
		this.clientSecret = clientSecret;
	}
	public IssuerDetail getIssuerDetail() {
		return issuerDetail;
	}
	public void setIssuerDetail(IssuerDetail issuerDetail) {
		this.issuerDetail = issuerDetail;
	}
	public VcData getVcData() {
		return vcData;
	}
	public void setVcData(VcData vcData) {
		this.vcData = vcData;
	}
	public CredentialIssueSubjectCommon getCredentialSubjectCommon() {
		return credentialSubjectCommon;
	}
	public void setCredentialSubjectCommon(CredentialIssueSubjectCommon credentialSubjectCommon) {
		this.credentialSubjectCommon = credentialSubjectCommon;
	}
	public CredentialIssueSubject getCredentialSubject() {
		return credentialSubject;
	}
	public void setCredentialSubject(CredentialIssueSubject credentialSubject) {
		this.credentialSubject = credentialSubject;
	}
	

}