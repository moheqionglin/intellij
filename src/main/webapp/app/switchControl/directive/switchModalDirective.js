/**
 * Created by zhouwanli on 27/08/2017.
 */
'use strict';
angular.module('FSwitchControl').directive('switchModalDirective', function () {
	return{
		templateUrl: 'app/switchControl/directive/switchModalDirective',
		restrict: 'E',
		replace: true,
		scope: {

		},
		link: function (scope, elem, attrs) {
			scope.selectSwitch = function(){
				$('.ui.modal').modal({duration: 50})
					.modal('show')
				;
			}

		}
	}
})
