/**
 * Created by zhouwanli on 27/08/2017.
 */
'use strict';
angular.module('FStrategy').directive('strategyModalDirective', function () {
	return{
		templateUrl: 'app/strategy/directive/strategyModalDirective',
		restrict: 'E',
		replace: true,
		scope: {
			title: '@'
		},
		link: function (scope, elem) {
			scope.clickBtn = function () {
				$(elem).find('.ui.modal').modal({duration: 50})
					.modal('show')
				;
			}

		}
	}
})
