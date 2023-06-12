package com.api.pojoRequests;

public class DeleteStudentRequest {
	private String schema;
	private String osid;
	
	public String getSchema() {
		return schema;
	}
	public void setSchema(String schema) {
		this.schema = schema;
	}
	public String getOsid() {
		return osid;
	}
	public void setOsid(String osid) {
		this.osid = osid;
	}
}
