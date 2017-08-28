package com.soft.web.service;

import java.util.*;

import org.apache.log4j.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

import com.soft.util.Text;
import com.soft.web.dao.user.*;

@Service
public class IndexService {
	
	private static Logger logger = Logger.getLogger(IndexService.class);
	
	@Autowired
	private UserMapper mapper;
	
	public List<Map<String, Object>> checkUser(String user_name, String mobile, String password) {
		return mapper.queryUser(null, user_name, mobile, password);
	}
	
	public List<Map<String, Object>> queryUserByLogin(String mobile, String password) {
		return mapper.queryUserByLogin(mobile, password);
	}
	
	public boolean checkInvite(String invite_id) {
		return mapper.queryUser(invite_id, null, null, null).size() > 0;
	}
	
	/**
	 * 于志强
	 * @param id
	 * @return
	 */
	public List<Map<String, Object>> queryUser(String id) {
		return mapper.queryUser(id, null, null, null);
	}
	
	public int save(String user_name, String password, String real_name, String mobile, String invite_id) {
		Integer invite = Text.decode(invite_id);
		if(invite != null){
			if(mapper.queryUser(invite_id, null, null, null).size() == 0){
				invite = null;
			}
		}
		
		return mapper.save(user_name, password, real_name, mobile, invite);
	}
}