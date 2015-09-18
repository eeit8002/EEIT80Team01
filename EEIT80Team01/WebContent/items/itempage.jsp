<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page import="items.model.*,item.category.model.*,item.bid.model.*" %>
<!DOCTYPE html>
	<c:if test="${!empty param.itemid}">
		<%
			String itemid = request.getParameter("itemid");
			ItemsBean bean=null;
			ItemCategoryBean icb=null;
			double price=0;
			try {
				int itemId = Integer.parseInt(itemid);
				ItemsService service = new ItemsService();
				bean = service.getOneItemId(itemId);
				if(bean!=null){
					ItemCategoryService ics = new ItemCategoryService();
					icb = ics.getOneCategory(bean.getItemCategory());
					BidLogDAOService bls = new BidLogDAOService();
					BidLogBean blb = bls.getTopPrice(itemId);
					if(blb!=null){
						price = blb.getBidPrice();
					} else{
					 	price = bean.getStartPrice();
					}
				}
			} catch (NumberFormatException e) {
				bean = null;
			}
			pageContext.setAttribute("item",bean);
			pageContext.setAttribute("itemCategory", icb);
			pageContext.setAttribute("price", price);
			%>
	</c:if>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<%@include file="/include/include" %>
<style>
.navbar{ 
 	margin-bottom: 0px;
}
body { padding-top: 50px; }
#contentPart { padding-top: 50px; }
</style>
<c:choose>
	<c:when test="${!empty item}">
		<title>${item.title}</title>
	
	</c:when>
	<c:otherwise>
		<title>查無此商品</title>	
	</c:otherwise>
</c:choose>
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
	        	<c:choose>
				<c:when test="${!empty item}">
				<c:if test="${!empty LoginOK}">
					賣家：<a href="${pageContext.request.contextPath}/member/default.jsp?id=${item.seller}" target="_blank">${item.seller}</a><br>
	        	</c:if>
	        	<c:if test="${empty LoginOK}">
	        		賣家：${item.seller}<br>
	        	</c:if>
	        		商品分類：${itemCategory.categoryName}<br>
	        		商品主題：${item.title}	<br>
	        		商品價格：${price}<br>
	        		<fmt:formatDate value="${item.endTime}" var="formatDate" type="date" pattern="yyyy年MM月dd日HH時mm分" />	
	        		結標時間：${formatDate}<br>
	        		最小加價：${item.bid}<br>
	        		直購價：${directPrice}<br>
	        		<c:if test="${!empty LoginOK}">
	        		<form action="${pageContext.request.contextPath}/product/bid.do" method="post">
	        			<input type="number" min="${price + item.bid}" value="${price + item.bid}" name="bidPrice">
	        			<input type="hidden" name="itemId" value="${item.itemId}">
	        			<input type="hidden" name="action" value="bid">
	        			<button type="submit" class="btn btn-primary">出價</button>
	        		</form>
	        		<form action="${pageContext.request.contextPath}/product/bid.do" method="post">
	        			<input type="hidden" name="itemId" value="${item.itemId}">
	        			<input type="hidden" name="action" value="direct">	        			
	        			<button type="submit" class="btn btn-primary">直購</button>
	        		</form>	        
	        		</c:if>
	        		<c:if test="${empty LoginOK}">
	        			<a href="${pageContext.request.contextPath}/member/login.do?itemid=${item.itemId}">若要購買此商品請先登入</a><br>
	        		</c:if>	        				
	        		<h4>商品內容描述：</h4>
	        		${item.itemDescribe}
				</c:when>
				<c:otherwise>
					<h3>查無此商品</h3>
				</c:otherwise>
				</c:choose>	        
 			 </div>
			<%@include file="/include/blockPart" %>
         </div>
        </div>
	</article>

</body>
</html>