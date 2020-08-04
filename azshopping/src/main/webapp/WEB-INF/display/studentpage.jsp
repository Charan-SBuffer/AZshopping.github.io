
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="taglib.jsp"%>

<meta charset="ISO-8859-1">
<title>Welcome</title>
<body>
	<%@ include file="usernavbar.jsp"%>
	<h1>AZshopping.</h1>
	Welcome User!


	<br>
	<c:if test="${msg.type =='INFO' }">
		<div class="alert alert-success">
			<strong>Success!</strong> ${msg.messagebody}
		</div>
	</c:if>
	<div class="search-container">
		<form action="reqsearch?search="{search}>
			<input type="text" placeholder="Search.." name="search">
			<button type="submit">
				<span class="glyphicon glyphicon-search"></span>
			</button>
		</form>
	</div>
	<div class="conatiner" style="margin-top: 70px">
		<div class="row row-flex col-wrap">
			<c:forEach items="${listofview}" var="v">
				<div class="col-sm-4" style="margin-bottom: 10px;">
					<div class="col-sm-1"></div>
					<div class="col-sm-10" style="border-style: solid">
						<div class="col-sm-8">
							<img src="resources/images/product/${v.productid}.jpg"
								width="80px" />
						</div>
					<%-- 	<c:if test="${v.productrating != 0 }">
							<div class="col-sm-4" style="font-size: 8px;">
								Rating<br> Review
							</div>
						</c:if>
						<c:if test="${v.productrating == 0 }">
							<div class="col-sm-4" style="font-size: 12px;">
								be first to Review The Product
							</div>
						</c:if> --%>
						<div class="col-sm-12">
							PRODUCT:${v.productname} <br>SELLER:${v.shoppername}
						</div>
						<div class="col-sm-8">
							<br>MRP:${v.xpsprice}
						</div>
						<div class="col-sm-4">
							<a href="reqaddtocart?xpsid=${v.xpsid}"><span
								class="glyphicon glyphicon-move"></span></a>
						</div>
					</div>
					<div class="col-sm-1"></div>
				</div>
			</c:forEach>
		</div>
	</div>







	<%-- <%-- <table border="1">
		<thead>
			<tr>
				<th>PRDTNAME</th>
				<th>SHOPPERNAME</th>
				<th>CATEGORYNAME</th>
				<th>XPSPRICE</th>
				<th>XPSSTOCK</th>
				<th>ADD</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${listofview}" var="lv">
				<tr>
					<td><img src="resources/images/product/${lv.productid}.jpg"
						width="100px" /><br>${lv.productname}</td>
					<td><img src="resources/images/shopper/${lv.shopperid}.jpg"
						width="100px" /><br>${lv.shoppername}</td>
					<td>${lv.categoryname}</td>
					<td>${lv.xpsprice}</td>
					<td>${lv.xpsstock}</td>
					<td><a href="reqaddtocart?xpsid=${lv.xpsid}"><span
							class="glyphicon glyphicon-move"></span></a></td>
				</tr>
			</c:forEach> 
			
			
		</tbody>
	</table> --%>
</body>
</html>