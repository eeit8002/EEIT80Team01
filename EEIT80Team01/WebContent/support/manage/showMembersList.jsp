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
	<form method="post" action="">
		<fieldset>
			<legend>客服人員一覽</legend>
			<table id="table" class="display" cellspacing="0" width="100%">
				<thead>
					<tr>
						<td>會員帳號</td>
						<td>姓氏</td>
						<td>名字</td>
						<td>E-mail</td>
						<td>性別</td>
						<td>生日</td>
						<td>帳號狀態</td>
						<td>身份驗證</td>
						<td>封鎖</td>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${memberlist}" var="item">
						<tr>
							<td>${item.userName}</td>
							<td>${item.lastName}</td>
							<td>${item.firstName}</td>
							<td>${item.email}</td>
							<td>${item.gender}</td>
							<td>${item.birthDay}</td>
							<c:choose>
								<c:when test="${item.access eq 0}">
									<td>正常使用</td>
								</c:when>
								<c:otherwise>
									<td>封鎖中！</td>
								</c:otherwise>
							</c:choose>
							<c:choose>
								<c:when test="${item.certified eq 0}">
									<td>未認證</td>
								</c:when>
								<c:otherwise>
									<td>已認證</td>
								</c:otherwise>
							</c:choose>
							<td><input type="checkbox" name="memberChecked" value="${item.userName}"></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<input type="reset" name="reset" value="清除">
			<input type="submit" name="suspend" value="封鎖選取的用戶">
			<input type="submit" name="resume" value="解除封鎖選取的用戶">
		</fieldset>
	</form>
</body>
</html>