<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="taglib.jsp" %>
<meta charset="ISO-8859-1">
<title>AZshopping</title>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form"
	prefix="spring"%>
</head>
<body>
<%@ include file="admin-navbar.jsp" %>
	<h1>List of XMAP</h1>
	<br>
	<table border="2">
		<thead>
			<tr>
				<th>XMAPID</th>
				<th>PRDTID</th>
				<th>SHPID</th>
				<th>XPRICE</th>
				<th>XSTOCK</th>
				<th>AVILABLE</th>
				<th>CHANGE AVAILABILITY</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${lxmap}" var="lx">
				<tr>
					<td>${lx.xpsid}</td>
					<td>${lx.productid}</td>
					<td>${lx.shopperid}</td>
					<td>${lx.xpsprice}</td>
					<td>${lx.xpsstock}</td>
					<td>${lx.xpsavailable}</td>
					<td><a href="reqchangexmapexistens?xpsid=${lx.xpsid}">CHANGE EXISTENCE</a>
				</tr> 
			</c:forEach>
		</tbody>
	</table>
	<br>

	<form action="reqgetXmap">
		Select shopperID<select name="sid">
			<c:forEach items="${lshp}" var="l">
				<option value="${l.shopperid}">"${l.shopperid}-${l.shoppername}"</option>
			</c:forEach>
</select>
			<input type="submit" value="Get" />
	</form>


</body>
</html>