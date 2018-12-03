package com.dongfang.client.zhongxin.web.front.response.idea;

import java.util.ArrayList;
import java.util.List;

public class IdeaMainResponse {
	List<IdeaResponse> IdeaResponseList =new ArrayList<IdeaResponse>();
	public int currentPage;
	public List<IdeaResponse> getIdeaResponseList() {
		return IdeaResponseList;
	}
	public void setIdeaResponseList(List<IdeaResponse> ideaResponseList) {
		IdeaResponseList = ideaResponseList;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
}
