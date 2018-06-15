<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form:form method="post" modelAttribute="tweet">
		Title: <form:input path="title"/>
		<form:errors path="title"/><br>
		Text: <form:textarea path="tweetText" rows="5" cols="50"/>
		<form:errors path="tweetText"/><br>
		User: <form:select items="${users}" path="user" itemValue="id" itemLabel="fullName"/>
		<form:errors path="user"/><br>
		<input type="submit" name="send" value="Send"/>
	</form:form>
</body>
</html>