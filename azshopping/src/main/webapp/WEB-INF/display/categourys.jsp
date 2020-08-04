<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="taglib.jsp" %>
<%@ include file="admin-navbar.jsp" %>
<meta charset="ISO-8859-1">
<title>Categorys</title>
</head>
<body>
	<h1>What u wanna buy</h1>
	<br>
	<table border="2">
		<thead>
			<tr>
				<th>ID</th>
				<th>NAME</th>
				<th>AVAILABLE</th>
				<th>OPTIONS</th>
				<th>CHANGE AVAILABILITY</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${lc}" var="lc">
				<tr>

					<td>${lc.categoryid }</td>
					<td>${lc.categoryname}</td>
					<td>${lc.categoryavailable}</td>
					<td><a href="reqdeletcategoury?cid=${lc.categoryid}">DELET</a>/<a
						href="reqeditcategory?cid=${lc.categoryid}">EDIT</a></td>
					<td><a href="reqchangecategoryavailable?cid=${lc.categoryid }">CHANGE
							EXISTENCE</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>

	<h1>Add new Category</h1>
	<form action="reqaddcategoury">
		CATEGOURYNAME<input type="text" name="cn" /> CATEGOURYAVAILABLE<input
			type="text" value="true" readonly /> <input type="submit"
			value="ADD" />
	</form>
	
</body>
</html>