/**
 * Created by zhouwanli on 26/08/2017.
 */
'use strict';
angular.module('FStatusCheck').controller('FStatusCheck.ctrl', function ($scope, $interval) {
	$scope.stop = function () {
		$scope.value = 50;

	}
	$scope.toggleDetail = false;

	$scope.toggleDetailBtn = function(){
		$scope.toggleDetail = !$scope.toggleDetail;
	}
});
