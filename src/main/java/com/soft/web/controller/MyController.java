package com.soft.web.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.soft.util.CookieUtil;
import com.soft.util.DateUtil;
import com.soft.web.dao.model.InsertModel;
import com.soft.web.service.ConfigService;
import com.soft.web.service.IndexService;
import com.soft.web.service.MyService;

/**
 * 私人订制操作类
 * @author wang
 *
 */
@Controller
@RequestMapping("my")
public class MyController {
	// 时间格式
	private final String format = "yyyy-MM-dd HH:mm:ss";
	
	@Autowired 
	private MyService myService;
	@Autowired 
	private IndexService indexService;
	@Autowired
	private ConfigService configService;
	
	@RequestMapping("addMy")
	public String my(Model model) {
		model.addAttribute("config", configService.queryConfig());
		return "/my";
	}
		
	
	/**
	 * 添加私人订制订单
	 * @param peopleNum 私人订制人数
	 * @param address  私人订制地点
	 * @param checkStartTiIme 私人订制开始时间
	 * @param checkEndTime 私人订制结束时间
	 */
	@RequestMapping("add")
	@ResponseBody
	public String addMy(String peopleNum, String userName, String userTel, String tripMode, HttpServletRequest request) {
		// 获取登陆者的用户名+手机号码
//		String userName = "";
//		String userTel = "";
		if(userName == null || "".equals(userName) || 
				userTel == null || "".equals(userTel)) {
			List<Map<String, Object>> list = indexService.queryUser(CookieUtil.getCookie(request));
			if(list.size() > 0) {
				userName = (String)list.get(0).get("real_name");
				userTel = (String)list.get(0).get("mobile");
			}
		}
		String createTime = DateUtil.getNow(format);
		String updateTime = DateUtil.getNow(format);
		InsertModel insertModel = new InsertModel();
		insertModel.setCreateTime(createTime);
		insertModel.setPeopleNum(peopleNum);
		insertModel.setUpdateTime(updateTime);
		insertModel.setUserName(userName);
		insertModel.setUserTel(userTel);
		insertModel.setTripMode(tripMode);
		insertModel.setuId(CookieUtil.getCookie(request)); // 用户id
		myService.addMy(insertModel);
		int id = insertModel.getId();
		return "{\"id\":" + id + "}";
	}
	
	@RequestMapping("list")
	public String list(Model model, HttpServletRequest request) {
		String id = CookieUtil.getCookie(request);
		if("".equals(id)) {
			return "redirect:/login.html";
		}
		List<Map> list = myService.queryMyList(id);
		
		model.addAttribute("list", list);
		model.addAttribute("config", configService.queryConfig());
		return "/myList";
	}
	
}