<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@include file="/css/cssforvalidate.file"%>
<%@include file="/css/datatables.file"%>
<title>Show Supporters</title>
</head>
<body>
	<%@include file="head/link.file"%>
	<form method="post" action="砍客服資料 還沒寫">
		<fieldset>
			<legend>客服人員列表</legend>
			<table id="table" class="display" cellspacing="0" width="100%">
				<thead>
					<tr>
						<td>客服帳號</td>
						<td>客服員工編號</td>
						<td>姓</td>
						<td>名</td>
						<td>編輯</td>
						<td>刪除帳號</td>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${supporterlist}" var="item">
						<tr>
							<td>${item.supportername}</td>
							<td>${item.employeeid}</td>
							<td>${item.lastname}</td>
							<td>${item.firstname}</td>
							<td><a href="${pageContext.request.contextPath}/admin/manage/modifySupporter.do?supportername=${item.supportername}">修改</a></td>
							<td><input type="checkbox" name="supporterChecked"
								value="${item.supportername}"></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</fieldset>
		<input type="reset" name="reset" value="清除">
		<input type="submit" name="delete" value="刪除客服帳號">
	</form>
</body>
</html>