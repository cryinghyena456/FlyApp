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

String name = (String) session.getAttribute("name");
String age =(String) session.getAttribute("age");
String email = (String) session.getAttribute("email");
String contact = (String) session.getAttribute("contact");





%>
<form action  = "Reg">
<label>Enter source</label>

<select name = "des">  
<option value = "MUMBAI"> MUMBAI   
</option>  
<option value = "BANGALORE"> BANGALORE   
</option>  
<option value = "DELHI"> DELHI  
</option>  
<option value = "CHENNAI"> CHENNAI  
</option>  
</select>  

<br>
<br>

<label>Enter dest</label>

<select name = "des">  
<option value = "MUMBAI"> MUMBAI   
</option>  
<option value = "BANGALORE"> BANGALORE   
</option>  
<option value = "DELHI"> DELHI  
</option>  
<option value = "CHENNAI"> CHENNAI  
</option>  
</select>  
<br>
<br>

<label>Input date</label>
<input type = "text" name = "date">
<br>
<br>
<input type = "submit">
</form>
</body>
</html>