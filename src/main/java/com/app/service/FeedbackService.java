package com.app.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.app.dao.FeedbackRepository;
import com.app.dao.UserRepository;

import com.app.form.FeedbackInputForm;
import com.app.pojos.Feedback;
import com.app.pojos.Response;

@Service
public class FeedbackService {

	@Autowired
	FeedbackRepository fdbkRepo;
	
	@Autowired
	UserRepository userRepo;
	
	public Response addFeedback(FeedbackInputForm fdbkform)
	{
		Feedback fdbk = new Feedback();
		fdbk.setMessage(fdbkform.getMessage());
		fdbk.setUserId(userRepo.findById(fdbkform.getUserId()).get());
		if(fdbkform.getMessage()!=null)
		{
			fdbkRepo.save(fdbk);
			return new Response("Your feedback submitted !!","Success");
		}
		else
			return new Response("Feedback cannot be blank","Fail");
		
	}
	
	public List<Map<String, String>> getAllFeedbacks()
	{
		List<Object[]> objList = fdbkRepo.getAllFeedbacks();
		List<Map<String, String>> fdbkMapList = new ArrayList<Map<String,String>>();
	
		for (Object[] obj : objList) {
			Map<String, String> fdbkMap = new HashMap<String, String>();
			fdbkMap.put("fdbkId", obj[0].toString());
			fdbkMap.put("name", obj[1].toString());
			fdbkMap.put("emailId", obj[2].toString());
			fdbkMap.put("message", obj[3].toString());
			
			fdbkMapList.add(fdbkMap);
		}
		return fdbkMapList;
	}
	
}
