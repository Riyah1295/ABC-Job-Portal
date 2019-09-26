<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1" name="viewport" content="width=device-width, initial-scale=1">
<title>Profile</title>
<link rel="stylesheet" type="text/css" href="Styles/bootstrap.css">
<link rel="stylesheet" type="text/css" href="Styles/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="Styles/styles.css">
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.2/css/all.css">
<script>
	window.history.forward(1)
</script>
</head>
<body>
	<div class="headerBtn">
		<a href='search.jsp' class="btn btn-dark" id="profileBtn">Search</a>
		<a href='profile?userBean.username=<s:property value="#session.username"/>' class="btn btn-dark" id="profileBtn">Profile</a>
		<a href='particulars?userBean.username=<s:property value="#session.username"/>' class="btn btn-dark" id="particularsBtn">Particulars</a>
		<a href='education?eduBean.username=<s:property value="#session.username"/>' class="btn btn-dark" id="eduBtn">Education</a>
		<a href='experience?expBean.username=<s:property value="#session.username"/>' class="btn btn-dark" id="expBtn">Experience</a>
		<a href="login.jsp" class="btn btn-dark" id="logoutBtn">Logout</a>
	</div>
</body>
</html>