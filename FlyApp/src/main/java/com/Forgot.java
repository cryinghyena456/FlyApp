package com;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/forgot")
public class Forgot extends HttpServlet {
@Override
protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

String npass= req.getParameter("npass");
	
try {
	Class.forName("com.mysql.cj.jdbc.Driver");
	Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/phase2","root","root");
	PreparedStatement pstmt = con.prepareStatement("update user set pass=?");
	pstmt.setString(1, npass);
	
	int x = pstmt.executeUpdate();
	
	
		
	if( x >0) {
		System.out.println("Database created");
		
	}else {System.out.println("error");
	pstmt.close();
	
	
}
		
	
}catch(Exception e) {
	
}
}
}

