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
		<div data-options="region:'center',title:''">
			<div style="float:right;padding-right: 10px;">
				<a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-reload'" onclick="tablemode()">拖拽树</a>
			</div>
			<table id="datagrid" title="" class="easyui-treegrid" 
				data-options="
				url: '/permission/selectalltrees.do',
				method: 'get',
				rownumbers: true,
				idField: 'id',
				treeField: 'text',
				fit:true,
				fitColumns:true,
				onContextMenu: onContextMenu
				">
				<thead>
					<tr>
						<th data-options="field:'id',align:'center',hidden:true"></th>
						<th data-options="field:'parentcode',align:'center',hidden:true"></th>
						<th data-options="field:'text'" >菜单名</th>
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
						<th data-options="field:'url',align:'left',editor:'text'" >URL</th>
						<th data-options="field:'beizhu',align:'center',editor:'text'" >备注</th>
						<th data-options="field:'describes',align:'center',editor:'text'" >描述</th>
						<th data-options="field:'alertDate',align:'center',formatter:function (value){
						if(value==null)
							return '';
						else
							return '20'+(value.year+'').substring(1,3)+'-'+(value.month+1)+'-'+value.date;}"
							width="80">修改时间</th>
						<th data-options="field:'alertUser',align:'center'" width="80">修改人</th>
					</tr>
				</thead>
			</table>
	<div id="mm" class="easyui-menu" style="width:120px;">
		<div onclick="openadd()" data-options="iconCls:'icon-add'">添加</div>
		<div onclick="deletepermission()" data-options="iconCls:'icon-remove'">删除</div>
		<div onclick="openedit()" data-options="iconCls:'icon-ok'">修改</div>
	</div>

	<div id="adddlg" class="easyui-dialog" title="菜单" style="width:300px;height:250px;padding:10px"
			data-options="
				iconCls: 'icon-add',
				closed: true,
				buttons: '#dlg-buttons'
			">
			<table>
				<tr>
					<td style="text-align: right;">菜单名:</td><td><input class="easyui-validatebox textbox" type="text" id="addpermissionname"  data-options="required:true"></input></td>
				</tr>
				<tr>
					<td style="text-align: right;">父节点:</td><td> 
					<input id="parentcode" class="easyui-combotree" data-options="url:'/permission/selectalltrees.do',method:'get',required:true"></input></td>
				</tr>
				<tr>
					<td style="text-align: right;">URL:</td><td><input class="easyui-validatebox textbox" type="text" id="url" ></input></td>
				</tr>
				<tr>
					<td style="text-align: right;">是否可用:</td><td><select  id="isuse" >
					<option value="1" selected>启用</option>
					<option value="0">弃用</option>
					</select></td>
				</tr>
				<tr>
					<td style="text-align: right;">备注:</td><td><input class="easyui-validatebox textbox" type="text" id="beizhu" ></input></td>
				</tr>
				<tr>
					<td style="text-align: right;">描述:</td><td><input class="easyui-validatebox textbox" type="text" id="miaoshu" ></input></td>
				</tr>
			</table>
		
	</div>
	
	<div id="dlg-buttons">
		<a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-save'"  id ="addsave" >保存</a>
		<a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-cancel'" onclick="javascript:$('#adddlg').dialog('close');">取消</a>
	</div>

		
</div>
</body>
</html>
<script>
function onContextMenu(e,row){
	e.preventDefault();
	$(this).treegrid('select', row.id);
	$('#mm').menu('show',{
		left: e.pageX,
		top: e.pageY
	});
}
function openadd(){
	$("#addsave").unbind('click');
	$("#addsave").click(function(){addpermission();});
	var row = $('#datagrid').treegrid('getSelected');
	$('#parentcode').combotree('setValue', row.id);
	$('#adddlg').dialog('open');
}
function openedit(){
	$("#addsave").unbind('click');
	$("#addsave").click(function(){updatepermission();});
	var row = $('#datagrid').treegrid('getSelected');
	$('#addpermissionname').val(row.text);
	$('#url').val(row.url);
	$('#beizhu').val(row.beizhu);
	$('#miaoshu').val(row.describes);
	$('#parentcode').combotree('setValue', row.parentcode);
	$('#adddlg').dialog('open');

}
function addpermission(){
	//alert($("#parentcode").combotree('getValues')+"");
	var permissionname=$("#addpermissionname").val();
	if(permissionname==""){
		$.messager.alert('提示',"菜单名不能为空！");
		return;
	}else{
		$.post("/permission/addonepermission.do",
		{
			permissionMc:permissionname,
			url:$("#url").val(),
			beizhu:$("#beizhu").val(),
			parentcode:$("#parentcode").combotree('getValues')+"",
			describes:$("#miaoshu").val()
		},
		function(data,status){
			if(data.resultcode==0){
				$.messager.alert('提示',data.description);
			}else if(data.resultcode==1){
				//$.messager.alert('提示',"添加菜单成功");
				alert("提示,添加菜单成功");
				location.reload();
			}
		});
		
	}
	$('#adddlg').dialog('close');
	$('#datagrid').treegrid('reload');   
}
function deletepermission(){
	var row = $('#datagrid').treegrid('getSelected');
	if (row){
		var textend="吗？";
		if($('#datagrid').treegrid('getChildren',row.id).length>0){
			textend="以及所属子菜单吗？";
		}
		$.messager.confirm('删除菜单', "确定删除"+row.text+textend, function(r){
				if (r){
					$.post("/permission/deleteonepermission.do",
					{
						permissionDm:row.id
					},
					function(data,status){
						//alert("Data: " + data.indexOf("success") + "\nStatus: " + status);
						if(data.resultcode==0){
							$.messager.alert('提示',data.description);
						}else if(data.resultcode==1){
							$.messager.alert('提示',"删除菜单成功");
						}
						$('#datagrid').treegrid('reload');
					});
				}
		});

	} 
}
function updatepermission(){
	var row = $('#datagrid').treegrid('getSelected');
	var permissionname=$("#addpermissionname").val();
	if(permissionname==""){
		$.messager.alert('提示',"菜单名不能为空！");
		return;
	}else{
		$.post("/permission/updateonepermission.do",
		{
			permissionDm:row.id,
			permissionMc:permissionname,
			url:$("#url").val(),
			beizhu:$("#beizhu").val(),
			isuse:$("#isuse").val(),
			parentcode:$("#parentcode").combotree('getValues')+"",
			describes:$("#miaoshu").val()
		},
		function(data,status){
			if(data.resultcode==0){
				$.messager.alert('提示',data.description);
			}else if(data.resultcode==1){
				//$.messager.alert('提示',"修改菜单成功");
				alert("提示,修改菜单成功");
				location.reload();
			}
		});
		
	}
	$('#adddlg').dialog('close');
	$('#datagrid').treegrid('reload'); 
}
function tablemode(){
	document.location.href="permissiontreemanage.jsp";
}
$(function(){
	//queryData();
});
</script>