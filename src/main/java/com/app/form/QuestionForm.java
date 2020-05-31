package com.app.form;

import com.app.pojos.Question;
import com.app.pojos.Subject;

public class QuestionForm {
	private Integer queId;
	private String question;
	private String opt1,opt2,opt3,opt4,correctAns;
	private Integer subId;
	public Integer getQueId() {
		return queId;
	}
	public void setQueId(Integer queId) {
		this.queId = queId;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public String getOpt1() {
		return opt1;
	}
	public void setOpt1(String opt1) {
		this.opt1 = opt1;
	}
	public String getOpt2() {
		return opt2;
	}
	public void setOpt2(String opt2) {
		this.opt2 = opt2;
	}
	public String getOpt3() {
		return opt3;
	}
	public void setOpt3(String opt3) {
		this.opt3 = opt3;
	}
	public String getOpt4() {
		return opt4;
	}
	public void setOpt4(String opt4) {
		this.opt4 = opt4;
	}
	public String getCorrectAns() {
		return correctAns;
	}
	public void setCorrectAns(String correctAns) {
		this.correctAns = correctAns;
	}
	public Integer getSubId() {
		return subId;
	}
	public void setSubId(Integer subId) {
		this.subId = subId;
	}
	@Override
	public String toString() {
		return "QuestionForm [queId=" + queId + ", question=" + question + ", opt1=" + opt1 + ", opt2=" + opt2
				+ ", opt3=" + opt3 + ", opt4=" + opt4 + ", correctAns=" + correctAns + ", subId=" + subId + "]";
	}
	
}
