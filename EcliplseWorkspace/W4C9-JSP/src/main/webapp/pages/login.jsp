<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<%
	String message = (String)request.getAttribute("error_message");
	
	if((message != null && !message.isEmpty())){
		%> <p style = "color: red"> <%= message %> 
	<%
	}
	
	%>

<form action="Login" method="post">
	<p>Email: <input type="email" name="email"></p>
	<p>Password: <input type="password" name="password"></p>
	<br>
	<input type = "submit" name = "login">
	
</form>
	
</body>
</html>