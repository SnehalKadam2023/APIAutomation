package com.api.pojoResponse;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ResultSchoolData {
	private String udiseCode;
	private String schoolName;
	private float schoolCategory;
	private float schoolManagementCenter;
	private float schoolManagementState;
	private float schoolType;
	private float classFrom;
	private float classTo;
	private float stateCode;
	private String stateName;
	private String districtName;
	private String blockName;
	private float locationType;
	private String headOfSchoolMobile;
	private String respondentMobile;
	private String alternateMobile;
	private String schoolEmail;
	private String did;
	private String osCreatedAt;
	private String osUpdatedAt;
	private String osCreatedBy;
	private String osUpdatedBy;
	private String osid;


	// Getter Methods 

	public String getUdiseCode() {
		return udiseCode;
	}

	public String getSchoolName() {
		return schoolName;
	}

	public float getSchoolCategory() {
		return schoolCategory;
	}

	public float getSchoolManagementCenter() {
		return schoolManagementCenter;
	}

	public float getSchoolManagementState() {
		return schoolManagementState;
	}

	public float getSchoolType() {
		return schoolType;
	}

	public float getClassFrom() {
		return classFrom;
	}

	public float getClassTo() {
		return classTo;
	}

	public float getStateCode() {
		return stateCode;
	}

	public String getStateName() {
		return stateName;
	}

	public String getDistrictName() {
		return districtName;
	}

	public String getBlockName() {
		return blockName;
	}

	public float getLocationType() {
		return locationType;
	}

	public String getHeadOfSchoolMobile() {
		return headOfSchoolMobile;
	}

	public String getRespondentMobile() {
		return respondentMobile;
	}

	public String getAlternateMobile() {
		return alternateMobile;
	}

	public String getSchoolEmail() {
		return schoolEmail;
	}

	public String getDid() {
		return did;
	}

	public String getOsCreatedAt() {
		return osCreatedAt;
	}

	public String getOsUpdatedAt() {
		return osUpdatedAt;
	}

	public String getOsCreatedBy() {
		return osCreatedBy;
	}

	public String getOsUpdatedBy() {
		return osUpdatedBy;
	}

	public String getOsid() {
		return osid;
	}

	// Setter Methods 

	public void setUdiseCode(String udiseCode) {
		this.udiseCode = udiseCode;
	}

	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}

	public void setSchoolCategory(float schoolCategory) {
		this.schoolCategory = schoolCategory;
	}

	public void setSchoolManagementCenter(float schoolManagementCenter) {
		this.schoolManagementCenter = schoolManagementCenter;
	}

	public void setSchoolManagementState(float schoolManagementState) {
		this.schoolManagementState = schoolManagementState;
	}

	public void setSchoolType(float schoolType) {
		this.schoolType = schoolType;
	}

	public void setClassFrom(float classFrom) {
		this.classFrom = classFrom;
	}

	public void setClassTo(float classTo) {
		this.classTo = classTo;
	}

	public void setStateCode(float stateCode) {
		this.stateCode = stateCode;
	}

	public void setStateName(String stateName) {
		this.stateName = stateName;
	}

	public void setDistrictName(String districtName) {
		this.districtName = districtName;
	}

	public void setBlockName(String blockName) {
		this.blockName = blockName;
	}

	public void setLocationType(float locationType) {
		this.locationType = locationType;
	}

	public void setHeadOfSchoolMobile(String headOfSchoolMobile) {
		this.headOfSchoolMobile = headOfSchoolMobile;
	}

	public void setRespondentMobile(String respondentMobile) {
		this.respondentMobile = respondentMobile;
	}

	public void setAlternateMobile(String alternateMobile) {
		this.alternateMobile = alternateMobile;
	}

	public void setSchoolEmail(String schoolEmail) {
		this.schoolEmail = schoolEmail;
	}

	public void setDid(String did) {
		this.did = did;
	}

	public void setOsCreatedAt(String osCreatedAt) {
		this.osCreatedAt = osCreatedAt;
	}

	public void setOsUpdatedAt(String osUpdatedAt) {
		this.osUpdatedAt = osUpdatedAt;
	}

	public void setOsCreatedBy(String osCreatedBy) {
		this.osCreatedBy = osCreatedBy;
	}

	public void setOsUpdatedBy(String osUpdatedBy) {
		this.osUpdatedBy = osUpdatedBy;
	}

	public void setOsid(String osid) {
		this.osid = osid;
	}

}
