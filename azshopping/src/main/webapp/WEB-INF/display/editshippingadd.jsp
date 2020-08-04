<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="taglib.jsp"%>
<%@ include file="usernavbar.jsp" %>
<meta charset="ISO-8859-1">
<title>AZshopping..:(</title>
</head>
<body>
	<p1 style="color:green;font:Bookman ">Edit ShippingADD</p1>

	<spring:form modelAttribute="shippinaddobj" action="requpdateshippingadd">
	ShippingID<spring:hidden path="shippingaddressid"/>
	
 HouseNO<spring:input path="houseno" />
		<br>
 Street<spring:input path="street" />
		<br>

 Area<spring:input path="area" />
		<br>

 City<spring:input path="city" />
		<br>

 State<spring:input path="state" />
		<br>

 Country<spring:input path="country" />
		<br>
 
 Pincode<spring:input path="pincode" />
		<br>


		<spring:button>CREATE</spring:button>


	</spring:form>



</body>
</html>