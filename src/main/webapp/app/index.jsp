<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html ng-app="Flower">
<head>
	<!-- 检测浏览器 -->
	<title>flower</title>
	<link rel="icon" type="image/png" href="/images/favicon.png"/>

	<!-- build:cssLibIndex styles/external.css -->
	<link href="/components/semantic-ui/dist/semantic.css" rel="stylesheet">
	<!-- endbuild -->

	<!-- build:appCss app/styles/all.css -->
	<link href="../app/styles/main.css" rel="stylesheet" media="screen"/>
	<!-- endbuild -->

	<meta name="viewport" content="width=device-width, initial-scale=1"/>
	<meta name="description" content=""/>
	<meta name="keywords" content=""/>
</head>
<body ng-controller="Flower.appCtrl">

	<div class="app-content ui container">
		<div ng-view autoScroll="true"></div>
	</div>

	<!-- build:jsLibIndex lib/lib-all.js -->
	<script type="text/javascript" src="/bower_components/jquery/dist/jquery.min.js"></script>
	<script type="text/javascript" src="/bower_components/angular/angular.min.js"></script>
	<script type="text/javascript" src="/bower_components/angular-cookies/angular-cookies.js"></script>
	<script type="text/javascript" src="/bower_components/lodash/lodash.min.js"></script>
	<script type="text/javascript" src="/bower_components/angular-filter/dist/angular-filter.min.js"></script>
	<script type="text/javascript" src="/bower_components/angular-resource/angular-resource.js"></script>
	<script type="text/javascript" src="/bower_components/angular-route/angular-route.js"></script>
	<script type="text/javascript" src="/components/semantic-ui/dist/semantic.js"></script>
	<!-- endbuild -->

	<!-- build:appJs app/app-all.js -->
	<script type="text/javascript" src="/app/app.js"></script>
	<!-- endbuild -->
</body>
</html>
