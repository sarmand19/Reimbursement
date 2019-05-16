package com.revature.services;

import com.revature.daos.UserDao;
import com.revature.daos.RequestDao;
import com.revature.daos.SubmitRequestDao;
import com.revature.util.HttpException;

import java.util.List;

import com.revature.bean.Request;
import com.revature.bean.User;


public class UserService {
	
	
	UserDao userDao = new UserDao();
	
	//SubmitRequestDao requestDao = new SubmitRequestDao();
	RequestDao requestDao = new RequestDao(); 
	
	
	public Boolean validUser(String username, String password) {

		User user =userDao.getUser(username, password);
		if(user == null) {
			
			throw new HttpException(400);	
		}//end if
		
		return true;	
	}// end method validUser
	
	/******************************************************************************************************************/
	
	public void submitRequest(int userId, float amount, String description, String receipt, int typeId)
	 //void insertRequest(int userId, double amount, String description, String receipt, int typeId)
	{
		
		requestDao.insertRequest(userId, amount, description, receipt, typeId);
		
	}
	
	/*public void getRequest(int userId, float amount, String description, String receipt, int typeId)
	 //void insertRequest(int userId, double amount, String description, String receipt, int typeId)
	{
		
		requestDao.insertRequest(userId, amount, description, receipt, typeId);
		
	}*/
	
	
	//Display All Requests
		
	public List<Request>ShowAllRequests(int userId, int roleId){
		List<Request>requests= requestDao.getRequests(userId, roleId);
		return requests;
	}
	//Pending tickets
	public List<Request> ShowPendingRequests(int userId, int roleId,int statusId) {
		List<Request> requests =requestDao.getPendingTickets(userId, roleId,statusId);
		return requests;
		
	}
	

}// UserService
