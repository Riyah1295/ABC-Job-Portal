<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Admin</title>
		<script>
			window.history.forward(1)
		</script>
		<link rel="stylesheet" type="text/css" href="Styles/bootstrap.css">
		<link rel="stylesheet" type="text/css" href="Styles/bootstrap.min.css">
		<link rel="stylesheet" type="text/css" href="Styles/styles.css">
		<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.2/css/all.css">
	</head>
	<body>
		<s:include value="headerAdmin.jsp"></s:include>
		
		<a href="sendBulkEmail"><button>Send Bulk Email</button></a>
	
		
		<table class="table table-bordered">
			<thead>
				<tr class="tableHeader">
					<!-- <th style="display: none;">Edu Id</th>-->
					<th>Username</th>
					<th>First Name</th> 
					<th>Last Name</th>
					<th>Email</th>
					<th>Gender</th>
					<th>Date of Birth</th>
					<th>Phone Number</th>
					<th>Address Name</th>
					<th>Street Name</th>
					<th>Country Name</th>
					<th>Action</th>
				</tr>
			</thead>
			
			<s:iterator value="userBeanList">
				<tr>
					<td><s:property value="username" /></td>
					<td><s:property value="firstName" /></td>
					<td><s:property value="lastName" /></td>
					<td><s:property value="email" /></td>
					<td><s:property value="gender" /></td>
					<td><s:property value="dateOfBirth" /></td>
					<td><s:property value="phoneNum" /></td>
					<td><s:property value="addrName" /></td>
					<td><s:property value="stName" /></td>
					<td><s:property value="countryName" /></td>
					<td>
						<a href="deleteUser.action?userBean.username=<s:property value="username"/>"><i class="fas fa-times" style="font-size: 40px;"></i></a>
					</td>
				</tr>
			</s:iterator>
		</table>
	</body>
</html>