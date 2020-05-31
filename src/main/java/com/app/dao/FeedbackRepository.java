package com.app.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import com.app.pojos.Feedback;

public interface FeedbackRepository extends JpaRepository<Feedback, Integer>{

	@Query("SELECT f.fdbkId, f.userId.name, f.userId.emailId, f.message FROM Feedback f")
	List<Object[]> getAllFeedbacks();
}
