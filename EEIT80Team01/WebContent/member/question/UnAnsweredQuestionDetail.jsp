<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>問題${questionDetail.qno} ${questionDetail.title} 詳細內容</title>
</head>
<body>
	<div>編號：${questionDetail.qno}</div>
	<div>標題：${questionDetail.title}</div>
	<div>
		<jsp:useBean id="dateObject" class="java.util.Date" />
		<jsp:setProperty name="dateObject" property="time"
			value="${dequestionDetailtail.qt}" />
		時間：<fmt:formatDate value="${dateObject}" pattern="yyyy/MM/dd hh:mm:ss" />
	</div>
	<div>內容：${questionDetail.qmsg}</div>
</body>
</html>