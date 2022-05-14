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

<body>

	<h2 align="center">Hello, ${ user.validatedUserDetails.name }</h2>

	<%-- Close DAO's --%>
	${ session.user.userDao.cleanup() } ${ session.tutorial.tutorialDao.cleanup() }
	${ session.topic.topicDao.cleanup() }

	<%-- Close Session --%>
	${ pageContext.session.invalidate() }
	<!-- Logged Out Message -->
	<h4>You have logged out</h4>

	<h4>
		<a href="login.jsp">
			<button>Login Again</button>
		</a>
	</h4>

</body>
</html>