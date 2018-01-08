'use strict';
angular.module('FCommon', ['ngRoute']).config(function ($routeProvider) {
	$routeProvider.when('/', {
		redirectTo: '/login'
	}).otherwise({
		redirectTo: '/login'
	});
});
