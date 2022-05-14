<%-- Directives --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%-- HTML --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Topics</title>
</head>
<%-- Not logged in redirect to login page --%>
<c:if test="${ user == null }">
	<c:redirect url="login.jsp" />
</c:if>

<body>
	<h1 align="center">Select Topic</h1>
	<form action="tutorials.jsp">
		<table>
			<c:forEach items="${ sessionScope.topic.allTopics }" var="t">
				<tr>
					<td><input type="radio" name="topicId" value="${ t.id }"
						id="${ t.id }"> <label for="${ t.id }"> ${ t.name }
					</label></td>
				</tr>
			</c:forEach>
			<tr>
				<td><input type="submit" value="choose Topic"></td>
			</tr>
		</table>
	</form>
</body>
</html>