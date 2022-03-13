package com.example.demo.layer3;


import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.layer2.CardDetail;
import com.example.demo.layer2.MonthlyTransaction;
import com.example.demo.layer2.ProductDetail;
import com.example.demo.layer2.Transaction;
import com.example.demo.layer2.TxnNotFoundException;
import com.example.demo.layer2.UserInformation;
import com.example.demo.layer2.UserNotFoundException;
import com.example.demo.layer2.Users;

@Repository
public interface DashboardRepository {
	
	//UserInformation selectUser(int userId) throws UserNotFoundException;
	
	public List<Transaction> selectTransactionByUserId(int userId) throws UserNotFoundException;
	List<MonthlyTransaction> selectMonthlyTransactionByTxnId(int txnId) throws TxnNotFoundException;
	CardDetail selectCardDetailByUserId(int userId) throws UserNotFoundException;
	
	UserInformation selectUserByEmail(String emailId);
	
	Users selectUserByIdAndPass(int userName, String password);
	
	
	
	
	
	

}
