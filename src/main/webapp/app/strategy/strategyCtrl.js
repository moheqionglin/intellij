/**
 * Created by zhouwanli on 26/08/2017.
 */
'use strict';
angular.module('FStrategy').controller('FStrategy.ctrl', function ($scope, $location, $rootScope, $http, $cookies) {
	$rootScope.loginPage = false;
	// var userid = $cookies.get('userid') || '04182642161821818175';
	var userid = $cookies.get('userid');
	$scope.items = [];
	$http.get('../resources/strategy/list/' + userid).then(function(data){
		$scope.items = data.data.strategyDetails;
	}, function(){});


	$scope.editSwitch = function(item){
		$http.get('../resources/strategy/' + item.id + '/status/' + item.enable).then(function(){

		}, function(){});
	}

});
