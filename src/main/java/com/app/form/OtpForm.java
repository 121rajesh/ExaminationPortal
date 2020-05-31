package com.app.form;

import java.util.Date;



public class OtpForm {

	private Integer otpId;
	private String otp;
	private Date generatedOn, validTill;
	private Integer userId;
	public Integer getOtpId() {
		return otpId;
	}
	public void setOtpId(Integer otpId) {
		this.otpId = otpId;
	}
	public String getOtp() {
		return otp;
	}
	public void setOtp(String otp) {
		this.otp = otp;
	}
	public Date getGeneratedOn() {
		return generatedOn;
	}
	public void setGeneratedOn(Date generatedOn) {
		this.generatedOn = generatedOn;
	}
	public Date getValidTill() {
		return validTill;
	}
	public void setValidTill(Date validTill) {
		this.validTill = validTill;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	
	
}
