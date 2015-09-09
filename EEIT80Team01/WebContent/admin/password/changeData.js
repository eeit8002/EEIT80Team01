$().ready(function() {

	$("#reset").click(function() {
		$("#form").validate().resetForm();
	});

	$("#form").validate({
		submitHandler : function(form) {
			form.submit();
		},
		rules : {
			oldpassword : {
				minlength : 5
			},
			password : {
				minlength : 5
			},
			passwordCheck : {
				minlength : 5,
				equalTo : "#password"
			}
		},// end of rules
		messages : {
			oldpassword : {
				minlength : "密碼至少五個字"
			},
			password : {
				minlength : "密碼至少五個字"
			},
			passwordCheck : {
				minlength : "密碼至少五個字",
				equalTo : "兩次密碼不相同，請確認密碼"
			}
		}

	});// end of validate
})