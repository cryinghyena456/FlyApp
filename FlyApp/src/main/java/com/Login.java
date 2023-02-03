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
@WebServlet("/Login")
public class Login extends HttpServlet {

	public static boolean isLoggedIn = false;
    public static String password ;
    public static String email = "admin@flyaway.com";
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/phase2","root","root");
			PreparedStatement pstmt = con.prepareStatement("select * from user");
			
			ResultSet set = pstmt.executeQuery();
			
			while(set.next()==true) {
				
				password  = set.getString("pass");
				
				   PrintWriter out = resp.getWriter();

			        String email = req.getParameter("inputemail");
			        String pass = req.getParameter("inputpass");
			System.out.println(password);
			        if (email.equals(Login.email) && pass.equals(password)){
			            
			            out.println("You have LoggedIn");
			            resp.sendRedirect("/FlyApp/adashboard.jsp");
			        }
			        else {
			            
			            out.println("Login Failed : Incorrect email or Password");
			        }
			        out.close();
			
				
				
				
			}
		}catch(Exception e) {
			
		}
	 
    }
	}


