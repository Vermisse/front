package com.soft.web.service;

import java.util.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

import com.soft.util.*;
import com.soft.web.dao.ticket.*;

@Service
public class TicketService {

	@Autowired
	private TicketMapper mapper;
	
	public List<Map> queryTickets(String ticket_name, Page page, String state) {
		return mapper.queryTickets(ticket_name, page, state);
	}
	
	public int queryTicketsCount(String ticket_name) {
		return mapper.queryTicketsCount(ticket_name);
	}
	
	public Map<String, Object> queryTicket(int ticket_id) {
		return mapper.queryTicket(ticket_id);
	}
}