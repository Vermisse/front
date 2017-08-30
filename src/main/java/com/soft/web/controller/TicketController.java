package com.soft.web.controller;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;

import com.soft.web.service.*;

@Controller
@RequestMapping("ticket")
public class TicketController {

	@Autowired
	private TicketService service;
}