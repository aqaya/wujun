<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="<%=request.getContextPath() %>/js/nui/nui.js"></script>
<link rel="stylesheet" href="<%=request.getContextPath() %>/css/common.css"/>
<style type="text/css">
	a{
		text-decoration: underline;
		color:blue;
	}
	a:hover{
		cursor: pointer;
	}
</style>
</head>
<body>
    <div class="nui-panel" title="查询条件" style="width:100%;" showToolbar="true" showFooter="false">
	    <div id="queryForm">
	    	<table id="tableSearch" style="width:100%;">
            <tr>
                <td style="text-align:right">条码：</td>
                <td>  
                   <input class="nui-textbox" name="tiaoma"/>
                </td>
                 <td style="text-align:right;width=80px">货号：</td>
                <td>  
                    <input class="nui-textbox" name="huohao"/>
                </td>
            </tr>
             <tr>
                <td style="text-align:right;width=80px">商品名称：</td>
                <td>  
                    <input class="nui-textbox" name="name"/>
                </td>
                <td style="text-align:right;width=80px"> </td>
                <td>  
                    
                </td>
            </tr>
            <tr>
                <td style="text-align:center;width=80px" colspan="4">  
                    <a class="nui-button" onclick="doSearch">查询</a>
                </td>
            </tr>
        </table>
	    </div>
    </div>
    
     <div style="width:100%;">
        <div class="nui-toolbar" style="border-bottom:0;padding:0px;">
            <table style="width:100%;">
                <tr>
                    <td style="width:100%;">
                        <a class="nui-button" iconCls="icon-add" onclick="addRow" plain="true">增加</a>
                        <a class="nui-button" iconCls="icon-remove" onclick="removeRow" plain="true">删除</a>
                        <span class="separator"></span>
                        <a class="nui-button" iconCls="icon-save" onclick="saveData" plain="true">保存</a>            
                    </td>
                </tr>
            </table>           
        </div>
    </div>
	<div id="datagrid1" showPager="true" class="nui-datagrid" allowSortColumn="true" style="width:100%;height:70%;"
		dataField="data" totalField="total" idField="id" url="../product/query" allowResize="true" allowCellValid="true"
		allowCellEdit="true" allowCellSelect="true" multiSelect="true" editNextOnEnterKey="true"  editNextRowCell="true">
	    <div property="columns">
	   		<div type="indexcolumn"></div>
            <div type="checkcolumn"></div>
	    	<div width="15%" headerAlign="center" align="center" width="15%" renderer="operate">操作</div>
	        <div field="tiaoma" width="15%"  vtype="required" headerAlign="center" allowSort="true">条码号
	        	<input property="editor" class="nui-textbox" style="width:100%;"/>
	        </div>    
	        <div field="huohao" width="15%" headerAlign="center" allowSort="true">货号
	        	<input property="editor" class="nui-textbox" style="width:100%;"/>
	        </div>
	        <div field="name" width="15%"  vtype="required" headerAlign="center" allowSort="true">商品名称
	        	<input property="editor" class="nui-textbox" style="width:100%;"/>
	        </div>
	        <div field="jinjia" width="10%"  vtype="float" headerAlign="center" allowSort="true">进价
	        	<input property="editor" class="nui-textbox" style="width:100%;"/>
	        </div>
	        <div field="shoujia" width="10%"  vtype="float"  headerAlign="center" allowSort="true">售价
	        	<input property="editor" class="nui-textbox" style="width:100%;"/>
	        </div>
	        <div field="kucun" width="10%" headerAlign="center"  vtype="float"  allowSort="true">库存
	        	<input property="editor" class="nui-textbox" style="width:100%;" vtype="int"/>
	        </div>
	        <div field="xiaoliang" width="10%" headerAlign="center" vtype="float" allowSort="true">销量
	        	<input property="editor" class="nui-textbox" style="width:100%;"/>
	        </div>
	        <div field="danwei" width="5%" headerAlign="center" align="center" allowSort="true">单位
	        	<input property="editor" class="nui-textbox" style="width:100%;"/>
	        </div>
	    </div>
	</div>
	<script>
		nui.parse();
		var dg = nui.get("datagrid1");
		dg.load();
		function doSearch(){
			var form = new nui.Form("queryForm");
			var data = form.getData();
			dg.load(data);
		}
		function operate(e){
			var r = e.record;
			var a = '<a text-decoration="underline"; onclick=\'ruku("'+r.id+'","'+r.tiaoma+'","'+r.huohao+'","'+r.name+'","'+r.danwei+'")\'>入库</a>';
			a += '&nbsp;&nbsp;<a text-decoration="underline"; onclick=\'chuku("'+r.id+'","'+r.tiaoma+'","'+r.huohao+'","'+r.name+'","'+r.danwei+'")\'>出库</a>'
			return a;
		}
		function ruku(id,tiaoma,huohao,name,danwei){
			if(!id){
				alert("不能入库！");
				return;
			}
			nui.open({
       			 url : "<%=request.getContextPath() %>/product/churuku.jsp",
       			 title : "商品入库",
       			 type : 'POST',
       			 width : 500,
       			 height : 300,
       			 onload : function () {
         			 var iframe = this.getIFrameEl();
                   	 iframe.contentWindow.setData({
                   		id:id,
                   		tiaoma:tiaoma,
                   		huohao:huohao,
                   		name:name,
                   		danwei:danwei,
                   		op:"in"
                   	 });
         		 },
				ondestroy : function(action) {
					if (action == "ok")
						dg.reload();
				}
	        });
		}
		
		
		function chuku(id,tiaoma,huohao,name,danwei){
			if(!id){
				alert("不能出库！");
				return;
			}
			nui.open({
      			 url : "<%=request.getContextPath() %>/product/churuku.jsp",
      			 title : "商品出库",
      			 type : 'POST',
      			 width : 500,
      			 height : 300,
      			 onload : function () {
        			 var iframe = this.getIFrameEl();
                  	 iframe.contentWindow.setData({
                  		id:id,
                  		tiaoma:tiaoma,
                  		huohao:huohao,
                  		name:name,
                  		danwei:danwei,
                  		op:"out"
                  	 });
        		 },
				ondestroy : function(action) {
					if (action == "ok")
						dg.reload();
				}
	        });
		}
		 function addRow() {          
	            var newRow = { name: "新增商品" ,xiaoliang:0,danwei:"个"};
	            dg.addRow(newRow, 0);
	            dg.beginEditCell(newRow, "tiaoma");
	        }
	        function removeRow() {
	            var rows = dg.getSelecteds();
	            if (rows.length > 0) {
	                dg.removeRows(rows, true);
	            }
	        }
	        function saveData() {
	        	dg.validate();
	            if (dg.isValid() == false) {
	                alert("请检查输入内容是否符合要求!");
	                var error = dg.getCellErrors()[0];
	                dg.beginEditCell(error.record, error.column);
	                return;
	            }
	        	
	            var data = dg.getChanges();
	            var json = nui.encode(data);
	            
	            dg.loading("保存中，请稍后......");
	            $.ajax({
	                url: "<%=request.getContextPath() %>/product/save",
	                data: { data: json },
	                type: "post",
	                success: function (text) {
	                    dg.reload();
	                },
	                error: function (jqXHR, textStatus, errorThrown) {
	                    alert(jqXHR.responseText);
	                }
	            });
	        }
	        dg.on("celleditenter", function (e) {
	            var index = dg.indexOf(e.record);
	            if (index == dg.getData().length - 1) {
	                var row = {};
	                dg.addRow(row);
	            }
	        });
	</script>
</body>
</html>