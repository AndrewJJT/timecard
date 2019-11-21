package com.skillstrom.services;

import java.sql.SQLException;

import com.skillstrom.data.TimeSheetDAO;
import com.skillstrom.data.User;

public class UserService {
	
	TimeSheetDAO timeSheetDao = new TimeSheetDAO();
	
	public User getUser(String inputUserName, String inputUserPassword)  {
		return timeSheetDao.findUserByUserNameAndPassword(inputUserName, inputUserPassword);
	}
}
