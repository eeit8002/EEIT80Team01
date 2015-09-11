<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登出</title>
</head>
<body>

<c:set var="memberName" value="${ LoginOK.supportername }" />

<c:remove var="LoginOK" scope="session" />

<c:set var="funcName" value="OUT" scope="session"/>

<c:set var="logoutMessage" scope="request">
<font color='blue' ><BR>
您已經登出<BR>
</font>
</c:set>
<%
  session.invalidate();
%>
<jsp:forward page="/support/index.jsp"/>
</body> 
</html>