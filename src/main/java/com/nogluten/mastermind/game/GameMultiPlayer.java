package com.nogluten.mastermind.game;

import com.nogluten.mastermind.player.Player;

public class GameMultiPlayer implements Game{

	private Long id;
	
	private Player playerOne;
	
	private Player playerTwo;
	
	private GameMode mode;
	
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
	
	public void addPlayerOne(Player playerTwo){
		this.playerTwo = playerTwo;
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
	
}
