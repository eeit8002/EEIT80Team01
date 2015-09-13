<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>首頁</title>
</head>
<body>
	等人放東西的首頁<br>
	<c:if test="${empty LoginOK }">
		<a href="${pageContext.request.contextPath}/register/register.jsp">註冊</a><br>
	</c:if>
	<c:if test="${ ! empty LoginOK }">
		<a href="${pageContext.request.contextPath}/member/changeData.jsp">修改資料</a><br>
	</c:if>
	<c:if test="${empty LoginOK }">
		<a href="${pageContext.request.contextPath}/login/login.jsp">登入</a><br>
    </c:if>	
	<c:if test="${ ! empty LoginOK }">
		<a href="${pageContext.request.contextPath}/login/logout.jsp">登出</a><br>
	</c:if>
	<c:if test="${ ! empty LoginOK }">
		<a href="${pageContext.request.contextPath}/member/changePassword.jsp">修改密碼</a><br>
	</c:if>
	<c:if test="${ ! empty LoginOK }">
		<a href="${pageContext.request.contextPath}/member/message/send">站內信系統</a><br>
	</c:if>
	
</body>
</html>