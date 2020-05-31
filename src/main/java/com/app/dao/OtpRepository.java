package com.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.app.form.OtpForm;
import com.app.pojos.OTPDetail;
import com.app.pojos.User;

public interface OtpRepository extends JpaRepository<OTPDetail, Integer>{
	//User findByOtp(String otp);
	OtpForm findByOtp(String otp);
	
//	@Query("SELECT o FROM OTPDetail o ORDER BY o.generatedOn ASC LIMIT 1 WHERE o.userId=:userid")
//	OtpForm getOtpFormByUser(User userid);
	OTPDetail findTopByUserIdOrderByGeneratedOnDesc(User userId);
}
