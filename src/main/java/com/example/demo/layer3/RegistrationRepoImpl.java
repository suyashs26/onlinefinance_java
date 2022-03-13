package com.example.demo.layer3;

import java.sql.Date;
import java.util.Calendar;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.Id;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.layer2.AddressDetails;
import com.example.demo.layer2.BankDetails;
import com.example.demo.layer2.CardDetail;
import com.example.demo.layer2.Registration;
import com.example.demo.layer2.UserInformation;
import com.example.demo.layer2.Users;

@Repository
public class RegistrationRepoImpl extends BaseRepository implements RegistrationRepo {

	
	@Autowired
	BaseRepositoryImpl base;
	
	@Transactional
	public String addUser(Registration registrationDTO) {
		// TODO Auto-generated method stub
		
		
		java.sql.Date date = new java.sql.Date(Calendar.getInstance().getTime().getTime());
		
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.add(Calendar.YEAR, 2);
		//java.sql.Date newDate = c.getTime();
		//java.sql.Date newDate =  new java.sql.Date(c.getTime());
		java.sql.Date newDate= new java.sql.Date(c.getTimeInMillis());
		
		UserInformation userInformation = new UserInformation();
		userInformation.setName(registrationDTO.getName());
		userInformation.setEmailId(registrationDTO.getEmailId());
		userInformation.setPhoneNo(registrationDTO.getPhoneNo());
		userInformation.setUserJoiningDate(registrationDTO.getUserJoiningDate());
		
		BankDetails bankDetails = new BankDetails();
		bankDetails.setAccId(registrationDTO.getAccId());
		bankDetails.setBank(registrationDTO.getBank());
		bankDetails.setIfscCode(registrationDTO.getIfscCode());
		bankDetails.setUserInformation(userInformation);
		
		CardDetail cardDetail = new CardDetail();
		cardDetail.setCardIssueDate(date);
		cardDetail.setCardType(registrationDTO.getCardType());
		if((cardDetail.getCardType()).equals("Platinum")) {
			cardDetail.setCardLimit(200000);
			cardDetail.setJoiningFee(1500);
		}	
		else {
			cardDetail.setCardLimit(150000);
			cardDetail.setJoiningFee(2000);
		}
		cardDetail.setValidity(newDate);
		//cardDetail.setJoiningFee(2000);
		cardDetail.setStatus("Active");
		cardDetail.setUserInformation(userInformation);
		
		AddressDetails addressDetails = new AddressDetails();
		addressDetails.setAddress(registrationDTO.getAddress());
		addressDetails.setCity(registrationDTO.getCity());
		addressDetails.setState(registrationDTO.getState());
		addressDetails.setPincode(registrationDTO.getPincode());
		addressDetails.setUserInformation(userInformation);
		
		Users users = new Users();
		users.setUserName(registrationDTO.getUserName());
		users.setPassword(registrationDTO.getPassword());
		users.setUserStatus("Active");
		users.setUserType("Non Admin");
		users.setUserInformation(userInformation);
		
		userInformation.setAddressDetails(addressDetails);
		userInformation.setBankDetails(bankDetails);
		userInformation.setCardDetail(cardDetail);
		userInformation.setUsers(users);
		
		base.saveRecord(userInformation);
		
		return "user added successfully";
		
		
	}
//
//	@Transactional
//	public void insertRegistration(UserInformation userInfo, Users users, AddressDetails addressDetails,
//			BankDetails bankDetails) {
//		// TODO Auto-generated method stub
//		
//		EntityManager entityManager = getEntityManager();
//		entityManager.persist(userInfo); //based on PK
//		System.out.println("employee inserted..."+userInfo);
//		entityManager.persist(addressDetails); //based on PK
//		System.out.println("employee inserted..."+addressDetails);
//		entityManager.persist(users); //based on PK
//		System.out.println("employee inserted..."+users);
//		entityManager.persist(bankDetails); //based on PK
//		System.out.println("employee inserted..."+bankDetails);
//		
//	}
//
//	@Transactional
//	public void insertUserDetails(Registration registration) {
//		// TODO Auto-generated method stub
//		
//		EntityManager entityManager = getEntityManager();
//		entityManager.persist(registration);
//		
//	}
//
//	@Override
//	public void insertUserDetails() {
//		// TODO Auto-generated method stub
//		
//	}

	
	
	
		
		
		
		
		
	}
	

	
	
	


