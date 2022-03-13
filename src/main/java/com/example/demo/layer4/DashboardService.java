package com.example.demo.layer4;

import java.util.List;

import com.example.demo.layer2.CardDetail;
import com.example.demo.layer2.Transaction;

public interface DashboardService {
	
	public List<Transaction> selectTransactionByUserId(int userId);
	
	public CardDetail  selectCardDetailsbyUser(int userId);

}
