package com.soft.web.dao.user;

import java.util.*;

import org.apache.ibatis.annotations.*;

public interface UserMapper {

	public List<Map<String, Object>> queryUser(@Param("user_name") String user_name, @Param("mobile") String mobile);
	
	public int save(@Param("user_name") String user_name,
			@Param("password") String password,
			@Param("real_name") String real_name,
			@Param("mobile") String mobile,
			@Param("invite_id") Integer invite_id);
}