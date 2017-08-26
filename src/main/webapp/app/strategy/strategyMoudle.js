'use strict';
angular.module('FStrategy', ['ngRoute']).config(function ($routeProvider) {
	$routeProvider.when('/strategy', {
		templateUrl: 'app/strategy/strategy',
		controller: 'FStrategy.ctrl',
		data: {
			standalonePage: true
		}
	});
});
