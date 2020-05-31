package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.form.QuestionForm;
import com.app.pojos.Question;
import com.app.pojos.Response;
import com.app.service.QuestionService;

@CrossOrigin(origins = "*",allowedHeaders = "*")
@RestController
@RequestMapping("/question")
public class QuestionController {

	@Autowired
	QuestionService queService;
	
	@PostMapping()
	public Response addQuestion(@RequestBody QuestionForm ques)
	{
		System.out.println("add ques");
		System.out.println(ques.getSubId());
//		System.out.println(subId);
		return new Response(queService.addQuestion(ques),"Success");
	}	
	
	@GetMapping("getquestion/{queId}")
	public Response getQueById(@PathVariable Integer queId)
	{
		return new Response(queService.getQuestionById(queId),"Success");
	}
	
	@GetMapping("/getquestionbysubj/{subId}")
	public Response getQuesBySubId(@PathVariable Integer subId)
	{
		return new Response(queService.getQuestionsBySubject(subId), "Success");
	}
	
	@PostMapping("/update/{queId}")
	public Response updateQuestion(@PathVariable Integer queId,@RequestBody QuestionForm ques)
	{
		return new Response(queService.updateQuestion(queId, ques), "Success");
	}
	@DeleteMapping("/{queId}")
	public Response deleteQuestion(@PathVariable Integer queId)
	{
		return new Response(queService.removeQuestion(queId), "Success");
	}
	
	@DeleteMapping("/allquestionbysubj/{subId}")
	public Response deleteQuestionBySubId(@PathVariable Integer subId)
	{
		return new Response(queService.removeAllQuestionBySubid(subId), "Success");
	}
}
