package com.api.pojoResponse;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ResultSearchStudent {
	
	private String id;
	List < String> type;
	private String issuer;
	@JsonProperty("@context")
	List < String > context;
	@JsonProperty("issuanceDate")
	private String issuanceDate;
	@JsonProperty("expirationDate")
	private String expirationDate;
	@JsonProperty("credentialSubject")
	CredentialSubject credentialSubject;


	// Getter Methods 

	public String getId() {
		return id;
	}

	public String getIssuer() {
		return issuer;
	}

	public String getIssuanceDate() {
		return issuanceDate;
	}

	public String getExpirationDate() {
		return expirationDate;
	}

	// Setter Methods 

	public void setId(String id) {
		this.id = id;
	}

	public void setIssuer(String issuer) {
		this.issuer = issuer;
	}

	public void setIssuanceDate(String issuanceDate) {
		this.issuanceDate = issuanceDate;
	}

	public void setExpirationDate(String expirationDate) {
		this.expirationDate = expirationDate;
	}

	public List<String> getType() {
		return type;
	}

	public void setType(List<String> type) {
		this.type = type;
	}

	public List<String> getContext() {
		return context;
	}

	public void setContext(List<String> context) {
		this.context = context;
	}

	public CredentialSubject getCredentialSubject() {
		return credentialSubject;
	}

	public void setCredentialSubject(CredentialSubject credentialSubject) {
		this.credentialSubject = credentialSubject;
	}

	
}
