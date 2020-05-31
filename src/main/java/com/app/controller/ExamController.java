package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.form.ExamDataForm;
import com.app.form.ExamForm;
import com.app.pojos.Response;
import com.app.service.ExamService;

@CrossOrigin(origins = "*",allowedHeaders = "*")
@RestController
@RequestMapping("/exam")
public class ExamController {

	@Autowired
	ExamService examService;
	
	@PostMapping("/paper")
	public Response submitExamData(@RequestBody ExamDataForm examDataForm)
	{
		return new Response(examService.calculateMarks(examDataForm), "Success");
	}
	
}
	