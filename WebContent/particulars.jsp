<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Particulars</title>
<script>
	window.history.forward(1)
</script>
</head>
<body>
	<s:include value="header.jsp"></s:include>

	    <form action="loadParticulars" method="post">
	    	<br>
	    	<div class="row" style="margin-left:20px; margin-right:20px;">
	    		<div class="col-lg-1"></div>
	    		<div class="col-lg-4">
					<s:textfield label="First Name" name="userBean.firstName" readonly="true" cssClass="form-control"/>
					<br>
					
					<s:textfield label="Last Name" name="userBean.lastName" readonly="true" cssClass="form-control"/>
					<br>
					
					<s:textfield label="Email" name="userBean.email" readonly="true" cssClass="form-control"/>
					<br>
					
					<s:textfield label="Gender" name="userBean.gender" readonly="true" cssClass="form-control"/>
					<br>
					
					<s:textfield label="Date Of Birth" name="userBean.dateOfBirth" readonly="true" cssClass="form-control"/>
					<br>
					
					<s:textfield label="Phone Number" name="userBean.phoneNum" readonly="true" cssClass="form-control"/>
				</div>
				<div class="col-lg-1"></div>
				<div class="col-lg-4">
					<s:textfield label="Address Name" name="userBean.addrName" readonly="true" cssClass="form-control"/>
					<br>
					
					<s:textfield label="Street Name" name="userBean.stName" readonly="true" cssClass="form-control"/>
					<br>
					
					<s:textfield label="Country Name" name="userBean.countryName" readonly="true" cssClass="form-control"/>
					<br>
					
					<s:textfield label="Username" name="userBean.username" readonly="true" cssClass="form-control"/>
					<br>
					
					<s:textfield label="Password" name="userBean.password" readonly="true" cssClass="form-control"/>
					<br>
					
					<s:textfield label="Confirm Password" name="userBean.confirmPass" readonly="true" cssClass="form-control"/>
				</div>
				<div class="col-lg-1">
					<s:submit href='updateParticulars?submitType=edituser&userBean.username=<s:property value="#session.username"/>' class="btn btn-info" style="margin-left:50px; margin-top:530px;" value="Edit"/>
				</div>
				</div>
				
				
				<br>
			</form>
			
	<s:if test="ctr>0">
		<span style="color: green;"><s:property value="msg" /></span>
	</s:if>
	<s:else>
		<span style="color: red;"><s:property value="msg" /></span>
	</s:else>
</body>
</html>