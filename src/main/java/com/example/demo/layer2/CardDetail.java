package com.example.demo.layer2;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the CARD_DETAILS database table.
 * 
 */
@Entity
@Table(name="CARD_DETAILS")
public class CardDetail implements Serializable {
	

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="CARD_NUMBER")
	private int cardNumber;

	//@Temporal(TemporalType.DATE)
	@Column(name="CARD_ISSUE_DATE")
	private Date cardIssueDate;

	@Column(name="CARD_LIMIT")
	private int cardLimit;

	@Column(name="CARD_TYPE")
	private String cardType;

	@Column(name="JOINING_FEE")
	private double joiningFee;
	
	@Column(name="STATUS")
	private String status;

	//@Temporal(TemporalType.DATE)
	@Column(name="VALIDITY")
	private Date validity;

	//bi-directional one-to-one association to UserInformation
	//@OneToOne(mappedBy="cardDetail")
	@OneToOne(fetch=FetchType.EAGER)
    @JoinColumn(name = "USER_ID")
	private UserInformation userInformation;

	public CardDetail() {
		super();
	}

	public CardDetail(int cardNumber, Date cardIssueDate, int cardLimit, String cardType, double joiningFee,
			String status, Date validity) {
		super();
		this.cardNumber = cardNumber;
		this.cardIssueDate = cardIssueDate;
		this.cardLimit = cardLimit;
		this.cardType = cardType;
		this.joiningFee = joiningFee;
		this.status = status;
		this.validity = validity;
	}

	public int getCardNumber() {
		return this.cardNumber;
	}

	public void setCardNumber(int cardNumber) {
		this.cardNumber = cardNumber;
	}

	@Override
	public String toString() {
		return "CardDetail [cardNumber=" + cardNumber + ", cardIssueDate=" + cardIssueDate + ", cardLimit=" + cardLimit
				+ ", cardType=" + cardType + ", joiningFee=" + joiningFee + ", status=" + status + ", validity="
				+ validity + ", userInformation=" + userInformation + "]";
	}

	public Date getCardIssueDate() {
		return this.cardIssueDate;
	}

	public void setCardIssueDate(Date cardIssueDate) {
		this.cardIssueDate = cardIssueDate;
	}

	public int getCardLimit() {
		return this.cardLimit;
	}

	public void setCardLimit(int cardLimit) {
		this.cardLimit = cardLimit;
	}

	public String getCardType() {
		return this.cardType;
	}

	public void setCardType(String cardType) {
		this.cardType = cardType;
	}

	public double getJoiningFee() {
		return this.joiningFee;
	}

	public void setJoiningFee(double joiningFee) {
		this.joiningFee = joiningFee;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getValidity() {
		return this.validity;
	}

	public void setValidity(Date validity) {
		this.validity = validity;
	}

	public UserInformation getUserInformation() {
		return this.userInformation;
	}

	public void setUserInformation(UserInformation userInformation) {
		this.userInformation = userInformation;
	}

}