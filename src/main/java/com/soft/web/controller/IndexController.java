package com.soft.web.controller;

import java.io.*;
import java.util.*;

import javax.servlet.http.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.ui.*;
import org.springframework.web.bind.annotation.*;

import com.soft.util.Black;
import com.soft.util.Page;
import com.soft.util.Text;
import com.soft.web.service.*;

/**
 * 登录Controller
 * 
 * @author vermisse
 */
@Controller
public class IndexController {
	
	private final String banner = "/upload/file";
	
	/**
	 * 登录Service
	 */
	@Autowired
	private IndexService service;
	
	@Autowired
	private BannerService bannerService;
	
	@Autowired
	private ProductService productService;
	
	/**
	 * 进入首页
	 * @param request
	 * @return
	 */
	@RequestMapping("/index")
	public String index(Model model) {
		// 轮播
		List banners = bannerService.queryBanner();
		model.addAttribute("banners", banners);

		// 产品列表
		List products = productService.queryProduct(null, new Page());
		model.addAttribute("products", products);
		return "home"; //已登录
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login() {
		return "login";
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String register() {
		return "sign";
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String register(String user_name, String password, String mobile, String invite_id, Model model) {
		String real_name = "用户";
		
		List<Map<String, Object>> list = service.checkUser(user_name, mobile, null);
		if(list.size() == 2){
			model.addAttribute("message", "用户名和手机号均已存在");
			return "sign";
		}
		if(list.size() == 1){
			Map<String, Object> map = list.get(0);
			if(map.get("user_name").equals(user_name))
				model.addAttribute("message", "用户名已存在");
			else
				model.addAttribute("message", "手机号已存在");
			return "sign";
		}
		
		int id = service.save(user_name, password, real_name, mobile, invite_id);
		model.addAttribute("invite_id", Text.encode(id));
		return "redirect:register.html";
	}
	
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	@ResponseBody
	public String login(String password, String mobile, Model model) {
		List<Map<String, Object>> list = service.queryUserByLogin(mobile, Black.passwd(password));
		if(list.size() <= 0){
			return "{\"code\":\"0\"}";
		}
		System.out.println(list.get(0).get("user_id"));
		return "{\"code\":" + list.get(0).get("user_id") + "}";
	}
	
}