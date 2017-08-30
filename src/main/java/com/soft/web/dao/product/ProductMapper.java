package com.soft.web.dao.product;

import java.util.*;

import org.apache.ibatis.annotations.*;

import com.soft.util.*;

public interface ProductMapper {
	
	List<Map> queryProduct(@Param("product_name") String product_name, @Param("page") Page page);
	
	int queryProductCount(@Param("product_name") String product_name);
	
	Map<String, Object> queryProductOne(@Param("product_id") Integer product_id);
}