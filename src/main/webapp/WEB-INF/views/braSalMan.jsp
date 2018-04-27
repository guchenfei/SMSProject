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
<script language="javascript" type="text/javascript"
	src="${APP_PATH }/static/My97DatePicker/WdatePicker.js"></script>
</head>
<body>
	<!-- 搭建显示页面 -->
	<div>
		<div class="row tools">
			<div class="col-md-3">
				<ul class="toolbar">
					<li id="admin_add_modal_btn">
						<span>
							<img src="${APP_PATH }/static/images/t01.png" />
						</span>
						<font style="font-size: 11px">添加业务员</font>
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
			<div class="col-md-3"></div>
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
	<script type="text/javascript">
		//定义一个全局数据，用于添加用户后定位到最后一页，这其中有一个分页参数合理化功能，它的作用是即使翻到超出总页数的页码，最后还是定位到最后一页，
		//所以找一个比总页码大的参数用于翻到最后一页.currentPage记录当前页,currentRole记录当前角色
		var totalRecord, currentPage, currentRole, currentCompany;
		currentRole = 2;
		currentCompany = ${admin.getCpyId()};
		//1,页面加载完成后，直接去发送ajax请求，要到分页数据
		$(function() {
			//去首页
			to_page(currentCompany, currentRole, 1);
		});

		//发送指定的请求，跳到点击的页码页
		function to_page(currentCompany, currentRole, pn) {
			$.ajax({
				url : "${APP_PATH }/selectAdminByRoleAndCpy",
				data : {
					"currentCompany" : currentCompany,
					"currentRole" : currentRole,
					"pn" : pn
				},
				type : "POST",
				success : function(result) {
					console.log(result);
					//1，解析并显示用户数据
					build_admins_table(result);
					//2，解析并显示分页信息
					build_page_info(result);
					//3，解析显示分页条数据
					build_page_nav(result);
				}
			});
		}

		/**
		 * 普通查询构建table
		 */
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
										$("<input/>").attr("type", "checkbox")
												.addClass("check_item"));
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
										.addClass("btn-primary btn-xs edit_btn")
										.append(
												$("<span></span>")
														.addClass(
																"glyphicon glyphicon-pencil"))
										.append("修改");
								//为修改按钮添加自定义属性，来表示当前用户的属性
								modifyBtn.attr("modify_id", item.adminId);

								var delBtn = $("<button></button>").addClass(
										"btn-danger btn-xs delete_btn").append(
										$("<span></span>").addClass(
												"glyphicon glyphicon-trash"))
										.append("删除");
								//为删除按钮添加自定义属性，来表示当前用户的属性
								delBtn.attr("delete_id", item.adminId);
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

		//解析显示普通查询分页信息
		function build_page_info(result) {
			//每次放新数据的时候要清空上次请求后的数据
			$("#page_info_area").empty();
			$("#page_info_area").append(
					"当前第&nbsp;" + result.extend.pageInfo.pageNum
							+ "&nbsp;页,总共&nbsp;" + result.extend.pageInfo.pages
							+ "&nbsp;页，总共&nbsp;" + result.extend.pageInfo.total
							+ "&nbsp;条记录 ");
			totalRecord = result.extend.pageInfo.total;
			currentPage = result.extend.pageInfo.pageNum;
		}

		//解析普通查询显示分页条并且点击能去下一页等等
		function build_page_nav(result) {
			//每次放新数据的时候要清空上次请求后的数据
			$("#page_nav_area").empty();
			//page_nav_area
			var ul = $("<ul></ul>").addClass("pagination");
			//构建元素
			var firstPageLi = $("<li></li>").append($("<a></a>").append("首页"));
			var prePageLi = $("<li></li>").append(
					$("<a></a>").append("&laquo;"));

			if (result.extend.pageInfo.hasPreviousPage == false) {
				firstPageLi.addClass("disabled");
				prePageLi.addClass("disabled");
			} else {
				//为元素添加翻页事件
				firstPageLi.click(function() {
					to_page(currentCompany, currentRole, 1);
				});

				prePageLi.click(function() {
					to_page(currentCompany, currentRole,
							result.extend.pageInfo.pageNum - 1);
				});
			}
			var nextPageLi = $("<li></li>").append(
					$("<a></a>").append("&raquo;"));
			var lastPageLi = $("<li></li>").append($("<a></a>").append("末页"));
			if (result.extend.pageInfo.hasNextPage == false) {
				nextPageLi.addClass("disabled");
				lastPageLi.addClass("disabled");
			} else {
				nextPageLi.click(function() {
					to_page(currentCompany, currentRole,
							result.extend.pageInfo.pageNum + 1);
				});

				lastPageLi.click(function() {
					to_page(currentCompany, currentRole,
							result.extend.pageInfo.pages);
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
					to_page(currentCompany, currentRole, item);
				});
				ul.append(numLi);
			});
			//添加下一页和末页的提示
			ul.append(nextPageLi).append(lastPageLi);
			var navEle = $("<nav></nav>").append(ul).attr("aria-label",
					"Page navigation");
			navEle.appendTo("#page_nav_area");
		}
	</script>
</body>
</html>