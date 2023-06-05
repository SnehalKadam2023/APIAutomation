package com.api.pojoRequests;

import java.util.List;

import com.api.pojoResponse.ResultRenderSchema;
import com.api.pojoResponse.ResultSearchStudent;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class BffCredentialRenderRequest {
	@JsonProperty("credential")
	ResultSearchStudent credential;
	public ResultSearchStudent getCredential() {
		return credential;
	}
	public void setCredential(ResultSearchStudent credential) {
		this.credential = credential;
	}
	@JsonProperty("schema")
	ResultRenderSchema schema;
	@JsonProperty("template")
	private String template;
	@JsonProperty("output")
	private String output;
	
	
	
	public ResultRenderSchema getSchema() {
		return schema;
	}
	public void setSchema(ResultRenderSchema schema) {
		this.schema = schema;
	}
	public String getTemplate() {
		return template;
	}
	public void setTemplate(String template) {
		this.template = template;
	}
	public String getOutput() {
		return output;
	}
	public void setOutput(String output) {
		this.output = output;
	}

}
