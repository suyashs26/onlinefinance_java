package com.example.demo.layer3;

import javax.persistence.NoResultException;

import org.springframework.stereotype.Repository;

import com.example.demo.layer2.UserNotFoundException;
import com.example.demo.layer2.Users;

@Repository
public interface LoginRepository {
	
	public Users selectUserByUserNameAndPass(int userName , String password) throws Exception;
	

}
