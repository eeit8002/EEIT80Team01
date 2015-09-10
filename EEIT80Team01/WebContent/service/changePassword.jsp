<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@include file="/css/cssforvalidate.file" %>
<title>重設密碼</title>
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
	<form method="post" class="cmxform" id="form" action="resetPassword">
		<fieldset>
			<legend>註冊</legend>
			<p>
				<label class="tag" for="user">帳號：</label>
				<input type="text" id="username" name="username" title="請輸入帳號"  value="${EmailChecked}" readonly="readonly">
			</p>						
			<p>
				<label class="tag" for="password">新密碼：</label>
				<input type="password" id="password" name="password" title="請輸入密碼">
			</p>
			<p>
				<label class="tag" for="password">確認新密碼：</label>
				<input type="password" id="passwordCheck" name="passwordCheck" title="請再次輸入密碼">
			</p>
			
			<label class="tag"></label>
			<input type="submit" id="submit" value="送出">
			<input type="reset" id="reset" value="清除">
		</fieldset>	
	</form>
	<Font color='red' size="-1">${loginFalure}&nbsp;</Font>	
</div>

</body>
</html>