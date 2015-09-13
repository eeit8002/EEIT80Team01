<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>已發出信件</title>
<%@include file="/css/cssforvalidate.file" %>
<%@include file="/css/datatables.file" %>
</head>
<body>
	<%@include file="head/link.file" %>
<form>
	<fieldset>
		<legend>已發出信件</legend>
		<table id="table" class="display" cellspacing="0" width="100%">
			<thead>
				<tr>
					<td></td>
					<td>發件者</td>
					<td>收件者</td>
					<td>信件主旨</td>
					<td>發件時間</td>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${list}" var="item">
					<tr>
						<td><input type="checkbox" name="messageNumber" value="${item.messageNumber}"></td>
						<td>${item.sender}</td>
						<td>${item.receiver}</td>
						<td><a href="msg.jsp?t=${item.messageNumber}">${item.messageTitle}</a></td>
						<fmt:formatDate value="${item.messageTime}" var="formattedDate" type="date" pattern="yyyy年MM月dd日" />				
						<td><c:out value="${formattedDate}"/></td>					
					</tr>						
				</c:forEach>
			</tbody>
		</table>
		<input type="reset" name="reset" value="清除">
		<input type="submit" name="delete" value="刪除信件">
	</fieldset>
</form>



</body>
</html>