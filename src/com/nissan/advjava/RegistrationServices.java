package com.nissan.advjava;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RegistrationServices {
	Connection con = null;
	
	public void makeConnection() throws ClassNotFoundException, SQLException
	{
		 Class.forName("com.mysql.jdbc.Driver");
		 con = DriverManager.getConnection("jdbc:mysql://localhost:3306/registration", "root", "Admin1234"); 
			
		
	}
	
	public void addUser(RegistrationBean user) {
		try 
		{
			

		    String query = "insert into user values(?,?,?)";

		    PreparedStatement ps = con.prepareStatement(query); 
		    ps.setString(1, user.getUname());
		    ps.setString(2, user.getUpass());
		    ps.setString(3, user.getUemail());

		    ps.executeUpdate(); 
		    System.out.println("successfuly inserted into database");
		    ps.close();
		    con.close();
		   } 
		catch (Exception e) 
		{
		    e.printStackTrace();
		}

		
	}
	
}
