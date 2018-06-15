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
	<a href="<c:url value='/home'/>">Zadanie 1 - Home</a><br>
	<a href="<c:url value='/user/1/tweets'/>">Zadanie 3 - Wyszukiwanie tweetów po user_id</a><br>
	<a href="<c:url value='/user/search-tweets?titleStart=a'/>">Zadanie 3 - Wyszukiwanie tweetów po tytule</a><br>
	<a href="<c:url value='/user/add'/>">Zadanie 4 - dodanie użytkownika</a><br>
	<a href="<c:url value='/tweet/add'/>">Zadanie 4 - dodanie tweet'a</a><br>
	<a href="<c:url value='/user/all'/>">Zadanie 5</a><br>
</body>
</html>