<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page session="false"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Register</title>

</head>
<body>
<h3>Register for a prize by completing this form.</h3>

<form:form action="register" commandName="person">
	<label>First Name
<form:input  path="firstName" /> <form:errors path="firstName"/> </label>
<br/>
<label> Last Name 
<form:input type = "text" path= "lastName"/></label>
<br/>
<label>Email 
<form:input path= "email" /><form:errors path="email"/></label>
<br/>
<label>Age
<form:input  path= "age" /><form:errors path="age"/></label>
<br/>
<input type = "submit" value = "Submit"/>
</form:form>
<hr/>
<p><a href="${pageContext.request.contextPath}/smvc/simplePage" >Return to home page</a>.</p>
</body>
</html>