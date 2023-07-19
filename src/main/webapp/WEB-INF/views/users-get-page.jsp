<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
 <h1>List of users:</h1>
		<c:forEach var="usersMap" items="${usersMap}">
    	<p> Id: ${usersMap.key} </p>
    	<p> Name: ${usersMap.value} </p>
		</c:forEach></body>
</html>