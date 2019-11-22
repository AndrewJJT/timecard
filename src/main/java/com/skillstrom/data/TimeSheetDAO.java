package com.skillstrom.data;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.LinkedList;
import java.util.List;


public class TimeSheetDAO {
//	public User findbyUsername (String username) {}
//	public List<TimeSheet> findTimesheetsByUser (int id){}
//	public Timesheet findTImesheetById (int id) {}
//	
//	public TImesheet save(Timesheet t) {}
	public Connection getConnection()  {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/timecard", "root", "root");
			return conn;
		} catch (SQLException | ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
	}

	//CRUD
	
	public User findUserByUserNameAndPassword(String inputUserName, String inputPassword)  {
		
		User foundUser = new User();
		System.out.println("in CRUD method...");
		// TODO write logic for get user back AND think of if user should bring back list of timesheet
		Connection conn = getConnection();
		
		PreparedStatement stmt;
		try {
			stmt = conn.prepareStatement("Select * from user where UserName = ? AND UserPassword = ?");
			stmt.setString(1, inputUserName);
			stmt.setString(2, inputPassword);
			ResultSet searchResult = stmt.executeQuery();

			while(searchResult.next()) {
				foundUser = new User(searchResult.getInt("UserId"), searchResult.getString("Fname"), searchResult.getString("Lname"),
						searchResult.getString("UserName"), searchResult.getString("UserPassword"), searchResult.getInt("RoleId"));
				}
	
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
		}
		System.out.println("in CRUD finduserbytheirlogininfo " + foundUser);	
		return foundUser;
	}

	public List<TimeSheet> findByTimeSheetByUserId (int id)  {
		Connection conn = getConnection();
		List<TimeSheet> userTimeSheets = new LinkedList<TimeSheet>();
		// what columns are returned in ResultSet when I call stmt.getGeneratedKeys
		PreparedStatement stmt;
		try {
		stmt = conn.prepareStatement("Select * from timesheet where userId = ?");
		stmt.setInt(1, id);
		ResultSet results = stmt.executeQuery();
//		results.next(); // to get to the first row, cursor is at row 0 before this line 
		
		
		while(results.next()) {
			TimeSheet newTimeSheet = new TimeSheet(results.getInt("TimeSheetId"), results.getDouble("MondayHours"), results.getDouble("TuesdayHours"), 
					results.getDouble("WednesdayHours"), results.getDouble("ThursdayHours"), results.getDouble("FridayHours"), 
					results.getDouble("SaturdayHours"), results.getDouble("SundayHours"), results.getDate("WeekEndingAt"), results.getInt("UserId"), results.getInt("StatusId"));
			userTimeSheets.add(newTimeSheet);
		}
		
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}finally {
			try {
				conn.close();
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
		}
		return userTimeSheets;
	}

	public TimeSheet saveOrSubmit (TimeSheet newTimeSheet) {
		
		Connection conn = getConnection();
		// what columns are returned in ResultSet when I call stmt.getGeneratedKeys
		PreparedStatement stmt;
		try {
			stmt = conn.prepareStatement("Insert into timesheet(MondayHours,TuesdayHours,WednesdayHours,ThursdayHours,FridayHours,SaturdayHours,SundayHours,WeekEndingAt,StatusId,UserId) Values(?,?,?,?,?,?,?,?,?,?)", new String[] {"timesheetId"});
			stmt.setDouble(1, newTimeSheet.getMondayHours());
			stmt.setDouble(2, newTimeSheet.getTuesdayHours());
			stmt.setDouble(3, newTimeSheet.getWednesdayHours());
			stmt.setDouble(4, newTimeSheet.getThursdayHours());
			stmt.setDouble(5, newTimeSheet.getFridayHours());
			stmt.setDouble(6, newTimeSheet.getSaturdayHours());
			stmt.setDouble(7, newTimeSheet.getSundayHours());
			stmt.setDate(8, (Date) newTimeSheet.getWeekEndingOn());
			stmt.setInt(9, newTimeSheet.getStatusId());
			stmt.setInt(10, newTimeSheet.getUserId());
			stmt.executeUpdate();
			
			// get primary key that was generated by DB
			//reflect in memory what is in the DB
			//always only 1 rows
			ResultSet keys = stmt.getGeneratedKeys();
			while(keys.next()) {
				int newTimeSheetId = keys.getInt(1); // first column of that row 
				newTimeSheet.setId(newTimeSheetId);
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
			
		}finally {
			try {
				conn.close();
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
		}
		
		return newTimeSheet;
	}
	
	/**
	public List<Artist> findAll() throws SQLException{
		Connection conn = getConnection();
	
		ResultSet results = conn.prepareStatement("Select * from artist").executeQuery();
		List<Artist> artResults = new LinkedList<>();
		while(results.next()) {
			Artist newartist = new Artist (results.getInt("artistId"), results.getString("name"));
			artResults.add(newartist);
		}
		
		conn.close();
		return artResults;
		
	}
	
	public Set<Artist> searchByName (String search) throws SQLException{
		Connection conn = getConnection();
		
		PreparedStatement stmt = conn.prepareStatement("Select * from artist where name LIKE ?");
		
		stmt.setString(1, search+"%"); //"googling it"... can't chain after setString 
		
		ResultSet rs = stmt.executeQuery();
		
		Set<Artist> artResults = new HashSet<>();
		
		while(rs.next()) {
			Artist newartist = new Artist (rs.getInt("artistId"), rs.getString("name"));
			artResults.add(newartist);
		}
		
		conn.close();
		return artResults;
	}
	
	
	
	public List<Artist> updated(){
		// update Artist set name =?, descript =?, column = ?, where artistId =?
		throw new UnsupportedOperationException("Not yet implemented");
	}
	
	public void delete(int id) throws SQLException{
		String sql = "Delete from artist where artistid = ?";
		Connection conn = getConnection();
		
		conn.setAutoCommit(false);	
		
		PreparedStatement stmt = conn.prepareStatement(sql);
		
		stmt.setInt(1, id);
		
		int rowsaffected = stmt.executeUpdate();
		
		conn.commit(); //where change take place permanently 
		
		conn.close();
		
	}
	
	**/
}
