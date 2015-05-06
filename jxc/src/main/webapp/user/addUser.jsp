<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="<%=request.getContextPath() %>/js/nui/nui.js"></script>
<link rel="stylesheet" href="<%=request.getContextPath() %>/css/common.css"/>
</head>
<body>
	<fieldset style="width:95%;height:90%;"> 
		<legend><span>商品入库/出库操作</span></legend>
		<div id="form">
			<table style="width:100%;height:90%;table-layout:fixed;" class="nui-form-table">
				<tr>
					<td class="nui-form-label" style="text-align:right;width:20%" >
						<label >用户名:</label>
					</td>
					<td style="text-align:left;width:30%" >
             			 <input name="username"  class="nui-textbox"/>
            		</td>
            		<td class="nui-form-label" style="text-align:right;width:20%">
						<label>密码:</label>
					</td>
					<td  style="text-align:left;">
						<input class="nui-textbox" name="password"/>
					</td>
				</tr>
				<tr>
					<td class="nui-form-label" style="text-align:right;">
						<label >用户姓名:</label>
					</td>
					<td style="text-align:left;">
						<input class="nui-textbox" name="name"/>
            		</td>
            		
            		<td class="nui-form-label" style="text-align:right;">
						<label id="churuku">年龄:</label>
					</td>
					<td style="text-align:left;" >
						<input class="nui-textbox" name="age"/>
            		</td>
				</tr>
				<tr>
            		<td class="nui-form-label" style="text-align:right;">
						<label id="churuku">email:</label>
					</td>
					<td style="text-align:left;" >
						<input class="nui-textbox" name="email" vtype="email"/>
            		</td>
            		<td class="nui-form-label" style="text-align:right;">
						<label id="churuku">QQ:</label>
					</td>
					<td style="text-align:left;" >
						<input class="nui-textbox" name="qq"/>
            		</td>
				</tr>
				
				<tr>
					<td class="nui-form-label" style="text-align:right;">
						<label>电话号码:</label>
					</td>
					<td style="text-align:left;" >
						<input class="nui-textbox" name="phonenumber"/>
            		</td>
					
            		<td class="nui-form-label" style="text-align:right;">
						<label id="churuku">是否管理员:</label>
					</td>
					<td style="text-align:left;" >
						<input class="nui-combobox" value='N' name="isadmin" data="[{id:'Y',text:'是'},{id:'N',text:'否'}]"/>
            		</td>
				</tr>
				
				
				<tr>
            		<td class="nui-form-label" style="text-align:right;">
						<label id="churuku">备注:</label>
					</td>
					<td style="text-align:left;"  colspan="3">
						<input class="nui-textarea" name="info" width="100%"/>
            		</td>
				</tr>
				
				<tr height="30px"><td></td><td></td><td></td><td></td></tr>
				<tr>
					<td  colspan="4" style="text-align:center;">
						<a class="nui-button"  onclick="doSave">保存</a>
                        <a class="nui-button"  onclick="doCancel">取消</a>
				</tr>
			</table>
		</div>	
	</fieldset>
	<script>
		function doSave(){
			var form = new nui.Form("form");
			var data = nui.encode(form.getData());
			nui.ajax({
				url:"<%=request.getContextPath() %>/user/add",
	 		 	type:'POST',
	            data:{data:data},
	  		 	success:function(text){
	  		 		nui.alert("操作成功！");
	  		 		closeWindow("ok");
	  		 	},
	  		 	error : function(text){
	  		 		debugger;
	  		 		alert("网络请求错误:"+text)
	  		 	}
			})
		}
		function closeWindow(action) {   
	        if (window.CloseOwnerWindow) {
	            return window.CloseOwnerWindow(action);
	        } else {
	        	window.close();  
	        }          
	    }
		function doCancel(e){
			closeWindow("cancel")
		}
	</script>
</body>
</html>