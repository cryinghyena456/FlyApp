package com;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/Fetchd")
public class FetchData extends HttpServlet {

	
	@Override
	protected void service(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/phase2","root","root");
			PreparedStatement pstmt = con.prepareStatement("select * from flight");
			
			ResultSet set = pstmt.executeQuery();
			
			while(set.next()==true) {
				
				String name = set.getString("name");
				String age = set.getString("age");
				String email = set.getString("email");
				String contact = set.getString("contact");
				
				String source = set.getString("source");
				String destination = set.getString("destination");
				String date = set.getString("date");
				
				
				
				PrintWriter writer = arg1.getWriter();
				writer.println(name +" "+age+" "+email+" "+contact+" "+source+" "+destination+" "+date);
				
			}
		}catch(Exception e) {
			
		}
	}
}
