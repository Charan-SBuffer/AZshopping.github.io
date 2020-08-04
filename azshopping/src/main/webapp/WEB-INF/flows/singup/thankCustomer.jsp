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
        <section>
            <div class="jumbotron">
                <div class="container">
                    <h1>Thank you for placing order AZshopping.com</h1>
                    <br>
					<h2>Your order details have been mailed to your registered email id.</h2>
                    <p>Your order will be shipped in next few Working days.</p>
                </div>
            </div>
        </section>

        <section class="container">
            <p><a href="reqopenstudentpage?Orderconfermed" class="btn btn-default">OK</a></p>
        </section>
</div>
</div>

</body>
</html>
