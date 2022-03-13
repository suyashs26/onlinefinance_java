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
@Table(name="ADDRESS_DETAILS")
public class AddressDetails {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ADD_ID")
	private int addId;
	
	public int getAddId() {
		return addId;
	}

	public void setAddId(int addId) {
		this.addId = addId;
	}

	@Column(name="ADDRESS")
	private String address;
	
	@Column(name="STATE")
	private String state;

	@Column(name="CITY")
	private String city;
	
	@Column(name="PINCODE")
	private String pincode;
	
//	@Id
//	private int UserId;
//	
//	@OneToOne
//	@JoinColumn(name="USER_ID")
//	private UserInformation userInformation;
//	
	@OneToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="USER_ID")
	private UserInformation userInformation;

	public AddressDetails(int addId, String address, String state, String city, String pincode) {
		super();
		this.addId = addId;
		this.address = address;
		this.state = state;
		this.city = city;
		this.pincode = pincode;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public AddressDetails() {
		super();
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

	public UserInformation getUserInformation() {
		return userInformation;
	}

	public void setUserInformation(UserInformation userInformation) {
		this.userInformation = userInformation;
	}

	@Override
	public String toString() {
		return "AddressDetails [address=" + address + ", state=" + state + ", city=" + city + ", pincode=" + pincode
				+ ", userInformation=" + userInformation + "]";
	}

	

}