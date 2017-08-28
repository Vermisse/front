package com.soft.web.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.soft.util.Page;
import com.soft.web.service.BannerService;
import com.soft.web.service.ProductService;

/**
 * 首页
 * @author wang
 *
 */
@Controller
//@RequestMapping("banner")
public class HomeController {
	
	@Autowired
	private BannerService bannerService;
	@Autowired
	private ProductService productService;
	
	@RequestMapping("list")
	public String list(HttpSession session, Model model) {
		// 轮播
		List bannerList = bannerService.queryBanner();
		model.addAttribute("bannerList", bannerList);
		
		// 产品列表
		List productList = productService.queryProduct(null, new Page());
		model.addAttribute("productList", productList);
		return "home";
	}
}