package com.app.pojos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

//@NamedQuery(name = "Result.findAll",query ="SELECT r.score,r.userId.name, r.userId.emailId, r.subId.subName FROM Result r" )
@Entity
//@Table(name = "T_RESULT")
public class Result {

	private Integer resId;
	private User userId;
	private Subject subId;
	private Integer score;
	
	public Result() {
		// TODO Auto-generated constructor stub
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="resId")
	public Integer getResId() {
		return resId;
	}

	public void setResId(Integer resId) {
		this.resId = resId;
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

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "subId",nullable = false)
	public Subject getSubId() {
		return subId;
	}

	public void setSubId(Subject subId) {
		this.subId = subId;
	}
	
	
	public Integer getScore() {
		return score;
	}

	public void setScore(Integer score) {
		this.score = score;
	}
	
	
}