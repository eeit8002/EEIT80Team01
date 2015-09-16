<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<%@include file="/include/include"%>
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
<title>系統管理員首頁</title>
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
				<c:if test="${empty LoginAdmin }">
				<div style="align:center"><h1>登入</h1></div>
				</c:if>
				<c:if test="${!empty LoginAdmin }">
				</c:if>
			</div>
		</div>
	</div>
	</article>
	<footer> </footer>
	<%@include file="/include/modal"%>






	<!-- <h1>系統管理員首頁</h1> -->
	<%-- <a href="${pageContext.request.contextPath}/admin/login/login.jsp">登入</a><br><br> --%>
	<%-- <a href="${pageContext.request.contextPath}/admin/manage/TestPage.jsp">系統管理員Filter測試頁面</a><br><br> --%>
	<%-- <a href="${pageContext.request.contextPath}/admin/password/changePassword.jsp">修改密碼</a><br><br> --%>
	<%-- <a href="${pageContext.request.contextPath}/admin/manage/listSupporters.jsp">客服人員列表</a><br><br> --%>
	<%-- <a href="${pageContext.request.contextPath}/admin/login/logout.jsp">登出</a> --%>
</body>
</html>