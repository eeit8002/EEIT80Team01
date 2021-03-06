<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@include file="/include/include" %>
<title>修改客服密碼</title>
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
	<form method="post" class="cmxform" id="form" action="supportChangePassword.do">
		<fieldset>
			<legend>修改客服密碼</legend>
			<p>
				<label class="tag" for="oldpassword">舊密碼：</label>
				<input type="password" id="oldpassword" name="oldpassword" title="請輸入舊密碼">
			</p>
			<p>
				<label class="tag" for="password">新密碼：</label>
				<input type="password" id="password" name="password" title="請輸入新密碼">
			</p>
			<p>
				<label class="tag" for="password">確認密碼：</label>
				<input type="password" id="passwordCheck" name="passwordCheck" title="請再次輸入新密碼">
			</p>
			<label class="tag"></label>
			<input type="submit" id="submit" value="送出">
			<input type="reset" id="reset" value="還原">
		</fieldset>
	</form>
	<a href="${pageContext.request.contextPath}/support/index.jsp">回管理首頁</a>
</div>

	<script src="changeData.js"></script>
</body>
</html>