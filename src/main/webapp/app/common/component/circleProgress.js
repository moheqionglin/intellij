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

			var loadProgress = function(lv){
				var progressBar = 0;
				scope.value = scope.display = 0;
				var progress = $interval(function () {
					scope.display = progressBar + '%';
					scope.value = progressBar;
					progressBar += 5;
					if(progressBar === 100){
						progressBar = 0;
						$interval.cancel(progress);
						if(lv){
							setValue(lv);
						}
					}
				}, 100);
			}
			var loading = function(){
				var progressBar = 0;
				scope.value = scope.display = 0;
				var progress = $interval(function () {
					scope.display = progressBar + '%';
					scope.value = progressBar;
					progressBar += 5;
					if(progressBar === 100){
						progressBar = 0;
						$interval.cancel(progress);
						if(lv){
							setValue(lv);
						}
					}
				}, 100);
			}

			var setValue = function (lv) {
				scope.value = scope.display = 0;
				var setValueProgress = $interval(function () {
					scope.value += 5;
					if ((scope.value + 5) >= lv) {
						$interval.cancel(setValueProgress);
					}
					scope.display = lv + '分';
					console.log('===>' + scope.display);
				}, 100);
			}

			loadProgress(scope.lastValue);

		}
	};
})
