<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="taglib.jsp" %>
<%@ include file="admin-navbar.jsp" %>
<meta charset="ISO-8859-1">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form"
	prefix="spring"%>

<title>AZshopping</title>

</head>
<body>
	<h1>Here are product details.</h1>
	<table border="1">
		<thead>
			<tr>
				<th>PRODUCTID</th>
				<th>PRODCTIMG</th>
				<th>PRODUCTNAME</th>
				<th>PRODUCTDESC</th>
				<th>CATEGORYID</th>
				<th>PRODUCTAVAILABLE</th>
				<th>OPTIONS</th>
				<th>CHANGE AVIALABILITY</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${pl}" var="p">
				<tr>
					<td>${p.productid}</td>
					<td><img src="resources/images/product/${p.productid}.jpg"
						width="100px" /></td>
					<td>${p.productname}</td>
					<td>${p.productdesc}</td>
					<td>${p.categoryid}</td>
					<td>${p.productavailable}</td>
					<td><a href="reqdeletproduct?pid=${p.productid}">DELET</a>/<a
						href="reqeditproduct?pid=${p.productid}">EDIT</a></td>
					<td><a href="reqchangeproductavailability?pid=${p.productid}">CHANGE
							EXISTENSE</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>

	<h2>ADD ur product below</h2>
	<br>
	<spring:form modelAttribute="productobj" action="reqaddproduct"
		enctype="Multipart/form-data">
	
PRODUCTNAME<spring:input path="productname" />
PRODUCTDESC<spring:input path="productdesc" />
CATEGORYID<spring:input path="categoryid" />
		<spring:input type="file" path="imagefile" />

		<spring:button>ADD</spring:button>
	</spring:form>
	
	
</body>
</html>