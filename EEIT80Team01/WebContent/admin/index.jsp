<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Admin Control Panel</title>
</head>
<body>
<a href="${pageContext.request.contextPath}/admin/login/login.jsp">Login</a><br><br>
<a href="${pageContext.request.contextPath}/admin/manage/TestPage.jsp">TestPage</a><br><br>
<a href="${pageContext.request.contextPath}/admin/password/changePassword.jsp">Change Password</a><br><br>
<a href="${pageContext.request.contextPath}/admin/manage/listSupporters.jsp">List Supporters</a><br><br>
<a href="${pageContext.request.contextPath}/admin/login/logout.jsp">Logout</a>
</body>
</html>