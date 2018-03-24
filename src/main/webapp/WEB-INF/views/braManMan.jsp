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
	<script type="text/javascript">
		$(document).ready(function() {
			$(".click").click(function() {
				$(".tip").fadeIn(200);
			});

			$(".tiptop a").click(function() {
				$(".tip").fadeOut(200);
			});

			$(".sure").click(function() {
				$(".tip").fadeOut(100);
			});

			$(".cancel").click(function() {
				$(".tip").fadeOut(100);
			});

		});
	</script>
</head>

<body>
	<div class="place">
		<span>位置：</span>
		<ul class="placeul">
			<li>
				<a href="#">公司角色管理</a>
			</li>
			<li>
				<a href="#">公司角色授权</a>
			</li>
			<li>
				<a href="#">操作</a>
			</li>
		</ul>
	</div>
	<!-- 搭建显示页面 -->
	<div>
		<div class="row tools">
			<div class="col-md-4">
				<div class="col-md-6">
					<ul class="toolbar">
						<li class="click">
							<span>
								<img src="${APP_PATH }/static/images/t01.png" />
							</span>
							添加管理员/业务员
						</li>
					</ul>
				</div>
			</div>
			<div class="col-md-4">
				<div class="dropdown">
					<button class="btn btn-default dropdown-toggle" type="button"
						id="dropdownMenu1" data-toggle="dropdown" aria-haspopup="true"
						aria-expanded="true">
						按角色查询
						<span class="caret"></span>
					</button>
					<ul class="dropdown-menu" aria-labelledby="dropdownMenu1">
						<li>
							<a href="#">管理员</a>
						</li>
						<li>
							<a href="#">业务员</a>
						</li>
					</ul>
				</div>
			</div>
			<div class="col-md-4">
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
				<table class="table table-striped table-hover">
					<tr>
						<th><input name="" type="checkbox" value="" /></th>
						<th>用户ID</th>
						<th>姓名</th>
						<th>密码</th>
						<th>性别</th>
						<th>生日</th>
						<th>联系方式</th>
						<th>居住地址</th>
						<th>邮箱</th>
						<th>角色</th>
						<th>所属分公司</th>
						<th>操作</th>
					</tr>
					<c:forEach items="${pageInfo.list}" var="admin">
						<tr>
							<th><input name="" type="checkbox" value="" /></th>
							<th>${admin.adminId}</th>
							<th>${admin.username}</th>
							<th>******</th>
							<!-- 性别（userSex男0女1） -->
							<th>${admin.usersex=="0"?"男":"女"}</th>
							<th>${admin.userbirthday}</th>
							<th>${admin.userpnum}</th>
							<th>${admin.useraddress}</th>
							<th>${admin.useremail}</th>
							<th>${admin.usertype}</th>
							<th>${admin.company.companyname}</th>
							<th>
								<button type="button" class="btn-primary btn-xs"
									aria-label="Left Align">
									<span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>
									修改
								</button>
								<button type="button" class="btn-danger btn-xs"
									aria-label="Left Align">
									<span class="glyphicon glyphicon-trash" aria-hidden="true"></span>
									删除
								</button>
							</th>
						</tr>
					</c:forEach>
				</table>
			</div>
		</div>
		<!-- 显示分页信息 -->
		<div class="row">
			<!-- 分页文字信息 -->
			<div class="col-md-4">
				当前第&nbsp;<font style="color: #104E8B;">${pageInfo.pageNum}</font>&nbsp;页,总共&nbsp;<font
					style="color: #104E8B;">${pageInfo.pages}</font>&nbsp;页，总共&nbsp;<font
					style="color: #104E8B;">${pageInfo.total}</font>&nbsp;条记录
			</div>
			<div class="col-md-4"></div>
			<!-- 分页条信息 -->
			<div class="col-md-4">
				<nav aria-label="Page navigation">
				<ul class="pagination">
					<li>
						<a href="${APP_PATH}/allAdmin?pn=1">首页</a>
					</li>
					<c:if test="${pageInfo.hasPreviousPage}">
						<li>
							<a href="${APP_PATH}/allAdmin?pn=${pageInfo.pageNum-1}"
								aria-label="Previous">
								<span aria-hidden="true">&laquo;</span>
							</a>
						</li>
					</c:if>
					<c:forEach items="${pageInfo.navigatepageNums}" var="page_Num">
						<c:if test="${ page_Num == pageInfo.pageNum}">
							<li class="active">
								<a href="#">${page_Num}</a>
							</li>
						</c:if>
						<c:if test="${ page_Num != pageInfo.pageNum}">
							<li>
								<a href="${APP_PATH}/allAdmin?pn=${page_Num}">${page_Num}</a>
							</li>
						</c:if>
					</c:forEach>
					<c:if test="${pageInfo.hasNextPage}">
						<li>
							<a href="${APP_PATH}/allAdmin?pn=${pageInfo.pageNum+1}"
								aria-label="Next">
								<span aria-hidden="true">&raquo;</span>
							</a>
						</li>
					</c:if>
					<li>
						<a href="${APP_PATH}/allAdmin?pn=${pageInfo.pages}">末页</a>
					</li>
				</ul>
				</nav>
			</div>
		</div>

	</div>
	<div class="tip">
		<div class="tiptop">
			<span>提示信息</span>
			<a></a>
		</div>

		<div class="tipinfo">
			<span>
				<img src="${APP_PATH }/static/images/ticon.png" />
			</span>
			<div class="tipright">
				<p>是否确认对信息的修改 ？</p>
				<cite>如果是请点击确定按钮 ，否则请点取消。</cite>
			</div>
		</div>

		<div class="tipbtn">
			<input name="" type="button" class="sure" value="确定" />&nbsp; <input
				name="" type="button" class="cancel" value="取消" />
		</div>
	</div>
	</div>
	<script type="text/javascript">
		$('.tablelist tbody tr:odd').addClass('odd');
	</script>
</body>
</html>