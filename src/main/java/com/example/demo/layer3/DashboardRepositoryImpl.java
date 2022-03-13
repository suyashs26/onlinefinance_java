package com.example.demo.layer3;

import java.util.List;


import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.layer2.CardDetail;
import com.example.demo.layer2.MonthlyTransaction;
import com.example.demo.layer2.ProductDetail;
import com.example.demo.layer2.Transaction;
import com.example.demo.layer2.TxnNotFoundException;
import com.example.demo.layer2.UserInformation;
import com.example.demo.layer2.UserNotFoundException;
import com.example.demo.layer2.Users;


@Repository
public class DashboardRepositoryImpl extends BaseRepository implements DashboardRepository {
	
	
//	
//	@Override
//	public UserInformation selectUser(int userId) throws UserNotFoundException {
//		// TODO Auto-generated method stub
//		return null;
//	}

	@Transactional
	public List<Transaction> selectTransactionByUserId(int userId) throws UserNotFoundException {
		// TODO Auto-generated method stub
		EntityManager entityManager = getEntityManager();
		Query query = entityManager.createQuery("select t from Transaction t where t.userInformation.userId = :vuserId ");
		query.setParameter("vuserId", userId);
		List<Transaction> TxnListAsPerUser = query.getResultList();
		//System.out.println(TxnListAsPerUser);
		return TxnListAsPerUser;

	}

	@Transactional
	public List<MonthlyTransaction> selectMonthlyTransactionByTxnId(int txnId) throws TxnNotFoundException {
//		// TODO Auto-generated method stub
		EntityManager entityManager = getEntityManager();
		Query query = entityManager.createQuery("select t from MonthlyTransaction t where t.transaction.txnId = :vtxnId");
		query.setParameter("vtxnId", txnId);
		List<MonthlyTransaction> MTxnListAsPerTxnId = query.getResultList();
		return MTxnListAsPerTxnId;
		
	}

	@Transactional
	public CardDetail selectCardDetailByUserId(int userId) throws UserNotFoundException {
		// TODO Auto-generated method stub
		
		
		EntityManager entityManager = getEntityManager();
		Query query = entityManager.createQuery("select u from CardDetail u where u.userInformation.userId = :vuserId");
		query.setParameter("vuserId", userId);
		//UserInformation user = user.
		CardDetail user = (CardDetail) query.getSingleResult();		
		return user;
		//return entityManager.find(CardDetail.class, userId);
		
	}

	@Transactional
	public UserInformation selectUserByEmail(String emailId) {
		// TODO Auto-generated method stub
		EntityManager entityManager = getEntityManager();
		Query query = entityManager.createQuery("select u from UserInformation u where u.emailId = :vemailId");
		query.setParameter("vemailId", emailId);
		//UserInformation user = user.
		UserInformation user = (UserInformation) query.getSingleResult();		
		return user;
		//return null;
	}

	@Transactional
	public Users selectUserByIdAndPass(int userName, String password) {
		// TODO Auto-generated method stub
		EntityManager entityManager = getEntityManager();
		Query query = entityManager.createQuery("select u from Users u where u.userName=:x  and u.password= :y");
		query.setParameter("x", userName);
		query.setParameter("y", password);
		//UserInformation user = user.
		Users user = (Users) query.getSingleResult();		
		return user;
		//return null;
	}

	
	
	

}
