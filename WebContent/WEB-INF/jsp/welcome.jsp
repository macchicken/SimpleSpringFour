<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page session="false"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<head>
    <title>Spring Hellow World</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
</head>
<body>
    <p> Hello,  ${name}! </>
	<hr />
	<table border="1">
		<thead>
			<tr>
				<th>Item id</th>
				<th>Item Title</th>
				<th>Picture</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="product" items="${products}" varStatus="productCount">
				<tr>
					<td>${product.id}</td>
					<td>${product.title}</td>
					<td><img src="${product.imgUrl}" width="150px" alt="image not available"></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<hr />
	<p><a href="${pageContext.request.contextPath}/smvc/simplePage" >Return to home page</a>.</p>
</body>
</html>