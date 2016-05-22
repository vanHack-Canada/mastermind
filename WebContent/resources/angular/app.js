angular.module('AppModule', [ 'ngRoute', 'SingleplayerModule' ])

.controller('AppController',
		[ '$scope', '$location', function($scope, $location, WebStorage) {

		} ])

.config([ '$routeProvider', function($routeProvider) {

	// SINGLEPLAYER
	$routeProvider.when('/singleplayer', {
		templateUrl : 'partials/singleplayer.html',
		controller : 'SingleplayerController'
	})

	// DEFAULT
	$routeProvider.otherwise({
		redirectTo : 'index.html'
	});

} ]);