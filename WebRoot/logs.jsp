<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
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

<title>记录日志 - 日志</title>

<link rel="stylesheet" type="text/css" href="themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="themes/icon.css">
<link rel="stylesheet" type="text/css" href="css/demo.css">
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/jquery.easyui.min.js"></script>

</head>

<body>

	<%
		if (session.getAttribute("LOGIN_USER") == null) {
			response.sendRedirect("index.jsp");
		}
	%>

	<h2>记录日志</h2>
	<p>
		欢迎，${sessionScope.LOGIN_USER.realname }！&nbsp;&nbsp;<a
			href="logout.action">退出</a>
	</p>
	<div style="margin:20px 0;"></div>
	<div class="easyui-layout" style="width:700px;height:550px;">
		<div id="p" data-options="region:'west'" title="目录"
			style="width:30%;padding:10px">
			<c:forEach var="l" items="${requestScope.logs }">
				<p style="margin: 5px 0;">
					<a href="findbyid.action?id=${l.lid }">${l.users.realname
						}_${l.createtime }</a>
				</p>
			</c:forEach>
		</div>
		<div data-options="region:'center'" title="正文"
			style="padding-left: 50px;">
			<form action="logadd.action" method="post" id="form">
				<c:if test="${sessionScope.log_show.lid != null }">
					<div style="margin:5px 0;">已选择日志：${sessionScope.log_show.users.realname
						}_${sessionScope.log_show.createtime }</div>
				</c:if>
				<div style="margin:5px 0;">今日工作</div>
				<input class="easyui-textbox" data-options="multiline:true"
					value="${sessionScope.log_show.txt1 }" style="width:300px;height:100px"
					name="log.txt1">
				<div style="margin:5px 0;">遇到问题</div>
				<input class="easyui-textbox" data-options="multiline:true"
					value="${sessionScope.log_show.txt2 }" style="width:300px;height:100px"
					name="log.txt2">
				<div style="margin:5px 0;">其他</div>
				<input class="easyui-textbox" data-options="multiline:true"
					value="${sessionScope.log_show.txt3 }" style="width:300px;height:100px"
					name="log.txt3">
				<div style="width:300px;margin:10px 0;text-align: center;">
					<a id="a_add" href="javascript:void(0);" class="easyui-linkbutton"
						data-options="iconCls:'icon-ok'"
						style="padding:5px 0px;width:100px;"> <span
						style="font-size:14px;">记录日志</span>
					</a> <a id="a_update" href="javascript:void(0);"
						class="easyui-linkbutton" data-options="iconCls:'icon-ok'"
						style="padding:5px 0px;width:100px;"> <span
						style="font-size:14px;">修改日志</span>
					</a>
				</div>
				<input type="hidden" name="log.lid" value="${sessionScope.log_show.lid }">
			</form>
		</div>
	</div>
</body>
<script type="text/javascript">
	$(function() {
		$('#a_add').click(function() {
			if (confirm('确定新增日志？')) {
				form.submit();
			}
		});
		$('#a_update').click(function() {
			if ($('input[name="log.lid"]').val() == '') {
				alert('请先选择要修改的日志');
				return;
			} else {
				$('#form').attr('action', 'logupdate.action');
				form.submit();
			}
		});
	});
</script>
</html>
