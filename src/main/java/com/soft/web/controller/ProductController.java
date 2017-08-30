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
	
	@RequestMapping("list")
	public String list(String product_name, Page page, Model model) {
		List<Map> list = service.queryProduct(product_name, page);
		int count = service.queryProductCount(product_name);
		page.setCount(count);
		
		model.addAttribute("list", list);
		model.addAttribute("page", page);
		return "manage/product";
	}
}