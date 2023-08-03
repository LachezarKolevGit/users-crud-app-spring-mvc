<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/user-post-page.css"> <%-- href="<c:url value="/resources/css/user-post-page.css"/>">--%>
    <meta charset="ISO-8859-1">
    <title>Insert title here</title>
</head>
<body>
<h2>Enter name and address of the user you want to create</h2>
<p>Fields with * are required</p>
<div class=form-wrapper>
    <form:form method="POST"
               action="${pageContext.request.contextPath}/user"
               modelAttribute="userDTO" cssClass="form">
        <div class=form-main>
            <h3>User details</h3>
            <input id="id" name="id" type="hidden"/>
            <hr>
            <label>Name*</label>
            <form:input path="name"/>
            <form:errors path="name" element="div" cssClass="error-div"/>
            <label>Age*</label> <input type="number" id="age-input" name="age"> <br>
            <form:errors path="age" element="div" cssClass="error-div"/>
            <hr>
            <h3>Address:</h3>
            <label>City*</label>
            <form:input path="addressDTO.city"/>
            <form:errors path="addressDTO.city" element="div" cssClass="error-div"/>
            <label>Street*</label>
            <form:input path="addressDTO.street"/>
            <form:errors path="addressDTO.street" element="div" cssClass="error-div"/>
            <%--<input type="text" id="street-input" name="addressDTO.street">--%>

            <label>Number*</label>
            <%--<form:input path="addressDTO.number"/>--%>
            <input type="number" id="number-input" name="addressDTO.number">
            <form:errors path="addressDTO.number" element="div" cssClass="error-div"/>
        </div>
        <div class=form-footer>
            <button id="btn-submit" type="submit" value="Submit"></button>
        </div>
    </form:form>
</div>
</body>
</html>