package com.api.pojoRequests;

public class SearchStudentRequest {
	private String schema;
	Filter filter;


	// Getter Methods 

	public String getSchema() {
		return schema;
	}

	public Filter getFilter() {
		return filter;
	}

	// Setter Methods 

	public void setSchema(String schema) {
		this.schema = schema;
	}

	public void setFilter(Filter filter) {
		this.filter = filter;
	}
}
