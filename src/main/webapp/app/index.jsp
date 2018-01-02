<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html ng-app="Flower">
<head>
	<!-- 检测浏览器 -->
	<title>爱尚智能大棚</title>
	<link rel="icon" type="image/png" href="/images/favicon.png"/>

	<!-- build:cssLibIndex styles/external.css -->
	<link href="../components/semantic-ui/dist/semantic.min.css" rel="stylesheet">
	<!-- endbuild -->

	<link href="../app/styles/circle.css" rel="stylesheet" media="screen"/>
	<!-- build:appCss app/styles/all.css -->
	<%--<link href="../app/styles/main.css" rel="stylesheet" media="screen"/>--%>

	<!-- endbuild -->
	<style>
		.ui.menu.fixed{
			width: 100% !important;
		}
		body{
			background-color: rgba(241, 241, 241, 0.5);
		}

		.ui.menu.item .item{
			padding: 0.528571em 1.14285714em ;
			font-weight: 300;
			font-size: 11px !important;
		}
		.suimei-color{
			color: #40b77d !important;
		}
		a{
			color: #40b77d ;
		}
	</style>
	<script type="text/javascript">
		//在此拿到jsAPI权限验证配置所需要的信息
		var _config = <%= com.dingding.AuthHelper.getConfig(request) %>;
	</script>
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=0"/>
	<meta name="description" content=""/>
	<meta name="keywords" content=""/>
</head>
<body ng-controller="Flower.appCtrl">
	<div class="ui green three item inverted labeled icon bottom fixed menu container">
		<a href="#/statusCheck" class="item"><i class="treatment icon"></i> 监测 </a>
		<a href="#/switchControl" class="item"><i class="power icon"></i> 开关 </a>
		<a href="#/strategy" class="item"><i class="options icon"></i> 策略 </a>
	</div>
	<div align="center">
		<span>UserName:</span>
		<div id="userName" style="display:inline-block"></div>
	</div >
	<div align="center">
		<span>UserId:</span>
		<div id="userId" style="display:inline-block"></div>
	</div>
	<div align="center"><img id = "userImg" src="" /></div>
	<div class="app-content ui container" style="padding-bottom: 65px;">
		<div ng-view autoScroll="true"></div>
	</div>

	<!-- build:jsLibIndex lib/lib-all.js -->
	<script type="text/javascript" src="../bower_components/jquery/dist/jquery.min.js"></script>
	<script type="text/javascript" src="http://g.alicdn.com/ilw/ding/0.8.6/scripts/dingtalk.js"></script>
	<script type="text/javascript" src="../bower_components/angular/angular.min.js"></script>
	<script type="text/javascript" src="../bower_components/angular-cookies/angular-cookies.js"></script>
	<script type="text/javascript" src="../bower_components/lodash/lodash.min.js"></script>
	<script type="text/javascript" src="../bower_components/angular-filter/dist/angular-filter.min.js"></script>
	<script type="text/javascript" src="../bower_components/angular-resource/angular-resource.js"></script>
	<script type="text/javascript" src="../bower_components/angular-route/angular-route.js"></script>
	<script type="text/javascript" src="../components/semantic-ui/dist/semantic.min.js"></script>
	<script type="text/javascript" src="../components/icalender/datePicker.js"></script>

	<!-- endbuild -->

	<!-- build:appJs app/app-all.js -->
	<script type="text/javascript" src="../app/app.js"></script>
	<script type="text/javascript" src="../app/common/commonModule.js"></script>
	<script type="text/javascript" src="../app/common/commonCtrl.js"></script>
	<script type="text/javascript" src="../app/common/component/multipleSelectedDirective.js"></script>
	<script type="text/javascript" src="../app/common/component/circleProgress.js"></script>
	<script type="text/javascript" src="../app/statusCheck/statusCheckModule.js"></script>
	<script type="text/javascript" src="../app/statusCheck/statusCheckCtrl.js"></script>
	<script type="text/javascript" src="../app/strategy/strategyMoudle.js"></script>
	<script type="text/javascript" src="../app/strategy/strategyCtrl.js"></script>
	<script type="text/javascript" src="../app/switchControl/switchControlModule.js"></script>
	<script type="text/javascript" src="../app/switchControl/switchControlCtrl.js"></script>
	<script type="text/javascript" src="../app/switchControl/switchGroup/switchGroup.js"></script>

	<script type="text/javascript" src="../app/switchControl/directive/switchModalDirective.js"></script>
	<script type="text/javascript" src="../app/switchControl/shedDetail/shedDetail.js"></script>
	<script type="text/javascript" src="../app/strategy/detail/strategyDetailCtrl.js"></script>

	<!-- endbuild -->

	<script type="text/javascript">

