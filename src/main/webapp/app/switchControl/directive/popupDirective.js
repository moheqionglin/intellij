/**
 * Created by zhouwanli on 27/08/2017.
 */
'use strict';
angular.module('FSwitchControl').directive('popupDirective', function () {
	return{
		templateUrl: 'app/switchControl/directive/popupDirective',
		restrict: 'E',
		replace: true,
		scope: {

		},
		link: function (scope, elem, attrs) {
			scope.shedData = [{id: 1, name: '1号大棚', selected: false},{id: 2, name: '2号大棚', selected: false},
				{id: 1, name: '3号大棚', selected: false},{id: 2, name: '4号大棚', selected: false},
				{id: 1, name: '5号大棚', selected: false},{id: 2, name: '6号大棚', selected: false},
				{id: 1, name: '7号大棚', selected: false},{id: 2, name: '10号大棚', selected: false},
				{id: 1, name: '11号大棚', selected: false},{id: 2, name: '12号大棚', selected: false},
				{id: 1, name: '12号大棚', selected: false},{id: 2, name: '14号大棚', selected: false},
				{id: 1, name: '15号大棚', selected: false},{id: 2, name: '16号大棚', selected: false},
				{id: 1, name: '17号大棚', selected: false},{id: 2, name: '18号大棚', selected: false},
				{id: 1, name: '19号大棚', selected: false},{id: 2, name: '20号大棚', selected: false},
			];
			$('.shed-btn').popup({
					inline     : true,
					position   : 'bottom center',
					popup : $('.shed-detail'),
					on    : 'click'
				});

		}
	}
})
