package com.example.demo.layer4;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.layer2.Login;
import com.example.demo.layer2.Users;
import com.example.demo.layer3.LoginRepoImpl;
import com.example.demo.layer3.LoginRepository;

@Service
public class LoginServiceImpl implements LoginService {
	
	

	
	@Autowired
	LoginRepository loginDao;

	@Transactional
	public Users login(Login logindto) throws Exception {
		// TODO Auto-generated method stub
		
		Users id = this.loginDao.selectUserByUserNameAndPass(logindto.getUserName(), logindto.getPassword());
		//long id = this.logindaoImpl.getUserByUsernameAndPassword(loginDto.getUsername(),loginDto.getPassword());
		return id;
		//return 0;
	}
	
//	
//	@Transactional
//	public boolean checkPassword(Login login){
//		
//		String password = login.getPassword();
//		String dbPassword = 
//		String dbPassword = gladiatorDao.getPassword(login.getUser_name());
//		StringBuilder passNew = new StringBuilder();
//		String newPassword = null;
//		
//		try {
//			MessageDigest md;
//            md = MessageDigest.getInstance("SHA-256");
//
//            byte[] hashedPasswordNew = md.digest(password.getBytes(StandardCharsets.UTF_8));
//            
//            for (byte b : hashedPasswordNew)
//                passNew.append(String.format("%02x", b));
//            
//            newPassword = passNew.toString();
//		}            
//		catch (Exception e) {
//			e.printStackTrace();
//		}
//		
//		if (dbPassword.equals(newPassword))
//			return true;
//		else 
//			return false;
//	}
	
	

}
