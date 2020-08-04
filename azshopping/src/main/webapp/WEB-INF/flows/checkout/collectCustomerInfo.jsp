<html>
<head>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
 <%@ include file="/WEB-INF/display/taglib.jsp" %> 
<%@ page isELIgnored="false" %>

</head>
<body>

<%@ include file="/WEB-INF/display/usernavbar.jsp"%>
<div class="container-wrapper" style="margin-top:50px; margin-bottom:50px;">
    <div class="container" style="background-color:#c7fccd">
        <div class="page-header">
            <h1>Customer</h1>


            <p class="lead">Customer Details:</p>
        </div>

        <form:form commandName="order" class="form-horizontal">

        <h3>Basic Info:</h3>

        <div class="form-group">
            <label for="name">Name</label>
            <form:input path="cart.customer.customername" id="name" class="form-Control" />
        </div>

        <div class="form-group">
            <label for="email">Email</label>
            <form:input path="cart.customer.customeremailid" id="email" class="form-Control" />
        </div>

        <div class="form-group">
            <label for="phone">Phone</label>
            <form:input path="cart.customer.customermobileno" id="phone" class="form-Control" />
        </div>

        <br/>

        <h3>Billing Address:</h3>

        <div class="form-group">
            <label for="billingStreet">Street Name</label>
            <form:input path="cart.customer.billingAddress.street" class="form-Control" />
        </div>       

        <div class="form-group">
            <label for="billingCity">City</label>
            <form:input path="cart.customer.billingAddress.city" class="form-Control" />
        </div>

        <div class="form-group">
            <label for="billingState">State</label>
            <form:input path="cart.customer.billingAddress.state" class="form-Control" />
        </div>

        <div class="form-group">
            <label for="billingCountry">Country</label>
            <form:input path="cart.customer.billingAddress.country" id="billingCountry" class="form-Control" />
        </div>

        <div class="form-group">
            <label for="billingZip">Zipcode</label>
            <form:input path="cart.customer.billingAddress.pincode" class="form-Control" />
        </div>

        <input type="hidden" name="_flowExecutionKey" />

        <br/><br/>
        <!--  on attribute - assign event id -->
        <!--  to attribute id value in state -->

        <input type="submit" value="Next" class="btn btn-default" name="_eventId_customerInfoCollected" />

        <button class="btn btn-default" name="_eventId_cancel">Cancel</button>


	
        </form:form>
        </div>
        </div>
    
</body>
</html>