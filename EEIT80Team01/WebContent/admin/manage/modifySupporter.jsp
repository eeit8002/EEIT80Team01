<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改客服資料</title>
</head>
<body>
	<div id="main">
		<form method="post" action="modifySupporter.do">
			<fieldset>
				<legend>修改客服帳號</legend>
				<p>
					<label class="tag" for="user">帳號：</label> <input type="text"
						id="supportername" name="supportername" title="請輸入客服帳號" value="${supporterInfo.supportername}">
				</p>
				<p>
					<label class="tag" for="password">密碼：</label> <input
						type="password" id="password" name="password" title="請輸入密碼" value="${supporterInfo.password}">
				</p>
				<p>
					<label class="tag" for="password">確認密碼：</label> <input
						type="password" id="passwordCheck" name="passwordCheck"
						title="再次輸入密碼" value="${supporterInfo.password}">
				</p>
				<p>
					<label class="tag" for="employeeid">客服編號：</label> <input
						type="text" id="employeeid" name="employeeid" title="輸入客服編號" value="${supporterInfo.employeeid}">
				</p>
				<p>
					<label class="tag" for="lastname">姓氏：</label>
					<input type="text" id="lastname" name="lastname" title="請輸入客服人員的姓氏" value="${supporterInfo.lastname}">
				</p>
				<p>
					<label class="tag" for="firstname">名字：</label>
					<input type="text" id="firstname" name="firstname" title="請輸入客服人員的名字" value="${supporterInfo.firstname}">
				</p>
				<p>
					<label class="tag"></label>
					<input type="submit" id="submit" value="送出">
					<input type="reset" id="reset" value="清除">
				</p>
			</fieldset>
		</form>
	</div>
</body>
</html>