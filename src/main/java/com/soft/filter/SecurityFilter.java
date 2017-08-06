package com.soft.filter;

import java.util.*;

import javax.annotation.*;
import javax.servlet.http.*;

import org.springframework.web.servlet.handler.*;

import com.alibaba.fastjson.*;
import com.soft.util.*;

/**
 * 登录权限过滤器
 */
public class SecurityFilter extends HandlerInterceptorAdapter {
	
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		String auth = null;
		String url = request.getServletPath().toString();
		
		Cookie[] cookies = request.getCookies();
		if(cookies != null)
			for (Cookie cookie : cookies)
				if (cookie.getName().equals("auth")){
					auth = cookie.getValue(); //读取凭证
					break;
				}

		//走到这里基本上不会出现user为空
		System.out.println("用户凭证:" + auth);
		System.out.println("用户请求:" + request.getHeader("user-agent"));
		
		//如果已经是登录状态拦截登录操作
		if (url.equals("/login.html")) {
			response.sendRedirect(request.getContextPath() + "/index.html");
			return super.preHandle(request, response, handler);
		}
		
		request.setAttribute("auth", auth);
		request.setAttribute("path", request.getContextPath());
		
		return super.preHandle(request, response, handler);
	}
}