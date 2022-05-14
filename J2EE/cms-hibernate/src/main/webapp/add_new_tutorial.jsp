<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<%-- Not logged in redirect to login page --%>
<c:if test="${ user == null }">
	<c:redirect url="login.jsp" />
</c:if>
<c:if test="${ !user.isAdmin() }">
	<c:redirect url="login.jsp" />
</c:if>

<body>

	<h3 align="center">Add New Tutorial</h3>

	<form action="process_tutorial.jsp" method="post">
		<table>
			<tr>
				<td>Topic :</td>
				<td><select name="topicId" required>
						<c:forEach items="${sessionScope.topic.allTopics}" var="topic">
							<option value="${topic.id}">${ topic.name }</option>
						</c:forEach>
				</select></td>
			</tr>
			<tr>
				<td>Name :</td>
				<td><input type="text" name="name" required></td>
			</tr>
			<tr>
				<td>Author :</td>
				<td><input type="text" name="author" required></td>
			</tr>
			<tr>
				<td>Published Date :</td>
				<td><input type="date" name="publishedDate" required></td>
			</tr>
			<tr>
				<td>Content :</td>
				<td><textarea rows="5" cols="51" name="content" required></textarea></td>
			</tr>
			<tr align="center">
				<td colspan="2"><input type="submit" value="Add"></td>
			</tr>
		</table>
	</form>

	<h4 align="center" style="color: red;">${ sessionScope.tutorial.errorMessage }
	</h4>

</body>
</html>