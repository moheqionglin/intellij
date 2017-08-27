'use strict';
angular.module('FStrategy', ['ngRoute']).config(function ($routeProvider) {
	$routeProvider.when('/strategy', {
		templateUrl: 'app/strategy/strategy',
		controller: 'FStrategy.ctrl',
		data: {
			standalonePage: true
		}
	}).when('/strategyDetail/:id', {
		templateUrl: 'app/strategy/detail/strategyDetail',
		controller: 'FStrategy.detailCtrl',
		resolve: {
			strategy: ['$route', '$http', '$q', '$location', function ($route, $http, $q, $location) {
				// var url = '../resources/orders/' + $route.current.params.id;
				// return $http.get(url).then(function(resp){
				// 	console.log(resp);
				// 	return $q.resolve(resp);
				// }, function(){
				// 	$location.path('/orders');
				// 	return $q.reject();
				// });
				return {
					id: 1,
					name: '策略-1',
					desc: '中午十二点打开左侧遮阳板1小时'
				};
			}]
		}
	});
});
