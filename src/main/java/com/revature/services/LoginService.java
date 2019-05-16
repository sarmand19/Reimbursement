package com.revature.services;

import com.revature.bean.Credentials;
import com.revature.bean.User;
import com.revature.daos.LoginDao;
import com.revature.util.HttpException;

public class LoginService {
	LoginDao loginDao = new LoginDao();
	public static int currentId;
	

	public int login(Credentials credentials) {
		// attempt to retrieve username/password from database
		User user = loginDao.getPasswordByUsername(credentials.getUsername());
		// compare them
		if (!user.getPassword().equals(credentials.getPassword())) {
			throw new HttpException(400);
		}
		
	return	(currentId = user.getUserId());
		
		//return currentId;
		
	}
}
