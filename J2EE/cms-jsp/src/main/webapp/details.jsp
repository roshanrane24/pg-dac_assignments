<%@ page language="java" contentType="text/html; charset=US-ASCII"
	pageEncoding="US-ASCII"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="US-ASCII">
<title>${ param.name }</title>
</head>
<%-- Not logged in redirect to login page --%>
<c:if test="${ user == null }">
	<c:redirect url="login.jsp" />
</c:if>

<jsp:setProperty property="name" name="tutorial" />
<body>

	${ tutorial.getTutorialByName() }
	<h1 align="center">${ tutorial.name }</h1>

	<table>
		<tr>
			<td>ID :</td>
			<td>${ tutorial.tutorial.id }</td>
		</tr>
		<tr>
			<td>Name :</td>
			<td>${ tutorial.tutorial.name }</td>
		</tr>
		<tr>
			<td>Author :</td>
			<td>${ tutorial.tutorial.author }</td>
		</tr>
		<tr>
			<td>Published Date :</td>
			<td>${ tutorial.tutorial.publishedDate }</td>
		</tr>
		<tr>
			<td>Visits :</td>
			<td>${ tutorial.tutorial.visits }</td>
		</tr>
		<tr>
			<td>Content :</td>
			<td>${ tutorial.tutorial.content }</td>
		</tr>
		<tr>
			<td>Topic ID :</td>
			<td>${ tutorial.tutorial.topicId }</td>
		</tr>
	</table>

	<h4>
		<a href="tutorials.jsp?topicId=${ tutorial.tutorial.topicId }">
			<button>Go Back</button>
		</a> <a href="logout.jsp">
			<button>Logout</button>
		</a>
	</h4>
</body>
</html>