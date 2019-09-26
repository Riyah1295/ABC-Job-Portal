<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Education</title>
<script>
	window.history.forward(1)
</script>
</head>
<body>    
    
    <s:include value="header.jsp"></s:include>
    
    <div class="row" id="eduRow">
    
	    <div class="addEduCont col-lg-3" style="margin-top: 100px;"> 
		    <h4 class="titleAddEdu" style="margin-left: 40px;">Add New Education</h4>
		    
		    <s:form action="addEdu" method="post" id="myForm">
		    	
				<s:textfield name="eduBean.qualification" placeholder="Qualification" cssClass="form-control" cssStyle="width:100%;"/>
				<s:textfield name="eduBean.institute" placeholder="Institute" cssClass="form-control" cssStyle="width:100%;"/>
				<s:textfield name="eduBean.countrySch" placeholder="Country of School" cssClass="form-control" cssStyle="width:100%;"/>
				<s:textfield name="eduBean.yearGrad" placeholder="Year of Graduate" cssClass="form-control" cssStyle="width:100%;"/>
				<s:textfield name="eduBean.grade" placeholder="Grade" cssClass="form-control" cssStyle="width:100%;"/>
		
				<input type="hidden" name="eduBean.username" value='<s:property value="#session.username"/>'>
				
				<s:submit href='education?eduBean.username=<s:property value="#session.username"/>' onclick="resetForm();" class="btn btn-success" style="width:100%; margin-top:10px;" name="submitType" type="submit" value="Add"/>
				
				<s:reset class="btn btn-info" type="button" key="reset" value="Clear" style="width:100%;  margin-bottom:10px;"/>
				
			</s:form>
		</div>
   
	<div class="eduCont col-lg-9 pre-scrollable">
	
	<s:if test="noData==true">
		<table class="table table-bordered">
			<thead>
				<tr class="tableHeader">
					<!-- <th style="display: none;">Edu Id</th>
					<th>Username</th> -->
					<th>Qualification</th>
					<th>Institute</th>
					<th>Country of School</th>
					<th>Year of Graduate</th>
					<th>Grades</th>
					<th>Action</th>
				</tr>
			</thead>
			
			<s:iterator value="eduBeanList">
				<tr>
					<td style="display: none;"><input type="hidden" value="eduId" name="eduId" /></td>
					<td style="display: none;"><s:property value="#session.username" /></td>
					<td><s:property value="qualification" /></td>
					<td><s:property value="institute" /></td>
					<td><s:property value="countrySch" /></td>
					<td><s:property value="yearGrad" /></td>
					<td><s:property value="grade" /></td>
					<td>
						<a href="deleteEdu.action?eduBean.eduId=<s:property value="eduId"/>&&eduBean.username=<s:property value="#session.username" />"><i class="fas fa-times" style="font-size: 40px;"></i></a>|
						<a href="updateEdu.action?submitType=editedu&eduBean.eduId=<s:property value="eduId"/>"><i class="fas fa-pencil-alt" style="font-size: 35px;"></i></a>
					</td>
				</tr>
			</s:iterator>
		</table>
	
	</s:if>
	<s:else>
		<table class="table table-bordered">
			<thead>
				<tr class="tableHeader">
					<!-- <th style="display: none;">Edu Id</th>
					<th>Username</th> -->
					<th>Qualification</th>
					<th>Institute</th>
					<th>Country of School</th>
					<th>Year of Graduate</th>
					<th>Grades</th>
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