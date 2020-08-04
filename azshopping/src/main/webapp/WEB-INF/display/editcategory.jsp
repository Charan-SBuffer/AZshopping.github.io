<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="admin-navbar.jsp" %>
<%@ include file="taglib.jsp" %>
<meta charset="ISO-8859-1">
<title>azshopping</title>
</head>
<body>
	<h1>EDIT FORM</h1>
	<form action="requpdatecategoury?">
		CATEGORYID<input type="text" value="${category.categoryid}" name="cid"
			readonly /> CATEGORYNAME<input type="text"
			value="${category.categoryname}" name="cn" /> CATEGORYAVAILABLE<input
			type="text" value="${category.categouryavailable}" name="ca" readonly />
		<input type="submit" value="UPDATE" />
	</form>
</body>
</html>