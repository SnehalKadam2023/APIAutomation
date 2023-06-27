package com.api.pojoResponse;

public class ChecksResponse {

	
	private String active;
	private String revoked;
	private String expired;
	private String proof;
	
	
	
	
	public String getActive() {
		return active;
	}
	public void setActive(String active) {
		this.active = active;
	}
	public String getRevoked() {
		return revoked;
	}
	public void setRevoked(String revoked) {
		this.revoked = revoked;
	}
	public String getExpired() {
		return expired;
	}
	public void setExpired(String expired) {
		this.expired = expired;
	}
	public String getProof() {
		return proof;
	}
	public void setProof(String proof) {
		this.proof = proof;
	}
	
	
}
