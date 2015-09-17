<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<%@include file="/include/include"%>
<title>修改系統管理員密碼</title>
<style>
.navbar {
	margin-bottom: 0px;
}

#carousel1 {
	margin-bottom: 20px;
}

body {
	padding-top: 50px;
}
</style>

</head>
<body>
	<div id="main">
		<form method="post" class="cmxform" id="form"
			action="adminChangePassword.do">
				<legend>修改管理員密碼</legend>
				<p>
					<label class="tag" for="oldpassword">舊密碼：</label> <input
						type="password" id="oldpassword" name="oldpassword" title="請輸入舊密碼">
				</p>
				<p>
					<label class="tag" for="password">新密碼：</label> <input
						type="password" id="password" name="password" title="請輸入新密碼">
				</p>
				<p>
					<label class="tag" for="password">確認密碼：</label> <input
						type="password" id="passwordCheck" name="passwordCheck"
						title="請再次輸入新密碼">
				</p>
				<label class="tag"></label> <input type="submit" id="submit"
					value="送出"> <input type="reset" id="reset" value="還原">
		</form>
		<a href="${pageContext.request.contextPath}/admin/index.jsp">回管理首頁</a>
	</div>

	<script src="changeData.js"></script>
</body>
</html>