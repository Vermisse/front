package com.soft.web.service;

import java.util.*;

import org.apache.log4j.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

import com.soft.web.dao.user.*;

@Service
public class IndexService {
	
	private static Logger logger = Logger.getLogger(IndexService.class);
	
	@Autowired
	private UserMapper mapper;
	
	public List<Map<String, Object>> queryUser(String user_name, String mobile) {
		return mapper.queryUser(user_name, mobile);
	}
	
	public int save(String user_name, String password, String real_name, String mobile, Integer invite_id) {
		return mapper.save(user_name, password, real_name, mobile, invite_id);
	}
}