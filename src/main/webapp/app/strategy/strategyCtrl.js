/**
 * Created by zhouwanli on 26/08/2017.
 */
'use strict';
angular.module('FStrategy').controller('FStrategy.ctrl', function ($scope, $location) {


	$scope.items = [];
	for(var i = 1; i <= 5; i++){
		$scope.items.push({
			id: i,
			name: '策略' + i,
			desc: '策略' + i,
			switchGroup: {
				id: i,
				name: '开关组1'
			}})
	}

});
