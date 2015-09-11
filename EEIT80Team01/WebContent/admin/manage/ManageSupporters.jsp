<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Manage Supporters</title>
</head>
<body>
	<table>
		<tr>
			<th>帳號</th>
			<th>客服編號</th>
			<th>名</th>
			<th>姓</th>
			<th>Delete</th>
		</tr>
		<jsp:include page="${pageContext.request.contextPath}/admin/manage/listSupporters.jsp"></jsp:include>
		<c:forEach items="${supporterlist}" var="supportbean">
			<tr>
				<td><c:out value="${supportbean.supportername}"></c:out></td>
				<td><c:out value="${supportbean.employeeID}"></c:out></td>
				<td><c:out value="${supportbean.firstname}"></c:out></td>
				<td><c:out value="${supportbean.lastname}"></c:out></td>
				<td>Delete CheckBox</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>