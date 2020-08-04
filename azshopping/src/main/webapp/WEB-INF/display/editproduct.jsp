<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="admin-navbar.jsp" %>
<%@ include file="taglib.jsp" %>
<meta charset="ISO-8859-1">
<title>AZshopping</title>
<%@ taglib uri="http://www.springframework.org/tags/form"
	prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
</head>
<body>
	<h2>UPDATE ur product DETAILS</h2>
	<br>
	<spring:form modelAttribute="pv" action="requpdateproduct">
	PRODUCTID<spring:input path="productid" value="${pv.productid}"
			readonly="true" />
PRODUCTNAME<spring:input path="productname" value="${pv.productname}" />
PRODUCTDESC<spring:input path="productdesc" value="${pv.productdesc}" />
CATEGORYID<spring:select path="categoryid">
			<spring:option value="Selectone" />
			<c:forEach items="${lc }" var="c">
				<spring:option value="${c.categoryid}">${c.categoryid}-${c.categoryname}</spring:option>
			</c:forEach>
		</spring:select>
PRODUCTAVAILABLE<spring:input path="productavailable"
			value="${pv.productavailable}" readonly="true" />

		<spring:button>ADD</spring:button>
	</spring:form>


</body>
</html>