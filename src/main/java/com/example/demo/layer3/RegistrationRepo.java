package com.example.demo.layer3;

import javax.persistence.Id;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.layer2.AddressDetails;
import com.example.demo.layer2.BankDetails;
import com.example.demo.layer2.Registration;
import com.example.demo.layer2.UserInformation;
import com.example.demo.layer2.Users;



public interface RegistrationRepo{
	
//	void insertUserInfo(UserInformation userInfo);
//	void insertUserCred(Users users);
//	void insertAddressDetails(AddressDetails addressDetails);
//	void insertBankDetails(BankDetails bankDetails);
	
	//void insertRegistration(UserInformation userInfo, Users users,AddressDetails addressDetails,BankDetails bankDetails);
	
	
	public String addUser(Registration registrationDTO);
	

}
