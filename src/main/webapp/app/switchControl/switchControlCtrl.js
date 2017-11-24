/**
 * Created by zhouwanli on 26/08/2017.
 */
'use strict';
angular.module('FSwitchControl').controller('FSwitchControl.ctrl', function ($scope, $location) {
	$('#context2 .menu .item')
		.tab({
			context: 'parent'
		})
	;
	$('.ui.modal.shed-modal').modal('attach events', '#context2 .select-shed-btn', 'show')
	$('.ui.modal.switch-modal').modal('attach events', '#context2 .select-switch-btn', 'show')
	$('.ui.basic.modal').modal('attach events', '.switch-btn', 'show')


	$scope.items = [];

	for(var i = 1; i <= 20; i++){
		$scope.items.push({image: '/app/images/switchControl/shed.jpg', name: '大棚' + i})
	}

	$scope.toDetailPage = function(){
		$location.path('/shedDetail');
	}
});
