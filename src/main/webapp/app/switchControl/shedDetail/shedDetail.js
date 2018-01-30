/**
 * Created by zhouwanli on 26/08/2017.
 */
'use strict';
angular.module('FSwitchControl').controller('FSwitchControl.shedDetail', function ($scope, switchItems, $http) {
	$scope.items = switchItems;

	$scope.switch = function (item) {
		var status = item.active ? 'CLOSE' : 'OPEN';
		$http.get('../resources/switchController/switch/' + item.id + '/status/' +  status).then(function(data){
			item.active = !item.active;
		}, function(data){

		});

	}

	$scope.editSwitch = function(item){
		item.edit = true;
	}

	$scope.saveSwitch = function (item) {
		item.edit = false;
		$http.get('../resources/switchController/switch/' + item.id + '/rename/' + item.name)
			.then(function(){}, function(){});
	}


});
