<%@ page language="java" contentType="text/html; charset=US-ASCII"
	pageEncoding="US-ASCII"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="US-ASCII">
<title>Insert title here</title>
</head>
<body>
	<h1>Employee Details</h1>

	<table>
		<tr>
			<th>Id</th>
			<th>Name</th>
			<th>Address</th>
			<th>Salary</th>
			<th>Department</th>
			<th>Joining Date</th>
		</tr>
		<c:forEach items="${ requestScope.emps }" var="emp">
			<tr>
				<td>${ emp.empId }</td>
				<td>${ emp.name }</td>
				<td>${ emp.address }</td>
				<td>${ emp.salary }</td>
				<td>${ emp.department }</td>
				<td>${ emp. date }</td>
			</tr>
		</c:forEach>

	</table>


</body>
</html>