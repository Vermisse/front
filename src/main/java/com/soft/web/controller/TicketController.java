package com.soft.web.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.soft.util.CookieUtil;
import com.soft.util.Page;
import com.soft.web.service.ConfigService;
import com.soft.web.service.TicketService;

@Controller
@RequestMapping("ticket")
public class TicketController {

	@Autowired
	private TicketService ticketService;
	@Autowired
	private ConfigService configService;
	
	@RequestMapping("list")
	public String list(Model model, Page page, HttpServletRequest request) {
		model.addAttribute("config", configService.queryConfig());
		String id = CookieUtil.getCookie(request);
		List<Map> list = ticketService.queryTickets(null, page, "1");
		int count = ticketService.queryTicketsCount(null);
		page.setCount(count);
		
		model.addAttribute("list", list);
		model.addAttribute("page", page);
		return "/ticketList";
	}
}