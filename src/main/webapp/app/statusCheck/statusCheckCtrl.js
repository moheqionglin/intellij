/**
 * Created by zhouwanli on 26/08/2017.
 */
'use strict';
angular.module('FStatusCheck').controller('FStatusCheck.ctrl', function ($scope, $rootScope, $interval, $cookies, $http) {
	$rootScope.loginPage = false;
	$scope.firstLoadPage = true;
	$scope.hideErrorDetail = true;
	//到这个页面100%有 userid， 否则会跳转到报错页面。
	$scope.userid = $cookies.get('userid') || '04182642161821818175';
	$scope.error = false;
	$scope.toggleDetail = false;



	//第一次进入页面显示 请点击"一键检测"
	//点击检测按钮以后， 每秒中Prograss bar 转动一次。直到 100% 停止转动， 一直到后台返回数据。
	//检测按钮点完以后不允许再点击


	var loadProgress = function(lv){
		var progressBar = 0;
		$scope.value = $scope.display = 0;
		var progress = $interval(function () {
			$scope.display = progressBar + '%';
			$scope.value = progressBar;
			progressBar += 5;
			if(progressBar === 100){
				progressBar = 0;
				$interval.cancel(progress);
				if(lv){
					setValue(lv);
				}
			}
		}, 100);
	}

	var setValue = function (lv) {
		$scope.display = lv + '分';
		$scope.value = lv;
		// var setValueProgress = $interval(function () {
		// 	$scope.value += 5;
		// 	if (($scope.value + 5) >= lv) {
		// 		$interval.cancel(setValueProgress);
		// 	}
		// 	$scope.display = lv + '分';
		// 	console.log('===>' + $scope.display);
		// }, 100);
	}

	$scope.toggleDetailBtn = function(){
		$scope.toggleDetail = !$scope.toggleDetail;
	}

	$scope.statusCheck = function () {
		$scope.error = false;
		$scope.firstLoadPage = false;
		var progressBar = 1;
		var progress = $interval(function () {
			$scope.display = progressBar + '%';
			$scope.value = progressBar;
			if(progressBar < 100){
				progressBar += 1;
			}
			$http.get('../resources/status/userid/' + $scope.userid).then(function(data){
				$interval.cancel(progress);
				console.log(data.data)
				setValue(data.data.percent * 100);
				$scope.errorDetail = data.data.statusDetails;
				var errorSwitchCountLocal = 0;
				_.each($scope.errorDetail, function(shed){
					errorSwitchCountLocal += shed.switchDetails.length;
					_.each(shed.switchDetails, function(ss){
						ss.errorInfo = ss.responseError ? '请求失败' : !ss.online ? '设备离线' : ss.breakdown ? '设备故障' : '未知错误';
					});
				})
				$scope.errorSwitchCount = errorSwitchCountLocal;
				$scope.hideErrorDetail = false;
				$scope.error = false;
			}, function(){
				$scope.error = true;
				$interval.cancel(progress);
			})
		}, 500);
	}
});
