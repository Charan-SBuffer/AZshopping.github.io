<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="taglib.jsp"%>
<meta charset="ISO-8859-1">
<title>AZshopping</title>
</head>
<body>
	
	<%@ include file="admin-navbar.jsp"%>
	<h1>Welcome Administrater.</h1>
<c:if test="${msg.type=='INFO' }">
		<div class="alert alert-success">
			<strong>Success!</strong> ${msg.messagebody}
		</div>
	</c:if>
	<img src="resources/images/adminback.jpg" width="1500px" height="700px"/>

</body>
</html>