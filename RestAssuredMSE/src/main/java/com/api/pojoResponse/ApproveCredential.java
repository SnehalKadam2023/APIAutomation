package com.api.pojoResponse;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ApproveCredential {

	private String id;
	List<String> type;
	private String issuer;
	@JsonProperty("proof")
	ApproveProof proof;
	@JsonProperty("@context")
	List<String> context;
	@JsonProperty("issuanceDate")
	private String issuanceDate;
	@JsonProperty("expirationDate")
	private String expirationDate;
	@JsonProperty("credentialSubject")
	CredentialSubject credentialSubject;

	// getter methods

	public String getId() {
		return id;
	}

	public List<String> getType() {
		return type;
	}

	public String getIssuer() {
		return issuer;
	}

	public ApproveProof getProof() {
		return proof;
	}

	public List<String> getContext() {
		return context;
	}

	public String getIssuanceDate() {
		return issuanceDate;
	}

	public String getExpirationDate() {
		return expirationDate;
	}

	public CredentialSubject getCredentialSubject() {
		return credentialSubject;
	}

	
     //setter methods
	public void setId(String id) {
		this.id = id;
	}

	public void setType(List<String> type) {
		this.type = type;
	}

	public void setIssuer(String issuer) {
		this.issuer = issuer;
	}

	public void setProof(ApproveProof proof) {
		this.proof = proof;
	}

	public void setContext(List<String> context) {
		this.context = context;
	}

	public void setIssuanceDate(String issuanceDate) {
		this.issuanceDate = issuanceDate;
	}

	public void setExpirationDate(String expirationDate) {
		this.expirationDate = expirationDate;
	}

	public void setCredentialSubject(CredentialSubject credentialSubject) {
		this.credentialSubject = credentialSubject;
	}

}
