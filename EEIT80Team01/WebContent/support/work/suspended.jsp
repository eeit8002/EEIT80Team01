<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page import="support.model.*"%>
<%@ page import="support.model.dao.*"%>
<%
boolean status = true;
if(status!=true){
	status = false;
} else if(status!=false) {
	status = true;
}
%>
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
<a href="${pageContext.request.contextPath}/support/work/forciblySnatch.jsp">強制下架商品</a><br>
<a href="${pageContext.request.contextPath}/support/work/suspended.jsp">停權</a><br>
<form method="post" action="send">
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
					<td>
						<select name="status">
									<option value="${item.status}">正常</option>
									<option value="${item.status}">停權</option>
						</select>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<input type="submit" value="確定">
</form>

</body>
</html>