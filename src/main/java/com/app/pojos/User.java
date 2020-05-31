	package com.app.pojos;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;




@Entity
//@Table(name = "T_USER")
public class User 
{
	
	private Integer userId;
	private String emailId;
	private String name;
	private String password;
	private String mobile;
	private boolean isLocked;
	private boolean isOnline;
	private Role role;
	
	private List<Feedback> fdbk = new ArrayList<Feedback>();
	
	@JsonIgnore
	@OneToMany(mappedBy = "userId", cascade = CascadeType.PERSIST)
	public List<Feedback> getFdbk() {
		return fdbk;
	}

	public void setFdbk(List<Feedback> fdbk) {
		this.fdbk = fdbk;
	}
	
	private List<OTPDetail> otplist = new ArrayList<OTPDetail>();
	
	@JsonIgnore
	@OneToMany(mappedBy = "userId",cascade = CascadeType.PERSIST)
	public List<OTPDetail> getOtplist() {
		return otplist;
	}

	public void setOtplist(List<OTPDetail> otplist) {
		this.otplist = otplist;
	}

	private List<PasswordHistory> passHist = new ArrayList<PasswordHistory>();
	
	@JsonIgnore
	@OneToMany(mappedBy = "userId", cascade = CascadeType.PERSIST)
	public List<PasswordHistory> getPassHist() {
		return passHist;
	}

	public void setPassHist(List<PasswordHistory> passHist) {
		this.passHist = passHist;
	}

	private List<Result> results = new ArrayList<>();
	
	//@JsonBackReference
	@JsonIgnore
	@OneToMany(mappedBy = "userId", cascade = CascadeType.PERSIST)
	public List<Result> getResults() {
		return results;
	}

	public void setResults(List<Result> results) {
		this.results = results;
	}

	public User() {
		// TODO Auto-generated constructor stub
	}
	
	public User(Integer userId, String emailId, String name, String password, String mobile) {
		super();
		this.userId = userId;
		this.emailId = emailId;
		this.name = name;
		this.password = password;
		this.mobile = mobile;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "userId")
	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	
	@Column(name = "emailId",length = 30, nullable = false, unique = true)
	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	@Column(name = "name",length = 30, nullable = false)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	@Column(length = 20, nullable = false)
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	@Column(length = 13,nullable = false, unique = true)
	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	@Column(name = "isLocked")
	public boolean getIsLocked() {
		return isLocked;
	}

	public void setIsLocked(boolean isLocked) {
		this.isLocked = isLocked;
	}

	@Column(name = "isOnline")
	public boolean getIsOnline() {
		return isOnline;
	}

	public void setIsOnline(boolean isOnline) {
		this.isOnline = isOnline;
	}
	
	@Enumerated(EnumType.STRING)
	@Column(name = "role",length = 15,nullable = false)
	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}
	
	
	
	
}
	