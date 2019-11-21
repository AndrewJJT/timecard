package com.skillstrom.controllers;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.skillstrom.services.UserService;

public class UserController {
	
	UserService userService = new UserService();
	
	public void getUser(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		System.out.println("Running controller....");
		String inputfname = req.getParameter("firstname");
		String inputlname = req.getParameter("lastname");
		if (userService.getUser(inputfname, inputlname) != null) {
			resp.sendRedirect("/drstrange/main/login.html");
		}
		

	}
}
