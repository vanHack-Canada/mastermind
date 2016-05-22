package com.nogluten.mastermind.game.singleplayer;

import com.nogluten.mastermind.game.Game;
import com.nogluten.mastermind.game.GameMode;
import com.nogluten.mastermind.player.Player;
import com.nogluten.mastermind.tip.Tip;

public class GameSinglePlayer implements Game {
	
	private Long id;
	
	private Player player;

	private GameMode mode;
	
	private Integer numberMoves = 0;
	
	private GameSinglePlayerStatus gameSinglePlayerStatus;
	
	private Tip tip;

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

	public GameSinglePlayerStatus getGameSinglePlayerStatus() {
		return gameSinglePlayerStatus;
	}

	public void setGameSinglePlayerStatus(GameSinglePlayerStatus gameSinglePlayerStatus) {
		this.gameSinglePlayerStatus = gameSinglePlayerStatus;
	}
	
	public void addOneMove(){
		numberMoves++;
	}
	
	public Integer getNumberMoves() {
		return numberMoves;
	}

	public Tip getTip() {
		return tip;
	}

	public void setTip(Tip tip) {
		this.tip = tip;
	}

}
