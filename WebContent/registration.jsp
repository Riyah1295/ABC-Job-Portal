<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registration</title>
<link rel="stylesheet" type="text/css" href="Styles/bootstrap.css">
<link rel="stylesheet" type="text/css" href="Styles/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="Styles/styles.css">
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.2/css/all.css">
<script>
	window.history.forward(1)
</script>
</head>
<body>
	<h1>Registration Form</h1>
	<div class="row">
		<div class="col-lg-3"></div>
		<div class="col-lg-6" id="contentRegister">
		
			<form action="register" method="post">
				<div class="form-inline">
					<i class="fas fa-user" style="margin-right: 20px; color: black; font-size: 40px;"></i>
					<s:textfield name="userBean.firstName" placeholder="First Name" cssClass="form-control"  style="width:92%"/>
				</div>
				<br>
				
				<div class="form-inline">
					<i class="fas fa-user" style="margin-right: 20px; color: black; font-size: 40px;"></i>
					<s:textfield name="userBean.lastName" placeholder="Last Name" cssClass="form-control"  style="width:92%"/>
				</div>
				<br>
				
				<div class="form-inline">
					<i class="fas fa-envelope" style="margin-right: 15px; color: black; font-size: 40px;"></i>
					<s:textfield name="userBean.email" placeholder="Email" cssClass="form-control"  style="width:92%"/>
				</div>				
				<br>
				<!-- <s:label style="color: red;" name="msg"/>-->
				<div class="form-inline">
					<i class="fas fa-restroom" style="margin-right: 20px; color: black; font-size: 40px;"></i>
					<s:radio name="userBean.gender" list="{'Male', 'Female'}" cssClass="genderRadio"/>
				</div>
				<br>
				
				<div class="form-inline">
					<i class="far fa-calendar-alt" style="margin-right: 20px; color: black; font-size: 40px;"></i>
					<s:textfield name="userBean.dateOfBirth" placeholder="Date of Birth" cssClass="form-control"  style="width:92%"/>
				</div>
				<br>
				
				<div class="form-inline">
					<i class="fas fa-mobile-alt" style="margin-right: 22px; margin-left: 5px; color: black; font-size: 40px;" title="Phone Number"></i>
					<s:textfield name="userBean.phoneNum" placeholder="Phone Number" cssClass="form-control"  style="width:92%"/>
				</div>
				<br>
				
				<div class="form-inline">
					<i class="fas fa-building" style="margin-right: 20px; color: black; font-size: 40px;"></i>
					<s:textarea name="userBean.addrName" placeholder="Address Name" cssClass="form-control"  style="width:92%"/>
				</div>
				<br>
				
				<div class="form-inline">
					<i class="fas fa-building" style="margin-right: 20px; color: black; font-size: 40px;"></i>
					<s:textfield name="userBean.stName" placeholder="Street Name" cssClass="form-control"  style="width:92%"/>
				</div>
				<br>
				
				<div class="form-inline">
					<i class="fas fa-flag" style="margin-right: 15px; color: black; font-size: 40px;"></i>
					<s:textfield name="userBean.countryName" placeholder="Country Name" cssClass="form-control"  style="width:92%"/>
				</div>
				<br>
				
				<div class="form-inline">
					<i class="fas fa-user" style="margin-right: 20px; color: black; font-size: 40px;"></i>
					<s:textfield name="userBean.username" placeholder="Username" cssClass="form-control"  style="width:92%"/>
				</div>
				<br>
				
				<div class="form-inline">
					<i class="fas fa-eye" style="margin-right: 10px; color: black; font-size: 40px;"></i>
					<s:textfield type="Password" name="userBean.password" placeholder="Password" cssClass="form-control"  style="width:92%"/>
				</div>
				<br>
				
				<div class="form-inline">
					<i class="fas fa-eye" style="margin-right: 10px; color: black; font-size: 40px;"></i>
					<s:textfield type="Password" name="userBean.confirmPass" placeholder="Confirm Password" cssClass="form-control"  style="width:92%"/>
				</div>
				<br>
				<span id="errorMsg"><s:property value="msg" /></span>
				<br>
				<div class="form-inline">
					<div class="col-lg-4">
						<s:submit class="btn btn-success" value="Submit" style="width:100%;"/>
					</div>	
					<div class="col-lg-4">
						<s:a href="login.jsp"><button class="btn btn-warning" type="button" style="width:100%;">Cancel</button></s:a>
					</div>		
					<div class="col-lg-4">
						<s:reset class="btn btn-info" type="button" key="reset" value="Clear" style="width:100%;"/>
					</div>	
				</div>
				
			</form>
		</div>
		<div class="col-lg-3"></div>
	</div>
</body>
</html>