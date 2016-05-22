angular.module('SingleplayerModule', [ 'AppModule' ])

.controller('SingleplayerController', [ '$scope', function($scope) {

	$scope.colorActual = '';

	$scope.colors = [ {
		blue : 'btn btn-primary',
		green : 'btn btn-success',
		yellow : 'btn btn-yellow',
		gray : 'btn btn-gray',
		red : 'btn btn-danger',
		brow : 'btn btn-brow',
		orange : 'btn btn-warning',
		pink : 'btn btn-pink'
	} ];

	$scope.infoColorActual = function(color) {
		$scope.colorActual = color;
		alert($scope.colorActual);
	};

} ]);