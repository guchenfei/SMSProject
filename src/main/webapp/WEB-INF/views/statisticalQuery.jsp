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
<link href="${APP_PATH }/static/css/style.css" rel="stylesheet" />
<!-- 引入js -->
<script src="${APP_PATH }/static/js/jquery3.3.1.min.js"></script>
<!-- 引入bootstrap css -->
<link type="text/css" rel="stylesheet"
	href="${APP_PATH }/static/bootstrap-3.3.7-dist/css/bootstrap.min.css" />
<!-- 引入bootstrap js -->
<script type="text/javascript"
	src="${APP_PATH }/static/bootstrap-3.3.7-dist/js/bootstrap.min.js">
	
</script>
<script type="text/javascript"
	src="${APP_PATH }/static/bootstrap-3.3.7-dist/js/popover.js">
	
</script>
<script type="text/javascript"
	src="${APP_PATH }/static/bootstrap-3.3.7-dist/js/tooltip.js">
	
</script>
<script language="javascript" type="text/javascript"
	src="${APP_PATH }/static/My97DatePicker/WdatePicker.js"></script>
</head>

<body>






	<a tabindex="0" class="btn btn-lg btn-danger" role="button"
		data-toggle="popover" data-trigger="focus" title="Dismissible popover"
		data-content="And here's some amazing content. It's very engaging. Right?">可消失的弹出框</a>


	<!-- <script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>
	<script
		src="/twitter-bootstrap/twitter-bootstrap-v2/js/bootstrap-tooltip.js"></script>
	<script
		src="/twitter-bootstrap/twitter-bootstrap-v2/js/bootstrap-popover.js"></script>
	<script>
		$(function() {
			
		});
	</script> -->
	<!--查看内容模态框 -->
	<div class="modal fade" tabindex="-1" role="dialog" id="ContentModal">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title">Modal title</h4>
				</div>
				<div class="modal-body">
					<p>One fine body&hellip;</p>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
					<button type="button" class="btn btn-primary">Save changes</button>
				</div>
			</div>
			<!-- /.modal-content -->
		</div>
		<!-- /.modal-dialog -->
	</div>
	<!-- /.modal -->
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
				<select class="form-control" id="selectByCompany">
					<!-- 按公司查询统计情况 -->
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
				<table class="table table-striped table-hover"
					id="statistical_table">
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
		<div class="col-md-4" id="page_nav_area">
			<button type="button" class="btn btn-default" data-container="body"
				data-toggle="popover" data-placement="top"
				data-content="Vivamus sagittis lacus vel augue laoreet rutrum faucibus.">
				Popover on 顶部</button>
		</div>
	</div>
	<script type="text/javascript">
		//1,页面加载完成后，直接去发送ajax请求，要到分页数据
		$(function() {
			$('[data-toggle="popover"]').popover();
			//去首页
			getCompanies("#selectByCompany");
			to_page(1);
		});

		//发送指定的请求，跳到点击的页码页
		function to_page(pn) {
			$.ajax({
				url : "${APP_PATH }/Statistical",
				data : "pn=" + pn,
				type : "POST",
				success : function(result) {
					//1，解析并显示统计数据
					build_statistical_table(result);
					/* //2，解析并显示分页信息
					build_page_info(result);
					//3，解析显示分页条数据
					build_page_nav(result); */
				}
			});
		}

		/**
		 * 普通查询构建table
		 */
		function build_statistical_table(result) {
			//每次放新数据的时候要清空上次请求后的数据
			$("#statistical_table tbody").empty();
			var statisticals = result.extend.pageInfo.list;
			//遍历数据
			$
					.each(
							statisticals,
							function(index, item) {
								/* alert(item.username); */
								/* <th><input name="" type="checkbox" value="" /></th> */
								var checkboxTd = $("<td></td>").append(
										$("<input/>").attr("type", "checkbox")
												.addClass("check_item"));
								var srecordIdTd = $("<td></td>").append(
										item.srecordId);
								var adminTd = $("<td></td>").append(
										item.admin.username);
								var createtimeTd = $("<td></td>").append(
										item.createtime);
								var topicTd = $("<td></td>").append(item.topic);
								/* .attr("describetask",item.describetask).attr("title","任务描述").addClass(
										"btn-primary btn-xs").append(
										$("<span></span>").addClass(
												"glyphicon glyphicon-eye-open")).append(
										"点击查看"); =""
								="">hover for popover</a>*/
								/* <a  tabindex="0" class="btn btn-lg btn-danger" role="button"
								data-toggle="popover" data-trigger="focus" title="Dismissible popover"
								data-content="And here's some amazing content. It's very engaging. Right?">可消失的弹出框</a>
								 */
								var describetaskTd = $("<a></a>")
										.attr("tabindex", "0")
										.addClass("btn-primary btn-xs")
										.attr("role", "button")
										.attr("data-toggle", "popover")
										.attr("data-trigger", "focus")
										.attr("title", "Dismissible popove")
										.attr("data-content",
												"And here's some amazing content. It's very engaging. Right?")
											.append("点击查看");

								;
								/* 群发类型:0立即发送，1定时发送 */
								var masstypeTd = $("<td></td>").append(
										item.masstype == "0" ? "立即发送" : "定时发送");
								var smsconTd = $("<a></a>").append("点击查看")
										.attr("smscon", item.smscon).attr(
												"title", "短信内容");
								var reservetimeTd = $("<td></td>").append(
										item.reservetime);
								var companyTd = $("<td></td>").append(
										item.company.companyname);
								/* 发送状态0:已发送，1:待发送 */
								var statusTd = $("<td></td>").append(
										item.masstype == "0" ? "已发送" : "待发送");
								var receDetailsTd = $("<a></a>").append("点击查看")
										.attr("company_id",
												item.company.companyId).attr(
												"title", "接收者详情");
								var delBtn = $("<button></button>").addClass(
										"btn-danger btn-xs delete_btn").append(
										$("<span></span>").addClass(
												"glyphicon glyphicon-trash"))
										.append("删除");
								//为删除按钮添加自定义属性，来表示当前任务的属性
								delBtn.attr("delete_id", item.srecordId);
								var btnTd = $("<td></td>").append(delBtn);

								/*append方法执行完成以后还是返回原来的元素 <tr></tr>所以一直继续添加每行内容*/
								$("<tr></tr>").append(checkboxTd).append(
										srecordIdTd).append(adminTd).append(
										createtimeTd).append(topicTd).append(
										describetaskTd).append(masstypeTd)
										.append(smsconTd).append(reservetimeTd)
										.append(companyTd).append(statusTd)
										.append(receDetailsTd).append(btnTd)
										.appendTo("#statistical_table tbody");
							});
		}

		//查出所有的分公司信息并显示在下拉列表中
		function getCompanies(ele) {
			//清空上次请求的下拉列表信息
			$(ele).empty();
			$.ajax({
				url : "${APP_PATH }/companies",
				types : "POST",
				success : function(result) {
					//思考下没有这个会产生响应信息吗？
					/* console.log(result); */
					//{"code":100,"msg":"处理成功！","extend":{"companies":[{"companyId":1,"companyname":"北京总部"},{"companyId":2,"companyname":"西安分公司"},{"companyId":3,"companyname":"上海分公司"},{"companyId":4,"companyname":"成都分公司"},{"companyId":5,"companyname":"南京分公司"}]}}
					//显示公司信息在下拉列表中
					$.each(result.extend.companies,
							function() {
								var optionEle = $("<option></option>").append(
										this.companyname).attr("value",
										this.companyId);
								optionEle.appendTo(ele);
							})
				}
			});
		}
	</script>
</body>
</html>