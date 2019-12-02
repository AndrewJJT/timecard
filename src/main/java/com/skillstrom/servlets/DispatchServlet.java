package com.skillstrom.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.cj.Session;
import com.skillstrom.controllers.TimeSheetControllers;
import com.skillstrom.controllers.UserController;

public class DispatchServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			dispatch(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			dispatch(req, resp);
	}
	
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			dispatch(req, resp);
	}
	
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			dispatch(req, resp);
	}
	
	private UserController UserControll = new UserController();
	private TimeSheetControllers TimeSheetControll = new TimeSheetControllers();
	
	public void dispatch(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO
		System.out.println("Dispatching..."); 
		String uri = req.getRequestURI();
		System.out.println(uri);
		switch(uri) {
			case "/drstrange/main/update":
				if (req.getMethod().equals("POST")) {
					System.out.println("in main/update post");
					TimeSheetControll.updateTimeSheet(req, resp);
					return;
				}
			case "/drstrange/main/edit":
				if (req.getMethod().equals("GET")) {
					System.out.println("in main/edit get...");
					TimeSheetControll.getTimeSheetToMod(req, resp);
					return;
				}
				if (req.getMethod().equals("POST")) {
					System.out.println("in main/edit post...");
					TimeSheetControll.redirectToModTimeSheet(req, resp);
					return;
				}
			case "/drstrange/main/logout":
				if(req.getMethod().equals("GET")) {
					UserControll.logoutUser(req, resp);
					return;
				}
			case "/drstrange/main/login":
				// user
				if (req.getMethod().equals("POST")) {
					UserControll.getUser(req, resp);
					return;
				}
				if (req.getMethod().equals("PUT")) {
				// do something here
					return;
				}
				if (req.getMethod().equals("GET")) {
					UserControll.getUserInfo(req, resp);
					return;
				}
				if (req.getMethod().equals("DELETE")) {
				// do something here
					return;
				}
			
			case "/drstrange/main/timesheet":
				if (req.getMethod().equals("POST")) {
					TimeSheetControll.addTimeSheet(req, resp);
					return;
				}
				if (req.getMethod().equals("PUT")) {
					// TODO
					return;
				}
				if (req.getMethod().equals("GET")) {
					TimeSheetControll.getUserTimeSheets(req, resp);
					return;
				}
				if (req.getMethod().equals("DELETE")) {
					TimeSheetControll.deleteTimeSheet(req, resp);
					return;
				}
		default:
			break;
		}
				
	}
	
}
