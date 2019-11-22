package com.skillstrom.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.skillstrom.data.TimeSheet;
import com.skillstrom.data.User;
import com.skillstrom.services.Service;

public class UserController {
	
	Service userService = new Service();
	
	public void getUser(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		System.out.println("Running controller....");
		String inputUserName = req.getParameter("username");
		String inputPassword = req.getParameter("password");
		User foundUser = userService.getUser(inputUserName, inputPassword);
		if (foundUser.getId()!= 0) {
			req.getSession().setAttribute("userInfo", foundUser);
			resp.sendRedirect("/drstrange/login.html");
		}
		else {
			resp.sendRedirect("/drstrange");
		}
		
	}
	
	public void getUserTimeSheets(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		resp.setContentType("application/json");
		User signedInUser = (User)req.getSession().getAttribute("userInfo");
		System.out.println("in getUserTimeSheet method " + signedInUser);
		List<TimeSheet> timeSheets = userService.getUserTimeSheet(signedInUser.getId());
		System.out.println(timeSheets);
		resp.getWriter().println(new ObjectMapper().writeValueAsString(timeSheets));
	}
}
