'use strict';
angular.module('FSwitchControl', ['ngRoute']).config(function ($routeProvider) {
	$routeProvider.when('/switchControl', {
		templateUrl: 'app/switchControl/switchControl',
		controller: 'FSwitchControl.ctrl',
		data: {
			standalonePage: true
		}
	})
	.when('/shedDetail/:type/:shedId', {
		templateUrl: 'app/switchControl/shedDetail/shedDetail',
		controller: 'FSwitchControl.shedDetail',
		data: {
			standalonePage: true
		},

		resolve: {
			switchItems: ['$location', '$http', '$route', '$q',
				function ($location, $http, $route, $q) {
					var type =  $route.current.params.type;
					var id = $route.current.params.shedId
					var def = $q.defer();
					$http.get('../resources/switchController/' + type + '/' + id)
						.success(function (data) {
							def.resolve(data.items);
						})
						.error(function () {
							$location.path('/');
						});
					return def.promise;
				}]
		}
	})
	.when('/switchGroup/:id', {
		templateUrl: 'app/switchControl/switchGroup/switchGroup',
		controller: 'FSwitchControl.switchGroup',
		data: {
			standalonePage: true
		}
	})

});
