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
		<div data-options="region:'center',title:'MainTitle'">
			<div style="float:left;padding-left: 10px;">
				权限名:<input class="easyui-validatebox textbox" type="text" id="permissionname" ></input>
				时间:<input class="easyui-datebox" id="alterDate_start"></input>
				-<input class="easyui-datebox" id="alterDate_end"></input>
				<a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-search'" onclick="queryData()">查询</a>
			</div>
			<div style="float:right;padding-right: 10px;">
				<a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-add'" onclick="$('#adddlg').dialog('open')" >添加</a>
				<a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-remove'" onclick="deletepermission()">删除</a>
				<a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-save'" onclick="update()" id="editbutton">保存</a>
				<a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-undo'" onclick="reject()">放弃</a>
				<a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-reload'" onclick="treemode()">权限树</a>
			</div>
			<table id="datagrid" class="easyui-datagrid"
					data-options="rownumbers:true,border:false,singleSelect:true,fit:true,fitColumns:true,onDblClickRow: onDbClickRow">
				<thead>
					<tr>
						<th data-options="field:'ck',checkbox:true"></th>
						<th data-options="field:'permissionDm',align:'center',hidden:true"></th>
						<th data-options="field:'permissionMc',align:'center',editor:'text'" width="80">权限名</th>
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
						<th data-options="field:'url',align:'center',editor:'text'" width="100">URL</th>
						<th data-options="field:'beizhu',align:'center',editor:'text'" width="80">备注</th>
						<th data-options="field:'describes',align:'center',editor:'text'" width="100">描述</th>
						<th data-options="field:'alertDate',align:'center',formatter:function (value){
						return '20'+(value.year+'').substring(1,3)+'-'+(value.month+1)+'-'+value.date;}" width="80">修改时间</th>
						<th data-options="field:'alertUser',align:'center'" width="80">修改人</th>
						
					</tr>
				</thead>
			</table>
		</div>
	</div>
	<div id="adddlg" class="easyui-dialog" title="添加权限" style="width:250px;height:250px;padding:10px"
			data-options="
				iconCls: 'icon-add',
				closed: true,
				buttons: [{
					text:'保存',
					iconCls:'icon-save',
					handler:function(){
						addpermission();
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
					<td style="text-align: right;">权限名:</td><td><input class="easyui-validatebox textbox" type="text" id="addpermissionname"  data-options="required:true"></input></td>
				</tr>
				<tr>
					<td style="text-align: right;">父节点:</td><td> 
					<input id="parentcode" class="easyui-combotree" data-options="url:'http://127.0.0.1:8080/Demo/permission/selectalltrees.do',method:'get',required:true"></input></td>
				</tr>
				<tr>
					<td style="text-align: right;">URL:</td><td><input class="easyui-validatebox textbox" type="text" id="url" ></input></td>
				</tr>
				<tr>
					<td style="text-align: right;">备注:</td><td><input class="easyui-validatebox textbox" type="text" id="beizhu" ></input></td>
				</tr>
				<tr>
					<td style="text-align: right;">描述:</td><td><input class="easyui-validatebox textbox" type="text" id="miaoshu" ></input></td>
				</tr>
			</table>
		
	</div>
</body>
</html>
<script>
function dataformatter(value,row,index){
	$.messager.alert('提示',row.alertDate);
	$.messager.alert('提示',value);
	return 11;
}
function addpermission(){
	var permissionname=$("#addpermissionname").val();
	if(permissionname==""){
		$.messager.alert('提示',"权限名不能为空！");
		return;
	}else{
		$.post("http://127.0.0.1:8080/Demo/permission/addonepermission.do",
		{
			permissionMc:permissionname,
			url:$("#url").val(),
			beizhu:$("#beizhu").val(),
			parentcode:$("#parentcode").combotree('getValues')+"",
			describes:$("#miaoshu").val()
		},
		function(data,status){
			$.messager.alert('提示',"Data: " + data + "\nStatus: " + status);
			$('#adddlg').dialog('close');
			queryData();
		});
		
	}
}
function queryData(){
	var permissionname=$("#permissionname").val();
	var domain=$("#domain").val();
	var alterDate_start=$("#alterDate_start").val();
	var alterDate_end=$("#alterDate_end").val();
	$.post("http://127.0.0.1:8080/Demo/permission/selectallpermission.do",
	{
		permissionMc:permissionname,
		alertDate_start:alterDate_start,
		alertDate_end:alterDate_end
	},
	function(data,status){
		if(data==null){
			$.messager.alert('提示',"没有查询到数据");
		}else{
			$("#datagrid").datagrid('loadData', data);
		}
	});
}
function deletepermission(){
	var row = $('#datagrid').datagrid('getSelected');
	if (row){
		$.messager.confirm('删除权限', "确定删除"+row.permissionMc+"吗?", function(r){
				if (r){
					$.post("http://127.0.0.1:8080/Demo/permission/deleteonepermission.do",
					{
						permissionDm:row.permissionDm
					},
					function(data,status){
						//$.messager.alert('提示',"Data: " + data.indexOf("success") + "\nStatus: " + status);
						if(data.indexOf("success")>-1){
							$.messager.alert('提示',"删除成功！");
						}else{
							$.messager.alert('提示',"删除失败！");
						}
						queryData();
					});
				}
		});

	}
}
function update(){
	accept();
	for(var i=0;i<editids.length;i++){
		var row = $('#datagrid').datagrid('getData').rows[editids[i]];
		$.post("http://127.0.0.1:8080/Demo/permission/updateonepermission.do",
		{
			permissionDm:row.permissionDm,
			permissionMc:row.permissionMc,
			url:row.url,
			beizhu:row.beizhu,
			describes:row.describes,
			isuse:row.isuse
		},
		function(data,status){
			//alert("Data: " + data.indexOf("success") + "\nStatus: " + status);
			if(data.indexOf("success")>-1){
				$.messager.alert('提示',"更新成功！");
			}else{
				$.messager.alert('提示',"更新失败！");
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
function treemode(){
	document.location.href="permissiontreegridmanage.html";
}
var editIndex = undefined;
var editids=new Array();　
</script>