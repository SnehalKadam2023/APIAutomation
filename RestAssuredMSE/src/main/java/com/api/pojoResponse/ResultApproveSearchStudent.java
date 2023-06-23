package com.api.pojoResponse;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ResultApproveSearchStudent {
	ApproveCredential CrendentialObject;
	@JsonProperty("credentialSchemaId")
	private String credentialSchemaId;
	@JsonProperty("createdAt")
	private String createdAt;
	@JsonProperty("updatedAt")
	private String updatedAt;
	@JsonProperty("createdBy")
	private String createdBy;
	@JsonProperty("updatedBy")
	private String updatedBy;
	@JsonProperty("tags")
	List<String> tags;

	// Getter Methods
	public ApproveCredential getCrendentialObject() {
		return CrendentialObject;
	}

	public String getCredentialSchemaId() {
		return credentialSchemaId;
	}

	public String getCreatedAt() {
		return createdAt;
	}

	public String getUpdatedAt() {
		return updatedAt;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public List<String> getTags() {
		return tags;
	}

	// setter methods

	public void setCrendentialObject(ApproveCredential crendentialObject) {
		CrendentialObject = crendentialObject;
	}

	public void setCredentialSchemaId(String credentialSchemaId) {
		this.credentialSchemaId = credentialSchemaId;
	}

	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}

	public void setUpdatedAt(String updatedAt) {
		this.updatedAt = updatedAt;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	public void setTags(List<String> tags) {
		this.tags = tags;
	}
}
