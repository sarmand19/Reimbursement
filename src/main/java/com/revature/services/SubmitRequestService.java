package com.revature.services;

import com.revature.daos.SubmitRequestDao;
import com.revature.daos.UserDao;



public class SubmitRequestService {
	
UserDao userDao = new UserDao();
	
	SubmitRequestDao submitRequestDao = new SubmitRequestDao();
	
	public void submitRequest(int userId, double amount, String description, String receipt, int typeId) {
		submitRequestDao.insertRequest(userId, amount, description, receipt, typeId);
	
	}
	
	
}
