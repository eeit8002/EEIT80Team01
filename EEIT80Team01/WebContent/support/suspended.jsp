<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
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
<a href="${pageContext.request.contextPath}/support/login/login.jsp">登入</a><br>
<a href="${pageContext.request.contextPath}/support/manage/TestPage.jsp">Manage TestPage</a><br>
<a href="${pageContext.request.contextPath}/support/password/changePassword.jsp">修改密碼</a><br>
<a href="${pageContext.request.contextPath}/support/login/logout.jsp">登出</a><br>
<a href="${pageContext.request.contextPath}/support/forciblySnatch.jsp">強制下架商品</a><br>
<a href="${pageContext.request.contextPath}/support/suspended.jsp">停權</a><br>
<input type="button" id="newList" value="更新">
<table id="Suspended_table">
	<thead>
		<tr>
			<th>leagal</th>
			<th>Prosecutor</th>
			<th>Username</th>
			<th>url</th>
			<th>reson</th>
			<th>stat</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${reportListName}" var="item">
			<tr>
				<td>${item.legal}</td>
				<td>${item.prosecutor}</td>
				<td>${item.username}</td>
				<td>${item.url}</td>
				<td>${item.reason}</td>
				<td>${item.status}</td>
			</tr>
		</c:forEach>
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