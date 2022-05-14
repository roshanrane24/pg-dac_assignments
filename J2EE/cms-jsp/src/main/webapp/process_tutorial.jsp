<%-- Directives --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%-- Set properties of tutorial --%>
<jsp:setProperty property="*" name="tutorial" />

<%-- Redirect user if data is valid --%>
<c:redirect url="${ sessionScope.tutorial.validateTutorial() }.jsp" />