package com.skillstrom.controllers;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.skillstrom.data.TimeSheet;
import com.skillstrom.services.Service;

public class TimeSheetControllers {
	Service service = new Service();
	
	public void addTimeSheet(HttpServletRequest req, HttpServletResponse resp) throws  IOException {
		resp.setContentType("application/json");
		resp.getWriter().println(new ObjectMapper().writeValueAsString(
				service.addTimeSheet(new ObjectMapper().readValue(req.getInputStream(), TimeSheet.class))));
	}
}
