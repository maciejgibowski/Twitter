<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<table>
<tr><th>Imię</th><th>Nazwisko</th><th>Email</th><th>Akcja</th></tr>
	<c:forEach var="user" items="${users}">
	<tr>
	<td><c:out value="${user.firstName}"/></td>
	<td><c:out value="${user.lastName}"/></td>
	<td><c:out value="${user.email}"/></td>
	<td><a href="<c:url value='/user/delete?id=${user.id}'/>">Usuń</a> 
	<a href="<c:url value='/user/edit?id=${user.id}'/>">Edytuj</a></td>
	</tr>
	</c:forEach>
</table>
</body>
</html>