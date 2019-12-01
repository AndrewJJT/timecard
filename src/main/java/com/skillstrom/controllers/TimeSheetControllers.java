package com.skillstrom.controllers;

import java.io.Console;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.skillstrom.data.TimeSheet;
import com.skillstrom.data.User;
import com.skillstrom.services.Service;

public class TimeSheetControllers {
	private Service service = new Service();
	
	public void getUserTimeSheets(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		resp.setContentType("application/json");
		User signedInUser = (User)req.getSession().getAttribute("userInfo");
		System.out.println("in getUserTimeSheet method " + signedInUser);
		List<TimeSheet> timeSheets = service.getUserTimeSheet(signedInUser.getId());
		System.out.println(timeSheets);
		resp.addCookie(new Cookie("id2", String.valueOf(signedInUser.getId())));
		resp.getWriter().println(new ObjectMapper().writeValueAsString(timeSheets));
	}
	
	public void addTimeSheet(HttpServletRequest req, HttpServletResponse resp) throws  IOException {
		System.out.println("in timesheetcontroller.addtimesheet");
		resp.setContentType("application/json");
	
		User signedInUser = (User)req.getSession().getAttribute("userInfo");
		int userId = signedInUser.getId();
		// map object and THEN reset id to
		ObjectMapper mapper = new ObjectMapper();
		TimeSheet newTimeSheet = mapper.readValue(req.getInputStream(), TimeSheet.class);
		newTimeSheet.setUserId(userId);
		
		resp.getWriter().println(new ObjectMapper().writeValueAsString(
				service.addTimeSheet(newTimeSheet)));
	}
	
	public void deleteTimeSheet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		resp.setContentType("application/json");
		System.out.println("in timesheetcontroller.deletetimesheet");
		
		service.deleteTimeSheet(Integer.parseInt(req.getParameter("timesheetid")));
		
//		resp.sendRedirect("/drstrange/login.html");
		}
}
