<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@include file="/css/cssforvalidate.file" %>
<title>註冊</title>
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
	<form method="post" class="cmxform" id="form" action="register.do">
		<fieldset>
			<legend>註冊</legend>
			<p>
				<label class="tag" for="user">帳號：</label>
				<input type="text" id="username" name="username" title="請輸入帳號">
			</p>
			<p>
				<label class="tag" for="password">密碼：</label>
				<input type="password" id="password" name="password" title="請輸入密碼">
			</p>
			<p>
				<label class="tag" for="password">確認密碼：</label>
				<input type="password" id="passwordCheck" name="passwordCheck" title="請再次輸入密碼">
			</p>
			<p>
				<label class="tag" for="id">身份證字號：</label>
				<input type="text" id="id" name="id" title="請輸入身份證字號">
			</p>
			<p>
				<label class="tag" for="lastName">姓：</label>
				<input type="text" id="lastName" name="lastName" title="請輸入姓">
			</p>
			<p>
				<label class="tag" for="firstName">名：</label>
				<input type="text" id="firstName" name="firstName" title="請輸入名">
			</p>
			<p>
				<label class="tag" for="email">E-mail：</label>
				<input type="text" id="email" name="email" title="請輸入E-mail信箱">
			</p>
			<p>
				<label class="tag" for="birthDay">生日：</label>
				<input type="text" id="birthDay" name="birthDay" title="輸入生日日期">
			</p>
			<p>
			<label class="tag" for="gender">姓別：</label>
			<select id="gender" name="gender">
				<option value="">請選擇姓別：</option>
				<option value="1">男</option>
				<option value="0">女</option>
			</select>
			</p>
			<label class="tag"></label>
			<input type="submit" id="submit" value="送出">
			<input type="reset" id="reset" value="清除">
		</fieldset>	
	</form>
	<c:if test="${ ! empty Success }">
			註冊成功!
	</c:if>
	<Font color='red' size="-1">${Error}&nbsp;</Font>	
</div>

	<script src="register.js"></script>
</body>
</html>