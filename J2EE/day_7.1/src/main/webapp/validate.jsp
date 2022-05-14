<%@page import="pojos.User"%>
<%@page import="java.util.HashMap"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<%!
	// Declaration block
	HashMap<String, User> users;

	// override jspInit
	public void jspInit() {
		users = new HashMap<>();
		users.put("Rama", new User("Rama", "1234", 25));
		users.put("Raj", new User("Raj", "4535", 22));
		users.put("Kir", new User("Kir", "123", 25));

	}%>

<body>
	<%
	// Get request parameters
	String uname = request.getParameter("name");
	String pass = request.getParameter("pass");

	// Get user fron data
	User user = users.get(uname);

	// User Exist
	if (user != null) {
		if (user.getPassword().equals(pass)) {
			// valid User. Create session var of user details
			session.setAttribute("client_user", user);

			// Forward request to details
			RequestDispatcher rd = request.getRequestDispatcher("details.jsp");
			rd.forward(request, response);
		} else {
	%>
	<h4>
		Login failed, <a href='login.jsp'>Retry</a>
	</h4>
	<%
		}
	} else {
	%>
	<h4>
		New User? Please Register <a href='register.jsp'>here</a>
	</h4>
	<%
	}
	%>
</body>
<%!public void jspDestroy() {
		users = null;
	}%>
</html>