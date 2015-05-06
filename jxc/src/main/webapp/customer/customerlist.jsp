<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="<%=request.getContextPath() %>/js/nui/nui.js"></script>
</head>
<body style="height:100%">
	    <div class="nui-panel" title="查询条件" style="width:100%;" showToolbar="true" showFooter="false">
	    <div id="queryForm">
	    	<table id="tableSearch" style="width:100%;">
            <tr>
                <td style="text-align:right">顾客名称：</td>
                <td>  
                   <input class="nui-textbox" name="name"/>
                </td>
                 <td style="text-align:right;width=80px">公司名称：</td>
                <td>  
                    <input class="nui-textbox" name="company"/>
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
		dataField="data" totalField="total" idField="id" url="<%=request.getContextPath() %>/customer/query" allowResize="true" allowCellValid="true"
		allowCellEdit="true" allowCellSelect="true" multiSelect="true" editNextOnEnterKey="true"  editNextRowCell="true">
	    <div property="columns">
	   		<div type="indexcolumn" width="5%"  ></div>
            <div type="checkcolumn" width="5%"  ></div>
	        <div field="name" width="10%"  vtype="float"  headerAlign="center" allowSort="true">顾客名称
	        	<input property="editor" class="nui-textbox" style="width:100%;"/>
	        </div>
	        <div field="address" width="25%" headerAlign="center"  vtype="float"  allowSort="true">地址
	        	<input property="editor" class="nui-textbox" style="width:100%;" vtype="int"/>
	        </div>
	        <div field="company" width="25%" headerAlign="center" vtype="float" allowSort="true">公司
	        	<input property="editor" class="nui-textbox" style="width:100%;"/>
	        </div>
	        <div field="score" width="5%" headerAlign="center" align="center" allowSort="true">评分
	        	<input property="editor" class="nui-textbox" style="width:100%;"/>
	        </div>
	        <div field="info" width="25%" headerAlign="center" align="center" allowSort="true">备注
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
		function addRow() {          
            var newRow = { name: "新增顾客" ,xiaoliang:0,danwei:"个"};
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