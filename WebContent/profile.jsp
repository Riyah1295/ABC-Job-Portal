<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Profile</title>
<script>
	window.history.forward(1)
</script>
</head>
<body>
	<s:include value="header.jsp"></s:include>
	<div class="row">
		<div class="col-lg-2" style="height: 180px;">
            <img src="image/erza.png" class="profileImage">
        </div>

        <div class="col-lg-10">  
            <h1><s:property value="#session.username"/></h1>  
            <h1><s:property value="userBean.name"/></h1>
        </div>
	</div>
	
	
	
	<div class="row">
	<div class="col-lg-1"></div>
	<div class="contentFriends col-lg-3" style="height:630px;">
	<label class="header">FRIENDS</label>
	
		<s:if test="noDataF==true">
			<table class="table table-bordered">
				<!-- <thead>
					<tr style="background-color: #00ad1c;">
						<th>Friends</th>
					</tr>
				</thead>
				 -->
				<s:iterator value="friendsBeanList">
					<tr>
						<!--<td><s:property value="username" /></td> -->
						 <td><s:property value="friendsName" /></td>
						<td style="display:none;"><s:property value="friendsId" /></td>
						<td style="display:none;"><s:property value="#session.username" /></td>
						<td><a href="deleteFriends.action?friendsBean.friendsName=<s:property value="friendsName"/>&&userBean.username=<s:property value="#session.username"/>"><button class="btn btn-light">Unfriend</button></a></td>
					</tr>
				</s:iterator>
			</table>
			
		</s:if>
		
		<s:else>
			<p>You have not added any friends yet!</p>
			<a href='search.jsp' id="profileBtn">Click here to search for friends!</a>
		</s:else>
	</div>
	
	
	<div class="col-lg-1"></div>
	<div class="contentPost col-lg-6" style="height:630px;">
	<div class="tab">
		<button type="button" class="tablinks" onclick="showHidePost(event, 'post')">Add Post</button>
		<button type="button" class="tablinks" onclick="showHidePost(event, 'myPost')" id="defaultPage">My Post</button>
		<button type="button" class="tablinks" onclick="showHidePost(event, 'allPost')">All Post</button>
	</div>
	<br>
	<div id="post" class="tabcontent">
			
		<form action="addPost" method="post">
		
			<s:textfield label="Job Title" name="jobBean.jobTitle" placeholder="Job Title" cssClass="form-control"/>
			<br>
			
			<s:textarea label="Job Description" name="jobBean.jobDesc" placeholder="Job Description" cssClass="form-control"/>
			<br>
			
			<s:textfield label="Country of Job" name="jobBean.countryJob" placeholder="Country of Job" cssClass="form-control"/>
			<br>
			
			<s:textfield label="Closing Date" name="jobBean.closeDate" placeholder="Closing Date" cssClass="form-control"/>
			<input type="hidden" name="userBean.username" value='<s:property value="#session.username"/>'>
			<input type="hidden" name="jobBean.username" value='<s:property value="#session.username"/>'>
			
			<br>
			<div class="form-inline">
				<div class="col-lg-6">
					<s:submit href='profile?submitType=editpost&userBean.username=<s:property value="#session.username"/>' class="btn btn-success" name="submitType" type="submit" value="Add" style="width:100%;"/>
				</div>	
				<div class="col-lg-6">
					<a href='profile?submitType=editpost&userBean.username=<s:property value="#session.username"/>'><button type="button" class="btn btn-warning" style="width:100%;">Cancel</button></a>
				</div>	
			</div>
		</form>
	</div>

	<div id="myPost" class="tabcontent pre-scrollable">
		<s:if test="noData==true">
				<s:iterator value="jobBeanList">
					<div class="myPostValue">
						<s:textfield label="Job Code" name="jobCode" readonly="true" cssClass="form-control"/>
						<s:textfield label="Job Title" name="jobTitle" readonly="true" cssClass="form-control"/>
						<s:textfield label="Job Description" name="jobDesc" readonly="true" cssClass="form-control"/>
						<s:textfield label="Country of Job" name="countryJob" readonly="true" cssClass="form-control"/>
						<s:textfield label="Closing Date" name="closeDate" readonly="true" cssClass="form-control"/>
						<input type="hidden" name="username" value='<s:property value="#session.username"/>'>
						
						<div class="form-inline" style="margin-top: 25px; float:right;">
							<a href="deletePost.action?jobBean.jobCode=<s:property value="jobCode"/>&&userBean.username=<s:property value="#session.username"/>"><i class="fas fa-times" style="font-size: 40px;"></i></a>
		                    <a href="updatePost.action?submitType=editpost&jobBean.jobCode=<s:property value="jobCode"/>"><i class="fas fa-pencil-alt"  style="font-size: 35px;"></i></a>
	                    </div>
                    </div>
					<br>
				</s:iterator>
		</s:if>
		
		<s:else>
			<p>You have not added any post yet!</p>
		</s:else>
	</div>

	<div id="allPost" class="tabcontent pre-scrollable">
		<s:if test="noData==true">
			<table class="table table-bordered">
				<thead>
					<tr class="tableHeader">
						<th>Username</th>
						<th>Job Code</th>
						<th>Job Title</th>
						<th>Job Description</th>
						<th>Country of Job</th>
						<th>Closing Date</th>
					</tr>
				</thead>
				
				<s:iterator value="jobBeanListAll">
					<tr>
						<td><s:property value="username" /></td>
						<td><s:property value="jobCode" /></td>
						<td><s:property value="jobTitle" /></td>
						<td><s:property value="jobDesc" /></td>
						<td><s:property value="countryJob" /></td>
						<td><s:property value="closeDate" /></td>
					</tr>
				</s:iterator>
			</table>
		</s:if>
		<s:else>
			<table class="table table-bordered">
				<thead>
					<tr class="tableHeader">
						<th>Username</th>
						<th>Job Code</th>
						<th>Job Title</th>
						<th>Job Description</th>
						<th>Country of Job</th>
						<th>Closing Date</th>
					</tr>
				</thead>
			</table>
		</s:else>
	</div>
	</div>
	<div class="col-lg-1"></div>
	</div>
<s:if test="ctr>0">
				<span style="color: green;"><s:property value="msg" /></span>
			</s:if>
			<s:else>
				<span style="color: red;"><s:property value="msg" /></span>
			</s:else>
	<script>
		function showHidePost(evt, post) {
			var i, tabcontent, tablinks;
			tabcontent = document.getElementsByClassName("tabcontent");
		
			for (i = 0; i < tabcontent.length; i++) {
				tabcontent[i].style.display = "none";
			}
		
			tablinks = document.getElementsByClassName("tablinks");
		
			for (i = 0; i < tablinks.length; i++) {
		    	tablinks[i].className = tablinks[i].className.replace(" active", "");
			}
		
			document.getElementById(post).style.display = "block";
			evt.currentTarget.className += " active";
		}
		document.getElementById("defaultPage").click();
	</script>

</body>
</html>