<%@ page language="java" import="java.util.*" isELIgnored="false"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Index</title>
	<link rel="stylesheet" type="text/css" href="/jsp/common/js/easyui/themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="/jsp/common/js/easyui/themes/icon.css">
	<link rel="stylesheet" type="text/css" href="/jsp/common/css/demo.css">
	<script type="text/javascript" src="/jsp/common/js/easyui/jquery.min.js"></script>
	<script type="text/javascript" src="/jsp/common/js/easyui/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="/jsp/common/js/easyui/locale/easyui-lang-zh_CN.js"></script>
	
</head>
<body>
	<div class="easyui-layout" style="width:100%;height:768px;">
		<div data-options="region:'center'">
			<div style="float:left;padding-left: 10px;">
				角色名:<input class="easyui-validatebox textbox" type="text" id="rolename" ></input>
				时间:<input class="easyui-datebox" id="alterDate_start"></input>
				-<input class="easyui-datebox" id="alterDate_end"></input>
				<a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-search'" onclick="queryData()">查询</a>
			</div>
			<div style="float:right;padding-right: 10px;">
				<a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-add'" onclick="$('#adddlg').dialog('open')" >添加</a>
				<a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-remove'" onclick="deleterole()">删除</a>
				<a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-save'" onclick="update()" id="editbutton">保存</a>
				<a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-undo'" onclick="reject()">放弃</a>
				<a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-add'" onclick="opengrantpanel()" >授权</a>
				
			</div>
			<table id="datagrid" class="easyui-datagrid"
					data-options="rownumbers:true,border:false,singleSelect:true,fit:true,fitColumns:true,onDblClickRow: onDbClickRow">
				<thead>
					<tr>
						<th data-options="field:'ck',checkbox:true"></th>
						<th data-options="field:'roleDm',align:'center',hidden:true"></th>
						<th data-options="field:'roleMc',align:'center',editor:'text'" width="80">角色名</th>
						<th data-options="field:'beizhu',align:'center',editor:'text'" width="80">备注</th>
						<th data-options="field:'alerttime',align:'center',formatter:function (value){
						return '20'+(value.year+'').substring(1,3)+'-'+(value.month+1)+'-'+value.date;}" width="80">修改时间</th>
						<th data-options="field:'alertuser',align:'center'" width="80">修改人</th>
						<th data-options="field:'isuse',align:'center',formatter:function (value){
							if(value=='1'){
								return '启用';
							}
							if(value=='0'){
								return '弃用';
							}
						},editor:{
							type:'combobox',
							options:{data:[{ 'value': '1', 'text': '启用' }, { 'value': '0', 'text': '弃用' }]}

						}" width="80">是否可用</th>
					</tr>
				</thead>
			</table>
		</div>
	</div>
	<div id="adddlg" class="easyui-dialog" title="添加用户" style="width:250px;height:250px;padding:10px"
			data-options="
				iconCls: 'icon-add',
				closed: true,
				buttons: [{
					text:'保存',
					iconCls:'icon-save',
					handler:function(){
						addrole();
					}
				},{
					text:'取消',
					iconCls:'icon-cancel',
					handler:function(){
						$('#adddlg').dialog('close');
					}
				}]
			">
			<table>
				<tr>
					<td style="text-align: right;">角色名:</td><td><input class="easyui-validatebox textbox" type="text" id="addrolename"  data-options="required:true"></input></td>
				</tr>
				<tr>
					<td style="text-align: right;">备注:</td><td><input class="easyui-validatebox textbox" type="text" id="addbeizhu" ></input></td>
				</tr>
			</table>
		
	</div>
	<div id="grantpage" class="easyui-dialog" title="角色授权" style="width:300px;height:300px;padding:10px"
			data-options="
				iconCls: 'icon-add',
				closed: true,
				buttons: [{
					text:'保存',
					iconCls:'icon-save',
					handler:function(){
						grantpermission();
					}
				},{
					text:'取消',
					iconCls:'icon-cancel',
					handler:function(){
						$('#grantpage').dialog('close');
						location.reload();
					}
				}]
			">
			<div style="float:none;padding:5px;width:100%;height:600px">
				<ul id="tt" class="easyui-tree" data-options="
				animate: true,
				checkbox:true
				"></ul>
			</div>
		
	</div>
</body>
</html>
<script>
function formatjsontree(tree){
	delete tree.target;
	delete tree.domId;
	delete tree.state;
	delete tree.alertDate;
	delete tree.isuse;
	delete tree.beizhu;
	delete tree.alertUser;
	delete tree.describes;
	delete tree.text;
	delete tree.url;
	delete tree.parentcode;
	delete tree.children;
	delete tree.checked;
	return tree;
}
function getCheckedTree(){
	var treeselect=$('#tt').tree('getChecked');
	var size=treeselect.length;
	for(var i=0;i<size;i++){
		treeselect[i]=formatjsontree(treeselect[i]);
	}
	return JSON.stringify(treeselect);
}

