angular.module('SingleplayerModule', [ 'AppModule' ])

.controller('SingleplayerController', [ '$scope', '$cookieStore', function($scope, $cookieStore) {

	$scope.colorActual = '';
	$scope.currentLine = 0;
	$cookieStore.put('btn btn-primary', 'BLUE');
	$cookieStore.put('btn btn-success', 'GREEN');
	$cookieStore.put('btn btn-yellow', 'YELLOW');
	$cookieStore.put('btn btn-gray', 'GRAY');
	$cookieStore.put('btn btn-danger', 'RED');
	$cookieStore.put('btn btn-brow', 'BROW');
	$cookieStore.put('btn btn-warning', 'ORANGE');
	$cookieStore.put('btn btn-pink', 'PINK');
	$cookieStore.put('btn btn-default', '');

	$scope.game = {
		sessionId : $scope.userId,
		 modeGame : 'SINGLE_PLAYER',
		    guess : [
		          {column : [{button : 'btn btn-default', color : ''},{button : 'btn btn-default', color : ''},{button : 'btn btn-default', color : ''},{button : 'btn btn-default', color : ''},{button : 'btn btn-default', color : ''},{button : 'btn btn-default', color : ''},{button : 'btn btn-default', color : ''},{button : 'btn btn-default', color : ''},{button : 'btn btn-default', color : ''},{button : 'btn btn-default', color : ''}], disable : false},
		          {column : [{button : 'btn btn-default', color : ''},{button : 'btn btn-default', color : ''},{button : 'btn btn-default', color : ''},{button : 'btn btn-default', color : ''},{button : 'btn btn-default', color : ''},{button : 'btn btn-default', color : ''},{button : 'btn btn-default', color : ''},{button : 'btn btn-default', color : ''},{button : 'btn btn-default', color : ''},{button : 'btn btn-default', color : ''}], disable : true},
		          {column : [{button : 'btn btn-default', color : ''},{button : 'btn btn-default', color : ''},{button : 'btn btn-default', color : ''},{button : 'btn btn-default', color : ''},{button : 'btn btn-default', color : ''},{button : 'btn btn-default', color : ''},{button : 'btn btn-default', color : ''},{button : 'btn btn-default', color : ''},{button : 'btn btn-default', color : ''},{button : 'btn btn-default', color : ''}], disable : true},
		          {column : [{button : 'btn btn-default', color : ''},{button : 'btn btn-default', color : ''},{button : 'btn btn-default', color : ''},{button : 'btn btn-default', color : ''},{button : 'btn btn-default', color : ''},{button : 'btn btn-default', color : ''},{button : 'btn btn-default', color : ''},{button : 'btn btn-default', color : ''},{button : 'btn btn-default', color : ''},{button : 'btn btn-default', color : ''}], disable : true},
		          {column : [{button : 'btn btn-default', color : ''},{button : 'btn btn-default', color : ''},{button : 'btn btn-default', color : ''},{button : 'btn btn-default', color : ''},{button : 'btn btn-default', color : ''},{button : 'btn btn-default', color : ''},{button : 'btn btn-default', color : ''},{button : 'btn btn-default', color : ''},{button : 'btn btn-default', color : ''},{button : 'btn btn-default', color : ''}], disable : true},
		          {column : [{button : 'btn btn-default', color : ''},{button : 'btn btn-default', color : ''},{button : 'btn btn-default', color : ''},{button : 'btn btn-default', color : ''},{button : 'btn btn-default', color : ''},{button : 'btn btn-default', color : ''},{button : 'btn btn-default', color : ''},{button : 'btn btn-default', color : ''},{button : 'btn btn-default', color : ''},{button : 'btn btn-default', color : ''}], disable : true},
		          {column : [{button : 'btn btn-default', color : ''},{button : 'btn btn-default', color : ''},{button : 'btn btn-default', color : ''},{button : 'btn btn-default', color : ''},{button : 'btn btn-default', color : ''},{button : 'btn btn-default', color : ''},{button : 'btn btn-default', color : ''},{button : 'btn btn-default', color : ''},{button : 'btn btn-default', color : ''},{button : 'btn btn-default', color : ''}], disable : true},
		          {column : [{button : 'btn btn-default', color : ''},{button : 'btn btn-default', color : ''},{button : 'btn btn-default', color : ''},{button : 'btn btn-default', color : ''},{button : 'btn btn-default', color : ''},{button : 'btn btn-default', color : ''},{button : 'btn btn-default', color : ''},{button : 'btn btn-default', color : ''},{button : 'btn btn-default', color : ''},{button : 'btn btn-default', color : ''}], disable : true},
		          {column : [{button : 'btn btn-default', color : ''},{button : 'btn btn-default', color : ''},{button : 'btn btn-default', color : ''},{button : 'btn btn-default', color : ''},{button : 'btn btn-default', color : ''},{button : 'btn btn-default', color : ''},{button : 'btn btn-default', color : ''},{button : 'btn btn-default', color : ''},{button : 'btn btn-default', color : ''},{button : 'btn btn-default', color : ''}], disable : true},
		          {column : [{button : 'btn btn-default', color : ''},{button : 'btn btn-default', color : ''},{button : 'btn btn-default', color : ''},{button : 'btn btn-default', color : ''},{button : 'btn btn-default', color : ''},{button : 'btn btn-default', color : ''},{button : 'btn btn-default', color : ''},{button : 'btn btn-default', color : ''},{button : 'btn btn-default', color : ''},{button : 'btn btn-default', color : ''}], disable : true}
	          ]
	};

	$scope.getColorActual = function(line, column) {
		if($scope.colorActual === ''){
			alert('Select a color');
		}else{
			for (var i = 0; i < $scope.game.guess.length; i++) {
				if(i === line){
					$scope.game.guess[i].column[column].button = $scope.colorActual;
					$scope.game.guess[i].column[column].color  = $cookieStore.get($scope.colorActual);
				}

			}
		}
	}

	$scope.send = function() {
		var send = true;
		for (var i = 0; i < $scope.game.guess.length; i++) {
			if(i === $scope.currentLine){
				for (var c = 0; c <=7 ; c++) {
					if($scope.game.guess[i].column[c].color == ''){
						send = false;
						alert('Warning! Fill in all fields');
						break;
					}
				}
			}
		}
		if(send){
			$scope.game.guess[$scope.currentLine].disable = true;
			if($scope.currentLine <= 9){
				$scope.game.guess[++$scope.currentLine].disable = false;
			}
			console.log('call RESTFULL');
		}
	}

	$scope.isDisabled = function(line) {
		return $scope.game.guess[line].disable;
	}

	$scope.getColor = function(line, column) {
		var css = '';
		css = $scope.game.guess[line].column[column].button;
		$scope.currentLine = line;
		return css;
	}

	$scope.colors = [ {
		blue : 'btn btn-primary',
		green : 'btn btn-success',
		yellow : 'btn btn-yellow',
		gray : 'btn btn-gray',
		red : 'btn btn-danger',
		brow : 'btn btn-brow',
		orange : 'btn btn-warning',
		pink : 'btn btn-pink',
		default_ : 'btn btn-default'
	} ];

	$scope.infoColorActual = function(color) {
		$scope.colorActual = color;
	};

} ]);