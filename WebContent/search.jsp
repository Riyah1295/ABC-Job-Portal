<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Search</title>
<script>
	window.history.forward(1)
</script>
</head>
<body>
	<s:include value="header.jsp"></s:include>
	<h3>Search</h3>
	<div class="row">
		<div class="col-lg-2"></div>
		<div class="col-lg-8" style="border:solid;">
		<br>
			<s:form action="search" method="post" class="form-inline">
				<s:textfield label="Search" name="userBean.firstName" placeholder="Search By First Name" cssClass="form-control"/>
				<s:submit type="submit" value="Search" class="btn btn-light"/>
			</s:form>
			<br>
			
			<form action="addFriends" method="post" class="form-inline">
				<!-- To display other's username. -->
				<input type="hidden" name="friendsBean.username" value="<s:property value='#session.username' />">
				<!-- To display user's username. -->
				<input type="hidden" name="userBean.username" value="<s:property value='#session.username' />">
							
				<s:iterator value="userBeanList">
					<div id="addFriends" style="border: solid 1px;">
						<input type="hidden" name="friendsBean.friendsName" value="<s:property value='friendsName' />">
						<input type="hidden" name="friendsName" value="<s:property value='friendsName' />">
							
						<span id="friendName"><s:property value="name"/></span>
									
						<s:if test="username != #session.username">
							<s:submit name="submitType" type="submit" value="Add" class="btn btn-success" style="width:100%; margin-top:10px;"/>
						</s:if>
					</div>		
				</s:iterator>
			</form>
			<br>
			<s:if test="ctr>0||i>0">
				<span style="color: red;"><s:property value="msg" /></span>
			</s:if>
			<s:else>
				<span style="color: green;"><s:property value="msg" /></span>
			</s:else>
		</div>
 </div>
</body>
</html>