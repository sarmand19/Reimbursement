package com.revature.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.catalina.servlets.DefaultServlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.bean.Credentials;
import com.revature.services.LoginService;
import com.revature.util.HttpException;

import com.revature.bean.User;

public class loginServlet extends DefaultServlet {
	
	LoginService loginService = new LoginService();

	
	@Override
	public void init() {
		System.out.println("LoginServlet is initializing");
	}
	
	@Override
	//To give permission to the client to submit request to this servlet.
	// Every servlet should have this.
	public void service(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		response.addHeader("Access-Control-Allow-Headers", "content-type");
		response.addHeader("Access-Control-Allow-Origin", request.getHeader("Origin"));
		super.service(request, response);
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		ObjectMapper om = new ObjectMapper();
		Credentials credentials = om.readValue(request.getInputStream(), Credentials.class);
		
		// 1. Login works fine, a session is created and is communicate to the client in some manner
		// 2. Login fails, some error is received and must be communicated to the client via status code
		//		400 - username/password don't match, or username doesn't exist
		//      500 - Some unhandled exception occurs during processing, servers fault
		Integer id = null;
		String fname = "";
		String lname = "";
		Integer roleId = null;
		try {
			id = this.loginService.login(credentials);
		} catch (HttpException e) {
			response.setStatus(e.getStatus());
			return;
		}
		
		User user = new User();
		System.out.println(credentials.getUsername()+credentials.getPassword());
		HttpSession session = request.getSession();
		session.setAttribute("id", id);	
		String resp = "{\"id\":"+id+",\"username\":\""+credentials.getUsername()+"\""+"}";
		response.getWriter().write(resp);
		String cache = user.getUserId() +" "+user.getRoleId()+" "+user.getFirstName() +" "+user.getLastName();
		//HttpSession session = request.getSession(true);
//		session.setAttribute("id", id);	
		om.writeValue(response.getOutputStream(),cache);

		
	}
}
