<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
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
	<header><%@include file="/include/header-admin"%></header>
	<article>
		<div class="container-fluid">
			<div class="row">
				<div class="col-md-3">
					<div class="panel panel-default" style="margin-top: 20px">
						<div class="panel-heading">
							<h3 class="panel-title">系統管理員</h3>
						</div>
						<div class="panel-body">
							<c:if test="${empty LoginAdmin }">
								<a
									href="${pageContext.request.contextPath}/admin/login/login.jsp">登入</a>
								<br>
								<br>
							</c:if>
							<c:if test="${!empty LoginAdmin }">
								<a
									href="${pageContext.request.contextPath}/admin/manage/AddNewSupporter.jsp">新增客服帳號</a>
								<br>
								<br>
								<a
									href="${pageContext.request.contextPath}/admin/manage/listSupporters.jsp">客服人員列表</a>
								<br>
								<br>
								<a
									href="${pageContext.request.contextPath}/admin/password/changePassword.jsp">修改系統管理員密碼</a>
								<br>
								<br>
								<a
									href="${pageContext.request.contextPath}/admin/login/logout.jsp">登出</a>
							</c:if>
						</div>
					</div>
				</div>
				<div class="col-md-9">
					<c:if test="${!empty LoginAdmin}">
						<c:set var="funcName" value="LOG" scope="session" />
						<div class="panel panel-default"
							style="margin: auto; margin-top: 20px; width: 40%">
							<div class="panel-heading">
								<h3 class="panel-title">系統管理員修改密碼</h3>
							</div>
							<div class="panel-body">
								<form method="post" action="adminChangePassword.do">
									<div class="form-group">
										<label for="username">舊密碼：</label> <input type="password"
											id="oldpassword" name="oldpassword" title="請輸入舊密碼"
											class="form-control">
									</div>
									<div class="form-group">
										<label for="password">新密碼：</label> <input type="password"
											id="password" name="password" title="請輸入新密碼"
											class="form-control">
									</div>
									<div class="form-group">
										<label for="password">確認新密碼：</label> <input type="password"
											id="passwordCheck" name="passwordCheck" title="請確認新密碼"
											class="form-control">
									</div>
									<input class="btn btn-default" type="submit" id="submit"
										value="確定"> <input class="btn btn-danger" type="reset"
										id="reset" value="清除">
								</form>
								<font color="red" size="-1">${ErrorMsgKey.LoginError}&nbsp;</font>
							</div>
						</div>
						<script type="text/javascript" src="login.js"></script>
					</c:if>
				</div>
			</div>
		</div>
	</article>
	<footer> </footer>
	<%@include file="/include/modal"%>
	<script src="changeData.js"></script>
</body>
</html>