<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>收到的的信件</title>
<%@include file="/css/cssforvalidate.file" %>
<%@include file="/css/datatables.file" %>
<%@page import="javax.servlet.http.*,global.GlobalService,member.model.*,java.util.List" %>
<%	
	MemberBean mb = (MemberBean)session.getAttribute(GlobalService.LOGIN_TOKEN);
	String sender = mb.getUserName();
	MessageService service = new MessageService();
	List<MessageBean> list = service.findBySender(sender);
	pageContext.setAttribute("list",list);
%>
</head>
<body>
	<%@include file="head/link.file" %>
<form method="post" action="receivedelete">
	<fieldset>
		<legend>收到的信件</legend>
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
						<td onclick="tdUrl(${item.messageNumber})">${item.sender}</td>
						<td onclick="tdUrl(${item.messageNumber})">${item.receiver}</td>
						<td onclick="tdUrl(${item.messageNumber})">${item.messageTitle}</td>
						<fmt:formatDate value="${item.messageTime}" var="formattedDate" type="date" pattern="yyyy年MM月dd日" />				
						<td onclick="tdUrl(${item.messageNumber})"><c:out value="${formattedDate}"/></td>
									
					</tr>						
				</c:forEach>
			</tbody>
		</table>
		<input type="reset" name="reset" value="清除">
		<input type="submit" name="delete" value="刪除信件">
	</fieldset>
</form>

<script type="text/javascript">
	function tdUrl(num){
		window.location="msg.jsp?t="+num;
	}
</script>

</body>
</html>