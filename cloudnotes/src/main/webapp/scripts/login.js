$(function(){
	//1.登录功能
	$("#login").click(checkLogin);
	//2.注册功能
	$("#regist_button").click(addUser);
});
function checkLogin(){
		//获取请求参数
		var name = $("#count").val().trim();
		var password = $("#password").val().trim();
		$("#count_span").html("");
		$("#password_span").html("");
		//检查格式
		var ok = true;
		if(name==""){
			ok = false;
			$("#count_span").html("用户名为空");
		}
		if(password==""){
			ok = false;
			$("#password_span").html("密码为空");
		}
		//发送ajax请求
		if(ok){
			$.ajax({
				url:base_Path+"/user/login.do",
				type:"post",
				data:{"name":name,"password":password},
				dataType:"json",
				success:function(result){
					//成功
					if(result.status==0){
						var user = result.data;
						window.location.href="edit.html";
					}else if(result.status==1){
					//用户名错	
					$("#count_span").html(result.msg);
					}else if(result.status==2){
					//密码错误
					$("#password_span").html(result.msg);
					}
				},
				error:function(){
					alert("登陆异常");
				}
			});
		}
	}


function addUser(){
	//获取请求参数
	var name = $("#regist_username").val().trim();
	var nick = $("#nickname").val().trim();
	var password = $("#regist_password").val().trim();
	var f_password = $("#final_password").val().trim();
	//检查格式
	//清空消息
	$("#warning_1 span").html("");
	$("#warning_2 span").html("");
	$("#warning_3 span").html("");
	var ok = true;
	if(name==""){
		ok = false;
		$("#warning_1").show();
		$("#warning_1 span").html("用户名为空");
	}
	if(password==""){
		ok = false;
		$("#warning_2").show();
		$("#warning_2 span").html("密码为空");
	}else if(password.length<6){
		ok = false;
		$("#warning_2").show();
		$("#warning_2 span").html("密码长度较短");
	}
	if(f_password==""){
		ok = false;
		$("#warning_3").show();
		$("#warning_3 span").html("确认密码为空");
	}else if(f_password!=password){
		ok = false;
		$("#warning_3").show();
		$("#warning_3 span").html("与密码不一致");
	}
	//发送ajax请求
	$.ajax({
		url:base_Path+"/user/add.do",
		type:"post",
		data:{"name":name,"nick":nick,"password":password},
		dataType:"json",
		success:function(result){
		    if(result.status==0){//成功
		    	alert(result.msg);
		        //转向登录页面
		        $("#back").click();
		    }else if(result.status==1){//用户名被占
		    	$("#warning_1").show();
				$("#warning_1 span").html(result.msg);
		    } 
		},
		error:function(){
			alert("注册异常");
		}
	});
}