/**
 * Created by zhouwanli on 26/08/2017.
 */
'use strict';
angular.module('FSwitchControl').controller('FSwitchControl.switchGroup', function ($scope, $location) {
	$('.ui.accordion').accordion();
	$scope.sheds = [];

	var k = 1;

	for(var i = 1 ; i <= 50; i ++){
		var s = {
			id: i,
			name: '大棚' + i,
			switch: []
		};
		console.log('---')
		for(var j = 1 ; j <= 20; j ++){
			s.switch.push({
				id: k,
				name: '开关' + k,
				desc: '开关' + k++,
				selected : false

			});
		}
		$scope.sheds.push(s);

	}

	$scope.selectSwitch = function (s) {
		s.selected = !s.selected

	}

	$scope.returnSwitchControl = function(){
		$location.path('/switchControl')
	}


});
