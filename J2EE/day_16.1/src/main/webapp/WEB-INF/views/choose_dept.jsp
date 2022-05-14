<%@ page language="java" contentType="text/html; charset=US-ASCII"
	pageEncoding="US-ASCII"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="US-ASCII">
<title>Departments</title>
</head>
<body>
<form action="details">
	<select id="dept" name="dept">
		<c:forEach items="${ requestScope.depts }" var="dept">
			<option value="${ dept }">${ dept }</option>
		</c:forEach>
	</select>
	<input type="submit" value="Choose" >
	</form>

</body>
</html>