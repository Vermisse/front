package com.soft.web.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.soft.web.dao.config.ConfigMapper;

@Service
public class ConfigService {

	@Autowired
	private ConfigMapper mapper;

	public Map<String, Object> queryConfig() {
		return mapper.queryConfig();
	}
}