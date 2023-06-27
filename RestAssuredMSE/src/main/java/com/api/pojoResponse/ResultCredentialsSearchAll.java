package com.api.pojoResponse;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;



public class ResultCredentialsSearchAll {

	private String id;
	List <String> type;
	private String issuer;
	@JsonProperty("@context")
	List <String> context;
	private String issuanceDate;
	private String expirationDate;
	CredentialSubjectCredentialsSearchAll credentialSubject;
	
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public List<String> getType() {
		return type;
	}
	public void setType(List<String> type) {
		this.type = type;
	}
	public String getIssuer() {
		return issuer;
	}
	public void setIssuer(String issuer) {
		this.issuer = issuer;
	}
	public List<String> getContext() {
		return context;
	}
	public void setContext(List<String> context) {
		this.context = context;
	}
	public String getIssuanceDate() {
		return issuanceDate;
	}
	public void setIssuanceDate(String issuanceDate) {
		this.issuanceDate = issuanceDate;
	}
	public String getExpirationDate() {
		return expirationDate;
	}
	public void setExpirationDate(String expirationDate) {
		this.expirationDate = expirationDate;
	}
	public CredentialSubjectCredentialsSearchAll getCredentialSubject() {
		return credentialSubject;
	}
	public void setCredentialSubject(CredentialSubjectCredentialsSearchAll credentialSubject) {
		this.credentialSubject = credentialSubject;
	}
	
	
	
}
