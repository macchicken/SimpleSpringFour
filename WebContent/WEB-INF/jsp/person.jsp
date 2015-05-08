<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page session="false"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Individual Person</title>
</head>
<body>
<form:form action="${pageContext.request.contextPath}/smvc/person/update" method = "post" commandName="person">
<label>FirstName
<form:input  path="firstName" /> <form:errors path="firstName"/></label>
<br/>
<label>LastName
<form:input  path="lastName" /> <form:errors path="lastName"/></label>
<br/>
<label>Email
<form:input  path="email" /> <form:errors path="email"/></label>
<br/>
<label>Age
<form:input  path="age" /> <form:errors path="age"/></label>
<form:input type="hidden" path="id"/>
<br/>
<input type = "submit" value = "Submit"/>
<br/>
<input type = "reset" />
</form:form>
<hr/>
<p><a href="${pageContext.request.contextPath}/smvc/simplePage" >Return to home page</a>.</p>
</body>
</html>