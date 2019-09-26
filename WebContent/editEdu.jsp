<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Education</title>
<script>
	window.history.forward(1)
</script>
</head>
<body>
	<s:include value="header.jsp"></s:include>
    
    <div class="row" style="margin-left:20px; margin-right:20px;">
    <div class="col-lg-4"></div>
    <div class="col-lg-4" style="margin-top: 150px;">
    <h3>Edit Education</h3>
    <form action="updateEdu" method="post">
    	
		<s:textfield label="Qualification" name="eduBean.qualification" cssClass="form-control"/>
		<s:textfield label="Institute" name="eduBean.institute" cssClass="form-control"/>
		<s:textfield label="Country of School" name="eduBean.countrySch" cssClass="form-control" cssStyle="width:100%;"/>
		<s:textfield label="Year of Graduate" name="eduBean.yearGrad" cssClass="form-control" cssStyle="width:100%;"/>
		<s:textfield label="Grade" name="eduBean.grade" cssClass="form-control" cssStyle="width:100%;"/>
		
		<input type="hidden" name="eduBean.eduId" value='<s:property value="eduBean.eduId"/>'>
		<input type="hidden" name="eduBean.username" value='<s:property value="#session.username"/>'>

		<s:submit href='education?submitType=editedu&eduBean.username=<s:property value="#session.username"/>' class="btn btn-success" cssStyle="width:100%; margin-top:10px;" name="submitType" type="submit" value="Save"/>
		<a href='education?submitType=editedu&eduBean.username=<s:property value="#session.username"/>' class="btn btn-warning" style="width:100%; margin-top:10px">Cancel</a>
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