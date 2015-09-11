<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>停權</title>
<style>
.del{
text-decoration:none;
font-size:0.8em;
}
#Suspended_table{
		border:1px solid green;
   		border-collapse:collapse;
   		width:400px;
}
#Suspended_table>thead>tr>th,#Suspended_table td{
		border:1px solid green;
   		padding:4px;
   		text-align:center;
}   		
</style>
</head>
<body>
<a href="${pageContext.request.contextPath}/support/login/login.jsp">Login</a><br>
<a href="${pageContext.request.contextPath}/support/manage/TestPage.jsp">Manage TestPage</a><br>
<a href="${pageContext.request.contextPath}/support/password/changePassword.jsp">Change Password</a>
<a href="${pageContext.request.contextPath}/support/login/logout.jsp">Logout</a>
<a href="">下架商品</a><br>
<input type="button" id="newList" value="更新">
<table id="Suspended_table">
	<thead>
		<tr>
			<th>Username</th>
			<th>Prosecutor</th>
			<th>stat</th>
			<th>執行</th>
		</tr>
	</thead>
	<tbody>
		<tr>
			<td>aaa</td>
			<td>bbb</td>
			<td>0:代表狀態可用，1:代表停權狀態</td>
			<td></td>
		</tr>
	</tbody>
</table>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.4/jquery.min.js"></script>
<script>!window.jQuery && document.write("<script src='Scripts/jquery-2.1.4.min.js'><\/script>")</script>
<script>
	(function($){
		
	});
</script>
</body>
</html>