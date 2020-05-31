package com.app.service;

import java.util.Calendar;
import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.OtpRepository;
import com.app.dao.PasswordHistoryRepository;
import com.app.dao.UserRepository;
import com.app.form.OtpForm;
import com.app.form.PasswordHistoryForm;
import com.app.pojos.OTPDetail;
import com.app.pojos.PasswordHistory;
import com.app.pojos.Response;
import com.app.pojos.User;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private EmailService emailService;
	
	@Autowired
	private OtpRepository otpRepo;
	
	@Autowired
	private PasswordHistoryRepository pwdhisRepo;
	
	public User loginUser(User user)
	{
		System.out.println(userRepo.findByEmailIdAndPassword(user.getEmailId(), user.getPassword()));
		return userRepo.findByEmailIdAndPassword(user.getEmailId(), user.getPassword());
		
	}

	public String registerUser(User user) {
		String msg="";
		
		if (userRepo.findByEmailId(user.getEmailId())!=null)
		{
			return "This email id is already registered !!!";
		}
		else {
			if(user.getRole().toString().equals("ADMIN")) {
				msg = "Dear "+user.getEmailId()+", You are admin on Online Examination Portal. "+
						 "You can now login to "+"http://localhost:4200/login";
			}else {
				msg = "Dear "+user.getEmailId()+", You are registered on Online Examination Portal. "+
						 "You can now login to "+"http://localhost:4200/login"; 
			}
			userRepo.save(user);
			emailService.sendMail(user.getEmailId(), "Registration on Online Examinayion Portal !", msg);
			return "User registered successfully !!";
		}
	}

	
	
	
	public Iterable<User> getAllUsers() {
		return userRepo.findAll();
	}

	public Optional<User> getUser(Integer userid) {
		Optional<User> user = userRepo.findById(userid);
		System.out.println("In service method ");
		return user;
	}
	
	public String updateUser(Integer userid,User user)
	{
		user.setUserId(userid);
		User u =userRepo.findByEmailId(user.getEmailId());
		
		Date currentDate = new Date();
		//System.out.println(currentDate.getDate());
		PasswordHistoryForm pwdhis = new PasswordHistoryForm();
		PasswordHistory pwd = new PasswordHistory();	

		pwd.setOldPassword(u.getPassword());
		pwd.setNewPassword(user.getPassword());
		pwd.setChangedOn(currentDate);
		pwdhis.setUserId(userid);
		System.out.println("before save call "+pwdhis.getChangedOn());
		userRepo.save(user);
		pwd.setUserId(userRepo.findById(pwdhis.getUserId()).get());
//		System.out.println(pwdhisRepo.findById(pwdhis.getUserId()));
		pwdhisRepo.save(pwd);
		return "User details updated successfully";
	}

	public int forgotPassword(String email) {
			User user=userRepo.findByEmailId(email);
		if( user != null)
		{
			String otp = OtpService.generateOtp(5);
			
			OtpForm otpForm = new OtpForm();
			otpForm.setUserId(user.getUserId());
			
			Date currentDate = new Date();
			Calendar c = Calendar.getInstance();
			c.setTime(currentDate);
			
			OTPDetail otpDetails = new OTPDetail();
			otpDetails.setUserId(userRepo.findById(otpForm.getUserId()).get());
			otpDetails.setGeneratedOn(c.getTime());
			otpDetails.setOtp(otp);
			c.add(Calendar.MINUTE, 20);
			otpDetails.setValidTill(c.getTime());
			
			otpRepo.save(otpDetails);
			
			emailService.sendMail(email,"Reset password mail","Your temporary password is "+otp+". Change your password after login.");
			
			return 1;
		}
		return 0;
	}
	
	public Response validateOtp(String email, String otp)
	{
		User user=userRepo.findByEmailId(email);
		OTPDetail otpForm =otpRepo.findTopByUserIdOrderByGeneratedOnDesc(user);
		if(otpForm!=null)
		{
			if(otpForm.getValidTill().after(new Date()))
			{
				if(otpForm.getOtp().equals(otp))
				{
					return new Response("OTP is verified", "Success");
				}
				else
				{
					return new Response("Invalid otp", "Fail");
				}
			}
			return new Response("OTP is expired", "Fail");
		}
		return new Response("OTP is not Created", "Fail");
	}

	public String updatePassword(User user) {
	
		
		
		User u =userRepo.findByEmailId(user.getEmailId());
		user.setUserId(u.getUserId());
		user.setName(u.getName());
		user.setMobile(u.getMobile());
		user.setRole(u.getRole());
		Date currentDate = new Date();
		//System.out.println(currentDate.getDate());
		PasswordHistoryForm pwdhis = new PasswordHistoryForm();
		PasswordHistory pwd = new PasswordHistory();	

		pwd.setOldPassword(u.getPassword());
		pwd.setNewPassword(user.getPassword());
		pwd.setChangedOn(currentDate);
		pwdhis.setUserId(user.getUserId());
		System.out.println("before save call "+pwdhis.getChangedOn());
		userRepo.save(user);
		pwd.setUserId(userRepo.findById(pwdhis.getUserId()).get());
//		System.out.println(pwdhisRepo.findById(pwdhis.getUserId()));
		pwdhisRepo.save(pwd);
		return "User password updated successfully";
	}
}
