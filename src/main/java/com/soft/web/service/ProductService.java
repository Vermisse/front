package com.soft.web.service;

import java.util.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

import com.soft.util.*;
import com.soft.web.dao.product.*;

@Service
public class ProductService {
	
	@Autowired
	private ProductMapper mapper;
	
	public List<Map> queryProduct(String product_name, Page page, String id, String state) {
		return mapper.queryProduct(product_name, page, id, state);
	}
	
	public int queryProductCount(String product_name) {
		return mapper.queryProductCount(product_name);
	}
	
	public Map<String, Object> queryProductOne(Integer product_id) {
		return mapper.queryProductOne(product_id);
	}
}