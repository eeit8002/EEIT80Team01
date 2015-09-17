<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
</head>
<body>
		<c:forEach items="${questionDetail}" var="bean">
			<div>${bean.qno}</div>
			<div>${bean.title}</div>
			<div>${bean.member}</div>
			<div>${bean.msg}</div>
			<div>${bean.qt}</div>
		</c:forEach>
		<form method="post" action="supporterAnswerQuestion.do" id="answerform">
			<input type="submit" value="送出">
			<input type="hidden" name="hiddenqno" value="${bean.qno}">
			<input type="hidden" name="hiddenqmsg" value="${bean.qmsg}">
			<input type="hidden" name="hiddenmember" value="${bean.member}">
			<input type="hidden" name="hiddentitle" value="${bean.title}">
			<input type="hidden" name="hiddenqt" value="${bean.qt}">
		</form>
		<textarea rows="20" cols="100" name="answer" form="answerform"></textarea>
</body>
</html>