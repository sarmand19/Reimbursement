package com.revature.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.catalina.servlets.DefaultServlet;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.bean.User;
import com.revature.bean.Request;
import com.revature.daos.RequestDao;
import com.revature.util.HttpException;
import com.revature.services.LoginService;
import com.revature.services.UserService;

import org.apache.catalina.servlets.DefaultServlet;

public class RequestServlet extends DefaultServlet {
	
UserService service = new UserService();
RequestDao requestDao = new RequestDao();
User user = new User();
Request request = new Request();
	
	public void service(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		response.addHeader("Access-Control-Allow-Headers", "content-type");
		response.addHeader("Access-Control-Allow-Origin", request.getHeader("Origin"));
		super.service(request, response);
	}
	
	
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException{
		
		
		ObjectMapper om = new ObjectMapper();
		List<Request> allUsers = requestDao.getRequests(LoginService.currentId, user.getRoleId());
		om.writeValue(res.getOutputStream(),allUsers);	
		
	}

}
