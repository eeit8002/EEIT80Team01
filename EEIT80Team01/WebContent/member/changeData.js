		$().ready(function(){
			
		    $("#reset").click(function() {
		    	$("#form").validate().resetForm();
		    });
			
		
			$("#form").validate({
					submitHandler:function(form) {
						form.submit();
					},
					rules:{						
						password:{
							minlength: 5
						},
						passwordCheck:{
							minlength: 5,
							equalTo:"#password"
						},
						firstName:{
							required:true
						},
						lastName:{
							required:true
						},
						email:{
							required: true,
						    email: true
						}
					},//end of rules
					messages: {
						password:{
							minlength:"密碼至少五個字"
						},
						passwordCheck:{
							minlength: "密碼至少五個字",
							equalTo:"兩次密碼不相同，請確認密碼"
						},
						firstName:{
							required: "名字未輸入"
						},
						lastName:{
							required: "姓氏未輸入"
						},
						email:{
							required: "請輸入E-mail",
						    email: "請輸入正確的E-mail格式"
						}
					}
			
			});//end of validate
		})