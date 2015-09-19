<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>讀取圖檔</title>
</head>
<body>
<form action="${pageContext.request.contextPath }/items/showImage" method="get" >
		<input type="text" name="imageNo" >
		<font color="red" size="-1"><span class="error">${error.ImageError }</span></font>
		<input type="submit" value="送出">
	</form>
</body>
</html>