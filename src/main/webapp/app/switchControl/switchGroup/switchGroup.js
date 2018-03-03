/**
 * Created by zhouwanli on 26/08/2017.
 */
'use strict';
angular.module('FSwitchControl').controller('FSwitchControl.switchGroup', function ($scope, $window, $location, $cookies, $http, $rootScope) {
	$rootScope.loginPage = false;
	$('.ui.accordion').accordion();
	// $scope.userid = $cookies.get('userid') || '04182642161821818175';
	$scope.userid = $cookies.get('userid');
	$scope.sheds = [];
	$scope.totalSelected = 0;
	$scope.req = {};
	$http.get('../resources/switchController/all/switchs/' + $scope.userid).then(function (data) {
		$scope.sheds = data.data.items;
	}, function () {

	});


	$scope.selectSwitch = function (s) {
		s.selected = !s.selected
		if(s.selected){
			$scope.totalSelected += 1;
		}else{
			$scope.totalSelected -= 1;
		}

	}

	$scope.returnSwitchControl = function(){
		// $location.path('/switchControl');
		$window.location.href = '/p/#/switchControl';
		$window.location.reload();
	}


	$scope.save = function () {
		$scope.req.switchs = [];
		_.each($scope.sheds, function (shed) {
			_.each(shed.switchs, function(sw){
				if(sw.selected){
					$scope.req.switchs.push({id: sw.id});
				}
			});

		});
		$http.post('../resources/switchController/switchGroup/' + $scope.userid, $scope.req).then(function (data) {
			// $location.path('/switchControl');
			$window.location.href = '/p/#/switchControl';
			$window.location.reload();
		},function(){

		});
		console.log($scope.req);
	}


});
