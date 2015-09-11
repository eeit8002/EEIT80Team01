<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>發送訊息</title>
<%@include file="/css/cssforvalidate.file" %>
<style type="text/css">
	form{
		width:75%;
	}
	.tag{ 
		display: inline-block;
		width: 115px;
		text-align: right;
		}
</style>
<script src="http://cdn.ckeditor.com/4.5.3/basic/ckeditor.js"></script>
</head>
<body>
	<form>
		<fieldset>
			<legend>發送訊息</legend>
			<label class="tag">收件者帳號：</label><input type="text" name="receiver"><br>
			<label class="tag">信件主旨：</label><input type="text" name="messageTitle"><br>
       		<textarea name="messageBody" id="editor1" rows="10" cols="60">
            </textarea>
			<script>
				CKEDITOR.replace( 'editor1' );
			</script>
			<label class="tag"></label>
			<input type="submit" id="submit" value="送出">
			<input type="reset" id="reset" value="清除">
		</fieldset>
	</form>
</body>
</html>