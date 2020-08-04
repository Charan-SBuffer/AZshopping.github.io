<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>AZshopping</title>
</head>
<body>
<h1>Edit Shopper details</h1><br>
<form action="requpdateshopperdetails">
		SHOPPERID<input type="text" value="${shopper.shopperid}" name="sid"
			readonly /> SHOPPERNAME<input type="text"
			value="${shopper.shoppername}" name="sn" /> 
			SHOPPERDESC<input type="text" value="${shopper.shopperdesc}" name="sd"/>SHOPPERAVAILABLE<input
			type="text" value="${shopper.shopperavailable}" name="sa" readonly />
		<input type="submit" value="UPDATE" />
	</form>

</body>
</html>