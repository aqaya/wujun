<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="<%=request.getContextPath() %>/css/common.css"/>
<script src="<%=request.getContextPath() %>/js/nui/nui.js"></script>
</head>
<body>
<div class="container">
	<!--
	<div class="head">
		<div class="nav">
			<div class="welcome"><span>欢迎来到管理系统</span></div>
			<div class="userinfo"><div >username</div><div>退出系统</div></div>
		</div>
	</div>
	-->
	<div class="main">
		<div id="layout" class="nui-layout" style="width: 100%; height: 90%;" borderStyle="border:solid 1px #aaa;">
			<div region="west"  showSplit="false" showHeader="false">
				<div id ="logo" class="logo" align="center">
					<table width="100%" height="100%">
						<tr><td class="form_label"><span style="color:#2050d0;font-size:16px">批发零售管理系统</span></td></tr>
						<tr><td class="form_label" id="user">当前用户：username</td></tr>
						<tr><td><a class="nui-button" onclick="doLogout">注销</a></td></tr>
					</table>
				</div>
				<div id ="left" class="left">
					<ul id="menu" class="menu" height="100%"></ul>
				</div>
			</div>
			<div title="center" region="center">
				<div id ="tabs" class="nui-tabs" activeIndex="0" style="width:100%;height:100%;" bodyStyle="border:0;background:white;">
				</div>
			</div>
		</div>
	</div>
</div>

<script>
	nui.parse();
	var menu = [	
				{title: "商品管理", id:"productmanager"},
				{title: "用户管理", id:"usermanager"},
				{title: "客户管理", id:"customermanager"},
				{title: "价格管理", id:"pricemanager"}
		   ];
			
	var tabs = {
				productmanager:
					[{title: "商品列表", url:"<%=request.getContextPath() %>/product/productlist.jsp", refreshOnClick: true}
				],
				usermanager:
	       			[{title: "用户列表", url:"<%=request.getContextPath() %>/user/userlist.jsp", refreshOnClick: true},
	       			{title: "新增用户", url:"<%=request.getContextPath() %>/user/userlist.jsp", refreshOnClick: true},
	       			{title: "修改用户", url:"<%=request.getContextPath() %>/user/userlist.jsp", refreshOnClick: true}],
				customermanager:
	           		[{title: "客户列表", url: "<%=request.getContextPath() %>/customer/customerlist.jsp", refreshOnClick: true}],
	       		pricemanager:
	           		[{title: "价格管理", url: "<%=request.getContextPath() %>/price/pricelist.jsp", refreshOnClick: true}],
				 };
				 
				 
	function init(){
		initMenu();
		menuListener();
		showTabs("productmanager");
	}
	
	
	function initMenu(){
		$.each(menu,function(index,obj){
			$("#menu").append('<li id = "'+obj.id+'"><a href="#" onclick="menuListener()">'+obj.title+'</a></li>');
		});
	}
			 
	function menuListener() {
		var  menuObj = $("#menu li");
		$.each(menuObj, function(key, val) {
			var link = menuObj[key];
			link.onclick = function() {
				var linkID = $(link).attr("id");
				showTabs(linkID);
			};
		});
	} 
	
	function showTabs(linkID){
		var tabsObj = nui.get("tabs");
		tabsObj.removeAll();
		
		$.each(tabs,function(index,obj){
			
			if(linkID==index){
				$.each(obj, function(key, val){ 
					tabsObj.addTab(val);
				});
				tabsObj.activeTab(tabsObj.getTab(0));
			}
		});
	}
	
	function doLogout(){
		nui.ajax({
			url:"user/logout",
 		 	type:'POST',
            data:"",
            cache: false,
  		 	success:function(text) {
      		 		window.top.location.href="<%=request.getContextPath() %>/login/logout.jsp";
  		 	},
  		 	error : function(text){
  		 		alert("操作失败！")
  		 	}
		})
	}
	window.onload = init;
</script>

</body>
</html>