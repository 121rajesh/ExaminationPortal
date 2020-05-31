package com.app.pojos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.app.form.QuestionForm;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
//@Table(name = "T_QUESTIONS")
public class Question {

	private Integer queId;
	private String question;
	private String opt1,opt2,opt3,opt4,correctAns;
	private Subject subId;
	
	public Question() {
		// TODO Auto-generated constructor stub
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "queId")
	public Integer getQueId() {
		return queId;
	}

	public void setQueId(Integer queId) {
		this.queId = queId;
	}

	@Column(nullable = false, unique=true)
	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}
	
	@Column(nullable = false)
	public String getOpt1() {
		return opt1;
	}

	public void setOpt1(String opt1) {
		this.opt1 = opt1;
	}

	@Column(nullable = false)
	public String getOpt2() {
		return opt2;
	}

	public void setOpt2(String opt2) {
		this.opt2 = opt2;
	}

	@Column(nullable = false)
	public String getOpt3() {
		return opt3;
	}

	public void setOpt3(String opt3) {
		this.opt3 = opt3;
	}

	@Column(nullable = false)
	public String getOpt4() {
		return opt4;
	}

	public void setOpt4(String opt4) {
		this.opt4 = opt4;
	}

	@Column(name = "correctAns" ,nullable = false)
	public String getCorrectAns() {
		return correctAns;
	}

	public void setCorrectAns(String correctAns) {
		this.correctAns = correctAns;
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



	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}