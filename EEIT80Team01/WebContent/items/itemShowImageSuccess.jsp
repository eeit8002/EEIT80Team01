<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>圖片讀取成功</title>
</head>
<body>
<h1>圖片讀取成功</h1>
<img height="200" width="200" border="1" src="${pageContext.request.contextPath }/items/itemShowImage.controller?imageNo=${imageNo}"></img>
</body>
</html>