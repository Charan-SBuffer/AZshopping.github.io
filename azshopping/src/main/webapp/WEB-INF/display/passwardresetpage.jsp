<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="taglib.jsp" %>
<%@ include file="navbar-guest.jsp" %>
<meta charset="ISO-8859-1">
<title>AZshopping</title>
</head>
<body>
<c:if test="${msg.type =='ERR'}">
		<div class="alert alert-info">
			<strong>OOPS!</strong> ${msg.messagebody}
		</div>
	</c:if>
<form action="reqchangepassword">
USERID<input type="text" name="UI">

<input type="submit" value="SEARCH">



</form>
</body>
</html>