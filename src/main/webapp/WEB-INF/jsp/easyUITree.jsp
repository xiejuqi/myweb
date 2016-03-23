<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%String path = request.getContextPath();%>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<script type="text/javascript" charset="utf-8" src="<%=path%>/js/jquery.min.js"></script>
<script type="text/javascript" charset="utf-8" src="<%=path%>/js/jquery.easyui.min.js"></script>
<script type="text/javascript">
	$(function(){
		loadTree();
	});
	
	function getCheckNode(){
		var nodes = $('#t1').tree('getChecked');
		var s = '';
		for(var i=0; i<nodes.length; i++){
			if (s != '') s += ',';
			s += nodes[i].id;
		}
		alert(s);
	}
	
	function loadTree(){
		//alert($("#navigateTree").length);
		$("#t1").tree({
			url:"/myweb/getTreeJson.json?r="+Math.random(),
			lines: false,
			animate: true,
			method:"POST"
			/* onClick:function(node){
				navFlag = false;
				var str = "";
				str = treeNav($(this), node, str);
				$("#index_nav").html(str);
				if($(this).tree('isLeaf', node.target)){
					if(node.text=="安全退出"){
						window.location.href="logout.htm"; 
					}
					addTab(node.text, "."+node.href);
				}
			},
			onSelect:function(node){
				//collapseAll $(this).tree('toggle',node.target);
				//$(this).tree('collapseAll');  
				$(this).tree('toggle',node.target); 	 
			} */
		});
	}
</script>
<link rel="stylesheet" type="text/css" href="<%=path%>/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="<%=path%>/themes/icon.css">
<title>Insert title here</title>
</head>
<body>
	
	<form name="Form2" action="<%=path%>/postUpload.html" method="post"  enctype="multipart/form-data">
		<h1>使用spring mvc提供的类的方法上传文件</h1>
		<input type="file" name="file">
		<input type="submit" value="upload"/>
	</form>
	
	    <ul id="tt" class="easyui-tree">
        <li>
    		<span>Folder</span>
    		<ul>
    			<li>
    				<span>Sub Folder 1</span>
    				<ul>
    					<li><span><a href="#">File 11</a></span></li>
    					<li><span>File 12</span></li>
    					<li><span>File 13</span></li>
    				</ul>
    			</li>
    			<li><span>File 2</span></li>
    			<li><span>File 3</span></li>
    		</ul>
    	</li>
        <li><span>File21</span></li>
    </ul>
    
    <ul id="t1" data-options="checkbox:true"></ul>
	
	<input type="button" onclick="getCheckNode();" value="保存" />
</body>
</html>