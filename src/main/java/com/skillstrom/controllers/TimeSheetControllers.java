package com.skillstrom.controllers;

import java.io.Console;
import java.io.IOException;
import java.sql.Date;
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
	
	public void redirectToModTimeSheet(HttpServletRequest req, HttpServletResponse resp) throws IOException{
		req.getSession().setAttribute("timesheetid",req.getParameter("timesheetid"));
		resp.sendRedirect("/drstrange/edit.html");
	}
	
	public void getTimeSheetToMod(HttpServletRequest req, HttpServletResponse resp) throws IOException{
		int id = Integer.parseInt((String)req.getSession().getAttribute("timesheetid"));
		resp.getWriter().println(new ObjectMapper().writeValueAsString(service.getTimeSheetToMod(id)));
		
	}
	
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
	
	public void updateTimeSheet(HttpServletRequest req, HttpServletResponse resp) throws IOException{
		System.out.println("in timesheetcontroller update");
		double monhrs = Double.parseDouble(req.getParameter("mondayHours"));
		double tueshrs = Double.parseDouble(req.getParameter("tuesdayHours"));
		double wedhrs = Double.parseDouble(req.getParameter("wednesdayHours"));
		double thurshrs = Double.parseDouble(req.getParameter("thursdayHours"));
		double frihrs = Double.parseDouble(req.getParameter("fridayHours"));
		double sathrs = Double.parseDouble(req.getParameter("saturdayHours"));
		double sunhrs = Double.parseDouble(req.getParameter("sundayHours"));
		int statid = Integer.parseInt(req.getParameter("statusId"));
		int userid = Integer.parseInt(req.getParameter("userId"));
		int tsid = Integer.parseInt(req.getParameter("timesheetid"));
		Date weekendingon = Date.valueOf(req.getParameter("weekendingon"));

		TimeSheet tmsht = new TimeSheet ();
		tmsht.setId(tsid);
		tmsht.setUserId(userid);
		tmsht.setStatusId(statid);
		tmsht.setMondayHours(monhrs);
		tmsht.setTuesdayHours(tueshrs);
		tmsht.setWednesdayHours(wedhrs);
		tmsht.setThursdayHours(thurshrs);
		tmsht.setFridayHours(frihrs);
		tmsht.setSaturdayHours(sathrs);
		tmsht.setSundayHours(sunhrs);
		tmsht.setWeekEndingOn(weekendingon);
		
		service.updateTimeSheet(tmsht);
		
		System.out.println("completed updated...redirecting");
		resp.sendRedirect("/drstrange/login.html");
		
	}
	
	public void deleteTimeSheet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		resp.setContentType("application/json");
		System.out.println("in timesheetcontroller.deletetimesheet");
		
		service.deleteTimeSheet(Integer.parseInt(req.getParameter("timesheetid")));
		
//		resp.sendRedirect("/drstrange/login.html");
		}
}
