package com.app.form;

import java.util.List;

public class ExamDataForm {
	
	Integer userId, subId;
	List<ExamForm> ansData;
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public Integer getSubId() {
		return subId;
	}
	public void setSubId(Integer subId) {
		this.subId = subId;
	}
	public List<ExamForm> getAnsData() {
		return ansData;
	}
	public void setAnsData(List<ExamForm> ansData) {
		this.ansData = ansData;
	}
	
	
}
