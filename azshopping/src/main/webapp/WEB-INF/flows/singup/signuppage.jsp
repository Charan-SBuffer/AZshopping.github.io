<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="taglib.jsp"%>
<%@ include file="navbar-guest.jsp"%>
<%@ taglib uri="http://www.springframework.org/tags/form"
	prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
</head>
<meta charset="ISO-8859-1">
<title>AZshopping</title>
</head>
<body>
	<h1>Create ur ID here >)</h1>
<div class="container-wrapper" style="margin-top:50px; margin-bottom:50px;">
    <div class="container" style="background-color:#c7fccd">
        <div class="page-header">
            <h1>Customer</h1>


            <p class="lead">Customer Details:</p>
        </div>

        <spring:form modelAttribute="customer" class="form-horizontal">

        <h3>Basic Info:</h3>

        <div class="form-group">
            <label for="name">Name</label>
            <spring:input path="customername" id="name" class="form-Control" />
        </div>

        <div class="form-group">
            <label for="email">Email</label>
            <spring:input path="customeremailid" id="email" class="form-Control" />
        </div>

        <div class="form-group">
            <label for="phone">Phone</label>
            <spring:input path="customermobileno" id="phone" class="form-Control" />
        </div>

        <br/>
         

        <div class="form-group">
            <label for="password">PASSword</label>
            <spring:input path="userdetails.password" id="password" class="form-Control" />
        </div>

        
<br>
        <h3>Billing Address:</h3>

        <div class="form-group">
            <label for="billingStreet">Street Name</label>
            <spring:input path="billingAddress.street" class="form-Control" />
        </div>       

        <div class="form-group">
            <label for="billingCity">City</label>
            <spring:input path="billingAddress.city" class="form-Control" />
        </div>

        <div class="form-group">
            <label for="billingState">State</label>
            <spring:input path="billingAddress.state" class="form-Control" />
        </div>

        <div class="form-group">
            <label for="billingCountry">Country</label>
            <spring:input path="billingAddress.country" id="billingCountry" class="form-Control" />
        </div>

        <div class="form-group">
            <label for="billingZip">Zipcode</label>
            <spring:input path="billingAddress.pincode" class="form-Control" />
        </div>

        <input type="hidden" name="_flowExecutionKey" />

        <br/><br/>
        <!--  on attribute - assign event id -->
        <!--  to attribute id value in state -->

        <input type="submit" value="Next" class="btn btn-default" name="_eventId_customerInfoCollected" />

        <button class="btn btn-default" name="_eventId_cancel">Cancel</button>


	
        </spring:form>
        </div>
        </div>
</body>
</html>