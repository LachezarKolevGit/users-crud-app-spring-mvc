<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Users</title>
</head>
<body>
<h1>Users CRUD application
</h1>
<br>
<a href="${pageContext.request.contextPath}/user">Display users</a>
<br>
<a href="${pageContext.request.contextPath}/WEB-INF/views/user-create-page.jsp">Post user</a>
<br>
<a href="${pageContext.request.contextPath}/user-modify-page">Modify user</a>
<br>
<a href="${pageContext.request.contextPath}/user-delete-page">Delete user</a>
<br>
</body>
</html>