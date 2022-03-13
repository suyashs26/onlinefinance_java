package com.example.demo.layer2;

import javax.persistence.Entity;
import javax.persistence.Id;


public class LoginUserDetails {
	
	private int userId;
	
	private UserInformation userInformation;
	//private String lastName;
	@Id
	private int userName;
	private String password;
	public LoginUserDetails(int userId, UserInformation userInformation, int userName, String password) {
		super();
		this.userId = userId;
		//this.userInformation = userInformation;
		this.userName = userName;
		this.password = password;
	}

	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	//private String role;
	public LoginUserDetails(int userId, UserInformation userInformation, int userName) {
		super();
		this.userId = userId;
		this.userInformation = userInformation;
		this.userName = userName;
	}
	public int getUser_id() {
		return userId;
	}
	public void setUser_id(int userId) {
		this.userId = userId;
	}
	public UserInformation getUserInformation() {
		return userInformation;
	}
	public void setUserInformation(UserInformation userInformation) {
		this.userInformation = userInformation;
	}
	public int getUserName() {
		return userName;
	}
	public void setUserName(int userName) {
		this.userName = userName;
	}

	

}
