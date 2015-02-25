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
	<div id="datagrid1" showPager="true" class="nui-datagrid" allowSortColumn="true" style="width:100%;height:70%;"
		dataField="data" totalField="total" idField="id" url="/price/byproductid" allowResize="true" allowCellValid="true"
		allowCellEdit="true" allowCellSelect="true" multiSelect="true" editNextOnEnterKey="true"  editNextRowCell="true">
	    <div property="columns">
	   		<div type="indexcolumn"></div>
            <div type="checkcolumn"></div>
	    	<div width="15%" headerAlign="center" align="center" width="15%" renderer="operate">操作</div>
	        <div field="price" width="40%"  vtype="float" headerAlign="center" allowSort="true">价格
	        	<input property="editor" class="nui-textbox" style="width:100%;"/>
	        </div>
	        <div field="name" width="40%"  vtype="float"  headerAlign="center" allowSort="true">顾客名称
	        	<input property="editor" class="nui-textbox" style="width:100%;"/>
	        </div>
	    </div>
	</div>
	<script>
		nui.parse();
		var dg = nui.get("datagrid1");
		dg.load({pid:1});
	</script>
</body>
</html>