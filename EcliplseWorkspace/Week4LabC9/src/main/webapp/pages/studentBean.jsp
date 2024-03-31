<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:useBean id="studentObject" class="model.Student" scope="page"></jsp:useBean>
	<jsp:setProperty property="id" name="studentObject" value="100"/>
	<jsp:setProperty property="name" name="studentObject" value="Ram"/>	
	<jsp:setProperty property="address" name="studentObject" value="ktm"/>
	
	<p><jsp:getProperty property="id" name="studentObject"/></p>
	<p><jsp:getProperty property="name" name="studentObject"/></p>
	<p><jsp:getProperty property="address" name="studentObject"/></p>

</body>
</html>