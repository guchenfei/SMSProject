<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title></title>
<%
	pageContext.setAttribute("APP_PATH", request.getContextPath());
%>
<!-- 引入CSS样式 -->
<link href="${APP_PATH }/static/css/style.css" rel="stylesheet">
<!-- 引入js -->
<script src="${APP_PATH }/static/js/jquery3.3.1.min.js"></script>
<!-- 引入bootstrap css -->
<link type="text/css" rel="stylesheet"
	href="${APP_PATH }/static/bootstrap-3.3.7-dist/css/bootstrap.min.css" />
<!-- 引入bootstrap js -->
<script type="text/javascript"
	src="${APP_PATH }/static/bootstrap-3.3.7-dist/js/bootstrap.min.js">
	
</script>
<script language="javascript" type="text/javascript"
	src="${APP_PATH }/static/My97DatePicker/WdatePicker.js"></script>
</head>

<body>
	<div class="place">
		<span>位置：</span>
		<ul class="placeul">
			<li>
				<a href="#">统计查询</a>
			</li>
			<li>
				<a href="#">公司群发详情</a>
			</li>
			<li>
				<a href="#">操作</a>
			</li>
		</ul>
	</div>
	<!-- 搭建显示页面 -->
	<div>
		<div class="row tools">
			<div class="col-md-3">
				<ul class="toolbar">
					<li id="admin_add_modal_btn">
						<span>
							<img src="${APP_PATH }/static/images/t01.png" />
						</span>
						<font style="font-size: 11px">添加管理员/业务员</font>
					</li>
				</ul>
			</div>
			<div class="col-md-3">
				<button type="button" class="btn-danger btn btn-default"
					id="admin_mutiDelete_btn">
					<span class="glyphicon glyphicon-trash"></span>
					批量删除
				</button>
			</div>
			<div class="col-md-3">
				<select class="form-control" id="selectByRole">
					<!-- 按公司查询统计情况 -->
					<option value="#">按公司查询</option>
					<option value="0">北京总部</option>
					<option value="1">成都分公司</option>
					<option value="2">西安分公司</option>
				</select>
			</div>
			<div class="col-md-3">
				<ul class="toolbar1">
					<li>
						<span>
							<img src="${APP_PATH }/static/images/t05.png" />
						</span>
						设置
					</li>
				</ul>
			</div>
		</div>
		<!-- 显示表格数据 -->
		<div class="row">
			<div class="col-md-12">
				<table class="table table-striped table-hover" id="admins_table">
					<thead>
						<tr>
							<th><input name="" type="checkbox" value="" id="check_all" /></th>
							<th>任务ID</th>
							<th>创建人</th>
							<th>创建时间</th>
							<th>任务主题</th>
							<th>任务描述</th>
							<th>群发类型</th>
							<th>群发内容</th>
							<th>定时时间</th>
							<th>接收对象</th>
							<!-- 发送状态0:已发送，1:待发送 -->
							<th>状态</th>
							<th>接收详情</th>
							<th>操作</th>
						</tr>
					</thead>
					<tbody>
					</tbody>
				</table>
			</div>
		</div>
	</div>
	<!-- 显示分页信息 -->
	<div class="row">
		<!-- 分页文字信息 -->
		<div class="col-md-4" id="page_info_area"></div>
		<div class="col-md-4"></div>
		<!-- 分页条信息 -->
		<div class="col-md-4" id="page_nav_area"></div>
	</div>
</body>
</html>