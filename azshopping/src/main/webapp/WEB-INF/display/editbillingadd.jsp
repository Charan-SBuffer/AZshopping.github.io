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
	<h1 style="color: green; font: timesnewroman">EDIT BillingAdd</h1>

	<spring:form modelAttribute="billingaddobj"
		action="requpdatebillingadd">
BillingID  <spring:hidden path="billingaddressid" />
House no<spring:input path="houseno" />
Street<spring:input path="street" />
Area<spring:input path="area" />
City<spring:input path="city" />
State<spring:input path="state" />
Country<spring:input path="country" />
PIN no<spring:input path="pincode" />
		<spring:button>UPDATE</spring:button>
	</spring:form>

</body>
</html>