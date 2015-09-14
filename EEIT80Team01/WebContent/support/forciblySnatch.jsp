<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>強制下架</title>
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
<table id="Suspended_table">
	<thead>
		<tr>
			<th>ITEM_ID</th>
			<th>SELLER</th>
			<th>BUYER</th>
			<th>ITEM_CATEGORY</th>
			<th>TITLE</th>
			<th>START_PRICE</th>
			<th>DIRECT_PRICE</th>
			<th>BID</th>
			<th>END_TIME</th>
			<th>ITEM_DISCRIBE</th>
			<th>ITEM_STATUS</th>
			<th>THREAD_LOCK</th>
			<th>執行</th>
		</tr>
	</thead>
	<tbody>
		<tr>
			<td>aaa</td>
			<td>bbb</td>
			<td>ccc</td>
			<td>ddd</td>
			<td>eee</td>
			<td>fff</td>
			<td>ggg</td>
			<td>hhh</td>
			<td>iii</td>
			<td>jjj</td>
			<td>kkk</td>
			<td>lll</td>
			<td></td>
		</tr>
	</tbody>
</table>

</body>
</html>