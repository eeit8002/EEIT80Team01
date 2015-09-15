<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Admin Control Panel</title>
</head>
<body>
<a href="${pageContext.request.contextPath}/admin/login/login.jsp">登入</a><br><br>
<a href="${pageContext.request.contextPath}/admin/manage/TestPage.jsp">管理員Filter測試頁面</a><br><br>
<a href="${pageContext.request.contextPath}/admin/password/changePassword.jsp">修改密碼</a><br><br>
<a href="${pageContext.request.contextPath}/admin/manage/listSupporters.jsp">客服人員列表</a><br><br>
<a href="${pageContext.request.contextPath}/admin/login/logout.jsp">登出</a>
</body>
</html>