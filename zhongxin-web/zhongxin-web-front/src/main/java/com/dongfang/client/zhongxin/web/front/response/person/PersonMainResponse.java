package com.dongfang.client.zhongxin.web.front.response.person;

import java.util.ArrayList;
import java.util.List;

public class PersonMainResponse {
	List<PersonResponse> personResponseList = new ArrayList<PersonResponse>();
	public int currentPage;
	public List<PersonResponse> getPersonResponseList() {
		return personResponseList;
	}
	public void setPersonResponseList(List<PersonResponse> personResponseList) {
		this.personResponseList = personResponseList;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	

}
