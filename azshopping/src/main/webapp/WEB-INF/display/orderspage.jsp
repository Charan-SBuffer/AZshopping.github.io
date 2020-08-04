<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="usernavbar.jsp"%>
<%@ include file="taglib.jsp"%>
<meta charset="ISO-8859-1">
<title>Azshopping</title>
</head>
<body>
	<div class="container" style="margin-top: 70px">

		<div>My Orders</div>

		<c:forEach items="${lo}" var="ord">
			<br>
			<button type="button" class="btn btn-info" data-toggle="collapse"
				data-target="#${ord.orderid}">${ord.orderid}</button>
			<div id="${ord.orderid}" class="collapse">
				${ord.orderdate}
				<div class="col-sm-4" style="margin-bottom: 10px;">

					<c:forEach items="${ord.orderdetails}" var="odet">
												<div class="col-sm-4" style="margin-bottom: 10px;"></div>
					
						<br>
			${odet.productname}
							<div class="col-sm-4" style="margin-bottom: 10px;"></div>

						<img src="resources/images/product" + ${odet.productid} + ".jpg"/>
						<div class="col-sm-4" style="margin-bottom: 10px;"></div>
					</c:forEach>
				</div>
		</c:forEach>



		<br>
	</div>
</body>
</html>