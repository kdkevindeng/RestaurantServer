<%@ page language="java" import="java.util.*" isELIgnored="false"
	pageEncoding="UTF-8"%>
<!doctype html>
<html>
	<head>
		<meta charset="utf-8" />
		<title>Default Examples</title>
		<style>
			form {
				margin: 0;
			}
			textarea {
				display: block;
			}
		</style>
		<link rel="stylesheet" type="text/css" href="/jsp/common/js/easyui/themes/default/easyui.css">
		<link rel="stylesheet" type="text/css" href="/jsp/common/js/easyui/themes/icon.css">
		<link rel="stylesheet" type="text/css" href="/jsp/common/css/demo.css">
		<script type="text/javascript" src="/jsp/common/js/easyui/jquery.min.js"></script>
		<script type="text/javascript" src="/jsp/common/js/easyui/jquery.easyui.min.js"></script>
		<script type="text/javascript" src="/jsp/common/js/easyui/locale/easyui-lang-zh_CN.js"></script>
	
		<link rel="stylesheet" href="/jsp/common/js/kindeditor-4.1.7/themes/default/default.css" />
		<script charset="utf-8" src="/jsp/common/js/kindeditor-4.1.7/kindeditor-min.js"></script>
		<script charset="utf-8" src="/jsp/common/js/kindeditor-4.1.7/lang/zh_CN.js"></script>
		<script>
			var editor;
			KindEditor.ready(function(K) {
				editor = K.create('textarea[name="content"]', {
					allowFileManager : true
				});
				/* K('input[name=getHtml]').click(function(e) {
					alert(editor.html());
				});
				K('input[name=isEmpty]').click(function(e) {
					alert(editor.isEmpty());
				});
				K('input[name=getText]').click(function(e) {
					alert(editor.text());
				});
				K('input[name=selectedHtml]').click(function(e) {
					alert(editor.selectedHtml());
				});
				K('input[name=clear]').click(function(e) {
					editor.html('');
				}); */
			});
			function gethtml(){
				alert(editor.html());
			}
			function clearedit(){
				editor.html('');
			}
		</script>
	</head>
	<body>
			<div style="float:left;padding-left: 10px;">
				 标题：<input class="easyui-validatebox textbox" type="text" id="userid" ></input>
				副标题：<input class="easyui-validatebox textbox" type="text" id="username" ></input>
			</div>
			<div style="float:right;padding-right: 10px;">
				<a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-undo'" onclick="clearedit()">清空</a>
				<a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-save'" onclick="gethtml()" id="editbutton">保存</a>
			</div>
		<form>
			<textarea name="content" style="width:100%;height:500px;visibility:hidden;"></textarea>
		</form>
	</body>
</html>
