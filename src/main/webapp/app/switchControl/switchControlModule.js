'use strict';
angular.module('FSwitchControl', ['ngRoute']).config(function ($routeProvider) {
	$routeProvider.when('/switchControl', {
		templateUrl: 'app/switchControl/switchControl',
		controller: 'FSwitchControl.ctrl',
		data: {
			standalonePage: true
		}
	})
});
