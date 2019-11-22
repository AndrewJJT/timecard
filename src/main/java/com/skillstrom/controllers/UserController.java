package com.skillstrom.controllers;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.skillstrom.data.User;
import com.skillstrom.services.UserService;

public class UserController {
	
	UserService userService = new UserService();
	
	public void getUser(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		System.out.println("Running controller....");
		String inputfname = req.getParameter("firstname");
		String inputlname = req.getParameter("lastname");
		User foundUser = userService.getUser(inputfname, inputlname);
		if (foundUser!= null) {
			req.getSession().setAttribute("userInfo", foundUser);
			resp.sendRedirect("/drstrange/login.html");
		}
		else {
			resp.sendRedirect("/drstrange");
		}
		
	}
	
	public void getUserTimeSheets(HttpServletRequest req, HttpServletResponse resp) {
		//TODO
	}
}
