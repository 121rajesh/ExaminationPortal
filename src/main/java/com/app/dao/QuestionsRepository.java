package com.app.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.pojos.Question;

public interface QuestionsRepository extends JpaRepository<Question, Integer>{

		List<Question> findBySubIdSubId(Integer subId);
		void deleteBySubIdSubId(Integer subId);
}
