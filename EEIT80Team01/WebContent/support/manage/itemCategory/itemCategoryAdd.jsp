<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>新增商品分類</title>
<script type="text/javascript">
function clearForm(){
	var inputs = document.getElementsByTagName("input");
	for(var i=0; i<=inputs.length; i++){
		if(inputs[i].type == "text"){
			inputs[i].value="";
		}
	}
}
</script>
</head>
<body>
<h3>商品頁面</h3>
<form method="post" action="${pageContext.request.contextPath }/support/manage/itemCategory/itemCategoryAdd.controller">
	<table>
		<tr>
			<td>商品分類編號</td>
			<td><input type="text" name="itemCategory" value="${param.itemCategory }"></td>
			<td><font color="red" size="-1"><span class="error">${error.itemCategoryError }</span></font></td>
		</tr>
		<tr>
			<td>商品分類名稱</td>
			<td><input type="text" name="categoryName" value="${param.categoryName }"></td>
			<td><font color="red" size="-1"><span class="error">${error.categoryNameError }</span></font></td>
		</tr>
	</table>
	<input type="submit" value="新增">
	<input type="hidden" name="categoryButton" value="Insert">
	<input type="button" value="Clear" onclick="clearForm()">
<h3><font color="red" size="-1"><span class="error" >${error.action }</span></font></h3>
</form>
</body>
</html>