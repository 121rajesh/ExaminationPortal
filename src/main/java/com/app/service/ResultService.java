package com.app.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.ResultRepository;
import com.app.form.ResultForm;
import com.app.form.ResultOutForm;
import com.app.pojos.Result;

import lombok.var;

@Service
public class ResultService {

	@Autowired 
	ResultRepository resRepo;
	
//	public 
	
	public List<ResultForm> getResultByUser(Integer userid)
	{
		return resRepo.findByUserIdUserId(userid);
		
	}
	
	public List<ResultForm> getResultByUserAndBySubject(Integer userId, Integer subId)
	{
		return resRepo.findByUserIdUserIdAndSubIdSubId(userId, subId);
	}

	public List<Map<String, String>> getResult() {
		List<Object[]> res =resRepo.getAllResult();
		List<Map<String, String>> resMapList = new ArrayList<Map<String,String>>();
		
		for(Object[] obj : res) {
//			String [] obj = obj.toString().split(",");
			Map<String, String> resMap = new HashMap<String, String>() ;
			resMap.put("score", obj[0].toString() );
			resMap.put("name", obj[1].toString() );
			resMap.put("emailId", obj[2].toString() );
			resMap.put("subName", obj[3].toString() );
			resMapList.add(resMap);			
		}
		
		return resMapList;
		
	}
}
