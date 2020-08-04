<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="taglib.jsp" %>
<meta charset="ISO-8859-1">
<title>AZshopping</title>
</head>
<body>
	<%@ include file="usernavbar.jsp"%>
	<h1 style="color:red;font:Monospace">Edit password </h1>
	<c:if test="${msg.type=='ERR'}">
	<div class="alert alert-info">
  <strong>OOPS!</strong> ${msg.messagebody}
</div>
	</c:if>
	<form action="requpdatepassword" method="post">
		OLD password<input type=password name=oldpswrd><br>
		 NEW
		password<input type=password name=newpswrd><br>
		 CONFORM
		password<input type=password name=confnewpswrd><br> 
		<input
			type="submit" value="UPdate">

	</form>

</body>
</html>