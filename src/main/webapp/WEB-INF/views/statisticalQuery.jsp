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

	<!--普通查看描述模态框 -->
	<!-- Modal -->
	<div class="modal fade" id="viewContentDescribe" tabindex="-1"
		role="dialog" aria-labelledby="myModalLabel">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<input type="text" class="modal-title" id="ModalTitleDescri" />
				</div>
				<div class="modal-body">
					<textarea id="Descri" class="form-control" rows="8"></textarea>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
				</div>
			</div>
		</div>
	</div>

	<!--普通查看短信内容模态框 -->
	<!-- Modal -->
	<div class="modal fade" id="viewContentSmsCon" tabindex="-1"
		role="dialog" aria-labelledby="myModalLabel">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<input type="text" class="modal-title" id="ModalTitleSmsCon" />
				</div>
				<div class="modal-body">
					<textarea id="SmsCon" class="form-control" rows="8"></textarea>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
				</div>
			</div>
		</div>
	</div>

	<!--普通查看接收详情模态框 -->
	<!-- Modal -->
	<div class="modal fade" id="viewContentReceDetail" tabindex="-1"
		role="dialog" aria-labelledby="myModalLabel">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<input type="text" class="modal-title" id="ModalTitleReceDetail" />
				</div>
				<div class="modal-body">
					<!-- 显示表格数据 -->
					<div class="row">
						<div class="col-md-12">
							<table class="table table-striped table-hover"
								id="contacts_table">
								<thead>
									<tr>
										<th>姓名</th>
										<th>性别</th>
										<th>生日</th>
										<th>联系方式</th>
										<th>居住地址</th>
										<th>邮箱</th>
										<th>所属分公司</th>
									</tr>
								</thead>
								<tbody>
								</tbody>
							</table>
						</div>
					</div>
					<!-- 显示分页信息 -->
					<div class="row">
						<!-- 分页文字信息 -->
						<div class="col-md-6" id="page_info_area"></div>
						<!-- 分页条信息 -->
						<div class="col-md-6" id="page_nav_area"></div>
					</div>
				</div>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
			</div>
		</div>
	</div>

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
		<div class="col-md-4" id="page_nav_area"></div>
	</div>
	<script type="text/javascript">
		var totalRecord, currentPage, currentCompany;

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

								var describetask = $("<button></button>")
										.addClass(
												"btn-primary btn-xs view_btn_describe")
										.append(
												$("<span></span>")
														.addClass(
																"glyphicon glyphicon-eye-open"))
										.append("点击查看");
								//为查看按钮添加自定义属性，来表示记录的属性
								describetask.attr("view_id", item.srecordId);

								var describetaskTd = $("<td></td>").append(
										describetask);
								;
								/* 群发类型:0立即发送，1定时发送 */
								var masstypeTd = $("<td></td>").append(
										item.masstype == "0" ? "立即发送" : "定时发送");
								var smscon = $("<button></button>")
										.addClass(
												"btn-primary btn-xs view_btn_smscon")
										.append(
												$("<span></span>")
														.addClass(
																"glyphicon glyphicon-eye-open"))
										.append("点击查看");
								//为查看按钮添加自定义属性，来表示记录的属性
								smscon.attr("view_id", item.srecordId);
								var smsconTd = $("<td></td>").append(smscon);
								var reservetimeTd = $("<td></td>").append(
										item.reservetime);
								var companyTd = $("<td></td>").append(
										item.company.companyname);
								/* 发送状态0:已发送，1:待发送 */
								var statusTd = $("<td></td>").append(
										item.masstype == "0" ? "已发送" : "待发送");
								var receDetails = $("<button></button>")
										.addClass(
												"btn-primary btn-xs view_btn_Details")
										.append(
												$("<span></span>")
														.addClass(
																"glyphicon glyphicon-eye-open"))
										.append("点击查看");
								//为查看按钮添加自定义属性，来表示记录的属性
								receDetails.attr("view_id", item.rececompanyid);
								var receDetailsTd = $("<td></td>").append(
										receDetails);
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

		//查询记录信息提交到普通描述模态框
		function getSendRecDescri(id) {
			$.ajax({
				url : "${APP_PATH }/Statistical/" + id,
				type : "GET",
				success : function(result) {
					/* console.log(result); */
					var sendedRecData = result.extend.sendedRec;
					$("#ModalTitleDescri").val("任务描述详情");
					$("#Descri").val(sendedRecData.describetask);
				}
			});
		}

		//查询记录信息提交到普通短信内容模态框
		function getSendRecSmsCon(id) {
			$.ajax({
				url : "${APP_PATH }/Statistical/" + id,
				type : "GET",
				success : function(result) {
					/* console.log(result); */
					var sendedRecData = result.extend.sendedRec;
					$("#ModalTitleSmsCon").val("短信内容详情");
					$("#SmsCon").val(sendedRecData.smscon);
				}
			});
		}

		/*普通查看描述按钮点击事件*/
		$(document).on("click", ".view_btn_describe", function() {
			//1，查出记录信息并且显示记录内容
			getSendRecDescri($(this).attr("view_id"));
			//弹出模态框
			$("#viewContentDescribe").modal({
				backdrop : "static"
			})
		});
		/*普通查看群发内容按钮点击事件*/
		$(document).on("click", ".view_btn_smscon", function() {
			//1，查出记录信息并且显示记录内容
			getSendRecSmsCon($(this).attr("view_id"));
			//弹出模态框
			$("#viewContentSmsCon").modal({
				backdrop : "static"
			})
		});

		function getContacts(id) {
			$.ajax({
				url : "${APP_PATH }/selectContactsByCompany",
				data : {
					"opValue" : id
				},
				type : "POST",
				dataType : "JSON",
				success : function(result) {
					$("#ModalTitleReceDetail").val("短信接收详情");
					//1，解析并显示用户数据
					build_contactsByCompany_table(result);
					//2，解析并显示分页信息
					build_page_info(result);
					//3，解析显示分页条数据
					build_pageByCompany_nav(result);
				}
			});
		}

		//解析按公司属性查询显示分页条并且点击能去下一页等等
		function build_pageByCompany_nav(result) {
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
					to_pageByCompany(currentCompany, 1);
				});

				prePageLi.click(function() {
					to_pageByCompany(currentCompany,
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
					to_pageByCompany(currentCompany,
							result.extend.pageInfo.pageNum + 1);
				});

				lastPageLi.click(function() {
					to_pageByCompany(currentCompany,
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
					to_pageByCompany(currentCompany, item);
				});
				ul.append(numLi);
			});
			//添加下一页和末页的提示
			ul.append(nextPageLi).append(lastPageLi);
			var navEle = $("<nav></nav>").append(ul).attr("aria-label",
					"Page navigation");
			navEle.appendTo("#page_nav_area");
		}

		//按公司属性查询后跳到指定页码
		function to_pageByCompany(currentCompany, pn) {
			$.ajax({
				url : "${APP_PATH }/selectContactsByCompany",
				data : {
					"opValue" : currentCompany,
					"pn" : pn
				},
				dataType : "JSON",
				type : "POST",
				success : function(result) {
					//1，解析并显示用户数据
					build_contactsByCompany_table(result);
					//2，解析并显示分页信息
					build_page_info(result);
					//3，解析显示分页条数据
					build_pageByCompany_nav(result);
				}
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

		function build_contactsByCompany_table(result) {
			//每次放新数据的时候要清空上次请求后的数据
			$("#contacts_table tbody").empty();
			var contacts = result.extend.pageInfo.list;
			//遍历数据
			$.each(contacts,
					function(index, item) {
						var connameTd = $("<td></td>").append(item.conname);
						var consexTd = $("<td></td>").append(
								item.consex == "0" ? "男" : "女");
						var conbirthdayTd = $("<td></td>").append(
								item.conbirthday);
						var conphonenumTd = $("<td></td>").append(
								item.conphonenum);
						var conaddressTd = $("<td></td>").append(
								item.conaddress);
						var conemailTd = $("<td></td>").append(item.conemail);

						var companyTd = $("<td></td>").append(
								item.company.companyname);
						/*append方法执行完成以后还是返回原来的元素 <tr></tr>所以一直继续添加每行内容*/
						$("<tr></tr>").append(connameTd).append(consexTd)
								.append(conbirthdayTd).append(conphonenumTd)
								.append(conaddressTd).append(conemailTd)
								.append(companyTd).appendTo(
										"#contacts_table tbody");
					});
		}
		/*普通查看接收详情按钮点击事件*/
		$(document).on("click", ".view_btn_Details", function() {
			currentCompany = $(this).attr("view_id");
			//1，查出相关联系人信息
			getContacts($(this).attr("view_id"));
			//弹出模态框
			$("#viewContentReceDetail").modal({
				backdrop : "static"
			})
		});
	</script>
</body>
</html>