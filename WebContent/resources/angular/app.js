angular
		.module('AppModule', [ 'ngRoute', 'ngCookies', 'SingleplayerModule' ])

		.controller(
				'AppController',
				[
						'$scope',
						'$location',
						'$cookies',
						'$cookieStore',
						function($scope, $location, $cookies, $cookieStore,
								WebStorage) {

							$scope.getSessionId = function() {
								return Math
										.floor((Math.random() * 10000000) + 5009);
							};

							$scope.showBtnSingleplayer = true;
							$cookieStore.put('userId', $scope.getSessionId());
							$scope.userId = $cookieStore.get('userId');
							$scope.colors = [ {} ];

						} ])

		.config([ '$routeProvider', function($routeProvider) {

			// OPTIONS
			$routeProvider.when('/option', {
				templateUrl : 'partials/option.html',
				controller : 'AppController'
			})

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