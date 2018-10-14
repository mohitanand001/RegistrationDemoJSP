<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	Welcome !!
	<%
		String uname =  request.getParameter("uname");
		String uemail= request.getParameter("uemail");
	%>	
	Name <br>
	<%= uname %>
	<br>
	Email
	<%= uemail %>
	
</body>
</html>