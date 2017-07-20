package com.xc.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xc.service.UserService;

@Controller
@RequestMapping("/mvc")
public class UserController {
	@Autowired
	private UserService userServiceBean;

	@RequestMapping(value = "/hello")
	public void Hello(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
	}
}
