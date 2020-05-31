package com.app.dao;

import java.util.List;

import javax.persistence.NamedQuery;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.app.form.ResultForm;
import com.app.form.ResultOutForm;
import com.app.pojos.Result;

public interface ResultRepository extends JpaRepository<Result, Integer> {

	List<ResultForm> findByUserIdUserId(Integer userId);
	List<Result> findBySubIdSubId(Integer subId);
	List<ResultForm> findByUserIdUserIdAndSubIdSubId(Integer userId, Integer subId);
	
	@Query("SELECT r.score,r.userId.name, r.userId.emailId, r.subId.subName FROM Result r")
	List<Object[]> getAllResult();

}