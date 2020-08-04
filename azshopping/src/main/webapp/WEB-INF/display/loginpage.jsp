<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="taglib.jsp" %>
<%@ include file="navbar-guest.jsp" %>
<meta charset="ISO-8859-1">
<%@ taglib uri="http://www.springframework.org/tags/form"
	prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
</head>
<title>Welcome</title>
</head>
<body>
	<h1>Login page</h1>

	
	<c:if test="${mssg.type =='ERR'}">
	<div class="alert alert-info">
  <strong>Info!</strong> ${mssg.messagebody}
</div>
	</c:if>
	<c:if test="${mssg.type=='INFO' }">
<div class="alert alert-success">
  <strong>Success!</strong> ${mssg.messagebody}
</div>
</c:if>	
	<br>
	<div class="container" style="margin-top:70px">

 <form  action="j_spring_security_check" method="POST">
 	User ID <input type="text"  placeholder="Enter User ID" name="j_username"/>
 	<br>
 	Password <input type="password" placeholder="Enter Password" name="j_password"/>    		
 	<br>
 	<input type="submit" value="Login"/>
 </form>
 
</div>
	<%-- <spring:form modelAttribute="userdetailsobj" action="reqopensite">
USerID<spring:input path="userid" />
Password<spring:password path="password" />
		<spring:button>SIGNIN</spring:button>
	</spring:form> --%>
	<a href="reqforgottepassword">forgotpassword?</a>
</body>
</html>