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
			switchItems: ['$route', '$location', '$q', function ($route, $location, $q) {
				// return ProductService.getProductDetailsBySupplierId($route.current.params.name, $route.current.params.supplierId).then(function (product) {
				// 	return $q.resolve(product);
				// }, function () {
				// 	$location.path('/');
				// });
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
