<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
	<table class="tablelist">
		<thead>
			<tr>
				<th><input name="" type="checkbox" value="" checked="checked" /></th>
				<th>编号ID<i class="sort">
						<img src="${APP_PATH }/static/images/px.gif" />
					</i></th>
				<th>所属分公司</th>
				<th>姓名</th>
				<th>性别</th>
				<th>入职时间</th>
				<th>工龄</th>
				<th>操作</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td><input name="" type="checkbox" value="" /></td>
				<td>20130908</td>
				<td>北京总部</td>
				<td>admin</td>
				<td>江苏南京</td>
				<td>2013-09-09 15:05</td>
				<td>已审核</td>
				<td><a href="#" class="click tablelink">修改</a> <a href="#"
						class="tablelink"> 删除</a></td>
			</tr>

			<tr>
				<td><input name="" type="checkbox" value="" /></td>
				<td>20130907</td>
				<td>温州19名小学生中毒流鼻血续：周边部分企业关停</td>
				<td>admin</td>
				<td>山东济南</td>
				<td>2013-09-08 14:02</td>
				<td>未审核</td>
				<td><a href="#" class="tablelink">查看</a> <a href="#"
						class="tablelink">删除</a></td>
			</tr>

			<tr>
				<td><input name="" type="checkbox" value="" /></td>
				<td>20130906</td>
				<td>社科院:电子商务促进了农村经济结构和社会转型</td>
				<td>user</td>
				<td>江苏无锡</td>
				<td>2013-09-07 13:16</td>
				<td>未审核</td>
				<td><a href="#" class="tablelink">查看</a> <a href="#"
						class="tablelink">删除</a></td>
			</tr>

			<tr>
				<td><input name="" type="checkbox" value="" /></td>
				<td>20130905</td>
				<td>江西&quot;局长违规建豪宅&quot;：局长检讨</td>
				<td>admin</td>
				<td>北京市</td>
				<td>2013-09-06 10:36</td>
				<td>已审核</td>
				<td><a href="#" class="tablelink">查看</a> <a href="#"
						class="tablelink">删除</a></td>
			</tr>

			<tr>
				<td><input name="" type="checkbox" value="" /></td>
				<td>20130904</td>
				<td>中国2020年或迈入高收入国家行列</td>
				<td>admin</td>
				<td>江苏南京</td>
				<td>2013-09-05 13:25</td>
				<td>已审核</td>
				<td><a href="#" class="tablelink">查看</a> <a href="#"
						class="tablelink">删除</a></td>
			</tr>

			<tr>
				<td><input name="" type="checkbox" value="" /></td>
				<td>20130903</td>
				<td>深圳地铁车门因乘客拉闸打开 3人被挤入隧道</td>
				<td>user</td>
				<td>广东深圳</td>
				<td>2013-09-04 12:00</td>
				<td>已审核</td>
				<td><a href="#" class="tablelink">查看</a> <a href="#"
						class="tablelink">删除</a></td>
			</tr>

			<tr>
				<td><input name="" type="checkbox" value="" /></td>
				<td>20130902</td>
				<td>33次地表塌陷 村民不敢下地劳作(图)</td>
				<td>admin</td>
				<td>湖南长沙</td>
				<td>2013-09-03 00:05</td>
				<td>未审核</td>
				<td><a href="#" class="tablelink">查看</a> <a href="#"
						class="tablelink">删除</a></td>
			</tr>

			<tr>
				<td><input name="" type="checkbox" value="" /></td>
				<td>20130901</td>
				<td>医患关系：医生在替改革不彻底背黑锅</td>
				<td>admin</td>
				<td>江苏南京</td>
				<td>2013-09-02 15:05</td>
				<td>未审核</td>
				<td><a href="#" class="tablelink">查看</a> <a href="#"
						class="tablelink">删除</a></td>
			</tr>

			<tr>
				<td><input name="" type="checkbox" value="" /></td>
				<td>20130900</td>
				<td>山东章丘公车进饭店景点将自动向监控系统报警</td>
				<td>admin</td>
				<td>山东滨州</td>
				<td>2013-09-01 10:26</td>
				<td>已审核</td>
				<td><a href="#" class="tablelink">查看</a> <a href="#"
						class="tablelink">删除</a></td>
			</tr>
		</tbody>
	</table>

	<div class="pagin">
		<div class="message">
			共
			<i class="blue">1256</i>
			条记录，当前显示第&nbsp;
			<i class="blue">2&nbsp;</i>
			页
		</div>
		<ul class="paginList">
			<li class="paginItem">
				<a href="javascript:;">
					<span class="pagepre"></span>
				</a>
			</li>
			<li class="paginItem">
				<a href="javascript:;">1</a>
			</li>
			<li class="paginItem current">
				<a href="javascript:;">2</a>
			</li>
			<li class="paginItem">
				<a href="javascript:;">3</a>
			</li>
			<li class="paginItem">
				<a href="javascript:;">4</a>
			</li>
			<li class="paginItem">
				<a href="javascript:;">5</a>
			</li>
			<li class="paginItem more">
				<a href="javascript:;">...</a>
			</li>
			<li class="paginItem">
				<a href="javascript:;">10</a>
			</li>
			<li class="paginItem">
				<a href="javascript:;">
					<span class="pagenxt"></span>
				</a>
			</li>
		</ul>
	</div>

	<div class="tip">
		<div class="tiptop">
			<span>提示信息</span>
			<a></a>
		</div>

		<div class="tipinfo">
			<span>
				<img src="images/ticon.png" />
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