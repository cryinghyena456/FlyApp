<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
String name = (String)session.getAttribute("name");
String email = (String)session.getAttribute("email");
String age = (String)session.getAttribute("age");
String contact = (String)session.getAttribute("contact");
String source = (String)session.getAttribute("source");
String dest = (String)session.getAttribute("dest");
String date = (String)session.getAttribute("date");


out.println("Ticket confirmed for "+name+" from "+source+" to "+ "dest "+ " on "+date+" Please click on the button below to make a payment of 2000 Rs");


%>	
<form action="success">
<input type = "submit">
</form>
</body>
</html>