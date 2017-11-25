/**
 * Created by zhouwanli on 26/08/2017.
 */
'use strict';
angular.module('FSwitchControl').controller('FSwitchControl.shedDetail', function ($scope) {
	$scope.items = [];
	for(var i = 1; i <= 20; i++){
		$scope.items.push({
			id: i,
			image: i % 4 == 0? '/app/images/switchControl/active.png' : '/app/images/switchControl/inactive.png',
			name: '开关' + i,
			shed: i,
			active: (i % 4 == 0),
			edit: false})
	}

	$scope.switch = function (item) {
		item.active = !item.active;
	}

	$scope.editSwitch = function(item){
		item.edit = true;
	}

	$scope.saveSwitch = function (item) {
		item.edit = false;
	}


});
