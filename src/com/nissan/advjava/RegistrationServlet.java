package com.nissan.advjava;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.servlet.RequestDispatcher;
/**
 * Servlet implementation class RegistrationController
 */
//@WebServlet("/RegistrationController")
public class RegistrationServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uname = request.getParameter("uname");
		String upass = request.getParameter("upass");
		String uemail = request.getParameter("uemail");
		
		RegistrationBean user = new RegistrationBean();
		user.setUname(uname);
		user.setUpass(upass);
		user.setUemail(uemail);
		
		RegistrationServices registerUser = new RegistrationServices();
		try {
			registerUser.makeConnection();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		registerUser.addUser(user);
		
		
		RequestDispatcher rd =  request.getRequestDispatcher("home_register.jsp");
		rd.forward(request, response);
		
	}

}
