package com.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.pojos.User;

public interface UserRepository extends JpaRepository<User, Integer> {

	User findByEmailIdAndPassword(String email, String password);
	User findByEmailId(String email);
}
