package com.example.demo.layer2;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

//import com.example.demo.layer2.AddressDetail;

//import java.sql.Date;
import java.util.List;


/**
 * The persistent class for the USER_INFORMATION database table.
 * 
 */
@Entity
@Table(name="USER_INFORMATION")
public class UserInformation  {
	

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="USER_ID")
	private int userId;

	public UserInformation(int userId, String emailId, String name, String phoneNo, Date userJoiningDate,
			CardDetail cardDetail, Users users, AddressDetails addressDetails, BankDetails bankDetails) {
		super();
		this.userId = userId;
		this.emailId = emailId;
		this.name = name;
		this.phoneNo = phoneNo;
		this.userJoiningDate = userJoiningDate;
		this.cardDetail = cardDetail;
		this.users = users;
		this.addressDetails = addressDetails;
		this.bankDetails = bankDetails;
	}

	public UserInformation(int userId, String emailId, String name, String phoneNo, Date userJoiningDate) {
		super();
		this.userId = userId;
		this.emailId = emailId;
		this.name = name;
		this.phoneNo = phoneNo;
		this.userJoiningDate = userJoiningDate;
	}

	@Column(name="EMAIL_ID")
	private String emailId;
	
	@Column(name="NAME")
	private String name;

	@Column(name="PHONE_NO")
	private String phoneNo;

	//@Temporal(TemporalType.DATE)
	@Column(name="USER_JOINING_DATE")
	private Date userJoiningDate;

	//bi-directional many-to-one association to Transaction
//	@OneToMany(mappedBy="userInformation")
//	private List<Transaction> transactions;

	@JsonIgnore
	@OneToOne(mappedBy="userInformation",cascade=CascadeType.ALL,  fetch=FetchType.EAGER)
	@JoinColumn(name="USER_ID", referencedColumnName="USER_ID")
	private CardDetail cardDetail;
	
	@JsonIgnore
	@OneToOne(mappedBy="userInformation",cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	@JoinColumn(name="USER_ID", referencedColumnName="USER_ID")
	private Users users;
	
	@JsonIgnore
	@OneToOne(mappedBy="userInformation",cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinColumn(name="USER_ID", referencedColumnName="USER_ID")
	private AddressDetails addressDetails;
//	
	@JsonIgnore
	@OneToOne(mappedBy="userInformation",cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinColumn(name="USER_ID", referencedColumnName="USER_ID")
	private BankDetails bankDetails;
//	

	//bi-directional one-to-one association to User
	

	public AddressDetails getAddressDetails() {
		return addressDetails;
	}
//
	public void setAddressDetails(AddressDetails addressDetails) {
		this.addressDetails = addressDetails;
	}

	public BankDetails getBankDetails() {
		return bankDetails;
	}
//
	public void setBankDetails(BankDetails bankDetails) {
		this.bankDetails = bankDetails;
	}

	public UserInformation() {
	}

	public Users getUsers() {
		return users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}

	public int getUserId() {
		return this.userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getEmailId() {
		return this.emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhoneNo() {
		return this.phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public Date getUserJoiningDate() {
		return this.userJoiningDate;
	}

	public void setUserJoiningDate(Date userJoiningDate) {
		this.userJoiningDate = userJoiningDate;
	}

//	public List<Transaction> getTransactions() {
//		return this.transactions;
//	}
//
//	public void setTransactions(List<Transaction> transactions) {
//		this.transactions = transactions;
//	}

//	public Transaction addTransaction(Transaction transaction) {
//		getTransactions().add(transaction);
//		transaction.setUserInformation(this);
//
//		return transaction;
//	}
//
//	public Transaction removeTransaction(Transaction transaction) {
//		getTransactions().remove(transaction);
//		transaction.setUserInformation(null);
//
//		return transaction;
//	}


	public CardDetail getCardDetail() {
		return this.cardDetail;
	}

	public void setCardDetail(CardDetail cardDetail) {
		this.cardDetail = cardDetail;
	}



//	@Override
//	public String toString() {
//		return "UserInformation [userId=" + userId + ", emailId=" + emailId + ", name=" + name + ", phoneNo=" + phoneNo
//				+ ", userJoiningDate=" + userJoiningDate + ", transactions=" + transactions + ", addressDetail="
//				+ addressDetail + ", bankDetail=" + bankDetail + ", cardDetail=" + cardDetail + ", user=" + user + "]";
//	}

}