<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Forget Password</title>
<link rel="stylesheet" type="text/css" href="Styles/bootstrap.css">
<link rel="stylesheet" type="text/css" href="Styles/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="Styles/styles.css">
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.2/css/all.css">
<script>
	window.history.forward(1)
</script>
</head>
<body>

	<h1>Forget Password</h1>
	<br>
	<div class="row">
	<div class="col-lg-3"></div>
		<div class="col-lg-6">
			<form action="forgetPassword" method="post">
				<br>
				<s:textfield label="Email" name="userBean.email" placeholder="Email" cssClass="form-control"/>
				<s:label style="color: red;" name="msg"/>
	
				<div class="form-inline">
					<div class="col-lg-4">
						<s:submit class="btn btn-success" value="Submit" style="width:100%;"/>
					</div>	
					<div class="col-lg-4">
						<s:reset class="btn btn-info" type="button" key="reset" value="Clear" style="width:100%;"/>
					</div>	
					<div class="col-lg-4">
						<s:a href="login.jsp"><button class="btn btn-warning" type="button" style="width:100%;">Cancel</button></s:a>
					</div>	
				</div>
				<br>
			</form>
		</div>
	</div>
</body>
</html>