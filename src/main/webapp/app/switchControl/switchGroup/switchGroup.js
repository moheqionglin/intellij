/**
 * Created by zhouwanli on 26/08/2017.
 */
'use strict';
angular.module('FSwitchControl').controller('FSwitchControl.switchGroup', function ($scope) {
	$('.ui.accordion').accordion();
	$scope.sheds = [];
	$scope.switchs = [];

	for(var i = 1 ; i <= 50; i ++){
		$scope.sheds.push({
			id: i,
			name: '大棚' + i,

		})
	}

	for(var i = 1 ; i <= 20; i ++){
		$scope.switchs.push({
			id: i,
			name: '开关' + i,
			desc: '开关' + i
		})
	}
});
