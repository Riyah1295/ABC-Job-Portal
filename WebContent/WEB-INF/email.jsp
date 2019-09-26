<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Bulk Email</title>
</head>
<body>
	<h4>Send Bulk Email</h4>
	
	<s:form action="sendBulkEmail">
		<s:textfield label="Subject" placeholder="Enter Subject" cssClass="form-control" cssStyle="width:100%;" />
		<s:textfield label="Content" placeholder="Enter Content" cssClass="form-control" cssStyle="width:100%;" />
		<s:submit value="Send" />
	</s:form>
</body>
</html>