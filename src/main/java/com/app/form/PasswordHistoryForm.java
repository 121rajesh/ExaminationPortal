package com.app.form;

import java.util.Date;

public class PasswordHistoryForm {
	
	private Integer passId;
	private String oldPassword, newPassword;
	private Date changedOn;
	private Integer userId;
	public Integer getPassId() {
		return passId;
	}
	public void setPassId(Integer passId) {
		this.passId = passId;
	}
	public String getOldPassword() {
		return oldPassword;
	}
	public void setOldPassword(String oldPassword) {
		this.oldPassword = oldPassword;
	}
	public String getNewPassword() {
		return newPassword;
	}
	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}
	public Date getChangedOn() {
		return changedOn;
	}
	public void setChangedOn(Date changedOn) {
		this.changedOn = changedOn;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	
	
}
