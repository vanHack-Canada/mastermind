package com.nogluten.mastermind.game;

import com.nogluten.mastermind.player.Player;

public class Game {
	
	public enum Mode{
		SINGLE_PLAYER, MULTI_PLAYER
	}
	
	private Player playerOne;
	
	private Player playerTwo;
	
	private Mode mode;
	
	public Game(Mode mode) {
		this.mode = mode;
	}
	
	public void addPlayerOne(Player playerOne){
		this.playerOne = playerOne;
	}
	
	public void addPlayerTwo(Player playerTwo){
		this.playerTwo = playerTwo;
	}
	
	public Mode getMode() {
		return mode;
	}
	
	public Player getPlayerOne() {
		return playerOne;
	}
	
	public Player getPlayerTwo() {
		return playerTwo;
	}
}
