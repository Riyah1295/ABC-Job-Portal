<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Experience</title>
<script>
	window.history.forward(1)
</script>
</head>
<body>
	<s:include value="header.jsp"></s:include>
	
	<div class="row" style="margin-left:20px; margin-right:20px;">
    <div class="col-lg-4"></div>
    <div class="col-lg-4" style="margin-top: 100px;">
    <h3>Edit Experience</h3>
    <form action="updateExp" method="post">
    	
    	
		<s:textfield label="Company Name" name="expBean.compName" cssClass="form-control"/>
		<s:textfield label="Company Address" name="expBean.compAddr" cssClass="form-control"/>
		<s:textfield label="Country of Company" name="expBean.countryComp" cssClass="form-control"/>
		<s:textfield label="Years of Experience" name="expBean.yearsExp" cssClass="form-control"/>
		<s:textfield label="Job Role" name="expBean.jobRole" cssClass="form-control"/>
		
		<input type="hidden" name="expBean.expId" value='<s:property value="expBean.expId"/>'>
		<input type="hidden" name="expBean.username" value='<s:property value="#session.username"/>'>
		
		<s:submit href='experience?submitType=editexp&expBean.username=<s:property value="#session.username"/>' class="btn btn-success" cssStyle="width:100%; margin-top:10px;" name="submitType" type="submit" value="Save"/>
		<a href='experience?submitType=editexp&expBean.username=<s:property value="#session.username"/>' class="btn btn-warning" style="width:100%; margin-top:10px">Cancel</a>		
	</form>
	</div>
	<div class="col-lg-4"></div>
	</div>
	
	<s:if test="ctr>0 || i>0">
		<span style="color: green;"><s:property value="msg" /></span>
	</s:if>
	<s:else>
		<span style="color: red;"><s:property value="msg" /></span>
	</s:else>

</body>
</html>