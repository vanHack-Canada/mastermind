angular.module('AppModule', [ 'ngRoute' ])

.controller('AppController',
		[ '$scope', '$location', function($scope, $location, WebStorage) {

			$scope.mastermind = "hello world";


		} ])

.config([ '$routeProvider', function($routeProvider) {

	// DEFAULT
	$routeProvider.otherwise({
		redirectTo : 'index.html'
	});

} ]);