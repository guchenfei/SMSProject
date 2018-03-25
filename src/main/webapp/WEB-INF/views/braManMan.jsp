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
	<!-- 用户添加的模态框 -->
	<div class="modal fade" id="adminAddModal" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" id="myModalLabel">添加管理员/业务员</h4>
				</div>
				<div class="modal-body">
					<form class="form-horizontal">
						<div class="form-group">
							<label class="col-sm-2 control-label">姓名:</label>
							<div class="col-sm-10">
								<input type="text" class="form-control" id="adminName_add_input"
									name="username" placeholder="请输入您的姓名">
							</div>
						</div>
						<!--
private String ;

	private String ;

	private Integer ;

	private String ;

	private String ;

	private String ;

	private String ;

	private Integer ;

	private Integer ;

						 -->
						<div class="form-group">
							<label class="col-sm-2 control-label">密码:</label>
							<div class="col-sm-10">
								<input type="password" class="form-control" name="userpass"
									id="adminPass_add_input" placeholder="请输入您的密码">
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-2 control-label">性别:</label>
							<div class="col-sm-10">
								<label class="radio-inline"> <!-- 男0女1 --> <input
									type="radio" name="usersex" id="adminsex0_add_input" value="0"
									checked="checked">男 </label> <label class="radio-inline">
									<input type="radio" name="usersex" id="adminsex1_add_input"
									value="1">女 
								</label>
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-2 control-label">生日:</label>
							<div class="col-sm-10">
								<input id="adminbirthday_add_input" type="text"
									name="userbirthday" class="form-control"
									onclick="WdatePicker({isShowClear:false,readOnly:true})"
									placeholder="请点击输入您的生日" />
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-2 control-label">联系方式:</label>
							<div class="col-sm-10">
								<input type="text" class="form-control" id="adminpnum_add_input"
									name="userpnum" placeholder="请输入您的手机号码">
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-2 control-label">地址:</label>
							<div class="col-sm-10">
								<input type="text" class="form-control" name="useraddress"
									id="adminaddress_add_input" placeholder="请输入您的详细地址">
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-2 control-label">邮箱:</label>
							<div class="col-sm-10">
								<input type="text" class="form-control" name="useremail"
									id="adminemail_add_input" placeholder="xxx@163.com">
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-2 control-label">角色:</label>
							<div class="col-sm-4">
								<select class="form-control" id="admintype_add_select"
									name="usertype">
									<!-- 权限角色：0表示超级管理员，1表示普通管理员，2表示业务员 -->
									<option value="0">超级管理员</option>
									<option value="1">普通管理员</option>
									<option value="2">业务员</option>
								</select>
							</div>
						</div>

						<div class="form-group">
							<label class="col-sm-2 control-label">所属公司:</label>
							<div class="col-sm-4">
								<select class="form-control" id="admincpy_add_select"
									name="cpyId">
									<!--  所属公司提交公司ID即可 -->
								</select>
							</div>
						</div>
					</form>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
					<button type="button" class="btn btn-primary">保存</button>
				</div>
			</div>
		</div>
	</div>

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
						<li id="admin_add_modal_btn">
							<span>
								<img src="${APP_PATH }/static/images/t01.png" />
							</span>
							<font style="font-size: 11px">添加管理员/业务员</font>
						</li>
					</ul>
				</div>
			</div>
			<div class="col-md-4">
				<select class="form-control">
					<option>按角色查询</option>
					<option>超级管理员</option>
					<option>管理员</option>
					<option>业务员</option>
				</select>
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
				<table class="table table-striped table-hover" id="admins_table">
					<thead>
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
		//1,页面加载完成后，直接去发送ajax请求，要到分页数据
		$(function() {
			//去首页
			to_page(1);
		});

		function build_admins_table(result) {
			//每次放新数据的时候要清空上次请求后的数据
			$("#admins_table tbody").empty();
			var admins = result.extend.pageInfo.list;
			//遍历数据
			$
					.each(
							admins,
							function(index, item) {
								/* alert(item.username); */
								/* <th><input name="" type="checkbox" value="" /></th> */
								var checkboxTd = $("<td></td>").append(
										$("<input/>").attr("type", "checkbox"));
								var adminIdTd = $("<td></td>").append(
										item.adminId);
								var usernameTd = $("<td></td>").append(
										item.username);
								var userpassTd = $("<td></td>")
										.append("******");
								var usersexTd = $("<td></td>").append(
										item.usersex == "0" ? "男" : "女");
								var userbirthdayTd = $("<td></td>").append(
										item.userbirthday);
								var userpnumTd = $("<td></td>").append(
										item.userpnum);
								var useraddressTd = $("<td></td>").append(
										item.useraddress);
								var useremailTd = $("<td></td>").append(
										item.useremail);
								/* 权限角色：0表示超级管理员，1表示普通管理员，2表示业务员 */
								if (item.usertype == 0) {
									var role = "超级管理员";
								} else if (item.usertype == 1) {
									var role = "普通管理员";
								} else if (item.usertype == 2) {
									var role = "业务员";
								}
								var usertypeTd = $("<td></td>").append(role);
								var companyTd = $("<td></td>").append(
										item.company.companyname);
								var modifyBtn = $("<button></button>")
										.addClass("btn-primary btn-xs")
										.append(
												$("<span></span>")
														.addClass(
																"glyphicon glyphicon-pencil"))
										.append("修改");
								var delBtn = $("<button></button>").addClass(
										"btn-danger btn-xs").append(
										$("<span></span>").addClass(
												"glyphicon glyphicon-trash"))
										.append("删除");
								var btnTd = $("<td></td>").append(modifyBtn)
										.append(" ").append(delBtn);

								/*append方法执行完成以后还是返回原来的元素 <tr></tr>所以一直继续添加每行内容*/
								$("<tr></tr>").append(checkboxTd).append(
										adminIdTd).append(usernameTd).append(
										userpassTd).append(usersexTd).append(
										userbirthdayTd).append(userpnumTd)
										.append(useraddressTd).append(
												useremailTd).append(usertypeTd)
										.append(companyTd).append(btnTd)
										.appendTo("#admins_table tbody");
							});
		}

		//解析显示分页信息
		function build_page_info(result) {
			//每次放新数据的时候要清空上次请求后的数据
			$("#page_info_area").empty();
			$("#page_info_area").append(
					"当前第&nbsp;" + result.extend.pageInfo.pageNum
							+ "&nbsp;页,总共&nbsp;" + result.extend.pageInfo.pages
							+ "&nbsp;页，总共&nbsp;" + result.extend.pageInfo.total
							+ "&nbsp;条记录 ");

		}
		//解析显示分页条并且点击能去下一页等等
		function build_page_nav(result) {
			//每次放新数据的时候要清空上次请求后的数据
			$("#page_nav_area").empty();
			//page_nav_area
			var ul = $("<ul></ul>").addClass("pagination");
			//构建元素
			var firstPageLi = $("<li></li>").append(
					$("<a></a>").append("首页").attr("href", "#"));
			var prePageLi = $("<li></li>").append(
					$("<a></a>").append("&laquo;"));

			if (result.extend.pageInfo.hasPreviousPage == false) {
				firstPageLi.addClass("disabled");
				prePageLi.addClass("disabled");
			} else {
				//为元素添加翻页事件
				firstPageLi.click(function() {
					to_page(1);
				});

				prePageLi.click(function() {
					to_page(result.extend.pageInfo.pageNum - 1);
				});
			}
			var nextPageLi = $("<li></li>").append(
					$("<a></a>").append("&raquo;"));
			var lastPageLi = $("<li></li>").append(
					$("<a></a>").append("末页").attr("href", "#"));
			if (result.extend.pageInfo.hasNextPage == false) {
				nextPageLi.addClass("disabled");
				lastPageLi.addClass("disabled");
			} else {
				nextPageLi.click(function() {
					to_page(result.extend.pageInfo.pageNum + 1);
				});

				lastPageLi.click(function() {
					to_page(result.extend.pageInfo.pages);
				});
			}
			//添加首页和前一页的提示
			ul.append(firstPageLi).append(prePageLi);
			//1,2,3,4,5页码号,遍历给ul中添加页码提示
			$.each(result.extend.pageInfo.navigatepageNums, function(index,
					item) {
				var numLi = $("<li></li>").append($("<a></a>").append(item));
				if (result.extend.pageInfo.pageNum == item) {
					numLi.addClass("active");
				}
				numLi.click(function() {
					to_page(item);
				});
				ul.append(numLi);
			});
			//添加下一页和末页的提示
			ul.append(nextPageLi).append(lastPageLi);
			var navEle = $("<nav></nav>").append(ul).attr("aria-label",
					"Page navigation");
			navEle.appendTo("#page_nav_area");
		}

		//发送指定的请求，跳到点击的页码页
		function to_page(pn) {
			$.ajax({
				url : "${APP_PATH }/allAdmin",
				data : "pn=" + pn,
				type : "POST",
				success : function(result) {
					/* console.log(result); */
					//1，解析并显示用户数据
					build_admins_table(result);
					//2，解析并显示分页信息
					build_page_info(result);
					//3，解析显示分页条数据
					build_page_nav(result);
				}
			});
		}
		//点击新增按钮显示增加的模态框
		$("#admin_add_modal_btn").click(function() {
			//发送ajax请求，查出分公司信息，显示在下拉列表中
			getCompanies();
			//弹出模态框
			$("#adminAddModal").modal({
				backdrop : "static"
			})
		});
		//查出所有的分公司信息并显示在下拉列表中
		function getCompanies() {
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
								optionEle.appendTo("#admincpy_add_select");
							})
				}
			});
		}
		$('.tablelist tbody tr:odd').addClass('odd');
	</script>
</body>
</html>