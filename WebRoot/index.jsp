<%@ page language="java" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>记录日志 - 登录</title>

<link rel="stylesheet" type="text/css" href="themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="themes/icon.css">
<link rel="stylesheet" type="text/css" href="css/demo.css">
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/jquery.easyui.min.js"></script>

</head>

<body>
	<h2>记录日志</h2>
	<div style="margin:20px 0;"></div>
	<form action="login.action" method="post" id="form">
		<div class="easyui-panel" title="Login to system  ${requestScope.errormsg }"
			style="width:400px;padding:30px 70px 20px 70px">
			<div style="margin-bottom:10px">
				<input class="easyui-textbox"
					style="width:100%;height:40px;padding:12px"
					data-options="prompt:'Username',iconCls:'icon-man',iconWidth:38"
					name="user.username">
			</div>
			<div style="margin-bottom:20px">
				<input class="easyui-textbox" type="password"
					style="width:100%;height:40px;padding:12px"
					data-options="prompt:'Password',iconCls:'icon-lock',iconWidth:38"
					name="user.password">
			</div>
			<div>
				<a onclick="form.submit();" class="easyui-linkbutton"
					data-options="iconCls:'icon-ok'"
					style="padding:5px 0px;width:100%;"> <span
					style="font-size:14px;">Login</span>
				</a>
			</div>
		</div>
	</form>
</body>
</html>