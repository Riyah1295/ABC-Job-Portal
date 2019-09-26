<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1"  name="viewport" content="width=device-width, initial-scale=1">
<title>ABC Community Portal</title>
<link rel="stylesheet" type="text/css" href="Styles/bootstrap.css">
<link rel="stylesheet" type="text/css" href="Styles/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="Styles/styles.css">
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.2/css/all.css">
<script>
	window.history.forward(1)
</script>
</head>
<body>

	<div class="container col-lg-2 col-lg-8 col-lg-2">
    	<img src="image/logo.png" alt="ABC Community Portal Logo" title="ABC Community Portal Logo">
	</div>
	<h1>Login</h1>
	<div class="row">
		<div class="col-lg-3"></div>
		<div class="col-lg-6" id="contentLogin">
			<form action="login" method="post">
				<div class="form-inline">
					<i class="fas fa-user" style="margin-right: 20px; color: black; font-size: 40px;" data-toggle="tooltip" title="Tooltip on top"></i>
					<s:textfield name="userBean.username" placeholder="Username" cssClass="form-control"  style="width:92%"/>
					<!-- <button type="button" class="btn btn-secondary" data-toggle="tooltip" data-placement="top" title="Tooltip on top"> Tooltip on top</button> -->
				</div>
				
				<br>
				<div class="form-inline">
					<i class="fas fa-eye" style="margin-right: 10px; color: black; font-size: 40px;"></i>
					<s:password name="userBean.password" placeholder="Password" cssClass="form-control" style="width:92%"/>
					<input type="hidden" name="username" value='<s:property value="username"/>'>
				</div>
				<br><br>
				<h4>Alternative login using social media:</h4>
				<br>
				<img src="https://img.icons8.com/color/48/000000/google-logo.png" style="width: 45px; margin: 0px 10px 20px 0px;">
			                
			    <img src="https://img.icons8.com/color/48/000000/facebook.png" style="width: 45px; margin: 0px 10px 20px 0px;">
			                
			    <img src="https://img.icons8.com/office/48/000000/instagram-new.png" style="width: 40px; margin: 0px 10px 20px 0px;">
			                
			    <img src="https://img.icons8.com/color/48/000000/twitter.png" style="width: 45px; margin: 0px 10px 20px 0px;">
			    <br>
				<span><s:property value="msg" /></span>
				
				<s:submit class="btn btn-success" value="Login" style="width:100%;"/>
				<br>
				<s:a href="registration.jsp"><button class="btn btn-warning" type="button" style="width:100%;">Sign Up!</button></s:a>
				<br><br>
				<a href="forgetPassword.jsp" class="forgetLink">Forget Password?</a>
			</form>
	    </div>
	    <div class="col-lg-3"></div>
    </div>
</body>
</html>
