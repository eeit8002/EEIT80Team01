<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>已獲得回覆的問題</title>
</head>
<body>
	<table>
		<thead>
			<tr>
				<td>編號</td>
				<td>標題</td>
				<td>發問時間</td>
				<td>回答時間</td>
				<td>內容</td>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${AnsweredQuestions}" var="answered">
				<tr>
					<td>${answered.gno}</td>
					<td>${answered.title}</td>
					<td><jsp:useBean id="dateObject" class="java.util.Date" /> <jsp:setProperty
							name="dateObject" property="time" value="${answered.qt}" /> <fmt:formatDate
							value="${dateObject}" pattern="yyyy/MM/dd hh:mm:ss" /></td>
					<td><jsp:useBean id="dateObject2" class="java.util.Date" /> <jsp:setProperty
							name="dateObject" property="time" value="${questions.at}" /> <fmt:formatDate
							value="${dateObject2}" pattern="yyyy/MM/dd hh:mm:ss" /></td>
					<td><a
						href="${pageContext.request.contextPath}/member/question/memberAnsweredQuestionDetailServlet.do?qno=${answered.qno}&member=${answered.member}"></a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>