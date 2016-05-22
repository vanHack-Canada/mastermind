package com.nogluten.mastermind.game.singleplayer;

import com.nogluten.mastermind.game.Game;
import com.nogluten.mastermind.game.GameMode;
import com.nogluten.mastermind.game.GameStatus;
import com.nogluten.mastermind.player.Player;

public class GameSinglePlayer implements Game {
	
	private Long id;
	
	private Player player;

	private GameMode mode;
	
	private GameSinglePlayerStatus gameStatus;

	public GameSinglePlayer(Player player) {
		this.player = player;
		this.id = System.currentTimeMillis();
		this.mode = GameMode.SINGLE_PLAYER;
	}

	@Override
	public Long getId() {
		return id;
	}

	@Override
	public GameMode getMode() {
		return this.mode;
	}
	
	public Player getPlayer() {
		return player;
	}

	public GameStatus getGameStatus() {
		return this.gameStatus;
	}
	
	public void setGameStatus(GameSinglePlayerStatus gameStatus) {
		this.gameStatus = gameStatus;
	}

}
