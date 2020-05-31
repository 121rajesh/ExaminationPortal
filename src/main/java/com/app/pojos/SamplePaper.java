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
//@Table(name = "T_SAMPLE_PAPER")
public class SamplePaper {

	private Integer paperId;
	private Subject subId;
	private String pdf;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "paperId")
	public Integer getPaperId() {
		return paperId;
	}
	
	public void setPaperId(Integer paperId) {
		this.paperId = paperId;
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
	
	
	public String getPdf() {
		return pdf;
	}
	public void setPdf(String pdf) {
		this.pdf = pdf;
	}
	
	
}
