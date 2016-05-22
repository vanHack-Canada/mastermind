package com.nogluten.mastermind.game.multiplayer;

import com.nogluten.mastermind.game.GameStatus;

public enum GameMultiPlayerStatus implements GameStatus{
	
	WAITING_ANOTHER_PLAYER,
	PLAYER_ONE_PLAYING,
	PLAYER_TWO_PLAYING,
	WAITING_PLAYER_ONE_MOVE,
	WAITING_PLAYER_TWO_MOVE,
	PLAYER_ONE_WIN,
	PLAYER_TWO_WIN,
	PLAYER_ONE_LOSE,
	PLAYER_TWO_LOSE;

}
