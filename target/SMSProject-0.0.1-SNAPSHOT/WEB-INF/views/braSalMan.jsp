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
					<h4 class="modal-title">添加业务员</h4>
				</div>
				<div class="modal-body">
					<form class="form-horizontal">
						<div class="form-group">
							<label class="col-sm-2 control-label">姓名:</label>
							<div class="col-sm-10">
								<input type="text" class="form-control" id="adminName_add_input"
									name="username" placeholder="请输入您的姓名"> <span
										class="help-block"></span>
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-2 control-label">密码:</label>
							<div class="col-sm-10">
								<input type="password" class="form-control" name="userpass"
									id="adminPass_add_input" placeholder="请输入您的密码"> <span
										class="help-block"></span>
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
								<span class="help-block"></span>
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-2 control-label">联系方式:</label>
							<div class="col-sm-10">
								<input type="text" class="form-control" id="adminpnum_add_input"
									name="userpnum" placeholder="请输入您的手机号码"> <span
										class="help-block"></span>
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-2 control-label">地址:</label>
							<div class="col-sm-10">
								<input type="text" class="form-control" name="useraddress"
									id="adminaddress_add_input" placeholder="请输入您的详细地址"> <span
										class="help-block"></span>
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-2 control-label">邮箱:</label>
							<div class="col-sm-10">
								<input type="text" class="form-control" name="useremail"
									id="adminemail_add_input" placeholder="xxx@163.com"> <span
										class="help-block"></span>
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-2 control-label">角色:</label>
							<div class="col-sm-4">
								<select class="form-control" id="admintype_add_select"
									name="usertype">
									<!-- 权限角色：2表示业务员 -->
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
									<option value="${admin.getCpyId()}">${admin.getCompany().getCompanyname()}</option>
								</select>
							</div>
						</div>
					</form>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
					<button type="button" class="btn btn-primary" id="admin_save_btn">保存</button>
				</div>
			</div>
		</div>
	</div>
	
		<!-- 普通用户修改的模态框 -->
	<div class="modal fade" id="adminUpdateModal" tabindex="-1"
		role="dialog" aria-labelledby="myModalLabel">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title">修改业务员</h4>
				</div>
				<div class="modal-body">
					<form class="form-horizontal">
						<div class="form-group">
							<label class="col-sm-2 control-label">姓名:</label>
							<div class="col-sm-10">
								<input type="text" class="form-control"
									id="adminName_update_input" name="username"
									placeholder="请输入您的姓名"> <span class="help-block"></span>
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-2 control-label">密码:</label>
							<div class="col-sm-10">
								<input type="text" class="form-control" name="userpass"
									id="adminPass_update_input" placeholder="请输入您的密码"> <span
										class="help-block"></span>
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-2 control-label">性别:</label>
							<div class="col-sm-10">
								<label class="radio-inline"> <!-- 男0女1 --> <input
									type="radio" name="usersex" id="adminsex0_update_input"
									value="0" checked="checked">男 </label> <label
									class="radio-inline"> <input type="radio"
									name="usersex" id="adminsex1_update_input" value="1">女
								</label>
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-2 control-label">生日:</label>
							<div class="col-sm-10">
								<input id="adminbirthday_update_input" type="text"
									name="userbirthday" class="form-control"
									onclick="WdatePicker({isShowClear:false,readOnly:true})"
									placeholder="请点击输入您的生日" />
								<span class="help-block"></span>
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-2 control-label">联系方式:</label>
							<div class="col-sm-10">
								<input type="text" class="form-control"
									id="adminpnum_update_input" name="userpnum"
									placeholder="请输入您的手机号码"> <span class="help-block"></span>
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-2 control-label">地址:</label>
							<div class="col-sm-10">
								<input type="text" class="form-control" name="useraddress"
									id="adminaddress_update_input" placeholder="请输入您的详细地址">
									<span class="help-block"></span>
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-2 control-label">邮箱:</label>
							<div class="col-sm-10">
								<p class="form-control-static" id="adminEmail_update_static"></p>
								<span class="help-block"></span>
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-2 control-label">角色:</label>
							<div class="col-sm-4">
								<select class="form-control" id="admintype_update_select"
									name="usertype">
									<!-- 权限角色：2表示业务员 -->
									<option value="2">业务员</option>
								</select>
							</div>
						</div>

						<div class="form-group">
							<label class="col-sm-2 control-label">所属公司:</label>
							<div class="col-sm-4">
								<select class="form-control" id="admincpy_update_select"
									name="cpyId">
									<!--  所属公司提交公司ID即可 -->
									<option value="${admin.getCpyId()}">${admin.getCompany().getCompanyname()}</option>
								</select>
							</div>
						</div>
					</form>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
					<button type="button" class="btn btn-primary" id="admin_update_btn">更新</button>
				</div>
			</div>
		</div>
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
		
		//点击新增按钮显示增加的模态框
		$("#admin_add_modal_btn").click(function() {
			//清除表单数据（表单完整重置（表单数据，表单样式））
			reset_form("#adminAddModal form");
			$("#adminAddModal form")[0].reset();
			//弹出模态框
			$("#adminAddModal").modal({
				backdrop : "static"
			})
		});
		
		//清空表单样式及内容
		function reset_form(ele) {
			//清空表单数据
			$(ele)[0].reset();
			//清空表单样式
			$(ele).find("*").removeClass("has-success has-error");
			$(ele).find(".help-block").text("");

		}
		
		
		/* 用户添加保存事件 */
		$("#admin_save_btn")
				.click(
						function() {
							//将模态框中填写的表单数据提交给服务器保存
							//1，先对要提交给服务器的数据进行校验
							if (!validate_add_form()) {
								return false;
							}
							//2，判断之前的ajax邮箱校验是否成功，如果校验不存在（校验返回成功）
							if ($(this).attr("ajax_validate") == "error") {
								return false;
							}

							//3，发送ajax请求保存用户
							/* alert($("#adminAddModal form").serialize()); */
							/*当使用ajax序列化提交表单时，一定要使用post请求方式提交表单，避免乱码问题。 */
							$
									.ajax({
										url : "${APP_PATH }/addAdmin",
										type : "POST",
										data : $("#adminAddModal form")
												.serialize(),
										success : function(result) {
											/* alert(result.msg); */
											if (result.code == 100) {
												//用户保存成功后需要完成2件事
												alert(result.msg);
												//1，关闭模态框
												$("#adminAddModal").modal(
														'hide');
												//2，来到最后一页，显示刚才保存的数据
												to_page(currentCompany, currentRole, totalRecord);
											} else if (result.code == 200) {
												//显示失败信息之前需要清除以前的样式
												reset_formStyle("#adminAddModal form");
												//显示失败信息
												/*  console.log(result); */
												//有那个字段的错误信息就显示那个字段的；
												/* alert(result.extend.fieldErrors.userpass);
												alert(result.extend.fieldErrors.userpnum);  */
												//后台存在校验通过就不会传来校验信息的字段，所以通过未定义判断来判断每个字段的校验信息
												if (undefined != result.extend.fieldErrors.username) {
													//显示姓名错误信息
													show_validate_msg(
															"#adminName_add_input",
															"error",
															result.extend.fieldErrors.username);

												}
												if (undefined != result.extend.fieldErrors.userpass) {
													//显示密码错误信息
													show_validate_msg(
															"#adminPass_add_input",
															"error",
															result.extend.fieldErrors.userpass);
												}

												if (undefined != result.extend.fieldErrors.userbirthday) {
													//显示生日错误信息
													show_validate_msg(
															"#adminbirthday_add_input",
															"error",
															result.extend.fieldErrors.userbirthday);
												}

												if (undefined != result.extend.fieldErrors.userpnum) {
													//显示手机号的错误信息
													show_validate_msg(
															"#adminpnum_add_input",
															"error",
															result.extend.fieldErrors.userpnum);
												}
												if (undefined != result.extend.fieldErrors.useraddress) {
													//显示地址不为空的错误信息
													show_validate_msg(
															"#adminaddress_add_input",
															"error",
															result.extend.fieldErrors.useraddress);
												}

												if (undefined != result.extend.fieldErrors.useremail) {
													//显示邮箱错误信息
													show_validate_msg(
															"#adminemail_add_input",
															"error",
															result.extend.fieldErrors.useremail);
												}
											}
										}
									});
						});
		
		/* 校验添加表单的数据 */
		function validate_add_form() {
			//拿到要校验的数据，使用正则表达式进行校验
			//校验姓名
			var adminName = $("#adminName_add_input").val();
			var regName = /(^[a-zA-Z0-9_-]{6,16}$)|(^[\u2E80-\u9FFF]{2,5})/;
			if (!regName.test(adminName)) {
				/* alert("用户名必须是2-5位中文或者6-16位英文和数字等组合"); */
				/* 应该清空这个元素之前的样式 */
				/* $("#adminName_add_input").parent().addClass("has-error");
				$("#adminName_add_input").next("span").text("用户名必须是2-5位中文或者6-16位英文和数字等组合"); */
				show_validate_msg("#adminName_add_input", "error",
						"姓名必须是2-5位中文或者6-16位英文和数字等组合");
				return false;
			} else {
				/* $("#adminName_add_input").parent().addClass("has-success");
				$("#adminName_add_input").next("span").text(""); */
				show_validate_msg("#adminName_add_input", "success", "");
			}
			//校验密码
			var adminPass = $("#adminPass_add_input").val();
			var regPass = /^[a-zA-Z0-9_-]{6,18}$/;
			if (!regPass.test(adminPass)) {
				/* 应该清空这个元素之前的样式 */
				show_validate_msg("#adminPass_add_input", "error",
						"密码必须为6-18位的字母数字下划线组合");
				return false;
			} else {
				show_validate_msg("#adminPass_add_input", "success", "");
			}
			//校验手机号
			var adminpnum = $("#adminpnum_add_input").val();
			var regPnum = /^[1][3,4,5,7,8][0-9]{9}$/;
			if (!regPnum.test(adminpnum)) {
				/* 应该清空这个元素之前的样式 */
				show_validate_msg("#adminpnum_add_input", "error",
						"请输入格式正确的11位手机号");
				return false;
			} else {
				show_validate_msg("#adminpnum_add_input", "success", "");
			}
			//校验邮箱
			var adminEmail = $("#adminemail_add_input").val();
			var regEmail = /^([a-z0-9_\.-]+)@([\da-z\.-]+)\.([a-z\.]{2,6})$/;

			if (!regEmail.test(adminEmail)) {
				/* alert("请按正确的邮箱格式输入"); */
				/* $("#adminemail_add_input").parent().addClass("has-error");
				$("#adminemail_add_input").next("span").text("请按正确的邮箱格式输入"); */
				show_validate_msg("#adminemail_add_input", "error",
						"请按正确的邮箱格式输入");
				return false;
			} else {
				/* $("#adminemail_add_input").parent().addClass("has-success");
				$("#adminemail_add_input").next("span").text(""); */
				show_validate_msg("#adminemail_add_input", "success", "");
			}
			return true;
		}
		
		//清除表单样式
		function reset_formStyle(ele) {
			//清空表单样式
			$(ele).find("*").removeClass("has-success has-error");
			$(ele).find(".help-block").text("");

		}
		
		/* 抽取校验姓名及邮箱等的结果提示 ,显示校验的提示信息*/
		function show_validate_msg(ele, status, msg) {
			//清除当前元素的校验状态
			$(ele).parent().removeClass("has-success has-error");
			$(ele).next("span").text(" ");
			if ("success" == status) {
				$(ele).parent().addClass("has-success");
				$(ele).next("span").text(msg);
			} else if ("error" == status) {
				$(ele).parent().addClass("has-error");
				$(ele).next("span").text(msg);
			}
		}
		
		/* 校验邮箱是否已存在 */
		$("#adminemail_add_input").change(
				function() {
					//发送ajax请求校验邮箱是否已存在
					/* 状态码 100 - 成功   200 - 失败 */
					var adminEmail = this.value;
					$
							.ajax({
								url : "${APP_PATH }/checkEmail",
								data : "email=" + adminEmail,
								type : "POST",
								success : function(result) {
									if (result.code == 100) {
										show_validate_msg(
												"#adminemail_add_input",
												"success",
												result.extend.checkEmail_msg);
										$("#admin_save_btn").attr(
												"ajax_validate", "success");
									} else if (result.code == 200) {
										show_validate_msg(
												"#adminemail_add_input",
												"error",
												result.extend.checkEmail_msg);
										$("#admin_save_btn").attr(
												"ajax_validate", "error");
									}
								}
							});
				});
		
		//查询用户信息提交到普通修改模态框
		function getAdmin(id) {
			$.ajax({
				url : "${APP_PATH }/admin/" + id,
				type : "GET",
				success : function(result) {
					/* console.log(result); */
					var adminData = result.extend.admin;
					$("#adminName_update_input").val(adminData.username);
					$("#adminPass_update_input").val(adminData.userpass);
					$("#adminUpdateModal input[name=usersex]").val(
							[ adminData.usersex ]);
					$("#adminbirthday_update_input")
							.val(adminData.userbirthday);
					$("#adminpnum_update_input").val(adminData.userpnum);
					$("#adminaddress_update_input").val(adminData.useraddress);
					$("#adminEmail_update_static").text(adminData.useremail);
					$("#admintype_update_select").val([ adminData.usertype ]);
					$("#admincpy_update_select").val([ adminData.cpyId ]);
				}
			});
		}
		
		
		/*普通修改按钮点击事件*/
		$(document).on(
				"click",
				".edit_btn",
				function() {
					//2，查出用户信息并且显示用户信息
					getAdmin($(this).attr("modify_id"));
					//3,把用户的ID传递给修改模态框的更新按钮
					$("#admin_update_btn").attr("modify_id",
							$(this).attr("modify_id"));
					//弹出模态框
					$("#adminUpdateModal").modal({
						backdrop : "static"
					})

				});
		
		/* 普通校验修改表单的数据 */
		function validate_modify_form() {
			//拿到要校验的数据，使用正则表达式进行校验
			//校验姓名
			var adminName = $("#adminName_update_input").val();
			var regName = /(^[a-zA-Z0-9_-]{6,16}$)|(^[\u2E80-\u9FFF]{2,5})/;
			if (!regName.test(adminName)) {
				/* alert("用户名必须是2-5位中文或者6-16位英文和数字等组合"); */
				/* 应该清空这个元素之前的样式 */
				/* $("#adminName_add_input").parent().addClass("has-error");
				$("#adminName_add_input").next("span").text("用户名必须是2-5位中文或者6-16位英文和数字等组合"); */
				show_validate_msg("#adminName_update_input", "error",
						"姓名必须是2-5位中文或者6-16位英文和数字等组合");
				return false;
			} else {
				/* $("#adminName_add_input").parent().addClass("has-success");
				$("#adminName_add_input").next("span").text(""); */
				show_validate_msg("#adminName_update_input", "success", "");
			}
			//校验密码
			var adminPass = $("#adminPass_update_input").val();
			var regPass = /^[a-zA-Z0-9_-]{6,18}$/;
			if (!regPass.test(adminPass)) {
				/* 应该清空这个元素之前的样式 */
				show_validate_msg("#adminPass_update_input", "error",
						"密码必须为6-18位的字母数字下划线组合");
				return false;
			} else {
				show_validate_msg("#adminPass_update_input", "success", "");
			}
			//校验手机号
			var adminpnum = $("#adminpnum_update_input").val();
			var regPnum = /^[1][3,4,5,7,8][0-9]{9}$/;
			if (!regPnum.test(adminpnum)) {
				/* 应该清空这个元素之前的样式 */
				show_validate_msg("#adminpnum_update_input", "error",
						"请输入格式正确的11位手机号");
				return false;
			} else {
				show_validate_msg("#adminpnum_update_input", "success", "");
			}
			return true;
		}
		
		//普通点击更新，更新用户信息
		$("#admin_update_btn")
				.click(
						function() {
							//进行修改表单验证
							if (validate_modify_form()) {
								//验证成功发送ajax请求保存用户信息（更新）
								$
										.ajax({
											url : "${APP_PATH }/admin/"
													+ $(this).attr("modify_id"),
											type : "POST",
											data : $("#adminUpdateModal form")
													.serialize()
													+ "&_method=PUT",
											success : function(result) {
												/* alert(result.msg); */
												if (result.code == 100) {
													alert(result.msg);
													//用户保存成功后需要完成2件事
													//1，关闭模态框
													$("#adminUpdateModal")
															.modal('hide');
													//2,回到本页面
													to_page(currentCompany, currentRole, currentPage);
												} else if (result.code == 200) {
													//显示失败信息之前需要清除以前的样式
													reset_formStyle("#adminUpdateModal form");
													//显示失败信息
													/*  console.log(result); */
													//有那个字段的错误信息就显示那个字段的；
													/* alert(result.extend.fieldErrors.userpass);
													alert(result.extend.fieldErrors.userpnum);  */
													//后台存在校验通过就不会传来校验信息的字段，所以通过未定义判断来判断每个字段的校验信息
													if (undefined != result.extend.fieldErrors.username) {
														//显示姓名错误信息
														show_validate_msg(
																"#adminName_update_input",
																"error",
																result.extend.fieldErrors.username);

													}
													if (undefined != result.extend.fieldErrors.userpass) {
														//显示密码错误信息
														show_validate_msg(
																"#adminPass_update_input",
																"error",
																result.extend.fieldErrors.userpass);
													}

													if (undefined != result.extend.fieldErrors.userbirthday) {
														//显示生日错误信息
														show_validate_msg(
																"#adminbirthday_update_input",
																"error",
																result.extend.fieldErrors.userbirthday);
													}

													if (undefined != result.extend.fieldErrors.userpnum) {
														//显示手机号的错误信息
														show_validate_msg(
																"#adminpnum_update_input",
																"error",
																result.extend.fieldErrors.userpnum);
													}
													if (undefined != result.extend.fieldErrors.useraddress) {
														//显示地址不为空的错误信息
														show_validate_msg(
																"#adminaddress_update_input",
																"error",
																result.extend.fieldErrors.useraddress);
													}

													if (undefined != result.extend.fieldErrors.useremail) {
														//显示邮箱错误信息
														show_validate_msg(
																"#adminemail_update_input",
																"error",
																result.extend.fieldErrors.useremail);
													}
												}
											}
										});
							}
						});
		
		/*普通删除按钮点击事件*/
		$(document).on("click", ".delete_btn", function() {
			//1，弹出确认删除对话框
			/* alert($(this).parents("tr").find("td:eq(8)").text()); */
			var adminEmail = $(this).parents("tr").find("td:eq(8)").text();
			var adminId = $(this).attr("delete_id");
			/* alert(adminId); */
			if (confirm("确认删除【" + adminEmail + "】吗？")) {
				//确认删除，发送ajax请求删除
				$.ajax({
					url : "${APP_PATH }/admin/" + adminId,
					type : "DELETE",
					success : function(result) {
						//状态码 100-成功 200-失败
						if (result.code == 100) {
							alert(result.msg);
							to_page(currentCompany, currentRole, currentPage);
						} else if (result.code == 200) {
							alert(result.msg);
						}
					}
				});
			}
		});
		
		/* 全选和全不选功能 */
		$("#check_all").click(function() {
			/*attr获取到的CheckBox属性为undefined,它可以获取自定义属性的值
			prop修改和读取dom原生属性值
			 */
			//同步选中状态即全选
			$(".check_item").prop("checked", $(this).prop("checked"));
		});
		
		/*check_item点击事件*/
		$(document)
				.on(
						"click",
						".check_item",
						function() {
							//1,判断当前选中元素是否选满（20个）
							var flag = $(".check_item:checked").length == $(".check_item").length;
							$("#check_all").prop("checked", flag);
						});
		
		//点击批量删除按钮事件
		$("#admin_mutiDelete_btn").click(
				function() {
					var adminEmails = "";
					var adminIds = "";
					$.each($(".check_item:checked"), function() {
						adminEmails += $(this).parents("tr").find("td:eq(8)")
								.text()
								+ ",";
						adminIds += $(this).parents("tr").find("td:eq(1)")
								.text()
								+ ",";
					});
					//去除adminEmails多余的
					adminEmails = adminEmails.substring(0,
							adminEmails.length - 1);
					//去除adminIds多余的
					adminIds = adminIds.substring(0, adminIds.length - 1);
					if (confirm("确认删除【" + adminEmails + "】吗？")) {
						//发送ajax请求删除
						$.ajax({
							url : "${APP_PATH }/admin/" + adminIds,
							type : "DELETE",
							success : function(result) {
								if (result.code == 100) {
									alert(result.msg);
									//回到当前页面
									to_page(currentCompany, currentRole, currentPage);
								} else if (result.code == 200) {
									alert(result.msg);
								}
							}
						});
					}
				});
	</script>
</body>
</html>