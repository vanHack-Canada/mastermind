package com.nogluten.mastermind.game;

import com.nogluten.mastermind.player.Player;

public class GameSinglePlayer implements Game{
	
	private Long id;
	
	private Player player;

	private GameMode mode;

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

}
