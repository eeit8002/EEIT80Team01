<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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
<title>會員中心</title>
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
	        	<h2>會員基本資料</h2>	        	
				<dl>
					<dt>會員帳號</dt>
					<dd>${LoginOK.userName}</dd>
					<dt>性別</dt>
					<c:choose>
  					  	<c:when test="${LoginOK.gender==1}">
   	     					<dd>男</dd>     			
    					</c:when>    
    					<c:otherwise>
							<dd>女</dd>
    					</c:otherwise>
					</c:choose>
					<dd></dd>
				</dl>
	        </div>
			<%@include file="/include/blockPart" %>
         </div>
        </div>
	</article>
	<footer>
	
	</footer>
	<%@include file="/include/modal" %>


</body>
</html>