package com.soft.web.dao.product;

import java.util.*;

import org.apache.ibatis.annotations.*;

import com.soft.util.*;

public interface ProductMapper {
	
	List<Map> queryProduct(@Param("product_name") String product_name, @Param("page") Page page);
	
	int queryProductCount(@Param("product_name") String product_name);
	
	int save(@Param("product_name") String product_name,
			@Param("product_price") Double product_price,
			@Param("description") String description,
			@Param("feature") String feature,
			@Param("price_description") String price_description,
			@Param("stroke") String stroke,
			@Param("notice") String notice,
			@Param("filepath") String filepath);
	
	void update(@Param("product_id") int product_id);
}