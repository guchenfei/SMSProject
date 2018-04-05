<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" lang="zh-CN">

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
		src="${APP_PATH }/static/bootstrap-3.3.7-dist/js/bootstrap.min.js" />
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
				<a href="#">通知群发</a>
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
					<input type="text" class="form-control" id="phoneNumber"
						placeholder="请点击下方选择要发送的子公司..." aria-describedby="basic-addon1">
				</div>
			</div>
		</div>
		<div>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</div>
		<div class="row">
			<div class="col-md-4">
				<span class="label label-info">
					<font style="font-size: 13px;">选择短信接收公司：</font>
				</span>
			</div>
			<div class="col-md-4">
				<div>
					<select class="form-control" id="smsCpy_select"
						name="concompanySelect">
					</select>
				</div>
			</div>
			<div class="col-md-4"></div>
		</div>
		<div>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</div>
		<div class="row">
			<div class="col-md-6">
				<span class="label label-info">
					<font style="font-size: 13px;">短信内容：</font>
				</span>
				<div>&nbsp;&nbsp;&nbsp;</div>

				<textarea class="form-control" rows="8" placeholder="请输入短信内容..."
					id="smsContent" onkeyup="showcontent()"></textarea>
				<span>
					<font id="word" style="color: red;">300</font> /300
				</span>
			</div>
			<div class="col-md-6">
				<span class="label label-info">
					<font style="font-size: 13px;">短信预览：</font>
				</span>
				<div>&nbsp;&nbsp;&nbsp;</div>
				<textarea class="form-control" rows="8" placeholder="请输入短信内容..."
					id="smsPreview" readonly="readonly"></textarea>
			</div>
		</div>
		<div>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</div>
		<div class="row">
			<div class="col-md-6">
				<button onclick="sendMessages()" class="btn btn-info">发送</button>
			</div>
			<div class="col-md-6">
				<button type="reset" class="btn btn-info">重置</button>
			</div>
		</div>
	</form>

	<script type="text/javascript">
		//1,页面加载完成后，直接去发送ajax请求，要到分公司情况数据
		$(function() {
			var textArea = $("#smsContent");
			var word = $("#word");
			//去首页
			getCompanies("#smsCpy_select");
			statInputNum(textArea, word);
		});

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

		function showcontent() {
			document.getElementById("smsPreview").value = document
					.getElementById("smsContent").value;
		}

		/*
		 * 剩余字数统计
		 * 注意 最大字数只需要在放数字的节点哪里直接写好即可 如：<var class="word">200</var>
		 */
		function statInputNum(textArea, numItem) {
			var max = numItem.text();
			textArea[0].setAttribute("maxlength", max);
			curLength = textArea.val().length;
			numItem.text(max - curLength);
			textArea.on('input propertychange', function() {
				var _value = $(this).val().replace(/\n/gi, "");
				numItem.text(max - _value.length);
			});
		}

		function placeAtInput(result) {
			var contacts = result.extend.contacts;
			var conphonenum = "";
			//遍历数据
			$.each(contacts, function(index, item) {
				conphonenum = conphonenum + item.conphonenum + ",";
			});
			//去除conphonenum多余的
			conphonenum = conphonenum.substring(0, conphonenum.length - 1);
			$("#phoneNumber").attr("value", conphonenum);
		}

		//发送按公司查询的请求，返回数据
		function selectByConpany(opValue) {
			$.ajax({
				url : "${APP_PATH }/selectAllContactsByCompany",
				data : {
					"opValue" : opValue
				},
				type : "POST",
				dataType : "JSON",
				success : function(result) {
					//请求成功后把数据放到接收短信框
					placeAtInput(result);
				}
			});
		}

		$("#smsCpy_select").change(function() {
			var opValue = $(this).val();
			selectByConpany(opValue);
		});

		function sendMessages() {
			var phoneNumbers = $("#phoneNumber").val();
			var messageContents = $("#smsContent").val();

			$.ajax({
				url : "${APP_PATH }/sendMessages",
				type : "POST",
				data : {
					"phoneNumbers" : phoneNumbers,
					"smsContent" : messageContents
				},
				success : function(result) {
                     alert(result.msg);
				}
			});
		}
	</script>
</body>
</html>