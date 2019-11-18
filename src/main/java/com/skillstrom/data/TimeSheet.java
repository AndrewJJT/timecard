package com.skillstrom.data;

public class TimeSheet {
	private int Id;
	private double MondayHours;
	private double TuesdayHours;
	private double WednesdayHours;
	private double ThursdayHours;
	private double FridayHours;
	private double SaturdayHours;
	private double SundayHours;
	private int UserId;
	private int StatusId;
	
	public TimeSheet() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TimeSheet(int id, double mondayHours, double tuesdayHours, double wednesdayHours, double thursdayHours,
			double fridayHours, double saturdayHours, double sundayHours, int userId, int statusId) {
		super();
		Id = id;
		MondayHours = mondayHours;
		TuesdayHours = tuesdayHours;
		WednesdayHours = wednesdayHours;
		ThursdayHours = thursdayHours;
		FridayHours = fridayHours;
		SaturdayHours = saturdayHours;
		SundayHours = sundayHours;
		UserId = userId;
		StatusId = statusId;
	}

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public double getMondayHours() {
		return MondayHours;
	}

	public void setMondayHours(double mondayHours) {
		MondayHours = mondayHours;
	}

	public double getTuesdayHours() {
		return TuesdayHours;
	}

	public void setTuesdayHours(double tuesdayHours) {
		TuesdayHours = tuesdayHours;
	}

	public double getWednesdayHours() {
		return WednesdayHours;
	}

	public void setWednesdayHours(double wednesdayHours) {
		WednesdayHours = wednesdayHours;
	}

	public double getThursdayHours() {
		return ThursdayHours;
	}

	public void setThursdayHours(double thursdayHours) {
		ThursdayHours = thursdayHours;
	}

	public double getFridayHours() {
		return FridayHours;
	}

	public void setFridayHours(double fridayHours) {
		FridayHours = fridayHours;
	}

	public double getSaturdayHours() {
		return SaturdayHours;
	}

	public void setSaturdayHours(double saturdayHours) {
		SaturdayHours = saturdayHours;
	}

	public double getSundayHours() {
		return SundayHours;
	}

	public void setSundayHours(double sundayHours) {
		SundayHours = sundayHours;
	}

	public int getUserId() {
		return UserId;
	}

	public void setUserId(int userId) {
		UserId = userId;
	}

	public int getStatusId() {
		return StatusId;
	}

	public void setStatusId(int statusId) {
		StatusId = statusId;
	}
	
	
}
