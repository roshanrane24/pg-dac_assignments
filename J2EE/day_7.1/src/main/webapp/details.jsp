<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1 align="center"> Welcome ${ sessionScope.client_user.userName }</h1>
<h5 align="center">Session ID : ${ pageContext.session.id }</h5>

<h3>User Name 	: ${sessionScope.client_user.userName}</h3>
<h3>Password	: ${sessionScope.client_user.password}</h3>
<h3>Age 		: ${sessionScope.client_user.age}</h3>

<% String url = response.encodeRedirectURL("logout.jsp"); %>

<h5><a href="<%= url %>">Logout</a></h5>

</body>
</html>