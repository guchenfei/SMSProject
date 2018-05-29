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

	<script language="javascript" type="text/javascript"
		src="${APP_PATH }/static/My97DatePicker/WdatePicker.js"></script>
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
<div id="smsMass">
	<form>
		<div class="row">
			<div class="col-md-12">
				<div class="input-group">
					<span class="input-group-addon" id="basic-addon1">接收者：</span>
					<input type="text" class="form-control" id="phoneNumber"
						placeholder="请点击下方选择要发送的子公司..." aria-describedby="basic-addon1"
						autocomplete="off" />
				</div>
			</div>
		</div>
		<div>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</div>
		<div class="row">
			<div class="col-md-3">
				<div>
					<span class="label label-info">
						<font style="font-size: 13px;">选择短信接收公司：</font>
					</span>
				</div>
				<div>&nbsp;</div>
				<div>
					<select class="form-control" id="smsCpy_select"
						name="rececompanyid">
						<!--  所属公司提交公司ID即可 -->
						<option value="#">请选择短信接收公司</option>
						<option value="${admin.getCpyId()}">${admin.getCompany().getCompanyname()}</option>
					</select>
				</div>
			</div>
			<div class="col-md-3">
				<div>
					<span class="label label-info">
						<font style="font-size: 13px;">任务名称：</font>
					</span>
				</div>
				<div>&nbsp;</div>
				<div>
					<input type="text" class="form-control" id="taskName"
						placeholder="请输入该任务主题" aria-describedby="basic-addon1"
						autocomplete="off" name="topic" />
				</div>
			</div>
			<div class="col-md-3">
				<div>
					<span class="label label-info">
						<font style="font-size: 13px;">任务描述：</font>
					</span>
				</div>
				<div>&nbsp;</div>
				<div>
					<input type="text" class="form-control" id="taskDescribe"
						placeholder="请输入该任务描述（备注）" aria-describedby="basic-addon1"
						autocomplete="off" name="describetask" />
				</div>
			</div>
			<div class="col-md-3">
				<div>
					<span class="label label-info">
						<font style="font-size: 13px;">创建人：</font>
					</span>
				</div>
				<div>&nbsp;</div>
				<div>
					<input type="hidden" id="creatorId" value="${admin.getAdminId()}" name="creatorId"/>
					<p class="form-control-static" id="" name="">${admin.getUsername()}</p>
				</div>
			</div>
		</div>
		<div>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</div>
		<div class="row">
			<div class="col-md-3">
				<div>
					<span class="label label-info">
						<font style="font-size: 13px;">群发类型：</font>
					</span>
				</div>
				<div>&nbsp;</div>
				<div>
					<select class="form-control" id="masstype" name="masstype">
						<!-- value为0普通群发，1定时群发 -->
						<option value="#">请选择发送类型</option>
						<option value="0">立即发送</option>
						<option value="1">定时发送</option>
					</select>
				</div>
			</div>
			<div class="col-md-3">
				<div>
					<span class="label label-info">
						<font style="font-size: 13px;">节日模板：</font>
					</span>
				</div>
				<div>&nbsp;</div>
				<div>
					<select class="form-control" id="festivalTemp_select" name="">
					</select>
				</div>
			</div>
			<div class="col-md-3">
				<div>
					<span class="label label-info">
						<font style="font-size: 13px;">设定发送时间：</font>
					</span>
				</div>
				<div>&nbsp;</div>
				<div>
					<input type="text" id="reservetime"
						onclick="WdatePicker({startDate:'%y-%M-01 00:00:00',dateFmt:'yyyy-MM-dd HH:mm:ss',alwaysUseStartDate:true})"
						class="form-control" placeholder="点击预定发送时间(及时发送可为空)"
						autocomplete="off" name="reservetime" />
				</div>
			</div>
				<div class="col-md-3">
				<div>
				</div>
				<div>&nbsp;</div>
				<div>
					<input type="hidden" id="createtime" name="createtime" />
				</div>
			</div>
		</div>

		<div>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</div>
		<div class="row">
			<div class="col-md-6">
				<span class="label label-info">
					<font style="font-size: 13px;">短信内容：</font>
				</span>
				<div>&nbsp;&nbsp;&nbsp;</div>
                   <div style="position: absolute">
                           <img src="${APP_PATH }/static/images/sms.jpg" style="width: 500px;height: 700px;"/>
                           <div style="position: absolute;left: 10px;top: 110px;"><textarea class="form-control" rows="20" cols="140" placeholder="请输入短信内容..."
					id="smsContent" onkeyup="showcontent()" name="smscon">有过欢笑，有过泪水；有过争执，有过摩擦；有过精彩，有过失落；有过彷徨，有过喜悦。而这一切都将转瞬即逝，再见了我的大学时代！我会将这一切永远珍藏！在这离别之际，我想对帮助过我的老师，同学，家人说声：谢谢！感谢陪我走过的每一段特殊的路程，最后我真心得祝福你们，身体健康，工作顺利，财源广进，心想事成！【谷晨飞】</textarea></div>
					       <div style="position: absolute;left: 450px;top: 550px;">
					       <span><font id="word" style="color: red;">300</font> /300</span>
					       </div>
				   </div>
			</div>
			<div class="col-md-6">
				<span class="label label-info">
					<font style="font-size: 13px;">短信预览：</font>
				</span>
				<div>&nbsp;&nbsp;&nbsp;</div>
				<div style="position: absolute"><img src="${APP_PATH }/static/images/sms.jpg" style="width: 500px;height: 700px;"/><div style="position: absolute;left: 10px;top: 110px;"><textarea class="form-control" rows="20" cols="140" placeholder="请输入短信内容..."
					id="smsPreview" readonly="readonly"></textarea></div></div>
			</div>
		</div>
		<div>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</div>
		<div class="row" style="position: absolute">
			<div style="position: absolute;left: 180px;top: 700px;" class="col-md-6">
				<button onclick="sendMessages()" class="btn btn-info">确定任务</button>
			</div>
			<div style="position: absolute;left: 800px;top: 700px;" class="col-md-6">
				<button type="reset" class="btn btn-info">重置任务</button>
			</div>
		</div>
	</form>
	</div>

	<script type="text/javascript">
		//1,页面加载完成后，直接去发送ajax请求，要到分公司情况数据
		$(function() {
			var textArea = $("#smsContent");
			var word = $("#word");
			//去首页
			getFestivalTemp("#festivalTemp_select");
			statInputNum(textArea, word);
		});

		//查出所有的节日模板主题，并且显示到对应的下拉列表中
		function getFestivalTemp(ele) {
			//清空上次请求的下拉列表信息
			$(ele).empty();
			$.ajax({
				url : "${APP_PATH }/festivalTemp",
				types : "POST",
				success : function(result) {
					//思考下没有这个会产生响应信息吗？
					/* console.log(result); */
					//{"code":100,"msg":"处理成功！","extend":{"companies":[{"companyId":1,"companyname":"北京总部"},{"companyId":2,"companyname":"西安分公司"},{"companyId":3,"companyname":"上海分公司"},{"companyId":4,"companyname":"成都分公司"},{"companyId":5,"companyname":"南京分公司"}]}}
					//显示节日模板信息在下拉列表中
					$.each(result.extend.festivalTemps, function() {
						var optionEle = $("<option></option>").append(
								this.festivalName).attr("value",
								this.festivalId);
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

		//发送短信请求方法
		function sendMessages() {
			$.ajax({
				url : "${APP_PATH}/sendMessages",
				type : "POST",
				dateType : "JSON",
				data : $("#smsMass form").serialize()
				+ "&_method=PUT",
				async: false,
				success : function(result) {
					alert(result.extend.smsResult);
				}
			}); 
		}

		//发送按模板主题查询的请求，显示模板内容
		function selectFestivalTempCon(opValue) {
			$.ajax({
				url : "${APP_PATH }/selectFestivalTempCon",
				data : {
					"opValue" : opValue
				},
				type : "POST",
				dataType : "JSON",
				success : function(result) {
					//1，解析并显示模板内容于短信框
					$("#smsContent").val(result.extend.festivalTempCon);
				}
			});
		}

		$("#festivalTemp_select").change(function() {
			var opValue = $(this).val();
			selectFestivalTempCon(opValue);
		});
	</script>
</body>
</html>