/**
 * Created by zhouwanli on 26/08/2017.
 */
'use strict';
angular.module('FStrategy').controller('FStrategy.ctrl', function ($scope, $location) {

	$scope.addStrategy = function () {
		$location.path('/strategyDetail/new');
	}
});