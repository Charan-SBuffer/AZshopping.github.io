<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="usernavbar.jsp" %>
<%@ include file="taglib.jsp" %>
<meta charset="ISO-8859-1">
<title>AZshopping</title>
</head>
<body>
<div class="conatiner" style="margin-top: 50px">
		<div class="row row-flex col-wrap">
			<c:forEach items="${lod}" var="v">
				<div class="col-sm-4" style="margin-bottom: 10px;">
					<div class="col-sm-1"></div>
					<div class="col-sm-10" style="border-style: solid">
						<div class="col-sm-8">
							<img src="resources/images/product/${v.productid}.jpg"
								width="80px" />
						</div>
						<div class="col-sm-4" style="font-size: 8px;">
							<a href="reqorderdetails?orderid=${v.suppliername}">DETAILS</a>
						</div>
						<div class="col-sm-12">
							${v.productprice} <br>${v.isratinggiven}
						</div>
						<div class="col-sm-8">
							<br>${v.quantity}</div>
						<div class="col-sm-4">
							<br>${v.rating}"</br>
								
						</div>
					</div>
					<div class="col-sm-1"></div>
				</div>
			</c:forEach>
			</div>
		</div><br>
</body>
</html>