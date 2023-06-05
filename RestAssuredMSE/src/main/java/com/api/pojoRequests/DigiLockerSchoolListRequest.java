package com.api.pojoRequests;

public class DigiLockerSchoolListRequest {
	private String regionType;
	private String regionCd;
	private String sortBy;


	// Getter Methods 

	public String getRegionType() {
		return regionType;
	}

	public String getRegionCd() {
		return regionCd;
	}

	public String getSortBy() {
		return sortBy;
	}

	// Setter Methods 

	public void setRegionType(String regionType) {
		this.regionType = regionType;
	}

	public void setRegionCd(String regionCd) {
		this.regionCd = regionCd;
	}

	public void setSortBy(String sortBy) {
		this.sortBy = sortBy;
	}


}
