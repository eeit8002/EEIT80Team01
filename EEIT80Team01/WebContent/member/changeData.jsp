<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@include file="/css/cssforvalidate.file" %>
<title>修改帳戶資料</title>
	<style>
		fieldset{
			width: 500px;
		}
		.tag{ 
			display: inline-block;
		 	width: 100px;
		 	text-align: right;
		 	}
	</style>

</head>
<body>
<div id="main">
	<form method="post" class="cmxform" id="form" action="changeData">
		<fieldset>
			<legend>修改資料</legend>
			<p>
				<label class="tag" for="user">帳號：</label>
				<input type="text" id="username" name="username" value="${LoginOK.userName.toLowerCase()}" readonly="readonly">
			</p>
			<p>
				<label class="tag" for="lastName">姓：</label>
				<input type="text" id="lastName" name="lastName" title="請輸入姓" value="${LoginOK.lastName}">
			</p>
			<p>
				<label class="tag" for="firstName">名：</label>
				<input type="text" id="firstName" name="firstName" title="請輸入名" value="${LoginOK.firstName}">
			</p>
			<p>
				<label class="tag" for="email">E-mail：</label>
				<input type="text" id="email" name="email" title="請輸入E-mail信箱" value="${LoginOK.email}">
			</p>

			<label class="tag"></label>
			<input type="submit" id="submit" value="送出">
			<input type="reset" id="reset" value="還原">
		</fieldset>	
	</form>
	<a href="${pageContext.request.contextPath}/index.jsp">回首頁</a>
</div>

	<script src="changeData.js"></script>
</body>
</html>