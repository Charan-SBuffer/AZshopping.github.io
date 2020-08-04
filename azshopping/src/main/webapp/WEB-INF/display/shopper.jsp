<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="taglib.jsp" %>
<%@ include file="admin-navbar.jsp" %>
<meta charset="ISO-8859-1">
<title>Shopper's LIST</title>
<%@ taglib uri="http://www.springframework.org/tags/form"
	prefix="spring"%>
</head>
<body>
	<h1>HERE are Shopper's details</h1>
	<br>
	<table border=" 2 ">
		<thead>
			<tr>
				<th>ID</th>
				<th>PHOTO</th>
				<th>NAME</th>
				<th>DESCRIPTIOn</th>
				<th>AVILABLE</th>
				<th>OPTIONS</th>
				<th>CHANGE AVAILABILITY</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${lc}" var="lc">
				<tr>

					<td>${lc.shopperid }</td>
					<td><img src="resources/images/product/${lc.shopperid}.jpg"
						width="100px" />
					<td>${lc.shoppername}</td>
					<td>${lc.shopperdesc}</td>
					<td>${lc.shopperavailable}</td>
					<td><a href="reqdeletshopperdetails?sid=${lc.shopperid}">DELET</a>/<a
						href="reqeditshopperdetails?sid=${lc.shopperid}">EDIT</a></td>
						<td><a href="reqchangeshopperexistemse?sid=${lc.shopperid}">CHANGE EXISTENSE</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<h1>Add new Shopper</h1>
	<spring:form modelAttribute="shopperobj" action="reqaddshopper"
		enctype="Multipart/form-data">
	SHOPPERNAME<spring:input type="text" path="shoppername" />
	SHOPPERDESC<spring:input type="text" path="shopperdesc" />
	SHOPPERIMG<spring:input type="file" path="imagefile" />
		<spring:button>ADD</spring:button>
	</spring:form>
	
	</body>
</html>