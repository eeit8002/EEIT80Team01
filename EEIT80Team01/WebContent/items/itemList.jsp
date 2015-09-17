<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.*" %>
<%@ page import="items.model.*" %>
<%
	ItemsService service = new ItemsService();
	List<ItemsBean> list = service.select(null);
	pageContext.setAttribute("list", list);
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>我的商品清單</title>
</head>
<body>
	<table border="1">
		<tr>
			<th>商品圖片</th>
			<th>商品名稱</th>
			<th>最高出價金額</th>
			<th>最高出價者</th>
			<th>出價次數</th>
			<th>剩餘時間</th>
			<th>追蹤數</th>
		</tr>
		
		<c:forEach var="item" items="${list }">
			<tr>
				<td>xx商品圖片</td>
				<td>${item.title }</td>
				<td>xx最高出價金額</td>
				<td>xx最高出價者</td>
				<td>xx出價次數</td>
				<td>xx剩餘時間</td>
				<td>xx追蹤數</td>
				<td>
			 	 <FORM METHOD="post" ACTION="${pageContext.request.contextPath }/items/itemSelectOne.controller">
				     <input type="submit" value="修改商品">
				     <input type="hidden" name="xxx" value="${item.itemId}">
				     <input type="hidden" name="action"	value="getOne_For_Update">
			     </FORM>
			     
			</td>
				<td>
					<form method="post" action="${pageContext.request.contextPath }/items/itemList.controller">
						<input type="submit" value="刪除">
					    <input type="hidden" name=deleteButton value="${item.itemId}">
					    <input type="hidden" name="action"value="delete">
				    <font color="red" size="-1"><span class="error">${error.deleteError }</span></font>
					</form>
					
				</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>