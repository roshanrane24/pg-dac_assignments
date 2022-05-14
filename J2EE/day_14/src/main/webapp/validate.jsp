<%-- Directives --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%-- Initiate JB w/o java code using actions --%>
<jsp:useBean id="user" class="beans.UserBean" scope="session" />
<jsp:useBean id="topic" class="beans.TopicBean" scope="session" />
<jsp:useBean id="tutorial" class="beans.TutorialBean" scope="session" />

<%-- Setter for properties --%>
<jsp:setProperty property="*" name="user" />

<%-- Invoke BL Method & Redirect the user --%>
<%-- <h5>Output : ${ sessionScope.user.validateUser() }</h5> --%>
<%-- <jsp:forward page="${ sessionScope.user.validateUser() }.jsp"/> --%>
<c:redirect url="${ sessionScope.user.validateUser() }.jsp" />