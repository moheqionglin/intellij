'use strict';
angular.module('FSLogin', ['ngRoute']).config(function ($routeProvider) {
	$routeProvider.when('/login', {
		templateUrl: 'app/login/login',
		controller: 'FSLoginControl.ctrl',
		data: {
			standalonePage: true
		}
	})
});
