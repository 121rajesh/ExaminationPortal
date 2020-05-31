package com.app.pojos;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
//@Table(name = "T_OTP_DETAILS")
public class OTPDetail {

	private Integer otpId;
	private String otp;
	private Date generatedOn, validTill;
	private User userId;
	
	//private List<Users> users = new ArrayList<Users>();
	
	public OTPDetail() {
		// TODO Auto-generated constructor stub
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "otpId")
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

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "generatedOn")
	public Date getGeneratedOn() {
		return generatedOn;
	}

	public void setGeneratedOn(Date generatedOn) {
		this.generatedOn = generatedOn;
	}
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "validTill")
	public Date getValidTill() {
		return validTill;
	}

	public void setValidTill(Date validTill) {
		this.validTill = validTill;
	}

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "userId",nullable = false)
	public User getUserId() {
		return userId;
	}

	public void setUserId(User userId) {
		this.userId = userId;
	}
	
	
}
