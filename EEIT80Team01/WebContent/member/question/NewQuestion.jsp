<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>向客服發問</title>
</head>
<body>
	<textarea form="questionForm" name="qmsg" rows="40" cols="100"></textarea>
	<form action="createQuestion.do" method="post" id="questionForm">
		標題：<input type="text" name="qtitle">
		<input type="submit" value="送出">
	</form>
</body>
</html>