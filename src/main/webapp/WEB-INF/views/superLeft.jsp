<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>左边导航栏</title>
<%
	pageContext.setAttribute("APP_PATH", request.getContextPath());
%>
<!-- 引入CSS样式 -->
<link href="${APP_PATH }/static/css/style.css" rel="stylesheet">
	<!-- 引入js -->
	<script src="${APP_PATH }/static/js/jquery3.3.1.min.js"></script>
	<script type="text/javascript">
		$(function() {
			//导航切换
			$(".menuson li").click(function() {
				$(".menuson li.active").removeClass("active")
				$(this).addClass("active");
			});

			$('.title').click(function() {
				var $ul = $(this).next('ul');
				$('dd').find('ul').slideUp();
				if ($ul.is(':visible')) {
					$(this).next('ul').slideUp();
				} else {
					$(this).next('ul').slideDown();
				}
			});
		})
	</script>
</head>

<body style="background: #f0f9fd;">
	<div class="lefttop">
		<span></span>
		超级管理员界面
	</div>

	<dl class="leftmenu">

		<dd>
			<div class="title">
				<span>
					<img src="${APP_PATH }/static/images/leftico01.png" />
				</span>
				公司角色管理
			</div>
			<ul class="menuson">
				<li class="active">
					<cite></cite>
					<a href="./braManMan" target="rightFrame">公司角色授权</a>
					<i></i>
				</li>
			</ul>
		</dd>

		<dd>
			<div class="title">
				<span>
					<img src="${APP_PATH }/static/images/leftico02.png" />
				</span>
				通讯录
			</div>
			<ul class="menuson">
				<li>
					<cite></cite>
					<a href="./HQContacts" target="rightFrame">总/分公司通讯录</a>
					<i></i>
				</li>
			</ul>
		</dd>
		<dd>
			<div class="title">
				<span>
					<img src="${APP_PATH }/static/images/leftico03.png" />
				</span>
				短信群发
			</div>
			<ul class="menuson">
				<li>
					<cite></cite>
					<a href="./massSMS" target="rightFrame">通知群发/节日慰问</a>
					<i></i>
				</li>
			</ul>
		</dd>
		<dd>
			<div class="title">
				<span>
					<img src="${APP_PATH }/static/images/leftico04.png" />
				</span>
				统计查询
			</div>
			<ul class="menuson">
				<li>
					<cite></cite>
					<a href="./statisticalQuery" target="rightFrame">各分公司群发详情</a>
					<i></i>
				</li>
			</ul>
		</dd>
	</dl>
</body>

</html>