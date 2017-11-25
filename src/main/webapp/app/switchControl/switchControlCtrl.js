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
	$scope.items.push({
		id: 1,
		type: 'GROUP',
		image: '/app/images/switchControl/shed.jpg',
		name: '开关组' + 1,
		desc: '开关组' + 1})
	for(var i = 1; i <= 20; i++){
		$scope.items.push({
			id: i,
			type: 'SHED',
			image: '/app/images/switchControl/shed.jpg',
			name: '大棚' + i,
			desc: '大棚' + i})
	}

	_.each($scope.items, function(item){
		item.typeDesc = item.type === 'SHED' ? '大棚' : '开关组';

	})

	$scope.toDetailPage = function(item){
		$location.path('/shedDetail/' + item.type + '/' + item.id);
	}
});
