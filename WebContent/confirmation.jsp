<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Confirmation Page</title>
<link rel="stylesheet" type="text/css" href="Styles/bootstrap.css">
<link rel="stylesheet" type="text/css" href="Styles/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="Styles/styles.css">
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.2/css/all.css">
<script>
	window.history.forward(1)
</script>
</head>
<body>
	<h1>Confirmation Form</h1>
	
	<div class="row">
		<div class="col-lg-3"></div>
		<div class="col-lg-6" id="contentRegister">
			<form action="confirmUser">
				<div class="form-inline">
					<i class="fas fa-user" style="margin-right: 20px; color: black; font-size: 40px;"></i>
					<s:textfield name="userBean.firstName" cssClass="form-control" readonly="true"  style="width:92%"/>
				</div>
				<br>
				
				<div class="form-inline">
					<i class="fas fa-user" style="margin-right: 20px; color: black; font-size: 40px;"></i>
					<s:textfield name="userBean.lastName" cssClass="form-control" readonly="true"  style="width:92%"/>
				</div>
				<br>
				
				<div class="form-inline">
					<i class="fas fa-envelope" style="margin-right: 15px; color: black; font-size: 40px;"></i>
					<s:textfield name="userBean.email" cssClass="form-control" readonly="true"  style="width:92%"/>
				</div>				
				<br>
				<!-- <s:label style="color: red;" name="msg"/>-->
				<div class="form-inline">
					<i class="fas fa-restroom" style="margin-right: 10px; color: black; font-size: 35px;"></i>
					<s:textfield name="userBean.gender" cssClass="form-control"  readonly="true"  style="width:92%"/>
				</div>
				<br>
				
				<div class="form-inline">
					<i class="far fa-calendar-alt" style="margin-right: 20px; color: black; font-size: 40px;"></i>
					<s:textfield name="userBean.dateOfBirth" cssClass="form-control" readonly="true"  style="width:92%"/>
				</div>
				<br>
				
				<div class="form-inline">
					<i class="fas fa-mobile-alt" style="margin-right: 22px; margin-left: 5px; color: black; font-size: 40px;" title="Phone Number"></i>
					<s:textfield name="userBean.phoneNum" cssClass="form-control" readonly="true"  style="width:92%"/>
				</div>
				<br>
				
				<div class="form-inline">
					<i class="fas fa-building" style="margin-right: 20px; color: black; font-size: 40px;"></i>
					<s:textarea name="userBean.addrName" cssClass="form-control" readonly="true"  style="width:92%"/>
				</div>
				<br>
				
				<div class="form-inline">
					<i class="fas fa-building" style="margin-right: 20px; color: black; font-size: 40px;"></i>
					<s:textfield name="userBean.stName" cssClass="form-control" readonly="true"  style="width:92%"/>
				</div>
				<br>
				
				<div class="form-inline">
					<i class="fas fa-flag" style="margin-right: 15px; color: black; font-size: 40px;"></i>
					<s:textfield name="userBean.countryName" cssClass="form-control" readonly="true"  style="width:92%"/>
				</div>
				<br>
				
				<div class="form-inline">
					<i class="fas fa-user" style="margin-right: 20px; color: black; font-size: 40px;"></i>
					<s:textfield name="userBean.username" cssClass="form-control" readonly="true"  style="width:92%"/>
				</div>
				<br>
				
				<div class="form-inline">
					<i class="fas fa-eye" style="margin-right: 10px; color: black; font-size: 40px;"></i>
					<s:textfield type="Password" name="userBean.password" cssClass="form-control" readonly="true"  style="width:92%"/>
				</div>
				<br>
				
				<div class="form-inline">
					<i class="fas fa-eye" style="margin-right: 10px; color: black; font-size: 40px;"></i>
					<s:textfield type="Password" name="userBean.confirmPass" cssClass="form-control" readonly="true"  style="width:92%"/>
				</div>
				<br>
				<span id="errorMsg"><s:property value="msg" /></span>
				<br>
				<div class="form-inline">
					<div class="col-lg-6">
						<s:submit class="btn btn-success" value="Submit" style="width:100%;"/>
					</div>	
					<div class="col-lg-6">
						<button class="btn btn-warning" type="button" onclick="goBack()" style="width:100%;">Back</button>
					</div>		
				</div>
				
			</form>
		</div>
		<div class="col-lg-3"></div>
	</div>

<script>
function goBack() {
  window.history.back();
}
</script>
</body>
</html>