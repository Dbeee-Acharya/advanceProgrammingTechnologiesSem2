<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
<table>
	<thead> 
		<tr>
			<th>First Name</th>
			<th>Last Name</th>
			<th>Username</th>
			<th>dob</th>
			<th>gender</th>
			<th>Phone Number</th>
			<th>subject</th>
		</tr>
	<thead>
	
	<tbody>
		<tr>
			<c:forEach var="student" items=${listOfStudents}
				<td><c:out value=${student.firstName}</td>
				<td><c:out value=${student.lastName}</td>
				<td><c:out value=${student.userName}</td>
				<td><c:out value=${student.dob}</td>
				<td><c:out value=${student.gender}</td>
				<td><c:out value=${student.email}</td>
				<td><c:out value=${student.phoneNumber}</td>
				<td><c:out value=${student.subject}</td>
		</tr>
	</tbody>
		
</table>

</body>
</html>