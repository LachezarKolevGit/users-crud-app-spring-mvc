<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<c:out value="${userDTO.name}" default="Not Available" escapeXml="true" />
	<h1>Enter the name of the user you want to create</h1>
	<div class=form-wrapper>
		<form:form method="POST"
			action="${pageContext.request.contextPath}/user"
			modelAttribute="userDTO">
			<form:errors path="*" element="div" />
			<div class=form-main>
				<h3>User details</h3>
				<input id="id" name="id" type="hidden" /> <label>Name</label>
				<form:input path="name" />
				<form:errors path="name" element="div" />
				<label>Age</label> <input type="number" name="age"> <br>
				<form:errors path="age" element="div" />
				<hr>
				<h3>Address:</h3>
				<!-- <label>Enter address</label> <input type="text" name="address"> -->
				<label>City</label> <input type="text" name="address.city">
				<form:errors path="address.city" element="div" />
				<label>Street</label> <input type="text" name="address.street">
				<form:errors path="address.street" element="div" />
				<label>Number</label> <input type="text" name="address.number">
				<form:errors path="address.number" element="div" />

			</div>
			<div class=form-footer>
				<button type="submit" value="Submit"></button>
			</div>
		</form:form>
	</div>
</body>
</html>