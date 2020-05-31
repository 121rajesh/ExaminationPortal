package com.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.pojos.PasswordHistory;

public interface PasswordHistoryRepository extends JpaRepository<PasswordHistory,Integer>{

}
