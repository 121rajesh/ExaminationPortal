package com.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

	@Autowired
	JavaMailSender emailSender;
	
	public 	void sendMail(String toEmail, String subject, String message)
	{
		SimpleMailMessage mailMessage = new SimpleMailMessage();
		
		mailMessage.setTo(toEmail);	
		mailMessage.setSubject(subject);
		mailMessage.setText(message);
		
		emailSender.send(mailMessage);
	
	}
}
