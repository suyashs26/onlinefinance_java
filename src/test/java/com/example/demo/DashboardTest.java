package com.example.demo;

import java.sql.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.layer2.AddressDetails;
import com.example.demo.layer2.BankDetails;
import com.example.demo.layer2.CardDetail;
import com.example.demo.layer2.MonthlyTransaction;
import com.example.demo.layer2.Transaction;
import com.example.demo.layer2.TxnNotFoundException;
import com.example.demo.layer2.UserInformation;
import com.example.demo.layer2.UserNotFoundException;
import com.example.demo.layer2.Users;
import com.example.demo.layer3.BaseRepositoryImpl;
import com.example.demo.layer3.DashboardRepositoryImpl;
import com.example.demo.layer3.LoginRepoImpl;

@SpringBootTest
public class DashboardTest {
	
	@Autowired
	DashboardRepositoryImpl dao = new DashboardRepositoryImpl();
	
	@Autowired
	LoginRepoImpl login = new LoginRepoImpl();
	
	@Autowired
	BaseRepositoryImpl base;
	
	@Test
	public void findTxnByUserIdTest() {
		//System.out.println("Transaction Repo : "+ dao);
		
		try {
			List<Transaction> txn = dao.selectTransactionByUserId(9820);
			for (Transaction t : txn) {
				System.out.println("Txn id : "+ t.getTxnId());
				System.out.println("Amount Paid : "+ t.getPaid());
				System.out.println("Name : "+ t.getUserInformation().getName());
				System.out.println("---------------------------");
				
			}
			
		}
		catch(UserNotFoundException e) {
			System.out.println("user not found "+e.getMessage());
		}
	}
	
	@Test
	public void findMTxnByTxnIdTest() {
		try {
			List<MonthlyTransaction> mtxn= dao.selectMonthlyTransactionByTxnId(20204);
			for(MonthlyTransaction m : mtxn) {
				System.out.println("MTxn id : "+ m.getMtxnId());
				System.out.println("Amount Paid : "+ m.getMonthlyInstallment());
				//System.out.println("MTxn Date :" m.getMtxnDate());
				System.out.println("---------------------------");
				
			}
			
				
			
		} catch (TxnNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void findCardDetailsByUserTest() {
		try {
			CardDetail card = dao.selectCardDetailByUserId(9820);
			System.out.println("Card Number : "+card.getCardNumber());
			System.out.println("Card Type  : "+card.getCardType());
			System.out.println("Card Limit : " + card.getCardLimit());
			System.out.println("Card validity :  "+ card.getValidity());
			
		} catch (UserNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void findUserByEmail() {
		UserInformation user = dao.selectUserByEmail("steve@starkindustries.com");
		System.out.println("User name : "+ user.getName());
	}
	
	@Test
	public void selectUserByIdAndPass() {
		Users user;
		try {
			user = login.selectUserByUserNameAndPass(4575,"JANE@4575");
			System.out.println("NAME : "+ user.getUserInformation().getName());
		} catch (UserNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@Test
	public void addUser() {
		//UserInformation userInformation = new UserInformation(9877, "abc@gmail.com", "kevin", "99247533444", Date.valueOf("2020-09-09"));
		
		UserInformation userInformation = new UserInformation();
		userInformation.setName("Jay");
		userInformation.setEmailId("abcdddsd@gmail.com");
		userInformation.setPhoneNo("984958437");
		userInformation.setUserJoiningDate(Date.valueOf("2020-09-09"));
		
		
//		BankDetails bankDetails = new BankDetails(556959443, "HDFC", "KKBK0003333");
//		
//		//CardDetail cardDetail = new CardDetail(5848555, "2021-04-05", 200000, "Platinum", 2000, "Active", "2021-07-09");
//		CardDetail cardDetail = new CardDetail(5848555, "2021-04-05", 200000, "Platinum", 2000, "Active", "2021-07-09");
//		AddressDetails addressDetails = new AddressDetails(20094, "wall street", "Maharashtra", "Pune", "433933");
//		Users users = new Users(4890, "NICK@4890", "NON ADMIN", "Active");
		
		BankDetails bankDetails = new BankDetails();
		bankDetails.setAccId(55432);
		bankDetails.setBank("HDFC");
		bankDetails.setIfscCode("KKBK003");
		bankDetails.setUserInformation(userInformation);
		
		CardDetail cardDetail = new CardDetail();
		//cardDetail.setCardNumber(453546);
		cardDetail.setCardIssueDate(Date.valueOf("2020-09-03"));
		cardDetail.setCardLimit(2000);
		cardDetail.setCardType("Platinum");
		cardDetail.setJoiningFee(2000);
		cardDetail.setStatus("Active");
		cardDetail.setValidity(Date.valueOf("2022-08-04"));
		cardDetail.setUserInformation(userInformation);
		
		AddressDetails addressDetails = new AddressDetails();
		//addressDetails.setAddId(29494);
		addressDetails.setAddress("wall");
		addressDetails.setCity("Pune");
		addressDetails.setState("Karnataka");
		addressDetails.setPincode("48586");
		addressDetails.setUserInformation(userInformation);
		
		Users users = new Users();
		users.setUserName(48999);
		users.setPassword("NICK@4890");
		users.setUserStatus("Active");
		users.setUserType("NON ADMIN");
		users.setUserInformation(userInformation);
		
		userInformation.setAddressDetails(addressDetails);
		userInformation.setBankDetails(bankDetails);
		userInformation.setCardDetail(cardDetail);
		userInformation.setUsers(users);
		
		base.saveRecord(userInformation);
		
		
		
	}
	
}
	


