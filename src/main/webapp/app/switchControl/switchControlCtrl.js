/**
 * Created by zhouwanli on 26/08/2017.
 */
'use strict';
angular.module('FSwitchControl').controller('FSwitchControl.ctrl', function ($scope, $location, $http, $cookies) {
	$('#context2 .menu .item')
		.tab({
			context: 'parent'
		})
	;
	$scope.userid = $cookies.get('userid') || '04182642161821818175';
	$('.ui.modal.shed-modal').modal('attach events', '#context2 .select-shed-btn', 'show')
	$('.ui.modal.switch-modal').modal('attach events', '#context2 .select-switch-btn', 'show')
	$('.ui.basic.modal').modal('attach events', '.switch-btn', 'show')
	$scope.items = [];
	$scope.loading = true;
	$scope.error = false;
	$http.get('../resources/switchController/all/' + $scope.userid).then(function(data){
		$scope.items = data.data.items;
		$scope.loading = false;
		$scope.error = false;
	}, function(error){
		$scope.loading = false;
		$scope.error = true;
	});


	_.each($scope.items, function(item){
		item.typeDesc = item.type === 'SHED' ? '大棚' : '开关组';

	})

	$scope.toDetailPage = function(item){
		$location.path('/shedDetail/' + item.type + '/' + item.id);
	}
});
