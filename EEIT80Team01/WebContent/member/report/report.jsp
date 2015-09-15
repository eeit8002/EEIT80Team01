<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>檢舉會員</title>
	<style>
		fieldset{
			width: 600px;
		}
		.tag{ 
			display: inline-block;
		 	width: 125px;
		 	text-align: right;
		 	}
	</style>
	<script src="http://cdn.ckeditor.com/4.5.3/basic/ckeditor.js"></script>
</head>
<body>
		<form method="post" class="cmxform" id="form" action="">
		<fieldset>
			<legend>檢舉會員</legend>
			<p>
				<label class="tag">被檢舉人帳號：</label>
				<input type="text" id="prosecutor" name="prosecutor">
			</p>
			<p>
				<label class="tag">網址連結：</label>
				<input type="text" id="url" name="url">
			</p>
			<p>
				<label class="tag">檢舉理由：</label>
				<input type="text" id="reason" name="reason"><br>
				<textarea name="messagebody" id="editor1" rows="10" cols="60">
            	</textarea>
			<script>
				CKEDITOR.replace( 'editor1' );
			</script>
			<p>
             <label class="tag"></label>
			<input type="submit" id="submit" value="送出">
			<input type="reset" id="reset" value="清除">
		</fieldset>	
	</form>
</div>


</body>
</html>