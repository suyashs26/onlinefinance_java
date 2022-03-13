package com.example.demo.layer4;

import javax.persistence.NoResultException;

import org.springframework.http.ResponseEntity;

import com.example.demo.layer2.Login;
import com.example.demo.layer2.Users;

public interface LoginService {
	
	public Users login(Login logindto) throws  Exception;

}
