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
			var progress = $interval(function () {
				scope.value += 5;
				if(scope.value === 100){
					scope.value = 0;
				}
				if(scope.lastValue){
					$interval.cancel(progress);
					scope.value = 0;
					var setValueProgress = $interval(function () {
						scope.value += 10;
						if (scope.value === scope.lastValue) {
							$interval.cancel(setValueProgress);
						}

					}, 100);

				}}, 100);
		}
	};
})