function grantpermission(){
	var row = $('#datagrid').datagrid('getSelected');
	if(row){
		$.post("/permission/grantpermission.do",
				{
					roleid:row.roleDm,
					treeselect:getCheckedTree()
				},
				function(data,status){
					//alert("Data: " + data + "\nStatus: " + status);
					if(data.resultcode==0){
						//$.messager.alert('提示',data.description);
						alert(data.description);
					}else if(data.resultcode==1){

						//$.messager.alert('提示',"授权成功");
						alert("授权成功");
					}
					$('#grantpage').dialog('close');
					location.reload();
					
				});
	}else{

		$.messager.alert('提示',"请选择一个角色");
		return;
		
	}
	
}
function addrole(){
	var rolename=$("#addrolename").val();
	if(rolename==""){
		$.messager.alert('提示',"角色名不能为空！");
		return;
	}else{
		
		$.post("/role/addonerole.do",
		{
			roleMc:rolename,
			beizhu:$("#addbeizhu").val()
		},
		function(data,status){
			//alert("Data: " + data + "\nStatus: " + status);
			if(data.resultcode==0){
				$.messager.alert('提示',data.description);
			}else if(data.resultcode==1){
				$.messager.alert('提示',"添加角色成功");
			}
			$('#adddlg').dialog('close');
			queryData();
		});
		
	}
}
function queryData(){
	$.post("/role/queryrole.do",
	{
		roleMc:$("#rolename").val(),
		startdate:$("#alterDate_start").datebox('getValue'),
		enddate:$("#alterDate_end").datebox('getValue')
	},
	function(data,status){
		//alert(data);
		if(data==null){
			$.messager.alert('提示',"没有查询到数据");
		}else{
			$("#datagrid").datagrid('loadData', data);
		}
	});
}
function deleterole(){
	var row = $('#datagrid').datagrid('getSelected');
	if (row){
		$.messager.confirm('删除角色', "确定删除"+row.roleMc+"吗?删除角色后，赋予其的菜单也将清除！", function(r){
				if (r){
					$.post("/role/deleteonerole.do",
					{
						roleDm:row.roleDm
					},
					function(data,status){
						//alert("Data: " + data.indexOf("success") + "\nStatus: " + status);
						if(data.resultcode==0){
							$.messager.alert('提示',data.description);
						}else if(data.resultcode==1){
							$.messager.alert('提示',"删除角色成功");
						}
						queryData();
					});
				}
		});

	}else{
		$.messager.alert('提示',"请选择一个角色");
	}
}
function update(){
	accept();
	for(var i=0;i<editids.length;i++){
		var row = $('#datagrid').datagrid('getData').rows[editids[i]];
		$.post("/role/updateonerole.do",
		{
			roleDm:row.roleDm,
			roleMc:row.roleMc,
			isuse:row.isuse,
			beizhu:row.beizhu
		},
		function(data,status){
			//alert("Data: " + data.indexOf("success") + "\nStatus: " + status);
			if(data.resultcode==0){
				$.messager.alert('提示',data.description);
			}else if(data.resultcode==1){
				//$.messager.alert('提示',"修改角色成功");
				alert("修改角色成功");
				location.reload();
			}
		});
	}
	editids=new Array();
	queryData();
}
function onDbClickRow(index){
	if (editIndex != index){
		if (endEditing()){
			editids.push(index);
			$('#datagrid').datagrid('selectRow', index)
			.datagrid('beginEdit', index);
			editIndex = index;
		} else {
			$('#datagrid').datagrid('selectRow', editIndex);
		}
	}
}
function endEditing(){
	if (editIndex == undefined){
		return true;
		}
	if ($('#datagrid').datagrid('validateRow', editIndex)){
		$('#datagrid').datagrid('endEdit', editIndex);
		editIndex = undefined;
		return true;
	} else {
		return false;
	}
}
$(function(){
	var date=new Date();
	$("#alterDate_start").datebox('setValue',date.getFullYear()+"-"+(date.getMonth()+1)+"-01"),
	$("#alterDate_end").datebox('setValue',date.getFullYear()+"-"+(date.getMonth()+1)+"-"+date.getDate())
	queryData();
});
function accept(){
	if (endEditing()){
		$('#datagrid').datagrid('acceptChanges');
	}
}
function reject(){
	$('#datagrid').datagrid('rejectChanges');
	editIndex = undefined;
}
function opengrantpanel(){

	var row = $('#datagrid').datagrid('getSelected');
	if(row){
		$.post("/permission/selectalltrees.do",
				{
					roledm:row.roleDm
				},
				function(data,status){
					$('#tt').tree('loadData',data);
				});
	
		$('#grantpage').dialog('open');
	}else{

		$.messager.alert('提示',"请选择一个角色");
		return;
	}
	
}
var editIndex = undefined;
var editids=new Array();　
</script>