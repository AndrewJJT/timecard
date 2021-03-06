package com.skillstrom.services;

import java.util.List;

import com.skillstrom.data.TimeSheet;
import com.skillstrom.data.TimeSheetDAO;
import com.skillstrom.data.User;

public class Service {
	
	TimeSheetDAO timeSheetDao = new TimeSheetDAO();
	
	public User getUser(String inputUserName, String inputUserPassword)  {
		return timeSheetDao.findUserByUserNameAndPassword(inputUserName, inputUserPassword);
	}
	
	public List<TimeSheet> getUserTimeSheet(int Id){
		return timeSheetDao.findByTimeSheetByUserId(Id);
	}
	
	public TimeSheet getTimeSheetToMod(int id) {
		return timeSheetDao.getOneTimeSheet(id);
	}
	
	public TimeSheet addTimeSheet(TimeSheet newTimeSheet) {
		System.out.println("in service");
		return timeSheetDao.saveOrSubmit(newTimeSheet);
	}
	
	public void updateTimeSheet(TimeSheet timesheet) {
		System.out.println("in service...update");
		timeSheetDao.updateTimeSheet(timesheet);
	}
	
	public void deleteTimeSheet(int timeSheetId) {
		timeSheetDao.deleteTimeSheet(timeSheetId);
	}
	
}
