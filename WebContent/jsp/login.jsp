<%@ page language="java" import="java.util.*" isELIgnored="false"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>XXX管理系统登录</title>

<link type="text/css" rel="stylesheet" href="/jsp/common/css/logingbar.css" />
<script type="text/javascript" src="/jsp/common/js/easyui/jquery.min.js"></script>
<script type="text/javascript" src="/jsp/common/js/easyui/jquery.easyui.min.js"></script>
<script type="text/javascript" src="/jsp/common/js/encrypt/md5-min.js"></script>
<style type="text/css">
body{line-height:1.666;background-color:#1691d7}
body,select,input,h1,h2,h3{font-size:12px}
body,input,select{font-family:verdana}
body,h1,h2,h3,ul,li,form,p,img{margin:0;padding:0;border:0}
input{margin:0;padding:0}
input,img{line-height:normal}
ul,li{list-style:none}
article,aside,footer,header,hgroup,nav,section{display: block}
a{color:#fff;text-decoration:none}
a:hover{text-decoration:underline}
.ipt-c{width:16px;height:16px;vertical-align:middle;padding:0}

.page,html,body{width:100%;height:100%}
.page{min-width:689px;min-height:435px;position:relative;+zoom:1}
.btn,
.copy-item,
.ico,
.tab-list{display:inline-block;+display:inline;+zoom:1;vertical-align:middle}
.main h3,
.tab-list .item .ico-logo,
.form .hd{line-height:100px;overflow:hidden}
.btn,
.form .hd,
/* 按钮 */
.btn{border:0;width:102px;height:40px}
.btn-login{background-color:#569BE0}
.btn-login-hover{background-color:#73BDE6}
.btn-login-active{background-color:#73BDE6}
/* 输入框 */
.ipt-wraper .ipt-c{visibility:hidden;position:absolute}
.ipt-wraper .ico-checkbox{position:relative;top:-1px;margin-right:3px}
/* tab */
.tab-list{width:220px;position:relative;+zoom:1;box-shadow:0px 1px 5px rgba(0,0,0,0.2)}
.tab-list .item{cursor:pointer;position:relative;overflow:hidden;+zoom:1;height:86px;width:220px;vertical-align:top}
.tab-list .item .bg{cursor:pointer;width:100%;height:85px;background-color:#fff;border-bottom:1px solid #ccc;position:absolute;z-index:0;left:0;top:0;opacity:0.4;filter:alpha(opacity=40);_filter:alpha(opacity=50)}
.tab-list .item .bg-selected{display:none;position:absolute;z-index:4;top:0;left:0;background-repeat:repeat-x;_background:#fff;_filter:alpha(opacity=50);width:219px;height:85px;zoom:1}
.tab-list .item .logo{position:absolute;zoom:1;background-color:transparent;cursor:pointer;z-index:5;top:27px;left:47px;opacity:0.6;filter:alpha(opacity=60)}
.tab-list .hover .bg{opacity:0.6;filter:alpha(opacity=60);_filter:alpha(opacity=80)}
.tab-list .hover .logo{opacity:0.7;filter:alpha(opacity=70)}
/* tab panel */
.tab-panel{width:460px;height:344px;border-color:#CDCDCD;border-width:0;border-style:solid;background-color:#fff;position:relative;z-index:10;+zoom:1;box-shadow:0px 1px 5px RGBA(0,0,0,0.5)}
.tab-panel .form{padding:0 60px}
.tab-panel-locat{position:absolute;z-index:15;top:32px;left:-15px}
.tab-panel .shadow,
.tab-list .shadow{display:none}

/* 表单 */
.form{overflow:hidden;+zoom:1;color:#7A8698;line-height:normal;height:100%}
.form a{color:#217DD9}
.form .hd{width:167px;height:24px;background-position:0 0}
#hdExtLink,
#hdMobExtLink{position:absolute; top:29px; right:54px; padding:0 4px; line-height: 21px; background-color:#EA4A4A; font-weight: bold; color: #fff; border-radius: 2px; text-decoration: none;}
#hdMobExtLink{background-color:#4793e5;}
.form .options{position:relative;+zoom:1}
.form .options label{margin-right:60px}
.form .options .help{line-height:0;display:inline-block;+display:inline;+zoom:1;vertical-align:top;margin-left:4px}
.form .options .ext{position:absolute;right:0;top:0;color:#7a8698}
.form .options .ext:hover{text-decoration:none;color:#217dd9}
.form .ft{border-top:1px solid #C9D6DD;padding-top:11px}
.form .hd{margin-top:29px;}
.form .user{margin-top:20px}
.form .pass{margin-top:26px}
.form .user{z-index: 1}
.form .options{margin-top:16px}
.form .ft{margin-top:18px}
.form .user .ico{position:absolute;left:12px;top:12px;display:none}
/* 版本选择 */
.ft-mailver-text{color:#7a8698}
.form .ft-mailver-now{cursor:pointer;display:inline-block;padding-right:12px;position:relative;color:#7a8698;}
.form .ft-mailver-now:hover{color:#217dd9;text-decoration:none;}
#loginFootTipsVer{position:relative;}
.ft-verSelect{position:absolute;width:133px;border:1px solid #cdcdcd;overflow:hidden;background:#fff;z-index:2;top:250px;left:120px;display:none;box-shadow:0px 1px 5px rgba(0,0,0,0.5);border-color:rgba(205, 205, 205, 0)}
.ft-verSelect-inner{width:131px;border:1px solid #fff;overflow:hidden;}
.ft-verSelect-inner li{float:left:height:24px;width:131px;overflow:hidden}
.form .ft-verSelect-inner-a{height:24px;width:131px;overflow:hidden;display:block;line-height:24px;color:#7a8698;text-indent:18px;}
.form .ft-verSelect-inner-a-selected{color:#217dd9;text-decoration:none}
.form .ft-verSelect-inner-a:hover{background:#ecf5fa;text-decoration:none}
.ft-mailver-darr{position:absolute;width:7px;height:4px;overflow:hidden;right:0;top:5px;}
.ft-mailver-darr i{background:#217dd9}
.ft-verSelect-tick{height:13px;width:13px;overflow:hidden;left:4px;position:absolute;top:0}
/* 输入框 */
.ipt-t{line-height:0;font-size:0;border-radius:2px;position:relative;+zoom:1;height:46px;border:1px solid #BAC7D2;background-color:#ECF5FA;box-shadow:0 0 2px RGBA(0,46,115,.25) inset;font-family:'Microsoft Yahei';z-index: 1;}
.ipt-t input{width:320px;outline:none;background:none;border:none;height:19px;margin:0;padding:13px 10px;_padding-bottom:10px;font-size:14px;line-height:normal;color:#000;font-weight:bold;margin-top;1px;}
.ipt-t label{position:absolute;left:0;top:12px;line-height:normal;font-size:16px;color:#90A2BC}
#capsLockHint{position: absolute; top: 47px; left: 0px;padding: 4px 8px; font-size:12px; line-height: 12px; background-color: #ffffcc; border: 1px solid #d7d7d7; color: #555; z-index: 2;}
.ipt-t .domain{position:absolute;font-size:14px;font-weight:bold;font-family:verdana;height:46px;width:105px;border-left:1px solid #E0E9ED;text-align:center;color:#5E6F88;line-height:46px;background-color:#F7FBFD;right:0;top:0}
.ipt-t .btn-login{position:absolute;top:3px;right:3px;cursor:pointer;}
.ipt-t-hover{border-color:#93afc6}
.ipt-t-hover label{color:#6C88B3}
.ipt-t-focus{border-color:#7dc4ff}
.ipt-t-focus label{color:#6D89B3}
/* 顶部 */
header{position:relative;z-index:11;height:45px}
header .bg{position:absolute;left:0;top:0;width:100%;height:45px;background-color:#000;opacity:0.5;filter:alpha(opacity=50);_filter:alpha(opacity=100);_background-color:#1b1b1b}
header .inner{position:relative;width:680px;margin:0 auto}
header h1{position:absolute;top:9px;left:1px;opacity:0.6;filter:alpha(opacity=60);_background-image:url(/jsp/common/images/logo.png);}
header h1 img{_visibility:hidden}
header .ext{position:absolute;right:0;line-height:normal;top:15px;}
header .link{padding-left:20px;color:#6B8798;display:inline-block;}
/* 主要 */
.main{position:relative;z-index:10}
.main .inner{width:680px;margin:0 auto;position:relative;+zoom:1}
.tab{position:relative;+zoom:1}
.tab-panel{position:absolute;left:220px;top:100px}
.main h3{position:absolute;z-index:1;width:298px;height:26px;background-position:0 -64px;top:-80px;left:0}
/* 主题背景 */
.theme{overflow:hidden;position:absolute;z-index:5;width:100%;height:100%;left:0;top:0;background:url('/jsp/common/images/all4.jpg') center center no-repeat;}
.bd .showPlaceholder .placeholder{visibility:visible;cursor:text;}
.bd .placeholder{font-size:16px;text-indent:12px;position:absolute;background:none;width:250px;visibility:hidden;}

#divError{padding:0 9px;width:320px;line-height:19px;position:absolute;top:130px;left:60px;color:#ff0000;background-color:#fff799;}
.ft-ext{position:absolute;top:256px;right:60px;}

.iptLayer{position:absolute;left:-1px;top:50px;background:#ECF5FA;border:1px solid #C6D1DA;width:338px;color:#9FB0C6;font-size:14px;line-height:2;padding:5px 0}
.iptLayer p,
.iptLayer li a{padding:0 24px;}
.iptLayer li a{display: block;color:#405A73!important;overflow:hidden;text-overflow:ellipsis;}
.iptLayer li a.iptLayer-selected,
.iptLayer li a:hover{background:#D0E5F2;text-decoration: none}
/* 对话框
============================== */
.g-dialogBox{display:none;position:absolute;width:430px;z-index:101;left:50%;top:50%;margin-left:-215px;margin-top:-77px;px;border-radius:2px 2px 0 0}
.g-dialogBox{-webkit-box-shadow:0 0 15px #888;-moz-box-shadow:0 0 15px #888;box-shadow:0 0 15px #888}
.g-dialogBox-text{font-size:14px;}
.g-dialogBox-hd{height:27px;line-height:27px;margin:0 2px;padding:0 10px;background-position:0 -224px;color:#fff;position:relative}
.g-dialogBox-hd-rc{position:absolute;top:0;width:2px;height:27px}
.g-dialogBox-hd-rc-1{left:-2px;background-position:0 -96px}
.g-dialogBox-hd-rc-2{right:-2px;background-position:-2px -96px}
.g-dialogBox-hd-title{font-size:14px}
.g-dialogBox-hd-ext{position:absolute;top:3px;right:3px;line-height:20px}
.g-dialogBox-hd-oprt{float:right;width:20px;height:20px}
.g-dialogBox-hd-oprt-close{background-position:0 -128px}
.g-dialogBox-hd-oprt-close:hover{background-position:0 -160px}
.g-dialogBox-hd-oprt-close:active{background-position:0 -192px}
.g-dialogBox-bd{background:#fff;border-width:0 1px 1px;border-style:solid}
/* 简单内容 */
.g-dialogBox-simpleContent{padding:30px 30px}
.g-dialogBox-simpleContent .title{text-align:center;color:#f00;font-size:14px;font-weight:bold}
.g-dialogBox-ft{height:42px;padding:0 10px;border-width:0 1px 1px;border-style:solid}
.g-dialogBox-ft-oprt{/*position:absolute;right:10px;top:8px;*/float:right;display:inline;margin:8px 0 0 0;+margin-right:-10px}
.g-dialogBox-ft-oprt .g-btn{margin-left:10px}
.g-dialogBox-ft-ext{float:left;margin-top:13px;line-height:normal}
.g-btn{font-size:12px;height:24px;padding:0 3px;position:relative}
.g-btn-inner{border-color: #969696;height:24px;line-height:23px;+line-height:25px;padding:0 8px;color:#000!important;vertical-align:baseline;text-decoration:none;outline:none;overflow:hidden;background-position:0 -256px}
.g-btn-inner:hover{text-decoration:none;}
.g-btn-rc{width:3px;height:100%;position:absolute;top:0;cursor:pointer}
.g-btn-rc-1{left:0;background-position:0 0}
.g-btn-rc-2{right:0;background-position:-3px 0}
/* 背景图-横向平铺 */
.g-dialogBox-hd,
.g-btn-inner{background-repeat:repeat-x}
.g-btn-inner,
.g-btn{display:inline-block;+display:inline;+zoom:1;vertical-align:middle}
@media screen and ( max-width : 479px ){
	.g-dialogBox{width:300px;margin-left:-150px;margin-top:-60px}
	.g-dialogBox-simpleContent{padding:15px 0 10px 10px}
	.g-dialogBox-simpleContent .ipt-t{width:100px;margin-right:4px}
	.g-dialogBox-simpleContent .at{margin-right:2px}
}
.g-dialogBox,
.g-dialogBox-simpleContent,
.g-dialogBox-simpleContent .at{-webkit-transition:all 0.5s}
.g-dialogBox-simpleContent .ipt-t{-webkit-transition:width 0.5s}
.mask{display:none;z-index:100;position:absolute;left:0;top:0;background:#000;filter:alpha(opacity=50);-moz-opacity:0.5;opacity:0.5}
.mask .iframe{display:none;_display:block;background:#000;filter:alpha(opacity=0);-moz-opacity:0;opacity:0;position:absolute;width:100%;height:100%;z-index:99}
/* 版权 */
.copyright{text-align:left;position:absolute;z-index:9;bottom:0;left:0;width:100%;height:45px}
.copyright .bg{position:absolute;left:0;top:0;width:100%;height:100%;background-color:#fff;opacity:0.4;filter:alpha(opacity=40)}
.copyright .inner{padding-top:14px;width:680px;margin:0 auto;position:relative;}
.copyright,.copyright a{color:#000}
.copy-item{margin-right:18px;vertical-align:top;opacity:0.4;filter:alpha(opacity=40)}
.copy-item-img{margin-right:0;position:absolute;right:0;top:15px;opacity:0.65;filter:alpha(opacity=65)}
.copy-item .sptln{margin-right:18px}

</style> 
</head>

<body class="mail-163">
<div id="loading" style="
    position: absolute;
    width: 100%;
    height: 100%;
    background: #003333;
    z-index: 11;
    TEXT-ALIGN: CENTER;
    padding-top: 300px;
    display:none;
	opacity:0.6;
">
    <div class="sk-spinner sk-spinner-three-bounce">
      <div class="sk-bounce1"></div>
      <div class="sk-bounce2"></div>
      <div class="sk-bounce3"></div>
    </div>
	<div class="sk-spinner sk-spinner-three-bounce" style="
    color: white;
    font-size: 25px;
    padding-top: 30px;
	">登录系统中。。。</div>
</div>
<div class="page" id="page">
	<header>
		<div class="bg"></div>
		<div class="inner" style="margin-left: 10px;">
			<h1><a href="" target="_blank"><img src="/jsp/common/images/logo.png" alt="Logo"  height="30" /></a></h1>
			
		</div>
	</header>
	<div class="main" id="main">
		<div class="inner">
			
			<div class="tab">
				
				<div class="tab-panel" style="margin-left: 100px;">
					<div class="form">
						<div id="LoginTitle" style="margin-top: 40px;"><font style="color: blue; font-size: 25px; font-weight: bold;">登录页面</font></div>
						<form class="bd" name="frmLogin" method="post" id="loginForm" >
							<!-- 帐号 -->
							<div class="ipt ipt-t user" id="idInputLine">
								<b class="ico"></b>
								<input type="text" id="userNameIpt" value="000001"  onfocus="javascript:if(this.value=='请输入用户名！')this.value='';" autocomplete="off"/>
							</div>
							<!-- 密码 -->
							<div class="ipt ipt-t pass" id="pwdInputLine">
								<input type="password" name="password"  id="pwdInput" value="admin" onfocus="javascript:if(this.value=='请输入密码！')this.value='';"/>
								<label for="pwdInput" class="placeholder" id="pwdPlaceholder">密码</label>
								<p id="capsLockHint" style="display: none">大写状态开启</p>
							</div>
							<div style="margin-top:30px">
							<button style="margin-left:40px" id="btnSubmit" title="注册" class="btn btn-login" type="button"><font style="text-align: center; color: white; font-size: 20px;">注册</font></button>
							<button onclick="login()" style="margin-left:50px" id="btnSubmit" title="登录" class="btn btn-login" type="button"><font style="text-align: center; color: white; font-size: 20px;">登录</font></button>
								
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
	<footer class="copyright">
		<div class="bg"></div>
		<div class="inner">
			<ul class="copy-list" style="text-align:center">
				<li class="copy-item">XX公司版权所有 &copy; 2015-2015</script></li>
				
				
				<!-- <li class="copy-item copy-item-img"><a id="KX_IMG" href="https://ss.knet.cn/verifyseal.dll?sn=e12051044010020841301459&amp;ct=df&amp;pa=363285" target="_blank"></a></li> -->
			</ul>
		</div>
	</footer>

	<!-- 背景 -->
	<div class="theme" id="theme"></div>
	</div>

</body>
</html>
<script>
function login(){
	var username=$("#userNameIpt").val();
	var password=$("#pwdInput").val();
	if(username!=""&&password!=""){
		$.post("/user/login.do",
		{
			userid:username,
			password:hex_md5(password)
		},
		function(data,status){
			if(data.resultcode==0){
				alert(data.description);
			}else if(data.resultcode==1){

				$("#loading").css("display","block");
				document.location.href="/jsp/sysmanage/index.jsp";
			}
		});
	}else{
		alert("用户名密码不能为空！");
	}
}
</script>