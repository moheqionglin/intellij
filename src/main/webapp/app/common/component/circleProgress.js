/**
 * Created by zhouwanli on 26/08/2017.
 */
'use strict';
angular.module('FCommon').directive('circleProgress', function ($interval) {
	return {
		templateUrl: 'app/common/component/circleProgress',
		restrict: 'E',
		replace : true,
		scope: {
			lastValue: '='
		},
		controller: function () {

		},
		link: function (scope, tElem) {
			scope.value = 0;

			var setValue = function (lv) {

				var setValueProgress = $interval(function () {
					scope.display = scope.value + '分';
					scope.value += 10;
					if (scope.value === lv) {
						$interval.cancel(setValueProgress);
					}

				}, 100);
			}

			var progress = $interval(function () {
				scope.display = scope.value + '%';
				scope.value += 5;
				if(scope.value === 120){
					scope.value = 0;
					$interval.cancel(progress);
					setValue(90);
				}

				if(scope.lastValue){
					$interval.cancel(progress);
					setValue(scope.lastValue);
				}}, 100);
		}
	};
})
