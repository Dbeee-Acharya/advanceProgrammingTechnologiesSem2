<%@page import="Week4Lab.DatabaseConnectivity"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.ResultSet"%>
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
	Connection conn = DatabaseConnectivity.getDbConnection();
	PreparedStatement st = conn.prepareStatement("select * from student_register");
	ResultSet set = st.executeQuery();
%>

	<table>
		<thead>
			<tr>
				<th>ID</th>
				<th>First Name</th>
				<th>Last Name</th>
			</tr>
		</thead>
		
		<tbody>
			<%
				while(set.next()) {
					int id =set.getInt(1);
					String firstName = set.getString("firstname");
					String lastName = set.getString("lastName");
					String email = set.getString("email");
					%>
					<tr>
						<td><%=id %></td>
						<td><%=firstName %></td>
						<td><%= lastName %></td>
						<td><%=email %></td>
			<%
				}
			%>
		</tbody>
		
	</table>

</body>
</html>