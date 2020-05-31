package com.app.pojos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
//@Table(name = "T_FEEDBACK")
public class Feedback {

	private Integer fdbkId;
	private String message;
	private User userId;
	
	//private List<Users> users = new ArrayList<Users>();
	
	public Feedback() {
		// TODO Auto-generated constructor stub
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "fdbkId")
	public Integer getFdbkId() {
		return fdbkId;
	}

	public void setFdbkId(Integer fdbkId) {
		this.fdbkId = fdbkId;
	}

	@Column(length = 250,nullable = false)
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
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
