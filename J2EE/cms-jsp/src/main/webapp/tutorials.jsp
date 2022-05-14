<%@ page language="java" contentType="text/html; charset=US-ASCII"
	pageEncoding="US-ASCII"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="US-ASCII">
<title>Insert title here</title>
</head>
<%-- Not logged in redirect to login page --%>
<c:if test="${ user == null }">
	<c:redirect url="login.jsp" />
</c:if>

<jsp:setProperty property="topicId" name="tutorial" />
<body>
	<h1 align="center">Select Tutorial</h1>

	<ul>
		<c:forEach items="${ tutorial.tutorialsByTopic }" var="tut">
			<li><a href="details.jsp?name=${ tut.name }"> ${ tut.name }
			</a></li>
		</c:forEach>
	</ul>

	<h4>
		<a href="topics.jsp">
			<button>Go Back</button>
		</a> <a href="logout.jsp">
			<button>Logout</button>
		</a>
	</h4>

</body>
</html>