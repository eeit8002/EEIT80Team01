<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
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
	<c:if test="${empty LoginAdmin }">
		<script>
			location.href = ('${pageContext.request.contextPath}/admin/login/login.jsp');
		</script>
	</c:if>
	<c:if test="${!empty LoginAdmin }">
		<script>
			location.href = ('${pageContext.request.contextPath}/admin/manage/listSupporters.jsp');
		</script>
	</c:if>
</body>
</html>