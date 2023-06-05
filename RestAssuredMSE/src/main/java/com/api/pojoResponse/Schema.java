package com.api.pojoResponse;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
@JsonIgnoreProperties(ignoreUnknown = true)
public class Schema {
	@JsonProperty("$id")
	private String id;
	
	@JsonProperty("type")
	private String type;
	
	@JsonProperty("$schema")
	private String schema;
	
	@JsonProperty("required")
	List < String > required;
	
	@JsonProperty("properties")
	Properties properties;
	
	private String description;
	private boolean additionalProperties;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getSchema() {
		return schema;
	}
	public void setSchema(String schema) {
		this.schema = schema;
	}
	public List<String> getRequired() {
		return required;
	}
	
	public void setRequired(List<String> required) {
		this.required = required;
	}
	public Properties getProperties() {
		return properties;
	}
	public void setProperties(Properties properties) {
		this.properties = properties;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public boolean isAdditionalProperties() {
		return additionalProperties;
	}
	public void setAdditionalProperties(boolean additionalProperties) {
		this.additionalProperties = additionalProperties;
	}

}
