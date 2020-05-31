package com.app.service;

import org.springframework.stereotype.Service;

@Service
public class OtpService {

	public static String generateOtp(Integer len)
	{
		//Create a alpha-numeric string 
		String charaters = 	"ABCDEFGHIJKLMNOPQRSTUVWXYZ"+
							"abcdefghijklmnopqrstuvwxyz"+
							"0123456789";
		//create a string buffer size of alpha-numeric string 
		StringBuilder otp = new StringBuilder(len);
		
		//get random characters from alphanumeric string
		for (int i = 0; i < len; i++) {
		
			int index = (int) (charaters.length()*Math.random());
			
			//append  random characters from alpha-numeric string to otp
			otp.append(charaters.charAt(index));
		}
		System.out.println(otp.toString());
		return otp.toString();
	}
}
