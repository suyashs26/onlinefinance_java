package com.example.demo.layer2;



public class UserNotFoundException extends Exception {
	public UserNotFoundException(String str) {
		super("user not found");
	}
}