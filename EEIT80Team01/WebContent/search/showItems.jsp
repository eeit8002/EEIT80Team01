<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<link rel='stylesheet' href='../../css/styles.css'  type="text/css" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Show All Members</title>
</head>
<body>

<div align="center">
		    <c:forEach var="mem"  varStatus="statusX" items="${items}">
                   <c:if test="${statusX.first}" >
                        <c:out value="<table border='1' cellspacing='5' cellpadding='5' >" escapeXml="false"/>
      		          	    <tr bgcolor="CCCC00">
			                    <td  colspan='5' ALIGN='CENTER'>商品資訊</td>
			                </tr>
			                <tr  bgcolor="CCCC00">
			                    <th>商品名稱</th><th>起標價格</th><th>直購價格</th><th>結標時間</th><th>商品描述</th>
			                </tr>
                    </c:if>		         
                    <c:choose>
                             <c:when test="${ statusX.count % 2 == 0 }">
                                  <c:set var="colorVar" value="99ddff" />
                             </c:when>
                             <c:otherwise>
                                  <c:set var="colorVar" value="88dd00" />
                             </c:otherwise>
                   </c:choose>
                    
                    <tr bgcolor="${colorVar}">
                      <td>${mem.title}</td>
                    <td>${mem.startPrice}</td>
                    <td>${mem.directPrice}</td>
                    <td>${mem.endTime}</td>
                    <td>${mem.itemDescribe}</td>
                    
<%--                     <td>${mem.username}</td> --%>
<%--                     <td>${mem.passwd}</td> --%>
<%--                     <td>${mem.id}</td> --%>
<%--                     <td>${mem.fname}</td> --%>
<%--                     <td>${mem.lname}</td> --%>
<%--                          <td>${mem.userId}</td> --%>
<%--                          <td>${mem.name} </td> --%>
<%--                          <td>${mem.email}</td> --%>
<%--                          <td>${mem.tel} </td> --%>
<%--                          <td>${mem.experience}</td> --%>
                    </tr>
                     <c:if test="${statusX.last}" >
                        <c:out value="</table>" escapeXml="flase" />
                    </c:if>		                      
		    </c:forEach>
</div>

<jsp:include page="commons/previousPage.jsp" />










</body>
</html>