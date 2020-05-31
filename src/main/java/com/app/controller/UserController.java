package com.app.controller;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.form.FeedbackInputForm;
import com.app.form.OtpInputForm;
import com.app.pojos.Response;
import com.app.pojos.User;
import com.app.service.FeedbackService;
import com.app.service.UserService;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;
	@Autowired
	private FeedbackService fdbkService;
	
	@PostMapping("/register")
	public Response register(@RequestBody User user)
	{
		
		return new Response(userService.registerUser(user),"Sucess");
	}
	
	@PostMapping("/login")
	public Response login(@RequestBody User user)
	{
		
		System.out.println(user.getEmailId());
		if(userService.loginUser(user) != null)
		return new Response(userService.loginUser(user),"Success");
		return new Response("Invalid emailId or password","Fail");
	}

	@GetMapping("/userdetails/{userid}")
	public Response getUser(@PathVariable Integer userid)
	{
		System.out.println(userid);
		return new Response(userService.getUser(userid),"Success");
	}
	
	@PostMapping("/updateuser/{userid}")
	public Response updateUser(@PathVariable Integer userid, @RequestBody User user)
	{
		System.out.println(user.getEmailId());
		//System.out.println(userid);
		return new Response(userService.updateUser(userid,user),"Success");
	}
	
	@PostMapping("/changepassword")
	public Response changePassword(@RequestBody User user)
	{
		return new Response(userService.updatePassword(user),"Success");
	}
	
	@PostMapping("/forgotpassword")
	public Response resetPassword(@RequestBody User user)
	{
		if(userService.forgotPassword(user.getEmailId())==1)
		{
			return new Response("Temporary password sent to your email id", "Success");
		}
		else {
			return new Response("Please enter valid email address", "Success");
		}
	}
	
	@PostMapping("/validateotp")
	public Response validateOtp(@RequestBody OtpInputForm otpinform)
	{
		return userService.validateOtp(otpinform.getEmailId(), otpinform.getOtp());
	}
	
	@PostMapping("/feedback")
	public Response sumbitFeedback(@RequestBody FeedbackInputForm feedback)
	{
		return fdbkService.addFeedback(feedback);
		
	}
	
}
