package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.QuestionsRepository;
import com.app.dao.ResultRepository;
import com.app.dao.SubjectRepository;
import com.app.dao.UserRepository;
import com.app.form.ExamDataForm;
import com.app.form.ExamForm;
import com.app.pojos.Question;
import com.app.pojos.Result;

@Service
public class ExamService {

	@Autowired
	QuestionsRepository queRepo;
	@Autowired
	ResultRepository resRepo;
	@Autowired
	UserRepository userRepo;
	@Autowired
	SubjectRepository subRepo;
	
	public Integer calculateMarks(ExamDataForm examdataform)
	{
		Integer marks=0;
		
		
		List<Question> ques =queRepo.findBySubIdSubId(examdataform.getSubId());
		
		for (ExamForm ans : examdataform.getAnsData()) 
		{
			
			for (Question question : ques) 
			{

				if(ans.getQueId() == question.getQueId())
				{
			
					if (ans.getAns().equals(question.getCorrectAns())) 
					{
			
						marks++;
					}
				}
			}
		}
		
		Result result = new Result();
		result.setUserId(userRepo.findById(examdataform.getUserId()).get());
		result.setSubId(subRepo.findById(examdataform.getSubId()).get());
		result.setScore(marks);
		
		resRepo.save(result);
		return marks;
	}
	
}
