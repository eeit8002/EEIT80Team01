<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div>問題編號：${AnsweredQuestion.qno}</div>
	<div>標題：${AnsweredQuestion.title}</div>
	<div>
		發問時間：<jsp:useBean id="dateObject" class="java.util.Date" />
		<jsp:setProperty name="dateObject" property="time"
			value="${AnsweredQuestion.qt}" />
		<fmt:formatDate value="${dateObject}" pattern="yyyy/MM/dd hh:mm:ss" />
	</div>
	<div>提問內容：${AnsweredQuestion.qmsg}</div>
	<div>回覆客服：${AnsweredQuestion.supporter}</div>
	<div>回覆時間：<jsp:useBean id="dateObject2" class="java.util.Date" /> <jsp:setProperty
							name="dateObject" property="time" value="${AnsweredQuestion.at}" /> <fmt:formatDate
							value="${dateObject2}" pattern="yyyy/MM/dd hh:mm:ss" /></div>
	<div>回覆內容：${AnsweredQuestion.amsg}</div>
</body>
</html>