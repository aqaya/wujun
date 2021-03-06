<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<script src="<%=request.getContextPath() %>/js/nui/nui.js"></script>
<style type="text/css">
	.container{
		width:300px;
		margin:auto;
		align:center;
		v-align:middle;
	}
	.center{
		margin-left:auto;
		margin-right:auto;
		text-align:center
	}
	.error{
		visibility:hidden;
		color:red
	}
</style>
</head>
<body>
<div class="container">
	<h1 class="center">用户登陆</h1>
	<div id="form">
	<table  class="center">
		<tr><td>用户名：</td><td><input class="nui-textbox" name="username" vtype="minLength:5"  required="true"/></td></tr>
		<tr><td align="right">密码：</td><td><input class="nui-password" name="password" vtype="minLength:5" onenter="login" required="true"/></td></tr>
		<tr><td align="center" colspan="2"><a class="nui-button" onclick="login">登陆</a> </td></tr>
	</table> 
		
	</div>
	<div id="error" class="center error">
		登陆失败,用户名不存在或密码错误!
	</div>
</div>
	
	<script>
		nui.parse();
		window.onload = function(){
			if(window!=window.top){
				window.top.location.href = "<%=request.getContextPath() %>/login/login.jsp"
			}
		}
		function login(e){
			var form = new nui.Form("form");
			form.validate();
	        if (form.isValid() == false) return;
			var data = form.getData();
			nui.ajax({
				url:"<%=request.getContextPath() %>/user/login",
     		 	type:'POST',
	            data:data,
	            cache: false,
      		 	success:function(text) {
	      		 	if(text == true) {
	      		 		window.location.href="<%=request.getContextPath() %>/index.jsp";
	      		 	} else {
						document.getElementById("error").style.visibility="visible";
						setTimeout(function(){
							document.getElementById("error").style.visibility="hidden";
						},3000);
	      		 	}
      		 	},
      		 	error : function(text){
      		 		alert("网络请求错误!")
      		 	}
			})
		}
	</script>
</body>
</html>