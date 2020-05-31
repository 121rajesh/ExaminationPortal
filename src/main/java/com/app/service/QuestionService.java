package com.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.QuestionsRepository;
import com.app.dao.SubjectRepository;
import com.app.form.QuestionForm;
import com.app.pojos.Question;

@Service
public class QuestionService {

	@Autowired
	QuestionsRepository quesRepo;
	@Autowired
	SubjectRepository subRepo;
	
	public List<Question> getQuestionsBySubject(Integer subId)
	{
		return quesRepo.findBySubIdSubId(subId);
	}

	public String addQuestion(QuestionForm ques) {
		Question q= new Question();
		q.setQuestion(ques.getQuestion());
		q.setCorrectAns(ques.getCorrectAns());
		q.setOpt1(ques.getOpt1());
		q.setOpt2(ques.getOpt2());
		q.setOpt3(ques.getOpt3());
		q.setOpt4(ques.getOpt4());
		q.setSubId(subRepo.findById(ques.getSubId()).get());
		quesRepo.save(q);
		return "Question added successfully !";
	}

	public Optional<Question> getQuestionById(Integer queid) {
		return quesRepo.findById(queid);
	}
	
	public String removeQuestion(Integer queId)
	{
		quesRepo.deleteById(queId);
		return "Question delete successfully";
	}
	
	public String removeAllQuestionBySubid(Integer subid)
	{
		 quesRepo.deleteAll(quesRepo.findBySubIdSubId(subid));

		return "Deleted all questions from Subject";
	}
	
	public String updateQuestion(Integer queid, QuestionForm que)
	{
		que.setQueId(queid);
		Question q= new Question();
		q.setQueId(que.getQueId());
		q.setQuestion(que.getQuestion());
		q.setCorrectAns(que.getCorrectAns());
		q.setOpt1(que.getOpt1());
		q.setOpt2(que.getOpt2());
		q.setOpt3(que.getOpt3());
		q.setOpt4(que.getOpt4());
		q.setSubId(subRepo.findById(que.getSubId()).get());
		
		quesRepo.save(q);
		return "Question updated successfully";
	}
}
