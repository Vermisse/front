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
	
	public List<Map> queryProduct(String product_name, Page page) {
		return mapper.queryProduct(product_name, page);
	}
	
	public int queryProductCount(String product_name) {
		return mapper.queryProductCount(product_name);
	}
	
	public int save(String product_name,
			Double product_price,
			String description,
			String feature,
			String price_description,
			String stroke,
			String notice,
			String filepath) {
		return mapper.save(product_name, product_price, description, feature, price_description, stroke, notice, filepath);
	}
	
	public void update(int product_id) {
		mapper.update(product_id);
	}
}