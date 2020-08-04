 <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="taglib.jsp"%>
<%@ include file="usernavbar.jsp"%>
<meta charset="ISO-8859-1">
<title>AZshopping:(</title>
</head>
<body>
	<h2 style="colour: red; font: BOLD">EDIT PROFILE INFO</h2>
	<br>
	<div class="col-sm-3"></div>
	<div class="col-sm-6"
		style="background-color: #a2dcde; border-radius: 10px; padding-top: 20px; padding-bottom: 20px">
		<spring:form modelAttribute="customer" action="requpdatecustomerinfo">
			<spring:hidden path="customerid" />
CustomerName<spring:input path="customername" />
			<br>
CustomerEmail <spring:input path="customeremailid" />
			<br>
CustomerMobileNo<spring:input path="customermobileno" />
			<br>
			<spring:button>UPDATE</spring:button>
		</spring:form>
	</div>
	<div class="col-sm-3"></div>
</body>
</html>