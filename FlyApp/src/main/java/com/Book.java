package com;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet("/Book")
public class Book extends HttpServlet{
@Override
protected void service(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException {
	String name = arg0.getParameter("name");
	String email = arg0.getParameter("email");
	String age = arg0.getParameter("age");
	String contact = arg0.getParameter("contact");
	
	
	HttpSession session = arg0.getSession();
	session.setAttribute("name", name);
	session.setAttribute("email", email);
	session.setAttribute("age", age);
	session.setAttribute("contact", contact);
	
	
	RequestDispatcher rs =arg0.getRequestDispatcher("Destin.jsp");
	rs.forward(arg0, arg1);
	
	
	
	
}
}
