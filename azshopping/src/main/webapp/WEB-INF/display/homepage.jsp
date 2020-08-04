 
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="taglib.jsp"%>
<meta charset="ISO-8859-1">
<title>Welcome</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
<style>
.carousel-inner>.item>img, .carousel-inner>.item>a>img {
	width: 70%;
	margin: auto;
}
</style>
</head>
<body>
	<c:if test="${msg.type =='ERR'}">
		<div class="alert alert-info">
			<strong>Info!</strong> ${msg.messagebody}
		</div>
	</c:if>

	<c:if test="${msg.type=='INFO' }">
		<div class="alert alert-success">
			<strong>Success!</strong> ${msg.messagebody}
		</div>
	</c:if>
	<%@ include file="navbar-guest.jsp"%>
	<div class="col-sm-8">
	<div class="container"
		style="background-color: #190da1; border-radius: 5px; padding-top: 20px; padding-bottom: 20px">
		<br>
		<div id="myCarousel" class="carousel slide" data-ride="carousel">
			<!-- Indicators -->
			<ol class="carousel-indicators">
				<li data-target="#myCarousel" data-slide-to="0" class="active"></li>
				<li data-target="#myCarousel" data-slide-to="1"></li>
				<li data-target="#myCarousel" data-slide-to="2"></li>
				<li data-target="#myCarousel" data-slide-to="3"></li>
				<li data-target="#myCarousel" data-slide-to="4"></li>

			</ol>

			<!-- Wrapper for slides -->
			<div class="carousel-inner" role="listbox">

				<div class="item active">
					<img src="resources/images/shopper/S004.jpg" alt="Chania"
						width="260" height="145">
					<div class="carousel-caption">
						<h3>NIKE</h3>
					</div>
				</div>

				<div class="item">
					<img src="resources/images/shopper/S008.jpg" alt="Chania"
						width="260" height="145">
					<div class="carousel-caption">
						<h3>MYNTRA</h3>
					</div>
				</div>

				<div class="item">
					<img src="resources/images/shopper/S006.jpg" alt="Flower"
						width="260" height="145">
					<div class="carousel-caption">
						<h3>ALEX</h3>
					</div>
				</div>

				<div class="item">
					<img src="resources/images/shopper/S007.jpg" alt="Flower"
						width="260" height="145">
					<div class="carousel-caption">
						<h3>HUAWEI</h3>
					</div>
				</div>
				<div class="item">
					<img src="resources/images/shopper/S002.jpg" alt="Flower"
						width="260" height="145">
					<div class="carousel-caption">
						<h3>SONY</h3>
					</div>
				</div>


			</div>

			<!-- Left and right controls -->
			<a class="left carousel-control" href="#myCarousel" role="button"
				data-slide="prev"> <span
				class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
				<span class="sr-only">Previous</span>
			</a> <a class="right carousel-control" href="#myCarousel" role="button"
				data-slide="next"> <span
				class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
				<span class="sr-only">Next</span>
			</a>
		</div>
	</div>
	</div>
	<div class="col-sm-4">

 <form  action="j_spring_security_check" method="POST">
 	User ID <input type="text"  placeholder="Enter User ID" name="j_username"/>
 	<br>
 	Password <input type="password" placeholder="Enter Password" name="j_password"/>    		
 	<br>
 	<input type="submit" value="Login"/>
 </form>
 
</div>






	<!-- <img src="resources/images/homeback.jpg"/> -->
</body>
</html>