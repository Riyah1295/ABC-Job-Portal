<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Post</title>
<script>
	window.history.forward(1)
</script>
</head>
<body>
	<s:include value="header.jsp"></s:include>
	<div class="row" style="margin-left:20px; margin-right:20px;">
    <div class="col-lg-4"></div>
    <div class="col-lg-4" style="margin-top: 150px;">
	<h3>Edit Post</h3>
    
    <form action="updatePost" method="post">
    	
		<s:textfield label="Job Title" name="jobBean.jobTitle" cssClass="form-control"/>
		<s:textfield label="Job Description" name="jobBean.jobDesc" cssClass="form-control"/>
		<s:textfield label="Country of Job" name="jobBean.countryJob" cssClass="form-control"/>	
		<s:textfield label="Closing Date" name="jobBean.closeDate" cssClass="form-control"/>

		<input type="hidden" name="jobBean.jobCode" value='<s:property value="jobBean.jobCode"/>'>
		<input type="hidden" name="jobBean.username" value='<s:property value="#session.username"/>'>
		<input type="hidden" name="userBean.username" value='<s:property value="#session.username"/>'>
		
		<s:submit href='profile?submitType=editpost&userBean.username=<s:property value="#session.username"/>' class="btn btn-success" cssStyle="width:100%; margin-top:10px;" name="submitType" type="submit" value="Save"/>
		<a href='profile?submitType=editpost&userBean.username=<s:property value="#session.username"/>' class="btn btn-warning" style="width:100%; margin-top:10px">Cancel</a>
		
	</form>
	</div>
	<div class="col-lg-4"></div>
	</div>
	
	<s:else>
		<span style="color: red;"><s:property value="msg" /></span>
	</s:else>

</body>
</html>