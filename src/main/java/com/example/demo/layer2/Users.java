package com.example.demo.layer2;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="USERS")
public class Users  {
	

	@Id
	//@GeneratedValue(strategy=GenerationType.AUTO)	
	@Column(name="USERNAME")
	private int userName;
	
	@Column(name="PASSWORD")
	private String password;

	@Column(name="USER_TYPE")
	private String userType;
	
	@Column(name="USER_STATUS")
	private String userStatus;
	
	
	
	
	public Users(int userName, String password, String userType, String userStatus) {
		super();
		this.userName = userName;
		this.password = password;
		this.userType = userType;
		this.userStatus = userStatus;
	}

	public Users() {
		super();
	}

	@OneToOne(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinColumn(name="USER_ID", referencedColumnName="USER_ID")
	private UserInformation userInformation;

	public int getUserName() {
		return userName;
	}

	public void setUserName(int userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public String getUserStatus() {
		return userStatus;
	}

	public void setUserStatus(String userStatus) {
		this.userStatus = userStatus;
	}

	public UserInformation getUserInformation() {
		return userInformation;
	}

	public void setUserInformation(UserInformation userInformation) {
		this.userInformation = userInformation;
	}

	@Override
	public String toString() {
		return "Users [userName=" + userName + ", password=" + password + ", userType=" + userType + ", userStatus="
				+ userStatus + ", userInformation=" + userInformation + "]";
	}
	
	
}