//		$(function(){
			/**
			 * _config comes from server-side template. see views/index.jade
			 */
			dd.config({
				agentId : _config.agentid,
				corpId : _config.corpId,
				timeStamp : _config.timeStamp,
				nonceStr : _config.nonceStr,
				signature : _config.signature,
				jsApiList : [ 'runtime.info', 'biz.contact.choose',
					'device.notification.confirm', 'device.notification.alert',
					'device.notification.prompt', 'biz.ding.post',
					'biz.util.openLink' ]
			});


			dd.ready(function() {
//			dd.biz.navigation.setTitle({
//				title: '钉钉demo',
//				onSuccess: function(data) {
//				},
//				onFail: function(err) {
//					log.e(JSON.stringify(err));
//				}
//			});
//	 alert('dd.ready rocks!');

				dd.runtime.info({
					onSuccess : function(info) {
						logger.e('runtime info: ' + JSON.stringify(info));
					},
					onFail : function(err) {
						logger.e('fail: ' + JSON.stringify(err));
					}
				});
//			dd.ui.pullToRefresh.enable({
//				onSuccess: function() {
//				},
//				onFail: function() {
//				}
//			})

//			dd.biz.navigation.setMenu({
//				backgroundColor : "#ADD8E6",
//				items : [
//					{
//						id:"此处可以设置帮助",//字符串
//						// "iconId":"file",//字符串，图标命名
//						text:"帮助"
//					}
//					,
//					{
//						"id":"2",
//						"iconId":"photo",
//						"text":"我们"
//					}
//					,
//					{
//						"id":"3",
//						"iconId":"file",
//						"text":"你们"
//					}
//					,
//					{
//						"id":"4",
//						"iconId":"time",
//						"text":"他们"
//					}
//				],
//				onSuccess: function(data) {
//					alert(JSON.stringify(data));
//
//				},
//				onFail: function(err) {
//					alert(JSON.stringify(err));
//				}
//			});


				dd.runtime.permission.requestAuthCode({
					corpId : _config.corpId,
					onSuccess : function(info) {
						alert('authcode: ' + info.code);
						var contextPath = ' http://106.14.133.77:8888/';
						var url = contextPath + 'userinfo?code=' + info.code + '&corpid='
							+ _config.corpId;
						$("#userName").html(url);
						alert(url)
						$.ajax({
							url : url,
							type : 'GET',
							contentType: 'application/json;charset=utf-8',
							dataType: 'json',
							success : function(data, status, xhr) {
								alert(data);
								var info = JSON.parse(data);

								$("#userName").html(info.name);
								$("#userId").html(info.userid)

								// 图片
								if(info.avatar.length != 0){
									var img = document.getElementById("userImg");
									img.src = info.avatar;
									img.height = '100';
									img.width = '100';
								}

							},
							error : function(xhr, errorType, error) {
								console.log("yinyien:" + _config.corpId);
								alert(errorType + ', ' + error);
							}
						});

					},
					onFail : function(err) {
						alert('fail: ' + JSON.stringify(err));
					}
				});
			});

			dd.error(function(err) {
				alert('dd error: ' + JSON.stringify(err));
			});
//		})

	</script>
</body>
</html>
