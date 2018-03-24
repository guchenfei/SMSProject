<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>欢迎登录集团财务公司后台管理系统</title>
<%
	pageContext.setAttribute("APP_PATH", request.getContextPath());
%>

<!-- 最新版本的 Bootstrap 核心 CSS 文件 -->
<link type="text/css" rel="stylesheet"
	href="${APP_PATH }/static/bootstrap-3.3.7-dist/css/bootstrap.min.css" />
<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script type="text/javascript"
	src="${APP_PATH }/static/bootstrap-3.3.7-dist/js/bootstrap.min.js" />
</script>
<!-- 引入CSS样式 -->
<link href="${APP_PATH }/static/css/style.css" rel="stylesheet">
	<!-- 引入js -->
	<script src="${APP_PATH }/static/js/jquery3.3.1.min.js"></script>
	<script src="${APP_PATH }/static/js/cloud.js"></script>

	<script language="javascript">
		$(function() {
			$('.loginbox').css({
				'position' : 'absolute',
				'left' : ($(window).width() - 692) / 2
			});
			$(window).resize(function() {
				$('.loginbox').css({
					'position' : 'absolute',
					'left' : ($(window).width() - 692) / 2
				});
			})
		});
	</script>
</head>

<body style="background-color: #1c77ac; background-image: src="${APP_PATH }/static/images/light.png";background-repeat:no-repeat; background-position:centertop; overflow:hidden;">
	<div id="mainBody">
		<div id="cloud1" class="cloud"></div>
		<div id="cloud2" class="cloud"></div>
	</div>
	<div class="logintop">
		<span>欢迎登录集团财务公司后台管理平台</span>
		<ul>
			<li>
				<a href="#">回首页</a>
			</li>
			<li>
				<a href="#">帮助</a>
			</li>
			<li>
				<a href="#">关于</a>
			</li>
		</ul>
	</div>
	<div class="loginbody">
		<span class="systemlogo"></span>
		<div class="loginbox">
			<form action="${APP_PATH}/login" method="post">
				<ul>
					<li>
						<input name="email" type="text" class="loginuser" value="123@qq.com"
							placeholder="请输入您的邮箱账号" onclick="JavaScript:this.value=''" />
					</li>
					<li>
						<input name="password" type="password" class="loginpwd" value="123"
							placeholder="请输入您的密码" onclick="JavaScript:this.value=''" />
					</li>

					<li>
						<input name="checkCode" type="text"
							style="height: 18px; border: 1px; solid; border-color: #000;"
							placeholder="请输入验证码" />
						<img id="checkCode" src="${APP_PATH}/checkCode.png" width="98"
							height="18" onclick="onCheckCode()" />
						<font style="color: red; font-weight: bold;">${msg}</font>
					</li>

					<li>
						<input name="" type="submit" class="loginbtn" value="登录" />
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<input name="" type="reset" class="loginbtn" value="重置" />
						<span style="color: red; font-weight: bold;">${msg}</span>
					</li>
				</ul>
			</form>
		</div>
	</div>
	<div class="loginbm">版权2018，仅供本公司所有</div>
	<script type="text/javascript">
		function onCheckCode() {
			document.getElementById("checkCode").src = "${APP_PATH}/checkCode.png?"
					+ Math.random();
		}
	</script>
</body>
</html>