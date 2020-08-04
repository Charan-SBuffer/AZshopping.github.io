<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="taglib.jsp" %>
<%@ include file="usernavbar.jsp" %>
<meta charset="ISO-8859-1">
<title>Cart Details</title>
</head>
<body>
<div class="container" style="margin-top:50px">
	<h1>AZshopping^)</h1>
	This are ur cart details.
	<br>
	GrandTOTAL:${msg} <br>
	<table class="table table-striped  table-hover"  id="tablesortsearch">
	<thead style="background-color:#9ffcb8; font-size:20px;color:blue">
			<tr>
				<th>SHOPPERNAME</th>
				<th>PRODUCTNAME</th>
				<th>PRODUCTPRICE</th>
				<th>QUANTITY</th>
				<th>OPT</th>
			</tr>
		</thead>
		<tbody style="color:black;font-size:20px;">
			<c:forEach items="${listoffulldetails}" var="co">
				<tr>
					<td><img src="resources/images/product" +${co.productid}+".jpg"/>/${co.shoppername}</td>
					<td>${co.productname}</td>
					<c:if test="${co.enabled==true }">
					<td>${co.xpsprice}</td>
					<td>${co.quantity}</td>
					<td><a href="reqdeletfromcartitems?citemid=${co.cartitemid}">DELETE</a></br>
					<a href="reqincreaseqnt?xpsid=${co.cartitemid}"><span
							class="glyphicon glyphicon-arrow-up"></span></a> / <a
						href="reqdicreaseqnt?citemid=${co.cartitemid}"><span
							class="glyphicon glyphicon-arrow-down"></span></a></td>
							</c:if>
							<c:if test="${co.enabled==false }">
							<td>Item not available</td>
							<td></td>
							<td></td>
							</c:if>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	</div>
	<a href="reqCheckout?cartid=${cartid} " class="btn btn-info btn-lg">
          <span class="glyphicon glyphicon-shopping-cart"></span> CHECKOUT
        </a>
</body>
</html>