<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
<title>客服管理</title>
</head>
<body>
<%-- <a href="${pageContext.request.contextPath}/support/login/login.jsp">登入</a><br> --%>
<%-- <a href="${pageContext.request.contextPath}/support/manage/TestPage.jsp">Manage TestPage</a><br> --%>
<%-- <a href="${pageContext.request.contextPath}/support/password/changePassword.jsp">修改密碼</a><br> --%>
<%-- <a href="${pageContext.request.contextPath}/support/login/logout.jsp">登出</a><br> --%>
<%-- <a href="${pageContext.request.contextPath}/support/work/forciblySnatch.jsp">強制下架商品</a><br> --%>
<%-- <a href="${pageContext.request.contextPath}/support/work/suspended.jsp">停權</a><br> --%>
	<c:if test="${empty LoginAdmin }">
		<script>
			location.href = ('${pageContext.request.contextPath}/admin/login/login.jsp');
		</script>
	</c:if>
	<c:if test="${!empty LoginAdmin }">
		<script>
			location.href = ('${pageContext.request.contextPath}/support/work/SuspendedServlet');
		</script>
	</c:if>
</body>
</html>