<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登入</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<link rel="stylesheet"
	href="https://ajax.googleapis.com/ajax/libs/jqueryui/1.11.4/themes/smoothness/jquery-ui.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.11.4/jquery-ui.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/scripts/jquery.form.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/scripts/jquery.validate.min.js"></script>

<style>
fieldset {
	width: 500px;
}

.tag {
	display: inline-block;
	width: 100px;
	text-align: right;
}
</style>

</head>
<body>
	<c:set var="funcName" value="LOG" scope="session" />
	<div id="main">
		<form method="post" class="cmxform" id="form" action="login.do">
			<fieldset>
				<legend>登入</legend>
				<p>
					<label class="tag" for="user" value="${sessionScope.username}">帳號：</label>
					<input type="text" id="username" name="username" title="請輸入帳號">
				</p>
				<p>
					<label class="tag" for="password" value="${sessionScope.password}">密碼：</label>
					<input type="password" id="password" name="password" title="請輸入密碼">
				</p>
				<p>
					<label class="tag"><small>記住密碼</small> </label><input
						type="checkbox" name="rememberMe"
						<c:if test='${sessionScope.rememberMe==true}'>
                  checked='checked'
               </c:if>
						value="true">
				</p>
				<label class="tag"></label> <input type="submit" id="submit"
					value="送出"> <input type="reset" id="reset" value="清除">
			</fieldset>
		</form>
		<Font color='red' size="-1">${ErrorMsgKey.LoginError}&nbsp;</Font>
	</div>
	<script type="text/javascript" src="login.js"></script>
</body>
</html>