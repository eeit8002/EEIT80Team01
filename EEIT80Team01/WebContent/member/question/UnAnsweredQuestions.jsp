<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>尚未被回覆的問題</title>
</head>
<body>
	<table>
		<thead>
			<tr>
				<td>編號</td>
				<td>標題</td>
				<td>發問時間</td>
				<td>內容</td>
			</tr>
		</thead>
		<tbody>
			<tr>
				<c:forEach items="${UnAnsweredQuestions}" var="questions">
					<td>${questions.qno}</td>
					<td>${questions.title}</td>
					<td><jsp:useBean id="dateObject" class="java.util.Date" /> <jsp:setProperty
							name="dateObject" property="time" value="${questions.qt}" /> <fmt:formatDate
							value="${dateObject}" pattern="yyyy/MM/dd hh:mm:ss" /></td>
					<td><a
						href="${pageContext.request.contextPath}/member/question/memberUnAnsweredQuestionDetailServlet.do?qno=${question.qno}&member=${question.member}">問題內容</a></td>
				</c:forEach>
			</tr>
		</tbody>
	</table>
</body>
</html>