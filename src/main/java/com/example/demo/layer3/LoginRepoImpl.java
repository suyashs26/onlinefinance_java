package com.example.demo.layer3;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import org.springframework.data.repository.RepositoryDefinition;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.layer2.UserNotFoundException;
import com.example.demo.layer2.Users;

@Repository
public class LoginRepoImpl extends BaseRepository implements LoginRepository {

	@Transactional
	public Users selectUserByUserNameAndPass(int userName, String password) throws Exception {
		// TODO Auto-generated method stub
		EntityManager entityManager = getEntityManager();
		Users users;
		try {
		Query query = entityManager.createQuery("select u from Users u where u.userName = :vuserId and u.password =:vpass ");
		query.setParameter("vuserId", userName);
		query.setParameter("vpass", password);
		users = (Users) query.getSingleResult();
		
		}
		catch(Exception e)
		{
			throw new Exception("User Not Found");
		}
		
		return users;
		
		//return null;
	}

	
	
	

}
