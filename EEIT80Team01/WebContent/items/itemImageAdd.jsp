<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>商品圖片上傳</title>
</head>
<body>
	<form action="${pageContext.request.contextPath }/items/itemImageAdd.controller" method="post" enctype="multipart/form-data">
		上傳圖片： <input type="file" name="image"><br><br>

		<input type="submit" value="上傳">
		<input type="hidden" name="action" value="upload">
		<font color="red" size="-1"><span class="error">${error.UploadError }</span></font>
	</form>
</body>
</html>