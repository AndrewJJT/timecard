package com.skillstrom.data;

public class User {
	private int Id;
	private String FirstName;
	private String LastName;
	private String UserName;
	private String Password;
	private int RoleId;
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(int id, String firstName, String lastName, String userName, String password, int roleId) {
		super();
		Id = id;
		FirstName = firstName;
		LastName = lastName;
		UserName = userName;
		Password = password;
		RoleId = roleId;
	}
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public String getFirstName() {
		return FirstName;
	}
	public void setFirstName(String firstName) {
		FirstName = firstName;
	}
	public String getLastName() {
		return LastName;
	}
	public void setLastName(String lastName) {
		LastName = lastName;
	}
	public String getUserName() {
		return UserName;
	}
	public void setUserName(String userName) {
		UserName = userName;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	public int getRoleId() {
		return RoleId;
	}
	public void setRoleId(int roleId) {
		RoleId = roleId;
	}
	@Override
	public String toString() {
		return "User [Id=" + Id + ", FirstName=" + FirstName + ", LastName=" + LastName + ", UserName=" + UserName
				+ ", Password=" + Password + ", RoleId=" + RoleId + "]";
	}
	
	
	
}
