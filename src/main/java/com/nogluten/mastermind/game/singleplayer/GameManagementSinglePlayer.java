package com.nogluten.mastermind.game.singleplayer;

import java.util.HashMap;
import java.util.Map;

import com.nogluten.mastermind.game.Game;
import com.nogluten.mastermind.player.Player;

public class GameManagementSinglePlayer {
	
	private static GameManagementSinglePlayer instance;
	
	private static final Map<Long, Game> GAMES_CACHE = new HashMap<Long, Game>();
	
	private GameManagementSinglePlayer() { 	}
	
	public static GameManagementSinglePlayer getInstance() {
		if(instance == null){
			instance = new GameManagementSinglePlayer();
		}
		return instance;
	}
	
	public void createNewGame(Player player) {
		GameSinglePlayer game = new GameSinglePlayer(player);
		player.setGame(game);
		game.setGameSinglePlayerStatus(GameSinglePlayerStatus.PLAYING);
		GAMES_CACHE.put(game.getId(), game);
	}

}
