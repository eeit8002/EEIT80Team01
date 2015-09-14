<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>主旨：${Message.messageTitle}</title>
<style type="text/css">

	.tag{ 
		display: inline-block;
		width: 115px;
		text-align: right;
		}
	.msgBody{
		padding-left:115px;
	}
</style>
</head>
<body>
	<label class="tag">收件者帳號：</label><span>${Message.sender}</span><br>
	<label class="tag">寄件者帳號：</label><span>${Message.receiver}</span><br>
	<label class="tag">信件主旨：</label><span>${Message.messageTitle}</span><br>
	<label class="tag">信件內容：</label><br>
	<div class="msgBody">${Message.messageBody}</div>
</body>
</html>