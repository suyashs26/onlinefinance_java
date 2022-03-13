package com.example.demo.layer5;

import java.util.List;

import javax.persistence.NoResultException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.layer2.CardDetail;
import com.example.demo.layer2.Login;
import com.example.demo.layer2.MonthlyTransaction;
import com.example.demo.layer2.ProductDetail;
import com.example.demo.layer2.Registration;
import com.example.demo.layer2.Transaction;
import com.example.demo.layer2.TxnNotFoundException;
import com.example.demo.layer2.UserInformation;
import com.example.demo.layer2.UserNotFoundException;
import com.example.demo.layer2.Users;
import com.example.demo.layer3.DashboardRepositoryImpl;
import com.example.demo.layer3.LoginRepoImpl;
import com.example.demo.layer3.LoginRepository;
import com.example.demo.layer3.RegistrationRepoImpl;
import com.example.demo.layer4.DashboardService;
import com.example.demo.layer4.DashboardServiceImpl;
import com.example.demo.layer4.LoginService;

@CrossOrigin
@RestController // it is a specialized version of @Component - marker to receive web request
@RequestMapping("/txn")
public class DashboardController {
	
	@Autowired
	DashboardRepositoryImpl dao;
	
	@Autowired 
	DashboardServiceImpl dashboardService;
	
	@Autowired
	RegistrationRepoImpl registrationRepoImpl;
	
	@Autowired
	LoginService login;

	@GetMapping
	@ResponseBody
	@RequestMapping(value="/{userId}")
	public List<Transaction> getTransaction(@PathVariable int userId) {
			
		System.out.println("getTransaction() ");
		//dao.selectTransactionByUserId(userId);
		  return dashboardService.selectTransactionByUserId(userId);
		
		

	}

		
		
//			System.out.println("getTransaction() ");
//			try {
//				  //dao.selectTransactionByUserId(userId);
//				  return dao.selectTransactionByUserId(userId);
//				
//			} catch (UserNotFoundException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			
//			return null;

		
	
	@GetMapping
	@ResponseBody
	@RequestMapping(value="/mtxn/{txnId}")
	public List<MonthlyTransaction> getMonthlyTransaction(@PathVariable int txnId) {
			System.out.println("getMonthlyTransaction() ");
			try {
				return dao.selectMonthlyTransactionByTxnId(txnId);
			} catch (TxnNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return null;

		}
	
	@GetMapping
	@ResponseBody
	@RequestMapping(value="/card/{userId}")
	public CardDetail getCardDetail(@PathVariable int userId) {
		
		System.out.println("getCardDetail()...method ");
		return dashboardService.selectCardDetailsByUser(userId);
		
//		System.out.println("getCardDetail()...method ");
//		try {
//			return dao.selectCardDetailByUserId(userId);
//		} catch (UserNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		return null;
	}
	
	
	@PostMapping
	@ResponseBody
	@RequestMapping(value="/login")
	public Users getUserLoginDetails(@RequestBody Login logindto ) throws Exception {
	System.out.println("getUserEmailDetails()...method ");
	try {
		return this.login.login(logindto);
	} catch (NoResultException e) {
		// TODO Auto-generated catch block 
		e.printStackTrace();
	
	
		
	}
	return null;
	

	}
	
//	@GetMapping
//	@ResponseBody
//	@RequestMapping(value="/test/{userId}")
//	public List<Transaction> getTransactionB(@PathVariable int userId) {
//			System.out.println("getTransaction() ");
//			//dao.selectTransactionByUserId(userId);
//			  return dashboardService.selectTransactionByUserId(userId);
//			
//			
//
//		}
//	
//	@GetMapping
//	@ResponseBody
//	@RequestMapping(value="/card/test/{userId}")
//	public CardDetail getCardDetailB(@PathVariable int userId) {
//		System.out.println("getCardDetail()...method ");
//		return dashboardService.selectCardDetailsByUser(userId);
//	}
	
	@PostMapping
	@ResponseBody
	@RequestMapping(value="/addUser")
	public String addUserDetails(@RequestBody Registration registration) {
		//registration.setUserInformation();
		return this.registrationRepoImpl.addUser(registration);
		
		
		//return "user added";
		
	}
	
//	
//	@PostMapping
//	@ResponseBody
//	@RequestMapping(value="/insertUser")
//	public String addUserDetails(@RequestBody Registration registration) {
//		
//		
//		
//		
//	}
	
}	
	
	
	
	
	
	
	
	


