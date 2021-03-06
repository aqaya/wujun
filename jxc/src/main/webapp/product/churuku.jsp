<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>修改商品记录</title>
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
						<label >条码号:</label>
					</td>
					<td style="text-align:left;width:30%" >
             			 <input id="tiaoma"  class="nui-textbox" enabled="false"/>
            		</td>
            		<td class="nui-form-label" style="text-align:right;width:20%">
						<label>货号:</label>
					</td>
					<td  style="text-align:left;">
						<input class="nui-textbox" id="huohao" enabled="false" />
					</td>
				</tr>
				<tr>
					<td class="nui-form-label" style="text-align:right;">
						<label >商品名称:</label>
					</td>
					<td style="text-align:left;">
						<input class="nui-textbox" id="name" enabled="false" />
            		</td>
            		<td class="nui-form-label" style="text-align:right;">
						<label>单位:</label>
					</td>
					<td style="text-align:left;" >
						<input class="nui-textbox" id="danwei" enabled="false" />
            		</td>
				</tr>
				<tr height="30px"><td></td><td></td><td></td><td></td></tr>
				<tr>
            		<td class="nui-form-label" style="text-align:right;">
						<label style="color:red" id="churuku">入库数量:</label>
					</td>
					<td style="text-align:left;" >
						<input class="nui-textbox" id="num" vtype="required;float"/>
            		</td>
            		
            		<td class="nui-form-label" style="text-align:right;">
						<input class="nui-checkbox" id="ck">
					</td>
					<td style="text-align:left;" >
						<label style="color:red" id="churuku">连续操作</label>
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
		nui.parse();
		var id;
		var op;
		function setData(data){
      		nui.get("huohao").setValue(data.huohao);
      		nui.get("tiaoma").setValue(data.tiaoma);
      		nui.get("name").setValue(data.name);
      		nui.get("danwei").setValue(data.danwei);
      		id = data.id;
      		op = data.op;
			document.getElementById("churuku").innerHTML = "in" == data.op ? "入库数量:" : "出库数量:";
    	}
		function doSave(){
			var ipt = nui.get("num");
			ipt.validate();
			if(!ipt.isValid()){
				alert("输入的数量格式不对！请输入小数！")
				return;
			}
			nui.ajax({
				url:"<%=request.getContextPath() %>/product/churuku",
     		 	type:'POST',
	            data:{
	            	id:id,
	            	num:ipt.getValue(),
	            	op:op
	            },
	            cache: false,
      		 	success:function(text) {
      		 		if(text == 'false' && op == "out"){
      		 			nui.alert("出库失败，可能是库存不足导致的！")
      		 			return;
      		 		}
      		 		var ck = nui.get("ck");
      		 		if(ck.checked)
      		 			return;
      		 		closeWindow("ok")
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