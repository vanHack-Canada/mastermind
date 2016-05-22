package com.nogluten.mastermind.game.multiplayer;

import com.nogluten.mastermind.game.Game;
import com.nogluten.mastermind.game.GameMode;
import com.nogluten.mastermind.player.Player;
import com.nogluten.mastermind.tip.Tip;

public class GameMultiPlayer implements Game {

	private Long id;
	
	private Player playerOne;
	
	private Player playerTwo;
	
	private int numberMovesPlayerOne = 0;
	
	private int numberMovesPlayerTwo = 0;
	
	private GameMode mode;
	
	private GameMultiPlayerStatus gameMultiPlayerStatus;
	
	private Tip tipPlayerOne;
	
	private Tip tipPlayerTwo;
	
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
	
	public GameMultiPlayerStatus getGameMultiPlayerStatus() {
		return gameMultiPlayerStatus;
	}
	
	public void setGameMultiPlayerStatus(GameMultiPlayerStatus gameMultiPlayerStatus) {
		this.gameMultiPlayerStatus = gameMultiPlayerStatus;
	}
	
	public void addMovePlayerOne(){
		 numberMovesPlayerOne++;
	}
	
	public void addMovePlayerTwo(){
		 numberMovesPlayerTwo++;
	}
	
	public int getNumberMovesPlayerOne() {
		return numberMovesPlayerOne;
	}
	
	public int getNumberMovesPlayerTwo() {
		return numberMovesPlayerTwo;
	}

	public Tip getTipPlayerOne() {
		return tipPlayerOne;
	}

	public void setTipPlayerOne(Tip tipPlayerOne) {
		this.tipPlayerOne = tipPlayerOne;
	}

	public Tip getTipPlayerTwo() {
		return tipPlayerTwo;
	}

	public void setTipPlayerTwo(Tip tipPlayerTwo) {
		this.tipPlayerTwo = tipPlayerTwo;
	}
	
}
