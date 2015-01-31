<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="/js/nui/nui.js"></script>
</head>
<body style="height:100%">
	<div id="datagrid1" showPager="true" class="nui-datagrid" allowSortColumn="true" style="width:100%;height:70%;"
		dataField="data" totalField="total" idField="id" url="/price/byproductid" allowResize="true" allowCellValid="true"
		allowCellEdit="true" allowCellSelect="true" multiSelect="true" editNextOnEnterKey="true"  editNextRowCell="true">
	    <div property="columns">
	   		<div type="indexcolumn"></div>
            <div type="checkcolumn"></div>
	    	<div width="15%" headerAlign="center" align="center" width="15%" renderer="operate">操作</div>
	    	<!--  
	        <div field="id" width="15%"  vtype="required" headerAlign="center" allowSort="true">id
	        	<input property="editor" class="nui-textbox" style="width:100%;"/>
	        </div>    
	        <div field="pid" width="15%" headerAlign="center" allowSort="true">商品id
	        	<input property="editor" class="nui-textbox" style="width:100%;"/>
	        </div>
	        <div field="cid" width="15%"  vtype="required" headerAlign="center" allowSort="true">顾客id
	        	<input property="editor" class="nui-textbox" style="width:100%;"/>
	        </div>
	        -->
	        <div field="price" width="40%"  vtype="float" headerAlign="center" allowSort="true">价格
	        	<input property="editor" class="nui-textbox" style="width:100%;"/>
	        </div>
	        
	        <div field="name" width="40%"  vtype="float"  headerAlign="center" allowSort="true">顾客名称
	        	<input property="editor" class="nui-textbox" style="width:100%;"/>
	        </div>
	        <!--
	        <div field="kucun" width="10%" headerAlign="center"  vtype="float"  allowSort="true">库存
	        	<input property="editor" class="nui-textbox" style="width:100%;" vtype="int"/>
	        </div>
	        <div field="xiaoliang" width="10%" headerAlign="center" vtype="float" allowSort="true">销量
	        	<input property="editor" class="nui-textbox" style="width:100%;"/>
	        </div>
	        <div field="danwei" width="5%" headerAlign="center" align="center" allowSort="true">单位
	        	<input property="editor" class="nui-textbox" style="width:100%;"/>
	        </div>
	        -->
	    </div>
	</div>
	<script>
		nui.parse();
		var dg = nui.get("datagrid1");
		dg.load({pid:1});
	</script>
</body>
</html>