/**
 * Created by zhouwanli on 26/08/2017.
 */
'use strict';
angular.module('FStrategy').controller('FStrategy.detailCtrl', function ($scope, $rootScope, $location, $http, $route, $cookies) {
	$scope.error = false;
	$scope.success = false;
	$rootScope.loginPage = false;
	var userid = $cookies.get('userid') || '04182642161821818175';
	init();

	$scope.selectSwitchGroup = function (switchGroup) {
		switchGroup.selected = !switchGroup.selected;
		if(switchGroup.selected){
			$scope.strategyDetail.switchGroups.push(switchGroup);
		}else{
			var deleteIndex = -1;
			for(var i = 0; i < $scope.strategyDetail.switchGroups.length; i++){
				var sg = $scope.strategyDetail.switchGroups[i];
				if(sg.id === switchGroup.id){
					deleteIndex = i;
					break;
				}
			}
			$scope.strategyDetail.switchGroups.splice(deleteIndex, 1);
		}


	}


	$scope.enableSave = function(){
		return $scope.strategyDetail && $scope.strategyDetail.name && $scope.strategyDetail.switchGroups.length > 0 &&
				$scope.strategyDetail.desc && $scope.strategyDetail.strategyStartAt &&
				$scope.strategyDetail.continueMin && ($scope.strategyDetail.repeatGapMin >= 0);
	}

	$scope.returnStrategyListPage = function () {
		$location.path('/strategy');
	}

	$scope.save = function () {
		$http.post('../resources/strategy/save/' + userid, $scope.strategyDetail).then(function(data){
			$scope.error = false;
			$scope.success = true;
		}, function(){
			$scope.error = true;
			$scope.success = false;
		});

	}


	function init(){
		$('.ui.dimmer.modals.page.transition.hidden').html('');
		$('.strategy-name-modal').modal('attach events', '.strategy-name-btn', 'show');
		$('.strategy-desc-modal').modal('attach events', '.strategy-desc-btn', 'show');
		$('.strategy-repeat-modal').modal('attach events', '.strategy-repeat-btn', 'show');
		$('.strategy-switch-group-modal').modal('attach events', '.strategy-switch-group-btn', 'show')
		$('.ui.checkbox').checkbox();
		$('.strategy-continue-to-modal').modal('attach events', '.strategy-continue-to-btn', 'show');



		var id = $route.current.params.id
		if(id === 'new'){
			id = -1;
		}
		$http.get('../resources/strategy/detail/' + userid + '/' + id)
			.success(function (strategy) {
				console.log(strategy);
				$scope.strategyDetail = strategy.strategyDetail;
				$scope.allSwitchGroupd = strategy.switchGroups;
				if(id === -1){
					$scope.strategyDetail = {
						name: "新建策略",
						switchGroups: [],
						desc: "新建策略描述",
						strategyStartAt: "00:00",
						continueMin: 1,
						repeatGapMin: 0
					}
				}else{
					_.each($scope.allSwitchGroupd, function(allSg){
						_.each($scope.strategyDetail.switchGroups, function(sg){
							if(allSg.id === sg.id){
								allSg.selected = true;
							}
						})
					});
				}

				var fromCalendar = new datePicker();
				fromCalendar.init({
					'trigger': '.strategy-time-from-btn', /*按钮选择器，用于触发弹出插件*/
					'type': 'time',/*模式：date日期；datetime日期时间；time时间；ym年月；*/
					'initTime': $scope.strategyDetail.strategyStartAt, /*格式 12：31：34*/
					'onSubmit':function(){/*确认时触发事件*/
						$scope.strategyDetail.strategyStartAt = fromCalendar.value + ":00";
					},
					'onClose':function(){/*取消时触发事件*/
					}
				});
			})
			.error(function () {
				$location.path('/');
			});



	}

});
