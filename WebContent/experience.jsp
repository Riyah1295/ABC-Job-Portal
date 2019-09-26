<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Experience</title>
<script>
	window.history.forward(1)
</script>
</head>
<body>    
    
    <s:include value="header.jsp"></s:include>

    <div class="row" id="expRow">
    
	    <div class="addExpCont col-lg-3" style="margin-top: 100px;">
		    <h4 class="titleAddExp"  style="margin-left: 35px;">Add New Experience</h4>
		    
		    <s:form action="addExp" method="post">
		    	
				<s:textfield name="expBean.compName" placeholder="Company Name" cssClass="form-control" cssStyle="width:100%;"/>
				<s:textfield name="expBean.compAddr" placeholder="Company Address" cssClass="form-control"/>
				<s:textfield name="expBean.countryComp" placeholder="Country of Company" cssClass="form-control"/>
				<s:textfield name="expBean.yearsExp" placeholder="Years of Experience" cssClass="form-control"/>
				<s:textfield name="expBean.jobRole" placeholder="Job Role" cssClass="form-control"/>
				<input type="hidden" name="expBean.username" value='<s:property value="expBean.username"/>'>
		
				<s:submit href='experience?expBean.username=<s:property value="#session.username"/>' class="btn btn-success" style="width:100%; margin-top:10px;" name="submitType" type="submit" value="Add"/>
				<s:reset class="btn btn-info" type="button" key="reset" value="Clear" style="width:100%;  margin-bottom:10px;"/>
			</s:form>
		</div>
    
	<div class="expCont col-lg-9 pre-scrollable">
	<s:if test="noData==true">
		<table class="table table-bordered">
			<thead>
				<tr class="tableHeader">
					<th>Company Name</th>
					<th>Company Address</th>
					<th>Country of Company</th>
					<th>Years of Experience</th>
					<th>Job Role</th>
					<th>Action</th>
				</tr>
			</thead>
			
			<s:iterator value="expBeanList">
				<tr>
					<td style="display: none;"><s:property value="#session.username" /></td>
					<td style="display: none;"><s:property value="expId" /></td>
					<td><s:property value="compName" /></td>
					<td><s:property value="compAddr" /></td>
					<td><s:property value="countryComp" /></td>
					<td><s:property value="yearsExp" /></td>
					<td><s:property value="jobRole" /></td>
					<td class="form-inline">
						<a href="deleteExp.action?expBean.expId=<s:property value="expId"/>&&expBean.username=<s:property value="#session.username"/>"><i class="fas fa-times"  style="font-size: 40px;"></i></a>|
						<a href="updateExp.action?submitType=editexp&expBean.expId=<s:property value="expBean.expId"/>"><i class="fas fa-pencil-alt" style="font-size: 35px;"></i></a>
					</td>
				</tr>
			</s:iterator>
		</table>
	
	</s:if>
	<s:else>
		<table class="table table-bordered">
			<thead>
				<tr class="tableHeader">
					<th>Company Name</th>
					<th>Company Address</th>
					<th>Country of Company</th>
					<th>Years of Experience</th>
					<th>Job Role</th>
				</tr>
			</thead>
		</table>
	</s:else>
    </div>
    </div>
    
	<s:if test="ctr>0 || i>0">
		<span style="color: green;"><s:property value="msg" /></span>
	</s:if>
	<s:else>
		<span style="color: red;"><s:property value="msg" /></span>
	</s:else>

</body>
</html>