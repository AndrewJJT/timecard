package com.skillstrom.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.skillstrom.data.TimeSheet;
import com.skillstrom.data.User;
import com.skillstrom.services.Service;

public class UserController {
	
	private Service userService = new Service();
	
	public void getUser(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		System.out.println("Running controller....");
		String inputUserName = req.getParameter("username");
		String inputPassword = req.getParameter("password");
		User foundUser = userService.getUser(inputUserName, inputPassword);
		if (foundUser.getId()!= 0) {
			req.getSession().setAttribute("userInfo", foundUser);
			resp.addCookie(new Cookie("id", String.valueOf(foundUser.getId())));
			resp.sendRedirect("/drstrange/login.html");
		}
		else {
			resp.sendRedirect("/drstrange");
		}
		
	}
	
	public void getUserInfo(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		System.out.println("Running controller....");
		User signedUser = (User)(req.getSession().getAttribute("userInfo"));
		signedUser.setUserName("null");
		signedUser.setPassword("null");
		resp.getWriter().println(new ObjectMapper().writeValueAsString(signedUser));
	}
	
	public void logoutUser(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		resp.setContentType("application/json");
		req.getSession().invalidate();
		resp.sendRedirect("/drstrange/index.html");
	}
}
