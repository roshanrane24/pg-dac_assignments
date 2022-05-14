<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h5 align="center">
		Session ID :
		<%=session.getId()%></h5>
	<h3>Hello, ${sessionScope.client_user.userName}</h3>

	<h4>you have successfully logged out.</h4>
	<%-- Invalidate Session --%>
	<%
session.invalidate();
%>

	<h5>
		<a href="login.jsp">Login Again</a>
	</h5>

</body>
</html>