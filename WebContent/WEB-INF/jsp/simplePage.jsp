<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ page session="false"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/style_new.css"  media="screen" />
<title>Simple Spring 4</title>
</head>
<body>
<div class="widget-box">
	<div class="widget-header">
	<h5 class="widget-title"><a href="greeting" >Greeting example without parameter.</a></h5><br>
	<h5 class="widget-title"><a href="greeting?name=Ethan">Greeting example with parameter.</a></h5><br>
	<h5 class="widget-title"><a href="registerForm" > Registration example</a></h5><br>
	<sec:authorize access="hasRole('ROLE_ADMIN')">
		<h5 class="widget-title"><a href="viewperson" > view all person</a></h5>
	</sec:authorize>
	</div>
	<div class="widget-body">
		<div class="widget-main">
			<p>You have login with ${currentUser.name}</p>
			<p>You has roles ${currentUser.role}</p>
		</div>
	</div>
</div>
<p><a href="${pageContext.request.contextPath}/logout">Log Out</a></p>
</body>
</html>
