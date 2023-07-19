<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
 <h1>Enter the id of the user you want to delete</h1>
<form action="${pageContext.request.contextPath}/user" method="post">
    <input type="hidden" name="_method" value="delete"/>
    <label>Id of user</label>
    <input type="number" name="userId">
    <input type="submit" value="Submit">
</form></body>
</html>