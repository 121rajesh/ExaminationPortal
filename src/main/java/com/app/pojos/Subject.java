package com.app.pojos;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
//@Table(name = "T_SUBJECTS")
public class Subject {
	private Integer subId;
	private String subName;
	
	private List<Question> ques = new ArrayList<>();
	
	@JsonIgnore
	@OneToMany(mappedBy = "subId", cascade = CascadeType.ALL, orphanRemoval = true)
	public List<Question> getQues() {
		return ques;
	}

	public void setQues(List<Question> ques) {
		this.ques = ques;
	}
	
	private List<SamplePaper> samplePapers = new ArrayList<>();

	@JsonIgnore
	@OneToMany(mappedBy = "subId", cascade = CascadeType.ALL, orphanRemoval = true)
	public List<SamplePaper> getSamplePapers() {
		return samplePapers;
	}

	public void setSamplePapers(List<SamplePaper> samplePapers) {
		this.samplePapers = samplePapers;
	}

	private List<Result>results = new ArrayList<>();
	
	@JsonBackReference
	@OneToMany(mappedBy = "subId", cascade = CascadeType.ALL, orphanRemoval = true)
	public List<Result> getResults() {
		return results;
	}

	public void setResults(List<Result> results) {
		this.results = results;
	}

	public Subject() {
		// TODO Auto-generated constructor stub
	}
	
	public Subject(Integer subId, String subName) {
		super();
		this.subId = subId;
		this.subName = subName;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "subId")
	public Integer getSubId() {
		return subId;
	}

	public void setSubId(Integer subId) {
		this.subId = subId;
	}
	
	@Column(name = "subName",length = 30, nullable = false, unique = true)
	public String getSubName() {
		return subName;
	}

	public void setSubName(String subName) {
		this.subName = subName;
	}
	
	

}
