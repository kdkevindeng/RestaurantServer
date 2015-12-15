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
	<script type="text/javascript" src="/jsp/common/js/encrypt/md5-min.js"></script>
	
</head>
<body>
	<div class="easyui-layout" style="width:100%;height:768px;">
		<div data-options="region:'center'">
			<div style="float:left;padding-left: 10px;">
				用户ID：<input class="easyui-validatebox textbox" type="text" id="userid" ></input>
				用户姓名:<input class="easyui-validatebox textbox" type="text" id="username" ></input>
				修改时间:<input class="easyui-datebox" id="alterDate_start"></input>
				-<input class="easyui-datebox" id="alterDate_end"></input>
				<a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-search'" onclick="queryData()">查询</a>
			</div>
			<div style="float:right;padding-right: 10px;">
				<a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-add'" onclick="$('#adddlg').dialog('open')" >添加</a>
				<a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-remove'" onclick="deleteuser()">删除</a>
				<a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-save'" onclick="update()" id="editbutton">保存</a>
				<a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-undo'" onclick="reject()">放弃</a>
				<a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-undo'" onclick="resetpass()">重置密码</a>
				<a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-undo'" onclick="opengrantrole()">角色分配</a>
				<a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-undo'" onclick="showmypermission()">查看权限</a>
			</div>
			<table id="datagrid" class="easyui-datagrid"
					data-options="rownumbers:true,border:false,singleSelect:true,fit:true,fitColumns:true,onDblClickRow: onDbClickRow">
				<thead>
					<tr>
						<th data-options="field:'ck',checkbox:true"></th>
						<th data-options="field:'id',align:'center',hidden:true"></th>
						<th data-options="field:'userid',align:'center'" width="100">用户ID</th>
						<th data-options="field:'username',align:'center',editor:'text'" width="80">用户姓名</th>
						<th data-options="field:'telphone',align:'center',editor:'text'" width="80">电话</th>
						<th data-options="field:'qq',align:'center',editor:'text'" width="80">QQ</th>
						<th data-options="field:'weixin',align:'center',editor:'text'" width="80">微信</th>
						<th data-options="field:'alterDate',align:'center',formatter:function (value){
						return '20'+(value.year+'').substring(1,3)+'-'+(value.month+1)+'-'+value.date;}" width="80">修改时间</th>
						<th data-options="field:'alterUser',align:'center'" width="80">修改人</th>
						
					</tr>
				</thead>
			</table>
		</div>
	</div>
	<div id="adddlg" class="easyui-dialog" title="添加用户" style="width:350px;height:250px;padding:10px"
			data-options="
				iconCls: 'icon-add',
				closed: true,
				buttons: [{
					text:'保存',
					iconCls:'icon-save',
					handler:function(){
						adduser();
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
					<td style="text-align: right;">用户名:</td><td><input class="easyui-validatebox textbox" type="text" id="addusername"  data-options="required:true"></input></td>
				</tr>
				<tr>
					<td style="text-align: right;">密码:</td><td><input class="easyui-validatebox textbox" type="text" id="addpwd" value="123456"  data-options="required:true"></input></td>
				</tr>
				<tr>
					<td style="text-align: right;">电话:</td><td><input class="easyui-validatebox textbox" type="text" id="addtel" ></input></td>
				</tr>
				<tr>
					<td style="text-align: right;">微信:</td><td><input class="easyui-validatebox textbox" type="text" id="addweixin" ></input></td>
				</tr>
				<tr>
					<td style="text-align: right;">QQ:</td><td><input class="easyui-validatebox textbox" type="text" id="addqq" ></input></td>
				</tr>
				
			</table>
		
	</div>
	<div id="grantdlg" class="easyui-dialog" title="角色授权" style="width:250px;height:250px;padding:10px"
			data-options="
				iconCls: 'icon-add',
				closed: true,
				buttons: [{
					text:'保存',
					iconCls:'icon-save',
					handler:function(){
						grantrole();
					}
				},{
					text:'取消',
					iconCls:'icon-cancel',
					handler:function(){
						$('#grantdlg').dialog('close');
					}
				}]
			">
		<table id="rolelist" class="easyui-datagrid"
					data-options="rownumbers:true,border:false,fit:true,fitColumns:true">
				<thead>
					<tr>
						<th data-options="field:'roleid',checkbox:true"></th>
						<th data-options="field:'rolemc',align:'center'" width="100">角色</th>
					</tr>
				</thead>
			</table>
	</div>
	<div id="showpermission" class="easyui-dialog" title="菜单查看" style="width:300px;height:300px;padding:10px"
			data-options="
				iconCls: 'icon-add',
				closed: true,
				buttons: [{
					text:'确定',
					iconCls:'icon-cancel',
					handler:function(){
						$('#showpermission').dialog('close');
						//location.reload();
					}
				}]
			">
			<div style="float:none;padding:5px;width:100%;height:600px">
				<ul id="showpermissiontt" class="easyui-tree" data-options="
				animate: true
				"></ul>
			</div>
		
	</div>
</body>
</html>
<script>
function adduser(){
	var username=$("#addusername").val();
	var password=$("#addpwd").val();
	if(username==""||password==""){
		$.messager.alert('提示',"用户名和密码不能为空！");
		return;
	}else{
		var domain=$("#adddomain").val();
		$.post("/user/addoneuser.do",
		{
			username:username,
			password:hex_md5(password),
			telphone:$("#addtel").val(),
			qq:$("#addqq").val(),
			weixin:$("#addweixin").val()
		},
		function(data,status){
			//alert("Data: " + data + "\nStatus: " + status);
			if(data.resultcode==0){
				$.messager.alert('提示',data.description);
			}else if(data.resultcode==1){
				$.messager.alert('提示',"添加用户成功");
			}
			$('#adddlg').dialog('close');
			queryData();
		});
		
	}
}
function queryData(){
	$.post("/user/queryuser.do",
	{
		userid:$("#userid").val(),
		username:$("#username").val(),
		startdate:$("#alterDate_start").datebox('getValue'),
		enddate:$("#alterDate_end").datebox('getValue')
	},
	function(data,status){
		if(data==null){
			$.messager.alert('提示',"没有查询到数据");
		}else{
			$("#datagrid").datagrid('loadData', data);
		}
	});
}
function deleteuser(){
	var row = $('#datagrid').datagrid('getSelected');
	if (row){
		$.messager.confirm('删除用户', "确定删除"+row.username+"吗?", function(r){
				if (r){
					$.post("/user/deleteoneuser.do",
					{
						id:row.id
					},
					function(data,status){
						//alert("Data: " + data.indexOf("success") + "\nStatus: " + status);
						if(data.resultcode==0){
							$.messager.alert('提示',data.description);
						}else if(data.resultcode==1){
							$.messager.alert('提示',"删除用户成功");
						}
						queryData();
					});
				}
		});

	}else{

		$.messager.alert('提示',"请选择一个用户");
	}
}
function resetpass(){
	var row = $('#datagrid').datagrid('getSelected');
	if (row){
		$.messager.confirm('重置密码', "确定重置"+row.username+"的密码为123456吗?", function(r){
				if (r){
					$.post("/user/updateoneuser.do",
					{
						id:row.id,
						password:hex_md5('123456')
					},
					function(data,status){
						//alert("Data: " + data.indexOf("success") + "\nStatus: " + status);
						if(data.resultcode==0){
							$.messager.alert('提示',data.description);
						}else if(data.resultcode==1){
							$.messager.alert('提示',"密码重置成功");
						}
						queryData();
					});
				}
		});

	}else{

		$.messager.alert('提示',"请选择一个用户");
	}
}
function update(){
	accept();
	for(var i=0;i<editids.length;i++){
		var row = $('#datagrid').datagrid('getData').rows[editids[i]];
		$.post("/user/updateoneuser.do",
		{
			id:row.id,
			userid:row.userid,
			telphone:row.telphone,
			qq:row.qq,
			weixin:row.weixin
		},
		function(data,status){
			//$.messager.alert('提示',"Data: " + data.indexOf("success") + "\nStatus: " + status);
			if(data.resultcode==0){
				$.messager.alert('提示',data.description);
			}else if(data.resultcode==1){
				$.messager.alert('提示',"修改用户成功");
			}
			queryData();
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

function grantrole(){
	var row = $('#datagrid').datagrid('getSelected');
	if (row){
		var roles = $('#rolelist').datagrid('getSelections');
		if (roles){
			$.post("/user/grantrole.do",
					{
						userid:row.id,
						roleselect:JSON.stringify(roles)
					},
					function(data,status){
						if(data.resultcode==0){
							$.messager.alert('提示',data.description);
						}else if(data.resultcode==1){
							$.messager.alert('提示',"角色分配成功");
						}
						$('#grantdlg').dialog('close');
						
					});

		}else{

			$.messager.alert('提示',"请选择至少一个角色");
		}

	}else{

		$.messager.alert('提示',"请选择一个用户");
	}
}
function opengrantrole(){
	var row = $('#datagrid').datagrid('getSelected');
	if (row){
		$.post("/role/querymyrole.do",
				{
					userid:row.id
				},
				function(data,status){
					//$.messager.alert('提示',"Data: " + data.indexOf("success") + "\nStatus: " + status);
					$('#rolelist').datagrid('loadData',data);
					$.each(data,function(index,item){//遍历JSON 
				        if(item.isselect){    
				            $("#rolelist").datagrid("selectRow", index);  
				        }  
				           
				    });  
					$('#grantdlg').dialog('open');
					
				});

	}else{

		$.messager.alert('提示',"请选择一个用户");
	}
	

}
function showmypermission(){
	//generatemytrees
	var row = $('#datagrid').datagrid('getSelected');
	if (row){
		$.post("/user/generateusertrees.do",
				{
					id:row.id
				},
				function(data,status){
					$('#showpermissiontt').tree('loadData',data);
					$('#showpermission').dialog('open');
					
				});

	}else{

		$.messager.alert('提示',"请选择一个用户");
	}
	

}
var editIndex = undefined;
var editids=new Array();

</script>