<%@ page language="java" import="java.util.*" isELIgnored="false"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>XXX管理系统</title>
	<link rel="stylesheet" type="text/css" href="/jsp/common/js/easyui/themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="/jsp/common/js/easyui/themes/icon.css">
	<link rel="stylesheet" type="text/css" href="/jsp/common/css/demo.css">
	<link rel="stylesheet" type="text/css" href="/jsp/common/css/progressbar/logingbarchasingdots.css">
	<script type="text/javascript" src="/jsp/common/js/easyui/jquery.min.js"></script>
	<script type="text/javascript" src="/jsp/common/js/easyui/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="/jsp/common/js/easyui/locale/easyui-lang-zh_CN.js"></script>
	<script type="text/javascript" src="/jsp/common/js/encrypt/md5-min.js"></script>
	<style type="text/css">
	  html { overflow-x: hidden; overflow-y: hidden; }
	</style>
</head>
<body>
	<div id="container" class="easyui-layout" style="width:100%;">
		<div data-options="region:'north',split:true" style="height:90px;overflow-x: hidden; overflow-y: hidden;">
			<div style="padding-top:10px;text-align: right;width: 100%;">
    			<h1 style="float: left;">
				<strong><span style="font-size:32px;"><span style="color:#337FE5;font-family:'Microsoft YaHei';">XXXX管理系统</span><span style="color:#337FE5;font-family:'Microsoft YaHei';"></span></span></strong>
				</h1>
				<a href="#" onclick="location.href='/jsp/login.jsp'" class="easyui-linkbutton" data-options="iconCls:'icon-cancel',size:'large',iconAlign:'top'" style="float: right;">退出系统</a>
				<a href="#" onclick="$('#changepass').dialog('open');" class="easyui-linkbutton" data-options="iconCls:'icon-edit',size:'large',iconAlign:'top'" style="float: right;">修改密码</a>
			</div>
			
		</div>
		
		<div data-options="region:'south',split:true" ></div>
		<div id="west" data-options="region:'west',split:true" title="功能菜单" style="width:200px;">
			<div style="float:none;padding:5px;width:100%">
			   
				<ul id="generatemytrees" class="easyui-tree" data-options="
				animate: true
				"></ul>
				 <div id="progressbar" class="sk-spinner sk-spinner-chasing-dots">
			      <div class="sk-dot1"></div>
			      <div class="sk-dot2"></div>
			    </div>
			</div>
			
		</div>
		<div id="center"  data-options="region:'center',title:'工作区'" style="overflow-x: hidden; overflow-y: hidden;">
			<div id="tabs" class="easyui-tabs" data-options="tools:'#tab-tools'" style="height: 600px;">
			</div>
		
		</div>
		
	</div>
	<div id="changepass" class="easyui-dialog" title="修改密码" style="width:350px;height:250px;padding:10px"
			data-options="
				iconCls: 'icon-edit',
				closed: true,
				buttons: [{
					text:'保存',
					iconCls:'icon-save',
					handler:function(){
						changepass();
					}
				},{
					text:'取消',
					iconCls:'icon-cancel',
					handler:function(){
						$('#changepass').dialog('close');
					}
				}]
			">
			<table>
				<tr>
					<td style="text-align: right;">旧密码:</td><td><input class="easyui-validatebox textbox" type="password" id="oldpass"  data-options="required:true"></input></td>
				</tr>
				<tr>
					<td style="text-align: right;">新密码:</td><td><input class="easyui-validatebox textbox" type="password" id="newpass1" ></input></td>
				</tr>
				<tr>
					<td style="text-align: right;">再次新密码:</td><td><input class="easyui-validatebox textbox" type="password" id="newpass2" ></input></td>
				</tr>
				
			</table>
		
	</div>
</body>
</html>
<script>
function changepass(){
	var oldpass=$('#oldpass').val();
	var newpass1=$('#newpass1').val();
	var newpass2=$('#newpass2').val();
	if(oldpass!==null&&oldpass!== undefined&&oldpass!==""){
		if(hex_md5(newpass1)==hex_md5(newpass2)){
			//changemypass
			$.post("/user/changemypass.do",
					{
						oldpass:hex_md5(oldpass),
						newpass1:hex_md5(newpass1),
						newpass2:hex_md5(newpass2)
					},
					function(data,status){
						//$.messager.alert('提示',"Data: " + data.indexOf("success") + "\nStatus: " + status);
						if(data.resultcode==0){
							$.messager.alert('提示',data.description);
						}else if(data.resultcode==1){
							$.messager.alert('提示',"修改密码成功");
							$('#changepass').dialog('close');
						}
						
					});
		}else{
			$.messager.alert('提示',"两次密码不一致！");
		}
	}else{
		$.messager.alert('提示',"请输入现在用的密码！");
	}
}
function addTab(title, href,icon){
	var tt = $('#tabs');
	if (tt.tabs('exists', title)){//if tab already exit,then refresh this tab 	
        tt.tabs('select', title);
        refreshTab({tabTitle:title,url:href});
	} else {
    	if (href){
	    	var content = '<iframe  frameborder="0" height="500px"  src="'+href+'" style="width:100%;"></iframe>';
    	} else {
	    	var content = '未实现';
    	}
    	tt.tabs('add',{
	    	title:title,
	    	closable:true,
	    	content:content,
	    	iconCls:icon||'icon-default'
    	});
	}
}

/**    
 * refresh tab
 * @cfg 
 *example: {tabTitle:'tabTitle',url:'refreshUrl'}
 *if this tabTitle is null，then refresh this tab
 *if url is null ，then reload the URL we used before
 */
 /**    
  * 刷新tab
  * @cfg 
  *example: {tabTitle:'tabTitle',url:'refreshUrl'}
  *如果tabTitle为空，则默认刷新当前选中的tab
  *如果url为空，则默认以原来的url进行reload
  */
function refreshTab(cfg){
	var refresh_tab = cfg.tabTitle?$('#tabs').tabs('getTab',cfg.tabTitle):$('#tabs').tabs('getSelected');
	if(refresh_tab && refresh_tab.find('iframe').length > 0){
	var _refresh_ifram = refresh_tab.find('iframe')[0];
	var refresh_url = cfg.url?cfg.url:_refresh_ifram.src;
	//_refresh_ifram.src = refresh_url;
	_refresh_ifram.contentWindow.location.href=refresh_url;
	}
}
  function showmypermission(){
		//generatemytrees
	  $.post("/user/generatemytrees.do",
				{
					
				},
				function(data,status){
					$('#generatemytrees').tree('loadData',data);
					$('#generatemytrees').tree({
						onClick: function(node){
							if($('#generatemytrees').tree('isLeaf',node.target)){

								addTab(node.text,node.url,"");
							}
							
						}
					});
					$('#progressbar').hide();

				});
		

	}
  function init(){
	  var width=window.screen.availWidth;
	  var height=window.screen.availHeight;
	  $('body').css("height",height+"px");
	  $('#center').css("height",(height-180)+"px");
	  $('#tabs').css("height",(height-180)+"px");
	  $('#container').css("height",(height)+"px");
	  $('#west').css("height",(height-180)+"px");

	  $('#center').css("width",(width-200)+"px");
	  $('#tabs').css("width",(width-200)+"px");
  }
$(function(){
	init();
	showmypermission();
});
</script>