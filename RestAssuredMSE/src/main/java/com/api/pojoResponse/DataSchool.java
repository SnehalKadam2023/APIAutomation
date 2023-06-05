package com.api.pojoResponse;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class DataSchool {
	
	List <PagingContent> pagingContent;
	PagingMetaData pagingMetaData;


	public List<PagingContent> getPagingContent() {
		return pagingContent;
	}

	public void setPagingContent(List<PagingContent> pagingContent) {
		this.pagingContent = pagingContent;
	}

	public PagingMetaData getPagingMetaData() {
		return pagingMetaData;
	}

	public void setPagingMetaData(PagingMetaData pagingMetaData) {
		this.pagingMetaData = pagingMetaData;
	}
}
