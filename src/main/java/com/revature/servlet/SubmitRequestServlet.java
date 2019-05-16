package com.revature.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.catalina.servlets.DefaultServlet;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.bean.Request;
import com.revature.daos.RequestDao;
import com.revature.util.HttpException;
import com.revature.services.LoginService;
import com.revature.services.UserService;


public class SubmitRequestServlet extends DefaultServlet{
	
	UserService service = new UserService();
	
	public void service(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		response.addHeader("Access-Control-Allow-Headers", "content-type");
		response.addHeader("Access-Control-Allow-Origin", request.getHeader("Origin"));
		super.service(request, response);
	}
	
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException
	{
		ObjectMapper om = new ObjectMapper();
		Request request = om.readValue(req.getInputStream(), Request.class);
		try {
			service.submitRequest(request.getAuthorNumber(), request.getAmount(), request.getDescription(), request.getReceipt(), request.getTypeId());
		} catch (HttpException e) {
			res.setStatus(e.getStatus());
			return;
		}
		
		
	}
	
	
	
}
	
