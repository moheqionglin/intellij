'use strict';
angular.module('FStatusCheck', ['ngRoute']).config(function ($routeProvider) {
	$routeProvider.when('/statusCheck', {
		templateUrl: 'app/statusCheck/statusCheck',
		controller: 'FStatusCheck.ctrl',
		data: {
			standalonePage: true
		}
	});
});
