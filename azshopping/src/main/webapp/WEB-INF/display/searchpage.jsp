<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="taglib.jsp" %>
<%@ include file="usernavbar.jsp" %>
<meta charset="ISO-8859-1">
<title>Search results</title>
</head>
<body>
<c:if test="${msg.type =='ERR' }">
		<div class="alert alert-success">
			<strong>Sorry!</strong> ${msg.messagebody}
		</div>
	</c:if>
<p style={color:red;font:italian}>SEARCH RESULTS..</p>

</body>
</html>