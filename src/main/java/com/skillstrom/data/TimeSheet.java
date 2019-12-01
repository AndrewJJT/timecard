package com.skillstrom.data;

import java.sql.Date;


public class TimeSheet {
	private int id;
	private double mondayHours;
	private double tuesdayHours;
	private double wednesdayHours;
	private double thursdayHours;
	private double fridayHours;
	private double saturdayHours;
	private double sundayHours;
	private Date weekEndingOn;
	private int userId;
	private int statusId;
	
	public TimeSheet() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TimeSheet(int id, double mondayHours, double tuesdayHours, double wednesdayHours, double thursdayHours,
			double fridayHours, double saturdayHours, double sundayHours, Date weekEndingOn, int userId, int statusId) {
		super();
		this.id = id;
		this.mondayHours = mondayHours;
		this.tuesdayHours = tuesdayHours;
		this.wednesdayHours = wednesdayHours;
		this.thursdayHours = thursdayHours;
		this.fridayHours = fridayHours;
		this.saturdayHours = saturdayHours;
		this.sundayHours = sundayHours;
		this.weekEndingOn = weekEndingOn;
		this.userId = userId;
		this.statusId = statusId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getMondayHours() {
		return mondayHours;
	}

	public void setMondayHours(double mondayHours) {
		this.mondayHours = mondayHours;
	}

	public double getTuesdayHours() {
		return tuesdayHours;
	}

	public void setTuesdayHours(double tuesdayHours) {
		this.tuesdayHours = tuesdayHours;
	}

	public double getWednesdayHours() {
		return wednesdayHours;
	}

	public void setWednesdayHours(double wednesdayHours) {
		this.wednesdayHours = wednesdayHours;
	}

	public double getThursdayHours() {
		return thursdayHours;
	}

	public void setThursdayHours(double thursdayHours) {
		this.thursdayHours = thursdayHours;
	}

	public double getFridayHours() {
		return fridayHours;
	}

	public void setFridayHours(double fridayHours) {
		this.fridayHours = fridayHours;
	}

	public double getSaturdayHours() {
		return saturdayHours;
	}

	public void setSaturdayHours(double saturdayHours) {
		this.saturdayHours = saturdayHours;
	}

	public double getSundayHours() {
		return sundayHours;
	}

	public void setSundayHours(double sundayHours) {
		this.sundayHours = sundayHours;
	}

	public Date getWeekEndingOn() {
		return weekEndingOn;
	}

	public void setWeekEndingOn(Date weekEndingOn) {
		this.weekEndingOn = weekEndingOn;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getStatusId() {
		return statusId;
	}

	public void setStatusId(int statusId) {
		this.statusId = statusId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(fridayHours);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + id;
		temp = Double.doubleToLongBits(mondayHours);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(saturdayHours);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + statusId;
		temp = Double.doubleToLongBits(sundayHours);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(thursdayHours);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(tuesdayHours);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + userId;
		temp = Double.doubleToLongBits(wednesdayHours);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((weekEndingOn == null) ? 0 : weekEndingOn.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TimeSheet other = (TimeSheet) obj;
		if (Double.doubleToLongBits(fridayHours) != Double.doubleToLongBits(other.fridayHours))
			return false;
		if (id != other.id)
			return false;
		if (Double.doubleToLongBits(mondayHours) != Double.doubleToLongBits(other.mondayHours))
			return false;
		if (Double.doubleToLongBits(saturdayHours) != Double.doubleToLongBits(other.saturdayHours))
			return false;
		if (statusId != other.statusId)
			return false;
		if (Double.doubleToLongBits(sundayHours) != Double.doubleToLongBits(other.sundayHours))
			return false;
		if (Double.doubleToLongBits(thursdayHours) != Double.doubleToLongBits(other.thursdayHours))
			return false;
		if (Double.doubleToLongBits(tuesdayHours) != Double.doubleToLongBits(other.tuesdayHours))
			return false;
		if (userId != other.userId)
			return false;
		if (Double.doubleToLongBits(wednesdayHours) != Double.doubleToLongBits(other.wednesdayHours))
			return false;
		if (weekEndingOn == null) {
			if (other.weekEndingOn != null)
				return false;
		} else if (!weekEndingOn.equals(other.weekEndingOn))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "TimeSheet [id=" + id + ", mondayHours=" + mondayHours + ", tuesdayHours=" + tuesdayHours
				+ ", wednesdayHours=" + wednesdayHours + ", thursdayHours=" + thursdayHours + ", fridayHours="
				+ fridayHours + ", saturdayHours=" + saturdayHours + ", sundayHours=" + sundayHours + ", weekEndingOn="
				+ weekEndingOn + ", userId=" + userId + ", statusId=" + statusId + "]";
	}

	


	
	
	
}
