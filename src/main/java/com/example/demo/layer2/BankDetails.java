package com.example.demo.layer2;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="BANK_DETAILS")
public class BankDetails {
	
	@Id
	@Column(name="ACC_ID")
	private int accId;
	
	
	@Column(name="BANK")
	private String bank;

	@Column(name="IFSC_CODE")
	private String ifscCode;
	
	
	@OneToOne(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinColumn(name="USER_ID")
	private UserInformation userInformation;


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


	public UserInformation getUserInformation() {
		return userInformation;
	}


	public void setUserInformation(UserInformation userInformation) {
		this.userInformation = userInformation;
	}


	@Override
	public String toString() {
		return "BankDetails [accId=" + accId + ", bank=" + bank + ", ifscCode=" + ifscCode + ", userInformation="
				+ userInformation + "]";
	}


	public BankDetails(int accId, String bank, String ifscCode) {
		super();
		this.accId = accId;
		this.bank = bank;
		this.ifscCode = ifscCode;
	}


	public BankDetails() {
		super();
	}
	
	
}