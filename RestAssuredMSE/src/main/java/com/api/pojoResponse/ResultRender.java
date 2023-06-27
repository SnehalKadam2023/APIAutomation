package com.api.pojoResponse;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ResultRender {
	
	private String id;
	private String schema;
	@JsonProperty("template")
	private String template;
	private String type;
	
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getSchema() {
		return schema;
	}
	public void setSchema(String schema) {
		this.schema = schema;
	}

	public String getTemplate() {
		return template;
	}
	public void setTemplate(String template) {
		this.template = template;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	
	

}
