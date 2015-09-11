<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="https://ajax.googleapis.com/ajax/libs/jqueryui/1.11.4/themes/smoothness/jquery-ui.css"/>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>商品上架</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.11.4/jquery-ui.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/scripts/jquery.form.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/scripts/jquery.validate.min.js"></script>
<style type="text/css"></style>
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
<form action="${pageContext.request.contextPath }/items/itemAdd.controller" method="post" > 
	<table>
		<tr>
			<td>商品名稱</td>
			<td><input type="text" name="title" value="${param.title }"></td>
			<td><font color="red" size="-1"><span class="error">${error.titleError }</span></font></td>
		</tr>
		<tr>
			<td>底價</td>
			<td><input type="text" name="startPrice" value="${param.startPrice }"></td>
		</tr>
		<tr>
			<td>直購價</td>
			<td><input type="text" name="directPrice" value="${param.directPrice }"></td>
			<td><font color="red" size="-1"><span class="error">${error.directPriceError }</span></font></td>
		</tr>
		<tr>
			<td>加價金額</td>
			<td><input type="text" name="bid" value="${param.bid }"></td>
			<td><font color="red" size="-1"><span class="error">${error.bidError }</span></font></td>
		</tr>
		<tr>
			<td>結標時間</td>
			<td><input type="text" name="endTime" value="${param.endTime }"></td>
			<td><font color="red" size="-1"><span class="error">${error.endTimeError }</span></font></td>
		</tr>
		<tr>
			<td>商品狀態</td>
			<td><input type="text" name="itemStatus" value="${param.itemStatus }"></td>
		</tr>
<!-- 		<tr> -->
<!-- 		<td> -->
			
<!-- 			<input type="submit" name="itemsButton" value="Update"> -->
<!-- 		</td> -->
<!-- 		<td> -->
<!-- 			<input type="submit" name="itemsButton" value="Delete"> -->
			
<!-- 		</td> -->
<!-- 	</tr> -->
	</table>
	<input type="submit" name="itemsButton" value="Insert">
	<input type="button" value="Clear" onclick="clearForm()">
<h3><font color="red" size="-1"><span class="error" >${error.action }</span></font></h3>

</form>
</body>
</html>