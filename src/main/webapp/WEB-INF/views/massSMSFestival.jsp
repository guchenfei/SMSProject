<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" lang="zh-CN">

<head>
<title></title>
<%
	pageContext.setAttribute("APP_PATH", request.getContextPath());
%>
<!-- 引入CSS样式 -->
<link href="${APP_PATH }/static/css/style.css" rel="stylesheet">
<!-- 引入js -->
<script src="${APP_PATH }/static/js/jquery3.3.1.min.js"></script>
<!-- 引入bootstrap css -->
<link type="text/css" rel="stylesheet" href="${APP_PATH }/static/bootstrap-3.3.7-dist/css/bootstrap.min.css" />
<!-- 引入bootstrap js -->
<script type="text/javascript" src="${APP_PATH }/static/bootstrap-3.3.7-dist/js/bootstrap.min.js" />
</script>

<script type="text/javascript">
	$(".form_datetime").datetimepicker({
		format : "dd MM yyyy - hh:ii",
		autoclose : true,
		todayBtn : true,
		startDate : "2013-02-14 10:00",
		minuteStep : 10
	});
</script>
</head>

<body>
	<div class="place">
		<span>位置：</span>
		<ul class="placeul">
			<li>
				<a href="#">短信群发</a>
			</li>
			<li>
				<a href="#">节日慰问</a>
			</li>
			<li>
				<a href="#">操作</a>
			</li>
		</ul>
	</div>
	<form>
		<div class="row">
			<div class="col-md-12">
				<div class="input-group">
					<span class="input-group-addon" id="basic-addon1">接收者：</span>
					<input type="text" class="form-control"
						placeholder="请点击下方选择要发送的子公司..." aria-describedby="basic-addon1">
				</div>
			</div>
		</div>
		<div>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</div>
		<div class="row">
			<div class="col-md-4">
				<span class="label label-info">选择短信接收公司：</span>
			</div>
			<div class="col-md-8">
				<label class="checkbox-inline"> <input type="checkbox"
					id="inlineCheckbox1" value="option1">总部 </label> <label
					class="checkbox-inline"> <input type="checkbox"
					id="inlineCheckbox2" value="option2">成都分公司 </label> <label
					class="checkbox-inline"> <input type="checkbox"
					id="inlineCheckbox3" value="option3">上海分公司 </label> <label
					class="checkbox-inline"> <input type="checkbox"
					id="inlineCheckbox3" value="option3">南京分公司 </label>
			</div>
		</div>
		<div>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</div>
		<div class="row">
			<div class="col-md-6">
				<span class="label label-info">短信内容：</span>
				<div>&nbsp;&nbsp;&nbsp;</div>
				<textarea class="form-control" rows="8" placeholder="请输入短信内容..."></textarea>
			</div>
			<div class="col-md-6">
				<span class="label label-info">短信预览：</span>
				<div>&nbsp;&nbsp;&nbsp;</div>
				<textarea class="form-control" rows="8" placeholder="请输入短信内容..." readonly="readonly"></textarea>
			</div>
		</div>
		</div>
		<div>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</div>
		<div class="row">
			<div class="col-md-6">
				<span class="label label-info">右侧选择节日模板：</span>
			</div>
			<div class="col-md-6">
				<select class="form-control">
					<option>元旦</option>
					<option>春节</option>
					<option>劳动节</option>
					<option>端午节</option>
					<option>中秋节</option>
					<option>国庆节</option>
					<option>圣诞节</option>
				</select>
			</div>
		</div>
		<div>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</div>
		<div class="row">
			<div class="col-md-6">
				<span class="label label-info ">右侧选择发送时间：</span>
			</div>
			<div class="col-md-6">
				<div class="form-group">
					<span class="label label-info">选择日期+时间：</span>
					<div>&nbsp;</div>
					<!--指定 date标记-->
					<div class='input-group date' id='datetimepicker2'>
						<input type='text' class="form-control" />
						<span class="input-group-addon">
							<span class="glyphicon glyphicon-calendar"></span>
						</span>
					</div>
				</div>
			</div>
		</div>
		<div>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</div>
		<div class="row">
			<div class="col-md-6">
				<button type="submit" class="btn btn-info">发送</button>
			</div>
			<div class="col-md-6">
				<button type="reset" class="btn btn-info">重置</button>
			</div>
		</div>
	</form>
</body>

</html>