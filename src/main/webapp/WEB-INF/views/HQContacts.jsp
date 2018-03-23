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
				<a href="#">通讯录</a>
			</li>
			<li>
				<a href="#">总/分公司通讯录</a>
			</li>
			<li>
				<a href="#">操作</a>
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
						添加联系人
					</li>
				</ul>
			</div>
		</div>
		<div class="col-md-4">
			<div class="dropdown">
				<button class="btn btn-default dropdown-toggle" type="button"
					id="dropdownMenu1" data-toggle="dropdown" aria-haspopup="true"
					aria-expanded="true">
					请选择分公司
					<span class="caret"></span>
				</button>
				<ul class="dropdown-menu" aria-labelledby="dropdownMenu1">
					<li>
						<a href="#">北京分公司</a>
					</li>
					<li>
						<a href="#">成都分公司</a>
					</li>
					<li>
						<a href="#">上海分公司</a>
					</li>
					<li>
						<a href="#">南京分公司</a>
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
				<th>ID<i class="sort">
						<img src="${APP_PATH }/static/images/px.gif" />
					</i></th>
				<th>姓名</th>
				<th>性别</th>
				<th>联系方式</th>
				<th>入职时间</th>
				<th>操作</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td><input name="" type="checkbox" value="" /></td>
				<td>20130908</td>
				<td>谷晨飞</td>
				<td>男</td>
				<td>1315616168</td>
				<td>2013-09-09 15:05</td>
				<td><a href="#" class="click tablelink">修改</a> <a href="#"
						class="tablelink"> 删除</a></td>
			</tr>

			<tr>
				<td><input name="" type="checkbox" value="" /></td>
				<td>20130908</td>
				<td>谷晨飞</td>
				<td>男</td>
				<td>1315616168</td>
				<td>2013-09-09 15:05</td>
				<td><a href="#" class="click tablelink">修改</a> <a href="#"
						class="tablelink"> 删除</a></td>
			</tr>

			<tr>
				<td><input name="" type="checkbox" value="" /></td>
				<td>20130908</td>
				<td>谷晨飞</td>
				<td>男</td>
				<td>1315616168</td>
				<td>2013-09-09 15:05</td>
				<td><a href="#" class="click tablelink">修改</a> <a href="#"
						class="tablelink"> 删除</a></td>
			</tr>

			<tr>
				<td><input name="" type="checkbox" value="" /></td>
				<td>20130908</td>
				<td>谷晨飞</td>
				<td>男</td>
				<td>1315616168</td>
				<td>2013-09-09 15:05</td>
				<td><a href="#" class="click tablelink">修改</a> <a href="#"
						class="tablelink"> 删除</a></td>
			</tr>

			<tr>
				<td><input name="" type="checkbox" value="" /></td>
				<td>20130908</td>
				<td>谷晨飞</td>
				<td>男</td>
				<td>1315616168</td>
				<td>2013-09-09 15:05</td>
				<td><a href="#" class="click tablelink">修改</a> <a href="#"
						class="tablelink"> 删除</a></td>
			</tr>

			<tr>
				<td><input name="" type="checkbox" value="" /></td>
				<td>20130908</td>
				<td>谷晨飞</td>
				<td>男</td>
				<td>1315616168</td>
				<td>2013-09-09 15:05</td>
				<td><a href="#" class="click tablelink">修改</a> <a href="#"
						class="tablelink"> 删除</a></td>
			</tr>

			<tr>
				<td><input name="" type="checkbox" value="" /></td>
				<td>20130908</td>
				<td>谷晨飞</td>
				<td>男</td>
				<td>1315616168</td>
				<td>2013-09-09 15:05</td>
				<td><a href="#" class="click tablelink">修改</a> <a href="#"
						class="tablelink"> 删除</a></td>
			</tr>

			<tr>
				<td><input name="" type="checkbox" value="" /></td>
				<td>20130908</td>
				<td>谷晨飞</td>
				<td>男</td>
				<td>1315616168</td>
				<td>2013-09-09 15:05</td>
				<td><a href="#" class="click tablelink">修改</a> <a href="#"
						class="tablelink"> 删除</a></td>
			</tr>

			<tr>
				<td><input name="" type="checkbox" value="" /></td>
				<td>20130908</td>
				<td>谷晨飞</td>
				<td>男</td>
				<td>1315616168</td>
				<td>2013-09-09 15:05</td>
				<td><a href="#" class="click tablelink">修改</a> <a href="#"
						class="tablelink"> 删除</a></td>
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