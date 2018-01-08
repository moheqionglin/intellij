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
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=0"/>
	<meta name="description" content=""/>
	<meta name="keywords" content=""/>
</head>
<body ng-controller="Flower.appCtrl">
	<div ng-show = "showNav" class="ui green three item inverted labeled icon bottom fixed menu container">
		<a href="#/statusCheck" class="item"><i class="treatment icon"></i> 监测 </a>
		<a href="#/switchControl" class="item"><i class="power icon"></i> 开关 </a>
		<a href="#/strategy" class="item"><i class="options icon"></i> 策略 </a>
	</div>
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
	<script type="text/javascript" src="../app/login/loginModule.js"></script>
	<script type="text/javascript" src="../app/login/loginCtrl.js"></script>
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
</body>
</html>
