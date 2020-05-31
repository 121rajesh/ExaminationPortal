package com.app.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.app.pojos.Subject;
import com.app.dao.SubjectRepository;

@Service
public class SubjectService {

	@Autowired
	SubjectRepository subRepo;

	public Iterable<Subject> getAllSubjects() {
		
		return subRepo.findAll();
	}
	
	public Optional<Subject> getSubject(Integer subid)
	{
		return subRepo.findById(subid);
	}
	
	public String addSubject(Subject subj)
	{
		subRepo.save(subj);
		return "Subject added successfully";
	}
	
	public String removeSubject(Integer id)
	{
		subRepo.deleteById(id);
		return "Subject removed successfully";
	}
	
	public String updateSubject(Integer subid,Subject subj)
	{
		subj.setSubId(subid);
		subRepo.save(subj);
		return "Subject name updated";
	}
}
