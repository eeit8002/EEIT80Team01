<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<%@include file="/include/include" %>
<style>
body { padding-top: 50px; }
.navbar{ 
 	margin-bottom: 0px;
}
#alertBar{margin-bottom:0px;}
#contentPart { padding-top: 50px; }
</style>
<title>DashBoard</title>
</head>
<body>
	<header>
		<%@include file="/include/header" %>
	</header>
	<article>
		<div id="alertBar"class="alert alert-danger alert-dismissible text-center" role="alert">
		  <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
		  <strong>密碼修改失敗!</strong>
		</div>
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
				    <label for="oldPassword" class="col-sm-3 control-label">舊密碼：</label>
				    <div class="col-sm-7">
				      <input type="password" class="form-control" id="oldPassword" name="oldPassword" placeholder="請輸入密碼" >
				    </div>
				  </div>
				  <div class="form-group">
				    <label for="password" class="col-sm-3 control-label">新密碼：</label>
				    <div class="col-sm-7">
				      <input type="password" class="form-control" id="password" name="password" placeholder="請輸入密碼" >
				    </div>
				  </div>
				  <div class="form-group">
				    <label for="passwordCheck" class="col-sm-3 control-label">確認新密碼：</label>
				    <div class="col-sm-7">
				      <input type="password" class="form-control" id="passwordCheck" name="passwordCheck" placeholder="請再次輸入密碼" >
				    </div>
				  </div>
				  <div class="form-group">
				    <div class="col-sm-offset-3 col-sm-7">
				      <button type="submit" id="submit" class="btn btn-default">送出</button>
				      <button type="button" id="reset" class="btn btn-default">清除</button>
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
</body>
<script>
$("#sectionItem2").addClass("active");
</script>
</html>