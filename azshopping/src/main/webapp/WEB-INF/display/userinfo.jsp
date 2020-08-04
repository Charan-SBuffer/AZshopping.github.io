<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="taglib.jsp"%>
<meta charset="ISO-8859-1">
<title>AZshopping:)</title>
</head>

<body>
	<%@ include file="admin-navbar.jsp"%>

	<h1 style="">List of UserDetails</h1>
	<br>
	<br>
	<br>
	<br>

	<table border="2">
		<thead>
			<tr>
				<th>USERID</th>
				<th>AVAILABILITY</th>
				<th>OPTIONS</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${listofUD}" var="ud">
				<tr>
					<td>${ud.userid}</td>
					<td>${ud.enabled}</td>
					<td><a href="reqchngavilability?USERID=${ud.userid}">CHANGE EXISTENSE</a></td>
				</tr>
			</c:forEach>

		</tbody>
	</table>



</body>
</html>