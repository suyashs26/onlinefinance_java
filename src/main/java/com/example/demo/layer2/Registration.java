package com.example.demo.layer2;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;


public class Registration {
	

	
	private String emailId;
	private String name;
	private String phoneNo;
	private Date userJoiningDate;
	private int accId;
	private String bank;
	private String ifscCode;
	//private int cardNumber;

	//private Date cardIssueDate;
	//private int cardLimit;
	private String cardType;
	//private double joiningFee;
	
	//private String status;
	//private Date validity;

	private String address;
	
	private String state;
	private String city;
	
	private String pincode;
	private int userName;
	
	

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public Date getUserJoiningDate() {
		return userJoiningDate;
	}

	public void setUserJoiningDate(Date userJoiningDate) {
		this.userJoiningDate = userJoiningDate;
	}

	public int getAccId() {
		return accId;
	}

	public void setAccId(int accId) {
		this.accId = accId;
	}

	public String getBank() {
		return bank;
	}

	public void setBank(String bank) {
		this.bank = bank;
	}

	public String getIfscCode() {
		return ifscCode;
	}

	public void setIfscCode(String ifscCode) {
		this.ifscCode = ifscCode;
	}

//	public int getCardNumber() {
//		return cardNumber;
//	}
//
//	public void setCardNumber(int cardNumber) {
//		this.cardNumber = cardNumber;
//	}
//
//	public Date getCardIssueDate() {
//		return cardIssueDate;
//	}
//
//	public void setCardIssueDate(Date cardIssueDate) {
//		this.cardIssueDate = cardIssueDate;
//	}
//
//	public int getCardLimit() {
//		return cardLimit;
//	}
//
//	public void setCardLimit(int cardLimit) {
//		this.cardLimit = cardLimit;
//	}

	public String getCardType() {
		return cardType;
	}

	public void setCardType(String cardType) {
		this.cardType = cardType;
	}

//	public double getJoiningFee() {
//		return joiningFee;
//	}
//
//	public void setJoiningFee(double joiningFee) {
//		this.joiningFee = joiningFee;
//	}
//
//	public String getStatus() {
//		return status;
//	}
//
//	public void setStatus(String status) {
//		this.status = status;
//	}
//
//	public Date getValidity() {
//		return validity;
//	}
//
//	public void setValidity(Date validity) {
//		this.validity = validity;
//	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

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
//
//	public String getUserType() {
//		return userType;
//	}
//
//	public void setUserType(String userType) {
//		this.userType = userType;
//	}
//
//	public String getUserStatus() {
//		return userStatus;
//	}
//
//	public void setUserStatus(String userStatus) {
//		this.userStatus = userStatus;
//	}

	private String password;

	//private String userType;

	//private String userStatus;
	

}
