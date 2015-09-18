<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>未回答問題</title>
</head>
<body>
	<table>
		<thead>
			<tr>
				<td>問題編號</td>
				<td>會員</td>
				<td>標題</td>
				<td>內容</td>
			</tr>
		</thead>
		<c:forEach items="${unansweredQuestions}" var="question">
			<tr>
			<td>${question.qno}</td>
			<td>${question.member}</td>
			<td>${question.title}</td>
			<td><a href="${pageContext.request.contextPath}/support/manage/question/supportQuestionDetail.do?qno=${question.qno}">內容</a></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>