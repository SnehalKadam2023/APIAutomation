package com.api.pojoResponse;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ApproveProof {

	@JsonProperty("type")
	private String type;
	@JsonProperty("created")
	private String created;
	@JsonProperty("proofValue")
	private String proofValue;
	private String proofPurpose;
	@JsonProperty("verificationMethod")
	private String verificationMethod;

	// Getter Methods
	public String getType() {
		return type;
	}

	public String getCreated() {
		return created;
	}

	public String getProofValue() {
		return proofValue;
	}

	public String getProofPurpose() {
		return proofPurpose;
	}

	public String getVerificationMethod() {
		return verificationMethod;
	}

	// setter Methods
	public void setType(String type) {
		this.type = type;
	}

	public void setCreated(String created) {
		this.created = created;
	}

	public void setProofValue(String proofValue) {
		this.proofValue = proofValue;
	}

	public void setProofPurpose(String proofPurpose) {
		this.proofPurpose = proofPurpose;
	}

	public void setVerificationMethod(String verificationMethod) {
		this.verificationMethod = verificationMethod;
	}
}
