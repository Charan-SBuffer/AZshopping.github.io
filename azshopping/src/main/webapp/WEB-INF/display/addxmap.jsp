<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>AZshopping</title>
<%@ taglib uri="http://www.springframework.org/tags/form"
	prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

</head>
<body>

	<h1>Add over here</h1>
	<br>
	<spring:form modelAttribute="xpsobj" action="reqaddxmap">
		SHOPPERID<spring:input path="shopperid" readonly="true" />
		PRODUCTID<spring:select path="productid">
			<c:forEach items="${lxmap }" var="lp">
				<spring:option value="${lp.productid}">"${lp.productid}-${lp.productname}"</spring:option>
			</c:forEach>
		</spring:select>
			XSPRICE<spring:input path="xpsprice" />
			XPSTOCK<spring:input path="xpsstock" />
			XPAVAILABLE<spring:input path="xpsavailable" value="true"
			readonly="true" />
		<spring:button>ADD</spring:button>
	</spring:form>
</body>
</html>