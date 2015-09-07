$().ready(function(){
	 $("#reset").click(function() {
	    	$("#form").validate().resetForm();
	    });
	$("#form").validate({
			submitHandler:function(form) {
				form.submit();
			},
			rules:{
				username:{
					required:true,
					minlength: 5												
				},//end of username
				password:{
					required:true,
					minlength: 5
				}				
			},
			messages:{
				username:{
					minlength: "帳號至少五個字",

				},
				password:{
					minlength:"密碼至少五個字"
				}
			}
	});
	
	
		
});