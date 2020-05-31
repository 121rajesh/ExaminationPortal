package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.pojos.Response;
import com.app.pojos.Subject;
import com.app.pojos.User;
import com.app.service.FeedbackService;
import com.app.service.SubjectService;
import com.app.service.UserService;

@CrossOrigin(origins = "*",allowedHeaders = "*")
@RestController
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	UserService userService;
	
	@Autowired
	SubjectService subService;
	
	@Autowired
	FeedbackService fdbkService;
	
	@GetMapping("/users")
	public Response getUserList()
	{
		return new Response(userService.getAllUsers(),"Sucess");
	}
	
	
	
//	@PutMapping("/manageUsers")
//	public User manageUser(@RequestBody User user)
//	{
//		return userservice.modifyUser(user);
//	}
	
	@GetMapping("/subjects")
	public Response getSubjectList()
	{
		return new Response(subService.getAllSubjects(),"Success"); 
	}
	
	@GetMapping("/subject/{subId}")
	public Response getSubject(@PathVariable Integer subId)
	{
		System.out.println("get subject");
		return new Response(subService.getSubject(subId), "Success");
	}
	
	@PostMapping("/subjects")
	public Response addSubject(@RequestBody Subject subj)
	{
		System.out.println("adddddddd");
		Response response =new Response();
		//response.setStatus(subService.addSubject(subj));
		response.setStatus("Success");
		response.setData(subService.addSubject(subj));
		return response;
		
	}
	
	@PostMapping("/updatesubject")
	public Response updateSubject(@PathVariable Integer subid, @RequestBody Subject sub)
	{
		return new Response(subService.updateSubject(subid,sub),"Sucess");
	}
	
	@DeleteMapping("/subjects/{subid}")
	public Response deleteSubject(@PathVariable Integer subid)
	{
		return new Response(subService.removeSubject(subid),"Sucess"); 
	}
	
	@GetMapping("/feedback")
	public Response getFeedbacks()
	{
		return new Response(fdbkService.getAllFeedbacks(), "Success");
	}
}
