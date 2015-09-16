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
<title>DashBoard</title>
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
	        	<form method="post" class="form-horizontal cmxform" id="form" action="changeData">
				  <div class="form-group" >
				    <label for="username" class="col-sm-3 control-label">帳號：</label>
				    <div class="col-sm-7">
				      <input type="text" class="form-control" id="username" name="username" value="${LoginOK.userName}" readonly>
				    </div>
				  </div>
				  <div class="form-group">
				    <label for="lastName" class="col-sm-3 control-label">姓：</label>
				    <div class="col-sm-7">
				      <input type="text" class="form-control" id="lastName" name="lastName" placeholder="請輸入姓" value="${LoginOK.lastName}">
				    </div>
				  </div>
				  <div class="form-group">
				    <label for="firstName" class="col-sm-3 control-label">名：</label>
				    <div class="col-sm-7">
				      <input type="text" class="form-control" id="firstName" name="firstName" placeholder="請輸入名" value="${LoginOK.firstName}">
				    </div>
				  </div>
				  <div class="form-group">
				    <label for="email" class="col-sm-3 control-label">E-mail：</label>
				    <div class="col-sm-7">
				      <input type="email" class="form-control" id="email" name="email" placeholder="請輸入E-mail信箱" value="${LoginOK.email}">
				    </div>
				  </div>
				  <div class="form-group">
				    <div class="col-sm-offset-3 col-sm-7">
				      <button type="submit" id="submit" class="btn btn-default">送出</button>
				      <button type="button" id="reset" class="btn btn-default">還原</button>
				    </div>
				  </div>
				</form>
	        </div>
			<%@include file="/include/blockPart" %>
         </div>
        </div>
	</article>
	<footer>
	
	</footer>
	<%@include file="/include/modal" %>
	
<script src="$(pageContext.request.contextPath)/scripts/changeData.js"></script>
<script>
$("#sectionItem1").addClass("active");
</script>
</body>
</html>