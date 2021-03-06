package com.soft.web.service;

import java.util.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

import com.soft.web.dao.banner.*;

@Service
public class BannerService {

	@Autowired
	private BannerMapper mapper;

	public List<Map<String, Object>> queryBanner() {
		return mapper.queryBanner();
	}
}