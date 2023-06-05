package com.api.pojoResponse;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
@JsonIgnoreProperties(ignoreUnknown = true)
public class ResultRenderSchema {
	@JsonProperty("id")
	private String id;
	@JsonProperty("type")
	private String type;
	@JsonProperty("version")
	private String version;
	@JsonProperty("name")
	private String name;
	@JsonProperty("author")
	private String author;
	@JsonProperty("authored")
	private String authored;
	@JsonProperty("schema")
	Schema schema;
	@JsonProperty("proof")
	Proof proof;
	@JsonProperty("createdAt")
	private String createdAt;
	@JsonProperty("updatedAt")
	private String updatedAt;
	@JsonProperty("deletedAt")
	private String deletedAt;
	@JsonProperty("tags")
	List <String> tags;


	// Getter Methods 

	public Schema getSchema() {
		return schema;
	}

	public void setSchema(Schema schema) {
		this.schema = schema;
	}

	public Proof getProof() {
		return proof;
	}

	public void setProof(Proof proof) {
		this.proof = proof;
	}

	public List<String> getTags() {
		return tags;
	}

	public void setTags(List<String> tags) {
		this.tags = tags;
	}

	public String getId() {
		return id;
	}

	public String getType() {
		return type;
	}

	public String getVersion() {
		return version;
	}

	public String getName() {
		return name;
	}

	public String getAuthor() {
		return author;
	}

	public String getAuthored() {
		return authored;
	}

	public String getCreatedAt() {
		return createdAt;
	}

	public String getUpdatedAt() {
		return updatedAt;
	}

	public String getDeletedAt() {
		return deletedAt;
	}

	// Setter Methods 

	public void setId(String id) {
		this.id = id;
	}

	public void setType(String type) {
		this.type = type;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public void setAuthored(String authored) {
		this.authored = authored;
	}

	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}

	public void setUpdatedAt(String updatedAt) {
		this.updatedAt = updatedAt;
	}

	public void setDeletedAt(String deletedAt) {
		this.deletedAt = deletedAt;
	}


}
