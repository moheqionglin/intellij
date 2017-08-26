'use strict';
angular.module('FCommon', ['ngRoute']).config(function ($routeProvider) {
	$routeProvider.when('/', {
		redirectTo: '/statusCheck'
	}).otherwise({
		redirectTo: '/statusCheck'
	});
});
