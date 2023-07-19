<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Enter the name of the user you want to create</h1>
		<form action="${pageContext.request.contextPath}/user" method="POST">
    		<label>Name</label>
    		<input type="text" name="name" placeholder="name">
    		<button type="submit" value="Submit"></button>
		</form>	
</body>
</html>