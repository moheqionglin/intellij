'use strict';
angular.module('FSwitchControl', ['ngRoute']).config(function ($routeProvider) {
	$routeProvider.when('/switchControl', {
		templateUrl: 'app/switchControl/switchControl',
		controller: 'FSwitchControl.ctrl',
		data: {
			standalonePage: true
		}
	}).when('/controlHistory', {
		templateUrl: 'app/switchControl/history/controlHistory',
		controller: 'FSwitchControl.controlHistory',
		data: {
			standalonePage: true
		}
	})
});
