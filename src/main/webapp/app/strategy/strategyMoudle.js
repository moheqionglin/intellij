'use strict';
angular.module('FStrategy', ['ngRoute']).config(function ($routeProvider) {
	$routeProvider.when('/strategy', {
		templateUrl: 'app/strategy/strategy',
		controller: 'FStrategy.ctrl',
		data: {
			standalonePage: true
		}
	}).when('/strategyDetail/:id', {
		templateUrl: 'app/strategy/detail/strategyDetail',
		controller: 'FStrategy.detailCtrl',
	});
});
