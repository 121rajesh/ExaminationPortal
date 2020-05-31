package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.form.ResultInputForm;
import com.app.pojos.Response;
import com.app.service.ResultService;

@CrossOrigin(allowedHeaders = "*", origins = "*")
@RestController
@RequestMapping("/result")
public class ResultController {
	
	@Autowired
	ResultService resService;
	
	@GetMapping()
	public Response getAllUsersResults()
	{
		return new Response(resService.getResult(), "Success");
	}
	
	@GetMapping("/byuser/{userId}")
	public Response getResult(@PathVariable Integer userId)
	{
		return new Response(resService.getResultByUser(userId), "Success");
	}
	
	@PostMapping("/byuserandsubject")
	public Response getResultByUserAndSubject(@RequestBody ResultInputForm rif)
	{
		return new Response(resService.getResultByUserAndBySubject(rif.getUserId(),rif.getSubId()), "Success");
	}
	
	//calculate marks kidhar likhu bc
	//marks to question table me correctAns match hoke pata chalenge na
	//uske liye exam ka controller hai na
	//usmne hi kar... sub data la          frontend se backend mei
	//ok sala angular me hi changes karne padenge abhi to
	//mar jayega me usme hi
	//	
	
	
	
	
	
	
	
	
	
	
	
}
