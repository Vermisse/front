package com.soft.web.controller;

import java.io.File;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.soft.web.service.*;

/**
 * 登录Controller
 * 
 * @author vermisse
 */
@Controller
public class IndexController {
	
	private final String banner = "/upload/banner";
	
	/**
	 * 登录Service
	 */
	@Autowired
	private IndexService service;
	
	/**
	 * 进入首页
	 * @param request
	 * @return
	 */
	@RequestMapping("/index")
	public String index(HttpSession session, Model model) {
		String path = session.getServletContext().getRealPath("/");
		File file = new File(path + "/../soft" + banner);
		File[] banners = file.listFiles();
		
		model.addAttribute("banners", banners);
		return "home"; //已登录
	}
}