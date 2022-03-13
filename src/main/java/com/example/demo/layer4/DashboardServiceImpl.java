package com.example.demo.layer4;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.layer2.CardDetail;
import com.example.demo.layer2.Transaction;
import com.example.demo.layer2.UserNotFoundException;
import com.example.demo.layer3.DashboardRepository;
@Service
public class DashboardServiceImpl {
	
	@Autowired
	DashboardRepository dao;
	
	@Transactional
	public List<Transaction> selectTransactionByUserId(int userId) {
		
		try {
			return dao.selectTransactionByUserId(userId);
		} catch (UserNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}
	
	@Transactional
	public CardDetail selectCardDetailsByUser(int userId) {
		try {
			return dao.selectCardDetailByUserId(userId);
		} catch (UserNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}	
//		

