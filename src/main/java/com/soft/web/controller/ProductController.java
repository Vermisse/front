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

	@RequestMapping(value = "add", method = RequestMethod.GET)
	public String add() {
		return "manage/productAdd";
	}

	@RequestMapping(value = "add", method = RequestMethod.POST)
	public String add(String product_name,
			Double product_price,
			String description,
			String feature,
			String price_description,
			String stroke,
			String notice,
			String filepath) {
		service.save(product_name, product_price, description, feature, price_description, stroke, notice, filepath);
		return "redirect:/product/list.html";
	}
	
	@RequestMapping("update")
	public String update(int product_id) {
		service.update(product_id);
		return "redirect:/product/list.html";
	}
}