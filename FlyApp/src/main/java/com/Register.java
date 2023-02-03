package com;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet("/Reg")
public class Register extends HttpServlet {
private Connection con;
private PreparedStatement stmt;

@Override
protected void service(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException {
	

try {
	
	HttpSession session = arg0.getSession();
	String name =(String) session.getAttribute("name");
	String age = (String) session.getAttribute("age");
	String email = (String) session.getAttribute("email");
	String contact = (String) session.getAttribute("contact");
			
		
	
	

	String source = arg0.getParameter("src");
	String dest = arg0.getParameter("des");
	String date = arg0.getParameter("date");
    RequestDispatcher disp = null;
	PrintWriter writer = arg1.getWriter();
	Connection con = null;
	
	Class.forName("com.mysql.cj.jdbc.Driver");
	 con = DriverManager.getConnection("jdbc:mysql://localhost:3306/phase2","root","root");
	PreparedStatement pstmt = con.prepareStatement("insert into flight(name,age,email,contact,source,destination,date) values(?,?,?,?,?,?,?)");
	pstmt.setString(1, name);
	pstmt.setString(2, age);
	pstmt.setString(3, email);
	pstmt.setString(4, contact);
	pstmt.setString(5, source);
	pstmt.setString(6, dest);
	pstmt.setString(7, date);
	
	int x = pstmt.executeUpdate();
	disp = arg0.getRequestDispatcher("payment.jsp");
	if(x>0) {
		session.setAttribute("source", source);
		session.setAttribute("dest", dest);
		session.setAttribute("date", date);
		
		arg0.setAttribute("status", "success");
		
	}else {
		
		arg0.setAttribute("status", "failed");
		
	}
	disp.forward(arg0, arg1);
	
	
}
catch (Exception e) {
	
	e.printStackTrace();
	
}
	
	
}
}
