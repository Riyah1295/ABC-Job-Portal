<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Particulars</title>
<link rel="stylesheet" type="text/css" href="Styles/bootstrap.css">
<link rel="stylesheet" type="text/css" href="Styles/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="Styles/styles.css">
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.2/css/all.css">
<script>
	window.history.forward(1)
</script>
</head>
<body>
	<s:include value="header.jsp"></s:include>
	<h3>Edit Particulars</h3>
	
	<form action="updateParticulars" method="post">
	    	<br>
	    	<div class="row" style="margin-left:20px; margin-right:20px;">
	    		<div class="col-lg-1"></div>
	    		<div class="col-lg-4">
					<s:textfield label="First Name" name="userBean.firstName" cssClass="form-control"/>
					<br>
					
					<s:textfield label="Last Name" name="userBean.lastName" cssClass="form-control"/>
					<br>
					
					<s:textfield label="Email" name="userBean.email" cssClass="form-control"/>
					<br>
					
					<s:textfield label="Gender" name="userBean.gender" readonly="true" cssClass="form-control"/>
					<br>
					
					<s:textfield label="Date Of Birth" name="userBean.dateOfBirth" cssClass="form-control"/>
					<br>
					
					<s:textfield label="Phone Number" name="userBean.phoneNum" cssClass="form-control"/>
				</div>
				<div class="col-lg-1"></div>
				<div class="col-lg-4">
					<s:textfield label="Address Name" name="userBean.addrName" cssClass="form-control"/>
					<br>
					
					<s:textfield label="Street Name" name="userBean.stName" cssClass="form-control"/>
					<br>
					
					<s:textfield label="Country Name" name="userBean.countryName" cssClass="form-control"/>
					<br>
					
					<s:textfield label="Username" name="userBean.username" readonly="true" cssClass="form-control"/>
					<br>
					
					<s:textfield label="Password" name="userBean.password" cssClass="form-control"/>
					<br>
					
					<s:textfield label="Confirm Password" name="userBean.confirmPass" cssClass="form-control"/>
					
				</div>
				<div class="col-lg-1 ml-5">
					<s:submit href='particulars?userBean.username=<s:property value="#session.username"/>' class="btn btn-success" style="width:87px; margin-top:460px;" value="Save"/>
					<br>
					<a href='particulars?submitType=edituser&userBean.username=<s:property value="#session.username"/>'><button class="btn btn-warning">Cancel</button></a>
				</div>
				</div>
				
				
				<br>
			</form>
	
    <!-- <div class="row">
		<div class="col-lg-2"></div>
        <div class="col-lg-8" style="border-style: solid; border-color: black;">
    <form action="editParticulars" method="post">
    	<br>
		    	<div class="form-inline">
				<s:textfield label="First Name" name="firstName" cssClass="form-control"/>
				</div>
				<br>
				<div class="form-inline">
				<s:textfield label="Last Name" name="lastName" cssClass="form-control"/>
				</div>
				<br>
				<div class="form-inline">
				<s:textfield label="Email" name="email" cssClass="form-control"/>
				</div>
				<br>
				<div class="form-inline">
				<s:textfield label="Gender" name="gender" cssClass="form-control"/>
				</div>
				<br>
				<div class="form-inline">
				<s:textfield label="Date Of Birth" name="dateOfBirth" cssClass="form-control"/>
				</div>
				<br>
				<div class="form-inline">
				<s:textfield label="Phone Number" name="phoneNum" cssClass="form-control"/>
				</div>
				<br>
				<div class="form-inline">
				<s:textarea label="Address Name" name="addrName" cssClass="form-control"/>
				</div>
				<br>
				<div class="form-inline">
				<s:textfield label="Street Name" name="stName" cssClass="form-control"/>
				</div>
				<br>
				<div class="form-inline">
				<s:textfield label="Country Name" name="countryName" cssClass="form-control"/>
				</div>
				<br>
				<div class="form-inline">
				<s:textfield label="Username" name="username" readonly="true" cssClass="form-control"/>
				</div>
				<br>
				<div class="form-inline">
				<s:textfield label="Password" name="password" cssClass="form-control"/>
				</div>
				<br>
				<div class="form-inline">
				<s:textfield label="Confirm Password" name="confirmPass" cssClass="form-control"/>
				</div>
				<br>
			<div class="form-inline">
				<div class="col-lg-6">
					<s:submit href='particulars?submitType=edituser&username=<s:property value="#session.username"/>' class="btn btn-success" style="width:100%;" value="Save"/>
				</div>	
					<div class="col-lg-6">
					<a href='particulars?submitType=edituser&username=<s:property value="#session.username"/>'><button class="btn btn-warning" style="width:100%;">Cancel</button></a>
				</div>
			</div>
	</form>
	</div>
	</div>
	
 -->
	<s:if test="ctr>0">
		<span style="color: red;"><s:property value="msg" /></span>
	</s:if>
	<s:else>
		<span style="color: green;"><s:property value="msg" /></span>
	</s:else>
	

</body>
</html>