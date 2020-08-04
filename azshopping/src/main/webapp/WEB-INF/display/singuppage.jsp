<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="taglib.jsp"%>
<%@ include file="navbar-guest.jsp"%>
<%@ taglib uri="http://www.springframework.org/tags/form"
	prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
</head>
<meta charset="ISO-8859-1">
<title>AZshopping</title>
</head>
<body>
	<h1>Create ur ID here >)</h1>

	<spring:form modelAttribute="customer" action="reqaddcustomer"
		enctype="Multipart/form-data">

NAME<spring:input path="customername" /><spring:errors path="customername" Style="color:red;font:BOLD"></spring:errors>
		<br>
CHOOSE PORPIC<spring:input type="file" path="imagefile" />
		<br>
EmailID<spring:input path="customeremailid" />
		<br>

MobileNO<spring:input path="customermobileno" /><spring:errors path="customermobileno" style="color:red"></spring:errors>
		<br>

 Password<spring:input path="userDetails.password" /><spring:errors path="userDetails.password" style="color:red"></spring:errors>
		<br>

 HouseNO<spring:input path="shippingAddress.houseno" />
		<br>

 Street<spring:input path="shippingAddress.street" />
		<br>

 Area<spring:input path="shippingAddress.area" />
		<br>

 City<spring:input path="shippingAddress.city" />
		<br>

 State<spring:input path="shippingAddress.state" />
		<br>

 Country<spring:input path="shippingAddress.country" />
		<br>
 
 Pincode<spring:input path="shippingAddress.pincode" /><spring:errors path="shippingAddress.pincode" style="color:red"></spring:errors>
		<br>


		<spring:button>CREATE</spring:button>


	</spring:form>


</body>
</html>