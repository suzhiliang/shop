// JavaScript Document
$(function(){
	 $("#click").click(function(){
		var today=new Date(); 
		var h=today.getHours(); 
		var m=today.getMinutes();
		var number = Math.random()+h+m;
		var email=/^([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+@([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+\.[a-zA-Z]{2,3}$/;
	 	if($("#username").val()!=""&&$("#password").val()!=""&&$("#repassword").val()!=""&&$("#safecode").val()!=""&&$("#email").val()!=""){
			if($("#password").val()!=$("#repassword").val()){
				alert("两次密码输入不一致！")
				$("#repassword").val("")
				return false
			}else if($("#password").val()==$("#username").val()){
				alert("为保证安全，密码和用户名不要一样")
				$("#password").val("")
				$("#repassword").val("")
				return false
			}else if(!email.test($("#email").val())){
				alert("邮箱格式不正确！")
				return false
			}else{
				var json = {name:$("#username").val(),pwd:$("#password").val(),safecode:$("#safecode").val(),email:$("#email").val(),number:number};
				$.ajax({
					type:"POST",
					url:"../add.do",
					dataType:"json",     
					contentType:"application/json",     
					data:JSON.stringify(json),
					success:function(data){								
						if(data.result == "fail"){
							$("#msg").html("<font color=red >该用户名已被注册</font>");
							$("#password").val("")
							$("#username").val("")
						}else if(data.result=="wrong"){
							alert("验证码错误")
							$("image").src = "../safecode.do?id="+Math.random;
							$("#safecode").val("")
						}else{
							alert(data.result)
							window.top.location.href = "login.jsp?serial="+number;
						}		
					}
				});		
				return true;
			}
		}else{
			alert("请务必填写完整信息");
			return false;
		}
	 });		
});

$(function(){
	$("flush").click(function(){
		$("image").src = "../safecode.do?id="+Math.random;
	});
});