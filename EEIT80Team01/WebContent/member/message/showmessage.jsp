<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@include file="/include/include" %>
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
	
	.navbar{ 
 		margin-bottom: 0px;
	}
body { padding-top: 50px; }
#contentPart { padding-top: 50px; }
</style>
</head>
<body>
	<header>
		<%@include file="/include/header" %>
	</header>
	<article>
	<div class="container-fluid">
	      <div class="row">
			<%@include file="/include/navPart" %>
				<div class="col-md-7 main" id="contentPart">
	<label class="tag">收件者帳號：</label><span>${Message.sender}</span><br>
	<label class="tag">寄件者帳號：</label><span>${Message.receiver}</span><br>
	<label class="tag">信件主旨：</label><span>${Message.messageTitle}</span><br>
	<label class="tag">信件內容：</label><br>
	<div class="msgBody">${Message.messageBody}</div>
		</div>
		<%@include file="/include/blockPart" %>
	</div>
	</div>
	</article>
</body>
</html>