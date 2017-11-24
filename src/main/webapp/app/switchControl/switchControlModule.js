'use strict';
angular.module('FSwitchControl', ['ngRoute']).config(function ($routeProvider) {
	$routeProvider.when('/switchControl', {
		templateUrl: 'app/switchControl/switchControl',
		controller: 'FSwitchControl.ctrl',
		data: {
			standalonePage: true
		}
	})
	.when('/shedDetail', {
		templateUrl: 'app/switchControl/shedDetail/shedDetail',
		controller: 'FSwitchControl.shedDetail',
		data: {
			standalonePage: true
		}
	})
});
