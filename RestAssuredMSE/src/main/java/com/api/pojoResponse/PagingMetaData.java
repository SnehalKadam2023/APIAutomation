package com.api.pojoResponse;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PagingMetaData {
	private float pageNo;
	private float recordsPerPage;
	private float totalPages;
	private float totalRecords;


	// Getter Methods 

	public float getPageNo() {
		return pageNo;
	}

	public float getRecordsPerPage() {
		return recordsPerPage;
	}

	public float getTotalPages() {
		return totalPages;
	}

	public float getTotalRecords() {
		return totalRecords;
	}

	// Setter Methods 

	public void setPageNo(float pageNo) {
		this.pageNo = pageNo;
	}

	public void setRecordsPerPage(float recordsPerPage) {
		this.recordsPerPage = recordsPerPage;
	}

	public void setTotalPages(float totalPages) {
		this.totalPages = totalPages;
	}

	public void setTotalRecords(float totalRecords) {
		this.totalRecords = totalRecords;
	}
}

