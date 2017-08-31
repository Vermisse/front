package com.soft.web.controller;

import java.util.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.ui.*;
import org.springframework.web.bind.annotation.*;

import com.soft.util.*;
import com.soft.web.service.*;

@Controller
@RequestMapping("product")
public class ProductController {

	@Autowired
	private ProductService service;
	@Autowired
	private ConfigService configService;
	
	@RequestMapping("list")
	public String list(String product_name, Page page, Model model, String id) {
		List<Map> list = service.queryProduct(product_name, page, id, "1");
		int count = service.queryProductCount(product_name);
		page.setCount(count);
		
		model.addAttribute("list", list);
		model.addAttribute("page", page);
		model.addAttribute("config", configService.queryConfig());
		return "productList";
	}
	
	@RequestMapping("detail")
	public String detail(int product_id, Model model) {
		Map<String, Object> map = service.queryProductOne(product_id);
		
		model.addAttribute("map", map);
		
		model.addAttribute("config", configService.queryConfig());
		
		return "productDetail";
	}
}