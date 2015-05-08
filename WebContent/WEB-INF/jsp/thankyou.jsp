<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ taglib prefix="c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page session="false"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Registration Successful</title>
</head>
<body>
<h3>Thank you for registering for a prize.</h3>

Your registration information: <br />
First Name: ${person.firstName} <br />
Last Name: ${person.lastName}<br />
Age: ${person.age}<br />
Email: ${person.email}<br />
<p><a href="${pageContext.request.contextPath}/smvc/simplePage" >Return to home page</a>.</p>

</body>
</html>