<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Thank You</title>
<link rel="stylesheet" type="text/css" href="Styles/bootstrap.css">
<link rel="stylesheet" type="text/css" href="Styles/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="Styles/styles.css">
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.2/css/all.css">
<script>
	window.history.forward(1)
</script>
</head>
<body>
    <div class="row">
        <div class="col-lg-4"></div>
        <div class="col-lg-4" id="contentThankPassword" style="margin-top: 150px;">
        <br>
            <p style="color: black; font-size: 30px;">
            	Thank you! You've now a new password. 
				Please login using the same username & the new password.
			</p>
                
            <i class="fas fa-check" style="color: lawngreen; font-size: 70px;"></i>

            <br>

           <a href="login.jsp" class="loginLink">Click here to Login!</a>
            <br><br>
        </div>
        <br>
        <div class="col-lg-4"></div>
    </div>
</body>
</html>