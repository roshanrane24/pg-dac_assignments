<%-- Directives --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Success</title>
</head>
<%-- Not logged in redirect to login page --%>
<c:if test="${ user == null }">
	<c:redirect url="login.jsp" />
</c:if>
<c:if test="${ !user.isAdmin() }">
	<c:redirect url="login.jsp" />
</c:if>

<body>
	<!-- Success Message -->
	<h2 style="color: green;" align="center">Successfully Added
		Tutorial</h2>

	<%@ include file="logout.jsp"%>

</body>
</html>