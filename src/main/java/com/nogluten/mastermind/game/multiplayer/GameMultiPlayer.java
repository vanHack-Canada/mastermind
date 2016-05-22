package com.nogluten.mastermind.game.multiplayer;

import com.nogluten.mastermind.game.Game;
import com.nogluten.mastermind.game.GameMode;
import com.nogluten.mastermind.game.GameStatus;
import com.nogluten.mastermind.player.Player;

public class GameMultiPlayer implements Game {

	private Long id;
	
	private Player playerOne;
	
	private Player playerTwo;
	
	private GameMode mode;
	
	private GameMultiPlayerStatus gameStatus;
	
	public GameMultiPlayer() {
		this.id = System.currentTimeMillis();
		this.mode = GameMode.SINGLE_PLAYER;
	}

	@Override
	public Long getId() {
		return id;
	}
	
	@Override
	public GameMode getMode() {
		return mode;
	}
	
	public void addPlayerOne(Player playerOne){
		this.playerTwo = playerOne;
	}
	
	public void addPlayerTwo(Player playerTwo){
		this.playerTwo = playerTwo;
	}
	
	public Player getPlayerOne() {
		return playerOne;
	}
	
	public Player getPlayerTwo() {
		return playerTwo;
	}

	@Override
	public GameStatus getGameStatus() {
		return this.gameStatus;
	}

	public void setGameStatus(GameMultiPlayerStatus gameStatus) {
		this.gameStatus = gameStatus;
	}
}
