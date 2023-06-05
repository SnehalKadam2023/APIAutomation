package com.api.pojoResponse;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ResultSchemaTemplate {
	private String id;
	private String schema;
	private String template;
	private String type;


	// Getter Methods 

	public String getId() {
		return id;
	}

	public String getSchema() {
		return schema;
	}

	public String getTemplate() {
		return template;
	}

	public String getType() {
		return type;
	}

	// Setter Methods 

	public void setId(String id) {
		this.id = id;
	}

	public void setSchema(String schema) {
		this.schema = schema;
	}

	public void setTemplate(String template) {
		this.template = template;
	}

	public void setType(String type) {
		this.type = type;
	}
}

