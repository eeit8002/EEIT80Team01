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
	<form>
		<fieldset>
			<legend>客服人員一覽</legend>
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
					<c:forEach items="${list}" var="item">
						<tr>
							<td>${item.supportername}</td>
							<td>${item.employeeid }</td>
							<td>${item.lastname }</td>
							<td>${item.firstname }</td>
							<td><input type="submit" name="" value="modify"></td>
							<td><input type="submit" name="" value="delete"></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</fieldset>
	</form>
</body>
</html>