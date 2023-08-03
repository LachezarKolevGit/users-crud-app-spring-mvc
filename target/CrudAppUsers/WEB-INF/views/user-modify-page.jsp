<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Enter id of user you want to modify</h1>
<!-- 
<input type="hidden" name="_method" value="DELETE"/><input type="submit" value="delete"></form></td>
 -->

		<form action="${pageContext.request.contextPath}/user" method="post">
    		<input type="hidden" name="_method" value="put">
    		<label>Id of user</label>
    		<input type="number" name="id">
    		<label>New name</label>
    		<input type="text" name="name">
    		<input type="submit" value="Submit">
		</form>
</body>
</html>